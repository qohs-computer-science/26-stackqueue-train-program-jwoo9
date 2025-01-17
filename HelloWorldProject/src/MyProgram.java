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
		
		//filter out track0
		System.out.println("\n Processing through track 0 \n");
		Train temp = track0.peek();
		while (!track0.isEmpty()){
			if (temp.getMiles()>700){
				track1.add(temp);
				track0.remove();
				temp = track0.peek();
		} //end if
			else{
				sort(track0,temp);
				track0.remove();
				temp=track0.peek();
			} //end else
		} //end while

		System.out.println("\n Train cars with over 700 miles (in track 1):\n");
		System.out.println(track1);

		//filter out track 1 afterwards
		System.out.println("\n\n Inspecting train cars on track 1 and processing\n");
	
		temp = track1.peek();
		while (!track1.isEmpty()){
			temp.setMiles(100);
			sort(track1,temp);
			track1.remove();
			temp=track1.peek();
		}//end while


		System.out.println("\n\n Depart Remaining Trains\n");
		if (trackA.isEmpty())
			System.out.println("No cars remaining in Trenton Track");
		else{
			trackA.push(new Train ("ENG00000", "Trenton"));
			depart(trackA);
		}//end else
		if (trackB.isEmpty())
			System.out.println("No cars remaining in Charlotte Track");
		else{
			trackB.push(new Train ("ENG00000", "Charlotte"));
			depart(trackB);
		}//end else
		if (trackC.isEmpty())
			System.out.println("No cars remaining in Baltimore Track");
		else{
			trackC.push(new Train ("ENG00000", "Baltimore"));
			depart(trackC);
		}//end else


		if (trackD.isEmpty())
			System.out.println("No cars remaining in 'other' track");
		else{
			System.out.println("\n Cars Remaining in 'other' track\n");
			System.out.println(trackD);
		}//end else

		
		System.out.println();

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
					weightA += t.getWeight();
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
					weightB += t.getWeight();
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
					weightC += t.getWeight();
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


			else{
				if (t.isEngine()){
					trackD.push(t);
					depart(trackD);
				}//end inner if
				else{
					trackD.push(t);
				}//end else
			}//end else other
			

	 }//end method sort 

 }//end class
