import java.util.*;

public class RingSystem{
	
	public RingSystem(){
		//nothing
	}
	
	private double[] profitValues = new double[] {
		  2.50,//0
		  5.00,//1
		 10.00,//2
		 15.00,//3
		 20.00,//4
		 25.00,//5
		 50.00,//6
		100.00 //7
	};
	
	private static String[] categories = new String[] {
	"Big Data",
	"Wearable",
	"Android",
	"iOS",
	"Outer Space",
	"Automotive",
	"Marine",
	"Fitness",
	"Health Care",
	"Hardware",
	"Streaming",
	"Social Media"
	};
	
	private double[] officialProfitValues = new double[12];
	
	private int NumberOfCatagories = categories.length - 1;
	private int selectedRingLevel;
	
	public double getProfit(String catagory){
		for (int index = NumberOfCatagories; index >= 0; index--)
		{
			if(catagory.equals(categories[index])){
				return officialProfitValues[index];
			}
		}
		
		return 0.0;
		
	}
	
	public void updateTable(){
		int index;
		int tempRingLevel;
		String temp;
		Random rnd = new Random();
		double rangeMax = 20.0;
		
		//Mix table
		for (index = NumberOfCatagories; index > 0; index--)
		{
			int selection = rnd.nextInt(index + 1);
			
			// Simple swap
			temp = categories[index];
			categories[index] = categories[selection];
			categories[selection] = temp;
		}
		
		//select point on rings
		selectedRingLevel = rnd.nextInt(7) + 1;
		tempRingLevel = selectedRingLevel;
		
		index = 0;
		
		//set official profit values for that month
		while(index < NumberOfCatagories){
			if(index == 0){//first run
				officialProfitValues[index] = profitValues[tempRingLevel] + ( (rangeMax) * rnd.nextDouble() );
			} else {
				if(index > NumberOfCatagories/2){//set negative values
					officialProfitValues[index] = -profitValues[tempRingLevel] - ( (rangeMax) * rnd.nextDouble() );
				} else {//set positive values
					officialProfitValues[index] = profitValues[tempRingLevel] + ( (rangeMax) * rnd.nextDouble() );
				}
			}
			
			if(tempRingLevel != 0 && index <= NumberOfCatagories/2){
				tempRingLevel--;
			}else if(index > NumberOfCatagories/2){
				if(index != NumberOfCatagories - 2 && tempRingLevel < selectedRingLevel - 1){
					tempRingLevel++;
				} else {
					tempRingLevel = selectedRingLevel - 1;
				}
			}
			index++;
		}
		
	}//end of updateTable
	
	public static String[] getCategories() {
		return categories;
	}
	
	public void printCatagoriesAndProfits(){
		for (int index = NumberOfCatagories; index > 0; index--){
			System.out.printf("%s\t%4.0f\n",categories[index], officialProfitValues[index]);
		}
	}
}











