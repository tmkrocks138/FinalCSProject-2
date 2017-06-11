public class PacMan{
    private Location current, start, opposite;
    private int lives, points;
    private char direction; //wasd

    public PacMan(Location s){
	start = s;
	current = s;
	lives = 3;
	points = 0;
	direction = 'a';
    }

    public void eat(Pellets p){
	points += 10;
	//if pellet is super it goes up 50
	p.eatMe();
    }

    public void move(){
	//change current location
	//change direction?
    }

    public Location getPos(){
	return current;
    }

    public Location getOp(){
	return opposite;
    }

}