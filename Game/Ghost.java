  
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
     
    public Location moving(PacMan pac, Location[][] b){
  Location[] spaces = new Location[4];
  for(int n = 0; n < 4; n++){
    if (n == 0){
      if(current.getRow() - 1 > 0 && !b[current.getRow() - 1][current.getCol()].isWall());
        spaces[0] = b[current.getRow() - 1][current.getCol()];
    }
    if (n == 1){
      if(current.getCol() + 1 < 29 && !b[current.getRow()][current.getCol() + 1].isWall());
        spaces[1] =b[current.getRow()][current.getCol() + 1];
    }
    if (n == 2){
      if(current.getRow() + 1 < 28 && !b[current.getRow() + 1][current.getCol()].isWall());
        spaces[2] = b[current.getRow() + 1][current.getCol()];
    }
    if (n == 3){
      if(current.getCol() - 1 > 0 && !b[current.getRow()][current.getCol() - 1].isWall());
        spaces[3] = b[current.getRow()][current.getCol()-1];
    }
  }
  int temp = 0;
  Location min;
  if (!(spaces[0].isWall())){
    min = spaces[temp];
  }
  else if (!spaces[1].isWall()){
    min = spaces[1];
    temp = 1;
  }
  else if (!spaces[2].isWall()){
      min = spaces[2];
      temp = 2;  
  }
  else{
    min = spaces[3];
    temp = 3;
  }
  for(int i = temp + 1; i < 4; i++){
    if (setToAim(spaces[i], pac.getPos()) < setToAim(min, pac.getPos())){
      min = spaces[i];
    }
  }
  line = spaces;
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
    
 /*   public void setBoard(Location[][] map){
      board = map;
    }
  */
      
}