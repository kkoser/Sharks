import java.util.ArrayList;


public class Company {
	private String name;
	private String type;
	private double value;
	private double investedAmount;
	public ArrayList<String> categories;
	
	public Company(String n, String t, double v, double iA, ArrayList<String> c) {
		name = n;
		type = t;
		value = v;
		investedAmount = iA;
		categories = c;
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
}
