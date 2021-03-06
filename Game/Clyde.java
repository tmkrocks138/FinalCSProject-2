
import java.lang.*;
import java.util.*;

public class Clyde extends Ghost{

    public Clyde(Location start){
	super(start, 3);
    }
   public void startMove(){
      Location temp = new Location(current.getRow() - 3, current.getCol() );
    }
    
    public boolean tooClose(Location l){
	int x = l.getRow() + l.getCol();
	int y = current.getRow() + current.getCol();
	boolean z = Math.abs(x - y) <= 8;
	return z;
    }

    public void setAim(PacMan p){
	if(!tooClose(p.getPos())){
	    if (mode == 0){
		aim = p.getPos();
	    }
	    else if (mode == 1){
		aim = p.getOp();
	    }
	}
	else{
	    aim = p.getOp();
	}
	
    }

    
    public int setToPac(PacMan p){
	Location l = p.getPos();
	int a = l.getRow();
	int b = current.getRow();
	int c = l.getCol();
	int d = current.getCol();
	int r = Math.abs(a - b);
	int s = Math.abs(c - d);
	return r + s;
    }
    
    public int setToAim(Location l, Location loc){
      return l.dist(loc);
    }
}