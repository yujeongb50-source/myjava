//DB 연결
//도서 대여/반납/대여수 체크를 담당하느 DAO



package BookRentalProject.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class RentalDAO {

    // DB 연결
    Connection conn = new DBConnection().gConnection();

    // 도서 대여
    public void rentBook(String memberId, int bookId ) {

        try {

            // 대여 정보 INSERT( 7일 대여 )
            String sql = """
                    INSERT INTO RENTAL
                    VALUES (SEQ_RENTAL.NEXTVAL, ?, ?, SYSDATE, STSDATE + 7, NULL, 'N')
                    """;

                    // SQL 실행 준비
                    PreparedStatement ps = conn.prepareStatement(sql);

                    // 값 널기
                    ps.setString(1,memberId); // 회원 ID
                    ps.setInt(2, bookId); // 책 ID

                    // INSERT 실행
                    ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 현재 대여 중인 책 개수 ( 반납 안 한 것 )
    public int countRental(String memberId) {

        int count = 0;

        try { 

            // 반납 안 된 대여 수 조회
            String sql = "SELECT COUNT(*) FROM RENTAL WHERE MEMBER_ID = ? AND RETURN_DATE IS NULL";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, memberId);

             // SELECT 실행 ( ResultSet: DB조회 결과를 담는 표 형태 객체)
            // ( executeQuery : SELECT조회 / executeUpdate : INSERT,UPDATE,DELETE )
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                count = rs.getInt(1);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    // 반납처리
    public void returnBook(int rentalId) {

        try {

            // 반납 날짜를 현재 시각으로 업데이트
            String sql = "UPDATE RENTAL SET RETURN_DATE = SYSDATE WHERE RENTAL_ID = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, rentalId);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int findBookIdByRentalId(int rentalId) {

        int bookId = 0;

        try{
            String sql = "SELECT BOOK_ID FROM RENTAL WHERE RENTAL_ID = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, rentalId);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                bookId = rs.getInt("BOOK_ID");

            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return bookId;
    } 
    public List<String> getRentalList(String memberId) {
        List<String> list = new ArrayList<>();

        try{
            String sql = "SELECT * FROM RENTAL WHERE MEMBER_ID = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, memberId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(
                    "RENTAL_ID: " + rs.getInt("RENTAL_ID") +
                    ", BOOK_ID " + rs.getInt("BOOK_ID")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;


    }

   
    }
    

