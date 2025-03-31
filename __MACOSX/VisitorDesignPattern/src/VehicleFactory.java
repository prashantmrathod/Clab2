// VehicleFactory.java
public class VehicleFactory {

    private VehicleFactory() {
        // Private constructor to prevent instantiation
    }

    public static IVehicleInspector getVehicleInspector(String prop) {
        if ("alt".equals(prop)) {
            return new AltVehicleInspection();
        } else {
            return new VehicleInspection();
        }
    }
}
