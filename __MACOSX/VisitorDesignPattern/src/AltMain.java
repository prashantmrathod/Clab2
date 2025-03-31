// AltMain.java
public class AltMain {
    public static void main(String[] args) {
        // Read the system property "vi"
        String viProperty = System.getProperty("vi");

        // Create AltVehicleService, passing in the property
        AltVehicleService service = new AltVehicleService(viProperty);

        // Example usage (replace with your actual vehicle data)
        Car car = new Car(2017, 5);
        Van van = new Van(2018, 4);
        Motorbike motorbike = new Motorbike(2024, 100);

        List<IVehicle> vehicles = new ArrayList<>();
        vehicles.add(car);
        vehicles.add(van);
        vehicles.add(motorbike);

        float total = service.calculateTotal(vehicles);
        System.out.println("Total inspection cost: " + total);
    }
}
