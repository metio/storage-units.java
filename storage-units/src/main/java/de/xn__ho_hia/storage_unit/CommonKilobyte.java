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
 * Kilobyte as commonly found in the wild (1 Kilobyte = 1 024 Byte).
 */
public final class CommonKilobyte extends StorageUnit<CommonKilobyte> {

    private static final long serialVersionUID = 3798828851496657978L;

    CommonKilobyte(@NonNull final BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Kilobyte contains.
     * @return A new Kilobyte unit with the given value.
     */
    @NonNull
    public static CommonKilobyte valueOf(@NonNull final BigInteger numberOfBytes) {
        return new CommonKilobyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Kilobyte contains.
     * @return A new Kilobyte unit with the given value.
     */
    @NonNull
    public static CommonKilobyte valueOf(final long numberOfBytes) {
        return valueOf(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Kilobyte contains.
     * @return A new Kilobyte unit with the given value.
     */
    @NonNull
    public static CommonKilobyte valueOf(@NonNull final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    public CommonKilobyte add(final long bytesToAdd) {
        return new CommonKilobyte(addNullsafe(bytes, asBigInteger(bytesToAdd)));
    }

    @Override
    public CommonKilobyte add(final StorageUnit<?> storageAmount) {
        return new CommonKilobyte(addNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    public CommonKilobyte divide(final long divisor) {
        return new CommonKilobyte(divideNullsafe(bytes, asBigInteger(divisor)));
    }

    @Override
    public CommonKilobyte multiply(final long factor) {
        return new CommonKilobyte(multiplyNullsafe(bytes, asBigInteger(factor)));
    }

    @Override
    public CommonKilobyte subtract(final long bytesToSubtract) {
        return new CommonKilobyte(subtractNullsafe(bytes, asBigInteger(bytesToSubtract)));
    }

    @Override
    public CommonKilobyte subtract(final StorageUnit<?> storageAmount) {
        return new CommonKilobyte(subtractNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_KIBIBYTE;
    }

    @Override
    protected String getSymbol() {
        return "kB"; //$NON-NLS-1$
    }

    @Override
    protected Function<@NonNull BigInteger, @NonNull StorageUnit<?>> converter() {
        return StorageUnits::commonValueOf;
    }

}
