/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.utils.storage_unit;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import de.xn__ho_hia.quality.suppression.CompilerWarnings;

/**
 * Helps with the creation of objects that are used for testing.
 *
 * @see <a href="http://martinfowler.com/bliki/ObjectMother.html">Martin Fowler about ObjectMothers</a>
 */
@SuppressWarnings(CompilerWarnings.NULL)
public class TestObjects {

    /** Multiplier for metric based units. */
    public static final long METRIC_MULTIPLIER = 1000L;

    /** Multiplier for binary based units. */
    public static final long BINARY_MULTIPLIER = 1024;

    /**
     * @return A list of constructor functions that take in a {@link Long} and produce a binary-based
     *         {@link StorageUnit}.
     */
    public static List<Function<Long, StorageUnit<?>>> highLevelBinaryLongBasedConstructors() {
        final List<Function<Long, StorageUnit<?>>> units = new ArrayList<>();
        units.add(StorageUnits::bytes);
        units.add(StorageUnits::kibibyte);
        units.add(StorageUnits::mebibyte);
        units.add(StorageUnits::gibibyte);
        units.add(StorageUnits::pebibyte);
        units.add(StorageUnits::tebibyte);
        units.add(StorageUnits::exbibyte);
        units.add(StorageUnits::zebibyte);
        units.add(StorageUnits::yobibyte);
        return units;
    }

    /**
     * @return A list of constructor functions that take in a {@link BigInteger} and produce a binary-based
     *         {@link StorageUnit}.
     */
    public static List<Function<BigInteger, StorageUnit<?>>> highLevelBinaryBigIntegerBasedConstructors() {
        final List<Function<BigInteger, StorageUnit<?>>> units = new ArrayList<>();
        units.add(StorageUnits::bytes);
        units.add(StorageUnits::kibibyte);
        units.add(StorageUnits::mebibyte);
        units.add(StorageUnits::gibibyte);
        units.add(StorageUnits::pebibyte);
        units.add(StorageUnits::tebibyte);
        units.add(StorageUnits::exbibyte);
        units.add(StorageUnits::zebibyte);
        units.add(StorageUnits::yobibyte);
        return units;
    }

    /**
     * @return A list of constructor functions that take in a {@link Long} and produce a metric-based
     *         {@link StorageUnit}.
     */
    public static List<Function<Long, StorageUnit<?>>> highLevelMetricLongBasedConstructors() {
        final List<Function<Long, StorageUnit<?>>> units = new ArrayList<>();
        units.add(StorageUnits::bytes);
        units.add(StorageUnits::kilobyte);
        units.add(StorageUnits::megabyte);
        units.add(StorageUnits::gigabyte);
        units.add(StorageUnits::petabyte);
        units.add(StorageUnits::terabyte);
        units.add(StorageUnits::exabyte);
        units.add(StorageUnits::zettabyte);
        units.add(StorageUnits::yottabyte);
        return units;
    }

    /**
     * @return A list of constructor functions that take in a {@link Long} and produce any kind of {@link StorageUnit}.
     */
    public static List<Function<Long, StorageUnit<?>>> highLevelLongBasedConstructors() {
        return Stream
                .concat(
                        highLevelBinaryLongBasedConstructors().stream(),
                        highLevelMetricLongBasedConstructors().stream())
                .collect(Collectors.toList());
    }

    /**
     * @return A list of constructor functions that take in a {@link BigInteger} and produce a metric-based
     *         {@link StorageUnit}.
     */
    public static List<Function<BigInteger, StorageUnit<?>>> bigIntegerBasedConstructors() {
        final List<Function<BigInteger, StorageUnit<?>>> units = new ArrayList<>();
        units.add(Byte::valueOf);
        units.add(Exabyte::valueOf);
        units.add(Exbibyte::valueOf);
        units.add(Gibibyte::valueOf);
        units.add(Gigabyte::valueOf);
        units.add(Kibibyte::valueOf);
        units.add(Kilobyte::valueOf);
        units.add(Mebibyte::valueOf);
        units.add(Megabyte::valueOf);
        units.add(Pebibyte::valueOf);
        units.add(Petabyte::valueOf);
        units.add(Tebibyte::valueOf);
        units.add(Terabyte::valueOf);
        units.add(Yobibyte::valueOf);
        units.add(Yottabyte::valueOf);
        units.add(Zebibyte::valueOf);
        units.add(Zettabyte::valueOf);
        return units;
    }

    /**
     * @return A list of constructor functions that take in a {@link Long} and produce a metric-based
     *         {@link StorageUnit}.
     */
    public static List<Function<Long, StorageUnit<?>>> longBasedConstructors() {
        final List<Function<Long, StorageUnit<?>>> units = new ArrayList<>();
        units.add(Byte::valueOf);
        units.add(Exabyte::valueOf);
        units.add(Exbibyte::valueOf);
        units.add(Gibibyte::valueOf);
        units.add(Gigabyte::valueOf);
        units.add(Kibibyte::valueOf);
        units.add(Kilobyte::valueOf);
        units.add(Mebibyte::valueOf);
        units.add(Megabyte::valueOf);
        units.add(Pebibyte::valueOf);
        units.add(Petabyte::valueOf);
        units.add(Tebibyte::valueOf);
        units.add(Terabyte::valueOf);
        units.add(Yobibyte::valueOf);
        units.add(Yottabyte::valueOf);
        units.add(Zebibyte::valueOf);
        units.add(Zettabyte::valueOf);
        return units;
    }

    private TestObjects() {
        // factory/helper class
    }

}
