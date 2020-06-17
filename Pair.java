public class Pair{
  public int row,col; 
  
  public Pair(int row, int col){
    this.row = row; 
    this.col = col;
  }
  public String toString(){
    return String.format("Row: %d,Col: %d", row, col); 
  }
  public boolean equals(Pair other){
    return this.row == other.row && this.col==other.col; 
  }
}