public class Pellets{

    private Location tile;
    private int row;
    private int col;
    private boolean eaten;
    private int points;

    public Pellets(Location place){
	tile = place;
	row = place.getRow();
	col = place.getCol();
	eaten = false;
	points = 10;
    }

    public int getRow(){
	return row;
    }
    public int getCol(){
	return col;
    }
    public int getPoints(){
	return points;
    }
    public boolean isEaten(){
	return eaten;
    }
    public void setPoints(int value){
	points = value;
    }

    public void eatMe(){
	eaten = true;
    	points = 0;
    } 

}
