package Height_DB;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Height_Ranking {
	public static void Ranking(User user) {
		// HeightTable : DB 의 Height Table 표현 
		List<Double> HeightTable = new ArrayList<Double>();
		List<Object> IdTable = new ArrayList<Object>();
		User_Height uh = new User_Height();
		
		
		
		
		
		
		// user data insert
		uh.Insert_DB(user);
		HeightTable = uh.Return_Height(user);
		
		int totalNum = HeightTable.size();
		int yourID = uh.Find_STONE(user);
		
		IdTable = uh.Return_Id(user);
		int yourHeightRank = IdTable.indexOf(yourID) + 1;
		System.out.println(yourID);
		System.out.println(totalNum);
		System.out.println(yourHeightRank);
		
		
		double fracNumber =( (double)yourHeightRank / (double)totalNum);
		double percentile = (fracNumber * 100);
		double highRank_percentile = (100- percentile);
		
		for(int i = 0; i<= totalNum - 1; i++) {
			System.out.println("#" + (i+1) + " height: " + HeightTable.get(i));
		}
		System.out.println("Your rank is " + yourHeightRank + "(total : " + totalNum + ")");
		System.out.println("The high percentile of your height is " + percentile + "%");
		//uh.Delete_DB(uh.Find_STONE(user));
		
	}
	
	public static void main(String[] args) {
		double userHeight = 170.2;
		int userAge = 23;
		if(userAge > 19 && userAge <26) userAge = 27;
		User user = new User(9691, 1, userAge, userHeight);
		
		if(userAge > 123 || userHeight > 243) System.out.println("Error! 장난치지마슈!");
		else Ranking(user);
	}

}
