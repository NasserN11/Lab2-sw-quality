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

    public void printReport() {}
}
