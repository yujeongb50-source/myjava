public class Ex44 {public static void main(String[] args){
    Teat09 myCar = new Teat09();

    myCar.setGas(5); //Teat09의 setGas() 메소드 호출

    boolean gasState = myCar.isLeftGas(); //Teat09의 isLefgGas()메소드 호출
    if(gasState){
        System.out.println("출발합니다.");
        myCar.run(); //Teat09의 run() 메소두 호출
    }

    if(myCar.isLeftGas()){
    System.out.println("gas를 주입할 필요가 없습니다.");
}else{
    System.out.println("gas를 주입하세요.");
}
}
}
