
import java.lang.*;
import java.util.*;

public class Blinky extends Ghost{

    private int toPac;

    public Blinky(Location start){
	super(start);
    }
    
    public void setAim(PacMan p){
	if (mode == 0){
	    aim = p.getPos();
	}
	else if (mode == 1){
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

    
    
}

