import java.util.ArrayList;

public class QualityDimension {

    // Private fields
    private String name;
    private String isoCode;
    private int weight;

    private ArrayList<Criterion> criteria;

    // Constructor
    QualityDimension(String name, String isoCode, int weight) {
        this.name = name;
        this.isoCode = isoCode;
        this.weight = weight;

        this.criteria = new ArrayList<>();
    }

    // Getters
    public String getName() { return name; }
    public String getIsoCode() { return isoCode; }
    public int getWeight() { return weight; };
    public ArrayList<Criterion> getCriteria() { return this.criteria; }

    // Methods
    public void addCriterion(Criterion c) {
        criteria.add(c);
    }

    public double calculateDimensionScore() {
        double dimensionScore;

        // metricScore x metricWeight
        double totalScoreTimesWeight = 0;
        double totalWeight = 0;

        int size = criteria.size();
        for (int i = 0; i < size; i++) {
            Criterion c = criteria.get(i);

            double metricScore = c.calculateScore();

            totalScoreTimesWeight += metricScore * c.getWeight();
            totalWeight += c.getWeight();
        }

        if (totalWeight == 0) return 0;

        dimensionScore = totalScoreTimesWeight / totalWeight;
        dimensionScore = Math.round(dimensionScore * 2) / 2.0;
        return dimensionScore;
    }

    public String qualityLabel() {
        double score = calculateDimensionScore();

        if (score >= 4.5 && score <= 5.0)
            return "Excellent Quality";
        else if (score >= 3.5 && score < 4.4)
            return "Good Quality";
        else if (score >= 2.5 && score < 3.4)
            return "Needs Improvement";
        else
            return "Poor Quality";
    }

    public double qualityGap() {
        return 5.0 - calculateDimensionScore();
    }
}
