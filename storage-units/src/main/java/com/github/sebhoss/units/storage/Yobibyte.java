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
 * Yobibyte as specified in ISO IEC 80000-13:2008.
 */
public final class Yobibyte extends StorageUnit<Yobibyte> {

    /** Generated */
    private static final long serialVersionUID = -5606322878020884194L;

    /**
     * @param numberOfBytes
     *            The amount of bytes the yobibytes contains.
     * @return A new Yobibyte unit with the given value.
     */
    public static Yobibyte valueOf(final long numberOfBytes) {
        return new Yobibyte(Nullsafe.nullsafe(BigInteger.valueOf(numberOfBytes)));
    }

    Yobibyte(final BigInteger bytes) {
        super(bytes);
    }

    @Override
    public Yobibyte add(final long bytesToAdd) {
        return new Yobibyte(Nullsafe.nullsafe(bytes.add(BigInteger.valueOf(bytesToAdd))));
    }

    @Override
    public Yobibyte add(final StorageUnit<?> storageAmount) {
        return new Yobibyte(Nullsafe.nullsafe(bytes.add(storageAmount.bytes)));
    }

    @Override
    public Yobibyte divide(final long divisor) {
        return new Yobibyte(Nullsafe.nullsafe(bytes.divide(BigInteger.valueOf(divisor))));
    }

    @Override
    public Yobibyte multiply(final long factor) {
        return new Yobibyte(Nullsafe.nullsafe(bytes.multiply(BigInteger.valueOf(factor))));
    }

    @Override
    public Yobibyte subtract(final long bytesToSubtract) {
        return new Yobibyte(Nullsafe.nullsafe(bytes.subtract(BigInteger.valueOf(bytesToSubtract))));
    }

    @Override
    public Yobibyte subtract(final StorageUnit<?> storageAmount) {
        return new Yobibyte(Nullsafe.nullsafe(bytes.subtract(storageAmount.bytes)));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_YOBIBYTE;
    }

    @Override
    protected String getSymbol() {
        return "YiB"; //$NON-NLS-1$
    }

}
