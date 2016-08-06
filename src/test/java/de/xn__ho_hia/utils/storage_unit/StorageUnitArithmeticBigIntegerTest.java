/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.utils.storage_unit;

import static de.xn__ho_hia.quality.null_analysis.Nullsafe.asBigInteger;
import static de.xn__ho_hia.utils.storage_unit.TestObjects.bigIntegerBasedConstructors;

import java.math.BigInteger;
import java.util.List;
import java.util.function.Function;

import org.junit.Assert;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import de.xn__ho_hia.quality.suppression.CompilerWarnings;

/**
 *
 *
 */
@RunWith(Theories.class)
@SuppressWarnings({ CompilerWarnings.NLS, CompilerWarnings.NULL, CompilerWarnings.STATIC_METHOD })
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
        final BigInteger initialAmount = asBigInteger(1);
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
        final BigInteger initialAmount = asBigInteger(1);
        final BigInteger amountToAdd = asBigInteger(bytes);
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
        final BigInteger initialAmount = asBigInteger(1);
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
        final StorageUnit<?> first = constructor.apply(asBigInteger(100));

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
        final StorageUnit<?> first = constructor.apply(asBigInteger(100));

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
        final StorageUnit<?> first = constructor.apply(asBigInteger(100));

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
        final StorageUnit<?> unit = constructor.apply(asBigInteger(bytes));
        final StorageUnit<?> unitToSubtract = constructor.apply(asBigInteger(1));

        // When
        final StorageUnit<?> calculatedResult = unit.subtract(unitToSubtract);
        final BigInteger expectedResult = BigInteger.valueOf(bytes - 1);

        // Then
        Assert.assertEquals(unit.getClass().getSimpleName() + "cannot subtract '1' and '" + bytes + "'.",
                expectedResult, calculatedResult.inByte());
    }

}
