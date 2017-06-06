public class Frontier{
    //Copied from lab 15 - Maze
    MyHeap line;
    int size;
    

    public Frontier(){
	this(true);
    }
    public FrontierPriorityQueue(boolean astar){
	line = new MyHeap(astar);
	size = 0;
    }
    
    public void add(Location l){
	size++;
	line.add(l);
    }

    public boolean hasNext(){
        return line.getSize() > 0;
    }
    
    public Location next(){
	if (hasNext()){
	    size--;
	    return line.remove();
	}
	else{
	    return null;
	}
    }

    public int getSize(){
	return size;
    }
    
}

