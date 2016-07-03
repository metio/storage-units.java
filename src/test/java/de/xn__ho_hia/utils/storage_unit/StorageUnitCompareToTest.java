/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.utils.storage_unit;

import static de.xn__ho_hia.quality.null_analysis.Nullsafe.asLong;
import static de.xn__ho_hia.utils.storage_unit.TestObjects.longBasedConstructors;

import java.util.List;
import java.util.function.Function;

import org.junit.Assert;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import de.xn__ho_hia.quality.suppression.CompilerWarnings;

/**
 * Test cases for the {@link StorageUnit} class and its behavior towards comparing one unit with another.
 */
@RunWith(Theories.class)
@SuppressWarnings({ CompilerWarnings.NLS, CompilerWarnings.STATIC_METHOD })
public class StorageUnitCompareToTest {

    /** The factory methods to create storage units to test. */
    @DataPoints("first")
    public static final List<Function<Long, StorageUnit<?>>> FIRST = longBasedConstructors();

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
        final Long smallerAmount = asLong(123);
        final Long biggerAmount = asLong(987);
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
        final Long smallerAmount = asLong(123);
        final Long biggerAmount = asLong(987);
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
        final Long amount = asLong(123);
        final StorageUnit<?> firstUnit = first.apply(amount);
        final StorageUnit<?> secondUnit = second.apply(amount);

        // When
        final int comparison = firstUnit.compareTo(secondUnit);

        // Then
        Assert.assertTrue("The equally sized units where not detected as such.", comparison == 0);
    }

}
