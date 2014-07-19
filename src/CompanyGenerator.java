
public class CompanyGenerator {
	
	public static String[] bizNames = new String[] {
			"Pear",
			"Foot",
			"Pottle",
			"Tech Nights",
			"Jimbob",
			"Real",
			"Cheetah",
			"Eagle",
			"Hooped",
			"Hole-in-One",
			"FakeProduct",
			"Popcorn",
			"BigMama",
			"DropTable",
			"FireEaters",
			"Jank"
	};
	
	// todo: fix the all-male sexism
	public static String[] ownerNames = new String[] {
			"Steve",
			"Bill",
			"Jim",
			"Bob",
			"Ed",
			"Craig",
			"Lex",
			"Frank",
			"Stan",
			"Neo",
			"Sean",
			"Jack",
			"Matt",
			"Paul",
			"Scott",
			"Tom",
			"Ryan",
			"Mark",
			"Jake",
			"Zack"
	};

	public static Company generate() {
		Company c = new Company();
		int ownerNameIndex = (int) (Math.random() * ownerNames.length);
		c.setOwnerName(ownerNames[ownerNameIndex]);
		int bizNameIndex = (int) (Math.random() * bizNames.length);
		c.setName(bizNames[bizNameIndex]);
		c.setAge((int) (Math.random() * 18));
		c.setValue((int) (Math.random() * 900000 + 100000)); // 100,000 -> 1,000,000
		c.setInvestedAmount(0);
		
		String[] categories = RingSystem.getCategories();
		int categoryIndex = (int) (Math.random() * categories.length);
		c.setType(categories[categoryIndex]);
		
		return c;
	}
}
