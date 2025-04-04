public class VehicleFactory {

    private VehicleFactory() {
    }
    public static IVehicleInspector getVehicleInspector(String type) {
        if ("alt".equalsIgnoreCase(type)) {
            System.out.println("Creating AltVehicleInspection instance...");
            return new AltVehicleInspection();
        } else {
            System.out.println("Creating VehicleInspection instance...");
            return new VehicleInspection();
        }
    }

    private record AltVehicleInspection() implements IVehicleInspector {
        @Override
        public int visit(Car car) {
            return 0;
        }

        @Override
        public int visit(Van van) {
            return 0;
        }

        @Override
        public int visit(Motorbike motorbike) {
            return 0;
        }
    }
}
