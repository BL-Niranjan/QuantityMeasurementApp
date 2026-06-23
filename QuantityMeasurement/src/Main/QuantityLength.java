package Main;

import java.util.Objects;

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

    public QuantityLength convertTo(
            LengthUnit targetUnit) {

        double convertedValue =
                convert(
                        value,
                        unit,
                        targetUnit
                );

        return new QuantityLength(
                convertedValue,
                targetUnit
        );
    }

    public QuantityLength add(
            QuantityLength other) {

        if (other == null) {
            throw new IllegalArgumentException(
                    "Other quantity cannot be null"
            );
        }

        double thisBase =
                convertToBaseUnit();

        double otherBase =
                other.convertToBaseUnit();

        double totalBase =
                thisBase + otherBase;

        double resultValue =
                totalBase /
                        unit.getConversionFactor();

        return new QuantityLength(
                resultValue,
                unit
        );
    }

    public static QuantityLength add(
            QuantityLength first,
            QuantityLength second,
            LengthUnit targetUnit) {

        if (first == null ||
                second == null ||
                targetUnit == null) {

            throw new IllegalArgumentException(
                    "Invalid input"
            );
        }

        double firstBase =
                first.convertToBaseUnit();

        double secondBase =
                second.convertToBaseUnit();

        double totalBase =
                firstBase + secondBase;

        double resultValue =
                totalBase /
                        targetUnit.getConversionFactor();

        return new QuantityLength(
                resultValue,
                targetUnit
        );
    }

    public static double convert(
            double value,
            LengthUnit sourceUnit,
            LengthUnit targetUnit) {

        validateValue(value);

        if (sourceUnit == null ||
                targetUnit == null) {

            throw new IllegalArgumentException(
                    "Unit cannot be null"
            );
        }

        double baseValue =
                value *
                        sourceUnit.getConversionFactor();

        return baseValue /
                targetUnit.getConversionFactor();
    }

    private double convertToBaseUnit() {

        return value *
                unit.getConversionFactor();
    }

    private static void validateValue(
            double value) {

        if (!Double.isFinite(value)) {

            throw new IllegalArgumentException(
                    "Invalid numeric value"
            );
        }
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null ||
                getClass() != obj.getClass())
            return false;

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
                "%.4f %s",
                value,
                unit
        );
    }
}