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
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.eclipse.jdt.annotation.NonNull;
import org.jooq.lambda.tuple.Tuple3;
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
public class StorageUnitsFormattingWithDefaultsTest {

    /**
     * @return Formatting functions that accept {@link BigInteger} as input.
     */
    @DataPoints("format-biginteger")
    public static List<Tuple3<Function<@NonNull BigInteger, String>, @NonNull BigInteger, String>> bigIntegerFunction() {
        final List<Tuple3<Function<@NonNull BigInteger, String>, @NonNull BigInteger, String>> units = new ArrayList<>();

        units.add(new Tuple3<>(StorageUnits::formatAsBinaryUnit, BYTES_IN_A_KIBIBYTE, "1.00 KiB"));
        units.add(new Tuple3<>(StorageUnits::formatAsKibibyte, BYTES_IN_A_KIBIBYTE, "1.00 KiB"));
        units.add(new Tuple3<>(StorageUnits::formatAsMebibyte, BYTES_IN_A_MEBIBYTE, "1.00 MiB"));
        units.add(new Tuple3<>(StorageUnits::formatAsGibibyte, BYTES_IN_A_GIBIBYTE, "1.00 GiB"));
        units.add(new Tuple3<>(StorageUnits::formatAsTebibyte, BYTES_IN_A_TEBIBYTE, "1.00 TiB"));
        units.add(new Tuple3<>(StorageUnits::formatAsPebibyte, BYTES_IN_A_PEBIBYTE, "1.00 PiB"));
        units.add(new Tuple3<>(StorageUnits::formatAsExbibyte, BYTES_IN_A_EXBIBYTE, "1.00 EiB"));
        units.add(new Tuple3<>(StorageUnits::formatAsZebibyte, BYTES_IN_A_ZEBIBYTE, "1.00 ZiB"));
        units.add(new Tuple3<>(StorageUnits::formatAsYobibyte, BYTES_IN_A_YOBIBYTE, "1.00 YiB"));

        units.add(new Tuple3<>(StorageUnits::formatAsMetricUnit, BYTES_IN_A_KILOBYTE, "1.00 kB"));
        units.add(new Tuple3<>(StorageUnits::formatAsKilobyte, BYTES_IN_A_KILOBYTE, "1.00 kB"));
        units.add(new Tuple3<>(StorageUnits::formatAsMegabyte, BYTES_IN_A_MEGABYTE, "1.00 MB"));
        units.add(new Tuple3<>(StorageUnits::formatAsGigabyte, BYTES_IN_A_GIGABYTE, "1.00 GB"));
        units.add(new Tuple3<>(StorageUnits::formatAsTerabyte, BYTES_IN_A_TERABYTE, "1.00 TB"));
        units.add(new Tuple3<>(StorageUnits::formatAsPetabyte, BYTES_IN_A_PETABYTE, "1.00 PB"));
        units.add(new Tuple3<>(StorageUnits::formatAsExabyte, BYTES_IN_A_EXABYTE, "1.00 EB"));
        units.add(new Tuple3<>(StorageUnits::formatAsZettabyte, BYTES_IN_A_ZETTABYTE, "1.00 ZB"));
        units.add(new Tuple3<>(StorageUnits::formatAsYottabyte, BYTES_IN_A_YOTTABYTE, "1.00 YB"));

        units.add(new Tuple3<>(StorageUnits::formatAsCommonUnit, BYTES_IN_A_KIBIBYTE, "1.00 kB"));
        units.add(new Tuple3<>(StorageUnits::formatAsCommonKilobyte, BYTES_IN_A_KIBIBYTE, "1.00 kB"));
        units.add(new Tuple3<>(StorageUnits::formatAsCommonMegabyte, BYTES_IN_A_MEBIBYTE, "1.00 MB"));
        units.add(new Tuple3<>(StorageUnits::formatAsCommonGigabyte, BYTES_IN_A_GIBIBYTE, "1.00 GB"));
        units.add(new Tuple3<>(StorageUnits::formatAsCommonTerabyte, BYTES_IN_A_TEBIBYTE, "1.00 TB"));
        units.add(new Tuple3<>(StorageUnits::formatAsCommonPetabyte, BYTES_IN_A_PEBIBYTE, "1.00 PB"));
        units.add(new Tuple3<>(StorageUnits::formatAsCommonExabyte, BYTES_IN_A_EXBIBYTE, "1.00 EB"));
        units.add(new Tuple3<>(StorageUnits::formatAsCommonZettabyte, BYTES_IN_A_ZEBIBYTE, "1.00 ZB"));
        units.add(new Tuple3<>(StorageUnits::formatAsCommonYottabyte, BYTES_IN_A_YOBIBYTE, "1.00 YB"));

        return units;
    }

    /**
     * @return Formatting functions that accept {@link Long} as input.
     */
    @DataPoints("format-long")
    public static List<Tuple3<Function<@NonNull Long, String>, @NonNull Long, String>> longFunction() {
        final List<Tuple3<Function<@NonNull Long, String>, @NonNull Long, String>> units = new ArrayList<>();

        units.add(new Tuple3<>(StorageUnits::formatAsBinaryUnit, asLong(BYTES_IN_A_KIBIBYTE), "1.00 KiB"));
        units.add(new Tuple3<>(StorageUnits::formatAsKibibyte, asLong(BYTES_IN_A_KIBIBYTE), "1.00 KiB"));
        units.add(new Tuple3<>(StorageUnits::formatAsMebibyte, asLong(BYTES_IN_A_MEBIBYTE), "1.00 MiB"));
        units.add(new Tuple3<>(StorageUnits::formatAsGibibyte, asLong(BYTES_IN_A_GIBIBYTE), "1.00 GiB"));
        units.add(new Tuple3<>(StorageUnits::formatAsTebibyte, asLong(BYTES_IN_A_TEBIBYTE), "1.00 TiB"));
        units.add(new Tuple3<>(StorageUnits::formatAsPebibyte, asLong(BYTES_IN_A_PEBIBYTE), "1.00 PiB"));
        units.add(new Tuple3<>(StorageUnits::formatAsExbibyte, asLong(BYTES_IN_A_EXBIBYTE), "1.00 EiB"));
        units.add(new Tuple3<>(StorageUnits::formatAsZebibyte, asLong(BYTES_IN_A_ZEBIBYTE), "0.00 ZiB"));
        units.add(new Tuple3<>(StorageUnits::formatAsYobibyte, asLong(BYTES_IN_A_YOBIBYTE), "0.00 YiB"));

        units.add(new Tuple3<>(StorageUnits::formatAsMetricUnit, asLong(BYTES_IN_A_KILOBYTE), "1.00 kB"));
        units.add(new Tuple3<>(StorageUnits::formatAsKilobyte, asLong(BYTES_IN_A_KILOBYTE), "1.00 kB"));
        units.add(new Tuple3<>(StorageUnits::formatAsMegabyte, asLong(BYTES_IN_A_MEGABYTE), "1.00 MB"));
        units.add(new Tuple3<>(StorageUnits::formatAsGigabyte, asLong(BYTES_IN_A_GIGABYTE), "1.00 GB"));
        units.add(new Tuple3<>(StorageUnits::formatAsTerabyte, asLong(BYTES_IN_A_TERABYTE), "1.00 TB"));
        units.add(new Tuple3<>(StorageUnits::formatAsPetabyte, asLong(BYTES_IN_A_PETABYTE), "1.00 PB"));
        units.add(new Tuple3<>(StorageUnits::formatAsExabyte, asLong(BYTES_IN_A_EXABYTE), "1.00 EB"));
        units.add(new Tuple3<>(StorageUnits::formatAsZettabyte, asLong(BYTES_IN_A_ZETTABYTE), "0.00 ZB"));
        units.add(new Tuple3<>(StorageUnits::formatAsYottabyte, asLong(BYTES_IN_A_YOTTABYTE), "0.00 YB"));

        units.add(new Tuple3<>(StorageUnits::formatAsCommonUnit, asLong(BYTES_IN_A_KIBIBYTE), "1.00 kB"));
        units.add(new Tuple3<>(StorageUnits::formatAsCommonKilobyte, asLong(BYTES_IN_A_KIBIBYTE), "1.00 kB"));
        units.add(new Tuple3<>(StorageUnits::formatAsCommonMegabyte, asLong(BYTES_IN_A_MEBIBYTE), "1.00 MB"));
        units.add(new Tuple3<>(StorageUnits::formatAsCommonGigabyte, asLong(BYTES_IN_A_GIBIBYTE), "1.00 GB"));
        units.add(new Tuple3<>(StorageUnits::formatAsCommonTerabyte, asLong(BYTES_IN_A_TEBIBYTE), "1.00 TB"));
        units.add(new Tuple3<>(StorageUnits::formatAsCommonPetabyte, asLong(BYTES_IN_A_PEBIBYTE), "1.00 PB"));
        units.add(new Tuple3<>(StorageUnits::formatAsCommonExabyte, asLong(BYTES_IN_A_EXBIBYTE), "1.00 EB"));
        units.add(new Tuple3<>(StorageUnits::formatAsCommonZettabyte, asLong(BYTES_IN_A_ZEBIBYTE), "0.00 ZB"));
        units.add(new Tuple3<>(StorageUnits::formatAsCommonYottabyte, asLong(BYTES_IN_A_YOBIBYTE), "0.00 YB"));

        return units;
    }

    /**
     * Tests formatting a {@link BigInteger} formatted as a storage unit.
     *
     * @param input
     *            The test inputs to use.
     */
    @Theory
    public void shouldFormatBigIntegerAsStorageUnit(
            @FromDataPoints("format-biginteger") final Tuple3<Function<@NonNull BigInteger, String>, @NonNull BigInteger, String> input) {
        // given
        Assume.assumeNotNull(input.v1);
        Assume.assumeNotNull(input.v2);
        Assume.assumeNotNull(input.v3);

        // when
        final String formatted = input.v1.apply(input.v2);

        // then
        Assert.assertEquals("", input.v3, formatted);
    }

    /**
     * Tests formatting a {@link Long} formatted as a storage unit.
     *
     * @param input
     *            The test inputs to use.
     */
    @Theory
    public void shouldFormatLongAsStorageUnit(
            @FromDataPoints("format-long") final Tuple3<Function<@NonNull Long, String>, @NonNull Long, String> input) {
        // given
        Assume.assumeNotNull(input.v1);
        Assume.assumeNotNull(input.v2);
        Assume.assumeNotNull(input.v3);

        // when
        final String formatted = input.v1.apply(input.v2);

        // then
        Assert.assertEquals(input.v3, formatted);
    }

    @NonNull
    private static Long asLong(final BigInteger number) {
        return Nullsafe.asLong(number.longValue());
    }

}
