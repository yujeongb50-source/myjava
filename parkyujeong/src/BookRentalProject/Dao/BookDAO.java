//DB 연결
//도서 검색/도서 상태 변경을 담당하는 DAO


package BookRentalProject.Dao;

import java.sql.Connection; //DB와 연결
import java.sql.PreparedStatement; //SQP을 안전하게 실행
import java.util.List; //여러 개 결과를 담기 위한 
import java.util.ArrayList; //List를 실제로 구현
import java.sql.ResultSet; //SELECT 결과를 담는 객체( 표 형태 데이터 )


public class BookDAO { 

    // DB와 연결 객체( DBConnection에서 받아옴 )
    Connection conn = new DBConnection().gConnection();
    
    
    private int bookId;

    //도서 검색 기능 ( 제목으로 검색 )
    public List<String> searchBook(String keyword) {
        
        // 검색 결과를 저장할 리스트 ( 책 제목들 저장 )
        List<String> list = new ArrayList<>();

        try{

            // SQL 작성 : 제목에 keyword가 포함된 책 검색
            String sql = "SELECT * FROM BOOK WHERE TITLE LIKE ?";

            // SQL 실행 준비
            PreparedStatement ps = conn.prepareStatement(sql);

            // ? 자리에 값 넣기 ( %keyword% -> 부분 검색)
            ps.setString(1, "%" + keyword + "%");

            // SELECT 실행 -> 결과를 ResultSet으로 받음
            ResultSet rs = ps.executeQuery();

            // 결과가 여러 행일 수 있으므로 반복
            while(rs.next()) {

                // 현재 행의 TITLE 컬럼 값을 list에 추가
                list.add(rs.getString("TITLE"));
            }

        } catch (Exception e) {
            // DB 오류, SQL 오류 등 발생 시 출력
            e.printStackTrace();
        }

        // 검색 결과 리스트 반환
        return list;
    }

    // 도서 상태 변경 (대여 불가)
    public void updateUnavailable(int bookId) { 

        try {

            // 특정 책을 대여 불가 상태로 변경 
            String sql = "UPDATE BOOK SET IS_AVAILABLE = 'N' WHERE BOOK_ID = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, bookId);

            // UPDATE 실행 ( DB 값 변경 )
            ps.executeUpdate();

        } catch (Exception e) {

            // 오류 발생 시 출력
            e.printStackTrace();
        }
    }
}