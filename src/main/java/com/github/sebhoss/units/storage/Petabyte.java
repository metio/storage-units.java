/* This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details. */
package com.github.sebhoss.units.storage;

import java.math.BigInteger;

import com.github.sebhoss.common.annotation.Nullsafe;

/**
 * Petabyte as specified in ISO IEC 80000-13:2008.
 */
public class Petabyte extends StorageUnit<Petabyte> {

    private static final long serialVersionUID = 5889808368085688387L;

    /**
     * @param numberOfBytes
     *            The amount of bytes the petabytes contains.
     * @return A new Petabyte unit with the given value.
     */
    public static Petabyte valueOf(final long numberOfBytes) {
        return new Petabyte(Nullsafe.nullsafe(BigInteger.valueOf(numberOfBytes)));
    }

    Petabyte(final BigInteger bytes) {
        super(bytes);
    }

    @Override
    public Petabyte add(final long bytesToAdd) {
        return new Petabyte(Nullsafe.nullsafe(bytes.add(BigInteger.valueOf(bytesToAdd))));
    }

    @Override
    public Petabyte add(final StorageUnit<?> storageAmount) {
        return new Petabyte(Nullsafe.nullsafe(bytes.add(storageAmount.bytes)));
    }

    @Override
    public Petabyte divide(final long divisor) {
        return new Petabyte(Nullsafe.nullsafe(bytes.divide(BigInteger.valueOf(divisor))));
    }

    @Override
    public Petabyte multiply(final long factor) {
        return new Petabyte(Nullsafe.nullsafe(bytes.multiply(BigInteger.valueOf(factor))));
    }

    @Override
    public Petabyte subtract(final long bytesToSubtract) {
        return new Petabyte(Nullsafe.nullsafe(bytes.subtract(BigInteger.valueOf(bytesToSubtract))));
    }

    @Override
    public Petabyte subtract(final StorageUnit<?> storageAmount) {
        return new Petabyte(Nullsafe.nullsafe(bytes.subtract(storageAmount.bytes)));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_PETABYTE;
    }

    @Override
    protected String getSymbol() {
        return "PB"; //$NON-NLS-1$
    }

}
