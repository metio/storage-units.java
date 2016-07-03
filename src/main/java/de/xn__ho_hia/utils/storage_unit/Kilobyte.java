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
 * Kilobyte as specified in ISO IEC 80000-13:2008 (1 Kilobyte = 1 000 Byte).
 */
public class Kilobyte extends StorageUnit<Kilobyte> {

    private static final long serialVersionUID = 6952239416014811456L;

    Kilobyte(@NonNull final BigInteger numberOfBytes) {
        super(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the kilobytes contains.
     * @return A new Kilobyte unit with the given value.
     */
    @NonNull
    public static Kilobyte valueOf(@NonNull final BigInteger numberOfBytes) {
        return new Kilobyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the kilobytes contains.
     * @return A new Kilobyte unit with the given value.
     */
    @NonNull
    public static Kilobyte valueOf(final long numberOfBytes) {
        return valueOf(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the kilobytes contains.
     * @return A new Kilobyte unit with the given value.
     */
    @NonNull
    public static Kilobyte valueOf(@NonNull final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    public Kilobyte add(final long bytesToAdd) {
        return new Kilobyte(addNullsafe(bytes, asBigInteger(bytesToAdd)));
    }

    @Override
    public Kilobyte add(final StorageUnit<?> storageAmount) {
        return new Kilobyte(addNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    public Kilobyte divide(final long divisor) {
        return new Kilobyte(divideNullsafe(bytes, asBigInteger(divisor)));
    }

    @Override
    public Kilobyte multiply(final long factor) {
        return new Kilobyte(multiplyNullsafe(bytes, asBigInteger(factor)));
    }

    @Override
    public Kilobyte subtract(final long bytesToSubtract) {
        return new Kilobyte(subtractNullsafe(bytes, asBigInteger(bytesToSubtract)));
    }

    @Override
    public Kilobyte subtract(final StorageUnit<?> storageAmount) {
        return new Kilobyte(subtractNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_KILOBYTE;
    }

    @Override
    protected String getSymbol() {
        return "kB"; //$NON-NLS-1$
    }

}
