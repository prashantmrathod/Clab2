abstract class Car implements IVehicle {
    private Object color;
    private int manufactureYear;

    public Car(String color, int manufactureYear) {
        this.color = color;
        this.manufactureYear = manufactureYear;
    }

    @Override
    public int accept(IVehicleInspector inspector) {
        return inspector.visit(this);
    }

    @Override
    public float co2Emissions() {
        // Formula: 8887 * (1 + (0.05 * (2020 - manufactureYear)))
        return 8887 * (1 + (0.05f * (2020 - manufactureYear)));
    }

    @Override
    public String toString() {
        return "Car{color='" + color + "', manufactureYear=" + manufactureYear + "}";
    }

    public Object getColor() {
        return color;
    }

    public void setColor(Object color) {
        this.color = color;
    }
}