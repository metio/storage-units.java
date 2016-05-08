/*
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 *
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information, please refer to <http://unlicense.org>
 */
package de.xn__ho_hia.utils.storage_unit;

import static de.xn__ho_hia.utils.jdt.CompilerWarnings.BOXING;
import static de.xn__ho_hia.utils.jdt.CompilerWarnings.NLS;
import static de.xn__ho_hia.utils.jdt.CompilerWarnings.STATIC_METHOD;
import static de.xn__ho_hia.utils.storage_unit.ObjectMother.METRIC_MULTIPLIER;

import org.junit.Assert;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * Test cases for the {@link StorageUnits} class that check the behavior of small metric based units.
 */
@RunWith(Theories.class)
@SuppressWarnings(BOXING)
public class StorageUnitsSmallMetricTest {

    /**
     * Test inputs and their expected result. Since we are working with {@code long}s here, we can't build the really
     * big storage units because their byte number is greater than {@link Long#MAX_VALUE}.
     */
    @DataPoints
    public static Object[][] INPUT_RESULTS = {
            { 1L, Kilobyte.class },
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
    @SuppressWarnings(STATIC_METHOD)
    public void shouldCreateCorrectUnit(final Object[] input) {
        // Given
        final long bytes = (long) input[0];
        final Class<?> expectedClass = (Class<?>) input[1];

        // When
        final StorageUnit<?> unit = StorageUnits.metricValueOf(bytes);
        final Class<?> unitClass = unit.getClass();

        // Then
        Assert.assertEquals(logIncorrectCreation(bytes, expectedClass, unitClass), expectedClass, unitClass);
    }

    @SuppressWarnings(NLS)
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
