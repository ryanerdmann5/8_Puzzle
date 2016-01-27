package puzzle;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Search {
	
	public LinkedList bfs(Node root) throws IOException, InterruptedException{
		LinkedList<Node> path=new LinkedList<Node>();
		Stack<Node> s=new Stack<Node>();
		s.push(root);
		Node current=s.pop();
		LinkedList<Node> visited=new LinkedList<Node>();
		while(current.isGoal()==false){
			visited.add(current);
			for(Node n:current.getChildren()){
				boolean in=false;
				for(Node visitedNode:visited){
					if(Arrays.deepEquals(n.state.board, visitedNode.state.board)==true){
						//System.out.println(Arrays.toString(n.state.board));
						//Thread.sleep(3000);
						in=true;
						//System.out.println(in);
					}
				}
				//System.out.println(in);
				if(in==false){
					visited.add(n);
					s.push(n);
				}
			}
			current=s.pop();
			//System.out.println(Arrays.toString(current.state.board));
			//Thread.sleep(300);
			
		}
		System.out.println("done");
		while(current.parent!=null){
			path.add(current);
			current=current.parent;
		}
		return path;
		
	}
	
	
	
	
	public LinkedList dfs(Node root) throws IOException{
		LinkedList<Node> path=new LinkedList<Node>();
		Queue<Node> s=new LinkedList<Node>();
		s.add(root);
		Node current=s.remove();
		LinkedList<Node> visited=new LinkedList<Node>();
		while(current.isGoal()==false){
			visited.add(current);
			for(Node n:current.getChildren()){
				boolean in=false;
				for(Node visitedNode:visited){
					if(Arrays.deepEquals(n.state.board, visitedNode.state.board)==true){
						in=true;
					}
				}
				if(in==false){
					visited.add(n);
					s.add(n);
				}
			}
			if(current.isGoal()==false){
				current=s.remove();
			}
			//System.out.println(Arrays.toString(current.state.board));
			
		}
		//System.out.println("done");
		while(current.parent!=null){
			//System.out.println(Arrays.toString(current.state.board));
			//System.out.println("done");
			path.add(current);
			current=current.parent;
		}
		path.add(current);
		return path;
		
	}
	
	public LinkedList uniformCost(Node root) throws IOException{
		Comparator<Node> comparator = new wSort();
		LinkedList<Node> path=new LinkedList<Node>();
		PriorityQueue<Node> s=new PriorityQueue<Node>(comparator);
		s.add(root);
		Node current=s.remove();
		LinkedList<Node> visited=new LinkedList<Node>();
		while(current.isGoal()==false){
			visited.add(current);
			for(Node n:current.getChildren()){
				boolean in=false;
				for(Node visitedNode:visited){
					if(Arrays.deepEquals(n.state.board, visitedNode.state.board)==true){
						in=true;
					}
				}
				if(in==false){
					visited.add(n);
					s.add(n);
				}
			}
			if(current.isGoal()==false){
				current=s.remove();
			}
			//System.out.println(Arrays.toString(current.state.board));
			
		}
		//System.out.println("done");
		while(current.parent!=null){
			//System.out.println(Arrays.toString(current.state.board));
			//System.out.println("done");
			path.add(current);
			current=current.parent;
		}
		path.add(current);
		return path;
		
	}
	
	
	
	public LinkedList bestfs(Node root) throws IOException{
		Comparator<Node> comparator = new hSort();
		LinkedList<Node> path=new LinkedList<Node>();
		PriorityQueue<Node> s=new PriorityQueue<Node>(comparator);
		s.add(root);
		Node current=s.remove();
		LinkedList<Node> visited=new LinkedList<Node>();
		while(current.isGoal()==false){
			visited.add(current);
			for(Node n:current.getChildren()){
				boolean in=false;
				for(Node visitedNode:visited){
					if(Arrays.deepEquals(n.state.board, visitedNode.state.board)==true){
						in=true;
					}
				}
				if(in==false){
					visited.add(n);
					s.add(n);
				}
			}
			if(current.isGoal()==false){
				current=s.remove();
			}
			//System.out.println(Arrays.toString(current.state.board));
			
		}
		//System.out.println("done");
		while(current.parent!=null){
			//System.out.println(Arrays.toString(current.state.board));
			//System.out.println("done");
			path.add(current);
			current=current.parent;
		}
		path.add(current);
		return path;
		
	}
	
	
	public LinkedList aStar(Node root) throws IOException{
		Comparator<Node> comparator = new aSort();
		LinkedList<Node> path=new LinkedList<Node>();
		PriorityQueue<Node> s=new PriorityQueue<Node>(comparator);
		s.add(root);
		Node current=s.remove();
		LinkedList<Node> visited=new LinkedList<Node>();
		while(current.isGoal()==false){
			visited.add(current);
			for(Node n:current.getChildren()){
				boolean in=false;
				for(Node visitedNode:visited){
					if(Arrays.deepEquals(n.state.board, visitedNode.state.board)==true){
						in=true;
					}
				}
				if(in==false){
					visited.add(n);
					s.add(n);
				}
			}
			if(current.isGoal()==false){
				current=s.remove();
			}
			//System.out.println(Arrays.toString(current.state.board));
			
		}
		//System.out.println("done");
		while(current.parent!=null){
			//System.out.println(Arrays.toString(current.state.board));
			//System.out.println("done");
			path.add(current);
			current=current.parent;
		}
		path.add(current);
		return path;
		
	}

	public LinkedList aStar2(Node root) throws IOException{
		Comparator<Node> comparator = new a2Sort();
		LinkedList<Node> path=new LinkedList<Node>();
		PriorityQueue<Node> s=new PriorityQueue<Node>(comparator);
		s.add(root);
		Node current=s.remove();
		LinkedList<Node> visited=new LinkedList<Node>();
		while(current.isGoal()==false){
			visited.add(current);
			for(Node n:current.getChildren()){
				boolean in=false;
				for(Node visitedNode:visited){
					if(Arrays.deepEquals(n.state.board, visitedNode.state.board)==true){
						in=true;
					}
				}
				if(in==false){
					visited.add(n);
					s.add(n);
				}
			}
			if(current.isGoal()==false){
				current=s.remove();
			}
			//System.out.println(Arrays.toString(current.state.board));
			
		}
		//System.out.println("done");
		while(current.parent!=null){
			//System.out.println(Arrays.toString(current.state.board));
			//System.out.println("done");
			path.add(current);
			current=current.parent;
		}
		path.add(current);
		return path;
		
	}
	static class hSort implements Comparator<Node> {
		 
		public int compare(Node one, Node two) {
			Integer a=two.calculateHeuristic();
			Integer b=one.calculateHeuristic();
			return b.compareTo(a) ;
			
		}
	}
	
	static class wSort implements Comparator<Node> {
		 
		public int compare(Node one, Node two) {
			Integer a=two.calculateWeight();
			Integer b=one.calculateWeight();
			return b.compareTo(a) ;
			
		}
	}
	
	static class aSort implements Comparator<Node> {
		 
		public int compare(Node one, Node two) {
			Integer a=two.calculateWeight()+two.calculateHeuristic();
			Integer b=one.calculateWeight()+one.calculateHeuristic();
			return b.compareTo(a) ;
			
		}
	}
	
	static class a2Sort implements Comparator<Node> {
		 
		public int compare(Node one, Node two) {
			Integer a=two.calculateWeight()+two.calculateHeuristic2();
			Integer b=one.calculateWeight()+one.calculateHeuristic2();
			return b.compareTo(a) ;
			
		}
	}
	

}
