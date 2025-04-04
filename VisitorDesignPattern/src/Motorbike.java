public abstract class Motorbike implements IVehicle {
    private int engineCapacity;
    private String brand;

    public Motorbike(int engineCapacity, String brand) {
        this.engineCapacity = engineCapacity;
        this.brand = brand;
    }

    @Override
    public int accept(IVehicleInspector inspector) {
        return inspector.visit(this);
    }

    @Override
    public float co2Emissions() {
        // Formula: 8887 * (1 + (0.01 * (100 - engineCapacity)))
        return 8887 * (1 + (0.01f * (100 - engineCapacity)));
    }

    @Override
    public String toString() {
        return "Motorbike{engineCapacity=" + engineCapacity + ", brand='" + brand + "'}";
    }
}