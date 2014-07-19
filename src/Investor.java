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
		companies = new ArrayList<Company>();
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
			for( String cat : c.getCategories() ) {
				c.setValue( c.getValue() * model.getChangeForCategory( cat ) );
			}
		}
	}
	
	
}
