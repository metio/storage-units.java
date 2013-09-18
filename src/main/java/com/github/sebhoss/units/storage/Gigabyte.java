/* This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details. */
package com.github.sebhoss.units.storage;

import java.math.BigInteger;

import com.github.sebhoss.common.annotation.Nullsafe;

/**
 * Gigabyte as specified in ISO IEC 80000-13:2008.
 */
public class Gigabyte extends StorageUnit<Gigabyte> {

    private static final long serialVersionUID = 7581075190529125530L;

    /**
     * @param numberOfBytes
     *            The amount of bytes the gigabytes contains.
     * @return A new Gigabyte unit with the given value.
     */
    public static Gigabyte valueOf(final long numberOfBytes) {
        return new Gigabyte(Nullsafe.nullsafe(BigInteger.valueOf(numberOfBytes)));
    }

    Gigabyte(final BigInteger bytes) {
        super(bytes);
    }

    @Override
    public Gigabyte add(final long bytesToAdd) {
        return new Gigabyte(Nullsafe.nullsafe(bytes.add(BigInteger.valueOf(bytesToAdd))));
    }

    @Override
    public Gigabyte add(final StorageUnit<?> storageAmount) {
        return new Gigabyte(Nullsafe.nullsafe(bytes.add(storageAmount.bytes)));
    }

    @Override
    public Gigabyte divide(final long divisor) {
        return new Gigabyte(Nullsafe.nullsafe(bytes.divide(BigInteger.valueOf(divisor))));
    }

    @Override
    public Gigabyte multiply(final long factor) {
        return new Gigabyte(Nullsafe.nullsafe(bytes.multiply(BigInteger.valueOf(factor))));
    }

    @Override
    public Gigabyte subtract(final long bytesToSubtract) {
        return new Gigabyte(Nullsafe.nullsafe(bytes.subtract(BigInteger.valueOf(bytesToSubtract))));
    }

    @Override
    public Gigabyte subtract(final StorageUnit<?> storageAmount) {
        return new Gigabyte(Nullsafe.nullsafe(bytes.subtract(storageAmount.bytes)));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_GIGABYTE;
    }

    @Override
    protected String getSymbol() {
        return "GB"; //$NON-NLS-1$
    }

}
