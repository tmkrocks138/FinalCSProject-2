Maze map;
PacMan pac;
Location[][] board;
int refresh = 0;
Ghost b, c, i, p;

void setup(){
    size(700, 700);
    background(0); 
    map = new Maze("data/data.txt");
    board = map.getBoard();
    pac = new PacMan(map.getHome());
    pac.setBoard(board);
    b = new Blinky(new Location(13, 14)); //red = 0
    c = new Clyde(new Location(14, 15));// orange = 3
    i = new Inky(new Location(13, 15)); // blue = 2
    p = new Pinky(new Location(14, 14)); //pink = 1
}

void draw(){
  if (refresh % 3 != 0){
    if (refresh == 30){
      b.startMove();
    } 
    if (refresh == 90){
      p.startMove();
    } 
    if (refresh == 150){
      i.startMove();
    } 
    if (refresh == 210){
      c.startMove();
    } 
    if (refresh > 60){
       b.moving(pac);
     }
     if (refresh > 120){
       p.moving(pac);
     }
     if (refresh > 180){
       i.moving(pac);
     }
     if (refresh > 240){
       c.moving(pac);
     }
  }
  if(keyPressed){
    pac.move(key);
  }
}