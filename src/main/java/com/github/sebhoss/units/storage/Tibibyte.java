/* This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details. */
package com.github.sebhoss.units.storage;

import java.math.BigInteger;

/**
 * Tibibyte as specified in ISO IEC 80000-13:2008.
 */
public final class Tibibyte extends StorageUnit<Tibibyte> {

    /** Generated */
    private static final long serialVersionUID = 3614537130129620881L;

    /**
     * @param numberOfBytes
     *            The amount of bytes the tibibytes contains.
     * @return A new Tibibyte unit with the given value.
     */
    public static Tibibyte valueOf(final long numberOfBytes) {
        return new Tibibyte(BigInteger.valueOf(numberOfBytes));
    }

    Tibibyte(final BigInteger bytes) {
        super(bytes);
    }

    @Override
    public Tibibyte add(final long bytesToAdd) {
        return new Tibibyte(this.bytes.add(BigInteger.valueOf(bytesToAdd)));
    }

    @Override
    public Tibibyte add(final StorageUnit<?> storageAmount) {
        return new Tibibyte(this.bytes.add(storageAmount.bytes));
    }

    @Override
    public Tibibyte divide(final long divisor) {
        return new Tibibyte(this.bytes.divide(BigInteger.valueOf(divisor)));
    }

    @Override
    public Tibibyte multiply(final long factor) {
        return new Tibibyte(this.bytes.multiply(BigInteger.valueOf(factor)));
    }

    @Override
    public Tibibyte subtract(final long bytesToSubtract) {
        return new Tibibyte(this.bytes.subtract(BigInteger.valueOf(bytesToSubtract)));
    }

    @Override
    public Tibibyte subtract(final StorageUnit<?> storageAmount) {
        return new Tibibyte(this.bytes.subtract(storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_TIBIBYTE;
    }

    @Override
    protected String getSymbol() {
        return "TiB"; //$NON-NLS-1$
    }

}
