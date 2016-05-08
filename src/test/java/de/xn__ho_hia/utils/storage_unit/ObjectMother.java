/*
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 *
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information, please refer to <http://unlicense.org>
 */
package de.xn__ho_hia.utils.storage_unit;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import de.xn__ho_hia.utils.storage_unit.Exabyte;
import de.xn__ho_hia.utils.storage_unit.Exbibyte;
import de.xn__ho_hia.utils.storage_unit.Gibibyte;
import de.xn__ho_hia.utils.storage_unit.Gigabyte;
import de.xn__ho_hia.utils.storage_unit.Kibibyte;
import de.xn__ho_hia.utils.storage_unit.Kilobyte;
import de.xn__ho_hia.utils.storage_unit.Mebibyte;
import de.xn__ho_hia.utils.storage_unit.Megabyte;
import de.xn__ho_hia.utils.storage_unit.Pebibyte;
import de.xn__ho_hia.utils.storage_unit.Petabyte;
import de.xn__ho_hia.utils.storage_unit.StorageUnit;
import de.xn__ho_hia.utils.storage_unit.StorageUnits;
import de.xn__ho_hia.utils.storage_unit.Tebibyte;
import de.xn__ho_hia.utils.storage_unit.Terabyte;
import de.xn__ho_hia.utils.storage_unit.Yobibyte;
import de.xn__ho_hia.utils.storage_unit.Yottabyte;
import de.xn__ho_hia.utils.storage_unit.Zebibyte;
import de.xn__ho_hia.utils.storage_unit.Zettabyte;

/**
 * Helps with the creation of objects that are used for testing.
 *
 * @see <a href="http://martinfowler.com/bliki/ObjectMother.html">Martin Fowler about ObjectMothers</a>
 */
public class ObjectMother {

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

    private ObjectMother() {
        // factory/helper class
    }

}
