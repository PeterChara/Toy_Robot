package Robot;
import java.util.*;

public class main {
	
	public static final Scanner sc = new Scanner(System.in);
	public static int row;
	public static int column;
	public static String face;
	
	public static void main(String[] args) {

		System.out.println("Welcome to the REA Toy Robot Simulator \n");
		placeRobot();
		
		String userSelection;
		do {
		System.out.println("------------------- \n");	
		System.out.println("Robot Control Menu \n");
		System.out.println("-------------------");

		System.out.printf("%-28s%s\n", "Place", "P");
		System.out.printf("%-28s%s\n", "Move", "M");
		System.out.printf("%-28s%s\n", "Left", "L");
		System.out.printf("%-28s%s\n", "Right", "R");
		System.out.printf("%-28s%s\n", "Report", "E");
		System.out.printf("%-28s%s\n", "Exit Program", "X");
		System.out.println();

	     // Prompt user to enter selection and make it case insensitive
	    System.out.print("Enter selection: ");
	    userSelection = sc.nextLine().toUpperCase();
	
	    System.out.println();
	     
	    // Process user selection
	    switch (userSelection)
	    {
	       case "P":
	          placeRobot();
	          break;
	
	       case "M":
	           moveRobot();
	           break;
	
	        case "L":
	           leftRobot();
	           break;
	
	        case "R":
	           rightRobot();
	           break;
	
	        case "E":
	           reportRobot();
	           break;
	
	        case "X":
	           System.out.println("Exiting the simulation...");
	           break;
	
	        default:
	           System.out.println("Error - invalid selection!");
	     }
	
	  } while (!userSelection.equals("X"));
	
	}
	
	private static void placeRobot() {
		int x = 0;
		int y = 0;
		String direction = "";

		System.out.println("Place Robot");
		System.out.println("Please enter the position you wish to place the robot");
		System.out.println("-------------------");
		
		//try catch statement to ensure input is a number
		boolean retry = false;
		int loopCount = 0;
		while(!retry) {
		try {
			System.out.println("X (0-4):");
			x = sc.nextInt();
			while(x > 4) {
				System.out.println("Please enter number between 0-4");
				x = sc.nextInt();
			}
			retry = true;
		}
		catch(InputMismatchException e) {
			if(loopCount == 3) {
				System.out.println("Too many incorrect attempts. Exiting application");
				System.exit(0);
			}
			System.out.println("Please enter value as number");
			sc.next();
			loopCount ++;
			
		}
	}
		
		
		//Resetting variable
		retry = false;
		loopCount = 0;
		
		while(!retry) {
		try {
			System.out.println("Y (0-4):");
			y = sc.nextInt();
			while(y > 4) {
				System.out.println("Please enter number between 0-4");
				y = sc.nextInt();
			}
			retry = true;
		}
		catch(InputMismatchException e) {
			if(loopCount == 3) {
				System.out.println("Too many incorrect attempts. Exiting application");
				System.exit(0);
			}
			System.out.println("Please enter value as number");
			sc.next();
			loopCount ++;
		}
		}
		
		sc.nextLine(); //blank scan to remove \n occupying next line

		System.out.println("Please enter the direction you would like the robot to face");
		System.out.println("North, East, South, West");
		
		//make entered value case insensitive
		boolean valid = false;
		
		while(valid == false) {
			direction = sc.nextLine().toUpperCase();
		if(direction.equals("NORTH") || direction.equals("N")) {
			face = "North";
			valid = true;
		}else if(direction.equals("EAST") || direction.equals("E")){
			face = "East";
			valid = true;
		}else if(direction.equals("SOUTH") || direction.equals("S")){
			face = "South";
			valid = true;
		}else if(direction.equals("WEST") || direction.equals("W")) {
			face = "West";
			valid = true;
		}else {
			System.out.println("Invalid direction");
		}
		}
		//store x and y values in our row and column variables
		row = x;
		column = y;

}
	
	private static void moveRobot() {
		System.out.println("Move Robot");
		if(face.equals("North") && column < 4) {
			column++;
		}else if(face.equals("East") && row < 4) {
			row++;
		}else if(face.equals("South") && column > 0) {
			column--;
		}else if(face.equals("West") && row > 0) {
			row--;
		}
		else {
			System.out.println("Robot is on edge. View report to see position.");
		}
	}
	private static void leftRobot() {
		System.out.println("Left Robot");
		if(face.equals("North")) {
			face = "West";
		}else if(face.equals("East")) {
			face = "North";
		}else if(face.equals("South")) {
			face = "East";
		}else if(face.equals("West")) {
			face = "South";
		}
	}
	private static void rightRobot() {
		System.out.println("Right Robot");
		if(face.equals("North")) {
			face = "East";
		}else if(face.equals("East")) {
			face = "South";
		}else if(face.equals("South")) {
			face = "West";
		}else if(face.equals("West")) {
			face = "North";
		}
	}
	private static void reportRobot() {
		System.out.println("Report Robot");
		System.out.println("-------------------");
		
		System.out.println("ROW: " + row);
		System.out.println("COLUMN: " + column);
		System.out.println("FACE: " + face);
	}
	
}

	
			