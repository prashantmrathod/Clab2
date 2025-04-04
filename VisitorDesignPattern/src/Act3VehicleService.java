import java.util.List;

public class Act3VehicleService {
    private static final Act3VehicleService INSTANCE;
    private final IVehicleInspector inspector;
    private final IEmissionsStrategy emissionsStrategy;

    // Static initialization block to configure the singleton instance
    static {
        // Read system property "vi" to determine which IVehicleInspector to use
        String vi = System.getProperty("vi");
        IVehicleInspector inspector = VehicleFactory.getVehicleInspector(vi);

        // Read system property "es" to determine which IEmissionsStrategy to use
        String es = System.getProperty("es");
        IEmissionsStrategy strategy;

        // Determine the appropriate emissions strategy based on the "es" property
        if (es == null || es.isEmpty()) {
            System.out.println("System property 'es' not provided. Defaulting to NullEmissionsStrategy.");
            strategy = new NullEmissionsStrategy(); // Default strategy
        } else {
            switch (es.toLowerCase()) {
                case "one":
                    System.out.println("Using OneEmissionsStrategy.");
                    strategy = new OneEmissionsStrategy();
                    break;
                case "two":
                    System.out.println("Using TwoEmissionsStrategy.");
                    strategy = new TwoEmissionsStrategy();
                    break;
                default:
                    System.out.println("Invalid value for 'es'. Defaulting to NullEmissionsStrategy.");
                    strategy = new NullEmissionsStrategy(); // Default strategy for invalid input
            }
        }

        // Initialize the singleton instance with the selected configurations
        INSTANCE = new Act3VehicleService(inspector, strategy);
    }

    // Private constructor to prevent external instantiation
    private Act3VehicleService(IVehicleInspector inspector, IEmissionsStrategy emissionsStrategy) {
        this.inspector = inspector;
        this.emissionsStrategy = emissionsStrategy;
    }

    // Public method to access the singleton instance
    public static Act3VehicleService getInstance() {
        return INSTANCE;
    }

    /**
     * Calculates the total cost for all vehicles, including service charges and emissions fees.
     *
     * @param vehicles List of vehicles to process.
     * @return The total cost.
     */
    public float calculateTotal(List<IVehicle> vehicles) {
        float total = 0;

        for (IVehicle vehicle : vehicles) {
            // Calculate emissions fee using the Strategy pattern
            int emissionsFee = emissionsStrategy.computeEmissionsFee(vehicle);

            // Calculate service charge using the Visitor pattern
            int serviceCharge = vehicle.accept(inspector);

            // Add both fees to the total
            total += emissionsFee + serviceCharge;
        }

        return total;
    }
}
