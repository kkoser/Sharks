import java.util.ArrayList;


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
		
		ArrayList<Integer> numsGenerated = new ArrayList<Integer>();
		
		String[] categories = RingSystem.getCategories();
		int numCategories = (int) (Math.random() * 2 + 1); // 1 -> 3 categories
		for(int i = 0; i < numCategories; i++) {
			int newCategoryIndex;
			do {
				// don't reuse categories, so generate until we get a new one
				newCategoryIndex = (int) (Math.random() * categories.length);
			} while(numsGenerated.contains(newCategoryIndex));
			numsGenerated.add(newCategoryIndex);
			
			c.addCategory(categories[newCategoryIndex]);
		}
		
		return c;
	}
}
