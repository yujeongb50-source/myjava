package Conex;


import java.io.FileInputStream;
import java.sql.Connection; //DB 연결
import java.sql.DriverManager; //연결 생성
import java.sql.PreparedStatement; //SQL 실행
import java.sql.ResultSet; // 결과 받기
import java.sql.SQLException;

public class Users {

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
         " InSERT INTO users (userid, username, userpassword, userage, useremail )" +
         " VALUES (SEQ_BNO.NEXTVAL, ?, ?, ?, ?)";
          //SEQ_BNO 시퀀스 이름 
          //NEXTVAL "다음 값"을 의미 (현재 시퀀스 값 + 1)



         //PreparedStatement 얻기 및 값 지정
         PreparedStatement pstmt = conn.prepareStatement(sql);
         pstmt.setString(1,"박유정");
         pstmt.setString(2,"1234");
         pstmt.setInt(3,30);
         pstmt.setString(4,"dbwjddl0263@naver.com");
         

         //SQL문 실행
         int rows = pstmt.executeUpdate();
         System.out.println("저장된 행 수:" + rows);

    
    
         

         //PreparedStatement 닫기
         pstmt.close();
        } catch(Exception e) {
            e.printStackTrace();
        }finally{
            if(conn != null) {
                try{
                    //연결 끊기
                    conn.close();
                }catch(SQLException e) {}
            }
        }
}
}

    

