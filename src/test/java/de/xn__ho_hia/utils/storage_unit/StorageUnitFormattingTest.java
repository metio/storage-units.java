/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.utils.storage_unit;

import java.text.DecimalFormat;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;

import de.xn__ho_hia.quality.suppression.CompilerWarnings;

/**
 * Tests how a {@link StorageUnit} can be formatted.
 */
@SuppressWarnings({ CompilerWarnings.NLS, CompilerWarnings.STATIC_METHOD })
public class StorageUnitFormattingTest {

    /**
     * Tests the default format for a unit.
     */
    @Test
    public void shouldUseDefaultUnitFormat() {
        // given
        final StorageUnit<?> unit = StorageUnits.kilobyte(2);

        // when
        final String formatted = unit.toString();

        // then
        Assert.assertEquals("2.00 kB", formatted);
    }

    /**
     * Tests that a unit can be formatted indirectly using a {@link DecimalFormat}.
     */
    @Test
    public void shouldFormatUnitIndirectly() {
        // given
        final DecimalFormat format = new DecimalFormat("#,###.00 ");
        final StorageUnit<?> unit = StorageUnits.kilobyte(2);

        // when
        final String formatted = format.format(unit.inKilobyte());

        // then
        Assert.assertEquals("2.00 kB", formatted + unit.getSymbol());
    }

    /**
     * Tests that a unit can be formatted directly by supplying a {@link DecimalFormat}.
     */
    @Test
    public void shouldFormatUnitDirectly() {
        // given
        final DecimalFormat format = new DecimalFormat("#,##0.00000");
        final StorageUnit<?> unit = StorageUnits.kilobyte(120);

        // when
        final String formatted = unit.asMegabyte().add(StorageUnits.gigabyte(1)).toString(format);

        // then
        Assert.assertEquals("1,000.12000 MB", formatted);
    }

    /**
     * Tests that a big unit can be formatted.
     */
    @Test
    public void shouldFormatBigUnitDirectly() {
        // given
        final DecimalFormat format = new DecimalFormat("0.0");
        final StorageUnit<?> unit = StorageUnits.kilobyte(212345);

        // when
        final String formatted = unit.toString(format);

        // then
        Assert.assertEquals("212345.0 kB", formatted);
    }

    /**
     * Tests that an even bigger unit can be formatted.
     */
    @Test
    public void shouldFormatBiggerUnitDirectly() {
        // given
        final DecimalFormat format = new DecimalFormat("#,###.000");
        final StorageUnit<?> unit = StorageUnits.gibibyte(2123458);

        // when
        final String formatted = unit.asTebibyte().toString(format);

        // then
        Assert.assertEquals("2,073.689 TiB", formatted);
    }

    /**
     * Tests that a unit can be formatted directly by supplying a pattern.
     */
    @Test
    public void shouldFormatUnitWithImplicitFormat() {
        // given
        final StorageUnit<?> unit = StorageUnits.kilobyte(120);

        // when
        final String formatted = unit.asMegabyte().add(StorageUnits.gigabyte(1)).toString("#,##0.00000");

        // then
        Assert.assertEquals("1,000.12000 MB", formatted);
    }

    /**
     * Tests that a big unit can be formatted directly by supplying a pattern.
     */
    @Test
    public void shouldFormatBiggestUnitWithImplicitFormat() {
        // given
        final StorageUnit<?> unit = StorageUnits.yobibyte(1);

        // when
        final String formatted = unit.asMegabyte().toString("#,##0.00000");

        // then
        Assert.assertEquals("1,208,925,819,614,629,174.70618 MB", formatted);
    }

    /**
     * Tests that a big unit can be formatted directly by supplying a pattern and Locale.
     */
    @Test
    public void shouldFormatBiggestUnitWithImplicitFormatAndLocale() {
        // given
        final StorageUnit<?> unit = StorageUnits.yobibyte(1);

        // when
        final String formatted = unit.asMegabyte().toString("#,##0.00000", Locale.GERMAN);

        // then
        Assert.assertEquals("1.208.925.819.614.629.174,70618 MB", formatted);
    }

    /**
     * Tests that the calculated capacity is correct.
     */
    @Test
    public void shouldCalculateBuilderCapacity() {
        // given
        final DecimalFormat format = new DecimalFormat("#,###.000");
        final StorageUnit<?> unit = StorageUnits.gibibyte(2123458);
        final String formatted = unit.asTebibyte().toString(format);

        // when
        final int calculatedCapacity = unit.calculateBuilderCapacity(formatted);

        // then
        Assert.assertEquals(18, calculatedCapacity);
    }

    /**
     * Tests that the number of missing bytes between user expectation and marketing departments can be calculated.
     */
    @Test
    public void shouldCalculateMissingBytes() {
        // given
        final Terabyte advertized = StorageUnits.terabyte(4);
        final Tebibyte expected = StorageUnits.tebibyte(4);

        // when
        final Tebibyte difference = expected.subtract(advertized);

        // then
        Assert.assertEquals("370.71 GiB", difference.asGibibyte().toString());
    }

    /**
     * Tests that the number of missing bytes between user expectation and marketing departments can be calculated and
     * displayed with a custom format.
     */
    @Test
    public void shouldCalculateMissingBytesWithCustomFormat() {
        // given
        final DecimalFormat format = new DecimalFormat("#0.00000");
        final Terabyte advertized = StorageUnits.terabyte(4);
        final Tebibyte expected = StorageUnits.tebibyte(4);

        // when
        final Tebibyte difference = expected.subtract(advertized);

        // then
        Assert.assertEquals("0.36202 TiB", difference.toString(format));
    }

    /**
     * Tests that the number of missing bytes between user expectation and marketing departments can be shown.
     */
    @Test
    public void shouldShowMissingBytes() {
        // given
        final DecimalFormat format = new DecimalFormat("#0.00000");
        final Terabyte advertized = StorageUnits.terabyte(4);

        // when
        final String formattedDiskSize = advertized.asTebibyte().toString(format);

        // then
        Assert.assertEquals("3.63798 TiB", formattedDiskSize);
    }

}
