package puzzle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Process {
	  public static void main(String []args) throws IOException, InterruptedException{
		  Search s=new Search();
		  Scanner input=new Scanner(System.in);
		  System.out.println("Welcome to the 8 puzzle solver by Ryan Erdmann");
		  System.out.println("please select a difficulty: 1: board(1,3,4,8,6,2,7,0,5) 2: board(2,8,1,0,4,3,7,6,5) 3: board(5,6,7,4,0,8,3,2,1)");
		  int difficulty=input.nextInt();
		  System.out.println("Select a searching method: 1:BFS 2:DFS(Caution! slow) 3:Uniform Cost 4: BestFS 5: A*1 6:A*2");
		  int search=input.nextInt();
		  long startTime = System.currentTimeMillis();
		  Integer[] a;
		  if(difficulty==1){
			  a=new Integer[]{1,3,4,8,6,2,7,0,5};
		  }
		  else if(difficulty==2){
			  a=new Integer[]{2,8,1,0,4,3,7,6,5};
		  }
		  else if(difficulty==3){
			  a=new Integer[]{5,6,7,4,0,8,3,2,1};
		  }
		  else{
			  System.out.println("Invalid difficulty, defualting to easy");
			  a=new Integer[]{1,3,4,8,6,2,7,0,5};
		  }
		  
		  if(search==1){
			  LinkedList<Node> path=s.bfs(new Node(null,new Board(a),"Start"));
			  java.util.Iterator<Node> itr=path.descendingIterator();
			  int totalCost=0;
			  while(itr.hasNext()){
				  Node current=itr.next();
				  System.out.println(Arrays.toString(current.state.board)+current.move+" Total Cost:"+totalCost);
				  totalCost=totalCost+(current.calculateWeight());
			  }
		  }
		  
		  if(search==2){
			  LinkedList<Node> path=s.dfs(new Node(null,new Board(a),"Start"));
			  java.util.Iterator<Node> itr=path.descendingIterator();
			  int totalCost=0;
			  while(itr.hasNext()){
				  Node current=itr.next();
				  System.out.println(Arrays.toString(current.state.board)+current.move+" Total Cost:"+totalCost);
				  totalCost=totalCost+(current.calculateWeight());
			  }
		  }
		  
		  if(search==3){
			  LinkedList<Node> path=s.uniformCost(new Node(null,new Board(a),"Start"));
			  java.util.Iterator<Node> itr=path.descendingIterator();
			  int totalCost=0;
			  while(itr.hasNext()){
				  Node current=itr.next();
				  System.out.println(Arrays.toString(current.state.board)+current.move+" Total Cost:"+totalCost);
				  totalCost=totalCost+(current.calculateWeight());
			  }
		  }
		  
		  if(search==4){
			  LinkedList<Node> path=s.bestfs(new Node(null,new Board(a),"Start"));
			  java.util.Iterator<Node> itr=path.descendingIterator();
			  int totalCost=0;
			  System.out.println("path length: "+path.size());
			  while(itr.hasNext()){
				  Node current=itr.next();
				  System.out.println(Arrays.toString(current.state.board)+current.move+" Total Cost:"+totalCost);
				  totalCost=totalCost+(current.calculateHeuristic());
			  }
		  }
		  
		  if(search==5){
			  LinkedList<Node> path=s.aStar(new Node(null,new Board(a),"Start"));
			  java.util.Iterator<Node> itr=path.descendingIterator();
			  int totalCost=0;
			  System.out.println("path length: "+path.size());
			  while(itr.hasNext()){
				  Node current=itr.next();
				  System.out.println(Arrays.toString(current.state.board)+current.move+" Total Cost:"+totalCost);
				  //System.out.println(current.calculateHeuristic()+current.calculateWeight());
				  totalCost=totalCost+(current.calculateHeuristic()+current.calculateWeight());
			  }
		  }
		  
		  if(search==6){
			  LinkedList<Node> path=s.aStar2(new Node(null,new Board(a),"Start"));
			  java.util.Iterator<Node> itr=path.descendingIterator();
			  int totalCost=0;
			  System.out.println("path length: "+path.size());
			  while(itr.hasNext()){
				  Node current=itr.next();
				  System.out.println(Arrays.toString(current.state.board)+current.move+" Total Cost:"+totalCost);
				  totalCost=totalCost+(current.calculateHeuristic2()+current.calculateWeight());
			  }
		  }
		  
		    long stopTime = System.currentTimeMillis();
		    long elapsedTime = stopTime - startTime;
		    System.out.println("Time in miliseconds: "+elapsedTime);
		  
		    Runtime runtime = Runtime.getRuntime();
		    // Run the garbage collector
		    runtime.gc();
		    // Calculate the used memory
		    long memory = runtime.totalMemory() - runtime.freeMemory();
		    System.out.println("Used memory is bytes: " + memory);
		    System.out.println("Used memory is megabytes: "+ bytesToMegabytes(memory));
	  }
	  
	  private static final long MEGABYTE = 1024L * 1024L;

	  public static long bytesToMegabytes(long bytes) {
	    return bytes / MEGABYTE;
	  }

}
