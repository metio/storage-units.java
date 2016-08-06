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
import java.util.function.Function;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Kibibyte as specified in ISO IEC 80000-13:2008 (1 Kibibyte = 1 024 Byte).
 */
public final class Kibibyte extends StorageUnit<Kibibyte> {

    private static final long serialVersionUID = 3798828851496657978L;

    Kibibyte(@NonNull final BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the kibibytes contains.
     * @return A new Kibibyte unit with the given value.
     */
    @NonNull
    public static Kibibyte valueOf(@NonNull final BigInteger numberOfBytes) {
        return new Kibibyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the kibibytes contains.
     * @return A new Kibibyte unit with the given value.
     */
    @NonNull
    public static Kibibyte valueOf(final long numberOfBytes) {
        return valueOf(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the kibibytes contains.
     * @return A new Kibibyte unit with the given value.
     */
    @NonNull
    public static Kibibyte valueOf(@NonNull final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    public Kibibyte add(final long bytesToAdd) {
        return new Kibibyte(addNullsafe(bytes, asBigInteger(bytesToAdd)));
    }

    @Override
    public Kibibyte add(final StorageUnit<?> storageAmount) {
        return new Kibibyte(addNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    public Kibibyte divide(final long divisor) {
        return new Kibibyte(divideNullsafe(bytes, asBigInteger(divisor)));
    }

    @Override
    public Kibibyte multiply(final long factor) {
        return new Kibibyte(multiplyNullsafe(bytes, asBigInteger(factor)));
    }

    @Override
    public Kibibyte subtract(final long bytesToSubtract) {
        return new Kibibyte(subtractNullsafe(bytes, asBigInteger(bytesToSubtract)));
    }

    @Override
    public Kibibyte subtract(final StorageUnit<?> storageAmount) {
        return new Kibibyte(subtractNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_KIBIBYTE;
    }

    @Override
    protected String getSymbol() {
        return "KiB"; //$NON-NLS-1$
    }

    @Override
    protected Function<@NonNull BigInteger, @NonNull StorageUnit<?>> converter() {
        return StorageUnits::binaryValueOf;
    }

}
