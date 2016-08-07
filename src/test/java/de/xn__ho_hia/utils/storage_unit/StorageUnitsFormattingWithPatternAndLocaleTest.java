/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.utils.storage_unit;

import static de.xn__ho_hia.utils.storage_unit.StorageUnit.BYTES_IN_A_EXABYTE;
import static de.xn__ho_hia.utils.storage_unit.StorageUnit.BYTES_IN_A_EXBIBYTE;
import static de.xn__ho_hia.utils.storage_unit.StorageUnit.BYTES_IN_A_GIBIBYTE;
import static de.xn__ho_hia.utils.storage_unit.StorageUnit.BYTES_IN_A_GIGABYTE;
import static de.xn__ho_hia.utils.storage_unit.StorageUnit.BYTES_IN_A_KIBIBYTE;
import static de.xn__ho_hia.utils.storage_unit.StorageUnit.BYTES_IN_A_KILOBYTE;
import static de.xn__ho_hia.utils.storage_unit.StorageUnit.BYTES_IN_A_MEBIBYTE;
import static de.xn__ho_hia.utils.storage_unit.StorageUnit.BYTES_IN_A_MEGABYTE;
import static de.xn__ho_hia.utils.storage_unit.StorageUnit.BYTES_IN_A_PEBIBYTE;
import static de.xn__ho_hia.utils.storage_unit.StorageUnit.BYTES_IN_A_PETABYTE;
import static de.xn__ho_hia.utils.storage_unit.StorageUnit.BYTES_IN_A_TEBIBYTE;
import static de.xn__ho_hia.utils.storage_unit.StorageUnit.BYTES_IN_A_TERABYTE;
import static de.xn__ho_hia.utils.storage_unit.StorageUnit.BYTES_IN_A_YOBIBYTE;
import static de.xn__ho_hia.utils.storage_unit.StorageUnit.BYTES_IN_A_YOTTABYTE;
import static de.xn__ho_hia.utils.storage_unit.StorageUnit.BYTES_IN_A_ZEBIBYTE;
import static de.xn__ho_hia.utils.storage_unit.StorageUnit.BYTES_IN_A_ZETTABYTE;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.eclipse.jdt.annotation.NonNull;
import org.jooq.lambda.function.Function3;
import org.jooq.lambda.tuple.Tuple5;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import de.xn__ho_hia.quality.null_analysis.Nullsafe;

/**
 * Formatting test cases for the {@link StorageUnits} class.
 */
@RunWith(Theories.class)
@SuppressWarnings({ "nls", "static-method" })
public class StorageUnitsFormattingWithPatternAndLocaleTest {

    // TODO: Check if annotation is required
    @NonNull
    private static final String PATTERN = "#0.0";
    private static final Locale LOCALE  = Locale.GERMAN;

    /**
     * @return Formatting functions that accept {@link BigInteger} as input.
     */
    @DataPoints("format-biginteger")
    public static List<Tuple5<Function3<@NonNull BigInteger, String, Locale, String>, @NonNull BigInteger, String, Locale, String>> bigIntegerFunction() {
        final List<Tuple5<Function3<@NonNull BigInteger, String, Locale, String>, @NonNull BigInteger, String, Locale, String>> units = new ArrayList<>();

        units.add(new Tuple5<>(StorageUnits::formatAsBinaryUnit, BYTES_IN_A_KIBIBYTE, PATTERN, LOCALE, "1,0 KiB"));
        units.add(new Tuple5<>(StorageUnits::formatAsKibibyte, BYTES_IN_A_KIBIBYTE, PATTERN, LOCALE, "1,0 KiB"));
        units.add(new Tuple5<>(StorageUnits::formatAsMebibyte, BYTES_IN_A_MEBIBYTE, PATTERN, LOCALE, "1,0 MiB"));
        units.add(new Tuple5<>(StorageUnits::formatAsGibibyte, BYTES_IN_A_GIBIBYTE, PATTERN, LOCALE, "1,0 GiB"));
        units.add(new Tuple5<>(StorageUnits::formatAsTebibyte, BYTES_IN_A_TEBIBYTE, PATTERN, LOCALE, "1,0 TiB"));
        units.add(new Tuple5<>(StorageUnits::formatAsPebibyte, BYTES_IN_A_PEBIBYTE, PATTERN, LOCALE, "1,0 PiB"));
        units.add(new Tuple5<>(StorageUnits::formatAsExbibyte, BYTES_IN_A_EXBIBYTE, PATTERN, LOCALE, "1,0 EiB"));
        units.add(new Tuple5<>(StorageUnits::formatAsZebibyte, BYTES_IN_A_ZEBIBYTE, PATTERN, LOCALE, "1,0 ZiB"));
        units.add(new Tuple5<>(StorageUnits::formatAsYobibyte, BYTES_IN_A_YOBIBYTE, PATTERN, LOCALE, "1,0 YiB"));

        units.add(new Tuple5<>(StorageUnits::formatAsMetricUnit, BYTES_IN_A_KILOBYTE, PATTERN, LOCALE, "1,0 kB"));
        units.add(new Tuple5<>(StorageUnits::formatAsKilobyte, BYTES_IN_A_KILOBYTE, PATTERN, LOCALE, "1,0 kB"));
        units.add(new Tuple5<>(StorageUnits::formatAsMegabyte, BYTES_IN_A_MEGABYTE, PATTERN, LOCALE, "1,0 MB"));
        units.add(new Tuple5<>(StorageUnits::formatAsGigabyte, BYTES_IN_A_GIGABYTE, PATTERN, LOCALE, "1,0 GB"));
        units.add(new Tuple5<>(StorageUnits::formatAsTerabyte, BYTES_IN_A_TERABYTE, PATTERN, LOCALE, "1,0 TB"));
        units.add(new Tuple5<>(StorageUnits::formatAsPetabyte, BYTES_IN_A_PETABYTE, PATTERN, LOCALE, "1,0 PB"));
        units.add(new Tuple5<>(StorageUnits::formatAsExabyte, BYTES_IN_A_EXABYTE, PATTERN, LOCALE, "1,0 EB"));
        units.add(new Tuple5<>(StorageUnits::formatAsZettabyte, BYTES_IN_A_ZETTABYTE, PATTERN, LOCALE, "1,0 ZB"));
        units.add(new Tuple5<>(StorageUnits::formatAsYottabyte, BYTES_IN_A_YOTTABYTE, PATTERN, LOCALE, "1,0 YB"));

        units.add(new Tuple5<>(StorageUnits::formatAsCommonUnit, BYTES_IN_A_KIBIBYTE, PATTERN, LOCALE, "1,0 kB"));
        units.add(new Tuple5<>(StorageUnits::formatAsCommonKilobyte, BYTES_IN_A_KIBIBYTE, PATTERN, LOCALE, "1,0 kB"));
        units.add(new Tuple5<>(StorageUnits::formatAsCommonMegabyte, BYTES_IN_A_MEBIBYTE, PATTERN, LOCALE, "1,0 MB"));
        units.add(new Tuple5<>(StorageUnits::formatAsCommonGigabyte, BYTES_IN_A_GIBIBYTE, PATTERN, LOCALE, "1,0 GB"));
        units.add(new Tuple5<>(StorageUnits::formatAsCommonTerabyte, BYTES_IN_A_TEBIBYTE, PATTERN, LOCALE, "1,0 TB"));
        units.add(new Tuple5<>(StorageUnits::formatAsCommonPetabyte, BYTES_IN_A_PEBIBYTE, PATTERN, LOCALE, "1,0 PB"));
        units.add(new Tuple5<>(StorageUnits::formatAsCommonExabyte, BYTES_IN_A_EXBIBYTE, PATTERN, LOCALE, "1,0 EB"));
        units.add(new Tuple5<>(StorageUnits::formatAsCommonZettabyte, BYTES_IN_A_ZEBIBYTE, PATTERN, LOCALE, "1,0 ZB"));
        units.add(new Tuple5<>(StorageUnits::formatAsCommonYottabyte, BYTES_IN_A_YOBIBYTE, PATTERN, LOCALE, "1,0 YB"));

        return units;
    }

    /**
     * @return Formatting functions that accept {@link Long} as input.
     */
    @DataPoints("format-long")
    public static List<Tuple5<Function3<@NonNull Long, String, Locale, String>, @NonNull Long, String, Locale, String>> longFunction() {
        final List<Tuple5<Function3<@NonNull Long, String, Locale, String>, @NonNull Long, String, Locale, String>> units = new ArrayList<>();

        units.add(new Tuple5<>(StorageUnits::formatAsBinaryUnit, asLong(BYTES_IN_A_KIBIBYTE), PATTERN, LOCALE,
                "1,0 KiB"));
        units.add(
                new Tuple5<>(StorageUnits::formatAsKibibyte, asLong(BYTES_IN_A_KIBIBYTE), PATTERN, LOCALE, "1,0 KiB"));
        units.add(
                new Tuple5<>(StorageUnits::formatAsMebibyte, asLong(BYTES_IN_A_MEBIBYTE), PATTERN, LOCALE, "1,0 MiB"));
        units.add(
                new Tuple5<>(StorageUnits::formatAsGibibyte, asLong(BYTES_IN_A_GIBIBYTE), PATTERN, LOCALE, "1,0 GiB"));
        units.add(
                new Tuple5<>(StorageUnits::formatAsTebibyte, asLong(BYTES_IN_A_TEBIBYTE), PATTERN, LOCALE, "1,0 TiB"));
        units.add(
                new Tuple5<>(StorageUnits::formatAsPebibyte, asLong(BYTES_IN_A_PEBIBYTE), PATTERN, LOCALE, "1,0 PiB"));
        units.add(
                new Tuple5<>(StorageUnits::formatAsExbibyte, asLong(BYTES_IN_A_EXBIBYTE), PATTERN, LOCALE, "1,0 EiB"));
        units.add(
                new Tuple5<>(StorageUnits::formatAsZebibyte, asLong(BYTES_IN_A_ZEBIBYTE), PATTERN, LOCALE, "0,0 ZiB"));
        units.add(
                new Tuple5<>(StorageUnits::formatAsYobibyte, asLong(BYTES_IN_A_YOBIBYTE), PATTERN, LOCALE, "0,0 YiB"));

        units.add(new Tuple5<>(StorageUnits::formatAsMetricUnit, asLong(BYTES_IN_A_KILOBYTE), PATTERN, LOCALE,
                "1,0 kB"));
        units.add(
                new Tuple5<>(StorageUnits::formatAsKilobyte, asLong(BYTES_IN_A_KILOBYTE), PATTERN, LOCALE, "1,0 kB"));
        units.add(
                new Tuple5<>(StorageUnits::formatAsMegabyte, asLong(BYTES_IN_A_MEGABYTE), PATTERN, LOCALE, "1,0 MB"));
        units.add(
                new Tuple5<>(StorageUnits::formatAsGigabyte, asLong(BYTES_IN_A_GIGABYTE), PATTERN, LOCALE, "1,0 GB"));
        units.add(
                new Tuple5<>(StorageUnits::formatAsTerabyte, asLong(BYTES_IN_A_TERABYTE), PATTERN, LOCALE, "1,0 TB"));
        units.add(new Tuple5<>(StorageUnits::formatAsPetabyte, asLong(BYTES_IN_A_PETABYTE), PATTERN, LOCALE, "1,0 PB"));
        units.add(new Tuple5<>(StorageUnits::formatAsExabyte, asLong(BYTES_IN_A_EXABYTE), PATTERN, LOCALE, "1,0 EB"));
        units.add(
                new Tuple5<>(StorageUnits::formatAsZettabyte, asLong(BYTES_IN_A_ZETTABYTE), PATTERN, LOCALE, "0,0 ZB"));
        units.add(
                new Tuple5<>(StorageUnits::formatAsYottabyte, asLong(BYTES_IN_A_YOTTABYTE), PATTERN, LOCALE, "0,0 YB"));

        units.add(new Tuple5<>(StorageUnits::formatAsCommonUnit, asLong(BYTES_IN_A_KIBIBYTE), PATTERN, LOCALE,
                "1,0 kB"));
        units.add(new Tuple5<>(StorageUnits::formatAsCommonKilobyte, asLong(BYTES_IN_A_KIBIBYTE), PATTERN, LOCALE,
                "1,0 kB"));
        units.add(new Tuple5<>(StorageUnits::formatAsCommonMegabyte, asLong(BYTES_IN_A_MEBIBYTE), PATTERN, LOCALE,
                "1,0 MB"));
        units.add(new Tuple5<>(StorageUnits::formatAsCommonGigabyte, asLong(BYTES_IN_A_GIBIBYTE), PATTERN, LOCALE,
                "1,0 GB"));
        units.add(new Tuple5<>(StorageUnits::formatAsCommonTerabyte, asLong(BYTES_IN_A_TEBIBYTE), PATTERN, LOCALE,
                "1,0 TB"));
        units.add(new Tuple5<>(StorageUnits::formatAsCommonPetabyte, asLong(BYTES_IN_A_PEBIBYTE), PATTERN, LOCALE,
                "1,0 PB"));
        units.add(new Tuple5<>(StorageUnits::formatAsCommonExabyte, asLong(BYTES_IN_A_EXBIBYTE), PATTERN, LOCALE,
                "1,0 EB"));
        units.add(new Tuple5<>(StorageUnits::formatAsCommonZettabyte, asLong(BYTES_IN_A_ZEBIBYTE), PATTERN, LOCALE,
                "0,0 ZB"));
        units.add(new Tuple5<>(StorageUnits::formatAsCommonYottabyte, asLong(BYTES_IN_A_YOBIBYTE), PATTERN, LOCALE,
                "0,0 YB"));

        return units;
    }

    /**
     * Tests formatting a {@link BigInteger} formatted as a storage unit with a custom pattern in a specific locale.
     *
     * @param input
     *            The test inputs to use.
     */
    @Theory
    public void shouldFormatBigIntegerAsStorageUnitWithPatternAndLocale(
            @FromDataPoints("format-biginteger") final Tuple5<Function3<@NonNull BigInteger, String, Locale, String>, @NonNull BigInteger, String, Locale, String> input) {
        // given
        Assume.assumeNotNull(input.v1);
        Assume.assumeNotNull(input.v2);
        Assume.assumeNotNull(input.v3);
        Assume.assumeNotNull(input.v4);
        Assume.assumeNotNull(input.v5);

        // when
        final String formatted = input.v1.apply(input.v2, input.v3, input.v4);

        // then
        Assert.assertEquals("", input.v5, formatted);
    }

    /**
     * Tests formatting a {@link Long} formatted as a storage unit with a custom pattern in a specific locale.
     *
     * @param input
     *            The test inputs to use.
     */
    @Theory
    public void shouldFormatLongAsStorageUnitWithPatternAndLocale(
            @FromDataPoints("format-long") final Tuple5<Function3<@NonNull Long, String, Locale, String>, @NonNull Long, String, Locale, String> input) {
        // given
        Assume.assumeNotNull(input.v1);
        Assume.assumeNotNull(input.v2);
        Assume.assumeNotNull(input.v3);
        Assume.assumeNotNull(input.v4);
        Assume.assumeNotNull(input.v5);

        // when
        final String formatted = input.v1.apply(input.v2, input.v3, input.v4);

        // then
        Assert.assertEquals(input.v5, formatted);
    }

    @NonNull
    private static Long asLong(final BigInteger number) {
        return Nullsafe.asLong(number.longValue());
    }

}
