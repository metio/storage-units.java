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
 * Terabyte as commonly found in the wild (1 Terabyte = 1 099 511 627 776 Byte).
 */
public final class CommonTerabyte extends StorageUnit<CommonTerabyte> {

    /** Generated */
    private static final long serialVersionUID = 3614537130129620881L;

    CommonTerabyte(@NonNull final BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Terabyte contains.
     * @return A new Terabyte unit with the given value.
     */
    @NonNull
    public static CommonTerabyte valueOf(@NonNull final BigInteger numberOfBytes) {
        return new CommonTerabyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Terabyte contains.
     * @return A new Terabyte unit with the given value.
     */
    @NonNull
    public static CommonTerabyte valueOf(final long numberOfBytes) {
        return new CommonTerabyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Terabyte contains.
     * @return A new Terabyte unit with the given value.
     */
    @NonNull
    public static CommonTerabyte valueOf(@NonNull final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    public CommonTerabyte add(final long bytesToAdd) {
        return new CommonTerabyte(addNullsafe(bytes, asBigInteger(bytesToAdd)));
    }

    @Override
    public CommonTerabyte add(final StorageUnit<?> storageAmount) {
        return new CommonTerabyte(addNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    public CommonTerabyte divide(final long divisor) {
        return new CommonTerabyte(divideNullsafe(bytes, asBigInteger(divisor)));
    }

    @Override
    public CommonTerabyte multiply(final long factor) {
        return new CommonTerabyte(multiplyNullsafe(bytes, asBigInteger(factor)));
    }

    @Override
    public CommonTerabyte subtract(final long bytesToSubtract) {
        return new CommonTerabyte(subtractNullsafe(bytes, asBigInteger(bytesToSubtract)));
    }

    @Override
    public CommonTerabyte subtract(final StorageUnit<?> storageAmount) {
        return new CommonTerabyte(subtractNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_TEBIBYTE;
    }

    @Override
    protected String getSymbol() {
        return "TB"; //$NON-NLS-1$
    }

    @Override
    protected Function<@NonNull BigInteger, @NonNull StorageUnit<?>> converter() {
        return StorageUnits::commonValueOf;
    }

}
