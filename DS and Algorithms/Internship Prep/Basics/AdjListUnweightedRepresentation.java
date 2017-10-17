package basic;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AdjListUnweightedRepresentation {

	private static Scanner sc;
	void createGraph(int numberOfNodes)
	{
		List<Integer>[] adjList=new LinkedList[numberOfNodes];
		 // Make sure the list is initialized before adding to it
		for(int i=0;i<numberOfNodes;i++)
		{
			adjList[i]=new LinkedList<>();
		}
		int i=0;
		System.out.println("Enter number of edges:");
		int edges=sc.nextInt();
		System.out.println("Enter edges");
		while(i!=2*edges)
		{
			int vertex1=sc.nextInt();
			int vertex2=sc.nextInt();
			adjList[vertex1].add(vertex2);
			i++;
		}
		/*adjList[0].add(1);
		adjList[0].add(2);
		adjList[0].add(3);
		adjList[1].add(0);
		adjList[1].add(5);
		adjList[2].add(0);
		adjList[2].add(4);
		adjList[2].add(5);
		adjList[3].add(0);
		adjList[3].add(4);
		adjList[4].add(2);
		adjList[4].add(3);
		adjList[5].add(1);
		adjList[5].add(2);*/
		printGraph(adjList);
	}
	void printGraph(List<Integer>[] adjList)
	{
		/*for(int i=0;i<adjList.length;i++)
		{
			String temp=Arrays.toString(adjList[i].toArray());
			System.out.println(i+"-"+temp);
		}*/
		//Use Iterator or ListIterator to iterate over a list//set
		for(int i=0;i<adjList.length;i++)
		{
			System.out.print(i+"->");
			Iterator<Integer> itr=adjList[i].iterator();
			while(itr.hasNext())
			{
				System.out.print(itr.next()+"-");
			}
			System.out.println();
			
			//adjList[i].forEach(vertex-> System.out.println(vertex));
			//Enhanced way of traversing in a sigle line.....
		}
	}
	public static void main(String[] args) {
		AdjListUnweightedRepresentation obj=new AdjListUnweightedRepresentation();
		sc = new Scanner(System.in);
		System.out.println("Enter vertices:");
		int n=sc.nextInt();
		obj.createGraph(n);
	}
}
