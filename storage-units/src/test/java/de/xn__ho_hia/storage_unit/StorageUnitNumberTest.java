/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.storage_unit;

import org.junit.Assert;
import org.junit.Test;

import de.xn__ho_hia.quality.suppression.CompilerWarnings;
import de.xn__ho_hia.storage_unit.StorageUnit;
import de.xn__ho_hia.storage_unit.StorageUnits;

/**
 * Test cases for the {@link StorageUnit} class that check its behavior as a {@link Number}.
 */
@SuppressWarnings({ CompilerWarnings.NLS, CompilerWarnings.STATIC_METHOD })
public class StorageUnitNumberTest {

    /**
     * Ensures that the {@link Number#doubleValue()} method is implemented.
     */
    @Test
    public void shouldReturnDoubleValue() {
        // Given
        final StorageUnit<?> unit = StorageUnits.kibibyte(1);

        // When
        final double result = unit.doubleValue();

        // Then
        Assert.assertEquals("Conversion was not correct", 1024D, result, 0D);
    }

    /**
     * Ensures that the {@link Number#longValue()} method is implemented.
     */
    @Test
    public void shouldReturnLongValue() {
        // Given
        final StorageUnit<?> unit = StorageUnits.kibibyte(1);

        // When
        final long result = unit.longValue();

        // Then
        Assert.assertEquals("Conversion was not correct", 1024L, result);
    }

    /**
     * Ensures that the {@link Number#floatValue()} method is implemented.
     */
    @Test
    public void shouldReturnFloatValue() {
        // Given
        final StorageUnit<?> unit = StorageUnits.kibibyte(1);

        // When
        final float result = unit.floatValue();

        // Then
        Assert.assertEquals("Conversion was not correct", 1024F, result, 0F);
    }

    /**
     * Ensures that the {@link Number#intValue()} method is implemented.
     */
    @Test
    public void shouldReturnIntValue() {
        // Given
        final StorageUnit<?> unit = StorageUnits.kibibyte(1);

        // When
        final int result = unit.intValue();

        // Then
        Assert.assertEquals("Conversion was not correct", 1024, result);
    }

}
