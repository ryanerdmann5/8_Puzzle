//Ryan Erdmann
package puzzle;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Board {
	
	public Integer[] board;
	
	public Board(Integer[] board ){
		this.board=board;
	}

	public boolean canGoRight(){
		int index=Arrays.asList(this.board).indexOf(0);
		if(index==2 || index==5 || index==8){
			return false;
		}
		return true;
	}
	
	public Board right() throws IOException{
		Integer[] temp=this.board.clone();
		int index=Arrays.asList(this.board).indexOf(0);
		if(index==2 || index==5 || index==8){
			throw new IOException("cannot move right");
		}
		int previousValue=this.board[index+1];
		temp[index+1]=0;
		temp[index]=previousValue;
		return new Board(temp);	
	}
	
	public boolean canGoLeft(){
		int index=Arrays.asList(this.board).indexOf(0);
		if(index==0 || index==3 || index==6){
			return false;
		}
		return true;
	}
	
	public Board left() throws IOException{
		Integer[] temp=this.board.clone();
		int index=Arrays.asList(this.board).indexOf(0);
		if(index==0 || index==3 || index==6){
			throw new IOException("cannot move left");
		}
		int previousValue=this.board[index-1];
		temp[index-1]=0;
		temp[index]=previousValue;
		return new Board(temp);	
	}
	
	public boolean canGoUp(){
		int index=Arrays.asList(this.board).indexOf(0);
		if(index==0 || index==1 || index==2){
			return false;
		}
		return true;
	}
	
	public Board up() throws IOException{
		Integer[] temp=this.board.clone();
		int index=Arrays.asList(this.board).indexOf(0);
		if(index==0 || index==1 || index==2){
			throw new IOException("cannot move up");
		}
		int previousValue=this.board[index-3];
		temp[index-3]=0;
		temp[index]=previousValue;
		return new Board(temp);	
	}
	
	
	public boolean canGoDown(){
		int index=Arrays.asList(this.board).indexOf(0);
		if(index==6 || index==7 || index==8){
			return false;
		}
		return true;
	}
	
	public Board down() throws IOException{
		Integer[] temp=this.board.clone();
		int index=Arrays.asList(this.board).indexOf(0);
		if(index==6 || index==7 || index==8){
			throw new IOException("cannot move down");
		}
		int previousValue=this.board[index+3];
		temp[index+3]=0;
		temp[index]=previousValue;
		return new Board(temp);	
	}
	
	public boolean isGoal(){
		Integer[] goal={1,2,3,8,0,4,7,6,5};
		return Arrays.deepEquals(goal, this.board);
	}
	
	
	public int calculateWeight(Board parent){
		int weight=0;
		for(int i=0;i<board.length-1;i++){
			if(board[i]!=parent.board[i]){
				weight=weight+parent.board[i];
			}
		}
		return weight;
	}
	
	public int calculateHeuristic(){
		int h=0;
		if(board[0]!=1){
			h++;
		}
		if(board[1]!=2){
			h++;
		}
		if(board[2]!=3){
			h++;
		}
		if(board[3]!=8){
			h++;
		}
		if(board[4]!=0){
			h++;
		}
		if(board[5]!=4){
			h++;
		}
		if(board[6]!=7){
			h++;
		}
		if(board[7]!=6){
			h++;
		}
		if(board[8]!=5){
			h++;
		}
		return h;
	}
	
	
	public int calculateMDistance(){
		int m=0;
		int index=0;
		if(board[0]!=1){
			index=Arrays.asList(this.board).indexOf(1);
			m=m+calculateDistance(0,index);
		}
		if(board[1]!=2){
			index=Arrays.asList(this.board).indexOf(2);
			m=m+calculateDistance(1,index);
		}
		if(board[2]!=3){
			index=Arrays.asList(this.board).indexOf(3);
			m=m+calculateDistance(2,index);
		}
		if(board[3]!=8){
			index=Arrays.asList(this.board).indexOf(8);
			m=m+calculateDistance(3,index);
		}
		if(board[4]!=0){
			index=Arrays.asList(this.board).indexOf(0);
			m=m+calculateDistance(4,index);
		}
		if(board[5]!=4){
			index=Arrays.asList(this.board).indexOf(4);
			m=m+calculateDistance(5,index);
		}
		if(board[6]!=7){
			index=Arrays.asList(this.board).indexOf(6);
			m=m+calculateDistance(6,index);
		}
		if(board[7]!=6){
			index=Arrays.asList(this.board).indexOf(7);
			m=m+calculateDistance(0,index);
		}
		if(board[8]!=5){
			index=Arrays.asList(this.board).indexOf(5);
			m=m+calculateDistance(8,index);
		}
		return m;
	}
	
	
	public static int calculateDistance(int goal, int actual){
		if(actual ==0 || actual ==3 || actual ==6){
			int difference=actual-goal;
			if(difference==1||difference==3||difference==-3){
				return 1;
			}
			if(difference==2||difference==-2||difference==4||difference==6||difference==-6){
				return 2;
			}
			if(difference==5||difference==-5||difference==7||difference==-1){
				return 3;
			}
			if(difference==-4||difference==8){
				return 4;
			}
			
		}   
		if(actual ==1 || actual ==4 || actual ==7){
			int difference=actual-goal;
			if(difference==1||difference==-1||difference==3||difference==-3){
				return 1;
			}
			if(difference==2||difference==-2||difference==4||difference==-4 ||difference==6||difference==-6){
				return 2;
			}
			if(difference==5||difference==-5||difference==7||difference==7){
				return 3;
			}
			if(difference==8){
				return 4;
			}
			
		}
		
		if(actual ==2 || actual ==5 || actual ==8){
			int difference=actual-goal;
			if(difference==-1||difference==3||difference==-3){
				return 1;
			}
			if(difference==2||difference==-2||difference==-4 ||difference==6||difference==-6){
				return 2;
			}
			if(difference==5||difference==-5||difference==7||difference==7||difference==1){
				return 3;
			}
			if(difference==8||difference==4){
				return 4;
			}
			
		} 
		
		return 0;
	}
	
	
	  public static void main(String []args) throws IOException{
		  System.out.println(calculateDistance(1,3));
		  Integer[] a={1,2,3,0,8,4,7,6,5};
		  Board b= new Board(a);
		  System.out.println(Arrays.toString(b.board));
		  System.out.println(b.isGoal());
		  Board c=b.right();
		  System.out.println(Arrays.toString(c.board));
		  System.out.println(c.calculateWeight(b));
		  System.out.println(c.isGoal());
		  Board d=b.left();
		  System.out.println(Arrays.toString(d.board));
		  Board e=b.up();
		  System.out.println(Arrays.toString(e.board));
		  Board f=e.down();
		  System.out.println(Arrays.toString(f.board));
		  
		  
		  
	  }

}
