/* This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details. */
package com.github.sebhoss.units.storage;

import java.math.BigInteger;

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
        return new Yobibyte(BigInteger.valueOf(numberOfBytes));
    }

    Yobibyte(final BigInteger bytes) {
        super(bytes);
    }

    @Override
    public Yobibyte add(final long bytesToAdd) {
        return new Yobibyte(this.bytes.add(BigInteger.valueOf(bytesToAdd)));
    }

    @Override
    public Yobibyte add(final StorageUnit<?> storageAmount) {
        return new Yobibyte(this.bytes.add(storageAmount.bytes));
    }

    @Override
    public Yobibyte divide(final long divisor) {
        return new Yobibyte(this.bytes.divide(BigInteger.valueOf(divisor)));
    }

    @Override
    public Yobibyte multiply(final long factor) {
        return new Yobibyte(this.bytes.multiply(BigInteger.valueOf(factor)));
    }

    @Override
    public Yobibyte subtract(final long bytesToSubtract) {
        return new Yobibyte(this.bytes.subtract(BigInteger.valueOf(bytesToSubtract)));
    }

    @Override
    public Yobibyte subtract(final StorageUnit<?> storageAmount) {
        return new Yobibyte(this.bytes.subtract(storageAmount.bytes));
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
