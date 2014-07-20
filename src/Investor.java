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
				System.out.println("Profit change: " + model.getProfit(cat) );
				c.setValue( c.getValue() * (1 + (model.getProfit( cat ) / c.getCategories().size() ) ) );
				double investmentChange = c.getInvestedAmount() * (1 + (model.getProfit( cat ) / c.getCategories().size() ) );
				System.out.println( investmentChange);
				setMoney( getMoney() + investmentChange );
				c.setInvestedAmount( c.getInvestedAmount() + investmentChange );
			}
		}
	}
}
