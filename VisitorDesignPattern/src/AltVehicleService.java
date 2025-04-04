public class AltVehicleService {
    private IVehicleInspector inspector;

    public AltVehicleService(String viType) {
        // Use VehicleFactory to dynamically create the appropriate inspector
        this.inspector = VehicleFactory.getVehicleInspector(viType);
    }
    public int calculateTotal(IVehicle[] vehicles) {
        int total = 0;
        for (IVehicle vehicle : vehicles) {
            total += vehicle.accept(inspector); // Use the dynamically created inspector
        }
        return total;
    }
}
