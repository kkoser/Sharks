import java.util.ArrayList;
import java.util.Scanner;


public class Sharks {

	public static void main(String[] args) {
		Investor steve = new Investor( "Steve", 100000.00);
		GlobalModel model = new GlobalModel();
		CompanyGenerator generator = new CompanyGenerator();
		System.out.println(getInvestorData(steve));
		
		Scanner scan = new Scanner(System.in);
		
		while( true ) {
			ArrayList<Company> newCompanies = new ArrayList<Company>();
			for(int i = 0; i < 5; i++ ) {
				Company c = generator.generate();
				newCompanies.add( c );
				System.out.println( i + ". " + c.getPitch() );
			}
			
			System.out.println( "Enter the number of the company you would like to invest in, or -1 to finish." );
			int choice = scan.nextInt();
			while( choice != -1 ) {
				if( choice > newCompanies.size() ) {
					System.out.println( "That is an invalid number, please enter again.");
					choice = scan.nextInt();
					continue;
				}
				
				Company comp = newCompanies.get(choice);
				System.out.println( "How much would you like to invest in " + comp.getName() + "? They are currently worth " + comp.getValue() + " and you have " + steve.getMoney() );
				double investment = scan.nextDouble();
				comp.investMoney( investment );
				steve.setMoney( steve.getMoney() - investment );
				steve.getCompanies().add(comp);
				
				System.out.println( "Please enter another company, or -1 to finish." );
				choice = scan.nextInt();
				
			}
			
			System.out.println(" Moving on to the next month!" );
			steve.setMoney( steve.getMoney() + 10000 );
			
			
			steve.updateCompanies( model );
		}
		
		//scan.close();
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
