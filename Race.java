import java.security.SecureRandom;



//RaceCar class that has a position private variable with setter getter and movement methods
//The RaceCar objects represent the contenders racing when they are instantiated in the main class 
class RaceCar{
	
	
	
	private int position;
	
	RaceCar(){
		this.position = 1;
	}
	
	int getPosition() {
		return this.position;
	}
	void movePosition(int position) {
		this.position += position;
		
	}
	void setPosition(int position) {
		this.position = position;
	}
	
}




public class Race {
	//overides the toString() method
	public String toString() {
		return "Race simulation class";
	}
	//static variable that represents the finish variable which causes the while loop to end
	static int finish = 100;
	
	//prints the racetrack and the positions of both Racers
	static void printStatus(int count, RaceCar RacerOne, RaceCar RacerTwo){
		int ROne = RacerOne.getPosition() * 2;
		int RTwo = RacerTwo.getPosition() * 2;
		
		System.out.printf("Time: %d\n", count);
		if(count == 0) {
			System.out.printf("%s%n", "B");
			
		}
		else if(ROne/2 == finish && RTwo/2 != finish){
			System.out.printf("%"+ RTwo + "s%n", "R2");
		}
		else if(RTwo/2 == finish && ROne/2 != finish){
			System.out.printf("%"+ ROne + "s%n", "R1");
		}
		
		else {
			if(ROne == RTwo)
				System.out.printf("%" + (ROne - 1) + "s%n", "B");
			else if(ROne < RTwo) {
				System.out.printf("%"+ ROne + "s", "R1");
				System.out.printf( "%" + (RTwo - ROne) + "s%n", "R2");
			}
			else {
				System.out.printf("%"+ RTwo + "s", "R2");
				System.out.printf( "%" + (ROne - RTwo) + "s%n", "R1");
			}
		}
			

		 for(int i = 1; i <= 100; i++) {
			 
			 System.out.printf("%s", "_ ");
		 }
		 System.out.print('\n');
	}
	//main function
	public static void main(String[] args){
		
		
		System.out.print("On Your Mark, Get Set, Go");
		
		//Create a Secure Random object called roulette so that I can produce pseudo random numbers
		SecureRandom roulette = new SecureRandom();
		//instantiate the Racecar class to make two racer objects
		RaceCar RacerOne = new RaceCar();
		RaceCar RacerTwo = new RaceCar();
		//the count is used to record the amount of seconds and so that B starts at 1 when you call printStatus() the 
		//first time
		int count = 0;
			//loop that iterates until one of the RaceCar object's position is at 100
			while(RacerOne.getPosition()  < finish && RacerTwo.getPosition() < finish){
			
			//call print status method to print the race track and the car positions on the track
			printStatus(count, RacerOne, RacerTwo);
			//gets a new random number
			int result = roulette.nextInt(10) + 1;
			//use switch statement on the random number to change to cars position 
			switch(result) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				RacerOne.movePosition(3);
				break;
			case 6:
			case 7:
			case 8:
				if(RacerOne.getPosition() > 6) {
					RacerOne.movePosition(-6);
					break;
				}
				else {
					RacerOne.setPosition(1);
					break;
				}
			case 9:
			case 10:
				RacerOne.movePosition(1);
				break;
			
			}
			switch(result) {
			case 1:
			case 2:
			case 3:
			case 4:
				RacerTwo.movePosition(1);
				break;
			case 5:
			case 6:
				if(RacerTwo.getPosition() > 2) {
					RacerTwo.movePosition(-2);
					break;
				}
				else {
					RacerTwo.setPosition(1);
					break;
				}
					
			case 7:
			case 8:
				RacerTwo.movePosition(5);
				break;
			case 9:
				RacerTwo.movePosition(0);
				break;
			case 10:
				if(RacerTwo.getPosition() > 10) {
					RacerTwo.movePosition(-10);
					break;
				}
				else {
					RacerTwo.setPosition(1);
					break;
				}
			}
		count++;
		//these make sure that the car position is never greater than 100
		if(RacerOne.getPosition() > finish)
			RacerOne.setPosition(finish);
		if(RacerTwo.getPosition() > finish)
			RacerTwo.setPosition(finish);
		
		}
		//print status after the car reaches 100 so that the winning car does not pass the last tile
		printStatus(count, RacerOne, RacerTwo);
		
		//prints the winning message depending on which racer won
		if(RacerOne.getPosition() > RacerTwo.getPosition())
			System.out.printf("%s\n", "Runner1 wins.");
		
		else if(RacerOne.getPosition() == RacerTwo.getPosition())
			System.out.printf("IT's A TIE");
		else
			System.out.printf("%s\n", "Runner2 wins.");
		
		System.out.printf("Time Elapsed = %d%s", count, " seconds");
}
	}	
