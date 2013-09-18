/* This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details. */
package com.github.sebhoss.units.storage;

import java.math.BigInteger;

import com.github.sebhoss.common.annotation.Nullsafe;

/**
 * Pebibyte as specified in ISO IEC 80000-13:2008.
 */
public final class Pebibyte extends StorageUnit<Pebibyte> {

    private static final long serialVersionUID = -6112472064345339882L;

    /**
     * @param numberOfBytes
     *            The amount of bytes the pebibytes contains.
     * @return A new Pebibyte unit with the given value.
     */
    public static Pebibyte valueOf(final long numberOfBytes) {
        return new Pebibyte(Nullsafe.nullsafe(BigInteger.valueOf(numberOfBytes)));
    }

    Pebibyte(final BigInteger bytes) {
        super(bytes);
    }

    @Override
    public Pebibyte add(final long bytesToAdd) {
        return new Pebibyte(Nullsafe.nullsafe(bytes.add(BigInteger.valueOf(bytesToAdd))));
    }

    @Override
    public Pebibyte add(final StorageUnit<?> storageAmount) {
        return new Pebibyte(Nullsafe.nullsafe(bytes.add(storageAmount.bytes)));
    }

    @Override
    public Pebibyte divide(final long divisor) {
        return new Pebibyte(Nullsafe.nullsafe(bytes.divide(BigInteger.valueOf(divisor))));
    }

    @Override
    public Pebibyte multiply(final long factor) {
        return new Pebibyte(Nullsafe.nullsafe(bytes.multiply(BigInteger.valueOf(factor))));
    }

    @Override
    public Pebibyte subtract(final long bytesToSubtract) {
        return new Pebibyte(Nullsafe.nullsafe(bytes.subtract(BigInteger.valueOf(bytesToSubtract))));
    }

    @Override
    public Pebibyte subtract(final StorageUnit<?> storageAmount) {
        return new Pebibyte(Nullsafe.nullsafe(bytes.subtract(storageAmount.bytes)));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_PEBIBYTE;
    }

    @Override
    protected String getSymbol() {
        return "PiB"; //$NON-NLS-1$
    }

}
