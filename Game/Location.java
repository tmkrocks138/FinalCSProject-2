import java.lang.Math;
public class Location{

    private int row, col;
    private boolean hasPellet, isWall;

    public Location (int r, int c){
	row = r;
	col = c;
    }

    public Location (int r, int c, boolean pellet, boolean wall){
	row = r;
	col = c;
	hasPellet = pellet;
	isWall = wall;
    }

    public int getRow(){
	return row;
    }
    public int getCol(){
	return col;
    }
    public boolean isWall(){
	return isWall;
    }
    public boolean hasPellet(){
	return hasPellet;
    }

    public void setWall(boolean wall){
	isWall = wall;
    }
    public void setPellet(boolean pellet){
    	hasPellet = pellet;
    }


    public int dist(Location other){
	return Math.abs(this.row - other.getRow()) + Math.abs(this.col - other.getCol());
    }
	


}
