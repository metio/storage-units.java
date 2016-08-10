/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.storage_unit;

import org.eclipse.jdt.annotation.NonNull;
import org.junit.Assert;
import org.junit.Test;

import de.xn__ho_hia.quality.null_analysis.Nullsafe;
import de.xn__ho_hia.quality.suppression.CompilerWarnings;
import de.xn__ho_hia.storage_unit.StorageUnits;

/**
 * Formatting test cases for the {@link StorageUnits} class.
 */
@SuppressWarnings({ CompilerWarnings.NLS, CompilerWarnings.STATIC_METHOD })
public class StorageUnitsFormattingTest {

    /**
     * Tests the README example
     */
    @Test
    public void shouldFormatReadmeExample() {
        // given
        final long numberOfBytes = 1_000_000_000_000_000L;

        // when
        final String formatted = StorageUnits.formatAsTerabyte(numberOfBytes, "#0.#####");

        // then
        Assert.assertEquals("1000 TB", formatted);
    }

    /**
     * Tests formatting a {@link Long} formatted as Byte.
     */
    @Test
    public void shouldFormatNumberAsBytes() {
        // given
        @NonNull
        final Long numberOfBytes = Nullsafe.asLong(123456L);

        // when
        final String formatted = StorageUnits.formatAsByte(numberOfBytes);

        // then
        Assert.assertEquals("123456 B", formatted);
    }

    /**
     * Tests formatting a primitive long formatted as Byte.
     */
    @Test
    public void shouldFormatPrimitiveLongAsBytes() {
        // given
        final long numberOfBytes = 123456L;

        // when
        final String formatted = StorageUnits.formatAsByte(numberOfBytes);

        // then
        Assert.assertEquals("123456 B", formatted);
    }

}
