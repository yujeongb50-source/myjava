package Test;

public class Book {
    private int id;         
    private String title;
    private String author;


    //생성자 
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    // Getter (외부 접근용)
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    
    }

    @Override
     public String toString() {   //객체를 문자열로 바꿔서 반환하는 메서드
        return id + " | " + title + " | " + author;  //객체를 보기 좋은 문자열로 반환

        /* toString >> 사람이 읽기 쉬운 문자열로 반환하는 기능
           (없으면 이상한 주소값 출력)
        */
}
}
