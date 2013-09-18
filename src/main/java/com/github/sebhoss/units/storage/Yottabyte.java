/* This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details. */
package com.github.sebhoss.units.storage;

import java.math.BigInteger;

import com.github.sebhoss.common.annotation.Nullsafe;

/**
 * Yottabyte as specified in ISO IEC 80000-13:2008.
 */
public class Yottabyte extends StorageUnit<Yottabyte> {

    private static final long serialVersionUID = 2482152459842042316L;

    /**
     * @param numberOfBytes
     *            The amount of bytes the yottabytes contains.
     * @return A new Yottabyte unit with the given value.
     */
    public static Yottabyte valueOf(final long numberOfBytes) {
        return new Yottabyte(Nullsafe.nullsafe(BigInteger.valueOf(numberOfBytes)));
    }

    Yottabyte(final BigInteger bytes) {
        super(bytes);
    }

    @Override
    public Yottabyte add(final long bytesToAdd) {
        return new Yottabyte(Nullsafe.nullsafe(bytes.add(BigInteger.valueOf(bytesToAdd))));
    }

    @Override
    public Yottabyte add(final StorageUnit<?> storageAmount) {
        return new Yottabyte(Nullsafe.nullsafe(bytes.add(storageAmount.bytes)));
    }

    @Override
    public Yottabyte divide(final long divisor) {
        return new Yottabyte(Nullsafe.nullsafe(bytes.divide(BigInteger.valueOf(divisor))));
    }

    @Override
    public Yottabyte multiply(final long factor) {
        return new Yottabyte(Nullsafe.nullsafe(bytes.multiply(BigInteger.valueOf(factor))));
    }

    @Override
    public Yottabyte subtract(final long bytesToSubtract) {
        return new Yottabyte(Nullsafe.nullsafe(bytes.subtract(BigInteger.valueOf(bytesToSubtract))));
    }

    @Override
    public Yottabyte subtract(final StorageUnit<?> storageAmount) {
        return new Yottabyte(Nullsafe.nullsafe(bytes.subtract(storageAmount.bytes)));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_YOTTABYTE;
    }

    @Override
    protected String getSymbol() {
        return "YB"; //$NON-NLS-1$
    }

}
