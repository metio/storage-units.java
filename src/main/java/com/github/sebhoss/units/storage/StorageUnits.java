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
package com.github.sebhoss.units.storage;

import java.math.BigInteger;

/**
 * Factory for storage units.
 */
public final class StorageUnits {

    private StorageUnits() {
        // Hidden constructor.
    }

    /**
     * @param bytes
     *            The amount to bytes to represent.
     * @return The appropriate binary-prefixed unit for the given amount of bytes.
     */
    public static StorageUnit<?> binaryValueOf(final long bytes) {
        return binaryValueOf(BigInteger.valueOf(bytes));
    }

    /**
     * @param bytes
     *            The amount to bytes to represent.
     * @return The appropriate binary-prefixed unit for the given amount of bytes.
     */
    public static StorageUnit<?> binaryValueOf(final BigInteger bytes) {
        StorageUnit<?> unit = Kibibyte.valueOf(bytes);

        if (inbetween(StorageUnit.BYTES_IN_A_MEBIBYTE, bytes, StorageUnit.BYTES_IN_A_GIBIBYTE)) {
            unit = unit.asMebibyte();
        } else if (inbetween(StorageUnit.BYTES_IN_A_GIBIBYTE, bytes, StorageUnit.BYTES_IN_A_TEBIBYTE)) {
            unit = unit.asGibibyte();
        } else if (inbetween(StorageUnit.BYTES_IN_A_TEBIBYTE, bytes, StorageUnit.BYTES_IN_A_PEBIBYTE)) {
            unit = unit.asTebibyte();
        } else if (inbetween(StorageUnit.BYTES_IN_A_PEBIBYTE, bytes, StorageUnit.BYTES_IN_A_EXBIBYTE)) {
            unit = unit.asPebibyte();
        } else if (inbetween(StorageUnit.BYTES_IN_A_EXBIBYTE, bytes, StorageUnit.BYTES_IN_A_ZEBIBYTE)) {
            unit = unit.asExbibyte();
        } else if (inbetween(StorageUnit.BYTES_IN_A_ZEBIBYTE, bytes, StorageUnit.BYTES_IN_A_YOBIBYTE)) {
            unit = unit.asZebibyte();
        } else if (greaterThanEquals(bytes, StorageUnit.BYTES_IN_A_YOBIBYTE)) {
            unit = unit.asYobibyte();
        }

        return unit;
    }

    /**
     * @param bytes
     *            The amount of bytes to represent.
     * @return The appropriate metric-prefixed unit for the given amount of bytes.
     */
    public static StorageUnit<?> metricValueOf(final long bytes) {
        return metricValueOf(BigInteger.valueOf(bytes));
    }

    /**
     * @param bytes
     *            The amount of bytes to represent.
     * @return The appropriate metric-prefixed unit for the given amount of bytes.
     */
    public static StorageUnit<?> metricValueOf(final BigInteger bytes) {
        StorageUnit<?> unit = Kilobyte.valueOf(bytes);

        if (inbetween(StorageUnit.BYTES_IN_A_MEGABYTE, bytes, StorageUnit.BYTES_IN_A_GIGABYTE)) {
            unit = unit.asMegabyte();
        } else if (inbetween(StorageUnit.BYTES_IN_A_GIGABYTE, bytes, StorageUnit.BYTES_IN_A_TERABYTE)) {
            unit = unit.asGigabyte();
        } else if (inbetween(StorageUnit.BYTES_IN_A_TERABYTE, bytes, StorageUnit.BYTES_IN_A_PETABYTE)) {
            unit = unit.asTerabyte();
        } else if (inbetween(StorageUnit.BYTES_IN_A_PETABYTE, bytes, StorageUnit.BYTES_IN_A_EXABYTE)) {
            unit = unit.asPetabyte();
        } else if (inbetween(StorageUnit.BYTES_IN_A_EXABYTE, bytes, StorageUnit.BYTES_IN_A_ZETTABYTE)) {
            unit = unit.asExabyte();
        } else if (inbetween(StorageUnit.BYTES_IN_A_ZETTABYTE, bytes, StorageUnit.BYTES_IN_A_YOTTABYTE)) {
            unit = unit.asZettabyte();
        } else if (greaterThanEquals(bytes, StorageUnit.BYTES_IN_A_YOTTABYTE)) {
            unit = unit.asYottabyte();
        }

        return unit;
    }

    private static boolean inbetween(final BigInteger start, final BigInteger value, final BigInteger endExclusive) {
        return greaterThanEquals(value, start) && value.compareTo(endExclusive) < 0;
    }

    private static boolean greaterThanEquals(final BigInteger value, final BigInteger comparison) {
        return value.compareTo(comparison) > 0 || value.compareTo(comparison) == 0;
    }

    /**
     * @param amount
     *            The amount of kibibytes to create.
     * @return A new Kibibyte unit with the given value.
     */
    public static Kibibyte kibibyte(final Long amount) {
        return kibibyte(amount.longValue());
    }

    /**
     * @param amount
     *            The amount of kibibytes to create.
     * @return A new Kibibyte unit with the given value.
     */
    public static Kibibyte kibibyte(final long amount) {
        return kibibyte(BigInteger.valueOf(amount));
    }

    /**
     * @param amount
     *            The amount of kibibytes to create.
     * @return A new Kibibyte unit with the given value.
     */
    public static Kibibyte kibibyte(final BigInteger amount) {
        return new Kibibyte(StorageUnit.BYTES_IN_A_KIBIBYTE.multiply(amount));
    }

    /**
     * @param amount
     *            The amount of mebibytes to create.
     * @return A new Mebibyte unit with the given value.
     */
    public static Mebibyte mebibyte(final Long amount) {
        return mebibyte(amount.longValue());
    }

    /**
     * @param amount
     *            The amount of mebibytes to create.
     * @return A new Mebibyte unit with the given value.
     */
    public static Mebibyte mebibyte(final long amount) {
        return mebibyte(BigInteger.valueOf(amount));
    }

    /**
     * @param amount
     *            The amount of mebibytes to create.
     * @return A new Mebibyte unit with the given value.
     */
    public static Mebibyte mebibyte(final BigInteger amount) {
        return new Mebibyte(StorageUnit.BYTES_IN_A_MEBIBYTE.multiply(amount));
    }

    /**
     * @param amount
     *            The amount of gibibytes to create.
     * @return A new Gibibyte unit with the given value.
     */
    public static Gibibyte gibibyte(final Long amount) {
        return gibibyte(amount.longValue());
    }

    /**
     * @param amount
     *            The amount of gibibytes to create.
     * @return A new Gibibyte unit with the given value.
     */
    public static Gibibyte gibibyte(final long amount) {
        return gibibyte(BigInteger.valueOf(amount));
    }

    /**
     * @param amount
     *            The amount of gibibytes to create.
     * @return A new Gibibyte unit with the given value.
     */
    public static Gibibyte gibibyte(final BigInteger amount) {
        return new Gibibyte(StorageUnit.BYTES_IN_A_GIBIBYTE.multiply(amount));
    }

    /**
     * @param amount
     *            The amount of tebibytes to create.
     * @return A new Tebibyte unit with the given value.
     */
    public static Tebibyte tebibyte(final Long amount) {
        return tebibyte(amount.longValue());
    }

    /**
     * @param amount
     *            The amount of tebibytes to create.
     * @return A new Tebibyte unit with the given value.
     */
    public static Tebibyte tebibyte(final long amount) {
        return tebibyte(BigInteger.valueOf(amount));
    }

    /**
     * @param amount
     *            The amount of tebibytes to create.
     * @return A new Tebibyte unit with the given value.
     */
    public static Tebibyte tebibyte(final BigInteger amount) {
        return new Tebibyte(StorageUnit.BYTES_IN_A_TEBIBYTE.multiply(amount));
    }

    /**
     * @param amount
     *            The amount of pebibytes to create.
     * @return A new Pebibyte unit with the given value.
     */
    public static Pebibyte pebibyte(final Long amount) {
        return pebibyte(amount.longValue());
    }

    /**
     * @param amount
     *            The amount of pebibytes to create.
     * @return A new Pebibyte unit with the given value.
     */
    public static Pebibyte pebibyte(final long amount) {
        return pebibyte(BigInteger.valueOf(amount));
    }

    /**
     * @param amount
     *            The amount of pebibytes to create.
     * @return A new Pebibyte unit with the given value.
     */
    public static Pebibyte pebibyte(final BigInteger amount) {
        return new Pebibyte(StorageUnit.BYTES_IN_A_PEBIBYTE.multiply(amount));
    }

    /**
     * @param amount
     *            The amount of exbibytes to create.
     * @return A new Exbibyte unit with the given value.
     */
    public static Exbibyte exbibyte(final Long amount) {
        return exbibyte(amount.longValue());
    }

    /**
     * @param amount
     *            The amount of exbibytes to create.
     * @return A new Exbibyte unit with the given value.
     */
    public static Exbibyte exbibyte(final long amount) {
        return exbibyte(BigInteger.valueOf(amount));
    }

    /**
     * @param amount
     *            The amount of exbibytes to create.
     * @return A new Exbibyte unit with the given value.
     */
    public static Exbibyte exbibyte(final BigInteger amount) {
        return new Exbibyte(StorageUnit.BYTES_IN_A_EXBIBYTE.multiply(amount));
    }

    /**
     * @param amount
     *            The amount of zebibytes to create.
     * @return A new Zebibyte unit with the given value.
     */
    public static Zebibyte zebibyte(final Long amount) {
        return zebibyte(amount.longValue());
    }

    /**
     * @param amount
     *            The amount of zebibytes to create.
     * @return A new Zebibyte unit with the given value.
     */
    public static Zebibyte zebibyte(final long amount) {
        return zebibyte(BigInteger.valueOf(amount));
    }

    /**
     * @param amount
     *            The amount of zebibytes to create.
     * @return A new Zebibyte unit with the given value.
     */
    public static Zebibyte zebibyte(final BigInteger amount) {
        return new Zebibyte(StorageUnit.BYTES_IN_A_ZEBIBYTE.multiply(amount));
    }

    /**
     * @param amount
     *            The amount of yobibytes to create.
     * @return A new Yobibyte unit with the given value.
     */
    public static Yobibyte yobibyte(final Long amount) {
        return yobibyte(amount.longValue());
    }

    /**
     * @param amount
     *            The amount of yobibytes to create.
     * @return A new Yobibyte unit with the given value.
     */
    public static Yobibyte yobibyte(final long amount) {
        return yobibyte(BigInteger.valueOf(amount));
    }

    /**
     * @param amount
     *            The amount of yobibytes to create.
     * @return A new Yobibyte unit with the given value.
     */
    public static Yobibyte yobibyte(final BigInteger amount) {
        return new Yobibyte(StorageUnit.BYTES_IN_A_YOBIBYTE.multiply(amount));
    }

    /**
     * @param amount
     *            The amount of kilobytes to create.
     * @return A new Kilobyte unit with the given value.
     */
    public static Kilobyte kilobyte(final long amount) {
        return new Kilobyte(StorageUnit.BYTES_IN_A_KILOBYTE.multiply(BigInteger.valueOf(amount)));
    }

    /**
     * @param amount
     *            The amount of megabytes to create.
     * @return A new Megabyte unit with the given value.
     */
    public static Megabyte megabyte(final long amount) {
        return new Megabyte(StorageUnit.BYTES_IN_A_MEGABYTE.multiply(BigInteger.valueOf(amount)));
    }

    /**
     * @param amount
     *            The amount of gigabytes to create.
     * @return A new Gigabyte unit with the given value.
     */
    public static Gigabyte gigabyte(final long amount) {
        return new Gigabyte(StorageUnit.BYTES_IN_A_GIGABYTE.multiply(BigInteger.valueOf(amount)));
    }

    /**
     * @param amount
     *            The amount of terabytes to create.
     * @return A new Terabyte unit with the given value.
     */
    public static Terabyte terabyte(final long amount) {
        return new Terabyte(StorageUnit.BYTES_IN_A_TERABYTE.multiply(BigInteger.valueOf(amount)));
    }

    /**
     * @param amount
     *            The amount of petabytes to create.
     * @return A new Petabyte unit with the given value.
     */
    public static Petabyte petabyte(final long amount) {
        return new Petabyte(StorageUnit.BYTES_IN_A_PETABYTE.multiply(BigInteger.valueOf(amount)));
    }

    /**
     * @param amount
     *            The amount of exabytes to create.
     * @return A new Exabyte unit with the given value.
     */
    public static Exabyte exabyte(final long amount) {
        return new Exabyte(StorageUnit.BYTES_IN_A_EXABYTE.multiply(BigInteger.valueOf(amount)));
    }

    /**
     * @param amount
     *            The amount of zettabytes to create.
     * @return A new Zettabyte unit with the given value.
     */
    public static Zettabyte zettabyte(final long amount) {
        return new Zettabyte(StorageUnit.BYTES_IN_A_ZETTABYTE.multiply(BigInteger.valueOf(amount)));
    }

    /**
     * @param amount
     *            The amount of yottabytes to create.
     * @return A new Yottabyte unit with the given value.
     */
    public static Yottabyte yottabyte(final long amount) {
        return new Yottabyte(StorageUnit.BYTES_IN_A_YOTTABYTE.multiply(BigInteger.valueOf(amount)));
    }

}
