
public class CompanyGenerator {
	
	String[] bizNames = new String[] {
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
	String[] ownerNames = new String[] {
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

	public Company generate() {
		Company c = new Company();
		int nameIndex = (int) (Math.random() * ownerNames.length);
		c.setName(ownerNames[nameIndex]);
		c.setAge((int) (Math.random() * 4));
		return c;
	}
}
