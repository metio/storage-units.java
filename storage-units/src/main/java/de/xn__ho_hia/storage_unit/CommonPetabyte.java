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
 * Petabyte as commonly found in the wild (1 Petabyte = 1 125 899 906 842 624 Byte).
 */
public final class CommonPetabyte extends StorageUnit<CommonPetabyte> {

    private static final long serialVersionUID = -6112472064345339882L;

    CommonPetabyte(@NonNull final BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Petabyte contains.
     * @return A new Petabyte unit with the given value.
     */
    @NonNull
    public static CommonPetabyte valueOf(@NonNull final BigInteger numberOfBytes) {
        return new CommonPetabyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Petabyte contains.
     * @return A new Petabyte unit with the given value.
     */
    @NonNull
    public static CommonPetabyte valueOf(final long numberOfBytes) {
        return new CommonPetabyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Petabyte contains.
     * @return A new Petabyte unit with the given value.
     */
    @NonNull
    public static CommonPetabyte valueOf(@NonNull final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    public CommonPetabyte add(final long bytesToAdd) {
        return new CommonPetabyte(addNullsafe(bytes, asBigInteger(bytesToAdd)));
    }

    @Override
    public CommonPetabyte add(final StorageUnit<?> storageAmount) {
        return new CommonPetabyte(addNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    public CommonPetabyte divide(final long divisor) {
        return new CommonPetabyte(divideNullsafe(bytes, asBigInteger(divisor)));
    }

    @Override
    public CommonPetabyte multiply(final long factor) {
        return new CommonPetabyte(multiplyNullsafe(bytes, asBigInteger(factor)));
    }

    @Override
    public CommonPetabyte subtract(final long bytesToSubtract) {
        return new CommonPetabyte(subtractNullsafe(bytes, asBigInteger(bytesToSubtract)));
    }

    @Override
    public CommonPetabyte subtract(final StorageUnit<?> storageAmount) {
        return new CommonPetabyte(subtractNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_PEBIBYTE;
    }

    @Override
    protected String getSymbol() {
        return "PB"; //$NON-NLS-1$
    }

    @Override
    protected Function<@NonNull BigInteger, @NonNull StorageUnit<?>> converter() {
        return StorageUnits::commonValueOf;
    }

}
