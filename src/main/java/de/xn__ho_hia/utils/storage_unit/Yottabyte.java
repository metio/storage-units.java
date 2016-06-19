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
 * Yottabyte as specified in ISO IEC 80000-13:2008 (1 Yottabyte = 1 000 000 000 000 000 000 000 000 Byte).
 */
public class Yottabyte extends StorageUnit<Yottabyte> {

    private static final long serialVersionUID = 2482152459842042316L;

    Yottabyte(final BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the yottabyte contains.
     * @return A new Yottabyte unit with the given value.
     */
    public static Yottabyte valueOf(final BigInteger numberOfBytes) {
        return new Yottabyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the yottabytes contains.
     * @return A new Yottabyte unit with the given value.
     */
    public static Yottabyte valueOf(final long numberOfBytes) {
        return new Yottabyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the yottabytes contains.
     * @return A new Yottabyte unit with the given value.
     */
    public static Yottabyte valueOf(final Long numberOfBytes) {
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

}
