import java.util.ArrayList;

public class SWSystem {

    // Private fields
    private String name;
    private String category;
    private String version;

    ArrayList<QualityDimension> dimensions;

    // Constructor
    SWSystem(String name, String category, String version) {

        this.name = name;
        this.category = category;
        this.version = version;

        dimensions = new ArrayList<>();
    }

    // Getters
    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getVersion() { return version; }

    // Methods
    public void addQualityDimension(QualityDimension d) {
        dimensions.add(d);
    }

    public double calculateOverallScore() {

        // dimensionScore x dimensionWeight
        double totalScoreTimesWeight = 0;
        double totalWeight = 0;

        int size = dimensions.size();
        for (int i = 0; i < size; i++) {

            QualityDimension d = dimensions.get(i);
            double dimensionScore = d.calculateDimensionScore();

            totalScoreTimesWeight += dimensionScore * d.getWeight();
            totalWeight += d.getWeight();
        }

        double overallScore = totalScoreTimesWeight / totalWeight;
        overallScore = Math.round(overallScore * 2) / 2.0;

        return overallScore;
    }

    public QualityDimension findWeakestDimension() {

        QualityDimension weakestDimension = dimensions.get(0);
        double weakestDimensionScore = weakestDimension.calculateDimensionScore();

        int size = dimensions.size();
        for (int i = 1; i < size; i++) {
            QualityDimension dimension = dimensions.get(i);
            double dimensionScore = dimension.calculateDimensionScore();

            if (dimensionScore < weakestDimensionScore) {
                weakestDimension = dimension;
            }
        }

        return weakestDimension;
    }

    public String overallLabel(double score) {
        if (score >= 4.5) return "Excellent Quality";
        if (score >= 3.5) return "Good Quality";
        if (score >= 2.5) return "Needs Improvement";
        return "Poor Quality";
    }

    public void printReport() {

        // Header
        System.out.println("========================================");
        System.out.println("SOFTWARE QUALITY EVALUATION REPORT (ISO/IEC 25010)");
        System.out.println("System: " + getName() + " " + getVersion() + " (" + getCategory() + ")");
        System.out.println("========================================");
        System.out.println();

        // Dimensions
        for (QualityDimension d : dimensions) {
            // Dimension header
            System.out.println("--- " + d.getName() + " [" + d.getIsoCode() + "] (Weight: " + d.getWeight() + ") ---");

            // Print each criterion in this dimension
            for (Criterion c : d.getCriteria()) {
                System.out.println(c.getName() + ": " + c.getMeasuredValue() + " " + c.getUnit() + " -> Score: " + c.calculateScore() + " (" + c.getDirection() + " is better)");
            }
            // Print dimension score and label
            System.out.println(">> Dimension score: " + d.calculateDimensionScore() + "/5 [" + d.qualityLabel() + "]");
            System.out.println();
        }

        // Overall Score
        double overall = calculateOverallScore();
        String overallLabel = overallLabel(overall);
        System.out.println("========================================");
        System.out.println("OVERALL QUALITY SCORE: " + overall + "/5 [" + overallLabel + "]");
        System.out.println("========================================");
        System.out.println();

        // Gap analysis
        // Header
        System.out.println("GAP ALALYSIS (ISO/IEC 25010)");
        System.out.println("========================================");

        QualityDimension weakest = findWeakestDimension();
        System.out.println("Weakest Characteristic: " + weakest.getName() + " [" + weakest.getIsoCode() + "]");
        System.out.println("Score: " + weakest.calculateDimensionScore() + "/5  |  Gap: " + weakest.qualityGap());
        System.out.println("Level: " + weakest.qualityLabel());
        System.out.println(">> This characteristic requires the most improvement.");
        System.out.println("========================================");
        System.out.println();
    }
}
