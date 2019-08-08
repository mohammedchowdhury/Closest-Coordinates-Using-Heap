import java.util.ArrayList;
import java.util.HashSet;

import javax.xml.bind.Validator;
//Mohammed Chowdhury 
public class PriorityQueue {
	private static ArrayList<Node> myQueue; 
	  private static String mainX, mainY; 
	private static int size = 0;

	public PriorityQueue(String mainx,String mainy) {
		this.mainX = mainx; 
		this.mainY = mainy; 
		myQueue = new ArrayList<>(); 
	}

	public void add(String x, String y) {
		String mainxcopy = this.mainX; 
		String mainycopy = this.mainY; 
		Node newNode  = new Node(x, y, mainxcopy, mainycopy);
			myQueue.add(newNode); 
			size = myQueue.size();
			if(size>1) {
				BubbleUp(); 
			}
	}

	public Node NodeGetFirst(){
		Node targetNode = myQueue.get(0); 
		myQueue.set(0, myQueue.get(size-1)); 
		myQueue.remove(size-1); 
		size = myQueue.size(); 
		heapfiyDown();
		return targetNode;
	}


	private void heapfiyDown() {
		int currentPlace = 0; 
		while(true) {			
			int leftChild = currentPlace*2+1; 
			int  rightChild = currentPlace*2+2; 		
			if(leftChild<size && rightChild<size) {		
				int correctChild; 
				if(myQueue.get(rightChild).getDistance()>=myQueue.get(leftChild).getDistance()) {
					correctChild=leftChild; 
				}
				else {
					correctChild = rightChild; 
				}			
				if(myQueue.get(currentPlace).getDistance()>=myQueue.get(correctChild).getDistance()) {
					Node parentNode = myQueue.get(currentPlace); 
					Node childNode = myQueue.get(correctChild); 
					
					myQueue.set(correctChild, parentNode); 
					myQueue.set(currentPlace, childNode); 
					
					currentPlace = correctChild; 			
				}
				else {
					return; 
				}
			}
			else if(leftChild<size && !(rightChild<size)) {
				
				if(myQueue.get(currentPlace).getDistance()>myQueue.get(leftChild).getDistance()) {
					Node parentNode = myQueue.get(currentPlace); 
					Node childNode = myQueue.get(leftChild); 
					myQueue.set(leftChild, parentNode); 
					myQueue.set(currentPlace, childNode); 
				}
				return; 
				
			}
			else if(!(leftChild<size)&& !(rightChild<size)) {
				return; 
			}
		}
	}

	private void BubbleUp() {
		int parent  = size/2;
		int last = size; 

		while(parent!=0 && last!=0) {
			if(myQueue.get(parent-1).getDistance() > myQueue.get(last-1).getDistance()) {
				Node childNode = myQueue.get(last-1); 
				Node parentNode = myQueue.get(parent-1); 
				myQueue.set(last-1, parentNode); 
				myQueue.set(parent-1, childNode); 

				last = parent; 
				parent = parent/2; 		
			}
			else {
				return; 
			}
		}
	}

	public void print() {
		for(int a=0; a<myQueue.size(); a++) {
			System.out.println(myQueue.get(a).getData());
		}
	}
	public int getSize() {
		return myQueue.size(); 
	}
}
//Mohammed Chowdhury 
