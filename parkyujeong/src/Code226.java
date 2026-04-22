
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Code226 {
    public static void main(String[]args)
    {
        BufferedInputStream bis = null;
        try{

            bis = new BufferedInputStream(new FileInputStream("D:/yujeong/java/myjava/parkyujeong/src/data6.txt"));
            int x = 0;
            while((x = bis.read()) != -1)
            System.out.println((char)x);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try{
                bis.close();
            }
            catch(IOException e){
                System.out.println(e);
            }
        }
    }
    
}
