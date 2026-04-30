// 렌탈 관련 로직




package BookRentalProject.Service;

import BookRentalProject.Dao.RentalDAO;
import BookRentalProject.Dao.BookDAO;

public class RentalService {

    RentalDAO rentalDAO = new RentalDAO();
    BookDAO bookDAO = new BookDAO();

    // 📖 도서 대여
    public void rentBook(String memberId, int bookId) throws Exception {

        // 1. 대여 제한 (3권)
        int count = rentalDAO.countRental(memberId);

        if (count >= 3) {
            throw new Exception("대여 가능 권수 초과 (최대 3권)");
        }

        // 2. 도서 대여 실행
        rentalDAO.rentBook(memberId, bookId);

        // 3. 도서 상태 변경
        bookDAO.updateUnavailable(bookId);


        System.out.println("대여 완료 (도서 ID: " + bookId + ")");
    }

    public void returnBook(int rentalId) {

        // 1. 해당 대여의 bookId 조회
        int bookId = rentalDAO.findBookIdByRentalId(rentalId);

        // 2. 반납 처리
        rentalDAO.returnBook(rentalId);

        // 3. 도서 상태 복구
        bookDAO.updateAvailable(bookId);
    
        System.out.println("반납 완료"); 
    }

    
    }
