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
 * Megabyte as commonly found in the wild (1 Megabyte = 1 048 576 Byte).
 */
public final class CommonMegabyte extends StorageUnit<CommonMegabyte> {

    /** Generated */
    private static final long serialVersionUID = 7697583678146919524L;

    CommonMegabyte(@NonNull final BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Megabyte contains.
     * @return A new Megabyte unit with the given value.
     */
    @NonNull
    public static CommonMegabyte valueOf(@NonNull final BigInteger numberOfBytes) {
        return new CommonMegabyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Megabyte contains.
     * @return A new Megabyte unit with the given value.
     */
    @NonNull
    public static CommonMegabyte valueOf(final long numberOfBytes) {
        return new CommonMegabyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Megabyte contains.
     * @return A new Megabyte unit with the given value.
     */
    @NonNull
    public static CommonMegabyte valueOf(@NonNull final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    public CommonMegabyte add(final long bytesToAdd) {
        return new CommonMegabyte(addNullsafe(bytes, asBigInteger(bytesToAdd)));
    }

    @Override
    public CommonMegabyte add(final StorageUnit<?> storageAmount) {
        return new CommonMegabyte(addNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    public CommonMegabyte divide(final long divisor) {
        return new CommonMegabyte(divideNullsafe(bytes, asBigInteger(divisor)));
    }

    @Override
    public CommonMegabyte multiply(final long factor) {
        return new CommonMegabyte(multiplyNullsafe(bytes, asBigInteger(factor)));
    }

    @Override
    public CommonMegabyte subtract(final long bytesToSubtract) {
        return new CommonMegabyte(subtractNullsafe(bytes, asBigInteger(bytesToSubtract)));
    }

    @Override
    public CommonMegabyte subtract(final StorageUnit<?> storageAmount) {
        return new CommonMegabyte(subtractNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_MEBIBYTE;
    }

    @Override
    protected String getSymbol() {
        return "MB"; //$NON-NLS-1$
    }

    @Override
    protected Function<@NonNull BigInteger, @NonNull StorageUnit<?>> converter() {
        return StorageUnits::commonValueOf;
    }

}
