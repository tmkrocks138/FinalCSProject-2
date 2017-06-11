//ADAPTED FROM MR. K'S MAZE FROM LAB 15

import java.util.*;
import java.io.*;

public class Maze{
    
    private Location home;
    private int maxRows, maxCols;
    private char[][] maze = new char[28][28];
    private Location[][] board = new Location[28][28];

    public Maze(String filename){
	ArrayList<char[]> lines = new ArrayList<char[]>();
	try{
	    Scanner in = new Scanner(new File(filename));
	    while(in.hasNext()){
		lines.add(in.nextLine().toCharArray());
	    }
	}catch(FileNotFoundException e){
	    System.out.println("File not found: "+filename);
	    System.exit(1);
	}
	maze = new char[lines.size()][];
	for(int i = 0; i < maze.length; i++){
	    maze[i]=lines.get(i);
	}
	for(int r=0; r<maze.length;r++){
	    for(int c=0; c<maze[r].length;c++){
		if(maze[r][c]=='#'){
		    Location input = new Location(r, c, false, true);
		    board[r][c] = input;
		}
		if(maze[r][c]==' '){
		    Location input = new Location(r, c, false, false);
		    board[r][c] = input;
		}
		if(maze[r][c]==' '){
		    Location input = new Location(r, c, false, false);
		    board[r][c] = input;
		    home = input;
		}
		if(maze[r][c]=='.'){
		    Location input = new Location(r, c, true, false);
		    Pellets pellet = new Pellets(input);
		    board[r][c] = input;
		}
		if(maze[r][c]=='*'){
		    Location input = new Location(r, c, true, false);
		    Pellets pellet = new SuperPellets(input);
		    board[r][c] = input;
		}
	
	    }
	}
	maxRows = maze.length;
	maxCols = maze[0].length;

    }

    public Location getHome(){
	return home;
    }
    public int getMaxRows(){
	return maxRows;
    }
    public int getMaxCols(){
	return maxCols;
    }
    public Location[][] getBoard(){
	return board;
    }

}
