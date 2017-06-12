  
import java.util.*;
  
public abstract class Ghost{
  
    Location aim, current;
    int mode, speed, color;
    boolean alive;
    Location[] line;
      
    public Ghost(Location start, int c){
  color = c;//later
  speed = 1; //speed:1-3
  mode = 0;
  current = start;
  line = new Location[4];
    }
    public abstract void startMove();
     
    public abstract void setAim(PacMan p);
     
    public Location moving(PacMan pac){
  Location[] spaces = new Location[4];
  for(int n = 0; n < 4; n++){
    if (n == 0){
      if(current.getRow() - 1 > 0 && ! new Location(current.getRow() - 1, current.getCol()).isWall());
        spaces[0] = new Location(current.getRow() - 1, current.getCol());
    }
    if (n == 1){
      if(current.getCol() + 1 < 28 && ! new Location(current.getRow(), current.getCol() + 1).isWall());
        spaces[1] = new Location(current.getRow(), current.getCol() + 1);
    }
    if (n == 2){
      if(current.getRow() + 1 < 29 && ! new Location(current.getRow() + 1, current.getCol()).isWall());
        spaces[2] = new Location(current.getRow() + 1, current.getCol());
    }
    if (n == 3){
      if(current.getCol() - 1 > 0 && ! new Location(current.getRow(), current.getCol() - 1).isWall());
        spaces[3] = new Location(current.getRow(), current.getCol() - 1);
    }
  }
  Location min = spaces[0];
  for(Location tile: spaces){
    if (setToAim(tile, pac.getPos()) < setToAim(tile, pac.getPos())){
      min = tile;
    }
  }
  
  current = min;
  return current;
    }
  
    public abstract int setToPac(PacMan p);
  
    public abstract int setToAim(Location z, Location x);
  
    public boolean notWall(int num){
  Location temp;
  if(num== 0){
      temp = new Location(current.getRow() - 1, current.getCol());
      return !temp.isWall();
  }
  else if(num == 1){
      temp = new Location(current.getRow(), current.getCol() - 1);
      return !temp.isWall();
  }
  else if (num == 2){
      temp = new Location(current.getRow() + 1, current.getCol());
      return !temp.isWall();
  }
  else if (num == 3){
      temp = new Location(current.getRow(), current.getCol() + 1);
      return !temp.isWall();
  }
  return false;
    }
    public void setMode(int m){
  /*
    0 - normal
    1 - terrified
  */
  mode = m;
    }
      
    public boolean caughtPac(PacMan p){
  return (p.getPos().getRow() == this.getRow() && p.getPos().getCol() == this.getCol());
    }
  
    public int getRow(){
        try{
      return current.getRow();
        }
        catch(NullPointerException e){
      return -1;
        }
    }
    public int getCol(){
        try{
      return current.getRow();
        }
        catch(NullPointerException e){
      return -1;
        }
    }
  
    public Location getPos(){
  return current;
    }
  
      
}