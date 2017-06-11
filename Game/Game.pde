
void setup(){
    size(700, 700);
    background(0); 
    Maze map = new Maze("data/data.txt");
    PacMan pac = new PacMan(map.getHome());
    pac.setBoard(map);
}

void draw(){
  if(keyPressed){
    pac.move(key);
  }
}
