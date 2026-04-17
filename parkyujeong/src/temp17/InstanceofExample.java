package temp17;

public class InstanceofExample {

    public static void main(String[] args) {
        Taxi taxi = new Taxi();
        Bus bus = new Bus();

        ride(taxi);
        System.out.println();
        ride(bus);
    }

    public static void ride(Vehicle vehicle){

        if(vehicle instanceof Bus){
            Bus bus = (Bus) vehicle;
            bus.checFare();
        }

        vehicle.run();
    }
    
}
