import java.util.ArrayList;
import java.util.HashMap;

public class SWSystemData {
    public static HashMap<String, ArrayList<SWSystem>> getAllSystems() {

        HashMap<String, ArrayList<SWSystem>> map = new HashMap<>();

        // Create Web systems
        ArrayList<SWSystem> webList = new ArrayList<>();
        webList.add(createECommercePlatform());
        webList.add(createBankingPortal());
        map.put("Web", webList);

        // Create Mobile systems
        ArrayList<SWSystem> mobileList = new ArrayList<>();
        mobileList.add(createHealthApp());
        map.put("Mobile", mobileList);
        return map;
    }


    private static SWSystem createECommercePlatform() {
        SWSystem s = new SWSystem("ShopSphere", "Web", "3.2.1");

        // ISO 25010: Functional Suitability (QC.FS) --- ISO 25023 metrics
        s.addQualityDimension(createFunctionalSuitability());

        // ISO 25010: Reliability (QC.RE) --- ISO 25023 metrics
        s.addQualityDimension(createReliability());

        // ... add remaining quality characteristics
        s.addQualityDimension(createPerformanceEfficiency());
        s.addQualityDimension(createUsability());
        s.addQualityDimension(createSecurity());
        s.addQualityDimension(createMaintainability());

        return s;
    }

    private static QualityDimension createFunctionalSuitability() {
        QualityDimension funcSuit = new QualityDimension("Functional Suitability",
                "QC.FS", 25);

        funcSuit.addCriterion(new Criterion(
                "Functional Completeness Ratio", // ISO 25023 metric name
                50, "higher", 0, 100, "%")); // Implemented / Planned × 100

        funcSuit.addCriterion(new Criterion(
                "Functional Correctness Ratio",
                50, "higher", 0, 100, "%")); // Correct-output tests / Total tests × 100

        return funcSuit;
    }

    private static QualityDimension createReliability() {
        QualityDimension reliability = new QualityDimension("Reliability", "QC.RE",
                25);

        reliability.addCriterion(new Criterion(
                "Availability Ratio",
                50, "higher", 95, 100, "%")); // Uptime / (Uptime + Downtime) × 100

        reliability.addCriterion(new Criterion(
                "Defect Density",
                50, "lower", 0, 20, "defect/KLOC")); // Defects found / 1000 LOC

        return reliability;
    }

    private static QualityDimension createPerformanceEfficiency() {
        QualityDimension dimension = new QualityDimension("Performance Efficiency", "QC.PE", 25);

        dimension.addCriterion(new Criterion("Response Time",
                50, "lower", 0, 1000, "ms"));

        dimension.addCriterion(new Criterion("CPU Utilisation Ratio",
                50, "lower", 0, 100, "%"));

        return dimension;
    }

    private static QualityDimension createUsability() {
        QualityDimension dimension = new QualityDimension(
                "Usability", "QC.US", 25
        );

        dimension.addCriterion(new Criterion(
                "Task Completion Rate", 50, "higher", 0, 100, "%"
        ));

        dimension.addCriterion(new Criterion(
                "User Error Rate", 50, "lower", 0, 100, "%"
        ));

        return dimension;
    }

    private static QualityDimension createSecurity() {
        QualityDimension dimension = new QualityDimension(
                "Security", "QC.SE", 25
        );

        dimension.addCriterion(new Criterion(
                "Security Test Coverage", 50, "higher", 0, 100, "%"
        ));

        dimension.addCriterion(new Criterion(
                "Vulnerability Count", 50, "lower", 0, 20, "count"
        ));

        return dimension;
    }

    private static QualityDimension createMaintainability() {
        QualityDimension dimension = new QualityDimension("Maintainability", "QC.MA", 25);

        dimension.addCriterion(new Criterion("Test Coverage Ratio",
                50, "higher", 0, 100, "%"));

        dimension.addCriterion(new Criterion("Cyclomatic Complexity",
                50, "lower", 0, 20, "score"));

        return dimension;
    }


    // ... implement createBankingPortal() and createHealthApp()

    private static SWSystem createBankingPortal() {
        SWSystem s = new SWSystem("Bank Portal", "Web", "2.1.0");

        // Functional Suitability
        s.addQualityDimension(createFunctionalSuitability());

        // Security
        s.addQualityDimension(createSecurity());

        // Reliability
        s.addQualityDimension(createReliability());

        // Performance
        s.addQualityDimension(createPerformanceEfficiency());

        return s;
    }


    private static SWSystem createHealthApp() {
        SWSystem s = new SWSystem("Health App", "Mobile", "1.5.0");

        // Usability
        s.addQualityDimension(createUsability());

        // Functional Suitability
        s.addQualityDimension(createFunctionalSuitability());

        // Security
        s.addQualityDimension(createSecurity());

        // Maintainability
        s.addQualityDimension(createMaintainability());

        return s;
    }
}