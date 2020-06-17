import java.util.*; 
public class Propagation{
  //private static ArrayList<Pair> storage = new ArrayList<Pair>(); 
  private static Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();
  public static boolean isEffective(Block area, int startRow, int startCol){
    stack = new Stack<ArrayList<Integer>>(); 
    if(!area.isEntry(startRow,startCol)){ return false; }
    area.setStart(startRow, startCol); 
    int currRow = startRow, currCol = startCol;
   
    ArrayList<Integer> startTemp = new ArrayList<Integer>(); 
    startTemp.add(startRow);
    startTemp.add(startCol);
    stack.push(startTemp);
    //int counter = 0; 
    while(!area.isExit(currRow,currCol) ){
      currRow = stack.peek().get(0);
      currCol = stack.peek().get(1);
      area.setCurrentRow(currRow);
      area.setCurrentCol(currCol);
      //System.out.println("Start storage: " + storage);
      System.out.printf("Current Row: %d Current Col: %d\n", currRow, currCol);
      //counter++;
      ArrayList<Integer> temp = new ArrayList<Integer>(); 
//Movement
      if(!area.isVisited(currRow-1,currCol) && area.isFree(currRow-1, currCol)){
        area.moveUp();
        
        //if(currRow > area.getCurrentRow()){
          currRow = area.getCurrentRow();        
          temp.add(currRow);
          temp.add(currCol);
     
          stack.push(temp); 
          continue;
        //}
      }
      
      if(!area.isVisited(currRow, currCol+1)&&(area.isFree(currRow, currCol+1))){
        area.moveRight();
        //if(currCol < area.getCurrentCol()){
          currCol = area.getCurrentCol();
          
          temp.add(currRow);
          temp.add(currCol);
     
          stack.push(temp);
          continue; 
        //}
      }
      
      if(!area.isVisited(currRow+1, currCol) && area.isFree(currRow+1, currCol)){
        area.moveDown();
        //if(currRow < area.getCurrentRow()){
          currRow = area.getCurrentRow();
          
          temp.add(currRow);
          temp.add(currCol);
          
          stack.push(temp);continue; 
        //}
      }
      
      if(!area.isVisited(currRow, currCol-1)&&(area.isFree(currRow, currCol-1))){
        area.moveLeft();
        //if(currCol < area.getCurrentCol()){
          currCol = area.getCurrentCol();
          temp.add(currRow);
          temp.add(currCol);
          
          stack.push(temp);
          continue; 
        //}
      }
      

      
      //Backtrace
      
      System.out.printf("Backtrace Storage Values: Row: %d, Col: %d\n", currRow, currCol);
      area.getGrid()[currRow][currCol].setVisited(true);
      stack.pop();
      
      
      
      if(stack.isEmpty()){ return true; }   
    
    } 
      
    return false; 
  }
  
  public static Stack<ArrayList<Integer>> pathCalc(Block area, int startRow, int startCol){
    if(isEffective(area, startRow, startCol)){
      return null;
    }
    return stack; 
  }
}