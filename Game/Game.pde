Maze map;
PacMan pac;
Location[][] board;

void setup(){
    size(700, 700);
    background(0); 
    map = new Maze("data/data.txt");
    board = map.getBoard();
    pac = new PacMan(map.getHome());
    pac.setBoard(board);
}

void draw(){
  if(keyPressed){
    pac.move(key);
  }
}