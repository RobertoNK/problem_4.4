import java.util.Scanner;

public class CheckISBN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter ISBN: ");
		String originalISBN = input.nextLine();
		
		while(true) {
		int count = 0;
		for(int i = 0; i < originalISBN.length();i++) {
			if(originalISBN.charAt(i)=='-') {
				count++;
			}
			
		}
		if(originalISBN.length()!=13 || count!=3) {
			System.out.println("Re-enter ISBN: ");
			originalISBN=input.nextLine();
			break;
		}
		else {
			break;
		}
		}
		// Determine the location of dashes
		int dashPos1 = originalISBN.indexOf("-");
		int dashPos2 = originalISBN.indexOf("-",dashPos1+1);
		
		// Remove dashes from ISBN
		
		String reducedISBN = originalISBN.substring(0,dashPos1)+originalISBN.substring(dashPos1 + 1, dashPos2)+ originalISBN.substring(dashPos2 +1,11);
		
		// Compute the check digit for the ISBN
		
		int total2 = 0;
		for(int i =0; i<reducedISBN.length()-2;i++) {
			total2 = (reducedISBN.length()-i)*Integer.parseInt(reducedISBN.substring(i,i+1));
			
		}
		
	
		int checkDigit = 10 - ((total2 -1)%11);
		
		// Display the check digit entered by the user
		
		// Display the computed check digit
		
		final String DIGITS = "0123456789X";
		

		if(DIGITS.charAt(checkDigit)==originalISBN.charAt(12)) {
			System.out.println("ISBN is valid");
			
		}else {
			System.out.println("ISBN is not valid");
		}
	}

	

}
