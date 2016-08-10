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
 * Gigabyte as commonly found in the wild (1 Gigabyte = 1 073 741 824 Byte).
 */
public final class CommonGigabyte extends StorageUnit<CommonGigabyte> {

    private static final long serialVersionUID = -1104749948510944566L;

    CommonGigabyte(@NonNull final BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Gigabyte contains.
     * @return A new Gigabyte unit with the given value.
     */
    @NonNull
    public static CommonGigabyte valueOf(@NonNull final BigInteger numberOfBytes) {
        return new CommonGigabyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Gigabyte contains.
     * @return A new Gigabyte unit with the given value.
     */
    @NonNull
    public static CommonGigabyte valueOf(final long numberOfBytes) {
        return new CommonGigabyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Gigabyte contains.
     * @return A new Gigabyte unit with the given value.
     */
    @NonNull
    public static CommonGigabyte valueOf(@NonNull final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    public CommonGigabyte add(final long bytesToAdd) {
        return new CommonGigabyte(addNullsafe(bytes, asBigInteger(bytesToAdd)));
    }

    @Override
    public CommonGigabyte add(final StorageUnit<?> storageAmount) {
        return new CommonGigabyte(addNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    public CommonGigabyte divide(final long divisor) {
        return new CommonGigabyte(divideNullsafe(bytes, asBigInteger(divisor)));
    }

    @Override
    public CommonGigabyte multiply(final long factor) {
        return new CommonGigabyte(multiplyNullsafe(bytes, asBigInteger(factor)));
    }

    @Override
    public CommonGigabyte subtract(final long bytesToSubtract) {
        return new CommonGigabyte(subtractNullsafe(bytes, asBigInteger(bytesToSubtract)));
    }

    @Override
    public CommonGigabyte subtract(final StorageUnit<?> storageAmount) {
        return new CommonGigabyte(subtractNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_GIBIBYTE;
    }

    @Override
    protected String getSymbol() {
        return "GB"; //$NON-NLS-1$
    }

    @Override
    protected Function<@NonNull BigInteger, @NonNull StorageUnit<?>> converter() {
        return StorageUnits::commonValueOf;
    }

}
