/*
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 *
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information, please refer to <http://unlicense.org>
 */
package de.xn__ho_hia.utils.storage_unit;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * Abstract base class for all storage units. Provides common functionality for unit conversion, hashCode(), equals(),
 * compareTo(), toString(), doubleValue(), floatValue(), intValue() and longValue().
 *
 * @param <T>
 *            The type of this storage unit.
 */
public abstract class StorageUnit<T extends StorageUnit<T>> extends Number implements Comparable<StorageUnit<?>> {

    private static final int   NUMBER_OF_DECIMAL_PLACES = 2;

    private static final long  serialVersionUID         = -7344790980741118949L;

    private static final int   DEFAULT_SCALE            = 24;

    /**
     * The storage unit base for binary numbers. Each step between the units dimensions is done with this base value.
     */
    static final BigInteger    BINARY_UNIT_BASE         = BigInteger.valueOf(1024);

    static final BigInteger    BYTES_IN_A_KIBIBYTE      = BigInteger.ONE.multiply(StorageUnit.BINARY_UNIT_BASE);

    static final BigInteger    BYTES_IN_A_MEBIBYTE      = StorageUnit.BYTES_IN_A_KIBIBYTE
            .multiply(StorageUnit.BINARY_UNIT_BASE);

    static final BigInteger    BYTES_IN_A_GIBIBYTE      = StorageUnit.BYTES_IN_A_MEBIBYTE
            .multiply(StorageUnit.BINARY_UNIT_BASE);

    static final BigInteger    BYTES_IN_A_TEBIBYTE      = StorageUnit.BYTES_IN_A_GIBIBYTE
            .multiply(StorageUnit.BINARY_UNIT_BASE);

    static final BigInteger    BYTES_IN_A_PEBIBYTE      = StorageUnit.BYTES_IN_A_TEBIBYTE
            .multiply(StorageUnit.BINARY_UNIT_BASE);

    static final BigInteger    BYTES_IN_A_EXBIBYTE      = StorageUnit.BYTES_IN_A_PEBIBYTE
            .multiply(StorageUnit.BINARY_UNIT_BASE);

    static final BigInteger    BYTES_IN_A_ZEBIBYTE      = StorageUnit.BYTES_IN_A_EXBIBYTE
            .multiply(StorageUnit.BINARY_UNIT_BASE);

    static final BigInteger    BYTES_IN_A_YOBIBYTE      = StorageUnit.BYTES_IN_A_ZEBIBYTE
            .multiply(StorageUnit.BINARY_UNIT_BASE);

    /**
     * The storage unit base for metric numbers. Each step between the units dimensions is done with this base value.
     */
    static final BigInteger    METRIC_UNIT_BASE         = BigInteger.valueOf(1000);

    static final BigInteger    BYTES_IN_A_KILOBYTE      = BigInteger.ONE
            .multiply(StorageUnit.METRIC_UNIT_BASE);

    static final BigInteger    BYTES_IN_A_MEGABYTE      = StorageUnit.BYTES_IN_A_KILOBYTE
            .multiply(StorageUnit.METRIC_UNIT_BASE);

    static final BigInteger    BYTES_IN_A_GIGABYTE      = StorageUnit.BYTES_IN_A_MEGABYTE
            .multiply(StorageUnit.METRIC_UNIT_BASE);

    static final BigInteger    BYTES_IN_A_TERABYTE      = StorageUnit.BYTES_IN_A_GIGABYTE
            .multiply(StorageUnit.METRIC_UNIT_BASE);

    static final BigInteger    BYTES_IN_A_PETABYTE      = StorageUnit.BYTES_IN_A_TERABYTE
            .multiply(StorageUnit.METRIC_UNIT_BASE);

    static final BigInteger    BYTES_IN_A_EXABYTE       = StorageUnit.BYTES_IN_A_PETABYTE
            .multiply(StorageUnit.METRIC_UNIT_BASE);

    static final BigInteger    BYTES_IN_A_ZETTABYTE     = StorageUnit.BYTES_IN_A_EXABYTE
            .multiply(StorageUnit.METRIC_UNIT_BASE);

    static final BigInteger    BYTES_IN_A_YOTTABYTE     = StorageUnit.BYTES_IN_A_ZETTABYTE
            .multiply(StorageUnit.METRIC_UNIT_BASE);

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
        return new BigDecimal(this.bytes.toString())
                .divide(new BigDecimal(base.toString()), StorageUnit.DEFAULT_SCALE, RoundingMode.CEILING);
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(this.bytes);
    }

    @Override
    public final boolean equals(final Object other) {
        if (other instanceof StorageUnit<?>) {
            final StorageUnit<?> that = (StorageUnit<?>) other;

            return Objects.equals(this.bytes, that.bytes);
        }

        return false;
    }

    @Override
    public final int compareTo(final StorageUnit<?> that) {
        if (that != null) {
            return this.bytes.compareTo(that.bytes);
        }

        throw new NullPointerException("Can't compare against NULL object"); //$NON-NLS-1$
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