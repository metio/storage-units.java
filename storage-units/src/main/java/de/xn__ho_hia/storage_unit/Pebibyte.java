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
 * Pebibyte as specified in ISO IEC 80000-13:2008 (1 Pebibyte = 1 125 899 906 842 624 Byte).
 */
public final class Pebibyte extends StorageUnit<Pebibyte> {

    private static final long serialVersionUID = -6112472064345339882L;

    Pebibyte(@NonNull final BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Pebibyte contains.
     * @return A new Pebibyte unit with the given value.
     */
    @NonNull
    public static Pebibyte valueOf(@NonNull final BigInteger numberOfBytes) {
        return new Pebibyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Pebibyte contains.
     * @return A new Pebibyte unit with the given value.
     */
    @NonNull
    public static Pebibyte valueOf(final long numberOfBytes) {
        return new Pebibyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Pebibyte contains.
     * @return A new Pebibyte unit with the given value.
     */
    @NonNull
    public static Pebibyte valueOf(@NonNull final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    public Pebibyte add(final long bytesToAdd) {
        return new Pebibyte(addNullsafe(bytes, asBigInteger(bytesToAdd)));
    }

    @Override
    public Pebibyte add(final StorageUnit<?> storageAmount) {
        return new Pebibyte(addNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    public Pebibyte divide(final long divisor) {
        return new Pebibyte(divideNullsafe(bytes, asBigInteger(divisor)));
    }

    @Override
    public Pebibyte multiply(final long factor) {
        return new Pebibyte(multiplyNullsafe(bytes, asBigInteger(factor)));
    }

    @Override
    public Pebibyte subtract(final long bytesToSubtract) {
        return new Pebibyte(subtractNullsafe(bytes, asBigInteger(bytesToSubtract)));
    }

    @Override
    public Pebibyte subtract(final StorageUnit<?> storageAmount) {
        return new Pebibyte(subtractNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_PEBIBYTE;
    }

    @Override
    protected String getSymbol() {
        return "PiB"; //$NON-NLS-1$
    }

    @Override
    protected Function<@NonNull BigInteger, @NonNull StorageUnit<?>> converter() {
        return StorageUnits::binaryValueOf;
    }

}
