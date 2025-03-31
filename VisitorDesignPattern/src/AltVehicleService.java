import java.util.List;  // Import the List class

public class AltVehicleService {

    private IVehicleInspector inspector;

    public AltVehicleService(String viProperty) {
        // Use the VehicleFactory to get the appropriate inspector
        this.inspector = VehicleFactory.getVehicleInspector(viProperty);
    }

    public float calculateTotal(List<IVehicle> vehicles) {
        float total = 0;
        for (IVehicle vehicle : vehicles) {
            total += vehicle.accept(inspector);
        }
        return total;
    }
}
