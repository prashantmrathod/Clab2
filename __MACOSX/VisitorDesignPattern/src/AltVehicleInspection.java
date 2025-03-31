// AltVehicleInspection.java
public class AltVehicleInspection implements IVehicleInspector {
    @Override
    public float visit(Car car) {
        return 75.0f;  // Different fee for cars
    }

    @Override
    public float visit(Van van) {
        return 125.0f; // Different fee for vans
    }

    @Override
    public float visit(Motorbike motorbike) {
        return 50.0f;  // Different fee for motorbikes
    }
}
