/* This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details. */
package com.github.sebhoss.units.storage;

import java.math.BigInteger;

/**
 *
 */
public final class StorageUnits {

    /**
     * @param bytes
     *            The amount to bytes to represent.
     * @return The appropriate binary-prefixed unit for the given amount of bytes.
     */
    public static final StorageUnit<?> binaryValueOf(final long bytes) {
        StorageUnit<?> unit = Kibibyte.valueOf(bytes);

        if (bytes >= StorageUnit.BYTES_IN_A_MEBIBYTE.longValue() && bytes < StorageUnit.BYTES_IN_A_GIBIBYTE.longValue()) {
            unit = unit.asMebibyte();
        } else if (bytes >= StorageUnit.BYTES_IN_A_GIBIBYTE.longValue()
                && bytes < StorageUnit.BYTES_IN_A_TIBIBYTE.longValue()) {
            unit = unit.asGibibyte();
        } else if (bytes >= StorageUnit.BYTES_IN_A_TIBIBYTE.longValue()
                && bytes < StorageUnit.BYTES_IN_A_PEBIBYTE.longValue()) {
            unit = unit.asTibibyte();
        } else if (bytes >= StorageUnit.BYTES_IN_A_PEBIBYTE.longValue()
                && bytes < StorageUnit.BYTES_IN_A_EXBIBYTE.longValue()) {
            unit = unit.asPebibyte();
        } else if (bytes >= StorageUnit.BYTES_IN_A_EXBIBYTE.longValue()
                && bytes < StorageUnit.BYTES_IN_A_ZEBIBYTE.longValue()) {
            unit = unit.asExbibyte();
        } else if (bytes >= StorageUnit.BYTES_IN_A_ZEBIBYTE.longValue()
                && bytes < StorageUnit.BYTES_IN_A_YOBIBYTE.longValue()) {
            unit = unit.asZebibyte();
        } else if (bytes >= StorageUnit.BYTES_IN_A_YOBIBYTE.longValue()) {
            unit = unit.asYobibyte();
        }

        return unit;
    }

    /**
     * @param bytes
     *            The amount of bytes to represent.
     * @return The appropriate metric-prefixed unit for the given amount of bytes.
     */
    public static final StorageUnit<?> metricValueOf(final long bytes) {
        StorageUnit<?> unit = Kilobyte.valueOf(bytes);
    
        if (bytes >= StorageUnit.BYTES_IN_A_MEGABYTE.longValue() && bytes < StorageUnit.BYTES_IN_A_GIGABYTE.longValue()) {
            unit = unit.asMegabyte();
        } else if (bytes >= StorageUnit.BYTES_IN_A_GIGABYTE.longValue()
                && bytes < StorageUnit.BYTES_IN_A_TERABYTE.longValue()) {
            unit = unit.asGigabyte();
        } else if (bytes >= StorageUnit.BYTES_IN_A_TERABYTE.longValue()
                && bytes < StorageUnit.BYTES_IN_A_PETABYTE.longValue()) {
            unit = unit.asTerabyte();
        } else if (bytes >= StorageUnit.BYTES_IN_A_PETABYTE.longValue()
                && bytes < StorageUnit.BYTES_IN_A_EXABYTE.longValue()) {
            unit = unit.asPetabyte();
        } else if (bytes >= StorageUnit.BYTES_IN_A_EXABYTE.longValue()
                && bytes < StorageUnit.BYTES_IN_A_ZETTABYTE.longValue()) {
            unit = unit.asExabyte();
        } else if (bytes >= StorageUnit.BYTES_IN_A_ZETTABYTE.longValue()
                && bytes < StorageUnit.BYTES_IN_A_YOTTABYTE.longValue()) {
            unit = unit.asZettabyte();
        } else if (bytes >= StorageUnit.BYTES_IN_A_YOTTABYTE.longValue()) {
            unit = unit.asYottabyte();
        }
    
        return unit;
    }

    /**
     * @param amount
     *            The amount of kibibytes to create.
     * @return A new Kibibyte unit with the given value.
     */
    public static final Kibibyte kibibyte(final long amount) {
        return new Kibibyte(StorageUnit.BYTES_IN_A_KIBIBYTE.multiply(BigInteger.valueOf(amount)));
    }

    /**
     * @param amount
     *            The amount of mebibytes to create.
     * @return A new Mebibyte unit with the given value.
     */
    public static final Mebibyte mebibyte(final long amount) {
        return new Mebibyte(StorageUnit.BYTES_IN_A_MEBIBYTE.multiply(BigInteger.valueOf(amount)));
    }

    /**
     * @param amount
     *            The amount of gibibytes to create.
     * @return A new Gibibyte unit with the given value.
     */
    public static final Gibibyte gibibyte(final long amount) {
        return new Gibibyte(StorageUnit.BYTES_IN_A_GIBIBYTE.multiply(BigInteger.valueOf(amount)));
    }

    /**
     * @param amount
     *            The amount of tibibytes to create.
     * @return A new Tibibyte unit with the given value.
     */
    public static final Tibibyte tibibyte(final long amount) {
        return new Tibibyte(StorageUnit.BYTES_IN_A_TIBIBYTE.multiply(BigInteger.valueOf(amount)));
    }

    /**
     * @param amount
     *            The amount of pebibytes to create.
     * @return A new Pebibyte unit with the given value.
     */
    public static final Pebibyte pebibyte(final long amount) {
        return new Pebibyte(StorageUnit.BYTES_IN_A_PEBIBYTE.multiply(BigInteger.valueOf(amount)));
    }

    /**
     * @param amount
     *            The amount of exbibytes to create.
     * @return A new Exbibyte unit with the given value.
     */
    public static final Exbibyte exbibyte(final long amount) {
        return new Exbibyte(StorageUnit.BYTES_IN_A_EXBIBYTE.multiply(BigInteger.valueOf(amount)));
    }

    /**
     * @param amount
     *            The amount of zebibytes to create.
     * @return A new Zebibyte unit with the given value.
     */
    public static final Zebibyte zebibyte(final long amount) {
        return new Zebibyte(StorageUnit.BYTES_IN_A_ZEBIBYTE.multiply(BigInteger.valueOf(amount)));
    }

    /**
     * @param amount
     *            The amount of yobibytes to create.
     * @return A new Yobibyte unit with the given value.
     */
    public static final Yobibyte yobibyte(final long amount) {
        return new Yobibyte(StorageUnit.BYTES_IN_A_YOBIBYTE.multiply(BigInteger.valueOf(amount)));
    }

    /**
     * @param amount
     *            The amount of kilobytes to create.
     * @return A new Kilobyte unit with the given value.
     */
    public static final Kilobyte kilobyte(final long amount) {
        return new Kilobyte(StorageUnit.BYTES_IN_A_KILOBYTE.multiply(BigInteger.valueOf(amount)));
    }

    /**
     * @param amount
     *            The amount of megabytes to create.
     * @return A new Megabyte unit with the given value.
     */
    public static final Megabyte megabyte(final long amount) {
        return new Megabyte(StorageUnit.BYTES_IN_A_MEGABYTE.multiply(BigInteger.valueOf(amount)));
    }

    /**
     * @param amount
     *            The amount of gigabytes to create.
     * @return A new Gigabyte unit with the given value.
     */
    public static final Gigabyte gigabyte(final long amount) {
        return new Gigabyte(StorageUnit.BYTES_IN_A_GIGABYTE.multiply(BigInteger.valueOf(amount)));
    }

    /**
     * @param amount
     *            The amount of terabytes to create.
     * @return A new Terabyte unit with the given value.
     */
    public static final Terabyte terabyte(final long amount) {
        return new Terabyte(StorageUnit.BYTES_IN_A_TERABYTE.multiply(BigInteger.valueOf(amount)));
    }

    /**
     * @param amount
     *            The amount of petabytes to create.
     * @return A new Petabyte unit with the given value.
     */
    public static final Petabyte petabyte(final long amount) {
        return new Petabyte(StorageUnit.BYTES_IN_A_PETABYTE.multiply(BigInteger.valueOf(amount)));
    }

    /**
     * @param amount
     *            The amount of exabytes to create.
     * @return A new Exabyte unit with the given value.
     */
    public static final Exabyte exabyte(final long amount) {
        return new Exabyte(StorageUnit.BYTES_IN_A_EXABYTE.multiply(BigInteger.valueOf(amount)));
    }

    /**
     * @param amount
     *            The amount of zettabytes to create.
     * @return A new Zettabyte unit with the given value.
     */
    public static final Zettabyte zettabyte(final long amount) {
        return new Zettabyte(StorageUnit.BYTES_IN_A_ZETTABYTE.multiply(BigInteger.valueOf(amount)));
    }

    /**
     * @param amount
     *            The amount of yottabytes to create.
     * @return A new Yottabyte unit with the given value.
     */
    public static final Yottabyte yottabyte(final long amount) {
        return new Yottabyte(StorageUnit.BYTES_IN_A_YOTTABYTE.multiply(BigInteger.valueOf(amount)));
    }

    private StorageUnits() {
        // Hidden constructor.
    }

}
