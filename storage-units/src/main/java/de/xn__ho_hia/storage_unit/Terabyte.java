/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.storage_unit;

import static de.xn__ho_hia.quality.null_analysis.Nullsafe.addNullsafe;
import static de.xn__ho_hia.quality.null_analysis.Nullsafe.asBigInteger;
import static de.xn__ho_hia.quality.null_analysis.Nullsafe.divideNullsafe;
import static de.xn__ho_hia.quality.null_analysis.Nullsafe.multiplyNullsafe;
import static de.xn__ho_hia.quality.null_analysis.Nullsafe.subtractNullsafe;

import java.math.BigInteger;
import java.util.function.Function;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Terabyte as specified in ISO IEC 80000-13:2008 (1 Terabyte = 1 000 000 000 000 Byte).
 */
public class Terabyte extends StorageUnit<Terabyte> {

    private static final long serialVersionUID = 2160488069631638952L;

    Terabyte(@NonNull final BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Terabyte contains.
     * @return A new Kilobyte unit with the given value.
     */
    @NonNull
    public static Terabyte valueOf(@NonNull final BigInteger numberOfBytes) {
        return new Terabyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Terabyte contains.
     * @return A new Terabyte unit with the given value.
     */
    @NonNull
    public static Terabyte valueOf(final long numberOfBytes) {
        return new Terabyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Terabyte contains.
     * @return A new Terabyte unit with the given value.
     */
    @NonNull
    public static Terabyte valueOf(@NonNull final Long numberOfBytes) {
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

    @Override
    protected Function<@NonNull BigInteger, @NonNull StorageUnit<?>> converter() {
        return StorageUnits::decimalValueOf;
    }

}
