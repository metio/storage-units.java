/*
 * Copyright © 2012 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.units.storage;

import java.math.BigInteger;

import com.github.sebhoss.nullanalysis.Nullsafe;

/**
 * Zettabyte as specified in ISO IEC 80000-13:2008.
 */
public class Zettabyte extends StorageUnit<Zettabyte> {

    private static final long serialVersionUID = 8849006574018911826L;

    /**
     * @param numberOfBytes
     *            The amount of bytes the zettabytes contains.
     * @return A new Zettabyte unit with the given value.
     */
    public static Zettabyte valueOf(final long numberOfBytes) {
        return new Zettabyte(Nullsafe.nullsafe(BigInteger.valueOf(numberOfBytes)));
    }

    Zettabyte(final BigInteger bytes) {
        super(bytes);
    }

    @Override
    public Zettabyte add(final long bytesToAdd) {
        return new Zettabyte(Nullsafe.nullsafe(bytes.add(BigInteger.valueOf(bytesToAdd))));
    }

    @Override
    public Zettabyte add(final StorageUnit<?> storageAmount) {
        return new Zettabyte(Nullsafe.nullsafe(bytes.add(storageAmount.bytes)));
    }

    @Override
    public Zettabyte divide(final long divisor) {
        return new Zettabyte(Nullsafe.nullsafe(bytes.divide(BigInteger.valueOf(divisor))));
    }

    @Override
    public Zettabyte multiply(final long factor) {
        return new Zettabyte(Nullsafe.nullsafe(bytes.multiply(BigInteger.valueOf(factor))));
    }

    @Override
    public Zettabyte subtract(final long bytesToSubtract) {
        return new Zettabyte(Nullsafe.nullsafe(bytes.subtract(BigInteger.valueOf(bytesToSubtract))));
    }

    @Override
    public Zettabyte subtract(final StorageUnit<?> storageAmount) {
        return new Zettabyte(Nullsafe.nullsafe(bytes.subtract(storageAmount.bytes)));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_ZETTABYTE;
    }

    @Override
    protected String getSymbol() {
        return "ZB"; //$NON-NLS-1$
    }

}
