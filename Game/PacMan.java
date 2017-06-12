public class PacMan{
    private Location current, start, opposite;
    private int lives, points;
    private char direction; //wasd
    private Location[][] board;

    public PacMan(Location s){
	start = s;
	current = s;
	lives = 3;
	points = 0;
	direction = 'a';
    }

    public char getDirection(){
	return direction;
    }

    public void changeDirection(char c){
	direction = c;
    }
    
    public void eat(Pellets p){
	points += p.getPoints();
	//if pellet is super it goes up 50
	p.eatMe();
    }

    public void move(char key){
      if(key == 'w' || key == 'W'){
        changeDirection('w');
        if(current.getRow() - 1 >= 0 && !board[current.getRow() - 1][current.getCol()].isWall()){
          current = board[current.getRow() - 1][current.getCol()];
          if (current.hasPellet()){
            eat(current.getPellet());
            current.setPellet(false);
          }   
        }
      }
      if(key == 'a' || key == 'A'){
        changeDirection('a');
        if(current.getCol() - 1 >= 0 && !board[current.getRow()][current.getCol() - 1].isWall()){
          current = board[current.getRow()][current.getCol() - 1];
          if (current.hasPellet()){
            eat(current.getPellet());
            current.setPellet(false);
          } 
        }
      }
      if(key == 's' || key == 'S'){
        changeDirection('s');
        if(current.getRow() + 1 < board.length && !board[current.getRow() + 1][current.getCol()].isWall()){
          current = board[current.getRow() + 1][current.getCol()];
          if (current.hasPellet()){
            eat(current.getPellet());
            current.setPellet(false);
          } 
        }
      }
      if(key == 'd' || key == 'D'){
        changeDirection('d');
        if(current.getCol() + 1 < board[0].length && !board[current.getRow()][current.getCol() + 1].isWall()){
          current = board[current.getRow()][current.getCol() + 1];
          if (current.hasPellet()){
            eat(current.getPellet());
            current.setPellet(false);
          } 
        }
      }
    }

    public Location getPos(){
	return current;
    }

    public Location getOp(){
	return opposite;
    }
    
    public void setBoard(Location[][] map){
      board = map;
    }
    
    public Location getCurrent(){
      return current;
    }
    
    public int getPoints(){
      return points;
    }

}