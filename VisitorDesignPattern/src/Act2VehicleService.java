import java.util.List;

public class Act2VehicleService {
    private static final Act2VehicleService INSTANCE;
    private final IVehicleInspector inspector;

    static {
        String vi = System.getProperty("vi");
        IVehicleInspector inspector = VehicleFactory.getVehicleInspector(vi);
        INSTANCE = new Act2VehicleService(inspector);
    }

    private Act2VehicleService(IVehicleInspector inspector) {
        this.inspector = inspector;
    }

    public static Act2VehicleService getInstance() {
        return INSTANCE;
    }

    public float calculateTotal(List<IVehicle> vehicles) {
        float total = 0;
        for (IVehicle vehicle : vehicles) {
            total += vehicle.accept(inspector);
        }
        return total;
    }
}
