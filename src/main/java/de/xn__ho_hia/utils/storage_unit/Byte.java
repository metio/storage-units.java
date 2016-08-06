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
import static de.xn__ho_hia.quality.null_analysis.Nullsafe.nonNull;
import static de.xn__ho_hia.quality.null_analysis.Nullsafe.subtractNullsafe;

import java.math.BigInteger;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Byte as specified in ISO IEC 80000-13:2008 (1 Byte).
 */
public class Byte extends StorageUnit<Byte> {

    private static final long serialVersionUID = 6952239416014811456L;

    Byte(@NonNull final BigInteger numberOfBytes) {
        super(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Byte contains.
     * @return A new Byte unit with the given value.
     */
    @NonNull
    public static Byte valueOf(@NonNull final BigInteger numberOfBytes) {
        return new Byte(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Byte contains.
     * @return A new Byte unit with the given value.
     */
    @NonNull
    public static Byte valueOf(final long numberOfBytes) {
        return valueOf(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Byte contains.
     * @return A new Byte unit with the given value.
     */
    @NonNull
    public static Byte valueOf(@NonNull final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    public Byte add(final long bytesToAdd) {
        return new Byte(addNullsafe(bytes, asBigInteger(bytesToAdd)));
    }

    @Override
    public Byte add(final StorageUnit<?> storageAmount) {
        return new Byte(addNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    public Byte divide(final long divisor) {
        return new Byte(divideNullsafe(bytes, asBigInteger(divisor)));
    }

    @Override
    public Byte multiply(final long factor) {
        return new Byte(multiplyNullsafe(bytes, asBigInteger(factor)));
    }

    @Override
    public Byte subtract(final long bytesToSubtract) {
        return new Byte(subtractNullsafe(bytes, asBigInteger(bytesToSubtract)));
    }

    @Override
    public Byte subtract(final StorageUnit<?> storageAmount) {
        return new Byte(subtractNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return nonNull(BigInteger.ONE);
    }

    @Override
    protected String getSymbol() {
        return "B"; //$NON-NLS-1$
    }

}
