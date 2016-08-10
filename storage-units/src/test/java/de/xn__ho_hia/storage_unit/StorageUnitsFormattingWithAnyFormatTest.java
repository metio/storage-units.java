/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.storage_unit;

import static de.xn__ho_hia.storage_unit.StorageUnit.BYTES_IN_A_EXABYTE;
import static de.xn__ho_hia.storage_unit.StorageUnit.BYTES_IN_A_EXBIBYTE;
import static de.xn__ho_hia.storage_unit.StorageUnit.BYTES_IN_A_GIBIBYTE;
import static de.xn__ho_hia.storage_unit.StorageUnit.BYTES_IN_A_GIGABYTE;
import static de.xn__ho_hia.storage_unit.StorageUnit.BYTES_IN_A_KIBIBYTE;
import static de.xn__ho_hia.storage_unit.StorageUnit.BYTES_IN_A_KILOBYTE;
import static de.xn__ho_hia.storage_unit.StorageUnit.BYTES_IN_A_MEBIBYTE;
import static de.xn__ho_hia.storage_unit.StorageUnit.BYTES_IN_A_MEGABYTE;
import static de.xn__ho_hia.storage_unit.StorageUnit.BYTES_IN_A_PEBIBYTE;
import static de.xn__ho_hia.storage_unit.StorageUnit.BYTES_IN_A_PETABYTE;
import static de.xn__ho_hia.storage_unit.StorageUnit.BYTES_IN_A_TEBIBYTE;
import static de.xn__ho_hia.storage_unit.StorageUnit.BYTES_IN_A_TERABYTE;
import static de.xn__ho_hia.storage_unit.StorageUnit.BYTES_IN_A_YOBIBYTE;
import static de.xn__ho_hia.storage_unit.StorageUnit.BYTES_IN_A_YOTTABYTE;
import static de.xn__ho_hia.storage_unit.StorageUnit.BYTES_IN_A_ZEBIBYTE;
import static de.xn__ho_hia.storage_unit.StorageUnit.BYTES_IN_A_ZETTABYTE;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import org.eclipse.jdt.annotation.NonNull;
import org.jooq.lambda.tuple.Tuple4;
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
public class StorageUnitsFormattingWithAnyFormatTest {

    @NonNull
    private static final Format FORMAT = asFormat("#0.0");

    /**
     * @return Formatting functions that accept {@link BigInteger} as input.
     */
    @DataPoints("format-biginteger")
    public static List<Tuple4<BiFunction<@NonNull BigInteger, @NonNull Format, String>, @NonNull BigInteger, @NonNull Format, String>> bigIntegerFunction() {
        final List<Tuple4<BiFunction<@NonNull BigInteger, @NonNull Format, String>, @NonNull BigInteger, @NonNull Format, String>> units = new ArrayList<>();

        units.add(new Tuple4<>(StorageUnits::formatAsBinaryUnit, BYTES_IN_A_KIBIBYTE, FORMAT, "1.0 KiB"));
        units.add(new Tuple4<>(StorageUnits::formatAsKibibyte, BYTES_IN_A_KIBIBYTE, FORMAT, "1.0 KiB"));
        units.add(new Tuple4<>(StorageUnits::formatAsMebibyte, BYTES_IN_A_MEBIBYTE, FORMAT, "1.0 MiB"));
        units.add(new Tuple4<>(StorageUnits::formatAsGibibyte, BYTES_IN_A_GIBIBYTE, FORMAT, "1.0 GiB"));
        units.add(new Tuple4<>(StorageUnits::formatAsTebibyte, BYTES_IN_A_TEBIBYTE, FORMAT, "1.0 TiB"));
        units.add(new Tuple4<>(StorageUnits::formatAsPebibyte, BYTES_IN_A_PEBIBYTE, FORMAT, "1.0 PiB"));
        units.add(new Tuple4<>(StorageUnits::formatAsExbibyte, BYTES_IN_A_EXBIBYTE, FORMAT, "1.0 EiB"));
        units.add(new Tuple4<>(StorageUnits::formatAsZebibyte, BYTES_IN_A_ZEBIBYTE, FORMAT, "1.0 ZiB"));
        units.add(new Tuple4<>(StorageUnits::formatAsYobibyte, BYTES_IN_A_YOBIBYTE, FORMAT, "1.0 YiB"));

        units.add(new Tuple4<>(StorageUnits::formatAsMetricUnit, BYTES_IN_A_KILOBYTE, FORMAT, "1.0 kB"));
        units.add(new Tuple4<>(StorageUnits::formatAsKilobyte, BYTES_IN_A_KILOBYTE, FORMAT, "1.0 kB"));
        units.add(new Tuple4<>(StorageUnits::formatAsMegabyte, BYTES_IN_A_MEGABYTE, FORMAT, "1.0 MB"));
        units.add(new Tuple4<>(StorageUnits::formatAsGigabyte, BYTES_IN_A_GIGABYTE, FORMAT, "1.0 GB"));
        units.add(new Tuple4<>(StorageUnits::formatAsTerabyte, BYTES_IN_A_TERABYTE, FORMAT, "1.0 TB"));
        units.add(new Tuple4<>(StorageUnits::formatAsPetabyte, BYTES_IN_A_PETABYTE, FORMAT, "1.0 PB"));
        units.add(new Tuple4<>(StorageUnits::formatAsExabyte, BYTES_IN_A_EXABYTE, FORMAT, "1.0 EB"));
        units.add(new Tuple4<>(StorageUnits::formatAsZettabyte, BYTES_IN_A_ZETTABYTE, FORMAT, "1.0 ZB"));
        units.add(new Tuple4<>(StorageUnits::formatAsYottabyte, BYTES_IN_A_YOTTABYTE, FORMAT, "1.0 YB"));

        units.add(new Tuple4<>(StorageUnits::formatAsCommonUnit, BYTES_IN_A_KIBIBYTE, FORMAT, "1.0 kB"));
        units.add(new Tuple4<>(StorageUnits::formatAsCommonKilobyte, BYTES_IN_A_KIBIBYTE, FORMAT, "1.0 kB"));
        units.add(new Tuple4<>(StorageUnits::formatAsCommonMegabyte, BYTES_IN_A_MEBIBYTE, FORMAT, "1.0 MB"));
        units.add(new Tuple4<>(StorageUnits::formatAsCommonGigabyte, BYTES_IN_A_GIBIBYTE, FORMAT, "1.0 GB"));
        units.add(new Tuple4<>(StorageUnits::formatAsCommonTerabyte, BYTES_IN_A_TEBIBYTE, FORMAT, "1.0 TB"));
        units.add(new Tuple4<>(StorageUnits::formatAsCommonPetabyte, BYTES_IN_A_PEBIBYTE, FORMAT, "1.0 PB"));
        units.add(new Tuple4<>(StorageUnits::formatAsCommonExabyte, BYTES_IN_A_EXBIBYTE, FORMAT, "1.0 EB"));
        units.add(new Tuple4<>(StorageUnits::formatAsCommonZettabyte, BYTES_IN_A_ZEBIBYTE, FORMAT, "1.0 ZB"));
        units.add(new Tuple4<>(StorageUnits::formatAsCommonYottabyte, BYTES_IN_A_YOBIBYTE, FORMAT, "1.0 YB"));

        return units;
    }

    /**
     * @return Formatting functions that accept {@link Long} as input.
     */
    @DataPoints("format-long")
    public static List<Tuple4<BiFunction<@NonNull Long, @NonNull Format, String>, @NonNull Long, @NonNull Format, String>> longFunction() {
        final List<Tuple4<BiFunction<@NonNull Long, @NonNull Format, String>, @NonNull Long, @NonNull Format, String>> units = new ArrayList<>();

        units.add(new Tuple4<>(StorageUnits::formatAsBinaryUnit, asLong(BYTES_IN_A_KIBIBYTE), FORMAT, "1.0 KiB"));
        units.add(new Tuple4<>(StorageUnits::formatAsKibibyte, asLong(BYTES_IN_A_KIBIBYTE), FORMAT, "1.0 KiB"));
        units.add(new Tuple4<>(StorageUnits::formatAsMebibyte, asLong(BYTES_IN_A_MEBIBYTE), FORMAT, "1.0 MiB"));
        units.add(new Tuple4<>(StorageUnits::formatAsGibibyte, asLong(BYTES_IN_A_GIBIBYTE), FORMAT, "1.0 GiB"));
        units.add(new Tuple4<>(StorageUnits::formatAsTebibyte, asLong(BYTES_IN_A_TEBIBYTE), FORMAT, "1.0 TiB"));
        units.add(new Tuple4<>(StorageUnits::formatAsPebibyte, asLong(BYTES_IN_A_PEBIBYTE), FORMAT, "1.0 PiB"));
        units.add(new Tuple4<>(StorageUnits::formatAsExbibyte, asLong(BYTES_IN_A_EXBIBYTE), FORMAT, "1.0 EiB"));
        units.add(new Tuple4<>(StorageUnits::formatAsZebibyte, asLong(BYTES_IN_A_ZEBIBYTE), FORMAT, "0.0 ZiB"));
        units.add(new Tuple4<>(StorageUnits::formatAsYobibyte, asLong(BYTES_IN_A_YOBIBYTE), FORMAT, "0.0 YiB"));

        units.add(new Tuple4<>(StorageUnits::formatAsMetricUnit, asLong(BYTES_IN_A_KILOBYTE), FORMAT, "1.0 kB"));
        units.add(new Tuple4<>(StorageUnits::formatAsKilobyte, asLong(BYTES_IN_A_KILOBYTE), FORMAT, "1.0 kB"));
        units.add(new Tuple4<>(StorageUnits::formatAsMegabyte, asLong(BYTES_IN_A_MEGABYTE), FORMAT, "1.0 MB"));
        units.add(new Tuple4<>(StorageUnits::formatAsGigabyte, asLong(BYTES_IN_A_GIGABYTE), FORMAT, "1.0 GB"));
        units.add(new Tuple4<>(StorageUnits::formatAsTerabyte, asLong(BYTES_IN_A_TERABYTE), FORMAT, "1.0 TB"));
        units.add(new Tuple4<>(StorageUnits::formatAsPetabyte, asLong(BYTES_IN_A_PETABYTE), FORMAT, "1.0 PB"));
        units.add(new Tuple4<>(StorageUnits::formatAsExabyte, asLong(BYTES_IN_A_EXABYTE), FORMAT, "1.0 EB"));
        units.add(new Tuple4<>(StorageUnits::formatAsZettabyte, asLong(BYTES_IN_A_ZETTABYTE), FORMAT, "0.0 ZB"));
        units.add(new Tuple4<>(StorageUnits::formatAsYottabyte, asLong(BYTES_IN_A_YOTTABYTE), FORMAT, "0.0 YB"));

        units.add(new Tuple4<>(StorageUnits::formatAsCommonUnit, asLong(BYTES_IN_A_KIBIBYTE), FORMAT, "1.0 kB"));
        units.add(new Tuple4<>(StorageUnits::formatAsCommonKilobyte, asLong(BYTES_IN_A_KIBIBYTE), FORMAT, "1.0 kB"));
        units.add(new Tuple4<>(StorageUnits::formatAsCommonMegabyte, asLong(BYTES_IN_A_MEBIBYTE), FORMAT, "1.0 MB"));
        units.add(new Tuple4<>(StorageUnits::formatAsCommonGigabyte, asLong(BYTES_IN_A_GIBIBYTE), FORMAT, "1.0 GB"));
        units.add(new Tuple4<>(StorageUnits::formatAsCommonTerabyte, asLong(BYTES_IN_A_TEBIBYTE), FORMAT, "1.0 TB"));
        units.add(new Tuple4<>(StorageUnits::formatAsCommonPetabyte, asLong(BYTES_IN_A_PEBIBYTE), FORMAT, "1.0 PB"));
        units.add(new Tuple4<>(StorageUnits::formatAsCommonExabyte, asLong(BYTES_IN_A_EXBIBYTE), FORMAT, "1.0 EB"));
        units.add(new Tuple4<>(StorageUnits::formatAsCommonZettabyte, asLong(BYTES_IN_A_ZEBIBYTE), FORMAT, "0.0 ZB"));
        units.add(new Tuple4<>(StorageUnits::formatAsCommonYottabyte, asLong(BYTES_IN_A_YOBIBYTE), FORMAT, "0.0 YB"));

        return units;
    }

    /**
     * Tests formatting a {@link BigInteger} formatted as a storage unit with
     * any format.
     *
     * @param input
     *            The test inputs to use.
     */
    @Theory
    public void shouldFormatBigIntegerAsStorageUnitWithAnyFormat(
            @FromDataPoints("format-biginteger") final Tuple4<BiFunction<@NonNull BigInteger, @NonNull Format, String>, @NonNull BigInteger, @NonNull Format, String> input) {
        // given
        Assume.assumeNotNull(input.v1);
        Assume.assumeNotNull(input.v2);
        Assume.assumeNotNull(input.v3);
        Assume.assumeNotNull(input.v4);

        // when
        final String formatted = input.v1.apply(input.v2, input.v3);

        // then
        Assert.assertEquals(input.v4, formatted);
    }

    /**
     * Tests formatting a {@link Long} formatted as a storage unit with any
     * format.
     *
     * @param input
     *            The test inputs to use.
     */
    @Theory
    public void shouldFormatLongAsStorageUnitWithAnyFormat(
            @FromDataPoints("format-long") final Tuple4<BiFunction<@NonNull Long, @NonNull Format, String>, @NonNull Long, @NonNull Format, String> input) {
        // given
        Assume.assumeNotNull(input.v1);
        Assume.assumeNotNull(input.v2);
        Assume.assumeNotNull(input.v3);
        Assume.assumeNotNull(input.v4);

        // when
        final String formatted = input.v1.apply(input.v2, input.v3);

        // then
        Assert.assertEquals(input.v4, formatted);
    }

    @NonNull
    private static Long asLong(final BigInteger number) {
        return Nullsafe.asLong(number.longValue());
    }

    @NonNull
    private static Format asFormat(final String pattern) {
        return new DecimalFormat(pattern);
    }

}
