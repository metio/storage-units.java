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

import de.xn__ho_hia.quality.suppression.CompilerWarnings;
import de.xn__ho_hia.storage_unit.Gigabyte;
import de.xn__ho_hia.storage_unit.Kibibyte;
import de.xn__ho_hia.storage_unit.Kilobyte;
import de.xn__ho_hia.storage_unit.Mebibyte;
import de.xn__ho_hia.storage_unit.Megabyte;
import de.xn__ho_hia.storage_unit.StorageUnit;
import de.xn__ho_hia.storage_unit.StorageUnits;

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
        final long first = 1024;
        final long second = first * first;

        // when
        @NonNull
        final StorageUnit<?> unit1 = StorageUnits.commonValueOf(first);
        @NonNull
        final StorageUnit<?> unit2 = StorageUnits.commonValueOf(second);

        // then
        Assert.assertEquals("1 kB", unit1.toString("#"));
        Assert.assertEquals("1 MB", unit2.toString("#"));
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
        final long input1 = 0L;

        // when
        @NonNull
        final Kibibyte unit1 = Kibibyte.valueOf(input1);
        @NonNull
        final StorageUnit<?> unit2 = unit1.add(1234L).asBestMatchingUnit();

        // then
        Assert.assertEquals("0.00 KiB", unit1.toString());
        Assert.assertEquals("1.21 KiB", unit2.toString());
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
