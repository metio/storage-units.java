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

import static de.xn__ho_hia.utils.storage_unit.ObjectMother.longBasedConstructors;

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
 * Test cases for the {@link StorageUnit} class and its behavior towards comparing one unit with another.
 */
@RunWith(Theories.class)
@SuppressWarnings({ CompilerWarnings.NLS, CompilerWarnings.STATIC_METHOD })
public class StorageUnitCompareToTest {

    /** The factory methods to create storage units to test. */
    @DataPoints("first")
    public static final List<Function<Long, StorageUnit<?>>> FIRST  = longBasedConstructors();

    /** The factory methods to create storage units to test. */
    @DataPoints("second")
    public static final List<Function<Long, StorageUnit<?>>> SECOND = longBasedConstructors();

    /**
     * Ensures that comparing a smaller to a bigger unit yields the correct comparison result.
     *
     * @param first
     *            The constructor function for the storage unit under test.
     * @param second
     *            The constructor function for the storage unit under test.
     */
    @Theory
    public void shouldCompareSmallerToBiggerUnit(
            @FromDataPoints("first") final Function<Long, StorageUnit<?>> first,
            @FromDataPoints("second") final Function<Long, StorageUnit<?>> second) {
        // Given
        final Long smallerAmount = Long.valueOf(123);
        final Long biggerAmount = Long.valueOf(987);
        final StorageUnit<?> smallerUnit = first.apply(smallerAmount);
        final StorageUnit<?> biggerUnit = second.apply(biggerAmount);

        // When
        final int comparison = smallerUnit.compareTo(biggerUnit);

        // Then
        Assert.assertTrue("The smaller unit was not smaller than the bigger unit.", comparison < 0);
    }

    /**
     * Ensures that comparing a bigger to a smaller unit yields the correct comparison result.
     *
     * @param first
     *            The constructor function for the storage unit under test.
     * @param second
     *            The constructor function for the storage unit under test.
     */
    @Theory
    public void shouldCompareBiggerToSmallerUnit(
            @FromDataPoints("first") final Function<Long, StorageUnit<?>> first,
            @FromDataPoints("second") final Function<Long, StorageUnit<?>> second) {
        // Given
        final Long smallerAmount = Long.valueOf(123);
        final Long biggerAmount = Long.valueOf(987);
        final StorageUnit<?> smallerUnit = first.apply(smallerAmount);
        final StorageUnit<?> biggerUnit = second.apply(biggerAmount);

        // When
        final int comparison = biggerUnit.compareTo(smallerUnit);

        // Then
        Assert.assertTrue("The bigger unit was not bigger than the smaller unit.", comparison > 0);
    }

    /**
     * Ensures that comparing two equally sized units yields the correct comparison result.
     *
     * @param first
     *            The constructor function for the storage unit under test.
     * @param second
     *            The constructor function for the storage unit under test.
     */
    @Theory
    public void shouldCompareEqualSizedUnit(
            @FromDataPoints("first") final Function<Long, StorageUnit<?>> first,
            @FromDataPoints("second") final Function<Long, StorageUnit<?>> second) {
        // Given
        final Long amount = Long.valueOf(123);
        final StorageUnit<?> firstUnit = first.apply(amount);
        final StorageUnit<?> secondUnit = second.apply(amount);

        // When
        final int comparison = firstUnit.compareTo(secondUnit);

        // Then
        Assert.assertTrue("The equally sized units where not detected as such.", comparison == 0);
    }

}
