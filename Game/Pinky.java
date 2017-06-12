
import java.lang.*;
import java.util.*;

public class Pinky extends Ghost{

    public Pinky(Location start){
	super(start, 1);
    }
    
   public void startMove(){
      Location temp = new Location(current.getRow() - 3, current.getCol() );
    }
    
    
    public void setAim(PacMan p){
	Location x=null;
	if (mode == 0){
	    x = findSpot(p.getPos(), p.getDirection());
	   
	}
	else if (mode == 1){
	    x = findSpot(p.getOp(), p.getDirection());
	}
	aim = x;
	
    }

    public Location findSpot(Location l, char dir){
	Location z = null;
	int r = l.getRow();
	int c = l.getCol();
	try{
	    if (dir == 'a'){
		z = new Location(r, c - 2);
	    }
	    else if (dir == 's'){
		z = new Location(r - 2, c);
	    }
	    else if (dir == 'd'){
		z = new Location(r, c + 2);
	    }
	    else if (dir == 'w'){
		z = new Location (r - 4, c - 4);
	    }
	}
	catch(IndexOutOfBoundsException e){
	    z = l;
	}
	return z;
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
      try{
	int a = l.getRow();
	int b = loc.getRow();
	int c = l.getCol();
	int d = loc.getCol();
	int r = Math.abs(a - b);
	int s = Math.abs(c - d);
	return r + s;
      }
      catch (NullPointerException e){
      return -1;
      }
    }
}