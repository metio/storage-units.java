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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

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
@SuppressWarnings({ "static-method" })
public class ExpressionTest {

    /**
     * @return The factory methods to create storage units to test.
     */
    @DataPoints
    public static List<Function<StorageUnit<?>, BigDecimal>> storageUnits() {
        final List<Function<StorageUnit<?>, BigDecimal>> units = new ArrayList<>();

        units.add(StorageUnit::inKibibyte);
        units.add(StorageUnit::inMebibyte);
        units.add(StorageUnit::inGibibyte);
        units.add(StorageUnit::inTebibyte);
        units.add(StorageUnit::inPebibyte);
        units.add(StorageUnit::inExbibyte);
        units.add(StorageUnit::inZebibyte);
        units.add(StorageUnit::inYobibyte);

        units.add(StorageUnit::inKilobyte);
        units.add(StorageUnit::inMegabyte);
        units.add(StorageUnit::inGigabyte);
        units.add(StorageUnit::inTerabyte);
        units.add(StorageUnit::inPetabyte);
        units.add(StorageUnit::inExabyte);
        units.add(StorageUnit::inZettabyte);
        units.add(StorageUnit::inYottabyte);

        return units;
    }

    /**
     * @param expression
     *            The creating function for the storage unit under test.
     */
    @Theory
    @SuppressWarnings("nls")
    public void shouldAddNumberOfBytes(
            final Function<StorageUnit<?>, BigDecimal> expression) {
        // Given
        final StorageUnit<?> unit = StorageUnits.kilobyte(1);

        // When
        final BigDecimal result = expression.apply(unit);

        // Then
        Assert.assertNotNull("Could not expression one unit as another", result);
    }

}
