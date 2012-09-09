/* This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details. */
package com.github.sebhoss.units.storage;

import java.math.BigInteger;

/**
 * Kibibyte as specified in ISO IEC 80000-13:2008.
 */
public final class Kibibyte extends StorageUnit<Kibibyte> {

    private static final long serialVersionUID = 3798828851496657978L;

    /**
     * @param numberOfBytes
     *            The amount of bytes the kibibytes contains.
     * @return A new Kibibyte unit with the given value.
     */
    public static Kibibyte valueOf(final long numberOfBytes) {
        return new Kibibyte(BigInteger.valueOf(numberOfBytes));
    }

    Kibibyte(final BigInteger bytes) {
        super(bytes);
    }

    @Override
    public Kibibyte add(final long bytesToAdd) {
        return new Kibibyte(this.bytes.add(BigInteger.valueOf(bytesToAdd)));
    }

    @Override
    public Kibibyte add(final StorageUnit<?> storageAmount) {
        return new Kibibyte(this.bytes.add(storageAmount.bytes));
    }

    @Override
    public Kibibyte divide(final long divisor) {
        return new Kibibyte(this.bytes.divide(BigInteger.valueOf(divisor)));
    }

    @Override
    public Kibibyte multiply(final long factor) {
        return new Kibibyte(this.bytes.multiply(BigInteger.valueOf(factor)));
    }

    @Override
    public Kibibyte subtract(final long bytesToSubtract) {
        return new Kibibyte(this.bytes.subtract(BigInteger.valueOf(bytesToSubtract)));
    }

    @Override
    public Kibibyte subtract(final StorageUnit<?> storageAmount) {
        return new Kibibyte(this.bytes.subtract(storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_KIBIBYTE;
    }

    @Override
    protected String getSymbol() {
        return "KiB"; //$NON-NLS-1$
    }

}
