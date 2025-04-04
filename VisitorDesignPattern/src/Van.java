public class Van implements IVehicle {
    private int storageCapacity;
    private int numberOfDoors;

    public Van(int storageCapacity, int numberOfDoors) {
        this.storageCapacity = storageCapacity;
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public int accept(IVehicleInspector inspector) {
        return inspector.visit(this);
    }

    @Override
    public float co2Emissions() {
        // Formula: 8887 * (1 + (0.1 * (numberOfDoors - 2)))
        return 8887 * (1 + (0.1f * (numberOfDoors - 2)));
    }

    @Override
    public int getNumberOfDoors() {
        return 0;
    }

    @Override
    public int getEngineCapacity() {
        return 0;
    }

    @Override
    public String toString() {
        return "Van{storageCapacity=" + storageCapacity + ", numberOfDoors=" + numberOfDoors + "}";
    }
}
