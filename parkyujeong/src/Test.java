import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        System.out.print("사칙연산을 고르세요");
        String strX = scanner.nextLine();
      
        if(strX.equals("+")){
            System.out.print("y 값 입력:");
            String strY = scanner.nextLine();
            int y = Integer.parseInt(strY);
            
            System.out.print("i 값 입력:");
            String stri = scanner.nextLine();
            int i = Integer.parseInt(stri);

            int t =y+i;
            System.out.print("더하기 결과는:"+t);
        }

        else if(strX.equals("-")){
            System.out.print("y 값 입력:");
            String strY = scanner.nextLine();
            int y = Integer.parseInt(strY);
            
            System.out.print("i 값 입력:");
            String stri = scanner.nextLine();
            int i = Integer.parseInt(stri);

            int t =y-i;
            System.out.print("빼기 결과는:"+t);
        }

        else if(strX.equals("*")){
            System.out.print("y 값 입력:");
            String strY = scanner.nextLine();
            int y = Integer.parseInt(strY);
            
            System.out.print("i 값 입력:");
            String stri = scanner.nextLine();
            int i = Integer.parseInt(stri);

            int t =y*i;
            System.out.print("곱하기 결과는:"+t);
        }
        else if(strX.equals("/")){
            System.out.print("y 값 입력:");
            String strY = scanner.nextLine();
            int y = Integer.parseInt(strY);
            
            System.out.print("i 값 입력:");
            String stri = scanner.nextLine();
            int i = Integer.parseInt(stri);

            int t =y/i;
            System.out.print("나누기 결과는:"+t);
        }


        while(true){
            System.out.print("종료하시겠습니까:");
            String data = scanner.nextLine();
            if(data.equals("q")){
                break;
            }
            System.out.println("출력 문자열:" + data);
            System.out.println();
        }
        System.out.println("종료되었습니다");


       
    }
}
