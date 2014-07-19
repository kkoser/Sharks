import java.util.ArrayList;


public class Company {
	private String name;
	private String type;
	private double value;
	private double investedAmount;
	private int ownerType;
	private int age;
	public ArrayList<String> categories;
	
	public Company(String n, String t, double v, double iA, ArrayList<String> c) {
		name = n;
		type = t;
		value = v;
		investedAmount = iA;
		categories = c;
		ownerType = (int) (Math.random() * 5);
	}
	
	public String getPitch() {
		String catString = "";
		for( String s : getCategories() ) {
			catString += s;
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
			return "
		}
		
		return "";
	}
	
	public void investMoney( double money ) {
		setInvestedAmount( money / getValue() );
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
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
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
}
