/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.utils.storage_unit;

import static de.xn__ho_hia.utils.storage_unit.TestObjects.highLevelLongBasedConstructors;

import java.util.List;
import java.util.function.Function;

import org.junit.Assert;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import de.xn__ho_hia.quality.null_analysis.NullsafeMath;

/**
 * Test cases for the {@link StorageUnits} class that work with {@link Long}s.
 */
@RunWith(Theories.class)
public class StorageUnitsWithLongTest {

    /** The factory methods to create storage units to test. */
    @DataPoints
    public static List<Function<Long, StorageUnit<?>>> UNITS = highLevelLongBasedConstructors();

    /**
     * Ensures that high-level constructors for all given unit constructors produce a not-null output when fed with a
     * {@link Long} value.
     *
     * @param constructor
     *            The constructor function for the storage unit under test.
     * @see StorageUnitsWithBigIntegerTest#shouldCreateNotNullUnit(Function)
     */
    @Theory
    @SuppressWarnings({ "static-method", "nls" })
    public void shouldCreateNotNullUnit(final Function<Long, StorageUnit<?>> constructor) {
        // Given
        final Long bytes = NullsafeMath.asLong(1);

        // When
        final StorageUnit<?> unit = constructor.apply(bytes);

        // Then
        Assert.assertNotNull("Unit could not be created", unit);
    }

}
