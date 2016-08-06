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
 * Zebibyte as specified in ISO IEC 80000-13:2008 (1 Zebibyte = 1 180 591 620 717 411 303 424 Byte).
 */
public final class Zebibyte extends StorageUnit<Zebibyte> {

    private static final long serialVersionUID = 2192254824473341887L;

    Zebibyte(@NonNull final BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the zebibyte contains.
     * @return A new Zebibyte unit with the given value.
     */
    @NonNull
    public static Zebibyte valueOf(@NonNull final BigInteger numberOfBytes) {
        return new Zebibyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the zebibytes contains.
     * @return A new Zebibyte unit with the given value.
     */
    @NonNull
    public static Zebibyte valueOf(final long numberOfBytes) {
        return new Zebibyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the zebibytes contains.
     * @return A new Zebibyte unit with the given value.
     */
    @NonNull
    public static Zebibyte valueOf(@NonNull final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    public Zebibyte add(final long bytesToAdd) {
        return new Zebibyte(addNullsafe(bytes, asBigInteger(bytesToAdd)));
    }

    @Override
    public Zebibyte add(final StorageUnit<?> storageAmount) {
        return new Zebibyte(addNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    public Zebibyte divide(final long divisor) {
        return new Zebibyte(divideNullsafe(bytes, asBigInteger(divisor)));
    }

    @Override
    public Zebibyte multiply(final long factor) {
        return new Zebibyte(multiplyNullsafe(bytes, asBigInteger(factor)));
    }

    @Override
    public Zebibyte subtract(final long bytesToSubtract) {
        return new Zebibyte(subtractNullsafe(bytes, asBigInteger(bytesToSubtract)));
    }

    @Override
    public Zebibyte subtract(final StorageUnit<?> storageAmount) {
        return new Zebibyte(subtractNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_ZEBIBYTE;
    }

    @Override
    protected String getSymbol() {
        return "ZiB"; //$NON-NLS-1$
    }

    @Override
    protected Function<@NonNull BigInteger, @NonNull StorageUnit<?>> converter() {
        return StorageUnits::binaryValueOf;
    }

}
