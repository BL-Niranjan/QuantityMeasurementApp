package Main;

public enum LengthUnit {

    FEET(1.0),

    INCHES(1.0 / 12.0),

    YARDS(3.0),

    CENTIMETERS(1.0 / 30.48);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    /*
     * Converts current unit value
     * into base unit (Feet)
     */
    public double convertToBaseUnit(double value) {

        return value * conversionFactor;
    }

    /*
     * Converts Feet
     * into current unit
     */
    public double convertFromBaseUnit(double baseValue) {

        return baseValue / conversionFactor;
    }
}