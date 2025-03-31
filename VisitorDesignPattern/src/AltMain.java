// AltMain.java
public class AltMain {
    public static void main(String[] args) {
        // Read the system property "vi"
        String viProperty = System.getProperty("vi");

        // Create AltVehicleService, passing in the property
        AltVehicleService service = new AltVehicleService(viProperty);

        // ... rest of your AltMain code ...
    }
}
