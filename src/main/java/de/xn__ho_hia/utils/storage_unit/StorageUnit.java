/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.utils.storage_unit;

import static de.xn__ho_hia.utils.storage_unit.NullsafeMath.asBigInteger;
import static de.xn__ho_hia.utils.storage_unit.NullsafeMath.multiplyNullsafe;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Objects;

import org.eclipse.jdt.annotation.Nullable;

import de.xn__ho_hia.quality.null_analysis.Nullsafe;

/**
 * Abstract base class for all storage units. Provides common functionality for unit conversion, hashCode(), equals(),
 * compareTo(), toString(), doubleValue(), floatValue(), intValue() and longValue().
 *
 * @param <T>
 *            The type of this storage unit.
 */
public abstract class StorageUnit<T extends StorageUnit<T>> extends Number implements Comparable<StorageUnit<?>> {

    private static final int NUMBER_OF_DECIMAL_PLACES = 2;

    private static final long serialVersionUID = -7344790980741118949L;

    private static final int DEFAULT_SCALE = 24;

    /**
     * The storage unit base for binary numbers. Each step between the units dimensions is done with this base value.
     */
    static final BigInteger BINARY_UNIT_BASE = asBigInteger(1024);

    static final BigInteger BYTES_IN_A_KIBIBYTE = multiplyNullsafe(Nullsafe.nonNull(BigInteger.ONE),
            StorageUnit.BINARY_UNIT_BASE);

    static final BigInteger BYTES_IN_A_MEBIBYTE = multiplyNullsafe(StorageUnit.BYTES_IN_A_KIBIBYTE,
            StorageUnit.BINARY_UNIT_BASE);

    static final BigInteger BYTES_IN_A_GIBIBYTE = multiplyNullsafe(StorageUnit.BYTES_IN_A_MEBIBYTE,
            StorageUnit.BINARY_UNIT_BASE);

    static final BigInteger BYTES_IN_A_TEBIBYTE = multiplyNullsafe(StorageUnit.BYTES_IN_A_GIBIBYTE,
            StorageUnit.BINARY_UNIT_BASE);

    static final BigInteger BYTES_IN_A_PEBIBYTE = multiplyNullsafe(StorageUnit.BYTES_IN_A_TEBIBYTE,
            StorageUnit.BINARY_UNIT_BASE);

    static final BigInteger BYTES_IN_A_EXBIBYTE = multiplyNullsafe(StorageUnit.BYTES_IN_A_PEBIBYTE,
            StorageUnit.BINARY_UNIT_BASE);

    static final BigInteger BYTES_IN_A_ZEBIBYTE = multiplyNullsafe(StorageUnit.BYTES_IN_A_EXBIBYTE,
            StorageUnit.BINARY_UNIT_BASE);

    static final BigInteger BYTES_IN_A_YOBIBYTE = multiplyNullsafe(StorageUnit.BYTES_IN_A_ZEBIBYTE,
            StorageUnit.BINARY_UNIT_BASE);

    /**
     * The storage unit base for metric numbers. Each step between the units dimensions is done with this base value.
     */
    static final BigInteger METRIC_UNIT_BASE = asBigInteger(1000);

    static final BigInteger BYTES_IN_A_KILOBYTE = multiplyNullsafe(Nullsafe.nonNull(BigInteger.ONE),
            StorageUnit.METRIC_UNIT_BASE);

    static final BigInteger BYTES_IN_A_MEGABYTE = multiplyNullsafe(StorageUnit.BYTES_IN_A_KILOBYTE,
            StorageUnit.METRIC_UNIT_BASE);

    static final BigInteger BYTES_IN_A_GIGABYTE = multiplyNullsafe(StorageUnit.BYTES_IN_A_MEGABYTE,
            StorageUnit.METRIC_UNIT_BASE);

    static final BigInteger BYTES_IN_A_TERABYTE = multiplyNullsafe(StorageUnit.BYTES_IN_A_GIGABYTE,
            StorageUnit.METRIC_UNIT_BASE);

    static final BigInteger BYTES_IN_A_PETABYTE = multiplyNullsafe(StorageUnit.BYTES_IN_A_TERABYTE,
            StorageUnit.METRIC_UNIT_BASE);

    static final BigInteger BYTES_IN_A_EXABYTE = multiplyNullsafe(StorageUnit.BYTES_IN_A_PETABYTE,
            StorageUnit.METRIC_UNIT_BASE);

    static final BigInteger BYTES_IN_A_ZETTABYTE = multiplyNullsafe(StorageUnit.BYTES_IN_A_EXABYTE,
            StorageUnit.METRIC_UNIT_BASE);

    static final BigInteger BYTES_IN_A_YOTTABYTE = multiplyNullsafe(StorageUnit.BYTES_IN_A_ZETTABYTE,
            StorageUnit.METRIC_UNIT_BASE);

    protected final BigInteger bytes;

    protected StorageUnit(final BigInteger bytes) {
        this.bytes = bytes;
    }

    /**
     * @return This storage unit as a kibibyte.
     */
    public final Kibibyte asKibibyte() {
        return new Kibibyte(this.bytes);
    }

    /**
     * @return This storage unit as a mebibyte.
     */
    public final Mebibyte asMebibyte() {
        return new Mebibyte(this.bytes);
    }

    /**
     * @return This storage unit as a gibibyte.
     */
    public final Gibibyte asGibibyte() {
        return new Gibibyte(this.bytes);
    }

    /**
     * @return This storage unit as a tebibyte.
     */
    public final Tebibyte asTebibyte() {
        return new Tebibyte(this.bytes);
    }

    /**
     * @return This storage unit as a pebibyte.
     */
    public final Pebibyte asPebibyte() {
        return new Pebibyte(this.bytes);
    }

    /**
     * @return This storage unit as a exbibyte.
     */
    public final Exbibyte asExbibyte() {
        return new Exbibyte(this.bytes);
    }

    /**
     * @return This storage unit as a zebibyte.
     */
    public final Zebibyte asZebibyte() {
        return new Zebibyte(this.bytes);
    }

    /**
     * @return This storage unit as a yobibyte.
     */
    public final Yobibyte asYobibyte() {
        return new Yobibyte(this.bytes);
    }

    /**
     * @return This storage unit as a kilobyte.
     */
    public final Kilobyte asKilobyte() {
        return new Kilobyte(this.bytes);
    }

    /**
     * @return This storage unit as a megabyte.
     */
    public final Megabyte asMegabyte() {
        return new Megabyte(this.bytes);
    }

    /**
     * @return This storage unit as a gigabyte.
     */
    public final Gigabyte asGigabyte() {
        return new Gigabyte(this.bytes);
    }

    /**
     * @return This storage unit as a terabyte.
     */
    public final Terabyte asTerabyte() {
        return new Terabyte(this.bytes);
    }

    /**
     * @return This storage unit as a petabyte.
     */
    public final Petabyte asPetabyte() {
        return new Petabyte(this.bytes);
    }

    /**
     * @return This storage unit as a exabyte.
     */
    public final Exabyte asExabyte() {
        return new Exabyte(this.bytes);
    }

    /**
     * @return This storage unit as a zettabyte.
     */
    public final Zettabyte asZettabyte() {
        return new Zettabyte(this.bytes);
    }

    /**
     * @return This storage unit as a yottabyte.
     */
    public final Yottabyte asYottabyte() {
        return new Yottabyte(this.bytes);
    }

    /**
     * @return The amount of bytes this storage unit encompasses.
     */
    public final BigInteger inByte() {
        return this.bytes;
    }

    /**
     * @return This storage unit quantified as kibibyte.
     */
    public final BigDecimal inKibibyte() {
        return this.calculate(StorageUnit.BYTES_IN_A_KIBIBYTE);
    }

    /**
     * @return This storage unit quantified as mebibyte.
     */
    public final BigDecimal inMebibyte() {
        return this.calculate(StorageUnit.BYTES_IN_A_MEBIBYTE);
    }

    /**
     * @return This storage unit quantified as gibibyte.
     */
    public final BigDecimal inGibibyte() {
        return this.calculate(StorageUnit.BYTES_IN_A_GIBIBYTE);
    }

    /**
     * @return This storage unit quantified as tebibyte.
     */
    public final BigDecimal inTebibyte() {
        return this.calculate(StorageUnit.BYTES_IN_A_TEBIBYTE);
    }

    /**
     * @return This storage unit quantified as pebibyte.
     */
    public final BigDecimal inPebibyte() {
        return this.calculate(StorageUnit.BYTES_IN_A_PEBIBYTE);
    }

    /**
     * @return This storage unit quantified as exbibyte.
     */
    public final BigDecimal inExbibyte() {
        return this.calculate(StorageUnit.BYTES_IN_A_EXBIBYTE);
    }

    /**
     * @return This storage unit quantified as zebibyte.
     */
    public final BigDecimal inZebibyte() {
        return this.calculate(StorageUnit.BYTES_IN_A_ZEBIBYTE);
    }

    /**
     * @return This storage unit quantified as yobibyte.
     */
    public final BigDecimal inYobibyte() {
        return this.calculate(StorageUnit.BYTES_IN_A_YOBIBYTE);
    }

    /**
     * @return This storage unit quantified as kilobyte.
     */
    public final BigDecimal inKilobyte() {
        return this.calculate(StorageUnit.BYTES_IN_A_KILOBYTE);
    }

    /**
     * @return This storage unit quantified as megabyte.
     */
    public final BigDecimal inMegabyte() {
        return this.calculate(StorageUnit.BYTES_IN_A_MEGABYTE);
    }

    /**
     * @return This storage unit quantified as gigabyte.
     */
    public final BigDecimal inGigabyte() {
        return this.calculate(StorageUnit.BYTES_IN_A_GIGABYTE);
    }

    /**
     * @return This storage unit quantified as terabyte.
     */
    public final BigDecimal inTerabyte() {
        return this.calculate(StorageUnit.BYTES_IN_A_TERABYTE);
    }

    /**
     * @return This storage unit quantified as petabyte.
     */
    public final BigDecimal inPetabyte() {
        return this.calculate(StorageUnit.BYTES_IN_A_PETABYTE);
    }

    /**
     * @return This storage unit quantified as exabyte.
     */
    public final BigDecimal inExabyte() {
        return this.calculate(StorageUnit.BYTES_IN_A_EXABYTE);
    }

    /**
     * @return This storage unit quantified as zettabyte.
     */
    public final BigDecimal inZettabyte() {
        return this.calculate(StorageUnit.BYTES_IN_A_ZETTABYTE);
    }

    /**
     * @return This storage unit quantified as yottabyte.
     */
    public final BigDecimal inYottabyte() {
        return this.calculate(StorageUnit.BYTES_IN_A_YOTTABYTE);
    }

    @Override
    public final String toString() {
        final BigDecimal amount = this.calculate(this.getNumberOfBytesPerUnit());

        return amount
                .setScale(NUMBER_OF_DECIMAL_PLACES, RoundingMode.HALF_UP)
                .toPlainString() + " " + this.getSymbol(); //$NON-NLS-1$
    }

    private final BigDecimal calculate(final BigInteger base) {
        return Nullsafe.nonNull(new BigDecimal(this.bytes.toString())
                .divide(new BigDecimal(base.toString()), StorageUnit.DEFAULT_SCALE, RoundingMode.CEILING));
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(this.bytes);
    }

    @Override
    public final boolean equals(final @Nullable Object other) {
        if (other instanceof StorageUnit<?>) {
            final StorageUnit<?> that = (StorageUnit<?>) other;

            return Objects.equals(this.bytes, that.bytes);
        }

        return false;
    }

    @Override
    public final int compareTo(final StorageUnit<?> that) {
        return this.bytes.compareTo(that.bytes);
    }

    @Override
    public final double doubleValue() {
        return this.bytes.doubleValue();
    }

    @Override
    public final float floatValue() {
        return this.bytes.floatValue();
    }

    @Override
    public final int intValue() {
        return this.bytes.intValue();
    }

    @Override
    public final long longValue() {
        return this.bytes.longValue();
    }

    /**
     * @param bytesToAdd
     *            The amount of bytes to add.
     * @return The new amount of storage in the appropriate type.
     */
    public abstract T add(long bytesToAdd);

    /**
     * @param storageAmount
     *            The amount of storage to add.
     * @return The new amount of storage in the appropriate type.
     */
    public abstract T add(StorageUnit<?> storageAmount);

    /**
     * @param divisor
     *            The divisor to apply.
     * @return The new amount of storage in the appropriate type.
     */
    public abstract T divide(long divisor);

    /**
     * @param factor
     *            The factor to apply.
     * @return The new amount of storage in the appropriate type.
     */
    public abstract T multiply(long factor);

    /**
     * @param bytesToSubtract
     *            The amount of bytes to subtract.
     * @return The new amount of storage in the appropriate type.
     */
    public abstract T subtract(long bytesToSubtract);

    /**
     * @param storageAmount
     *            The amount of storage to subtract.
     * @return The new amount of storage in the appropriate type.
     */
    public abstract T subtract(StorageUnit<?> storageAmount);

    protected abstract BigInteger getNumberOfBytesPerUnit();

    protected abstract String getSymbol();

}
