package Test;

public interface Manageable {  //인터페이스 전체 의미 
                               //도서 관리 시스템이 반드시 기능 구현해야 하는 규칙

    void addItem(Book book);   //책 추가
    void displayAll();         //전체 목록 출력
    void saveToFile();         //파일 저장
    void loadFromFile();       //파일 불러오기
    
    
}




/*인터페이스 
1. 구조 통일 (모든 관리 클래스가 같은 기능을 갖게 됨)
2. 결합도 감소 (Main은 BookManager 내부를 몰라도 됨, 유연성 증가, 유지보수 쉬움)
3. 확장성 (모두 같은 구조로 만들  수 있음) */