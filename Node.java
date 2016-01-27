package puzzle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

public class Node {
	public Node parent;
	public Board state;
	public static int heuristic;
	public int weight;
	public String move;
	
	public Node(Node parent, Board state, String move){
		this.parent=parent;
		this.state=state;
		this.move=move;
		heuristic=calculateHeuristic();
	}
	
	public boolean isGoal(){
		return state.isGoal();
	}
	
	public LinkedList<Node> getChildren() throws IOException{
		LinkedList<Node> children=new LinkedList<Node>();
		if(state.canGoLeft()){
			children.add(new Node(this, state.left(),"Left"));
		}
		if(state.canGoRight()){
			children.add(new Node(this, state.right(),"Right"));
		}
		if(state.canGoUp()){
			children.add(new Node(this, state.up(),"Up"));
		}
		if(state.canGoDown()){
			children.add(new Node(this, state.down(),"Down"));
		}
		return children;
	}
	
	public int calculateHeuristic(){
		return state.calculateHeuristic();
	}
	
	public int calculateHeuristic2(){
		return state.calculateMDistance();
	}
	
	public int calculateWeight(){
		if(parent==null){
			return 0;
		}
		return(this.state.calculateWeight(parent.state));
	}


}
