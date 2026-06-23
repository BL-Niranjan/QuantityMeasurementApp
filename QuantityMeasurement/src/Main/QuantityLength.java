package Main;

import java.util.Objects;

public class QuantityLength {

    private static final double EPSILON = 0.000001;

    private static double value = 0;
    private static LengthUnit unit = null;

    public QuantityLength(
            double value,
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

        if (targetUnit == null) {
            throw new IllegalArgumentException(
                    "Target Unit cannot be null"
            );
        }

        double baseValue =
                unit.convertToBaseUnit(value);

        double convertedValue =
                targetUnit.convertFromBaseUnit(baseValue);

        return new QuantityLength(
                convertedValue,
                targetUnit
        );
    }

    /*
     * UC6
     */
    public QuantityLength add(
            QuantityLength other) {

        return add(other, this.unit);
    }

    /*
     * UC7
     */
    public static QuantityLength add(
            QuantityLength other,
            LengthUnit targetUnit) {

        if (other == null) {
            throw new IllegalArgumentException(
                    "Other quantity cannot be null"
            );
        }

        if (targetUnit == null) {
            throw new IllegalArgumentException(
                    "Target Unit cannot be null"
            );
        }

        double firstBase =
                unit.convertToBaseUnit(value);

        double secondBase =
                other.unit.convertToBaseUnit(
                        other.value
                );

        double totalBase =
                firstBase + secondBase;

        double resultValue =
                targetUnit.convertFromBaseUnit(
                        totalBase
                );

        return new QuantityLength(
                resultValue,
                targetUnit
        );
    }

    /*
     * UC5
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

        double baseValue =
                sourceUnit.convertToBaseUnit(value);

        return targetUnit
                .convertFromBaseUnit(baseValue);
    }

    private static void validateValue(
            double value) {

        if (!Double.isFinite(value)) {

            throw new IllegalArgumentException(
                    "Invalid Value"
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

        double thisBase =
                unit.convertToBaseUnit(value);

        double otherBase =
                other.unit.convertToBaseUnit(
                        other.value
                );

        return Math.abs(
                thisBase - otherBase
        ) < EPSILON;
    }

    @Override
    public int hashCode() {

        return Objects.hash(
                unit.convertToBaseUnit(value)
        );
    }

    @Override
    public String toString() {

        return String.format(
                "%.2f %s",
                value,
                unit
        );
    }
}