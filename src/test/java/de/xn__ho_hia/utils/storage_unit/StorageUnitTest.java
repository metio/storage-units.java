/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.utils.storage_unit;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import de.xn__ho_hia.quality.suppression.CompilerWarnings;

/**
 *
 *
 */
@SuppressWarnings({ CompilerWarnings.NLS, CompilerWarnings.NULL, CompilerWarnings.STATIC_METHOD })
public class StorageUnitTest {

    /**
    *
    */
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
    *
    */
    @Test
    public void shouldThrowNPEForNullCompareToCheck() {
        // Given
        final StorageUnit<?> unit = StorageUnits.kibibyte(1);

        // When
        thrown.expect(NullPointerException.class);

        // Then
        unit.compareTo(null);
    }

    /**
    *
    */
    @Test
    public void shouldBeEqualToItself() {
        // Given
        final StorageUnit<?> unit = StorageUnits.kibibyte(1);

        // When
        final boolean result = unit.equals(unit);

        // Then
        Assert.assertTrue("Unit is not equal to itself", result);
    }

    /**
    *
    */
    @Test
    public void shouldNotBeEqualToSomethingElse() {
        // Given
        final StorageUnit<?> unit = StorageUnits.kibibyte(1);

        // When
        final boolean result = unit.equals(new Object());

        // Then
        Assert.assertFalse("Unit is equal to something else", result);
    }

    /**
    *
    */
    @Test
    public void shouldCalculateHashCode() {
        // Given
        final StorageUnit<?> unit = StorageUnits.kibibyte(1);

        // When
        final int hashCode = unit.hashCode();

        // Then
        Assert.assertEquals("Conversion was not correct", 1024, hashCode);
    }

}
