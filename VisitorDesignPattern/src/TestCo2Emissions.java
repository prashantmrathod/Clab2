public class TestCo2Emissions {
    public static void main(String[] args) {
        IVehicle car = new Car("Red", 2015) {
            @Override
            public int getNumberOfDoors() {
                return 0;
            }

            @Override
            public int getEngineCapacity() {
                return 0;
            }
        };
        IVehicle van = new Van(700, 5);
        IVehicle motorbike = new Motorbike(150, "Yamaha") {
            @Override
            public int getNumberOfDoors() {
                return 0;
            }

            @Override
            public int getEngineCapacity() {
                return 0;
            }
        };

        System.out.println(car);
        System.out.println("Car CO2 Emissions: " + car.co2Emissions());

        System.out.println(van);
        System.out.println("Van CO2 Emissions: " + van.co2Emissions());

        System.out.println(motorbike);
        System.out.println("Motorbike CO2 Emissions: " + motorbike.co2Emissions());
    }
}
