package Test;

import Main.LengthUnit;
import Main.QuantityLength;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    @Test
    void testEquality_FeetToFeet_SameValue() {

        QuantityLength q1 =
                new QuantityLength(
                        1.0,
                        LengthUnit.FEET
                );

        QuantityLength q2 =
                new QuantityLength(
                        1.0,
                        LengthUnit.FEET
                );

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_InchToInch_SameValue() {

        QuantityLength q1 =
                new QuantityLength(
                        1.0,
                        LengthUnit.INCH
                );

        QuantityLength q2 =
                new QuantityLength(
                        1.0,
                        LengthUnit.INCH
                );

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_FeetToInch_EquivalentValue() {

        QuantityLength feet =
                new QuantityLength(
                        1.0,
                        LengthUnit.FEET
                );

        QuantityLength inch =
                new QuantityLength(
                        12.0,
                        LengthUnit.INCH
                );

        assertTrue(feet.equals(inch));
    }

    @Test
    void testEquality_InchToFeet_EquivalentValue() {

        QuantityLength inch =
                new QuantityLength(
                        12.0,
                        LengthUnit.INCH
                );

        QuantityLength feet =
                new QuantityLength(
                        1.0,
                        LengthUnit.FEET
                );

        assertTrue(inch.equals(feet));
    }

    @Test
    void testEquality_FeetToFeet_DifferentValue() {

        QuantityLength q1 =
                new QuantityLength(
                        1.0,
                        LengthUnit.FEET
                );

        QuantityLength q2 =
                new QuantityLength(
                        2.0,
                        LengthUnit.FEET
                );

        assertFalse(q1.equals(q2));
    }

    @Test
    void testEquality_InchToInch_DifferentValue() {

        QuantityLength q1 =
                new QuantityLength(
                        1.0,
                        LengthUnit.INCH
                );

        QuantityLength q2 =
                new QuantityLength(
                        2.0,
                        LengthUnit.INCH
                );

        assertFalse(q1.equals(q2));
    }

    @Test
    void testEquality_SameReference() {

        QuantityLength quantity =
                new QuantityLength(
                        1.0,
                        LengthUnit.FEET
                );

        assertTrue(
                quantity.equals(quantity)
        );
    }

    @Test
    void testEquality_NullComparison() {

        QuantityLength quantity =
                new QuantityLength(
                        1.0,
                        LengthUnit.FEET
                );

        assertFalse(
                quantity.equals(null)
        );
    }

    @Test
    void testEquality_NullUnit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new QuantityLength(
                        1.0,
                        null
                )
        );
    }
}
