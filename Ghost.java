public abstract class Ghost{

    Location aim, current;
    int mode, speed, color;
    boolean alive;
    
    public Ghost(){
        color = 0;//later
	speed = 1 //speed:1-3
    }

    public abstract moving();
    
    public void setMode(int m){
	/*
	 0 - normal
	 1 - terrified
	 */
	mode = m;
    }
    

    

    
}
