/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.utils.storage_unit;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import de.xn__ho_hia.quality.null_analysis.Nullsafe;
import de.xn__ho_hia.quality.null_analysis.NullsafeMath;

/**
*
*
*/
@RunWith(Theories.class)
public class StorageUnitsBigBinaryTest {

    private static final BigInteger MULTIPLIER = NullsafeMath.asBigInteger(1024);

    /**
     *
     */
    @DataPoints
    public static Object[][] INPUT_RESULTS = {
            { BigInteger.ONE, Kibibyte.class },
            { MULTIPLIER, Kibibyte.class },
            { MULTIPLIER.pow(2), Mebibyte.class },
            { MULTIPLIER.pow(3), Gibibyte.class },
            { MULTIPLIER.pow(4), Tebibyte.class },
            { MULTIPLIER.pow(5), Pebibyte.class },
            { MULTIPLIER.pow(6), Exbibyte.class },
            { MULTIPLIER.pow(7), Zebibyte.class },
            { MULTIPLIER.pow(8), Yobibyte.class },
            { MULTIPLIER.pow(9), Yobibyte.class },
    };

    /**
     * @param input
     *            The number of bytes to wrap + the expected return class.
     */
    @SuppressWarnings({ "nls", "static-method", "unchecked" })
    @Theory
    public void shouldCreateCorrectBinaryUnit(final Object[] input) {
        // Given
        final BigInteger bytes = (BigInteger) input[0];
        final Class<? extends StorageUnit<?>> expectedClass = (Class<? extends StorageUnit<?>>) input[1];

        // When
        final StorageUnit<?> unit = StorageUnits.binaryValueOf(Nullsafe.nonNull(bytes));

        // Then
        Assert.assertEquals(
                bytes + " should result in " + expectedClass.getSimpleName() + " but got "
                        + unit.getClass().getSimpleName(),
                expectedClass, unit.getClass());
    }

}
