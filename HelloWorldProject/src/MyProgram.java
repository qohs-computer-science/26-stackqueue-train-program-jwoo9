/*
 * Justin Wu
 * 1/13/24
 * Pd 3
 * Program that simulates a train station with multiple tracks that depart to different destinations.
 */
import java.util.Scanner;
import java.io.File;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class MyProgram {
	//create stacks for track A-D and variables for weight and limit
	public static int val = 0;
	public static int weightA = 0, weightB = 0, weightC = 0, weightD = 0;
	public static int limitTrackA = 100000, limitTrackB = 100000, limitTrackC = 100000;
	public static Stack<Train> trackA = new Stack<Train>();
	public static Stack<Train> trackB = new Stack<Train>();
	public static Stack<Train> trackC = new Stack<Train>();
	public static Stack<Train> trackD = new Stack<Train>();
	public static void main(String[] args) {

		
		
		Scanner x = new Scanner(System.in);
		//Create queues for tracks 0 and 1
		Queue <Train> track0 = new LinkedList<Train>();
		Queue <Train> track1 = new LinkedList<Train>();

		try{
			File f = new File("HelloWorldProject/src/data.txt");
			x = new Scanner (f);
			
		} //end try
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}//end catch

		String name = x.nextLine();
		System.out.println(name);
		System.out.println(name.length());
		while (!name.toLowerCase().equals("end")){
			if (name.substring(0,3).toLowerCase().equals("car")){
				track0.add(new Train(name, x.nextLine(),x.nextLine(), x.nextLine(), x.nextInt(), x.nextInt()));
				x.nextLine();
				name = x.nextLine();
			} //end if
			else {
				track0.add(new Train(name, x.nextLine()));
				name = x.nextLine();
			} //end else
		}//end while
		
		//filter out track1

		
	}//end main

	//make depart and sort method
	public static void depart(Stack<Train> s){
		while (!s.isEmpty())
			System.out.println(s.pop());
	}//end method depart

	public static void sort (Queue <Train> q){
		while (!q.isEmpty()){
			Train temp = q.remove();
			if (temp.getDestination().toLowerCase().equals("trenton")){
				weightA += temp.getWeight();
				if (weightA>limitTrackA){
					weightA=0;
					trackA.push(new Train ("ENG0000", "Trenton"));
				}//end inner if

			}//end Trenton if
		}//end while

	}//end method sort

}//end class
