/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Helps with the creation of objects that are used for testing.
 *
 * @see <a href="http://martinfowler.com/bliki/ObjectMother.html">Martin Fowler about ObjectMothers</a>
 */
final class TestObjects {

    /**
     * Multiplier for decimal based units.
     */
    public static final long DECIMAL_MULTIPLIER = 1000L;

    /**
     * Multiplier for binary based units.
     */
    public static final long BINARY_MULTIPLIER = 1024;

    /**
     * @return A list of constructor functions that take in a {@link Long} and produce a binary-based
     * {@link StorageUnit}.
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
     * {@link StorageUnit}.
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
     * @return A list of constructor functions that take in a {@link Long} and produce a decimal {@link StorageUnit}.
     */
    public static List<Function<Long, StorageUnit<?>>> highLevelDecimalLongBasedConstructors() {
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
     * @return A list of constructor functions that take in a {@link BigInteger} and produce a decimal
     * {@link StorageUnit}.
     */
    public static List<Function<BigInteger, StorageUnit<?>>> highLevelDecimalBigIntegerBasedConstructors() {
        final List<Function<BigInteger, StorageUnit<?>>> units = new ArrayList<>();
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
        return Stream.concat(
                        highLevelBinaryLongBasedConstructors().stream(), highLevelDecimalLongBasedConstructors().stream())
                .toList();
    }

    /**
     * @return A list of constructor functions that take in a {@link BigInteger} and produce any kind of
     * {@link StorageUnit}.
     */
    public static List<Function<BigInteger, StorageUnit<?>>> highLevelBigIntegerBasedConstructors() {
        return Stream.concat(
                        highLevelBinaryBigIntegerBasedConstructors().stream(),
                        highLevelDecimalBigIntegerBasedConstructors().stream())
                .toList();
    }

    /**
     * @return A list of constructor functions that take in a {@link BigInteger} and produce a decimal
     * {@link StorageUnit}.
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
     * @return A list of constructor functions that take in a {@link Long} and produce a decimal {@link StorageUnit}.
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
