package temp7;

public class SupersonicAirplaneExampl {

    public static void main(String[] args) {
        SupersonicAirplane sa = new SupersonicAirplane();
        sa.takdOff();
        sa.fly();
        sa.flyMode = SupersonicAirplane.SUPERSONIC;
        sa.fly();
        sa.flyMode = SupersonicAirplane.NORMAL;
        sa.fly();
        sa.land();
    }
    
}
