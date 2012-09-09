/* This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details. */
package com.github.sebhoss.units.storage;

import java.math.BigInteger;

/**
 * Gibibyte as specified in ISO IEC 80000-13:2008.
 */
public final class Gibibyte extends StorageUnit<Gibibyte> {

    private static final long serialVersionUID = -1104749948510944566L;

    /**
     * @param numberOfBytes
     *            The amount of bytes the gibibytes contains.
     * @return A new Gibibyte unit with the given value.
     */
    public static Gibibyte valueOf(final long numberOfBytes) {
        return new Gibibyte(BigInteger.valueOf(numberOfBytes));
    }

    Gibibyte(final BigInteger bytes) {
        super(bytes);
    }

    @Override
    public Gibibyte add(final long bytesToAdd) {
        return new Gibibyte(this.bytes.add(BigInteger.valueOf(bytesToAdd)));
    }

    @Override
    public Gibibyte add(final StorageUnit<?> storageAmount) {
        return new Gibibyte(this.bytes.add(storageAmount.bytes));
    }

    @Override
    public Gibibyte divide(final long divisor) {
        return new Gibibyte(this.bytes.divide(BigInteger.valueOf(divisor)));
    }

    @Override
    public Gibibyte multiply(final long factor) {
        return new Gibibyte(this.bytes.multiply(BigInteger.valueOf(factor)));
    }

    @Override
    public Gibibyte subtract(final long bytesToSubtract) {
        return new Gibibyte(this.bytes.subtract(BigInteger.valueOf(bytesToSubtract)));
    }

    @Override
    public Gibibyte subtract(final StorageUnit<?> storageAmount) {
        return new Gibibyte(this.bytes.subtract(storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_GIBIBYTE;
    }

    @Override
    protected String getSymbol() {
        return "GiB"; //$NON-NLS-1$
    }

}
