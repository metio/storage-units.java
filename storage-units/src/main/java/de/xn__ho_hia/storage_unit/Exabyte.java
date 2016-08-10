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
 * Exabyte as specified in ISO IEC 80000-13:2008 (1 Exabyte = 1 000 000 000 000 000 000 Byte).
 */
public class Exabyte extends StorageUnit<Exabyte> {

    private static final long serialVersionUID = 6846441733771841250L;

    Exabyte(@NonNull final BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Exabyte contains.
     * @return A new Exabyte unit with the given value.
     */
    @NonNull
    public static Exabyte valueOf(@NonNull final BigInteger numberOfBytes) {
        return new Exabyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Exabyte contains.
     * @return A new Exabyte unit with the given value.
     */
    @NonNull
    public static Exabyte valueOf(final long numberOfBytes) {
        return new Exabyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Exabyte contains.
     * @return A new Exabyte unit with the given value.
     */
    @NonNull
    public static Exabyte valueOf(@NonNull final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    public Exabyte add(final long bytesToAdd) {
        return new Exabyte(addNullsafe(bytes, asBigInteger(bytesToAdd)));
    }

    @Override
    public Exabyte add(final StorageUnit<?> storageAmount) {
        return new Exabyte(addNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    public Exabyte divide(final long divisor) {
        return new Exabyte(divideNullsafe(bytes, asBigInteger(divisor)));
    }

    @Override
    public Exabyte multiply(final long factor) {
        return new Exabyte(multiplyNullsafe(bytes, asBigInteger(factor)));
    }

    @Override
    public Exabyte subtract(final long bytesToSubtract) {
        return new Exabyte(subtractNullsafe(bytes, asBigInteger(bytesToSubtract)));
    }

    @Override
    public Exabyte subtract(final StorageUnit<?> storageAmount) {
        return new Exabyte(subtractNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_EXABYTE;
    }

    @Override
    protected String getSymbol() {
        return "EB"; //$NON-NLS-1$
    }

    @Override
    protected Function<@NonNull BigInteger, @NonNull StorageUnit<?>> converter() {
        return StorageUnits::metricValueOf;
    }

}
