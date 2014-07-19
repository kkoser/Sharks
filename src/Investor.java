import java.util.ArrayList;

public class Investor {
	private ArrayList<Company> companies;
	private double money;
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Investor( double initialMoney, String name ) {
		this.setMoney( initialMoney );
	}
	
	public ArrayList<Company> getCompanies() {
		return companies;
	}
	public void setCompanies(ArrayList<Company> companies) {
		this.companies = companies;
	}
	
	public double getMoney() {
		return money;
	}
	
	public void setMoney(double money) {
		this.money = money;
	}
	
	
	public void updateCompanies( GlobalModel model ) {
		for( Company c : getCompanies() )
		{
			double change = model.getChangeForCategory( c.getCategory1() );
			change += model.getChangeForCategory( c.getCategory2() );
			double newVal = c.getValue() * change;
			c.setValue( newVal );
		}
	}
	
	
}
