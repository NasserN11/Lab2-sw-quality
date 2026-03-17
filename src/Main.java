import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        // Load all systems
        HashMap<String, ArrayList<SWSystem>> allSystems = new HashMap<>();
        allSystems = SWSystemData.getAllSystems();

        // Retrieve the systems in the "Web" category
        ArrayList<SWSystem> webs = allSystems.get("Web");

        // Select "ShopSphere" system
        for (SWSystem s : webs) {
            if (s.getName().equals("ShopSphere")) {
                // Set the test values for each metric
                ArrayList<QualityDimension> dimensions = s.getDimensions();

                for (QualityDimension d : dimensions) {

                    ArrayList<Criterion> criteria = d.getCriteria();

                    for (Criterion c : criteria) {
                        switch (c.getName()) {
                            case "Functional Completeness Ratio":
                                c.setMeasuredValue(94);
                                break;

                            case "Functional Correctness Ratio":
                                c.setMeasuredValue(91);
                                break;

                            case "Availability Ratio":
                                c.setMeasuredValue(99.2);
                                break;

                            case "Defect Density":
                                c.setMeasuredValue(2.1);
                                break;

                            case "Response Time":
                                c.setMeasuredValue(220);
                                break;

                            case "CPU Utilisation Ratio":
                                c.setMeasuredValue(38);
                                break;

                            case "Test Coverage Ratio":
                                c.setMeasuredValue(72);
                                break;

                            case "Cyclomatic Complexity":
                                c.setMeasuredValue(8.5);
                                break;
                        }
                    }
                }
                s.printReport();
            }
        }
    }
}
