//규칙 처리
//도서 관련 로직



package BookRentalProject.Service;

import java.util.List;



public class BookService {

    BookDAO bookDAO = new BookDAO();

    //도서 검색
    public List<String> searchBook(String keyword) {

        return bookDAO.searchBook(keyword);
    }

    //도서 대여 가능 여부
    public boolean isAvailable(int bookId) {

        //DAO에서 상태 체크
        return true;
    }


    
}
