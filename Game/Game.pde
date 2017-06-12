Maze map;
PacMan pac;
Location[][] board;
int refresh = 0;
Ghost b, c, i, p;
PImage pacImage;
PImage pinkyImage;
PImage clydeImage;
PImage blinkyImage;
PImage inkyImage;

void setup(){
    size(700, 725);
    background(0); 
    map = new Maze("data/data.txt");
    board = map.getBoard();
    pac = new PacMan(map.getHome());
    pac.setBoard(board);
    
     readMaze();
    
    b = new Blinky(new Location(13, 14)); //red = 0
    c = new Clyde(new Location(14, 15));// orange = 3
    i = new Inky(new Location(13, 15)); // blue = 2
    p = new Pinky(new Location(14, 14)); //pink = 1
    
    pacImage = loadImage("pacman.png");
    pinkyImage = loadImage("pinky.png");
    clydeImage = loadImage("clyde.png");
    blinkyImage = loadImage("blinky.png");
    inkyImage = loadImage("inky.png");
    
    image(pacImage, 14 * 25, 16 * 25, 25, 25);
    image(pinkyImage, 14 * 25, 13 * 25, 25, 25);
    image(blinkyImage, 12 * 25, 13 * 25, 25, 25);
    image(clydeImage, 13 * 25, 13 * 25, 25, 25);
    image(inkyImage, 15 * 25, 13 * 25, 27, 27);
    
    
}

void readMaze(){
  for(Location[] line: board){
    for(Location tile: line){
      //println(tile.getRow() + " " + tile.getCol());
      if(tile.isWall()){
        fill(0, 0, 255);
        rect(tile.getCol() * 25, tile.getRow() * 25, 25, 25);
      }
      else{
        fill(0, 0, 0);
        rect(tile.getCol() * 25, tile.getRow() * 25, 25, 25);
        if(tile.hasPellet()){
          if(tile.getPellet().getPoints() == 10){
            fill(255, 255, 0);
            ellipse((tile.getCol() * 25) + 12, (tile.getRow() * 25) + 12, 7, 7);
          }
          else if (tile.getPellet().getPoints() == 50){
            fill(255,218,185);
            ellipse((tile.getCol() * 25) + 12, (tile.getRow() * 25) + 12, 17, 17);
          }
        }
      }
    }
  }
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