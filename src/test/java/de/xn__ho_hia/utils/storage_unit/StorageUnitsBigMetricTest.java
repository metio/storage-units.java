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
public class StorageUnitsBigMetricTest {

    private static final BigInteger MULTIPLIER = NullsafeMath.asBigInteger(1000);

    /**
     *
     */
    @DataPoints
    public static Object[][] INPUT_RESULTS = {
            { BigInteger.ONE, Kilobyte.class },
            { MULTIPLIER, Kilobyte.class },
            { MULTIPLIER.pow(2), Megabyte.class },
            { MULTIPLIER.pow(3), Gigabyte.class },
            { MULTIPLIER.pow(4), Terabyte.class },
            { MULTIPLIER.pow(5), Petabyte.class },
            { MULTIPLIER.pow(6), Exabyte.class },
            { MULTIPLIER.pow(7), Zettabyte.class },
            { MULTIPLIER.pow(8), Yottabyte.class },
            { MULTIPLIER.pow(9), Yottabyte.class },
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
        final StorageUnit<?> unit = StorageUnits.metricValueOf(Nullsafe.nonNull(bytes));

        // Then
        Assert.assertEquals(
                bytes + " should result in " + expectedClass.getSimpleName() + " but got "
                        + unit.getClass().getSimpleName(),
                expectedClass, unit.getClass());
    }

}
