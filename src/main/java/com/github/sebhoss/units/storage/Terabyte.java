/* This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details. */
package com.github.sebhoss.units.storage;

import java.math.BigInteger;

import com.github.sebhoss.common.annotation.Nullsafe;

/**
 * Terabyte as specified in ISO IEC 80000-13:2008.
 */
public class Terabyte extends StorageUnit<Terabyte> {

    private static final long serialVersionUID = 2160488069631638952L;

    /**
     * @param numberOfBytes
     *            The amount of bytes the terabytes contains.
     * @return A new Terabyte unit with the given value.
     */
    public static Terabyte valueOf(final long numberOfBytes) {
        return new Terabyte(Nullsafe.nullsafe(BigInteger.valueOf(numberOfBytes)));
    }

    Terabyte(final BigInteger bytes) {
        super(bytes);
    }

    @Override
    public Terabyte add(final long bytesToAdd) {
        return new Terabyte(Nullsafe.nullsafe(bytes.add(BigInteger.valueOf(bytesToAdd))));
    }

    @Override
    public Terabyte add(final StorageUnit<?> storageAmount) {
        return new Terabyte(Nullsafe.nullsafe(bytes.add(storageAmount.bytes)));
    }

    @Override
    public Terabyte divide(final long divisor) {
        return new Terabyte(Nullsafe.nullsafe(bytes.divide(BigInteger.valueOf(divisor))));
    }

    @Override
    public Terabyte multiply(final long factor) {
        return new Terabyte(Nullsafe.nullsafe(bytes.multiply(BigInteger.valueOf(factor))));
    }

    @Override
    public Terabyte subtract(final long bytesToSubtract) {
        return new Terabyte(Nullsafe.nullsafe(bytes.subtract(BigInteger.valueOf(bytesToSubtract))));
    }

    @Override
    public Terabyte subtract(final StorageUnit<?> storageAmount) {
        return new Terabyte(Nullsafe.nullsafe(bytes.subtract(storageAmount.bytes)));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_TERABYTE;
    }

    @Override
    protected String getSymbol() {
        return "TB"; //$NON-NLS-1$
    }

}
