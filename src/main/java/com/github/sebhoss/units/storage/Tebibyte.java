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
 * Tebibyte as specified in ISO IEC 80000-13:2008.
 */
public final class Tebibyte extends StorageUnit<Tebibyte> {

    /** Generated */
    private static final long serialVersionUID = 3614537130129620881L;

    /**
     * @param numberOfBytes
     *            The amount of bytes the tebibytes contains.
     * @return A new Tebibyte unit with the given value.
     */
    public static Tebibyte valueOf(final long numberOfBytes) {
        return new Tebibyte(Nullsafe.nullsafe(BigInteger.valueOf(numberOfBytes)));
    }

    Tebibyte(final BigInteger bytes) {
        super(bytes);
    }

    @Override
    public Tebibyte add(final long bytesToAdd) {
        return new Tebibyte(Nullsafe.nullsafe(bytes.add(BigInteger.valueOf(bytesToAdd))));
    }

    @Override
    public Tebibyte add(final StorageUnit<?> storageAmount) {
        return new Tebibyte(Nullsafe.nullsafe(bytes.add(storageAmount.bytes)));
    }

    @Override
    public Tebibyte divide(final long divisor) {
        return new Tebibyte(Nullsafe.nullsafe(bytes.divide(BigInteger.valueOf(divisor))));
    }

    @Override
    public Tebibyte multiply(final long factor) {
        return new Tebibyte(Nullsafe.nullsafe(bytes.multiply(BigInteger.valueOf(factor))));
    }

    @Override
    public Tebibyte subtract(final long bytesToSubtract) {
        return new Tebibyte(Nullsafe.nullsafe(bytes.subtract(BigInteger.valueOf(bytesToSubtract))));
    }

    @Override
    public Tebibyte subtract(final StorageUnit<?> storageAmount) {
        return new Tebibyte(Nullsafe.nullsafe(bytes.subtract(storageAmount.bytes)));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_TEBIBYTE;
    }

    @Override
    protected String getSymbol() {
        return "TiB"; //$NON-NLS-1$
    }

}
