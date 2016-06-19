/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.utils.storage_unit;

import static de.xn__ho_hia.utils.storage_unit.NullsafeMath.addNullsafe;
import static de.xn__ho_hia.utils.storage_unit.NullsafeMath.asBigInteger;
import static de.xn__ho_hia.utils.storage_unit.NullsafeMath.divideNullsafe;
import static de.xn__ho_hia.utils.storage_unit.NullsafeMath.multiplyNullsafe;
import static de.xn__ho_hia.utils.storage_unit.NullsafeMath.subtractNullsafe;

import java.math.BigInteger;

/**
 * Megabyte as specified in ISO IEC 80000-13:2008 (1 Megabyte = 1 000 000 Byte).
 */
public class Megabyte extends StorageUnit<Megabyte> {

    private static final long serialVersionUID = 5901923092058760111L;

    Megabyte(final BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the megabyte contains.
     * @return A new Megabyte unit with the given value.
     */
    public static Megabyte valueOf(final BigInteger numberOfBytes) {
        return new Megabyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the megabytes contains.
     * @return A new Megabyte unit with the given value.
     */
    public static Megabyte valueOf(final long numberOfBytes) {
        return new Megabyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the megabytes contains.
     * @return A new Megabyte unit with the given value.
     */
    public static Megabyte valueOf(final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    public Megabyte add(final long bytesToAdd) {
        return new Megabyte(addNullsafe(bytes, asBigInteger(bytesToAdd)));
    }

    @Override
    public Megabyte add(final StorageUnit<?> storageAmount) {
        return new Megabyte(addNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    public Megabyte divide(final long divisor) {
        return new Megabyte(divideNullsafe(bytes, asBigInteger(divisor)));
    }

    @Override
    public Megabyte multiply(final long factor) {
        return new Megabyte(multiplyNullsafe(bytes, asBigInteger(factor)));
    }

    @Override
    public Megabyte subtract(final long bytesToSubtract) {
        return new Megabyte(subtractNullsafe(bytes, asBigInteger(bytesToSubtract)));
    }

    @Override
    public Megabyte subtract(final StorageUnit<?> storageAmount) {
        return new Megabyte(subtractNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_MEGABYTE;
    }

    @Override
    protected String getSymbol() {
        return "MB"; //$NON-NLS-1$
    }

}
