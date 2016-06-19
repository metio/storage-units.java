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

import org.eclipse.jdt.annotation.NonNull;

/**
 * Mebibyte as specified in ISO IEC 80000-13:2008 (1 Mebibyte = 1 048 576 Byte).
 */
public final class Mebibyte extends StorageUnit<Mebibyte> {

    /** Generated */
    private static final long serialVersionUID = 7697583678146919524L;

    Mebibyte(@NonNull final BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the mebibyte contains.
     * @return A new Mebibyte unit with the given value.
     */
    @NonNull
    public static Mebibyte valueOf(@NonNull final BigInteger numberOfBytes) {
        return new Mebibyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the mebibytes contains.
     * @return A new Mebibyte unit with the given value.
     */
    @NonNull
    public static Mebibyte valueOf(final long numberOfBytes) {
        return new Mebibyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the mebibytes contains.
     * @return A new Mebibyte unit with the given value.
     */
    @NonNull
    public static Mebibyte valueOf(@NonNull final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    public Mebibyte add(final long bytesToAdd) {
        return new Mebibyte(addNullsafe(bytes, asBigInteger(bytesToAdd)));
    }

    @Override
    public Mebibyte add(final StorageUnit<?> storageAmount) {
        return new Mebibyte(addNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    public Mebibyte divide(final long divisor) {
        return new Mebibyte(divideNullsafe(bytes, asBigInteger(divisor)));
    }

    @Override
    public Mebibyte multiply(final long factor) {
        return new Mebibyte(multiplyNullsafe(bytes, asBigInteger(factor)));
    }

    @Override
    public Mebibyte subtract(final long bytesToSubtract) {
        return new Mebibyte(subtractNullsafe(bytes, asBigInteger(bytesToSubtract)));
    }

    @Override
    public Mebibyte subtract(final StorageUnit<?> storageAmount) {
        return new Mebibyte(subtractNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_MEBIBYTE;
    }

    @Override
    protected String getSymbol() {
        return "MiB"; //$NON-NLS-1$
    }

}
