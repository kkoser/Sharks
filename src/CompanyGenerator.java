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
		int ownerNameIndex = (int) (Math.random() * ownerNames.length);
		String ownerName = ownerNames[ownerNameIndex];
		
		int bizNameIndex = (int) (Math.random() * bizNames.length);
		String bizName = bizNames[bizNameIndex];
		
		int age = (int) (Math.random() * 18); // 0 -> 18 months old
		int valuation = (int) (Math.random() * 900 + 100); // 100 -> 1000
		int investedAmount = 0;
		
		ArrayList<Integer> numsGenerated = new ArrayList<Integer>();
		
		String[] allCategories = RingSystem.getCategories();
		ArrayList<String> categories = new ArrayList<String>();
		
		int numCategories = (int) (Math.random() * 2 + 1); // 1 -> 3 company categories
		for(int i = 0; i < numCategories; i++) {
			int newCategoryIndex;
			do {
				// don't reuse categories, so generate until we get a new one
				newCategoryIndex = (int) (Math.random() * allCategories.length);
			} while(numsGenerated.contains(newCategoryIndex));
			numsGenerated.add(newCategoryIndex);
			
			categories.add(allCategories[newCategoryIndex]);
		}
		
		return new Company(bizName, valuation, investedAmount, age, ownerName, categories);
	}
}
