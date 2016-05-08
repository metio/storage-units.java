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

import static com.github.sebhoss.units.storage.ObjectMother.bigIntegerBasedConstructors;

import java.math.BigInteger;
import java.util.List;
import java.util.function.Function;

import com.github.sebhoss.units.storage.StorageUnit;

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
@SuppressWarnings({ "static-method", "nls" })
public class StorageUnitArithmeticBigIntegerTest {

    /**
     *
     */
    @DataPoints
    public static long[] BYTES_TO_ADD = { 1, 2, 3, 5, 8, 13, 100, 500, -500, 123456789 };

    /** The constructor methods to create storage units to test. */
    @DataPoints
    public static List<Function<BigInteger, StorageUnit<?>>> UNITS = bigIntegerBasedConstructors();

    /**
     * @param bytes
     *            The number of bytes to add.
     * @param constructor
     *            The constructor function for the storage unit under test.
     */
    @Theory
    public void shouldAddNumberOfBytes(
            final long bytes,
            final Function<BigInteger, StorageUnit<?>> constructor) {
        // Given
        final BigInteger initialAmount = BigInteger.valueOf(1);
        final StorageUnit<?> unit = constructor.apply(initialAmount);

        // When
        final StorageUnit<?> calculatedResult = unit.add(bytes);
        final BigInteger expectedResult = initialAmount.add(BigInteger.valueOf(bytes));

        // Then
        Assert.assertEquals(unit.getClass().getSimpleName() + "cannot add '1' and '" + bytes + "'.",
                expectedResult, calculatedResult.inByte());
    }

    /**
     * @param bytes
     *            The number of bytes to add.
     * @param constructor
     *            The constructor function for the storage unit under test.
     */
    @Theory
    public void shouldAddStorageUnit(
            final long bytes,
            final Function<BigInteger, StorageUnit<?>> constructor) {
        // Given
        final BigInteger initialAmount = BigInteger.valueOf(1);
        final BigInteger amountToAdd = BigInteger.valueOf(bytes);
        final StorageUnit<?> unit = constructor.apply(initialAmount);
        final StorageUnit<?> unitToAdd = constructor.apply(amountToAdd);

        // When
        final StorageUnit<?> calculatedResult = unit.add(unitToAdd);
        final BigInteger expectedResult = initialAmount.add(amountToAdd);

        // Then
        Assert.assertEquals(unit.getClass().getSimpleName() + "cannot add '1' and '" + bytes + "'.",
                expectedResult, calculatedResult.inByte());
    }

    /**
     * @param constructor
     *            The constructor function for the storage unit under test.
     */
    @Theory
    public void shouldReturnNewInstanceAfterAddLong(final Function<BigInteger, StorageUnit<?>> constructor) {
        // Given
        final BigInteger initialAmount = BigInteger.valueOf(1);
        final StorageUnit<?> first = constructor.apply(initialAmount);

        // When
        final StorageUnit<?> second = first.add(1000);

        // Then
        Assert.assertNotSame("The add(long) method must return a new instance.", first, second);
    }

    /**
     * @param constructor
     *            The constructor function for the storage unit under test.
     */
    @Theory
    public void shouldReturnNewInstanceAfterDivide(final Function<BigInteger, StorageUnit<?>> constructor) {
        // Given
        final StorageUnit<?> first = constructor.apply(BigInteger.valueOf(100));

        // When
        final StorageUnit<?> second = first.divide(5);

        // Then
        Assert.assertNotSame("The divide(long) method must return a new instance.", first, second);
    }

    /**
     * @param constructor
     *            The constructor function for the storage unit under test.
     */
    @Theory
    public void shouldReturnNewInstanceAfterMultiply(final Function<BigInteger, StorageUnit<?>> constructor) {
        // Given
        final StorageUnit<?> first = constructor.apply(BigInteger.valueOf(100));

        // When
        final StorageUnit<?> second = first.multiply(5);

        // Then
        Assert.assertNotSame("The multiply(long) method must return a new instance.", first, second);
    }

    /**
     * @param constructor
     *            The constructor function for the storage unit under test.
     */
    @Theory
    public void shouldReturnNewInstanceAfterSubtractLong(final Function<BigInteger, StorageUnit<?>> constructor) {
        // Given
        final StorageUnit<?> first = constructor.apply(BigInteger.valueOf(100));

        // When
        final StorageUnit<?> second = first.subtract(20);

        // Then
        Assert.assertNotSame("The subtract(long) method must return a new instance.", first, second);
    }

    /**
     * @param bytes
     *            The number of bytes to add.
     * @param constructor
     *            The constructor function for the storage unit under test.
     */
    @Theory
    public void shouldSubtractStorageUnit(
            final long bytes,
            final Function<BigInteger, StorageUnit<?>> constructor) {
        // Given
        final StorageUnit<?> unit = constructor.apply(BigInteger.valueOf(bytes));
        final StorageUnit<?> unitToSubtract = constructor.apply(BigInteger.valueOf(1));

        // When
        final StorageUnit<?> calculatedResult = unit.subtract(unitToSubtract);
        final BigInteger expectedResult = BigInteger.valueOf(bytes - 1);

        // Then
        Assert.assertEquals(unit.getClass().getSimpleName() + "cannot subtract '1' and '" + bytes + "'.",
                expectedResult, calculatedResult.inByte());
    }

}
