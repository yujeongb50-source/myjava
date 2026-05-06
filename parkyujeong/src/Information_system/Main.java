package Information_system;


import java.util.Scanner;
import Information_system.MemberService;
import Information_system.MemberDAO;
import Information_system.Member;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MemberService memberService = new MemberService();

        String loginId = null;

        
        while (true) {

            System.out.println("===== 회원 관리 시스템 =====");
            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            System.out.println("3. 종료");

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

                memberService.register(id, pw, name);
                System.out.println("회원가입 완료");
               

            } else if (menu == 3) {
                System.out.println("종료");
                break;

            }
}

sc.close();


}

    }
