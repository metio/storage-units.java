/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.utils.storage_unit;

import static de.xn__ho_hia.quality.null_analysis.NullsafeMath.asLong;
import static de.xn__ho_hia.utils.storage_unit.TestObjects.highLevelLongBasedConstructors;

import java.math.BigDecimal;
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
        final Long amount = asLong(1);
        final StorageUnit<?> unit = constructor.apply(amount);

        // When
        final BigDecimal result = expression.apply(unit);

        // Then
        Assert.assertNotNull("Could not expression one unit as another", result);
    }

}
