//Mohammed Chowdhury 
public class Node {
	
	private int x,y;
	private int mainX, mainY; 
	private double distance; 
	
	Node(String x, String y,String mainX, String mainY){
		this.x = Integer.parseInt(x); 
		this.y = Integer.parseInt(y); 
//		System.out.println("ghchgch");
//		System.out.println(mainX+" "+mainY);
		this.mainX = Integer.parseInt(mainX); 
		this.mainY = Integer.parseInt(mainY); 
		setDistance(); 
	}
	private void setDistance() {
		this.distance = Math.hypot(x-mainX, y-mainY); 
	}
	public double getDistance() {
		return this.distance; 
	}
	public String getData() {
		return x+" ,"+y+" , "+distance; 
	}
}
//Mohammed Chowdhury 