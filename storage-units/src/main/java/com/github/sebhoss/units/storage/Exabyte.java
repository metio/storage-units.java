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
 * Exabyte as specified in ISO IEC 80000-13:2008.
 */
public class Exabyte extends StorageUnit<Exabyte> {

    private static final long serialVersionUID = 6846441733771841250L;

    /**
     * @param numberOfBytes
     *            The amount of bytes the exabytes contains.
     * @return A new Exabyte unit with the given value.
     */
    public static Exabyte valueOf(final long numberOfBytes) {
        return new Exabyte(Nullsafe.nullsafe(BigInteger.valueOf(numberOfBytes)));
    }

    Exabyte(final BigInteger bytes) {
        super(bytes);
    }

    @Override
    public Exabyte add(final long bytesToAdd) {
        return new Exabyte(Nullsafe.nullsafe(bytes.add(BigInteger.valueOf(bytesToAdd))));
    }

    @Override
    public Exabyte add(final StorageUnit<?> storageAmount) {
        return new Exabyte(Nullsafe.nullsafe(bytes.add(storageAmount.bytes)));
    }

    @Override
    public Exabyte divide(final long divisor) {
        return new Exabyte(Nullsafe.nullsafe(bytes.divide(BigInteger.valueOf(divisor))));
    }

    @Override
    public Exabyte multiply(final long factor) {
        return new Exabyte(Nullsafe.nullsafe(bytes.multiply(BigInteger.valueOf(factor))));
    }

    @Override
    public Exabyte subtract(final long bytesToSubtract) {
        return new Exabyte(Nullsafe.nullsafe(bytes.subtract(BigInteger.valueOf(bytesToSubtract))));
    }

    @Override
    public Exabyte subtract(final StorageUnit<?> storageAmount) {
        return new Exabyte(Nullsafe.nullsafe(bytes.subtract(storageAmount.bytes)));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_EXABYTE;
    }

    @Override
    protected String getSymbol() {
        return "EB"; //$NON-NLS-1$
    }

}
