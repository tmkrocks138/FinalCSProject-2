  
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
     
      public void moving(PacMan pac){
    Location l;
    for(int n = 0; n < 4; n++){
        if (n == 0){
          try{
      l = new Location(current.getRow() - 1, current.getCol());
          }
          catch(NullPointerException e){  
          l = null;
        }
        }
        else if (n == 1){
          try{
      l = new Location(current.getRow(), current.getCol() + 1);
              }
          catch(NullPointerException e){  
          l = null;
        }
        }
        else if (n == 2){
          try{
      l = new Location(current.getRow() + 1, current.getCol());
              }
          catch(NullPointerException e){  
          l = null;
        }
        }
        else{
try{
      l = new Location(current.getRow(), current.getCol() - 1);
              }
          catch(NullPointerException e){  
          l = null;
        }
      }

      line[n] = l;
         }
    int i = 0;
    int x = 0;
    if(line[0] != null){
        i = setToAim(aim, line[0]);
    }
    else if(line[1] != null){
        i = setToAim(aim, line[1]);
        x = 1;
    }
    else if(line[2] != null){
        i = setToAim(aim, line[2]);
        x = 2;
    }
    for(int n = x + 1; n < 4; n++){
        if(setToAim(aim, line[n]) < i){
      i = setToAim(aim, line[n]);
      x = n;
        }
    }
    current = line[x];
  
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