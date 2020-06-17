public class Block{
   
  //**************** Instance variables **********************
  /** Layout of the block */ 
  private Cell[][] grid; 
  /** @return Return the board's grid */ 
  public Cell[][] getGrid(){ return this.grid; }
  /** @param grid Sets the grid of the board */ 
  public void setGrid(Cell[][] grid){ this.grid = grid; } 
  
  /** Current row and col of individual */ 
  private int currentRow=-1, currentCol = -1;
  /** @return Returns the current row of a individual */ 
  public int getCurrentRow(){ return this.currentRow; }
  /** @return Returns the current col of a individual */ 
  public int getCurrentCol(){ return this.currentCol; }
  /** @param row Sets the current row of a individual*/ 
  public void setCurrentRow(int row){ this.currentRow = row; }
  /** @param col Sets the current col of a individual */ 
  public void setCurrentCol(int col){ this.currentCol = col; }
  /** Shows the start of individual */ 
  private int startRow = -1, startCol = -1; 
  /** @return Returns the starting Row of an individual */ 
  public int getStartRow(){ return this.startRow; }
  /** @return Returns the starting Column of an individual */ 
  public int getStartCol() { return this.startCol; }
  /** @param row Sets the starting row of an individual */ 
  public void setStartRow(int row){ this.startRow = row; }
  /** @param col Sets the starting col of an indiviual */ 
  public void setStartCol(int col){ this.startCol = col; }
  /** Sets the starting coordinates */
  public void setStart(int row, int col){
    if(isValid(row,col)&&getStatus(row,col)==0 && (isEntry(row,col))){
      setStartRow(row);
      setStartCol(col);
      setCurrentRow(row);
      setCurrentCol(col);
    }
       }
  
  //**************** Constructors ******************************
  public Block(Cell[][] grid){
    setGrid(grid); 
  }
  
  public boolean isValid(int row, int col){
    if(row < 0 || row > grid.length-1) { return false; }
    if(col < 0 || col > grid[0].length - 1){ return false; }
    
    return true; 
  }
  
  //***************** Status methods ************************
  /** @return Returns the status of a specified cell */ 
  public int getStatus(int row, int col){
    if(isValid(row, col))
      return grid[row][col].getStatus();
    return -1; 
  }
  /** @return Returns if the cell has been visited */ 
  public boolean isVisited(int row, int col){
    if(isValid(row,col)){
      return grid[row][col].getVisited(); 
    }
    return false; 
  }
  /** @return Return if the specified cell is an entry cell */
  public boolean isEntry(int row, int col){
    if(getStatus(row,col) == 1) { return false; }
    return (col == 0);
  }
  /** @return Return if the specified cell is an exit cell */ 
  public boolean isExit(int row, int col){
    if(getStatus(row,col)==1){ return false; }
      return (col == grid[0].length - 1);
  }
  /** @return Return if a specified cell is free to move in */ 
  public boolean isFree(int row, int col){
    if(isValid(row,col) && getStatus(row,col)==0)
       return true; 
    return false; 
  }
  
  //*****************Movement methods *******************
  
  /** Moves an individual left if possible */ 
  public void moveLeft(){
    if(isFree(currentRow,currentCol-1)){
      grid[currentRow][currentCol].setVisited(true);
      currentCol--; 
    }
  }
  /** Moves an individual right if possible */
  public void moveRight(){
    if(isFree(currentRow,currentCol+1)){
      grid[currentRow][currentCol].setVisited(true);
      currentCol++; 
    }
  }
  /** Moves an individual up if possible */
  public void moveUp(){
    if(isFree(currentRow-1,currentCol)){
      grid[currentRow][currentCol].setVisited(true);
      currentRow--; 
    }
  }
  /** Moves an individual down if possible */
  public void moveDown(){
    if(isFree(currentRow+1,currentCol)){
      grid[currentRow][currentCol].setVisited(true);
      currentRow++; 
    }
  }
  
  public void displayGrid(){ 
    for(Cell[] i: getGrid()){
      for(Cell j: i){
        System.out.printf("%d ", j.getStatus());
      }
      System.out.println();
    }
  }
  public void displayVisit(){ 
    for(Cell[] i: getGrid()){
      for(Cell j: i){
        System.out.printf("%b ", j.getVisited());
      }
      System.out.println();
    }
  }
  
  
}
