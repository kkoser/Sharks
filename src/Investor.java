import java.util.ArrayList;

public class Investor {
	private String name;
	private double money;
	private ArrayList<Company> companies;
	
	public Investor(String name, double money) {
		this.name = name;
		this.money = money;
		companies = new ArrayList<Company>();
	}
	
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
	
	
	public void updateCompanies( RingSystem model ) {
		for( Company c : getCompanies() ) {
			for( String cat : c.getCategories() ) {
				final double change = (1 + (model.getProfit( cat ) / c.getCategories().size() ) );
				c.setValue( c.getValue() * change );
				double investmentChange = c.getInvestedAmount() * change;
				setMoney( getMoney() + investmentChange - c.getInvestedAmount() );
				c.setInvestedAmount( investmentChange );
			}
		}
	}
}
