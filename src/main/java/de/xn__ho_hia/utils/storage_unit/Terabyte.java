/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.utils.storage_unit;

import static de.xn__ho_hia.quality.null_analysis.NullsafeMath.addNullsafe;
import static de.xn__ho_hia.quality.null_analysis.NullsafeMath.asBigInteger;
import static de.xn__ho_hia.quality.null_analysis.NullsafeMath.divideNullsafe;
import static de.xn__ho_hia.quality.null_analysis.NullsafeMath.multiplyNullsafe;
import static de.xn__ho_hia.quality.null_analysis.NullsafeMath.subtractNullsafe;

import java.math.BigInteger;

/**
 * Terabyte as specified in ISO IEC 80000-13:2008 (1 Terabyte = 1 000 000 000 000 Byte).
 */
public class Terabyte extends StorageUnit<Terabyte> {

    private static final long serialVersionUID = 2160488069631638952L;

    Terabyte(final BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the terabyte contains.
     * @return A new Kilobyte unit with the given value.
     */
    public static Terabyte valueOf(final BigInteger numberOfBytes) {
        return new Terabyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the terabytes contains.
     * @return A new Terabyte unit with the given value.
     */
    public static Terabyte valueOf(final long numberOfBytes) {
        return new Terabyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the terabytes contains.
     * @return A new Terabyte unit with the given value.
     */
    public static Terabyte valueOf(final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    public Terabyte add(final long bytesToAdd) {
        return new Terabyte(addNullsafe(bytes, asBigInteger(bytesToAdd)));
    }

    @Override
    public Terabyte add(final StorageUnit<?> storageAmount) {
        return new Terabyte(addNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    public Terabyte divide(final long divisor) {
        return new Terabyte(divideNullsafe(bytes, asBigInteger(divisor)));
    }

    @Override
    public Terabyte multiply(final long factor) {
        return new Terabyte(multiplyNullsafe(bytes, asBigInteger(factor)));
    }

    @Override
    public Terabyte subtract(final long bytesToSubtract) {
        return new Terabyte(subtractNullsafe(bytes, asBigInteger(bytesToSubtract)));
    }

    @Override
    public Terabyte subtract(final StorageUnit<?> storageAmount) {
        return new Terabyte(subtractNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_TERABYTE;
    }

    @Override
    protected String getSymbol() {
        return "TB"; //$NON-NLS-1$
    }

}
