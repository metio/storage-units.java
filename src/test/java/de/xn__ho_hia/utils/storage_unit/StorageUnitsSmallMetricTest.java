/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.utils.storage_unit;

import static de.xn__ho_hia.utils.storage_unit.TestObjects.METRIC_MULTIPLIER;

import org.junit.Assert;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import de.xn__ho_hia.quality.null_analysis.Nullsafe;
import de.xn__ho_hia.quality.suppression.CompilerWarnings;

/**
 * Test cases for the {@link StorageUnits} class that check the behavior of small metric based units.
 */
@RunWith(Theories.class)
@SuppressWarnings(CompilerWarnings.BOXING)
public class StorageUnitsSmallMetricTest {

    /**
     * Test inputs and their expected result. Since we are working with {@code long}s here, we can't build the really
     * big storage units because their byte number is greater than {@link Long#MAX_VALUE}.
     */
    @DataPoints
    public static Object[][] INPUT_RESULTS = {
            { 1L, Byte.class },
            { METRIC_MULTIPLIER, Kilobyte.class },
            { METRIC_MULTIPLIER * METRIC_MULTIPLIER, Megabyte.class },
            { METRIC_MULTIPLIER * METRIC_MULTIPLIER * METRIC_MULTIPLIER, Gigabyte.class },
            { METRIC_MULTIPLIER * METRIC_MULTIPLIER * METRIC_MULTIPLIER * METRIC_MULTIPLIER, Terabyte.class },
            { METRIC_MULTIPLIER * METRIC_MULTIPLIER * METRIC_MULTIPLIER * METRIC_MULTIPLIER * METRIC_MULTIPLIER,
                    Petabyte.class },
            { Long.MAX_VALUE, Exabyte.class },
    };

    /**
     * @param input
     *            The number of bytes to wrap + the expected return class.
     */
    @Theory
    @SuppressWarnings(CompilerWarnings.STATIC_METHOD)
    public void shouldCreateCorrectUnit(final Object[] input) {
        // Given
        final long bytes = (long) input[0];
        final Class<?> expectedClass = (Class<?>) input[1];

        // When
        final StorageUnit<?> unit = StorageUnits.metricValueOf(bytes);
        final Class<?> unitClass = unit.getClass();

        // Then
        Assert.assertEquals(logIncorrectCreation(bytes, Nullsafe.nonNull(expectedClass), unitClass), expectedClass,
                unitClass);
    }

    @SuppressWarnings({ CompilerWarnings.NLS })
    private static String logIncorrectCreation(
            final long bytes,
            final Class<?> expectedClass,
            final Class<?> unitClass) {
        return String.format(
                "'%s' bytes should result in type [%s] but got [%s].",
                bytes,
                expectedClass.getSimpleName(),
                unitClass.getSimpleName());
    }

}
