public class PacMan{
    Location current, start, opposite;
    int lives, points;
    char direction; //wasd

    public PacMan(Location s){
	start = s;
	current = s;
	live = 3;
	points = 0;
	direction = 'a';
    }

    public void eat(Pellet p){
	points += 10;
	//if pellet is super it goes up 50
	p.eatMe();
    }

    public void move(){
	//change current location
	//change direction?
    }



}
