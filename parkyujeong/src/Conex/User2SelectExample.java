package Conex;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.tools.StandardLocation;

public class User2SelectExample {

    public static void main(String[]args) {
        Connection conn = null; //DB 연결 담는 변수

        try{
            //JDBC Driver 등록  ( Oracle DB 사용 준비)
            Class.forName("oracle.jdbc.OracleDriver");

            //연결하기 (DB 로그인)
            conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "system",
                "1234"
            );

            
            //매개변수화된 SQL문 작성
            String sql = "" +
            "SELECT userid, username, userpassword, userage, useremail " +
            "FROM users " +
            "WHERE userid=?";

            //PreparedStatement 얻기 및 값 지정
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"박유정");

            //SQL문 실행 후, ResultSet을 통해 데이터 읽기
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                Users2 user = new Users2();
                user.setUserId(rs.getString("userid"));
                user.setUserName(rs.getString("username"));
                user.setUserPassword(rs.getString("userpassword"));
                user.setUserAge(rs.getInt("userage"));
                user.setUserEmail(rs.getString("useremail"));
                System.out.println(user);
            

            } else {
                System.out.println("사용자 아이디가 존재하지 않음");
            }
            rs.close();

            //PreparedStatement 닫기
            pstmt.close();
        } catch(Exception e) {
            e.printStackTrace();
        } finally{
            if(conn != null) {
                try {
                    //연결 끊기
                    conn.close();
                } catch(SQLException e){}
            }
        }
    }
}



