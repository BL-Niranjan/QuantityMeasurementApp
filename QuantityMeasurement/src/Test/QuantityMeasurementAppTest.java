package Test;

import Main.LengthUnit;
import Main.QuantityLength;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    private static final double EPSILON =
            0.001;

    @Test
    void testAddition_ExplicitTargetUnit_Feet() {

        QuantityLength result =
                QuantityLength.add(
                        new QuantityLength(
                                1,
                                LengthUnit.FEET
                        ),
                        LengthUnit.FEET
                );

        assertEquals(
                2.0,
                result.getValue(),
                EPSILON
        );
    }

    @Test
    void testAddition_ExplicitTargetUnit_Inches() {

        QuantityLength result =
                QuantityLength.add(
                        new QuantityLength(
                                1,
                                LengthUnit.FEET
                        ),
                        LengthUnit.INCHES
                );

        assertEquals(
                24.0,
                result.getValue(),
                EPSILON
        );
    }

    @Test
    void testAddition_ExplicitTargetUnit_Yards() {

        QuantityLength result =
                QuantityLength.add(
                        new QuantityLength(
                                12,
                                LengthUnit.INCHES
                        ),
                        LengthUnit.YARDS
                );

        assertEquals(
                0.667,
                result.getValue(),
                EPSILON
        );
    }

    @Test
    void testAddition_ExplicitTargetUnit_Centimeters() {

        QuantityLength result =
                QuantityLength.add(
                        new QuantityLength(
                                1,
                                LengthUnit.INCHES
                        ),
                        LengthUnit.CENTIMETERS
                );

        assertEquals(
                5.08,
                result.getValue(),
                0.01
        );
    }

    @Test
    void testAddition_ExplicitTargetUnit_Commutativity() {

        QuantityLength first =
                QuantityLength.add(
                        new QuantityLength(
                                1,
                                LengthUnit.FEET
                        ),
                        LengthUnit.YARDS
                );

        QuantityLength second =
                QuantityLength.add(
                        new QuantityLength(
                                1,
                                LengthUnit.FEET
                        ),
                        LengthUnit.YARDS
                );

        assertEquals(
                first,
                second
        );
    }

    @Test
    void testAddition_ExplicitTargetUnit_WithZero() {

        QuantityLength result =
                QuantityLength.add(
                        new QuantityLength(
                                5,
                                LengthUnit.FEET
                        ),
                        LengthUnit.YARDS
                );

        assertEquals(
                1.667,
                result.getValue(),
                EPSILON
        );
    }

    @Test
    void testAddition_ExplicitTargetUnit_NegativeValues() {

        QuantityLength result =
                QuantityLength.add(
                        new QuantityLength(
                                -2,
                                LengthUnit.FEET
                        ),
                        LengthUnit.INCHES
                );

        assertEquals(
                36,
                result.getValue(),
                EPSILON
        );
    }

    @Test
    void testAddition_ExplicitTargetUnit_NullTargetUnit() {

        assertThrows(
                IllegalArgumentException.class,
                () -> QuantityLength.add(
                        new QuantityLength(
                                1,
                                LengthUnit.FEET
                        ),
                        null
                )
        );
    }

    @Test
    void testAddition_ExplicitTargetUnit_LargeToSmallScale() {

        QuantityLength result =
                QuantityLength.add(
                        new QuantityLength(
                                1000,
                                LengthUnit.FEET
                        ),
                        LengthUnit.INCHES
                );

        assertEquals(
                18000,
                result.getValue(),
                EPSILON
        );
    }

    @Test
    void testAddition_ExplicitTargetUnit_SmallToLargeScale() {

        QuantityLength result =
                QuantityLength.add(
                        new QuantityLength(
                                12,
                                LengthUnit.INCHES
                        ),
                        LengthUnit.YARDS
                );

        assertEquals(
                0.667,
                result.getValue(),
                EPSILON
        );
    }
}