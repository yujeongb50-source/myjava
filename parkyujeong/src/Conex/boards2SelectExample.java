package Conex;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class boards2SelectExample {

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
            "SELECT bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata " +
            "FROM boards " +
            "WHERE bwriter=?";

            //PreparedStatement 얻기 및 값 지정
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"winter");

            //SQL문 실행 후, ResultSet을 통해 데이터 읽기
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                //데이터 행을 읽고 Board 객체 생성
                Boards2 board = new Boards2();
                board.setBno(rs.getInt("bno"));
                board.setBtitle(rs.getString("btitle"));
                board.setBwriter(rs.getString("bwriter"));
                board.setBdate(rs.getDate("bdate"));
                board.setBfilename(rs.getString("bfilename"));
                board.setBfiledata(rs.getBlob("bfiledata"));

                //콘솔에 출력
                System.out.println(board);

                //파일로 저장
                Blob blob = board.getBfiledata();
                if(blob != null) {
                    InputStream is = blob.getBinaryStream();
                    OutputStream os = new FileOutputStream("C:/Temp/"+board.getBfilename());
                    is.transferTo(os);
                    os.flush();
                    os.close();
                    is.close();
                }
            }
            rs.close();

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


            




    
