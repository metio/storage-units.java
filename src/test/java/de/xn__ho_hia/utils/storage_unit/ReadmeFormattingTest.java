/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.utils.storage_unit;

import static de.xn__ho_hia.utils.storage_unit.StorageUnits.formatAsPebibyte;
import static de.xn__ho_hia.utils.storage_unit.StorageUnits.formatAsPetabyte;
import static de.xn__ho_hia.utils.storage_unit.StorageUnits.formatAsTerabyte;
import static de.xn__ho_hia.utils.storage_unit.StorageUnits.gibibyte;
import static de.xn__ho_hia.utils.storage_unit.StorageUnits.gigabyte;
import static de.xn__ho_hia.utils.storage_unit.StorageUnits.kilobyte;
import static de.xn__ho_hia.utils.storage_unit.StorageUnits.megabyte;
import static de.xn__ho_hia.utils.storage_unit.StorageUnits.petabyte;
import static de.xn__ho_hia.utils.storage_unit.StorageUnits.terabyte;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;

import de.xn__ho_hia.quality.suppression.CompilerWarnings;

/**
 * Formatting test cases for the examples in the README.
 */
@SuppressWarnings({ CompilerWarnings.NLS, CompilerWarnings.STATIC_METHOD })
public class ReadmeFormattingTest {

    /**
     * Tests the README example: Formatting a unit with the default settings.
     */
    @Test
    public void shouldFormatUnitWithDefaults() {
        Assert.assertEquals("2.00 TB", terabyte(2).toString());
        Assert.assertEquals("1.20 GB", gigabyte(1).add(megabyte(200)).toString());
        Assert.assertEquals("0.75 PB", petabyte(1).subtract(terabyte(250)).toString());
    }

    /**
     * Tests the README example: Formatting a unit with a custom pattern.
     */
    @Test
    public void shouldFormatUnitWithPattern() {
        Assert.assertEquals("212345.0 kB", kilobyte(212345).toString("0.0"));
        Assert.assertEquals("2,073.689 TiB", gibibyte(2123458).asTebibyte().toString("#,###.000"));
        Assert.assertEquals("1,000.12000 MB", kilobyte(120).asMegabyte().add(gigabyte(1)).toString("#,##0.00000"));
    }

    /**
     * Tests the README example: Formatting a unit with a custom pattern and Locale.
     */
    @Test
    public void shouldFormatUnitWithPatternAndLocale() {
        Assert.assertEquals("212345,0 kB", kilobyte(212345).toString("0.0", Locale.GERMAN));
        Assert.assertEquals("2.073,689 TiB", gibibyte(2123458).asTebibyte().toString("#,###.000", Locale.GERMAN));
    }

    /**
     * Tests the README example: Formatting a unit with a custom format.
     */
    @Test
    public void shouldFormatUnitWithFormat() {
        final Format customFormat = new DecimalFormat("#.00000");
        Assert.assertEquals("3.63798 TiB", terabyte(4).asTebibyte().toString(customFormat));
        Assert.assertEquals("2.00 TB", terabyte(2).toString());
    }

    /**
     * Tests the README example: Formatting some number of bytes without creating a unit first
     */
    @Test
    public void shouldFormatWithoutCreatingUnit() {
        final long numberOfBytes = 1_000_000_000_000_000L;
        Assert.assertEquals("1.00 PB", formatAsPetabyte(numberOfBytes));
        Assert.assertEquals("1000.00 TB", formatAsTerabyte(numberOfBytes));
        Assert.assertEquals("0.89 PiB", formatAsPebibyte(numberOfBytes));
    }

    /**
     * Tests the README example: Formatting some number of bytes without creating a unit first using a custom pattern.
     */
    @Test
    public void shouldFormatWithoutCreatingUnitUsingCustomPattern() {
        final long numberOfBytes = 1_000_000_000_000_000L;
        Assert.assertEquals("1000 TB", formatAsTerabyte(numberOfBytes, "#0.#####"));
        Assert.assertEquals("0.88818 PiB", formatAsPebibyte(numberOfBytes, "#0.#####"));
    }

    /**
     * Tests the README example: Formatting some number of bytes without creating a unit first using a custom pattern &
     * Locale.
     */
    @Test
    public void shouldFormatWithoutCreatingUnitUsingCustomPatternWithSpecificLocale() {
        final long numberOfBytes = 1_000_000_000_000_000L;
        Assert.assertEquals("1000 TB", formatAsTerabyte(numberOfBytes, "#0.#####", Locale.GERMAN));
        Assert.assertEquals("0,88818 PiB", formatAsPebibyte(numberOfBytes, "#0.#####", Locale.GERMAN));
    }

    /**
     * Tests the README example: Formatting some number of bytes without creating a unit first using a custom format.
     */
    @Test
    public void shouldFormatWithoutCreatingUnitUsingCustomFormat() {
        final Format customFormat = new DecimalFormat("#.00000");
        final long numberOfBytes = 1_000_000_000_000_000L;
        Assert.assertEquals("1000.00000 TB", formatAsTerabyte(numberOfBytes, customFormat));
        Assert.assertEquals(".88818 PiB", formatAsPebibyte(numberOfBytes, customFormat));
    }

}
