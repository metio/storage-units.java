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
 * Tebibyte as specified in ISO IEC 80000-13:2008 (1 Tebibyte = 1 099 511 627 776 Byte).
 */
public final class Tebibyte extends StorageUnit<Tebibyte> {

    /** Generated */
    private static final long serialVersionUID = 3614537130129620881L;

    Tebibyte(@NonNull final BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the tebibyte contains.
     * @return A new Tebibyte unit with the given value.
     */
    @NonNull
    public static Tebibyte valueOf(@NonNull final BigInteger numberOfBytes) {
        return new Tebibyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the tebibytes contains.
     * @return A new Tebibyte unit with the given value.
     */
    @NonNull
    public static Tebibyte valueOf(final long numberOfBytes) {
        return new Tebibyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the tebibytes contains.
     * @return A new Tebibyte unit with the given value.
     */
    @NonNull
    public static Tebibyte valueOf(@NonNull final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    public Tebibyte add(final long bytesToAdd) {
        return new Tebibyte(addNullsafe(bytes, asBigInteger(bytesToAdd)));
    }

    @Override
    public Tebibyte add(final StorageUnit<?> storageAmount) {
        return new Tebibyte(addNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    public Tebibyte divide(final long divisor) {
        return new Tebibyte(divideNullsafe(bytes, asBigInteger(divisor)));
    }

    @Override
    public Tebibyte multiply(final long factor) {
        return new Tebibyte(multiplyNullsafe(bytes, asBigInteger(factor)));
    }

    @Override
    public Tebibyte subtract(final long bytesToSubtract) {
        return new Tebibyte(subtractNullsafe(bytes, asBigInteger(bytesToSubtract)));
    }

    @Override
    public Tebibyte subtract(final StorageUnit<?> storageAmount) {
        return new Tebibyte(subtractNullsafe(bytes, storageAmount.bytes));
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
