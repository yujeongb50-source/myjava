package Conex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;   

public class Delete {

    public static void main(String[] args) {
        Connection conn = null;

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
            String sql = "DELETE FROM users WHERE userid = ?";

            //PreparedStatement 얻기 및 값 지정
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "9");

            //SQL문 실행
            int rows = pstmt.executeUpdate();
            System.out.println("삭제된 행 수 : " + rows);

            //PreparedStatement 닫기
            pstmt.close();
           }catch (Exception e) {
            e.printStackTrace();

           } finally{
            if(conn != null) {
                try { 
                    //연결 끊기
                    conn.close();
                } catch(SQLException e) {}
            }
           }
        }
    }