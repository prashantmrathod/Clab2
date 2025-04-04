import java.util.ArrayList;
import java.util.List;

public class AltMain {
    public static void main(String[] args) {

        String vi = System.getProperty("vi");

        System.out.println("System property 'vi': " + vi);

        if (vi == null || vi.isEmpty()) {
            System.out.println("No 'vi' system property provided. Defaulting to VehicleInspection.");
            vi = "default"; // Default value for 'vi'
        }

        AltVehicleService service = new AltVehicleService(vi);

        List<IVehicle> vehicles = new ArrayList<>();
        int totalCost = service.calculateTotal(vehicles.toArray(new IVehicle[0]));
        System.out.println("Total Service Charge: $" + totalCost);
    }
}
