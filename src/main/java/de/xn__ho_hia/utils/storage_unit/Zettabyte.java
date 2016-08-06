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
 * Zettabyte as specified in ISO IEC 80000-13:2008 (1 Zettabyte = 1 000 000 000 000 000 000 000 Byte).
 */
public class Zettabyte extends StorageUnit<Zettabyte> {

    private static final long serialVersionUID = 8849006574018911826L;

    Zettabyte(@NonNull final BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the zettabyte contains.
     * @return A new Zettabyte unit with the given value.
     */
    @NonNull
    public static Zettabyte valueOf(@NonNull final BigInteger numberOfBytes) {
        return new Zettabyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the zettabytes contains.
     * @return A new Zettabyte unit with the given value.
     */
    @NonNull
    public static Zettabyte valueOf(final long numberOfBytes) {
        return new Zettabyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the zettabytes contains.
     * @return A new Zettabyte unit with the given value.
     */
    @NonNull
    public static Zettabyte valueOf(@NonNull final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    public Zettabyte add(final long bytesToAdd) {
        return new Zettabyte(addNullsafe(bytes, asBigInteger(bytesToAdd)));
    }

    @Override
    public Zettabyte add(final StorageUnit<?> storageAmount) {
        return new Zettabyte(addNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    public Zettabyte divide(final long divisor) {
        return new Zettabyte(divideNullsafe(bytes, asBigInteger(divisor)));
    }

    @Override
    public Zettabyte multiply(final long factor) {
        return new Zettabyte(multiplyNullsafe(bytes, asBigInteger(factor)));
    }

    @Override
    public Zettabyte subtract(final long bytesToSubtract) {
        return new Zettabyte(subtractNullsafe(bytes, asBigInteger(bytesToSubtract)));
    }

    @Override
    public Zettabyte subtract(final StorageUnit<?> storageAmount) {
        return new Zettabyte(subtractNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_ZETTABYTE;
    }

    @Override
    protected String getSymbol() {
        return "ZB"; //$NON-NLS-1$
    }

    @Override
    protected Function<@NonNull BigInteger, @NonNull StorageUnit<?>> converter() {
        return StorageUnits::metricValueOf;
    }

}
