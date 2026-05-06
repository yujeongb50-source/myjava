//사용자 화면




package BookRentalProject.Service;



import java.util.Scanner;
import BookRentalProject.Service.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MemberService memberService = new MemberService();
        RentalService rentalService = new RentalService();
        BookService bookService = new BookService();

        String loginId = null;

        while (true) {

            System.out.println("===== 도서 대여 시스템 =====");
            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            System.out.println("3. 도서 검색");
            System.out.println("4. 도서 대여");
            System.out.println("5. 도서 반납");
            System.out.println("0. 종료");

            System.out.print("선택 >> ");
            int menu = sc.nextInt();
            sc.nextLine();

            
            if (menu == 1) {
                System.out.print("ID: ");
                String id = sc.next();
                System.out.print("PW: ");
                String pw = sc.next();

                boolean result = memberService.login(id, pw);

                if (result) {
                    loginId = id;
                    System.out.println("로그인 성공");
                } else {
                    System.out.println("로그인 실패");
                }

            } else if (menu == 2) {

                System.out.print("ID: ");
                String id = sc.next();
                System.out.print("PW: ");
                String pw = sc.next();
                System.out.print("이름: ");
                String name = sc.next();
                System.out.print("전화번호: ");
                String phone = sc.next();
                

                memberService.register(id, pw, name, phone);
                System.out.println("회원가입 완료");

            } else if (menu == 3) {

                System.out.print("검색어: ");
                String keyword = sc.nextLine();

                System.out.println(bookService.searchBook(keyword));

            } else if (menu == 4) {

                if (loginId == null) {
                    System.out.println("로그인 먼저 하세요");
                    continue;
                }

                System.out.print("책 번호: ");
                int bookId = sc.nextInt();

                try {
                    rentalService.rentBook(loginId, bookId);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } else if (menu == 5) {

                System.out.print("대여번호: ");
                int rentalId = sc.nextInt();

                rentalService.returnBook(rentalId);

            } else if (menu == 0) {
                System.out.println("종료");
                break;
            }
        }

        sc.close();
    }

}
    

