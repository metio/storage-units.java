/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.Locale;

class StorageUnitFormattingTest {

    @Test
    void useDefaultUnitFormat() {
        // given
        final StorageUnit<?> unit = StorageUnits.kilobyte(2);

        // when
        final String formatted = unit.toString();

        // then
        Assertions.assertEquals("2.00 kB", formatted);
    }

    @Test
    void formatUnitIndirectly() {
        // given
        final DecimalFormat format = new DecimalFormat("#,###.00 ");
        final StorageUnit<?> unit = StorageUnits.kilobyte(2);

        // when
        final String formatted = format.format(unit.inKilobyte());

        // then
        Assertions.assertEquals("2.00 kB", formatted + unit.getSymbol());
    }

    @Test
    void formatUnitDirectly() {
        // given
        final DecimalFormat format = new DecimalFormat("#,##0.00000");
        final StorageUnit<?> unit = StorageUnits.kilobyte(120);

        // when
        final String formatted = unit.asMegabyte().add(StorageUnits.gigabyte(1)).toString(format);

        // then
        Assertions.assertEquals("1,000.12000 MB", formatted);
    }

    @Test
    void formatBigUnitDirectly() {
        // given
        final DecimalFormat format = new DecimalFormat("0.0");
        final StorageUnit<?> unit = StorageUnits.kilobyte(212345);

        // when
        final String formatted = unit.toString(format);

        // then
        Assertions.assertEquals("212345.0 kB", formatted);
    }

    @Test
    void formatBiggerUnitDirectly() {
        // given
        final DecimalFormat format = new DecimalFormat("#,###.000");
        final StorageUnit<?> unit = StorageUnits.gibibyte(2123458);

        // when
        final String formatted = unit.asTebibyte().toString(format);

        // then
        Assertions.assertEquals("2,073.689 TiB", formatted);
    }

    @Test
    void formatUnitWithImplicitFormat() {
        // given
        final StorageUnit<?> unit = StorageUnits.kilobyte(120);

        // when
        final String formatted = unit.asMegabyte().add(StorageUnits.gigabyte(1)).toString("#,##0.00000");

        // then
        Assertions.assertEquals("1,000.12000 MB", formatted);
    }

    @Test
    void formatBiggestUnitWithImplicitFormat() {
        // given
        final StorageUnit<?> unit = StorageUnits.yobibyte(1);

        // when
        final String formatted = unit.asMegabyte().toString("#,##0.00000");

        // then
        Assertions.assertEquals("1,208,925,819,614,629,174.70618 MB", formatted);
    }

    @Test
    void formatBiggestUnitWithImplicitFormatAndLocale() {
        // given
        final StorageUnit<?> unit = StorageUnits.yobibyte(1);

        // when
        final String formatted = unit.asMegabyte().toString("#,##0.00000", Locale.GERMAN);

        // then
        Assertions.assertEquals("1.208.925.819.614.629.174,70618 MB", formatted);
    }

    @Test
    void calculateMissingBytes() {
        // given
        final Terabyte advertised = StorageUnits.terabyte(4);
        final Tebibyte expected = StorageUnits.tebibyte(4);

        // when
        final Tebibyte difference = expected.subtract(advertised);

        // then
        Assertions.assertEquals("370.71 GiB", difference.asGibibyte().toString());
    }

    @Test
    void calculateMissingBytesWithCustomFormat() {
        // given
        final DecimalFormat format = new DecimalFormat("#0.00000");
        final Terabyte advertised = StorageUnits.terabyte(4);
        final Tebibyte expected = StorageUnits.tebibyte(4);

        // when
        final Tebibyte difference = expected.subtract(advertised);

        // then
        Assertions.assertEquals("0.36202 TiB", difference.toString(format));
    }

    @Test
    void showMissingBytes() {
        // given
        final DecimalFormat format = new DecimalFormat("#0.00000");
        final Terabyte advertised = StorageUnits.terabyte(4);

        // when
        final String formattedDiskSize = advertised.asTebibyte().toString(format);

        // then
        Assertions.assertEquals("3.63798 TiB", formattedDiskSize);
    }

}
