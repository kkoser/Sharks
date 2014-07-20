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
		ownerType = (int) (Math.random() * 5);
	}
	
	public String getPitch() {
		String catString = "";
		for( String s : getCategories() ) {
			catString += s + ", ";
		}
		
		switch( this.ownerType ) {
		case 0:
			return "Hello! I am here today to pitch my company " + getName() + ", and we are excited to revolutionize the " + catString + "industries!";
		case 1:
			return "Hi... I am here today to pitch my company " + getName() + ". We do work in the areas of " + catString +". PLease invest in us. Please...";
		case 2:
			return "Oh, what's the point. You aren't going to invest in me anyway.";
		case 3:
			return "Hey there! I'm here today to pitch you the biggest opportunity of your life. My company " + getName() + " is going to be the next big thing in " + catString + "! If you don't invest now, it's gonna cost you a lot more next round!";
		case 4:
			return "Farts";
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
