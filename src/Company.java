import java.util.ArrayList;


public class Company {
	private String name;
	private double value;
	private double investedAmount;
	private String ownerName;

	private int ownerType;
	private int age;
	public ArrayList<String> categories;
	
	public Company(String name, double val, double invested, int age, String owner, ArrayList<String> categories) {
		this.name = name;
		this.value = val;
		this.investedAmount = invested;
		this.age = age;
		this.ownerName = owner;
		this.categories = categories;
		ownerType = (int) (Math.random() * 9);
	}
	
	public String getPitch() {
		String catString = "";
		int numCategories = getCategories().size();
		for(int i = 0; i < numCategories; i++) {
			if(i != 0 && numCategories > 2) {
				catString += ", ";
			}
			if(i == numCategories - 1 && numCategories > 1) {
				if(numCategories == 2) {
					catString += " ";
				}
				catString += "and ";
			}
			catString += getCategories().get(i);
		}
		
		switch( this.ownerType ) {
		case 0:
			return "Hello! I am here today to pitch my company " + getName() + ", and we are excited to revolutionize the " + catString + "industries!";
		case 1:
			return "Hi... I am here today to pitch my company " + getName() + ". We do work in the areas of " + catString +". PLease invest in us. Please...";
		case 2:
			return "My company is awesome! It's called " + getName() + " and we work on " + catString + "! Invest!";
		case 3:
			return "Big data, HTML5, lawlcatz, Angular. Buzz words are all over here at " + getName() + " we're the next big thing in " + catString + "!";
		case 4:
			return "Get yo' computing on at " + getName() + "! Yo, yo, we do " + catString + "!";
		case 5:
			return "Take care of all your freakin' " + catString + " needs here at " + getName() + "!";
		case 6:
			return "Who kicks butt at " + catString + "? " + getName() + " does!";
		case 7:
			return "Here at " + getName() + ", we love our users, along with " + catString + "!";
		case 8:
			return "At " + getName() + " need your financial help to help fund adventures in " + catString + "!";
		case 9:
			return "Don't worry, " + getName() + " bans Facebook and Reddit for all employees! Invest in " + catString + "!";
		}
		
		return "";
	}
	
	public void investMoney( double money ) {
		setInvestedAmount( money );
	}
	
	public ArrayList<String> getCategories() {
		return categories;
	}
	
	public void setCategories(ArrayList<String> c) {
		categories = c;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public double getInvestedAmount() {
		return investedAmount;
	}
	
	public void setInvestedAmount(double investedAmount) {
		this.investedAmount = investedAmount;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getOwnerType() {
		return ownerType;
	}

	public void setOwnerType(int ownerType) {
		this.ownerType = ownerType;
	}
}
