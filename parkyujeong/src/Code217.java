
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Code217 {
    
    public static void main(String[] args){

        FileInputStream fis = null;
        byte b[] = new byte[50];
        try{

            fis = new FileInputStream("D:/yujeong/java/myjava/parkyujeong/src/data1.txt");
            fis.read(b);
            for (byte x : b)
            System.out.print((char)x);
        }
        catch(FileNotFoundException e) {
            System.out.println("data1.txt는 없는 파일입니다.");
        }
    catch(IOException e) {
        System.out.println(e);
    }
    finally{
        try{
            fis.close();
        }
        catch (IOException e){
            System.out.println(e);
        }
        catch(NullPointerException e){
            System.out.println("fis가 null값을 갖고 있습니다.");
        }
    }
    }
}
