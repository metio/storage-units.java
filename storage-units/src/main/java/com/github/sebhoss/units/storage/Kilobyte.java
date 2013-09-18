/*
 * Copyright © 2012 Sebastian Hoß <mail@shoss.de>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See http://www.wtfpl.net/ for more details.
 */
package com.github.sebhoss.units.storage;

import java.math.BigInteger;

import com.github.sebhoss.common.annotation.Nullsafe;

/**
 * Kilobyte as specified in ISO IEC 80000-13:2008.
 */
public class Kilobyte extends StorageUnit<Kilobyte> {

    private static final long serialVersionUID = 6952239416014811456L;

    /**
     * @param numberOfBytes
     *            The amount of bytes the kilobytes contains.
     * @return A new Kilobyte unit with the given value.
     */
    public static Kilobyte valueOf(final long numberOfBytes) {
        return new Kilobyte(Nullsafe.nullsafe(BigInteger.valueOf(numberOfBytes)));
    }

    Kilobyte(final BigInteger numberOfBytes) {
        super(numberOfBytes);
    }

    @Override
    public Kilobyte add(final long bytesToAdd) {
        return new Kilobyte(Nullsafe.nullsafe(bytes.add(BigInteger.valueOf(bytesToAdd))));
    }

    @Override
    public Kilobyte add(final StorageUnit<?> storageAmount) {
        return new Kilobyte(Nullsafe.nullsafe(bytes.add(storageAmount.bytes)));
    }

    @Override
    public Kilobyte divide(final long divisor) {
        return new Kilobyte(Nullsafe.nullsafe(bytes.divide(BigInteger.valueOf(divisor))));
    }

    @Override
    public Kilobyte multiply(final long factor) {
        return new Kilobyte(Nullsafe.nullsafe(bytes.multiply(BigInteger.valueOf(factor))));
    }

    @Override
    public Kilobyte subtract(final long bytesToSubtract) {
        return new Kilobyte(Nullsafe.nullsafe(bytes.subtract(BigInteger.valueOf(bytesToSubtract))));
    }

    @Override
    public Kilobyte subtract(final StorageUnit<?> storageAmount) {
        return new Kilobyte(Nullsafe.nullsafe(bytes.subtract(storageAmount.bytes)));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_KILOBYTE;
    }

    @Override
    protected String getSymbol() {
        return "kB"; //$NON-NLS-1$
    }

}
