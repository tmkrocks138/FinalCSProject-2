public class Frontier{
    //Ideas from lab 15 - Maze but parts are changed
    public Location ary;
    private int size;
    

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

