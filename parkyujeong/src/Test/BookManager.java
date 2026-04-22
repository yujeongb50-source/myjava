package Test;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;


public class BookManager implements Manageable{   //BookManager = 책관리 담당 클래스
                                                  //Manageable = 반드시 기능 구현해야 하는 규칙    


    Book[ ] books = new Book[100];  //Book 객체 100개 저장 가능

    int count = 0;  //현재 저장된 책 개수

   private String fileName = "book.txt";  //저장/불러오기 파일 이름 




    
    @Override
    public void addItem(Book book){    //addItem(항목 추가)
                                       //책 1개 추가 기능


        if (count >= books.length) {  //배열 꽉 찼는지 검사

            System.out.println("더 이상 등록할 수 없습니다.");
            return;
        }

    books[count++] = book;  //현재 위치에 저장
                            //저장 후 count 증가


    System.out.println("등록 완료"); }



    @Override
    public void displayAll() {   //displayAll(전체 출력)
        
        if (count == 0) {  //책이 하나도 없으면 메시지 츌력
            System.out.println("등록된 도서가 없습니다.");
            return;
        }

        System.out.println("ID | 제목 | 저자");
        System.out.println("----------------------");
       


        
        for (int i = 0; i < count; i++) {  //저장된 개수만큼 반복
            System.out.println(
                books[i].getId() + " | " +  //Book 객체에서 데이터 꺼내기
                books[i].getTitle() + " | " +
                books[i].getAuthor()
            );
        }  
    }

    @Override
    public void saveToFile() {    //saveToFile(파일 저장)
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) { 
            
            /*BufferdWriter bw (데이터를 임시저장 했다가 한 번에 출력) 
             BufferedWriter >>>> FileWriter >>>> 파일(book.txt)
             BufferedWriter는 "포장지"
             FileWriter가 "실제 파일 출력 담당" */


            for (int i = 0; i < count; i++) {
                bw.write(books[i].getId() + "," +
                         books[i].getTitle() + "," +
                         books[i].getAuthor());
                bw.newLine();
            }

            System.out.println("파일 저장 완료");

        } catch (IOException e) {
            System.out.println("저장 실패");
        }
    }
                
    

    @Override
    public void loadFromFile() {   //loadFromFile(파일 불러오기)
        
        
        File file = new File(fileName);  //파일 존재 확인  

        if (!file.exists()) {  //파일 없으면 종료 (exists는 파일이나 폴더가 실제로 존재하는지 확인하는 메서드)

            System.out.println("기존 데이터 없음");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            /*BufferdReader br (데이터를 임시저장 했다가 한 번에 읽음) 
             BufferdReader >>>> FileReader >>>> 파일(book.txt)
             BufferdReader는 "포장지"
             FileReader가 "실제 파일 열기 담당" */  


            String line; // 파일에서 읽어온 데이터를 한 줄씩 읽을 변수

            count = 0; // 중요: 중복 방지 (기존에 있던 count 초기화)

            while ((line = br.readLine()) != null) { //더 이상 읽을게 없을때까지 반복

                String[] data = line.split(","); //line.split(line 문자열을 콤마 기준으로 나누어서 배열 반환 메서드)

                /* 파일에서 읽어온 데이터는 전부 문자열이라서 필요한 타입(int/String)에
                  맞게 나누고 변환하는 과정
                 */

                int id = Integer.parseInt(data[0]); //문자열을 숫자로 반환
                String title = data[1];
                String author = data[2];

                books[count++] = new Book(id, title, author);
            }

            System.out.println("데이터 로드 완료");

        } catch (IOException e) { //e = 에러 정보 객체
            System.out.println("불러오기 실패");
        }
    } 
}


/* try-catch 없으면 >>> 파일 없을 시 프로그램 바로 종료(에러)
 * try-catch 있으면 >>> 오류발생 시 catch 실행하여 프로그램 계속 실행 가능
 
 @@@ try-catch는 오류가 발생해도 프로그램이 종료되지 않도록 예외를 처리하는 구조
 @@@ try는 위험한 코드 실행, catch는 위험코드 발생 시 처리하는 불록
 */
 

