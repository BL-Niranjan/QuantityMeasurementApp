package Main;

import java.util.Objects;
/**
 * Represents an immutable length quantity.
 */
public class QuantityLength {

    private static final double EPSILON = 0.000001;

    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value,
                          LengthUnit unit) {

        validateValue(value);

        if (unit == null) {
            throw new IllegalArgumentException(
                    "Unit cannot be null"
            );
        }

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    /**
     * Convert current object to target unit.
     */
    public QuantityLength convertTo(
            LengthUnit targetUnit) {

        double convertedValue =
                convert(
                        this.value,
                        this.unit,
                        targetUnit
                );

        return new QuantityLength(
                convertedValue,
                targetUnit
        );
    }

    /**
     * Static conversion API.
     */
    public static double convert(
            double value,
            LengthUnit sourceUnit,
            LengthUnit targetUnit) {

        validateValue(value);

        if (sourceUnit == null ||
                targetUnit == null) {

            throw new IllegalArgumentException(
                    "Units cannot be null"
            );
        }

        double valueInBaseUnit =
                value *
                        sourceUnit.getConversionFactor();

        return valueInBaseUnit /
                targetUnit.getConversionFactor();
    }

    private static void validateValue(
            double value) {

        if (!Double.isFinite(value)) {

            throw new IllegalArgumentException(
                    "Value must be finite"
            );
        }
    }

    private double convertToBaseUnit() {

        return value *
                unit.getConversionFactor();
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null ||
                getClass() != obj.getClass()) {
            return false;
        }

        QuantityLength other =
                (QuantityLength) obj;

        return Math.abs(
                convertToBaseUnit()
                        - other.convertToBaseUnit()
        ) < EPSILON;
    }

    @Override
    public int hashCode() {

        return Objects.hash(
                convertToBaseUnit()
        );
    }

    @Override
    public String toString() {

        return String.format(
                "%.6f %s",
                value,
                unit
        );
    }
}