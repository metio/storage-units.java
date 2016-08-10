/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.storage_unit;

import static de.xn__ho_hia.quality.null_analysis.Nullsafe.asLong;
import static de.xn__ho_hia.storage_unit.TestObjects.highLevelLongBasedConstructors;

import java.util.ArrayList;
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
 * Test cases for the {@link StorageUnit} class and its behavior towards
 * converting one unit into another.
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

        units.add(StorageUnit::asBestMatchingBinaryUnit);
        units.add(StorageUnit::asBestMatchingDecimalUnit);
        units.add(StorageUnit::asBestMatchingCommonUnit);
        units.add(StorageUnit::asBestMatchingUnit);

        units.add(StorageUnit::asByte);

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

        units.add(StorageUnit::asCommonKilobyte);
        units.add(StorageUnit::asCommonMegabyte);
        units.add(StorageUnit::asCommonGigabyte);
        units.add(StorageUnit::asCommonTerabyte);
        units.add(StorageUnit::asCommonPetabyte);
        units.add(StorageUnit::asCommonExabyte);
        units.add(StorageUnit::asCommonZettabyte);
        units.add(StorageUnit::asCommonYottabyte);

        return units;
    }

    /**
     * Ensures that all given units (as per their constructing method) can be
     * expressed as any other given unit.
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
        final Long amount = asLong(1);
        final StorageUnit<?> unit = constructor.apply(amount);

        // When
        final StorageUnit<?> result = expression.apply(unit);

        // Then
        Assert.assertNotNull("Could not convert one unit into another", result);
        Assert.assertEquals("Amounts should be the same after conversion", unit.inByte(), result.inByte());
    }

}
