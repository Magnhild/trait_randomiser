package main.java;
import java.util.InputMismatchException;
import java.util.Scanner;
import main.java.TraitRandomiser;

public class UserInput {
	
	// Attributes
	private static Scanner inputScanner;
	
	public static void main(String[] args) {
		
		TraitRandomiser randomiser = new TraitRandomiser();
		
		// Create scanner to read input from user
		inputScanner = new Scanner(System.in);

		Trait trait = null;
		
	    // Perform trait generation
	    do {
	
	      int nature = retrieveNatureFromUser();
	      int category = retrieveCategoryFromUser();
	      
  	      // Perform trait generation
  		  trait = randomiser.generateTrait(nature, category);
  		  
  		  if (trait != null) {
  			  
  			  // Print out the random trait
  		      System.out.println(trait.getName());
  		      System.out.println();  		
  		  }
  		  
	     
	    } while (confirmGenerateAgain());
	}
	
	private static int retrieveNatureFromUser() {

		int userNature = 4;

		// Read user choice of trait nature and validate it is correct
		boolean validInput = false;
		do {

			// Ask for user input of trait nature
			System.out.println("Which nature would you prefer?");
			System.out.println("1. Good");
			System.out.println("2. Neutral");
			System.out.println("3. Bad");
			System.out.println("4. Random");

			// Read user input and validate it is numerical
			try {

				userNature = inputScanner.nextInt();
				inputScanner.nextLine();
				validInput = true;

			} catch (InputMismatchException ex) {

				System.out.println("Input must be numerical!");
				inputScanner.nextLine();
				validInput = false;
			}

			if (!validInput) {

				break;
			}

			// Check if user input is a valid selection
			switch (userNature) {
			case 1:
				validInput = true;
				break;
			case 2:
				userNature = 0;
				validInput = true;
				break;
			case 3:
				userNature = -1;
				validInput = true;
				break;
			case 4:
				validInput = true;
				break;

			default:
				System.out.println("Input should be '1', '2', '3' or '4'");
				validInput = false;
				break;
			}

		} while (!validInput);
		
		return userNature;
	}

	private static int retrieveCategoryFromUser() {
		
		int userCategory = 5;

		// Read user choice of trait category and validate it is correct
		boolean validInput = false;
		do {

			// Ask for user input of trait nature
			System.out.println("Which category would you prefer?");
			System.out.println("1. Lifestyle");
			System.out.println("2. Social");
			System.out.println("3. Emotional");
			System.out.println("4. Hobby");
			System.out.println("5. Random");

			// Read user input and validate it is numerical
			try {

				userCategory = inputScanner.nextInt();
				inputScanner.nextLine();
				validInput = true;

			} catch (InputMismatchException ex) {

				System.out.println("Input must be numerical!");
				inputScanner.nextLine();
				validInput = false;
			}

			if (!validInput) {

				break;
			}

			// Check if user input is a valid selection
			switch (userCategory) {
			case 1:
				userCategory = 1;
				validInput = true;
				break;
			case 2:
				userCategory = 2;
				validInput = true;
				break;
			case 3:
				userCategory = 3;
				validInput = true;
				break;
			case 4:
				userCategory = 4;
				validInput = true;
				break;
			case 5:
				userCategory = 5;
				validInput = true;
				break;
			default:
				System.out.println("Input should be '1', '2', '3', '4' or '5'");
				validInput = false;
				break;
			}

		} while (!validInput);
		
		return userCategory;		
	}
	
	private static boolean confirmGenerateAgain(){

	    boolean generateAgain = false;
	
	    // Ask user if they wish to generate another trait
	    boolean inputIsYesOrNo;
	    do {
	
	      // Check if user would like another trait
	      System.out.println("Would you like another? (Y/n)");
	
	      // Read their response
	      String userResponse = inputScanner.nextLine();
	
	      // Check if input is empty
	      if ((userResponse.trim()).equals("n")) {
	
	        generateAgain = false;
	        inputIsYesOrNo = true;
	
	      } else if ((userResponse.trim()).equals("y")) {
	
	        generateAgain = true;
	        inputIsYesOrNo = true;
	
	      } else {
	
	        System.out.println("Input should be 'y' or 'n'");
	        inputIsYesOrNo = false;
	      }
	
	    } while (!inputIsYesOrNo);
	
	    return generateAgain;
	  }

}
