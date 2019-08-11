import java.util.Scanner; 

public class Email{
	private String firstName; 
	private String lastName; 
	private String password; 
	private int defaultPasswordLength = 10; 
	private String department; 
	private String email; 
	private int mailboxCapacity = 500; 
	private String altEmail; 
	private String companySuffix = "company.com"; 

	// Constructor to recieve the first name and last name 
	public Email(String firstName, String lastName){
		this.firstName = firstName; 
		this.lastName = lastName;
		//System.out.println("Email created: " + this.firstName + " " + this.lastName); 
		
		// Call a method asking for the department - return the department 
		this.department = setDepartment(); 
		//System.out.println("Department: " + this.department); 
	
		// Call a method that returns a random passwd 
		this.password = genRanPasswd(defaultPasswordLength);
		//System.out.println("Your password is: " + this.password); 

		// Combine elements to generate e-mail 
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix; 
		//System.out.println("Your e-mail is: " + email); 
	
	}

	// Ask for the department 
	private String setDepartment(){
		System.out.print("Enter the department\n 1 for Sales \n 2 for Development \n 3 for Accounting \n 0 for none: "); 
		Scanner in = new Scanner(System.in); 
		int depChoice = in.nextInt(); 
		
		if(depChoice == 1)
			return "sales"; 
		else if(depChoice == 2) 
			return "dev"; 
		else if(depChoice == 3)
			return "acct"; 
		else 
			return ""; //empty string if there is not department  
	}

	// Generate a random passwd 
	private String genRanPasswd(int length){
		String passwdSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*"; 
		char[] password = new char[length]; 

		for(int i = 0 ; i < length; i++){
			int rand = (int) (Math.random() * passwdSet.length()); 
			password[i] = passwdSet.charAt(rand); 
		}

		return new String(password); 
	}

	// Set the mail capacity 
	public void setMailCapacity(int capacity){
		this.mailboxCapacity = capacity; 
	}

	// Set the alternative email 
	public void setAltEmail(String altEmail){
		this.altEmail = altEmail; 
	}

	// Change passwd 
	public void chngPasswd(String passwd){
		this.password = passwd; 
	}

	// Get mail box capacity 
	public int getMailCapacity(){ return this.mailboxCapacity; }
	public String getAltEmail(){ return altEmail; }
	public String getPasswd(){ return password; }

	//return info: name, email and mailbox capacity 
	public void showInfo(){
		System.out.println("DISPLAY NAME: " + firstName + "  " + lastName  + "\n" + 
			"COMPANY E-MAIL: " + email + "\n" + 
			"MALIBOX CAPACITY: " +  mailboxCapacity + "\n"); 
	}
}