// Java practice with instance variables, set Methods and get Methods and classes

// Account class with a name instance variable and methods to set and get its value
public class Account { // every public class must be stored in a file with the same name
	// 'public' or 'private' are access modifiers. Private classes are only accessible to ethods and classes in which they are declared 
	private String name; // This is an instance variable

// this is a method to set the name in the object
	public void setName(String name) {
		this.name = name; //stores the name

	}
//this is a method to retrieve the name from the object
	public String getName() { //must return type declared after 'public'
		return name; // returns the value of name 
	}

}
public void main Account (){
	//this is a constructor. You are constructing a new class, Account.
	Account myAccount = new Account();

}