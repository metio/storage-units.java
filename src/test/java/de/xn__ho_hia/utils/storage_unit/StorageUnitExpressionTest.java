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

import static de.xn__ho_hia.utils.storage_unit.ObjectMother.highLevelLongBasedConstructors;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.github.sebhoss.warnings.CompilerWarnings;

import org.junit.Assert;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * Test cases for the {@link StorageUnit} class and its behavior towards expressing one unit as the fraction of another.
 */
@RunWith(Theories.class)
@SuppressWarnings({ CompilerWarnings.NLS, CompilerWarnings.STATIC_METHOD })
public class StorageUnitExpressionTest {

    /** The factory methods to create storage units to test. */
    @DataPoints("units")
    public static final List<Function<Long, StorageUnit<?>>> UNITS = highLevelLongBasedConstructors();

    /**
     * @return The methods to express one unit as the fraction of another.
     */
    @DataPoints("expressions")
    public static List<Function<StorageUnit<?>, BigDecimal>> expressions() {
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
     * Ensures that all given units (as per their constructing method) can be expressed as any other given unit.
     *
     * @param constructor
     *            The constructor function for the storage unit under test.
     * @param expression
     *            The expression method (e.g. 'inGigabyte') to apply.
     */
    @Theory
    public void shouldExpressUnitAsFractionOfAnotherUnit(
            @FromDataPoints("units") final Function<Long, StorageUnit<?>> constructor,
            @FromDataPoints("expressions") final Function<StorageUnit<?>, BigDecimal> expression) {
        // Given
        final Long amount = Long.valueOf(1);
        final StorageUnit<?> unit = constructor.apply(amount);

        // When
        final BigDecimal result = expression.apply(unit);

        // Then
        Assert.assertNotNull("Could not expression one unit as another", result);
    }

}
