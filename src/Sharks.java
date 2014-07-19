
public class Sharks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( "Hellow World!" );
		
		Investor steve = new Investor( 100000.00, "Steve" );
		GlobalModel model = new GlobalModel();
		while( true ) {
			steve.updateCompanies( model );
		}
	}
	
	public String getStatusData() {
		return "blank data";
	}
	
}
