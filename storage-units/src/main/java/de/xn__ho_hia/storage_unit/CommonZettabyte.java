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
 * Zettabyte as commonly found in the wild (1 Zettabyte = 1 180 591 620 717 411 303 424 Byte).
 */
public final class CommonZettabyte extends StorageUnit<CommonZettabyte> {

    private static final long serialVersionUID = 2192254824473341887L;

    CommonZettabyte(@NonNull final BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Zettabyte contains.
     * @return A new Zettabyte unit with the given value.
     */
    @NonNull
    public static CommonZettabyte valueOf(@NonNull final BigInteger numberOfBytes) {
        return new CommonZettabyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Zettabyte contains.
     * @return A new Zettabyte unit with the given value.
     */
    @NonNull
    public static CommonZettabyte valueOf(final long numberOfBytes) {
        return new CommonZettabyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Zettabyte contains.
     * @return A new Zettabyte unit with the given value.
     */
    @NonNull
    public static CommonZettabyte valueOf(@NonNull final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    public CommonZettabyte add(final long bytesToAdd) {
        return new CommonZettabyte(addNullsafe(bytes, asBigInteger(bytesToAdd)));
    }

    @Override
    public CommonZettabyte add(final StorageUnit<?> storageAmount) {
        return new CommonZettabyte(addNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    public CommonZettabyte divide(final long divisor) {
        return new CommonZettabyte(divideNullsafe(bytes, asBigInteger(divisor)));
    }

    @Override
    public CommonZettabyte multiply(final long factor) {
        return new CommonZettabyte(multiplyNullsafe(bytes, asBigInteger(factor)));
    }

    @Override
    public CommonZettabyte subtract(final long bytesToSubtract) {
        return new CommonZettabyte(subtractNullsafe(bytes, asBigInteger(bytesToSubtract)));
    }

    @Override
    public CommonZettabyte subtract(final StorageUnit<?> storageAmount) {
        return new CommonZettabyte(subtractNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_ZEBIBYTE;
    }

    @Override
    protected String getSymbol() {
        return "ZB"; //$NON-NLS-1$
    }

    @Override
    protected Function<@NonNull BigInteger, @NonNull StorageUnit<?>> converter() {
        return StorageUnits::commonValueOf;
    }

}
