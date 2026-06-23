package Test;

import Main.LengthUnit;
import Main.QuantityLength;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    @Test
    void testEquality_YardToYard_SameValue() {

        assertEquals(
                new QuantityLength(
                        1,
                        LengthUnit.YARDS
                ),
                new QuantityLength(
                        1,
                        LengthUnit.YARDS
                )
        );
    }

    @Test
    void testEquality_YardToYard_DifferentValue() {

        assertNotEquals(
                new QuantityLength(
                        1,
                        LengthUnit.YARDS
                ),
                new QuantityLength(
                        2,
                        LengthUnit.YARDS
                )
        );
    }

    @Test
    void testEquality_YardToFeet_EquivalentValue() {

        assertEquals(
                new QuantityLength(
                        1,
                        LengthUnit.YARDS
                ),
                new QuantityLength(
                        3,
                        LengthUnit.FEET
                )
        );
    }

    @Test
    void testEquality_FeetToYard_EquivalentValue() {

        assertEquals(
                new QuantityLength(
                        3,
                        LengthUnit.FEET
                ),
                new QuantityLength(
                        1,
                        LengthUnit.YARDS
                )
        );
    }

    @Test
    void testEquality_YardToInches_EquivalentValue() {

        assertEquals(
                new QuantityLength(
                        1,
                        LengthUnit.YARDS
                ),
                new QuantityLength(
                        36,
                        LengthUnit.INCH
                )
        );
    }

    @Test
    void testEquality_InchesToYard_EquivalentValue() {

        assertEquals(
                new QuantityLength(
                        36,
                        LengthUnit.INCH
                ),
                new QuantityLength(
                        1,
                        LengthUnit.YARDS
                )
        );
    }

    @Test
    void testEquality_YardToFeet_NonEquivalentValue() {

        assertNotEquals(
                new QuantityLength(
                        1,
                        LengthUnit.YARDS
                ),
                new QuantityLength(
                        2,
                        LengthUnit.FEET
                )
        );
    }
}