public interface IVehicle {
    int accept(IVehicleInspector inspector);
    float co2Emissions(); // New method for calculating CO2 emissions

    int getNumberOfDoors();

    int getEngineCapacity();
}
