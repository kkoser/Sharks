import java.util.ArrayList;

public class Investor {
	private ArrayList<Company> companies;
	private int money;
	
	public ArrayList<Company> getCompanies() {
		return companies;
	}
	public void setCompanies(ArrayList<Company> companies) {
		this.companies = companies;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
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
