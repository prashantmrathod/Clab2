import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Act3Main {
    public static void main(String[] args) {
        List<IVehicle> vehicles = new ArrayList<>();

        String filePath = System.getProperty("data");
        if (filePath == null) {
            System.out.println("Please specify the JSON file path using the 'data' system property.");
            return;
        }

        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(filePath)) {
            JSONArray jsonArray = (JSONArray) parser.parse(reader);

            for (Object obj : jsonArray) {
                JSONObject vehicleObj = (JSONObject) obj;
                String vtype = (String) vehicleObj.get("vtype");

                switch (vtype.trim()) {
                    case "Car":
                        String color = (String) vehicleObj.get("color");
                        String myear = (String) vehicleObj.get("myear");
                        vehicles.add(new Car(color, Integer.parseInt(myear)) {
                            @Override
                            public int getNumberOfDoors() {
                                return 0;
                            }

                            @Override
                            public int getEngineCapacity() {
                                return 0;
                            }
                        });
                        break;

                    case "Van":
                        String storage = (String) vehicleObj.get("storage");
                        String numdoors = (String) vehicleObj.get("numdoors");
                        vehicles.add(new Van(Integer.parseInt(storage), Integer.parseInt(numdoors)));
                        break;

                    case "Motorbike":
                        String engine = (String) vehicleObj.get("engine");
                        String brand = (String) vehicleObj.get("brand");
                        vehicles.add(new Motorbike(Integer.parseInt(engine), brand) {
                            @Override
                            public int getNumberOfDoors() {
                                return 0;
                            }

                            @Override
                            public int getEngineCapacity() {
                                return 0;
                            }
                        });
                        break;

                    default:
                        System.out.println("Unknown vehicle type: " + vtype);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Act3VehicleService service = Act3VehicleService.getInstance();
        float totalCost = service.calculateTotal(vehicles);

        System.out.println("Total Service Charge: $" + totalCost);
    }
}