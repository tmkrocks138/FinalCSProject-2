import java.lang.Math;

public class Location{

    private int row, col;

    public Location (int r, int c){
	row = r;
	col = c;
    }

    public int getRow(){
	return row;
    }
    public int getCol(){
	return col;
    }

    public int dist(Location other){
	return Math.abs(this.row - other.getRow()) + Math.abs(this.col - other.getCol());
    }


}
