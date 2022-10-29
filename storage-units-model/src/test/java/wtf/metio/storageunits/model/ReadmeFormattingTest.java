/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.Locale;

import static wtf.metio.storageunits.model.StorageUnits.*;

class ReadmeFormattingTest {

    @Test
    void shouldFormatUnitWithDefaults() {
        Assertions.assertEquals("2.00 TB", terabyte(2).toString());
        Assertions.assertEquals("1.20 GB", gigabyte(1).add(megabyte(200)).toString());
        Assertions.assertEquals("0.75 PB", petabyte(1).subtract(terabyte(250)).toString());
    }

    @Test
    void shouldFormatUnitWithPattern() {
        Assertions.assertEquals("212345.0 kB", kilobyte(212345).toString("0.0"));
        Assertions.assertEquals("2,073.689 TiB", gibibyte(2123458).asTebibyte().toString("#,###.000"));
        Assertions.assertEquals("1,000.12000 MB", kilobyte(120).asMegabyte().add(gigabyte(1)).toString("#,##0.00000"));
    }

    @Test
    void shouldFormatUnitWithPatternAndLocale() {
        Assertions.assertEquals("212345,0 kB", kilobyte(212345).toString("0.0", Locale.GERMAN));
        Assertions.assertEquals("2.073,689 TiB", gibibyte(2123458).asTebibyte().toString("#,###.000", Locale.GERMAN));
    }

    @Test
    void shouldFormatUnitWithFormat() {
        final var customFormat = new DecimalFormat("#.00000");
        Assertions.assertEquals("3.63798 TiB", terabyte(4).asTebibyte().toString(customFormat));
        Assertions.assertEquals("2.00 TB", terabyte(2).toString());
    }

    @Test
    void shouldFormatWithoutCreatingUnit() {
        final long numberOfBytes = 1_000_000_000_000_000L;
        Assertions.assertEquals("1.00 PB", formatAsPetabyte(numberOfBytes));
        Assertions.assertEquals("1000.00 TB", formatAsTerabyte(numberOfBytes));
        Assertions.assertEquals("0.89 PiB", formatAsPebibyte(numberOfBytes));
    }

    @Test
    void shouldFormatWithoutCreatingUnitUsingCustomPattern() {
        final long numberOfBytes = 1_000_000_000_000_000L;
        Assertions.assertEquals("1000 TB", formatAsTerabyte(numberOfBytes, "#0.#####"));
        Assertions.assertEquals("0.88818 PiB", formatAsPebibyte(numberOfBytes, "#0.#####"));
    }

    @Test
    void shouldFormatWithoutCreatingUnitUsingCustomPatternWithSpecificLocale() {
        final long numberOfBytes = 1_000_000_000_000_000L;
        Assertions.assertEquals("1000 TB", formatAsTerabyte(numberOfBytes, "#0.#####", Locale.GERMAN));
        Assertions.assertEquals("0,88818 PiB", formatAsPebibyte(numberOfBytes, "#0.#####", Locale.GERMAN));
    }

    @Test
    void shouldFormatWithoutCreatingUnitUsingCustomFormat() {
        final var customFormat = new DecimalFormat("#.00000");
        final long numberOfBytes = 1_000_000_000_000_000L;
        Assertions.assertEquals("1000.00000 TB", formatAsTerabyte(numberOfBytes, customFormat));
        Assertions.assertEquals(".88818 PiB", formatAsPebibyte(numberOfBytes, customFormat));
        Assertions.assertEquals("8.00000 EiB", formatAsExbibyte(Long.MAX_VALUE, customFormat));
        Assertions.assertEquals("-8.00000 EiB", formatAsExbibyte(Long.MAX_VALUE + 1, customFormat));
    }

}
