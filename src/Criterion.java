public class Criterion {

    // Private fields
    private String name;
    private int weight;
    private String direction;
    private double minValue;
    private double maxValue;
    private String unit;

    private double measuredValue;

    // Constructor
    public Criterion(String name, int weight, String direction, double minValue, double maxValue, String unit) {
        this.name = name;
        this.weight = weight;
        this.direction = direction;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.unit = unit;
    }

    // getters
    public String getName() { return name; }
    public int getWeight() { return weight; }
    public String getDirection() { return direction; }
    public double getMinValue() { return minValue; }
    public double getMaxValue() { return maxValue; }
    public String getUnit() { return unit; }

    public double getMeasuredValue() { return measuredValue; }

    // setters
    public void setMeasuredValue(double measuredValue) {
        this.measuredValue = measuredValue;
    }


    // Methods
    public double calculateScore() {
        double score;

        // Calculate row score
        if (direction.equals("higher")) {
            score = (1 + (measuredValue - minValue) / (maxValue - minValue) * 4);
        }
        else {
            score = (5 - (measuredValue - minValue) / (maxValue - minValue) * 4);
        }

        // Clamp between 1 and 5
        if (score < 1)
            score = 1;

        if (score > 5)
            score = 5;

        // Round to nearest 0.5
        score = Math.round(score * 2) / 2.0;

        return score;
    }
}
