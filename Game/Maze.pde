//ADAPTED FROM MR. K'S MAZE FROM LAB 15

import java.util.*;
import java.io.*;

public class Maze{
    
    private Location home;
    private int maxRows, maxCols;
    private char[][] maze = new char[28][28];
    private Location[][] board = new Location[28][28];

    public Maze(String filename){
  String[] lines= loadStrings("data.txt"); 
  maze = new char[lines.length][lines[0].length()];
//  for(int i = 0; i < maze.length; i++){
//      maze[i]=lines[i];
//  }
  for (int i = 0; i < lines.length; i++){
    for (int j = 0; j < lines[i].length(); j++){
      maze[i][j] = lines[i].charAt(j);
    }
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
    if(maze[r][c]=='H'){
        Location input = new Location(r, c, false, false);
        board[r][c] = input;
        home = input;
    }
    if(maze[r][c]=='.'){ 
  /*    Pellets pellet;
        Location input = new Location(r, c, true, false, pellet = new Pellets(input));
        board[r][c] = input;
    */
    Location input = new Location(r, c, true, false);
    Pellets pellet = new Pellets(input);
    board[r][c] = new Location (r, c, true, false, pellet);
  }
    if(maze[r][c]=='*'){
/*        Pellets pellet;
        Location input = new Location(r, c, true, false, pellet = new SuperPellets(input));
        board[r][c] = input;
*/
    Location input = new Location(r, c, true, false);
    Pellets pellet = new SuperPellets(input);
    board[r][c] = new Location (r, c, true, false, pellet);
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