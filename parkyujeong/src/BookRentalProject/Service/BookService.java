
//도서 관련 로직



package BookRentalProject.Service;

import java.util.List;
import BookRentalProject.Dao.BookDAO;



public class BookService {

    // DOA 객체 생성 ( Service가 DB 기능을 쓰기 위해 )
    BookDAO bookDAO = new BookDAO();

    //도서 검색
    //List<String> 문자열 리스트 반환
    public List<String> searchBook(String keyword) {

        return bookDAO.searchBook(keyword);
    }

    //도서 대여 가능 여부
    public boolean isAvailable(int bookId) {

        //DAO에서 상태 체크
        return bookDAO.isAvailable(bookId);
    }


    
}
