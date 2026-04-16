package temp4;

public class C { public static void main(String[] args) {
    //B 객체 생성
    B dmbCellPhone = new B("자바폰", "검정", 10);

    //A로부터 상속 받은 필드
    System.out.println("모델:" + dmbCellPhone.model);
    System.out.println("색상:" + dmbCellPhone.color);

    //B의 필드
    System.out.println("채널:" + dmbCellPhone.channel);

    //A로부터 상속 받은 메소드 호출
    dmbCellPhone.powerOn();
    dmbCellPhone.bell();
    dmbCellPhone.sendVoice("여보세요");
    dmbCellPhone.receiveVoice("안녕하세요! 저는 홍길동인데요");
    dmbCellPhone.sendVoice("아~ 예 반갑습니다.");
    dmbCellPhone.hangUp();

    //B의 메소드 호출
    dmbCellPhone.turnOnDmb();
    dmbCellPhone.changeChannelDmb(12);
    dmbCellPhone.turnOffDmb();
}
    
}
