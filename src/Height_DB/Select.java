package Height_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Select {
	public static String[] Show_allitems() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String[] result2 = new String[9686];
		
		int i = 0;
		try {
			// 드라이버 로
			Class.forName("com.mysql.jdbc.Driver");
			// 연
			String url="jdbc:mysql://localhost/HEIGHT?useSSL=false";
			conn = DriverManager.getConnection(url, "root", "845284");
			
			// 쿼리 수행을 위한 STATAMENT 객체 생성
			
			stmt = conn.createStatement();
			
			// 쿼리 작성
			// 주의사항
            // 1) JDBC에서 쿼리를 작성할 때는 세미콜론(;)을 빼고 작성한다.
            // 2) SELECT 할 때 * 으로 모든 칼럼을 가져오는 것보다
            //   가져와야 할 칼럼을 직접 명시해주는 것이 좋다.
            // 3) 원하는 결과는 쿼리로써 마무리 짓고, java 코드로 후작업 하는 것은 권하지 않음
            // 4) 쿼리를 한 줄로 쓰기 어려운 경우 들여쓰기를 사용해도 되지만 띄어쓰기에 유의 !!
			String sql = "SELECT sex, age, height from height_object";
			
			// 쿼리 수행
			rs = stmt.executeQuery(sql);
			
			// 실행 결과 출력
			
			while(rs.next()) {
				//int id = rs.getInt(1);
				int sex = rs.getInt(1);
				int age = rs.getInt(2);
				double height = rs.getDouble(3);
				
				
				result2[i] = "|" + sex + "|" + age + "|" + height+ "|";
				System.out.println(result2[i]);
				i++;
				
				
				
			}
		}
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}
		catch(SQLException e) {
			System.out.println("에러"+e );
		}
		finally {
			try {
				if(conn != null && !conn.isClosed()) {
					conn.close();
				}
				if(stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
				if(rs != null && !rs.isClosed()) {
					rs.close();
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result2;
	}
	
	public static void main(String[] args) {
		Show_allitems();
	}

}