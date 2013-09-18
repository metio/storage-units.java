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
 * Zebibyte as specified in ISO IEC 80000-13:2008.
 */
public final class Zebibyte extends StorageUnit<Zebibyte> {

    private static final long serialVersionUID = 2192254824473341887L;

    /**
     * @param numberOfBytes
     *            The amount of bytes the zebibytes contains.
     * @return A new Zebibyte unit with the given value.
     */
    public static Zebibyte valueOf(final long numberOfBytes) {
        return new Zebibyte(Nullsafe.nullsafe(BigInteger.valueOf(numberOfBytes)));
    }

    Zebibyte(final BigInteger bytes) {
        super(bytes);
    }

    @Override
    public Zebibyte add(final long bytesToAdd) {
        return new Zebibyte(Nullsafe.nullsafe(bytes.add(BigInteger.valueOf(bytesToAdd))));
    }

    @Override
    public Zebibyte add(final StorageUnit<?> storageAmount) {
        return new Zebibyte(Nullsafe.nullsafe(bytes.add(storageAmount.bytes)));
    }

    @Override
    public Zebibyte divide(final long divisor) {
        return new Zebibyte(Nullsafe.nullsafe(bytes.divide(BigInteger.valueOf(divisor))));
    }

    @Override
    public Zebibyte multiply(final long factor) {
        return new Zebibyte(Nullsafe.nullsafe(bytes.multiply(BigInteger.valueOf(factor))));
    }

    @Override
    public Zebibyte subtract(final long bytesToSubtract) {
        return new Zebibyte(Nullsafe.nullsafe(bytes.subtract(BigInteger.valueOf(bytesToSubtract))));
    }

    @Override
    public Zebibyte subtract(final StorageUnit<?> storageAmount) {
        return new Zebibyte(Nullsafe.nullsafe(bytes.subtract(storageAmount.bytes)));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_ZEBIBYTE;
    }

    @Override
    protected String getSymbol() {
        return "ZiB"; //$NON-NLS-1$
    }

}
