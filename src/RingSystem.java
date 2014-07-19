import java.util.*;

public class RingSystem{
	
	public RingSystem(){
		//nothing
	}
	
	private double[] profitValues = new double[] {
		0.0250,//0
		0.0500,//1
		0.1000,//2
		0.1500,//3
		0.2000,//4
		0.2500,//5
		0.5000,//6
		1.0000 //7
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
		double rangeMax = 0.20;
		
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











