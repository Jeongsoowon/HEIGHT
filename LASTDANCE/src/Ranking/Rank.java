package Ranking;

//import java.lang.reflect.Array;
import User.UserDAO;
import User.UserVO;
import java.util.ArrayList;
import java.util.List;
//import java.util.Collections;
//import java.util.Arrays;

public class Rank {
	private static int yourHeightRank;
	private static int totalNum;
	private static double percentile;
	
	public static double[] Return_Rank(UserVO uv, UserDAO ud) {
		List<Double> HeightTable = new ArrayList<Double>();
		List<Object> IdTable = new ArrayList<Object>();
		double[] Results = new double[2];
		ud.Insert_DB(uv);
		
		HeightTable = ud.Return_Height(uv);
		totalNum = HeightTable.size();
		int yourId = ud.Find_STONE(uv);
		IdTable = ud.Return_Id(uv);
		
		yourHeightRank = IdTable.indexOf(yourId) + 1;
		
		percentile = (double)yourHeightRank / (double)totalNum * 100;
		
		System.out.println("Your Rank is " + yourHeightRank + "(total : " + totalNum + ")");
		System.out.println("percent" + percentile + "%");
		
		
		
		ud.Delete_DB(ud.Find_STONE(uv));
		
		if(ud.Find_STONE(uv) == -1) {
			System.out.println("ERROR: Can't Find User's data.");
		}
		Results[0] = yourHeightRank;
		Results[1] = percentile;
		return Results;
		
		
	}

	
	public static void main(String[] args) {
		int age = 16;
		int sex = 1;
		double height = 174.1;
		UserVO uv = new UserVO(1, sex, age, height, 1);
		UserDAO ud = new UserDAO();
		double[] result = new double[1];
		result = Return_Rank(uv, ud);
		System.out.println(result[0]);
		System.out.println(result[1]);
		//System.out.println(Return_Rank(uv, ud));
		//System.out.println(Return_Percentile());
		
	}
}
