package chap8;
import java.util.*;

public class Question_8_2 {
	class Point{
		int row,col;
		Point(int row,int col)
		{
			this.row=row;
			this.col=col;
		}	
	}
	ArrayList<Point> path=new ArrayList<Point>();
	HashMap<Point, Boolean> cache=new HashMap<Point, Boolean>();
	static boolean[][] maze= {{true, false, false, true},{true, false, false, true},
						{true,true, true, true}, {false, true, false, true}};
	int lastRow=maze.length-1;
	int lastCol=maze[0].length-1;
	
	ArrayList<Point> getPath(boolean[][] maze)
	{
		if(getPath(maze, path, cache, lastRow, lastCol)==true)
		{
			return path;
		}
		else
			return null;
	}
	
	boolean getPath(boolean[][] maze, ArrayList<Point> path, HashMap<Point, Boolean> cache, int row, int col)
	{
		if(col<0||row<0||maze[row][col]==false)
		{
			return false;
		}
		Point p=new Point(row,col);
		if(cache.containsKey(p))
		{
			return cache.get(p);
		}
		boolean isOrigin=false;
		if(row==0 && col==0)
		{
			isOrigin=true;
		}
		boolean success=false;
		if(isOrigin || getPath(maze, path, cache, row-1, col)|| getPath(maze, path, cache, row, col-1))
		{
			path.add(p);
			success=true;
		}
		cache.put(p, success);
		return success;
	}
	public static void main(String[] args) {
		Question_8_2 obj=new Question_8_2();
		ArrayList<Point> path=obj.getPath(maze);
		for(int i=0;i<path.size();i++)
		{
			System.out.print(path.get(i).row+","+path.get(i).col+" ");
		}
	}
}
