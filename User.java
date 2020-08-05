package Height_DB;

public class User {
	private int userId;
	private int userSex;
	private int userAge;
	private double userHeight;
	private int STONE = 1;
	public User(int userId, int userSex, int userAge, double userHeight) {
		this.userId = userId;
		this.userSex = userSex;
		this.userAge = userAge;
		this.userHeight = userHeight;
		this.STONE = STONE;
	}
	public int getSTONE() {
		return STONE;
	}
	
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getUserSex() {
		return userSex;
	}
	
	public void setUserSex(int userSex) {
		this.userSex = userSex;
	}
	public int getUserAge() {
		return userAge;
	}
	
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public double getUserHeight() {
		return userHeight;
	}
	
	public void setUserHeight(double userHeight) {
		this.userHeight = userHeight;
	}


}