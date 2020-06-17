public class Cell{
  /** Status of the current cell, 0 == Clear, 1 == Marked) */ 
  private int status; 
  /** Returns whether the cell has been visited */ 
  private boolean visited; 
  
  /** @return Returns the status of the current cell, 0 == Clear, 1 == Marked)*/ 
  public int getStatus(){ return status; }
  /** @param status Sets the status of the current cell, 0 == Clear, 1 == Marked)*/ 
  public void setStatus(int status){ this.status = status; }
  
  /** @return Returns whether the cell is visited */
  public boolean getVisited(){ return this.visited; }
  /** @param visited Sets the cell visitation status */  
  public void setVisited(boolean visited){ this.visited = visited; }
  
  public Cell(int status, boolean visited){
    this.status = status; 
    this.visited = visited; 
  }
  
  public Cell(int status){
    this(status,false);
  }
}