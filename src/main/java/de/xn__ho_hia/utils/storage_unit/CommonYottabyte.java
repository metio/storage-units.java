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
 * Yottabyte as commonly found in the wild (1 Yottabyte = 1 208 925 819 614 629 174 706 176 Byte).
 */
public final class CommonYottabyte extends StorageUnit<CommonYottabyte> {

    /** Generated */
    private static final long serialVersionUID = -5606322878020884194L;

    CommonYottabyte(@NonNull final BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Yottabyte contains.
     * @return A new Yottabyte unit with the given value.
     */
    @NonNull
    public static CommonYottabyte valueOf(@NonNull final BigInteger numberOfBytes) {
        return new CommonYottabyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Yottabyte contains.
     * @return A new Yottabyte unit with the given value.
     */
    @NonNull
    public static CommonYottabyte valueOf(final long numberOfBytes) {
        return new CommonYottabyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Yottabyte contains.
     * @return A new Yottabyte unit with the given value.
     */
    @NonNull
    public static CommonYottabyte valueOf(@NonNull final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    public CommonYottabyte add(final long bytesToAdd) {
        return new CommonYottabyte(addNullsafe(bytes, asBigInteger(bytesToAdd)));
    }

    @Override
    public CommonYottabyte add(final StorageUnit<?> storageAmount) {
        return new CommonYottabyte(addNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    public CommonYottabyte divide(final long divisor) {
        return new CommonYottabyte(divideNullsafe(bytes, asBigInteger(divisor)));
    }

    @Override
    public CommonYottabyte multiply(final long factor) {
        return new CommonYottabyte(multiplyNullsafe(bytes, asBigInteger(factor)));
    }

    @Override
    public CommonYottabyte subtract(final long bytesToSubtract) {
        return new CommonYottabyte(subtractNullsafe(bytes, asBigInteger(bytesToSubtract)));
    }

    @Override
    public CommonYottabyte subtract(final StorageUnit<?> storageAmount) {
        return new CommonYottabyte(subtractNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_YOBIBYTE;
    }

    @Override
    protected String getSymbol() {
        return "YB"; //$NON-NLS-1$
    }

    @Override
    protected Function<@NonNull BigInteger, @NonNull StorageUnit<?>> converter() {
        return StorageUnits::commonValueOf;
    }

}
