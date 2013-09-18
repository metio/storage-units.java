/* This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details. */
package com.github.sebhoss.units.storage;

import java.math.BigInteger;

import com.github.sebhoss.common.annotation.Nullsafe;

/**
 * Exbibyte as specified in ISO IEC 80000-13:2008.
 */
public final class Exbibyte extends StorageUnit<Exbibyte> {

    private static final long serialVersionUID = 5993490571003918471L;

    /**
     * @param numberOfBytes
     *            The amount of bytes the exbibytes contains.
     * @return A new Exbibyte unit with the given value.
     */
    public static Exbibyte valueOf(final long numberOfBytes) {
        return new Exbibyte(Nullsafe.nullsafe(BigInteger.valueOf(numberOfBytes)));
    }

    Exbibyte(final BigInteger bytes) {
        super(bytes);
    }

    @Override
    public Exbibyte add(final long bytesToAdd) {
        return new Exbibyte(Nullsafe.nullsafe(bytes.add(BigInteger.valueOf(bytesToAdd))));
    }

    @Override
    public Exbibyte add(final StorageUnit<?> storageAmount) {
        return new Exbibyte(Nullsafe.nullsafe(bytes.add(storageAmount.bytes)));
    }

    @Override
    public Exbibyte divide(final long divisor) {
        return new Exbibyte(Nullsafe.nullsafe(bytes.divide(BigInteger.valueOf(divisor))));
    }

    @Override
    public Exbibyte multiply(final long factor) {
        return new Exbibyte(Nullsafe.nullsafe(bytes.multiply(BigInteger.valueOf(factor))));
    }

    @Override
    public Exbibyte subtract(final long bytesToSubtract) {
        return new Exbibyte(Nullsafe.nullsafe(bytes.subtract(BigInteger.valueOf(bytesToSubtract))));
    }

    @Override
    public Exbibyte subtract(final StorageUnit<?> storageAmount) {
        return new Exbibyte(Nullsafe.nullsafe(bytes.subtract(storageAmount.bytes)));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_EXBIBYTE;
    }

    @Override
    protected String getSymbol() {
        return "EiB"; //$NON-NLS-1$
    }

}
