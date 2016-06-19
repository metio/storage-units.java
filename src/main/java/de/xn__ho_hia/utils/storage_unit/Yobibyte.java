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
 * Yobibyte as specified in ISO IEC 80000-13:2008 (1 Yobibyte = 1 208 925 819 614 629 174 706 176 Byte).
 */
public final class Yobibyte extends StorageUnit<Yobibyte> {

    /** Generated */
    private static final long serialVersionUID = -5606322878020884194L;

    Yobibyte(final BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the yobibyte contains.
     * @return A new Yobibyte unit with the given value.
     */
    public static Yobibyte valueOf(final BigInteger numberOfBytes) {
        return new Yobibyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the yobibytes contains.
     * @return A new Yobibyte unit with the given value.
     */
    public static Yobibyte valueOf(final long numberOfBytes) {
        return new Yobibyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the yobibytes contains.
     * @return A new Yobibyte unit with the given value.
     */
    public static Yobibyte valueOf(final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    public Yobibyte add(final long bytesToAdd) {
        return new Yobibyte(addNullsafe(bytes, asBigInteger(bytesToAdd)));
    }

    @Override
    public Yobibyte add(final StorageUnit<?> storageAmount) {
        return new Yobibyte(addNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    public Yobibyte divide(final long divisor) {
        return new Yobibyte(divideNullsafe(bytes, asBigInteger(divisor)));
    }

    @Override
    public Yobibyte multiply(final long factor) {
        return new Yobibyte(multiplyNullsafe(bytes, asBigInteger(factor)));
    }

    @Override
    public Yobibyte subtract(final long bytesToSubtract) {
        return new Yobibyte(subtractNullsafe(bytes, asBigInteger(bytesToSubtract)));
    }

    @Override
    public Yobibyte subtract(final StorageUnit<?> storageAmount) {
        return new Yobibyte(subtractNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_YOBIBYTE;
    }

    @Override
    protected String getSymbol() {
        return "YiB"; //$NON-NLS-1$
    }

}
