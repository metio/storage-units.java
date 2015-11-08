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
package com.github.sebhoss.units.storage;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
*
*
*/
@RunWith(Theories.class)
public class BigMetricStorageUnitsTest {

    private static final BigInteger MULTIPLIER = BigInteger.valueOf(1000);

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
    };

    /**
     * @param input
     *            The number of bytes to wrap + the expected return class.
     */
    @SuppressWarnings({ "nls", "static-method", "unchecked" })
    @Theory
    public void shouldCreateCorrectBinaryUnit(
            final Object[] input) {
        // Given
        final BigInteger bytes = (BigInteger) input[0];
        final Class<? extends StorageUnit<?>> expectedClass = (Class<? extends StorageUnit<?>>) input[1];

        // When
        final StorageUnit<?> unit = StorageUnits.metricValueOf(bytes);

        // Then
        Assert.assertEquals(
                bytes + " should result in " + expectedClass.getSimpleName() + " but got "
                        + unit.getClass().getSimpleName(),
                expectedClass, unit.getClass());
    }

}
