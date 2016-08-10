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
 * Exabyte as commonly found in the wild (1 Exabyte = 1 152 921 504 606 846 976 Byte).
 */
public final class CommonExabyte extends StorageUnit<CommonExabyte> {

    private static final long serialVersionUID = 5993490571003918471L;

    CommonExabyte(@NonNull final BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Exabyte contains.
     * @return A new Exabyte unit with the given value.
     */
    @NonNull
    public static CommonExabyte valueOf(@NonNull final BigInteger numberOfBytes) {
        return new CommonExabyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Exabyte contains.
     * @return A new Exabyte unit with the given value.
     */
    @NonNull
    public static CommonExabyte valueOf(final long numberOfBytes) {
        return new CommonExabyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Exabyte contains.
     * @return A new Exabyte unit with the given value.
     */
    @NonNull
    public static CommonExabyte valueOf(@NonNull final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    public CommonExabyte add(final long bytesToAdd) {
        return new CommonExabyte(addNullsafe(bytes, asBigInteger(bytesToAdd)));
    }

    @Override
    public CommonExabyte add(final StorageUnit<?> storageAmount) {
        return new CommonExabyte(addNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    public CommonExabyte divide(final long divisor) {
        return new CommonExabyte(divideNullsafe(bytes, asBigInteger(divisor)));
    }

    @Override
    public CommonExabyte multiply(final long factor) {
        return new CommonExabyte(multiplyNullsafe(bytes, asBigInteger(factor)));
    }

    @Override
    public CommonExabyte subtract(final long bytesToSubtract) {
        return new CommonExabyte(subtractNullsafe(bytes, asBigInteger(bytesToSubtract)));
    }

    @Override
    public CommonExabyte subtract(final StorageUnit<?> storageAmount) {
        return new CommonExabyte(subtractNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_EXBIBYTE;
    }

    @Override
    protected String getSymbol() {
        return "EB"; //$NON-NLS-1$
    }

    @Override
    protected Function<@NonNull BigInteger, @NonNull StorageUnit<?>> converter() {
        return StorageUnits::commonValueOf;
    }

}
