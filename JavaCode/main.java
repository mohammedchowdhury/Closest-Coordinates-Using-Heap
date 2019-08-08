import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
//Mohammed Chowdhury 
public class main {

	static String location,mainX,mainY;
	static int point; 
	static PriorityQueue myQueue; 


	public static void main(String[] args) throws IOException {

				location = args[0]; 
				point  = Integer.parseInt(args[1]);

//		location = "/Users/mohammedchowdhury/Desktop/locations.txt"; //linking the file 
//		point = 5000;

		if(point<0 || point>5000) {
			System.out.println("Not a Valid Point");
			return; 
		}

		readData();
		writetoFile(); 
	
	}
	private static void writetoFile() throws IOException {
		String path = location.replace("locations.txt", "OutPutLocations.txt"); 
		System.out.println(path);
				
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			String str =""; 
			for(int a=0 ;a<point;a++) {
				str = str + myQueue.NodeGetFirst().getData()+"\n";  
			}
			System.out.println(str);
			
			writer.write(str);
			writer.close();
		}
		
	
	public static void readData() throws IOException {

		File file = new File(location); 
		String[] arrOfStr = new String[2]; 
		int counter = 0; 
		String st; 

		//try {
		BufferedReader br = new BufferedReader(new FileReader(file)); 

		String x,y; 

		st = br.readLine(); 

		arrOfStr = st.split(" ");
		arrOfStr[0].replaceAll(" ",""); 
		arrOfStr[1].replaceAll(" ",""); 

		x = arrOfStr[0]; 
		y = arrOfStr[1]; 

		myQueue = new PriorityQueue(x, y);
		x = ""; 
		y = ""; 
		while ((st = br.readLine()) != null) {
			//System.out.println(st);
			arrOfStr = st.split(" ");
			arrOfStr[0].replaceAll(" ",""); 
			arrOfStr[1].replaceAll(" ",""); 
			x = arrOfStr[0]; 
			y = arrOfStr[1]; 
			System.out.println(x+"  "+y);
			myQueue.add(x, y);
			x = ""; 
			y = ""; 
		}
	}
}
//Mohammed Chowdhury 