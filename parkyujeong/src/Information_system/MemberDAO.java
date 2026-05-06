package Information_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class MemberDAO {

    // DB 연결 객체 생성
    Connection conn = new connection().gConnection();

    // 회원가입
    public void insertMember(String id, String pw, String name) {

        try{

            // 회원 정보 삽입 ( 가입일은 SYSDATE, 연체여부 기본 'N')
            // INSERT INTO = 테이블에 새로운 데이터 행을 넣는다
            String sql = "INSERT INTO TBL_MEMBER VALUES (?, ?, ?, SYSDATE)";

            // SQL 실행 준비
            PreparedStatement ps = conn.prepareStatement(sql);

            // ? 값 채우기
            ps.setString(1, id);
            ps.setString(2, pw);
            ps.setString(3,name);
 
            // INSERT 실행
            ps.executeUpdate();
        } catch (Exception e) {

            // 에러 발생 시 출력
            e.printStackTrace();
        }
    }

    // 로그인 
    public boolean login(String id, String pw) {

        boolean result = false; // 로그인 성공 여부 ( 로그인 기본 상태를 "실패"로 두고 조건이 맞을 시 TRUE로 바꾸기 위한 안전한 초기값)

        try {
            
            // ID와 비밀번호가 일치하는 회원 조회
            String sql = "SELECT * FROM TBL_MEMBER WHERE ID = ? AND PASSWORD = ?";

            // SQL 준비
            PreparedStatement ps = conn.prepareStatement(sql);

            // 값 설정
            ps.setString(1, id);
            ps.setString(2, pw);

            // SELECT 실행 ( ResultSet: DB조회 결과를 담는 표 형태 객체)
            // ( executeQuery : SELECT조회 / executeUpdate : INSERT,UPDATE,DELETE )
            ResultSet rs = ps.executeQuery(); 

            // 조건에 맞는 사람이 DB존재하면 로그인 성공처리
            if(rs.next()) {
                result = true;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        

        return result;
    }
}

    

