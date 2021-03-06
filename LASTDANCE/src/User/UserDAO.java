package User;

//import User.UserVO;
import java.sql.*;
//import java.lang.reflect.Array;
import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.Comparator;
import java.util.List;

public class UserDAO {
	private static String dbURL = "jdbc:mysql://172.30.1.220/HEIGHT?useSSL=false";
	private static String dbID = "MS";
	private static String dbPassword = "123456";
	private static Connection conn;
	private static Statement stmt;
	private static ResultSet rs;
	private static PreparedStatement pstmt;
	
	
	// Display DB's all items
	public void Display_DB(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			stmt = conn.createStatement();
			
			String sql = "SELECT id ,age, sex, height, stone FROM height_object";
			
			rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				int id = rs.getInt(1);
				int sex = rs.getInt(2);
				int age = rs.getInt(3);
				double height = rs.getDouble(4);
				int stone = rs.getInt(5);
				System.out.println(id + " " + sex + " " + age +" " + height + " " + stone);
			}
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}catch(SQLException e) {
			System.out.println("에러" + e);
		}finally {
			try {
				if(conn != null && !conn.isClosed()) conn.close();
				if(stmt != null && !stmt.isClosed()) stmt.close();
				if(rs != null && !rs.isClosed()) rs.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	
	}
	// Display Height items
	public static void Display_Height(UserVO user){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			
			
			String sql = "SELECT height FROM height_object WHERE age=" + user.getUserAge() + " && "+  "sex=" + user.getUserSex();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				double height = rs.getDouble(1);
				System.out.println(height);
			}
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}catch(SQLException e) {
			System.out.println("에러" + e);
		}finally {
			try {
				if(conn != null && !conn.isClosed()) conn.close();
				if(stmt != null && !stmt.isClosed()) stmt.close();
				if(rs != null && !rs.isClosed()) rs.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	
	}	
	
	// Return Height items
	public List<Double> Return_Height(UserVO user){
		List<Double> Results = new ArrayList<Double>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			
			
			String sql = "SELECT height, stone FROM height_object WHERE age=" + user.getUserAge() + " && "+  "sex=" + user.getUserSex() + " ORDER BY height DESC";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				double height = rs.getDouble(1);
				Results.add(height);
				
			}
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}catch(SQLException e) {
			System.out.println("에러" + e);
		}finally {
			try {
				if(conn != null && !conn.isClosed()) conn.close();
				if(stmt != null && !stmt.isClosed()) stmt.close();
				if(rs != null && !rs.isClosed()) rs.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return Results;
		
	
	}
	public List<Object> Return_Id(UserVO user){
		List<Object> Results = new ArrayList<Object>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			
			
			String sql = "SELECT id FROM height_object WHERE age=" + user.getUserAge() + " && "+  "sex=" + user.getUserSex() + " ORDER BY height DESC";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				int id = rs.getInt(1);
				Results.add(id);
				
			}
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}catch(SQLException e) {
			System.out.println("에러" + e);
		}finally {
			try {
				if(conn != null && !conn.isClosed()) conn.close();
				if(stmt != null && !stmt.isClosed()) stmt.close();
				if(rs != null && !rs.isClosed()) rs.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return Results;
		
	
	}
	

	

	
	// Insert item into DB
	public void Insert_DB(UserVO user) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			String sql = "INSERT INTO height_object (age, sex, height, stone) VALUES (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			//pstmt.setInt(1, user.getUserId());
			pstmt.setInt(1, user.getUserAge());
			pstmt.setInt(2, user.getUserSex());
			pstmt.setDouble(3, user.getUserHeight());
			pstmt.setInt(4, user.getSTONE());
			
			int count = pstmt.executeUpdate();
			if(count == 0) System.out.println("데이터 입력 실패");
			else System.out.println("데이터 입력 성공");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}catch(SQLException e) {
			System.out.println("에러" + e);
		}finally {
			try{
                if( conn != null && !conn.isClosed()){
                    conn.close();
                }
                if( pstmt != null && !pstmt.isClosed()){
                    pstmt.close();
                }
            }
            catch( SQLException e){
                e.printStackTrace();
            }
		}
		
	}
	
	// Delete item from DB 
	public void Delete_DB(int ID) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			String sql = "DELETE FROM height_object WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, ID);
			
			int r = pstmt.executeUpdate();
			System.out.println("변경된 row : " + r);
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}catch(SQLException e) {
			System.out.println("에러" + e);
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// Find new items
	public int Find_STONE(UserVO user){
		int id = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			
			
			String sql = "SELECT id FROM height_object WHERE stone = 1";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				id = rs.getInt(1);
				//System.out.println(id);
				
				
				
				
			}
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}catch(SQLException e) {
			System.out.println("에러" + e);
		}finally {
			try {
				if(conn != null && !conn.isClosed()) conn.close();
				if(stmt != null && !stmt.isClosed()) stmt.close();
				if(rs != null && !rs.isClosed()) rs.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return id;
	
	}


	public static void main(String[] args) {
		// Insert 예제 
		//UserVO use1= new UserVO(0, 1, 16, 160, 1);
		//System.out.println(use1.getUserAge());
	   // Insert_DB(use1);
		
		// Delete 예제
		// User user = new User(9696, 1, 19, 174.2);
		// Delete_DB(user);
		
		// Display_Height 예제
		// User user = new User(9686, 1, 11, 174.2);
		// Display_Height(user);
		
		// Return_Height 예제
		// User user = new User(9691, 1, 11, 174.2);
		
		//Return_Height(user);
		
		//Find_stone 예
		// System.out.println(Find_STONE(user));
		
		// Return_ID 예제
		// System.out.println(Return_Id(user));
		//Display_DB();
	}
}
