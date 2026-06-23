package Test;

import Main.LengthUnit;
import Main.QuantityLength;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    private static final double EPSILON =
            0.000001;

    @Test
    void testAddition_SameUnit_FeetPlusFeet() {

        QuantityLength result =
                new QuantityLength(
                        1,
                        LengthUnit.FEET
                ).add(
                        new QuantityLength(
                                2,
                                LengthUnit.FEET
                        )
                );

        assertEquals(
                3.0,
                result.getValue(),
                EPSILON
        );
    }

    @Test
    void testAddition_SameUnit_InchPlusInch() {

        QuantityLength result =
                new QuantityLength(
                        6,
                        LengthUnit.INCH
                ).add(
                        new QuantityLength(
                                6,
                                LengthUnit.INCH
                        )
                );

        assertEquals(
                12,
                result.getValue(),
                EPSILON
        );
    }

    @Test
    void testAddition_CrossUnit_FeetPlusInches() {

        QuantityLength result =
                new QuantityLength(
                        1,
                        LengthUnit.FEET
                ).add(
                        new QuantityLength(
                                12,
                                LengthUnit.INCH
                        )
                );

        assertEquals(
                2,
                result.getValue(),
                EPSILON
        );
    }

    @Test
    void testAddition_CrossUnit_InchPlusFeet() {

        QuantityLength result =
                new QuantityLength(
                        12,
                        LengthUnit.INCH
                ).add(
                        new QuantityLength(
                                1,
                                LengthUnit.FEET
                        )
                );

        assertEquals(
                24,
                result.getValue(),
                EPSILON
        );
    }

    @Test
    void testAddition_CrossUnit_YardPlusFeet() {

        QuantityLength result =
                new QuantityLength(
                        1,
                        LengthUnit.YARDS
                ).add(
                        new QuantityLength(
                                3,
                                LengthUnit.FEET
                        )
                );

        assertEquals(
                2,
                result.getValue(),
                EPSILON
        );
    }

    @Test
    void testAddition_CrossUnit_CentimeterPlusInch() {

        QuantityLength result =
                new QuantityLength(
                        2.54,
                        LengthUnit.CENTIMETER
                ).add(
                        new QuantityLength(
                                1,
                                LengthUnit.INCH
                        )
                );

        assertEquals(
                5.08,
                result.getValue(),
                0.01
        );
    }

    @Test
    void testAddition_Commutativity() {

        QuantityLength first =
                QuantityLength.add(
                        new QuantityLength(
                                1,
                                LengthUnit.FEET
                        ),
                        new QuantityLength(
                                12,
                                LengthUnit.INCH
                        ),
                        LengthUnit.FEET
                );

        QuantityLength second =
                QuantityLength.add(
                        new QuantityLength(
                                12,
                                LengthUnit.INCH
                        ),
                        new QuantityLength(
                                1,
                                LengthUnit.FEET
                        ),
                        LengthUnit.FEET
                );

        assertEquals(
                first,
                second
        );
    }

    @Test
    void testAddition_WithZero() {

        QuantityLength result =
                new QuantityLength(
                        5,
                        LengthUnit.FEET
                ).add(
                        new QuantityLength(
                                0,
                                LengthUnit.INCH
                        )
                );

        assertEquals(
                5,
                result.getValue(),
                EPSILON
        );
    }

    @Test
    void testAddition_NegativeValues() {

        QuantityLength result =
                new QuantityLength(
                        5,
                        LengthUnit.FEET
                ).add(
                        new QuantityLength(
                                -2,
                                LengthUnit.FEET
                        )
                );

        assertEquals(
                3,
                result.getValue(),
                EPSILON
        );
    }

    @Test
    void testAddition_NullSecondOperand() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new QuantityLength(
                        1,
                        LengthUnit.FEET
                ).add(null)
        );
    }

    @Test
    void testAddition_LargeValues() {

        QuantityLength result =
                new QuantityLength(
                        1_000_000,
                        LengthUnit.FEET
                ).add(
                        new QuantityLength(
                                1_000_000,
                                LengthUnit.FEET
                        )
                );

        assertEquals(
                2_000_000,
                result.getValue(),
                EPSILON
        );
    }

    @Test
    void testAddition_SmallValues() {

        QuantityLength result =
                new QuantityLength(
                        0.001,
                        LengthUnit.FEET
                ).add(
                        new QuantityLength(
                                0.002,
                                LengthUnit.FEET
                        )
                );

        assertEquals(
                0.003,
                result.getValue(),
                EPSILON
        );
    }
}