public class Inky extends Ghost{

    public Inky(Location start){
	super(start);
    }

    public void setAim(PacMan p){
	Location x;
	if (mode == 0){
	    x = getBetween(this.getPos(), p.getPos());
	}
	else{
	    x = getBetween(this.getPos(), p.getOp());
	}
	aim = x;
    }
    
    public Location getBetween(Location a, Location b){
	int r = Math.abs(a.getRow() - b.getRow()) / 2;
	int c = Math.abs(a.getCol() - b.getCol()) / 2;
	if (a.getRow() > b.getRow()){
	    r += b.getRow();
	}
	else{
	    r+= a.getRow();
	}
	if (a.getCol() > b.getCol()){
	    r += b.getCol();
	}
	else{
	    r+= a.getCol();
	}
	Location x = new Location(r, c);
	return x;
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
    public int setToPac(PacMan p, Location loc){
	Location l = p.getPos();
	int a = l.getRow();
	int b = loc.getRow();
	int c = l.getCol();
	int d = loc.getCol();
	int r = Math.abs(a - b);
	int s = Math.abs(c - d);
	return r + s;
    }

    
}
