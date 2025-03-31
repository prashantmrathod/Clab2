public class AltVehicleInspection implements IVehicleInspector {
    @Override
    public int visit(Car car) {

        int serviceCharge = 0;
        if (car.getColor().equalsIgnoreCase("Red")) {
            serviceCharge += 150;
        } else {
            serviceCharge += 75;
        }
        System.out.println("Alt Service Charge for Car: " + serviceCharge);
        return serviceCharge;
    }

    @Override
    public int visit(Van van) {

        int serviceCharge = 0;
        if (van.getNumberOfDoors() > 3) {
            serviceCharge += 400;
        } else {
            serviceCharge += 200;
        }
        System.out.println("Alt Service Charge for Van: " + serviceCharge);
        return serviceCharge;
    }

    @Override
    public int visit(Motorbike motorbike) {

        int serviceCharge = 0;
        if (motorbike.getEngineCapacity() >= 150) {
            serviceCharge += 250;
        } else {
            serviceCharge += 100;
        }
        System.out.println("Alt Service Charge for Motorbike: " + serviceCharge);
        return serviceCharge;
    }
}
