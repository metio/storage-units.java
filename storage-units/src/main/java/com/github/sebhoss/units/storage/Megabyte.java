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
 * Megabyte as specified in ISO IEC 80000-13:2008.
 */
public class Megabyte extends StorageUnit<Megabyte> {

    private static final long serialVersionUID = 5901923092058760111L;

    /**
     * @param numberOfBytes
     *            The amount of bytes the megabytes contains.
     * @return A new Megabyte unit with the given value.
     */
    public static Megabyte valueOf(final long numberOfBytes) {
        return new Megabyte(Nullsafe.nullsafe(BigInteger.valueOf(numberOfBytes)));
    }

    Megabyte(final BigInteger bytes) {
        super(bytes);
    }

    @Override
    public Megabyte add(final long bytesToAdd) {
        return new Megabyte(Nullsafe.nullsafe(bytes.add(BigInteger.valueOf(bytesToAdd))));
    }

    @Override
    public Megabyte add(final StorageUnit<?> storageAmount) {
        return new Megabyte(Nullsafe.nullsafe(bytes.add(storageAmount.bytes)));
    }

    @Override
    public Megabyte divide(final long divisor) {
        return new Megabyte(Nullsafe.nullsafe(bytes.divide(BigInteger.valueOf(divisor))));
    }

    @Override
    public Megabyte multiply(final long factor) {
        return new Megabyte(Nullsafe.nullsafe(bytes.multiply(BigInteger.valueOf(factor))));
    }

    @Override
    public Megabyte subtract(final long bytesToSubtract) {
        return new Megabyte(Nullsafe.nullsafe(bytes.subtract(BigInteger.valueOf(bytesToSubtract))));
    }

    @Override
    public Megabyte subtract(final StorageUnit<?> storageAmount) {
        return new Megabyte(Nullsafe.nullsafe(bytes.subtract(storageAmount.bytes)));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_MEGABYTE;
    }

    @Override
    protected String getSymbol() {
        return "MB"; //$NON-NLS-1$
    }

}
