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
	public static int weightA = 0, weightB = 0, weightC = 0;
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
		Train temp = track0.remove();
		while (!track0.isEmpty()){
			if (temp.getMiles()>700){
				track1.add(temp);
				temp = track0.remove();
		} //end if
			else{
				sort(track0,temp);
				temp=track0.remove();
			} //end else
		} //end while
		System.out.println(trackA);
		System.out.println(trackB);
		System.out.println(trackC);
	}//end main

	//make depart and sort method
	public static void depart(Stack<Train> s){
		while (!s.isEmpty())
			System.out.println(s.pop());
		System.out.println();
	}//end method depart

	public static void sort (Queue <Train> q, Train t){

			if (t.getDestination().toLowerCase().equals("trenton")){
				weightA += t.getWeight();
				if (weightA>limitTrackA){
					weightA=0;
					trackA.push(new Train ("ENG00000", "Trenton"));
					depart(trackA);
					trackA.push(t);
				}//end inner if
				else if(t.isEngine()){
					trackA.push(t);
					weightA=0;
					depart(trackA);
				}//end inner else if
				else{
					trackA.push(t);
				}//end else
			}//end Trenton if
			else if (t.getDestination().toLowerCase().equals("charlotte")){
				weightB += t.getWeight();
				if (weightB>limitTrackB){
					weightB=0;
					trackB.push(new Train ("ENG00000", "Charlotte"));
					depart(trackB);
					trackB.push(t);
				}//end inner if
				else if(t.isEngine()){
					trackB.push(t);
					weightB=0;
					depart(trackB);
				}//end inner else if
				else{
					trackB.push(t);
				}//end else
			}//end Charlotte else if
			else if (t.getDestination().toLowerCase().equals("baltimore")){
				weightC += t.getWeight();
				if (weightC>limitTrackC){
					weightC=0;
					trackC.push(new Train ("ENG00000", "Baltimore"));
					depart(trackC);
					trackC.push(t);
				}//end inner if
				else if(t.isEngine()){
					trackC.push(t);
					weightC=0;
					depart(trackC);
				}//end inner else if
				else{
					trackC.push(t);
				}//end else
			}//end Batimore else if
			
		

	 }//end method sort 

 }//end class
