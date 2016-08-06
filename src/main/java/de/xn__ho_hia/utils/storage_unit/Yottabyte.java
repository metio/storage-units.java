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
 * Yottabyte as specified in ISO IEC 80000-13:2008 (1 Yottabyte = 1 000 000 000 000 000 000 000 000 Byte).
 */
public class Yottabyte extends StorageUnit<Yottabyte> {

    private static final long serialVersionUID = 2482152459842042316L;

    Yottabyte(@NonNull final BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the yottabyte contains.
     * @return A new Yottabyte unit with the given value.
     */
    @NonNull
    public static Yottabyte valueOf(@NonNull final BigInteger numberOfBytes) {
        return new Yottabyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the yottabytes contains.
     * @return A new Yottabyte unit with the given value.
     */
    @NonNull
    public static Yottabyte valueOf(final long numberOfBytes) {
        return new Yottabyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the yottabytes contains.
     * @return A new Yottabyte unit with the given value.
     */
    @NonNull
    public static Yottabyte valueOf(@NonNull final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    public Yottabyte add(final long bytesToAdd) {
        return new Yottabyte(addNullsafe(bytes, asBigInteger(bytesToAdd)));
    }

    @Override
    public Yottabyte add(final StorageUnit<?> storageAmount) {
        return new Yottabyte(addNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    public Yottabyte divide(final long divisor) {
        return new Yottabyte(divideNullsafe(bytes, asBigInteger(divisor)));
    }

    @Override
    public Yottabyte multiply(final long factor) {
        return new Yottabyte(multiplyNullsafe(bytes, asBigInteger(factor)));
    }

    @Override
    public Yottabyte subtract(final long bytesToSubtract) {
        return new Yottabyte(subtractNullsafe(bytes, asBigInteger(bytesToSubtract)));
    }

    @Override
    public Yottabyte subtract(final StorageUnit<?> storageAmount) {
        return new Yottabyte(subtractNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_YOTTABYTE;
    }

    @Override
    protected String getSymbol() {
        return "YB"; //$NON-NLS-1$
    }

    @Override
    protected Function<@NonNull BigInteger, @NonNull StorageUnit<?>> converter() {
        return StorageUnits::metricValueOf;
    }

}
