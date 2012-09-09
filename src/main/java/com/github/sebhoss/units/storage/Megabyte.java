/* This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details. */
package com.github.sebhoss.units.storage;

import java.math.BigInteger;

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
        return new Megabyte(BigInteger.valueOf(numberOfBytes));
    }

    Megabyte(final BigInteger bytes) {
        super(bytes);
    }

    @Override
    public Megabyte add(final long bytesToAdd) {
        return new Megabyte(this.bytes.add(BigInteger.valueOf(bytesToAdd)));
    }

    @Override
    public Megabyte add(final StorageUnit<?> storageAmount) {
        return new Megabyte(this.bytes.add(storageAmount.bytes));
    }

    @Override
    public Megabyte divide(final long divisor) {
        return new Megabyte(this.bytes.divide(BigInteger.valueOf(divisor)));
    }

    @Override
    public Megabyte multiply(final long factor) {
        return new Megabyte(this.bytes.multiply(BigInteger.valueOf(factor)));
    }

    @Override
    public Megabyte subtract(final long bytesToSubtract) {
        return new Megabyte(this.bytes.subtract(BigInteger.valueOf(bytesToSubtract)));
    }

    @Override
    public Megabyte subtract(final StorageUnit<?> storageAmount) {
        return new Megabyte(this.bytes.subtract(storageAmount.bytes));
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
