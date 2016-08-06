/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.utils.storage_unit;

import static de.xn__ho_hia.quality.null_analysis.Nullsafe.asBigInteger;
import static de.xn__ho_hia.quality.null_analysis.Nullsafe.multiplyNullsafe;
import static de.xn__ho_hia.utils.storage_unit.FormatUtils.asFormat;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Function;

import org.eclipse.jdt.annotation.NonNull;
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

    private static final long serialVersionUID = -7344790980741118949L;

    private static final int DEFAULT_SCALE = 24;

    /**
     * Default number format used within the library.
     */
    static final String DEFAULT_FORMAT_PATTERN = "0.00"; //$NON-NLS-1$

    /**
     * The storage unit base for binary numbers. Each step between the units dimensions is done with this base value.
     */
    @NonNull
    static final BigInteger BINARY_UNIT_BASE = asBigInteger(1024);

    @NonNull
    static final BigInteger BYTES_IN_A_KIBIBYTE = multiplyNullsafe(Nullsafe.nonNull(BigInteger.ONE),
            StorageUnit.BINARY_UNIT_BASE);

    @NonNull
    static final BigInteger BYTES_IN_A_MEBIBYTE = multiplyNullsafe(StorageUnit.BYTES_IN_A_KIBIBYTE,
            StorageUnit.BINARY_UNIT_BASE);

    @NonNull
    static final BigInteger BYTES_IN_A_GIBIBYTE = multiplyNullsafe(StorageUnit.BYTES_IN_A_MEBIBYTE,
            StorageUnit.BINARY_UNIT_BASE);

    @NonNull
    static final BigInteger BYTES_IN_A_TEBIBYTE = multiplyNullsafe(StorageUnit.BYTES_IN_A_GIBIBYTE,
            StorageUnit.BINARY_UNIT_BASE);

    @NonNull
    static final BigInteger BYTES_IN_A_PEBIBYTE = multiplyNullsafe(StorageUnit.BYTES_IN_A_TEBIBYTE,
            StorageUnit.BINARY_UNIT_BASE);

    @NonNull
    static final BigInteger BYTES_IN_A_EXBIBYTE = multiplyNullsafe(StorageUnit.BYTES_IN_A_PEBIBYTE,
            StorageUnit.BINARY_UNIT_BASE);

    @NonNull
    static final BigInteger BYTES_IN_A_ZEBIBYTE = multiplyNullsafe(StorageUnit.BYTES_IN_A_EXBIBYTE,
            StorageUnit.BINARY_UNIT_BASE);

    @NonNull
    static final BigInteger BYTES_IN_A_YOBIBYTE = multiplyNullsafe(StorageUnit.BYTES_IN_A_ZEBIBYTE,
            StorageUnit.BINARY_UNIT_BASE);

    /**
     * The storage unit base for metric numbers. Each step between the units dimensions is done with this base value.
     */
    @NonNull
    static final BigInteger METRIC_UNIT_BASE = asBigInteger(1000);

    @NonNull
    static final BigInteger BYTES_IN_A_KILOBYTE = multiplyNullsafe(Nullsafe.nonNull(BigInteger.ONE),
            StorageUnit.METRIC_UNIT_BASE);

    @NonNull
    static final BigInteger BYTES_IN_A_MEGABYTE = multiplyNullsafe(StorageUnit.BYTES_IN_A_KILOBYTE,
            StorageUnit.METRIC_UNIT_BASE);

    @NonNull
    static final BigInteger BYTES_IN_A_GIGABYTE = multiplyNullsafe(StorageUnit.BYTES_IN_A_MEGABYTE,
            StorageUnit.METRIC_UNIT_BASE);

    @NonNull
    static final BigInteger BYTES_IN_A_TERABYTE = multiplyNullsafe(StorageUnit.BYTES_IN_A_GIGABYTE,
            StorageUnit.METRIC_UNIT_BASE);

    @NonNull
    static final BigInteger BYTES_IN_A_PETABYTE = multiplyNullsafe(StorageUnit.BYTES_IN_A_TERABYTE,
            StorageUnit.METRIC_UNIT_BASE);

    @NonNull
    static final BigInteger BYTES_IN_A_EXABYTE = multiplyNullsafe(StorageUnit.BYTES_IN_A_PETABYTE,
            StorageUnit.METRIC_UNIT_BASE);

    @NonNull
    static final BigInteger BYTES_IN_A_ZETTABYTE = multiplyNullsafe(StorageUnit.BYTES_IN_A_EXABYTE,
            StorageUnit.METRIC_UNIT_BASE);

    @NonNull
    static final BigInteger BYTES_IN_A_YOTTABYTE = multiplyNullsafe(StorageUnit.BYTES_IN_A_ZETTABYTE,
            StorageUnit.METRIC_UNIT_BASE);

    @NonNull
    protected final BigInteger bytes;

    protected StorageUnit(@NonNull final BigInteger bytes) {
        this.bytes = bytes;
    }

    /**
     * @return This storage unit as the best matching binary-prefixed unit.
     */
    @NonNull
    public final StorageUnit<?> asBestMatchingBinaryUnit() {
        return StorageUnits.binaryValueOf(this.bytes);
    }

    /**
     * @return This storage unit as the best matching metric-prefixed unit.
     */
    @NonNull
    public final StorageUnit<?> asBestMatchingMetricUnit() {
        return StorageUnits.metricValueOf(this.bytes);
    }

    /**
     * @return This storage unit as the best matching unit, while keeping the current prefix-type (binary or metric).
     */
    @NonNull
    public final StorageUnit<?> asBestMatchingUnit() {
        return converter().apply(this.bytes);
    }

    protected abstract Function<@NonNull BigInteger, @NonNull StorageUnit<?>> converter();

    /**
     * @return This storage unit as bytes.
     */
    @NonNull
    public final Byte asByte() {
        return new Byte(this.bytes);
    }

    /**
     * @return This storage unit as a kibibyte.
     */
    @NonNull
    public final Kibibyte asKibibyte() {
        return new Kibibyte(this.bytes);
    }

    /**
     * @return This storage unit as a mebibyte.
     */
    @NonNull
    public final Mebibyte asMebibyte() {
        return new Mebibyte(this.bytes);
    }

    /**
     * @return This storage unit as a gibibyte.
     */
    @NonNull
    public final Gibibyte asGibibyte() {
        return new Gibibyte(this.bytes);
    }

    /**
     * @return This storage unit as a tebibyte.
     */
    @NonNull
    public final Tebibyte asTebibyte() {
        return new Tebibyte(this.bytes);
    }

    /**
     * @return This storage unit as a pebibyte.
     */
    @NonNull
    public final Pebibyte asPebibyte() {
        return new Pebibyte(this.bytes);
    }

    /**
     * @return This storage unit as a exbibyte.
     */
    @NonNull
    public final Exbibyte asExbibyte() {
        return new Exbibyte(this.bytes);
    }

    /**
     * @return This storage unit as a zebibyte.
     */
    @NonNull
    public final Zebibyte asZebibyte() {
        return new Zebibyte(this.bytes);
    }

    /**
     * @return This storage unit as a yobibyte.
     */
    @NonNull
    public final Yobibyte asYobibyte() {
        return new Yobibyte(this.bytes);
    }

    /**
     * @return This storage unit as a kilobyte.
     */
    @NonNull
    public final Kilobyte asKilobyte() {
        return new Kilobyte(this.bytes);
    }

    /**
     * @return This storage unit as a megabyte.
     */
    @NonNull
    public final Megabyte asMegabyte() {
        return new Megabyte(this.bytes);
    }

    /**
     * @return This storage unit as a gigabyte.
     */
    @NonNull
    public final Gigabyte asGigabyte() {
        return new Gigabyte(this.bytes);
    }

    /**
     * @return This storage unit as a terabyte.
     */
    @NonNull
    public final Terabyte asTerabyte() {
        return new Terabyte(this.bytes);
    }

    /**
     * @return This storage unit as a petabyte.
     */
    @NonNull
    public final Petabyte asPetabyte() {
        return new Petabyte(this.bytes);
    }

    /**
     * @return This storage unit as a exabyte.
     */
    @NonNull
    public final Exabyte asExabyte() {
        return new Exabyte(this.bytes);
    }

    /**
     * @return This storage unit as a zettabyte.
     */
    @NonNull
    public final Zettabyte asZettabyte() {
        return new Zettabyte(this.bytes);
    }

    /**
     * @return This storage unit as a yottabyte.
     */
    @NonNull
    public final Yottabyte asYottabyte() {
        return new Yottabyte(this.bytes);
    }

    /**
     * @return The amount of bytes this storage unit encompasses.
     */
    @NonNull
    public final BigInteger inByte() {
        return this.bytes;
    }

    /**
     * @return This storage unit quantified as kibibyte.
     */
    @NonNull
    public final BigDecimal inKibibyte() {
        return this.calculate(StorageUnit.BYTES_IN_A_KIBIBYTE);
    }

    /**
     * @return This storage unit quantified as mebibyte.
     */
    @NonNull
    public final BigDecimal inMebibyte() {
        return this.calculate(StorageUnit.BYTES_IN_A_MEBIBYTE);
    }

    /**
     * @return This storage unit quantified as gibibyte.
     */
    @NonNull
    public final BigDecimal inGibibyte() {
        return this.calculate(StorageUnit.BYTES_IN_A_GIBIBYTE);
    }

    /**
     * @return This storage unit quantified as tebibyte.
     */
    @NonNull
    public final BigDecimal inTebibyte() {
        return this.calculate(StorageUnit.BYTES_IN_A_TEBIBYTE);
    }

    /**
     * @return This storage unit quantified as pebibyte.
     */
    @NonNull
    public final BigDecimal inPebibyte() {
        return this.calculate(StorageUnit.BYTES_IN_A_PEBIBYTE);
    }

    /**
     * @return This storage unit quantified as exbibyte.
     */
    @NonNull
    public final BigDecimal inExbibyte() {
        return this.calculate(StorageUnit.BYTES_IN_A_EXBIBYTE);
    }

    /**
     * @return This storage unit quantified as zebibyte.
     */
    @NonNull
    public final BigDecimal inZebibyte() {
        return this.calculate(StorageUnit.BYTES_IN_A_ZEBIBYTE);
    }

    /**
     * @return This storage unit quantified as yobibyte.
     */
    @NonNull
    public final BigDecimal inYobibyte() {
        return this.calculate(StorageUnit.BYTES_IN_A_YOBIBYTE);
    }

    /**
     * @return This storage unit quantified as kilobyte.
     */
    @NonNull
    public final BigDecimal inKilobyte() {
        return this.calculate(StorageUnit.BYTES_IN_A_KILOBYTE);
    }

    /**
     * @return This storage unit quantified as megabyte.
     */
    @NonNull
    public final BigDecimal inMegabyte() {
        return this.calculate(StorageUnit.BYTES_IN_A_MEGABYTE);
    }

    /**
     * @return This storage unit quantified as gigabyte.
     */
    @NonNull
    public final BigDecimal inGigabyte() {
        return this.calculate(StorageUnit.BYTES_IN_A_GIGABYTE);
    }

    /**
     * @return This storage unit quantified as terabyte.
     */
    @NonNull
    public final BigDecimal inTerabyte() {
        return this.calculate(StorageUnit.BYTES_IN_A_TERABYTE);
    }

    /**
     * @return This storage unit quantified as petabyte.
     */
    @NonNull
    public final BigDecimal inPetabyte() {
        return this.calculate(StorageUnit.BYTES_IN_A_PETABYTE);
    }

    /**
     * @return This storage unit quantified as exabyte.
     */
    @NonNull
    public final BigDecimal inExabyte() {
        return this.calculate(StorageUnit.BYTES_IN_A_EXABYTE);
    }

    /**
     * @return This storage unit quantified as zettabyte.
     */
    @NonNull
    public final BigDecimal inZettabyte() {
        return this.calculate(StorageUnit.BYTES_IN_A_ZETTABYTE);
    }

    /**
     * @return This storage unit quantified as yottabyte.
     */
    @NonNull
    public final BigDecimal inYottabyte() {
        return this.calculate(StorageUnit.BYTES_IN_A_YOTTABYTE);
    }

    @NonNull
    @Override
    public final String toString() {
        return this.toString(DEFAULT_FORMAT_PATTERN);
    }

    /**
     * Formats this storage unit according to the given pattern.
     *
     * @param pattern
     *            The {@link Format} pattern to apply.
     * @return The formatted representation of this storage unit.
     */
    @NonNull
    public final String toString(final String pattern) {
        return this.toString(new DecimalFormat(pattern));
    }

    /**
     * Formats this storage unit according to the given pattern in a specific {@link Locale}.
     *
     * @param pattern
     *            The {@link Format} pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted representation of this storage unit.
     */
    @NonNull
    public final String toString(final String pattern, final Locale locale) {
        return this.toString(asFormat(pattern, locale));
    }

    /**
     * Formats this storage unit according to a specified {@link Format}. The storage unit's symbol will be
     * automatically added at the end of the formatted string together with a single whitespace character in front of
     * it. Use the <code>asOtherUnit</code> methods before printing in order to change the symbol.
     *
     * @param format
     *            The custom format to use.
     * @return The formatted representation of this storage unit.
     */
    @NonNull
    public final String toString(final Format format) {
        final BigDecimal amount = this.calculate(this.getNumberOfBytesPerUnit());
        final String formattedAmount = format.format(amount);
        return Nullsafe.nonNull(new StringBuilder(calculateBuilderCapacity(formattedAmount))
                .append(formattedAmount)
                .append(" ") //$NON-NLS-1$
                .append(getSymbol())
                .toString());
    }

    @NonNull
    private final BigDecimal calculate(final BigInteger base) {
        return Nullsafe.nonNull(new BigDecimal(this.bytes.toString())
                .divide(new BigDecimal(base.toString()), StorageUnit.DEFAULT_SCALE, RoundingMode.CEILING));
    }

    // Only exposed to be accessible by tests.
    final int calculateBuilderCapacity(final String formattedAmount) {
        return formattedAmount.length() + getSymbol().length() + 2;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(this.bytes);
    }

    @Override
    public final boolean equals(@Nullable final Object other) {
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
    @NonNull
    public abstract T add(long bytesToAdd);

    /**
     * @param storageAmount
     *            The amount of storage to add.
     * @return The new amount of storage in the appropriate type.
     */
    @NonNull
    public abstract T add(@NonNull StorageUnit<?> storageAmount);

    /**
     * @param divisor
     *            The divisor to apply.
     * @return The new amount of storage in the appropriate type.
     */
    @NonNull
    public abstract T divide(long divisor);

    /**
     * @param factor
     *            The factor to apply.
     * @return The new amount of storage in the appropriate type.
     */
    @NonNull
    public abstract T multiply(long factor);

    /**
     * @param bytesToSubtract
     *            The amount of bytes to subtract.
     * @return The new amount of storage in the appropriate type.
     */
    @NonNull
    public abstract T subtract(long bytesToSubtract);

    /**
     * @param storageAmount
     *            The amount of storage to subtract.
     * @return The new amount of storage in the appropriate type.
     */
    @NonNull
    public abstract T subtract(@NonNull StorageUnit<?> storageAmount);

    @NonNull
    protected abstract BigInteger getNumberOfBytesPerUnit();

    @NonNull
    protected abstract String getSymbol();

}
