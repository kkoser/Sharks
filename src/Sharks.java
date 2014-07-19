import java.util.ArrayList;


public class Sharks {

	public static void main(String[] args) {
		Investor steve = new Investor( "Steve", 100000.00);
		GlobalModel model = new GlobalModel();
		System.out.println(getInvestorData(steve));
		
		while( true ) {
			steve.updateCompanies( model );
		}
	}
	
	public static String getInvestorData(Investor inv) {
		StringBuilder sb = new StringBuilder();
		sb.append("Name: " + inv.getName() + "\n");
		sb.append("Money: " + inv.getMoney() + "\n");
		ArrayList<Company> companies = inv.getCompanies();
		sb.append("Companies: ");
		for(Company c : companies) {
			sb.append(c.getName() + ", ");
		}
		return sb.toString();
	}
	
}
