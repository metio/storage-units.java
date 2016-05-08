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
 * Test cases for the {@link StorageUnit} class and its behavior towards converting one unit into another.
 */
@RunWith(Theories.class)
@SuppressWarnings({ CompilerWarnings.NLS, CompilerWarnings.STATIC_METHOD })
public class StorageUnitConversionTest {

    /** The factory methods to create storage units to test. */
    @DataPoints("units")
    public static final List<Function<Long, StorageUnit<?>>> UNITS = highLevelLongBasedConstructors();

    /**
     * @return The methods to convert one unit into another.
     */
    @DataPoints("conversions")
    public static List<Function<StorageUnit<?>, StorageUnit<?>>> expressions() {
        final List<Function<StorageUnit<?>, StorageUnit<?>>> units = new ArrayList<>();

        units.add(StorageUnit::asKibibyte);
        units.add(StorageUnit::asMebibyte);
        units.add(StorageUnit::asGibibyte);
        units.add(StorageUnit::asTebibyte);
        units.add(StorageUnit::asPebibyte);
        units.add(StorageUnit::asExbibyte);
        units.add(StorageUnit::asZebibyte);
        units.add(StorageUnit::asYobibyte);

        units.add(StorageUnit::asKilobyte);
        units.add(StorageUnit::asMegabyte);
        units.add(StorageUnit::asGigabyte);
        units.add(StorageUnit::asTerabyte);
        units.add(StorageUnit::asPetabyte);
        units.add(StorageUnit::asExabyte);
        units.add(StorageUnit::asZettabyte);
        units.add(StorageUnit::asYottabyte);

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
    public void shouldConvertUnitIntoAnotherUnit(
            @FromDataPoints("units") final Function<Long, StorageUnit<?>> constructor,
            @FromDataPoints("conversions") final Function<StorageUnit<?>, StorageUnit<?>> expression) {
        // Given
        final Long amount = Long.valueOf(1);
        final StorageUnit<?> unit = constructor.apply(amount);

        // When
        final StorageUnit<?> result = expression.apply(unit);

        // Then
        Assert.assertNotNull("Could not convert one unit into another", result);
        Assert.assertEquals("Amounts should be the same after conversion", unit.inByte(), result.inByte());
    }

}
