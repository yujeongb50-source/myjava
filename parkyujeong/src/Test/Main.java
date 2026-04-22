package Test;
import java.util.Scanner; //키보드 입력 받기 위한 동구

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);   //Scanner 타입의 변수 sc를 선언(입력을 받는 도구를 담은 변수)
                                               //오른쪽에서 만든것을 왼쪽 변수에 넣는다
                                               //System.in = 키보드 입력

        
        BookManager manager = new BookManager(); //책 관리 기능 담당 객체 생성(추가, 출력, 파일 저장/불러오기)
                                                
    
        manager.loadFromFile();  //BookManager 클래스 안에 있는 loadFromFile() 기능을 실행한다
                                 //프로그램 껐다 켜면 데이터 사라지므로 파일> 다시 메모리 복구
    
        while (true) {   //프로그램 계속 실행

            // 메뉴 출력 (사용자 선택 화면)
            System.out.println("\n===== LIBRARY SYSTEM =====");
            System.out.println("1. 도서 등록");
            System.out.println("2. 도서 목록 조회");
            System.out.println("3. 저장 및 종료");
            System.out.print("선택 >> ");

            int menu = sc.nextInt();  //사용자가 키보드로 입력한 숫자를 menu변수에 저장

      
            // 1. 도서 등록
            if (menu == 1) {

                System.out.print("ID: ");
                int id = sc.nextInt(); //사용자가 입력한 "숫자"를 id변수에 저장
                sc.nextLine(); //줄바꿈 처리 //버퍼 비우기

                /* nextInt()는 "숫자"만 읽도록 설계된 메서드이므로 엔터는 읽지않고 버퍼에 남겨둠

                   Scanner는 입력을 공백 / 엔터 기준으로 잘라서 처리함

                   반대로 nextLine()은 버퍼에 있는 한 줄 전체를 처리(엔터포함)

                   줄바꿈 처리하지 않으면 다음 입력칸인 제목은 이미 누가 엔터를 쳐놓은 상태로 인식되어
                   제목이 출력되지 않고 빈칸으로 나옴
                 */

                System.out.print("제목: ");
                String title = sc.nextLine();  //사용자가 입력한 한 줄 전체 문자열 저장(엔터포함)

                System.out.print("저자: ");
                String author = sc.nextLine(); //사용자가 입력한 한 줄 전체 문자열 저장(엔터포함)

                
                manager.addItem(new Book(id, title, author)); 
                /*
                  객체 생성 + 저장
                  BookManager클래스에 있는 Books[count++] = book; 배열에 저장됨
      
                  1. 제목 입력 > title 저장
                  2. 저자 입력 > aughor 저장
                  3. Book 객체 생성
                  4. Manager로 전달
                  5. 배열에 저장

                 */

            }

         
            // 2. 목록 출력
            else if (menu == 2) {
                manager.displayAll();   //저장된 모든 책 출력
            }

            /* 
               1. 메뉴 2 선택
               2. BookManger클래스에 있는 displayAll() 호출
               3. books 배열 순회
               4. 책 정보 출력
             */

    


            // 3. 저장 후 종료
            else if (menu == 3) {
                manager.saveToFile();  //배열에 저장된 책을 파일에 저장
                System.out.println("저장 후 종료합니다.");
                break;  //while 반족 종료 > 프로그램 종료
            }

            else {
                System.out.println("잘못된 입력입니다.");
            }
        }

        sc.close();
    }
}


/*
  Main 클래스는 "기능 없음"

  역할 >>> 1. 사용자 입력 받기 2. Manager에 전달

  Main은 사용자와 시스템(BookManager)을 연결해주는 역할

  ==================================================

  <전체 구조>

  사용자  >  Main(입력 처리)  >  BookManager(로직)  >  Book(데이터)  >  파일(저장)
 */