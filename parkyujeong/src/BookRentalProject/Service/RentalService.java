//규칙 처리




package BookRentalProject.Service;

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

        System.out.println("대여 완료");
    }

    public void returnBook(int rentalId) {

        // 1. 반납 처리
        rentalDAO.returnBook(rentalId);
    
        System.out.println("반납 완료");
        public void myPage(String memberId) {

            int count = rentalDAO.countRental(memberId);
        
            System.out.println("현재 대여 수: " + count);
        }
    }
}