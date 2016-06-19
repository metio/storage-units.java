/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.utils.storage_unit;

import static de.xn__ho_hia.quality.null_analysis.NullsafeMath.asBigInteger;
import static de.xn__ho_hia.quality.null_analysis.NullsafeMath.multiplyNullsafe;

import java.math.BigInteger;

import org.eclipse.jdt.annotation.NonNull;

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
        return binaryValueOf(asBigInteger(bytes));
    }

    /**
     * @param bytes
     *            The amount to bytes to represent.
     * @return The appropriate binary-prefixed unit for the given amount of bytes.
     */
    public static StorageUnit<?> binaryValueOf(@NonNull final BigInteger bytes) {
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
        return metricValueOf(asBigInteger(bytes));
    }

    /**
     * @param bytes
     *            The amount of bytes to represent.
     * @return The appropriate metric-prefixed unit for the given amount of bytes.
     */
    public static StorageUnit<?> metricValueOf(@NonNull final BigInteger bytes) {
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
        return value.compareTo(comparison) >= 0;
    }

    /**
     * @param amount
     *            The amount of kibibytes to create.
     * @return A new Kibibyte unit with the given value.
     */
    @NonNull
    public static Kibibyte kibibyte(@NonNull final Long amount) {
        return kibibyte(amount.longValue());
    }

    /**
     * @param amount
     *            The amount of kibibytes to create.
     * @return A new Kibibyte unit with the given value.
     */
    @NonNull
    public static Kibibyte kibibyte(final long amount) {
        return kibibyte(asBigInteger(amount));
    }

    /**
     * @param amount
     *            The amount of kibibytes to create.
     * @return A new Kibibyte unit with the given value.
     */
    @NonNull
    public static Kibibyte kibibyte(@NonNull final BigInteger amount) {
        return new Kibibyte(multiplyNullsafe(StorageUnit.BYTES_IN_A_KIBIBYTE, amount));
    }

    /**
     * @param amount
     *            The amount of mebibytes to create.
     * @return A new Mebibyte unit with the given value.
     */
    @NonNull
    public static Mebibyte mebibyte(@NonNull final Long amount) {
        return mebibyte(amount.longValue());
    }

    /**
     * @param amount
     *            The amount of mebibytes to create.
     * @return A new Mebibyte unit with the given value.
     */
    @NonNull
    public static Mebibyte mebibyte(final long amount) {
        return mebibyte(asBigInteger(amount));
    }

    /**
     * @param amount
     *            The amount of mebibytes to create.
     * @return A new Mebibyte unit with the given value.
     */
    @NonNull
    public static Mebibyte mebibyte(@NonNull final BigInteger amount) {
        return new Mebibyte(multiplyNullsafe(StorageUnit.BYTES_IN_A_MEBIBYTE, amount));
    }

    /**
     * @param amount
     *            The amount of gibibytes to create.
     * @return A new Gibibyte unit with the given value.
     */
    @NonNull
    public static Gibibyte gibibyte(@NonNull final Long amount) {
        return gibibyte(amount.longValue());
    }

    /**
     * @param amount
     *            The amount of gibibytes to create.
     * @return A new Gibibyte unit with the given value.
     */
    @NonNull
    public static Gibibyte gibibyte(final long amount) {
        return gibibyte(asBigInteger(amount));
    }

    /**
     * @param amount
     *            The amount of gibibytes to create.
     * @return A new Gibibyte unit with the given value.
     */
    @NonNull
    public static Gibibyte gibibyte(@NonNull final BigInteger amount) {
        return new Gibibyte(multiplyNullsafe(StorageUnit.BYTES_IN_A_GIBIBYTE, amount));
    }

    /**
     * @param amount
     *            The amount of tebibytes to create.
     * @return A new Tebibyte unit with the given value.
     */
    @NonNull
    public static Tebibyte tebibyte(@NonNull final Long amount) {
        return tebibyte(amount.longValue());
    }

    /**
     * @param amount
     *            The amount of tebibytes to create.
     * @return A new Tebibyte unit with the given value.
     */
    @NonNull
    public static Tebibyte tebibyte(final long amount) {
        return tebibyte(asBigInteger(amount));
    }

    /**
     * @param amount
     *            The amount of tebibytes to create.
     * @return A new Tebibyte unit with the given value.
     */
    @NonNull
    public static Tebibyte tebibyte(@NonNull final BigInteger amount) {
        return new Tebibyte(multiplyNullsafe(StorageUnit.BYTES_IN_A_TEBIBYTE, amount));
    }

    /**
     * @param amount
     *            The amount of pebibytes to create.
     * @return A new Pebibyte unit with the given value.
     */
    @NonNull
    public static Pebibyte pebibyte(@NonNull final Long amount) {
        return pebibyte(amount.longValue());
    }

    /**
     * @param amount
     *            The amount of pebibytes to create.
     * @return A new Pebibyte unit with the given value.
     */
    @NonNull
    public static Pebibyte pebibyte(final long amount) {
        return pebibyte(asBigInteger(amount));
    }

    /**
     * @param amount
     *            The amount of pebibytes to create.
     * @return A new Pebibyte unit with the given value.
     */
    @NonNull
    public static Pebibyte pebibyte(@NonNull final BigInteger amount) {
        return new Pebibyte(multiplyNullsafe(StorageUnit.BYTES_IN_A_PEBIBYTE, amount));
    }

    /**
     * @param amount
     *            The amount of exbibytes to create.
     * @return A new Exbibyte unit with the given value.
     */
    @NonNull
    public static Exbibyte exbibyte(@NonNull final Long amount) {
        return exbibyte(amount.longValue());
    }

    /**
     * @param amount
     *            The amount of exbibytes to create.
     * @return A new Exbibyte unit with the given value.
     */
    @NonNull
    public static Exbibyte exbibyte(final long amount) {
        return exbibyte(asBigInteger(amount));
    }

    /**
     * @param amount
     *            The amount of exbibytes to create.
     * @return A new Exbibyte unit with the given value.
     */
    @NonNull
    public static Exbibyte exbibyte(@NonNull final BigInteger amount) {
        return new Exbibyte(multiplyNullsafe(StorageUnit.BYTES_IN_A_EXBIBYTE, amount));
    }

    /**
     * @param amount
     *            The amount of zebibytes to create.
     * @return A new Zebibyte unit with the given value.
     */
    @NonNull
    public static Zebibyte zebibyte(@NonNull final Long amount) {
        return zebibyte(amount.longValue());
    }

    /**
     * @param amount
     *            The amount of zebibytes to create.
     * @return A new Zebibyte unit with the given value.
     */
    @NonNull
    public static Zebibyte zebibyte(final long amount) {
        return zebibyte(asBigInteger(amount));
    }

    /**
     * @param amount
     *            The amount of zebibytes to create.
     * @return A new Zebibyte unit with the given value.
     */
    @NonNull
    public static Zebibyte zebibyte(@NonNull final BigInteger amount) {
        return new Zebibyte(multiplyNullsafe(StorageUnit.BYTES_IN_A_ZEBIBYTE, amount));
    }

    /**
     * @param amount
     *            The amount of yobibytes to create.
     * @return A new Yobibyte unit with the given value.
     */
    @NonNull
    public static Yobibyte yobibyte(@NonNull final Long amount) {
        return yobibyte(amount.longValue());
    }

    /**
     * @param amount
     *            The amount of yobibytes to create.
     * @return A new Yobibyte unit with the given value.
     */
    @NonNull
    public static Yobibyte yobibyte(final long amount) {
        return yobibyte(asBigInteger(amount));
    }

    /**
     * @param amount
     *            The amount of yobibytes to create.
     * @return A new Yobibyte unit with the given value.
     */
    @NonNull
    public static Yobibyte yobibyte(@NonNull final BigInteger amount) {
        return new Yobibyte(multiplyNullsafe(StorageUnit.BYTES_IN_A_YOBIBYTE, amount));
    }

    /**
     * @param amount
     *            The amount of kilobytes to create.
     * @return A new Kilobyte unit with the given value.
     */
    @NonNull
    public static Kilobyte kilobyte(final long amount) {
        return new Kilobyte(multiplyNullsafe(StorageUnit.BYTES_IN_A_KILOBYTE, asBigInteger(amount)));
    }

    /**
     * @param amount
     *            The amount of megabytes to create.
     * @return A new Megabyte unit with the given value.
     */
    @NonNull
    public static Megabyte megabyte(final long amount) {
        return new Megabyte(multiplyNullsafe(StorageUnit.BYTES_IN_A_MEGABYTE, asBigInteger(amount)));
    }

    /**
     * @param amount
     *            The amount of gigabytes to create.
     * @return A new Gigabyte unit with the given value.
     */
    @NonNull
    public static Gigabyte gigabyte(final long amount) {
        return new Gigabyte(multiplyNullsafe(StorageUnit.BYTES_IN_A_GIGABYTE, asBigInteger(amount)));
    }

    /**
     * @param amount
     *            The amount of terabytes to create.
     * @return A new Terabyte unit with the given value.
     */
    @NonNull
    public static Terabyte terabyte(final long amount) {
        return new Terabyte(multiplyNullsafe(StorageUnit.BYTES_IN_A_TERABYTE, asBigInteger(amount)));
    }

    /**
     * @param amount
     *            The amount of petabytes to create.
     * @return A new Petabyte unit with the given value.
     */
    @NonNull
    public static Petabyte petabyte(final long amount) {
        return new Petabyte(multiplyNullsafe(StorageUnit.BYTES_IN_A_PETABYTE, asBigInteger(amount)));
    }

    /**
     * @param amount
     *            The amount of exabytes to create.
     * @return A new Exabyte unit with the given value.
     */
    @NonNull
    public static Exabyte exabyte(final long amount) {
        return new Exabyte(multiplyNullsafe(StorageUnit.BYTES_IN_A_EXABYTE, asBigInteger(amount)));
    }

    /**
     * @param amount
     *            The amount of zettabytes to create.
     * @return A new Zettabyte unit with the given value.
     */
    @NonNull
    public static Zettabyte zettabyte(final long amount) {
        return new Zettabyte(multiplyNullsafe(StorageUnit.BYTES_IN_A_ZETTABYTE, asBigInteger(amount)));
    }

    /**
     * @param amount
     *            The amount of yottabytes to create.
     * @return A new Yottabyte unit with the given value.
     */
    @NonNull
    public static Yottabyte yottabyte(final long amount) {
        return new Yottabyte(multiplyNullsafe(StorageUnit.BYTES_IN_A_YOTTABYTE, asBigInteger(amount)));
    }

}
