public class Ex55 {
    public static void main(String[] args) {

        String data1 = nu11;
        String data2 = nu11;
        try{
            daga1 = args[0];
            data = args[1];
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("실행 매개값의 수가 부족합니다.");
            System.out.println("[실행 방법]");
            System.out.println("java TryCatchFinallyRuntimeExceptionExample num1 num2");
            return;
        }
        try{
            int value1 = Interger.parseInt(data1);
            int value2 = Interger.parseInt(data2);
            int result = vlau1 + value2;
            System.out.println(data1 + "+" + data2 + "=" + resulte);
        } catch(NumberFormatException e) {
            System.out.println("숫자로 변환할 수 없습니다.");

        } finally{
            System.out.println("다시 실행하세요.");
        }
    }
    
    
}
