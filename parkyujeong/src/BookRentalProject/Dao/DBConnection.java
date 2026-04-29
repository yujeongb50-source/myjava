//DB 연결 전용 클래스 (데이터베이스 접속만 담당)



package BookRentalProject.Dao;

import java.sql.Connection; // 연결 통로
import java.sql.DriverManager; // 연결 공장 역할
import java.sql.SQLException; // SQL 관련 예외 처리용

public class DBConnection {

    public Connection gConnection(){
        // DB 연결 객체를 반환하는 메서드
        // (다른 DAO들이 이걸 호출해서 DB 사용함)

        Connection conn = null;
        // DB 연결 객체를 저장할 변수 (처음에는 아무 연결 없음)
        
        try{
            //JDBC Driver 등록  ( Oracle DB 사용 준비)
            Class.forName("oracle.jdbc.OracleDriver");
    
            //연결하기 (DB 로그인)
            conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "system",
                "1234"
            );
    } catch (Exception e) {
        // 연결 실패 시 예외 처리
        e.printStackTrace();
        // 에러 내용 출력 
    }
    
    // 생성된 DB 연결 객체 반환
    return conn;
    }
    }
    
    

