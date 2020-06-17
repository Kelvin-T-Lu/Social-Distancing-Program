public class RecursivePropagation{
  
  /** A recusrive method that checks if a path is possible to get to exit */ 
  public static boolean recursiveIsEffective(Block area, int row, int col){
     
    area.setStart(row,col);
    //Base Case 
    if(area.isExit(row,col)){ return false; }
    
    //boolean flag = true; 
    
    //Movements
    if(!area.isVisited(row-1,col) && area.isValid(row-1,col)){
      area.moveUp(); 
      if(row > area.getCurrentRow()){
        if(!recursiveIsEffective(area, row-1, col)){
          return false; 
        }
        else{
          area.moveDown();
        }
      }
    }
    if(!area.isVisited(row,col+1)&& area.isValid(row,col+1)){
      area.moveRight(); 
      if(col < area.getCurrentCol()){
        if(!recursiveIsEffective(area, row, col + 1)){
          return false;
        }
        else{ 
          area.moveLeft();
        }
      }
    }
    
    if(!area.isVisited(row+1,col)&& area.isValid(row+1,col)){
      area.moveDown();
      if(row< area.getCurrentRow()){
        if(!recursiveIsEffective(area, row + 1, col)){
          return false; 
        }
        else{
          area.moveUp(); 
        } 
      }
    }
    if(!area.isVisited(row,col-1) && area.isValid(row, col-1)){
      area.moveLeft();
      if(col < area.getCurrentCol()){
        if(!recursiveIsEffective(area, row, col - 1)){
          return false; 
        }
        area.moveRight(); 
        
      }
    }
    return true; 
    
  }
}