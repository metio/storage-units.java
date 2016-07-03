/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.utils.storage_unit;

import static de.xn__ho_hia.quality.null_analysis.Nullsafe.addNullsafe;
import static de.xn__ho_hia.quality.null_analysis.Nullsafe.asBigInteger;
import static de.xn__ho_hia.quality.null_analysis.Nullsafe.divideNullsafe;
import static de.xn__ho_hia.quality.null_analysis.Nullsafe.multiplyNullsafe;
import static de.xn__ho_hia.quality.null_analysis.Nullsafe.subtractNullsafe;

import java.math.BigInteger;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Exbibyte as specified in ISO IEC 80000-13:2008 (1 Exbibyte = 1 152 921 504 606 846 976 Byte).
 */
public final class Exbibyte extends StorageUnit<Exbibyte> {

    private static final long serialVersionUID = 5993490571003918471L;

    Exbibyte(@NonNull final BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the exbibyte contains.
     * @return A new Exbibyte unit with the given value.
     */
    @NonNull
    public static Exbibyte valueOf(@NonNull final BigInteger numberOfBytes) {
        return new Exbibyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the exbibytes contains.
     * @return A new Exbibyte unit with the given value.
     */
    @NonNull
    public static Exbibyte valueOf(final long numberOfBytes) {
        return new Exbibyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the exbibytes contains.
     * @return A new Exbibyte unit with the given value.
     */
    @NonNull
    public static Exbibyte valueOf(@NonNull final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    public Exbibyte add(final long bytesToAdd) {
        return new Exbibyte(addNullsafe(bytes, asBigInteger(bytesToAdd)));
    }

    @Override
    public Exbibyte add(final StorageUnit<?> storageAmount) {
        return new Exbibyte(addNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    public Exbibyte divide(final long divisor) {
        return new Exbibyte(divideNullsafe(bytes, asBigInteger(divisor)));
    }

    @Override
    public Exbibyte multiply(final long factor) {
        return new Exbibyte(multiplyNullsafe(bytes, asBigInteger(factor)));
    }

    @Override
    public Exbibyte subtract(final long bytesToSubtract) {
        return new Exbibyte(subtractNullsafe(bytes, asBigInteger(bytesToSubtract)));
    }

    @Override
    public Exbibyte subtract(final StorageUnit<?> storageAmount) {
        return new Exbibyte(subtractNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_EXBIBYTE;
    }

    @Override
    protected String getSymbol() {
        return "EiB"; //$NON-NLS-1$
    }

}
