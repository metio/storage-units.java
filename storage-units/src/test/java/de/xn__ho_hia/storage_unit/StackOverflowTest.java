/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.storage_unit;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.eclipse.jdt.annotation.NonNull;
import org.junit.Assert;
import org.junit.Test;

import de.xn__ho_hia.quality.null_analysis.Nullsafe;
import de.xn__ho_hia.quality.suppression.CompilerWarnings;

/**
 * Verifies that questions on Stack Overflow can be answered with this library.
 *
 * @see <a href="https://stackoverflow.com">Stack Overflow</a>
 */
@SuppressWarnings({ CompilerWarnings.NLS, CompilerWarnings.STATIC_METHOD })
public class StackOverflowTest {

    /**
     * @see <a href="http://stackoverflow.com/q/3758606/2014864">Question 3758606</a>
     */
    @Test
    public void shoildConvertByteSizeIntoHumanReadbleFormat() {
        // given
        final long input1 = 1024;
        final long input2 = 1024 * 1024;
        final Format format = new DecimalFormat("#.#");

        // when
        final String formattedUnit1 = StorageUnits.formatAsCommonUnit(input1, "#");
        final String formattedUnit2 = StorageUnits.formatAsCommonUnit(input2, "#");
        final String formattedUnit3 = StorageUnits.formatAsBinaryUnit(input1);
        final String formattedUnit4 = StorageUnits.formatAsBinaryUnit(input2);
        final String formattedUnit5 = StorageUnits.formatAsDecimalUnit(input1, "#.00",
                Nullsafe.nonNull(Locale.GERMAN));
        final String formattedUnit6 = StorageUnits.formatAsDecimalUnit(input2, "#.00",
                Nullsafe.nonNull(Locale.GERMAN));
        final String formattedUnit7 = StorageUnits.formatAsBinaryUnit(input1, format);
        final String formattedUnit8 = StorageUnits.formatAsBinaryUnit(input2, format);
        final String formattedUnit9 = StorageUnits.formatAsKibibyte(input2);
        final String formattedUnit10 = StorageUnits.formatAsCommonMegabyte(input2);

        // then
        Assert.assertEquals("1 kB", formattedUnit1);
        Assert.assertEquals("1 MB", formattedUnit2);
        Assert.assertEquals("1.00 KiB", formattedUnit3);
        Assert.assertEquals("1.00 MiB", formattedUnit4);
        Assert.assertEquals("1,02 kB", formattedUnit5);
        Assert.assertEquals("1,05 MB", formattedUnit6);
        Assert.assertEquals("1 KiB", formattedUnit7);
        Assert.assertEquals("1 MiB", formattedUnit8);
        Assert.assertEquals("1024.00 KiB", formattedUnit9);
        Assert.assertEquals("1.00 MB", formattedUnit10);
    }

    /**
     * @see <a href="http://stackoverflow.com/q/3263892/2014864">Question 3263892</a>
     */
    @Test
    public void shouldFormatFileSizeAsMB() {
        // given
        final long first = 1L;
        final long second = 1024L;
        final long third = 2537253L;

        // when
        @NonNull
        final StorageUnit<?> unit1 = StorageUnits.commonValueOf(first);
        @NonNull
        final StorageUnit<?> unit2 = StorageUnits.commonValueOf(second);
        @NonNull
        final StorageUnit<?> unit3 = StorageUnits.commonValueOf(third);

        // then
        Assert.assertEquals("1 B", unit1.toString("#.#"));
        Assert.assertEquals("1 kB", unit2.toString("#.#"));
        Assert.assertEquals("2.4 MB", unit3.toString("#.#"));
    }

    /**
     * @see <a href="http://stackoverflow.com/q/801935/2014864">Question 801935</a>
     */
    @Test
    public void shouldFormatFileSizes() {
        // given
        final long input1 = 34L;
        final long input2 = 795L;
        final long input3 = 2646L;
        final long input4 = 2705L;
        final long input5 = 4096L;
        final long input6 = 13588L;
        final long input7 = 28282471L;
        final long input8 = 28533748L;

        // when
        @NonNull
        final StorageUnit<?> unit1 = StorageUnits.commonValueOf(input1);
        @NonNull
        final StorageUnit<?> unit2 = StorageUnits.commonValueOf(input2);
        @NonNull
        final StorageUnit<?> unit3 = StorageUnits.commonValueOf(input3);
        @NonNull
        final StorageUnit<?> unit4 = StorageUnits.commonValueOf(input4);
        @NonNull
        final StorageUnit<?> unit5 = StorageUnits.commonValueOf(input5);
        @NonNull
        final StorageUnit<?> unit6 = StorageUnits.commonValueOf(input6);
        @NonNull
        final StorageUnit<?> unit7 = StorageUnits.commonValueOf(input7);
        @NonNull
        final StorageUnit<?> unit8 = StorageUnits.commonValueOf(input8);

        // then
        Assert.assertEquals("34 B", unit1.toString("#.#"));
        Assert.assertEquals("795 B", unit2.toString("#.#"));
        Assert.assertEquals("2.6 kB", unit3.toString("#.#"));
        Assert.assertEquals("2.6 kB", unit4.toString("#.#"));
        Assert.assertEquals("4 kB", unit5.toString("#.#"));
        Assert.assertEquals("13.3 kB", unit6.toString("#.#"));
        Assert.assertEquals("27 MB", unit7.toString("#.#"));
        Assert.assertEquals("27.2 MB", unit8.toString("#.#"));
    }

    /**
     * @see <a href="http://stackoverflow.com/q/10420352/2014864">Question 10420352</a>
     */
    @Test
    public void shouldConvertFileSizeInBytesToHumanReadble() {
        // given
        final long input1 = 1551859712L;

        // when
        @NonNull
        final StorageUnit<?> unit1 = StorageUnits.commonValueOf(input1);

        // then
        Assert.assertEquals("1.4 GB", unit1.toString("#.#"));
    }

    /**
     * @see <a href="http://stackoverflow.com/q/1571374/2014864">Question 1571374</a>
     */
    @Test
    public void shouldConvertValuesToUnitPrefixes() {
        // given
        final long input1 = 1001L;
        final long input2 = 1_000_001L;

        // when
        @NonNull
        final StorageUnit<?> unit1 = StorageUnits.decimalValueOf(input1);
        @NonNull
        final StorageUnit<?> unit2 = StorageUnits.decimalValueOf(input2);

        // then
        Assert.assertEquals("1 kB", unit1.toString("#"));
        Assert.assertEquals("1 MB", unit2.toString("#"));
    }

    /**
     * @see <a href="http://stackoverflow.com/q/8157437/2014864">Question 8157437</a>
     */
    @Test
    public void shouldShowUserFriendlyFormattedOutput() {
        // given
        final long transferDurationInNanos = 2000000000L;
        final long transferDurationInSeconds = TimeUnit.NANOSECONDS.toSeconds(transferDurationInNanos);
        final long numberOfTransferredBytes = 4096L;

        // when
        final StorageUnit<?> totalTransferred = StorageUnits.binaryValueOf(numberOfTransferredBytes);
        final StorageUnit<?> transferredPerSecond = totalTransferred.divide(transferDurationInSeconds);

        // then
        Assert.assertEquals("2.00 KiB/s", transferredPerSecond + "/s");
        Assert.assertEquals("4.00 KiB", totalTransferred.toString());
        Assert.assertEquals("1.18 MiB", totalTransferred.add(1234567).asBestMatchingUnit().toString());
    }

    /**
     * @see <a href="http://stackoverflow.com/q/14400113/2014864">Question 14400113</a>
     */
    @Test
    public void shouldFormatNumberAsKb() {
        // given
        final long input1 = 1024L;
        final long input2 = 1048576L;

        // when
        @NonNull
        final StorageUnit<?> unit1 = StorageUnits.binaryValueOf(input1);
        @NonNull
        final StorageUnit<?> unit2 = StorageUnits.binaryValueOf(input2);

        // then
        Assert.assertEquals("1.00 KiB", unit1.toString());
        Assert.assertEquals("1.00 MiB", unit2.toString());
    }

    /**
     * @see <a href="http://stackoverflow.com/q/1107531/2014864">Question 1107531</a>
     */
    @Test
    public void shouldHaveBuiltInStorageUnitConversions() {
        // given
        @NonNull
        final Kilobyte unit1 = Kilobyte.valueOf(1234567L);

        // when
        @NonNull
        final Mebibyte unit2 = unit1.asMebibyte();

        // then
        Assert.assertEquals("1.18 MiB", unit2.toString());
    }

    /**
     * @see <a href="http://stackoverflow.com/q/18829782/2014864">Question 18829782</a>
     */
    @Test
    public void shouldDisplayUsedMemoryInMegabytes() {
        // given
        final long input1 = 12232313131L;

        // when
        @NonNull
        final Megabyte unit1 = Megabyte.valueOf(input1);
        @NonNull
        final Gigabyte unit2 = Gigabyte.valueOf(input1);

        // then
        Assert.assertEquals("12232.31 MB", unit1.toString());
        Assert.assertEquals("12.23 GB", unit2.toString());
    }

}
