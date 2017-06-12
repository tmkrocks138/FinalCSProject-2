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
    
    b = new Blinky(new Location(12, 13)); //red = 0
    c = new Clyde(new Location(13, 13));// orange = 3
    i = new Inky(new Location(15, 13)); // blue = 2
    p = new Pinky(new Location(14, 13)); //pink = 1
    
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
    
    frameRate(30);
    
    
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
      image(blinkyImage, b.getPos().getCol() * 25, b.getPos().getRow() * 25, 25, 25);
    } 
    if (refresh == 90){
      p.startMove();
      image(pinkyImage, p.getPos().getCol() * 25, p.getPos().getRow() * 25, 25, 25);
    } 
    if (refresh == 150){
      i.startMove();
      image(inkyImage, i.getPos().getCol() * 25, i.getPos().getRow() * 25, 27, 27);
    } 
    if (refresh == 210){
      c.startMove();
      image(clydeImage, c.getPos().getCol() * 25, c.getPos().getRow() * 25, 25, 25);
    } 
    if (refresh > 60){
       b.moving(pac);
       println(b.getPos().getCol() + " " + b.getPos().getRow());
       image(blinkyImage, b.getPos().getCol() * 25, b.getPos().getRow() * 25, 25, 25);
     }
     if (refresh > 120){
       p.moving(pac);
       image(pinkyImage, p.getPos().getCol() * 25, p.getPos().getRow() * 25, 25, 25);
     }
     if (refresh > 180){
       i.moving(pac);
       image(inkyImage, i.getPos().getCol() * 25, i.getPos().getRow() * 25, 27, 27);
     }
     if (refresh > 240){
       c.moving(pac);
       image(clydeImage, c.getPos().getCol() * 25, c.getPos().getRow() * 25, 25, 25);
     }
  }
  if(keyPressed){
    fill(0, 0, 0);
    rect(pac.getPos().getCol() * 25, pac.getPos().getRow() * 25, 25, 25);  
    pac.move(key);
    image(pacImage, pac.getPos().getCol() * 25, pac.getPos().getRow() * 25, 25, 25);
    //println ("Score: " + pac.getPoints());
  }
  refresh++;
}