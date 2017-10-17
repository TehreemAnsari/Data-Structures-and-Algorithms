package chap4;

import java.util.*;
public class Question_4_1 {

	public static void main(String[] args) {
		Graph g=new Graph(8);
		g.createGraph();
		g.printGraph();
		int src=2, dest=5;
		System.out.println("Is "+src+" and "+dest+" connected?"+g.isConnected(src, dest));
		/*INPUT and OUTPUT
		 * Number of edges:
			12
			Directed: 1, Undirected: 2
			1
			Enter edges
			0
			1
			0
			3
			0
			5
			1
			2
			2
			3
			2
			4
			3
			1
			3
			4
			4
			7
			5
			3
			6
			3
			7
			6
			0->1-3-5-
			1->2-
			2->3-4-
			3->1-4-
			4->7-
			5->3-
			6->3-
			7->6-
			
			Neighbours of 2
			3 4 
			Neighbours of 3
			1 4 
			Neighbours of 4
			7 
			Neighbours of 1
			2 
			Neighbours of 7
			6 
			Neighbours of 6
			3 Is 2 and 5 connected?false
		 * */
		 
	}
	
}
class Graph
{
	List<Integer>[] adjList;
	Graph(int n)		//number of nodes
	{
		adjList=new LinkedList[n];
		for(int i=0;i<n;i++)
		{
			adjList[i]=new LinkedList<>();
		}
	}
	void createGraph()
	{
		int edges, vertex1, vertex2;
		Scanner sc=new Scanner(System.in);
		System.out.println("Number of edges:");
		edges=sc.nextInt();
		System.out.println("Directed: 1, Undirected: 2");
		int option=sc.nextInt();
		if(option==1)
		{
			System.out.println("Enter edges");
			for(int i=0;i<edges;i++)
			{
				vertex1=sc.nextInt();
				vertex2=sc.nextInt();
				adjList[vertex1].add(vertex2);
			}
		}
		if(option==2)
		{
			System.out.println("Enter edges");
			for(int i=0;i<edges;i++)
			{
				vertex1=sc.nextInt();
				vertex2=sc.nextInt();
				adjList[vertex1].add(vertex2);
				adjList[vertex2].add(vertex1);
			}
		}
		sc.close();
	}
	void printGraph()
	{
		for(int i=0;i<adjList.length;i++)
		{
			System.out.print((i)+"->");
			Iterator<Integer> itr=adjList[i].iterator();
			while(itr.hasNext())
			{
				System.out.print((itr.next())+"-");
			}
			System.out.println();
		}
	}
	LinkedList<Integer> bfs(Integer src)
	{
		LinkedList<Integer> visited=new LinkedList<>();
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(src);
		while(!q.isEmpty()) 
		{
			int item=q.remove();
			System.out.println("\nNeighbours of "+item);
			LinkedList<Integer> t=(LinkedList<Integer>) adjList[item];
			Iterator<Integer> itr=t.iterator();
			while(itr.hasNext())
			{
				Integer neighbour=itr.next();
				System.out.print(neighbour+" ");
				if(!q.contains(neighbour) && !visited.contains(neighbour))
				{
					q.add(neighbour);
				}
			}
			visited.add(item);
		}
		return visited;
	}
	boolean isConnected(int src, int dest)
	{
		LinkedList<Integer> bfsResult=bfs(src);
		if(bfsResult.contains(dest))
			return true;
		else
			return false;
	}
}