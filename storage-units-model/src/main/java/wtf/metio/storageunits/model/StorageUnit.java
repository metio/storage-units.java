/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.model;

import com.google.errorprone.annotations.CheckReturnValue;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Function;

import static wtf.metio.storageunits.model.FormatUtils.asFormat;

/**
 * Abstract base class for all storage units. Provides common functionality for unit conversion, hashCode(), equals(),
 * compareTo(), toString(), doubleValue(), floatValue(), intValue() and longValue().
 *
 * @param <T> The type of this storage unit.
 */
public abstract class StorageUnit<T extends StorageUnit<T>> extends Number implements Comparable<StorageUnit<?>> {

    @Serial
    private static final long serialVersionUID = -7344790980741118949L;

    private static final int DEFAULT_SCALE = 24;

    /**
     * Default number format used within the library.
     */
    static final @NotNull String DEFAULT_FORMAT_PATTERN = "0.00"; //$NON-NLS-1$

    /**
     * The storage unit base for binary numbers. Each step between the units dimensions is done with this base value.
     */
    static final @NotNull BigInteger BINARY_UNIT_BASE = BigInteger.valueOf(1024);

    static final @NotNull BigInteger BYTES_IN_A_KIBIBYTE = BigInteger.ONE.multiply(StorageUnit.BINARY_UNIT_BASE);

    static final @NotNull BigInteger BYTES_IN_A_MEBIBYTE = StorageUnit.BYTES_IN_A_KIBIBYTE.multiply(
            StorageUnit.BINARY_UNIT_BASE);

    static final @NotNull BigInteger BYTES_IN_A_GIBIBYTE = StorageUnit.BYTES_IN_A_MEBIBYTE.multiply(
            StorageUnit.BINARY_UNIT_BASE);

    static final @NotNull BigInteger BYTES_IN_A_TEBIBYTE = StorageUnit.BYTES_IN_A_GIBIBYTE.multiply(
            StorageUnit.BINARY_UNIT_BASE);

    static final @NotNull BigInteger BYTES_IN_A_PEBIBYTE = StorageUnit.BYTES_IN_A_TEBIBYTE.multiply(
            StorageUnit.BINARY_UNIT_BASE);

    static final @NotNull BigInteger BYTES_IN_A_EXBIBYTE = StorageUnit.BYTES_IN_A_PEBIBYTE.multiply(
            StorageUnit.BINARY_UNIT_BASE);

    static final @NotNull BigInteger BYTES_IN_A_ZEBIBYTE = StorageUnit.BYTES_IN_A_EXBIBYTE.multiply(
            StorageUnit.BINARY_UNIT_BASE);

    static final @NotNull BigInteger BYTES_IN_A_YOBIBYTE = StorageUnit.BYTES_IN_A_ZEBIBYTE.multiply(
            StorageUnit.BINARY_UNIT_BASE);

    static final @NotNull BigInteger BYTES_IN_A_ROBIBYTE = StorageUnit.BYTES_IN_A_YOBIBYTE.multiply(
            StorageUnit.BINARY_UNIT_BASE);

    static final @NotNull BigInteger BYTES_IN_A_QUBIBYTE = StorageUnit.BYTES_IN_A_ROBIBYTE.multiply(
            StorageUnit.BINARY_UNIT_BASE);

    /**
     * The storage unit base for decimal numbers. Each step between the units dimensions is done with this base value.
     */
    static final @NotNull BigInteger DECIMAL_UNIT_BASE = BigInteger.valueOf(1000);

    static final @NotNull BigInteger BYTES_IN_A_KILOBYTE = BigInteger.ONE.multiply(
            StorageUnit.DECIMAL_UNIT_BASE);

    static final @NotNull BigInteger BYTES_IN_A_MEGABYTE = StorageUnit.BYTES_IN_A_KILOBYTE.multiply(
            StorageUnit.DECIMAL_UNIT_BASE);

    static final @NotNull BigInteger BYTES_IN_A_GIGABYTE = StorageUnit.BYTES_IN_A_MEGABYTE.multiply(
            StorageUnit.DECIMAL_UNIT_BASE);

    static final @NotNull BigInteger BYTES_IN_A_TERABYTE = StorageUnit.BYTES_IN_A_GIGABYTE.multiply(
            StorageUnit.DECIMAL_UNIT_BASE);

    static final @NotNull BigInteger BYTES_IN_A_PETABYTE = StorageUnit.BYTES_IN_A_TERABYTE.multiply(
            StorageUnit.DECIMAL_UNIT_BASE);

    static final @NotNull BigInteger BYTES_IN_A_EXABYTE = StorageUnit.BYTES_IN_A_PETABYTE.multiply(
            StorageUnit.DECIMAL_UNIT_BASE);

    static final @NotNull BigInteger BYTES_IN_A_ZETTABYTE = StorageUnit.BYTES_IN_A_EXABYTE.multiply(
            StorageUnit.DECIMAL_UNIT_BASE);

    static final @NotNull BigInteger BYTES_IN_A_YOTTABYTE = StorageUnit.BYTES_IN_A_ZETTABYTE.multiply(
            StorageUnit.DECIMAL_UNIT_BASE);

    static final @NotNull BigInteger BYTES_IN_A_RONNABYTE = StorageUnit.BYTES_IN_A_YOTTABYTE.multiply(
            StorageUnit.DECIMAL_UNIT_BASE);

    static final @NotNull BigInteger BYTES_IN_A_QUETTABYTE = StorageUnit.BYTES_IN_A_RONNABYTE.multiply(
            StorageUnit.DECIMAL_UNIT_BASE);

    protected final @NotNull BigInteger bytes;

    protected StorageUnit(final @NotNull BigInteger numberOfBytes) {
        bytes = numberOfBytes;
    }

    /**
     * @return This storage unit as the best matching binary unit.
     */
    @CheckReturnValue
    public final @NotNull StorageUnit<?> asBestMatchingBinaryUnit() {
        return StorageUnits.binaryValueOf(bytes);
    }

    /**
     * @return This storage unit as the best matching decimal unit.
     */
    @CheckReturnValue
    public final @NotNull StorageUnit<?> asBestMatchingDecimalUnit() {
        return StorageUnits.decimalValueOf(bytes);
    }

    /**
     * @return This storage unit as the best matching unit, while keeping the current type (binary or decimal).
     */
    @CheckReturnValue
    public final @NotNull StorageUnit<?> asBestMatchingUnit() {
        return converter().apply(bytes);
    }

    protected abstract @NotNull Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter();

    /**
     * @return This storage unit as bytes.
     */
    @CheckReturnValue
    public final @NotNull Byte asByte() {
        return new Byte(bytes);
    }

    /**
     * @return This storage unit as a kibibyte.
     */
    @CheckReturnValue
    public final @NotNull Kibibyte asKibibyte() {
        return new Kibibyte(bytes);
    }

    /**
     * @return This storage unit as a mebibyte.
     */
    @CheckReturnValue
    public final @NotNull Mebibyte asMebibyte() {
        return new Mebibyte(bytes);
    }

    /**
     * @return This storage unit as a gibibyte.
     */
    @CheckReturnValue
    public final @NotNull Gibibyte asGibibyte() {
        return new Gibibyte(bytes);
    }

    /**
     * @return This storage unit as a tebibyte.
     */
    @CheckReturnValue
    public final @NotNull Tebibyte asTebibyte() {
        return new Tebibyte(bytes);
    }

    /**
     * @return This storage unit as a pebibyte.
     */
    @CheckReturnValue
    public final @NotNull Pebibyte asPebibyte() {
        return new Pebibyte(bytes);
    }

    /**
     * @return This storage unit as an exbibyte.
     */
    @CheckReturnValue
    public final @NotNull Exbibyte asExbibyte() {
        return new Exbibyte(bytes);
    }

    /**
     * @return This storage unit as a zebibyte.
     */
    @CheckReturnValue
    public final @NotNull Zebibyte asZebibyte() {
        return new Zebibyte(bytes);
    }

    /**
     * @return This storage unit as a yobibyte.
     */
    @CheckReturnValue
    public final @NotNull Yobibyte asYobibyte() {
        return new Yobibyte(bytes);
    }

    /**
     * @return This storage unit as a robibyte.
     */
    @CheckReturnValue
    public final @NotNull Robibyte asRobibyte() {
        return new Robibyte(bytes);
    }

    /**
     * @return This storage unit as a qubibyte.
     */
    @CheckReturnValue
    public final @NotNull Qubibyte asQubibyte() {
        return new Qubibyte(bytes);
    }

    /**
     * @return This storage unit as a kilobyte.
     */
    @CheckReturnValue
    public final @NotNull Kilobyte asKilobyte() {
        return new Kilobyte(bytes);
    }

    /**
     * @return This storage unit as a megabyte.
     */
    @CheckReturnValue
    public final @NotNull Megabyte asMegabyte() {
        return new Megabyte(bytes);
    }

    /**
     * @return This storage unit as a gigabyte.
     */
    @CheckReturnValue
    public final @NotNull Gigabyte asGigabyte() {
        return new Gigabyte(bytes);
    }

    /**
     * @return This storage unit as a terabyte.
     */
    @CheckReturnValue
    public final @NotNull Terabyte asTerabyte() {
        return new Terabyte(bytes);
    }

    /**
     * @return This storage unit as a petabyte.
     */
    @CheckReturnValue
    public final @NotNull Petabyte asPetabyte() {
        return new Petabyte(bytes);
    }

    /**
     * @return This storage unit as an exabyte.
     */
    @CheckReturnValue
    public final @NotNull Exabyte asExabyte() {
        return new Exabyte(bytes);
    }

    /**
     * @return This storage unit as a zettabyte.
     */
    @CheckReturnValue
    public final @NotNull Zettabyte asZettabyte() {
        return new Zettabyte(bytes);
    }

    /**
     * @return This storage unit as a yottabyte.
     */
    @CheckReturnValue
    public final @NotNull Yottabyte asYottabyte() {
        return new Yottabyte(bytes);
    }

    /**
     * @return This storage unit as a ronnabyte.
     */
    @CheckReturnValue
    public final @NotNull Ronnabyte asRonnabyte() {
        return new Ronnabyte(bytes);
    }

    /**
     * @return This storage unit as a quettabyte.
     */
    @CheckReturnValue
    public final @NotNull Quettabyte asQuettabyte() {
        return new Quettabyte(bytes);
    }

    /**
     * @return The amount of bytes this storage unit encompasses.
     */
    @CheckReturnValue
    public final @NotNull BigInteger inByte() {
        return bytes;
    }

    /**
     * @return This storage unit quantified as kibibyte.
     */
    @CheckReturnValue
    public final @NotNull BigDecimal inKibibyte() {
        return calculate(StorageUnit.BYTES_IN_A_KIBIBYTE);
    }

    /**
     * @return This storage unit quantified as mebibyte.
     */
    @CheckReturnValue
    public final @NotNull BigDecimal inMebibyte() {
        return calculate(StorageUnit.BYTES_IN_A_MEBIBYTE);
    }

    /**
     * @return This storage unit quantified as gibibyte.
     */
    @CheckReturnValue
    public final @NotNull BigDecimal inGibibyte() {
        return calculate(StorageUnit.BYTES_IN_A_GIBIBYTE);
    }

    /**
     * @return This storage unit quantified as tebibyte.
     */
    @CheckReturnValue
    public final @NotNull BigDecimal inTebibyte() {
        return calculate(StorageUnit.BYTES_IN_A_TEBIBYTE);
    }

    /**
     * @return This storage unit quantified as pebibyte.
     */
    @CheckReturnValue
    public final @NotNull BigDecimal inPebibyte() {
        return calculate(StorageUnit.BYTES_IN_A_PEBIBYTE);
    }

    /**
     * @return This storage unit quantified as exbibyte.
     */
    @CheckReturnValue
    public final @NotNull BigDecimal inExbibyte() {
        return calculate(StorageUnit.BYTES_IN_A_EXBIBYTE);
    }

    /**
     * @return This storage unit quantified as zebibyte.
     */
    @CheckReturnValue
    public final @NotNull BigDecimal inZebibyte() {
        return calculate(StorageUnit.BYTES_IN_A_ZEBIBYTE);
    }

    /**
     * @return This storage unit quantified as yobibyte.
     */
    @CheckReturnValue
    public final @NotNull BigDecimal inYobibyte() {
        return calculate(StorageUnit.BYTES_IN_A_YOBIBYTE);
    }

    /**
     * @return This storage unit quantified as robibyte.
     */
    @CheckReturnValue
    public final @NotNull BigDecimal inRobibyte() {
        return calculate(StorageUnit.BYTES_IN_A_ROBIBYTE);
    }

    /**
     * @return This storage unit quantified as qubibyte.
     */
    @CheckReturnValue
    public final @NotNull BigDecimal inQubibyte() {
        return calculate(StorageUnit.BYTES_IN_A_QUBIBYTE);
    }

    /**
     * @return This storage unit quantified as kilobyte.
     */
    @CheckReturnValue
    public final @NotNull BigDecimal inKilobyte() {
        return calculate(StorageUnit.BYTES_IN_A_KILOBYTE);
    }

    /**
     * @return This storage unit quantified as megabyte.
     */
    @CheckReturnValue
    public final @NotNull BigDecimal inMegabyte() {
        return calculate(StorageUnit.BYTES_IN_A_MEGABYTE);
    }

    /**
     * @return This storage unit quantified as gigabyte.
     */
    @CheckReturnValue
    public final @NotNull BigDecimal inGigabyte() {
        return calculate(StorageUnit.BYTES_IN_A_GIGABYTE);
    }

    /**
     * @return This storage unit quantified as terabyte.
     */
    @CheckReturnValue
    public final @NotNull BigDecimal inTerabyte() {
        return calculate(StorageUnit.BYTES_IN_A_TERABYTE);
    }

    /**
     * @return This storage unit quantified as petabyte.
     */
    @CheckReturnValue
    public final @NotNull BigDecimal inPetabyte() {
        return calculate(StorageUnit.BYTES_IN_A_PETABYTE);
    }

    /**
     * @return This storage unit quantified as exabyte.
     */
    @CheckReturnValue
    public final @NotNull BigDecimal inExabyte() {
        return calculate(StorageUnit.BYTES_IN_A_EXABYTE);
    }

    /**
     * @return This storage unit quantified as zettabyte.
     */
    @CheckReturnValue
    public final @NotNull BigDecimal inZettabyte() {
        return calculate(StorageUnit.BYTES_IN_A_ZETTABYTE);
    }

    /**
     * @return This storage unit quantified as yottabyte.
     */
    @CheckReturnValue
    public final @NotNull BigDecimal inYottabyte() {
        return calculate(StorageUnit.BYTES_IN_A_YOTTABYTE);
    }

    /**
     * @return This storage unit quantified as ronnabyte.
     */
    @CheckReturnValue
    public final @NotNull BigDecimal inRonnabyte() {
        return calculate(StorageUnit.BYTES_IN_A_RONNABYTE);
    }

    /**
     * @return This storage unit quantified as quettabyte.
     */
    @CheckReturnValue
    public final @NotNull BigDecimal inQuettabyte() {
        return calculate(StorageUnit.BYTES_IN_A_QUETTABYTE);
    }

    @Override
    @CheckReturnValue
    public final @NotNull String toString() {
        return toString(DEFAULT_FORMAT_PATTERN);
    }

    /**
     * Formats this storage unit according to the given pattern.
     *
     * @param pattern The {@link Format} pattern to apply.
     * @return The formatted representation of this storage unit.
     */
    @CheckReturnValue
    public final @NotNull String toString(final String pattern) {
        return toString(new DecimalFormat(pattern));
    }

    /**
     * Formats this storage unit according to the given pattern in a specific {@link Locale}.
     *
     * @param pattern The {@link Format} pattern to apply.
     * @param locale  The locale to use.
     * @return The formatted representation of this storage unit.
     */
    @CheckReturnValue
    public final @NotNull String toString(final String pattern, final Locale locale) {
        return toString(asFormat(pattern, locale));
    }

    /**
     * Formats this storage unit according to a specified {@link Format}. The storage unit's symbol will be automatically
     * added at the end of the formatted string together with a single whitespace character in front of it. Use the
     * {@code asOtherUnit} methods before printing in order to change the symbol.
     *
     * @param format The custom format to use.
     * @return The formatted representation of this storage unit.
     */
    @CheckReturnValue
    public final @NotNull String toString(final Format format) {
        final BigDecimal amount = calculate(getNumberOfBytesPerUnit());
        final String formattedAmount = format.format(amount);
        return String.format("%s %s", formattedAmount, getSymbol());
    }

    @CheckReturnValue
    private @NotNull BigDecimal calculate(final BigInteger base) {
        return new BigDecimal(bytes)
                .divide(new BigDecimal(base), StorageUnit.DEFAULT_SCALE, RoundingMode.CEILING);
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(bytes);
    }

    @Override
    public final boolean equals(final Object obj) {
        if (obj instanceof final StorageUnit<?> other) {
            return Objects.equals(bytes, other.bytes);
        }

        return false;
    }

    @Override
    public final int compareTo(final StorageUnit<?> o) {
        return bytes.compareTo(o.bytes);
    }

    @Override
    public final double doubleValue() {
        return bytes.doubleValue();
    }

    @Override
    public final float floatValue() {
        return bytes.floatValue();
    }

    @Override
    public final int intValue() {
        return bytes.intValue();
    }

    @Override
    public final long longValue() {
        return bytes.longValue();
    }

    /**
     * @param bytesToAdd The amount of bytes to add.
     * @return The new amount of storage in the appropriate type.
     */
    public abstract @NotNull T add(long bytesToAdd);

    /**
     * @param bytesToAdd The amount of bytes to add.
     * @return The new amount of storage in the appropriate type.
     */
    public abstract @NotNull T add(@NotNull BigInteger bytesToAdd);

    /**
     * @param storageAmount The amount of storage to add.
     * @return The new amount of storage in the appropriate type.
     */
    public abstract @NotNull T add(@NotNull StorageUnit<?> storageAmount);

    /**
     * @param divisor The divisor to apply.
     * @return The new amount of storage in the appropriate type.
     */
    public abstract @NotNull T divide(long divisor);

    /**
     * @param divisor The divisor to apply.
     * @return The new amount of storage in the appropriate type.
     */
    public abstract @NotNull T divide(@NotNull BigInteger divisor);

    /**
     * @param factor The factor to apply.
     * @return The new amount of storage in the appropriate type.
     */
    public abstract @NotNull T multiply(long factor);

    /**
     * @param factor The factor to apply.
     * @return The new amount of storage in the appropriate type.
     */
    public abstract @NotNull T multiply(@NotNull BigInteger factor);

    /**
     * @param bytesToSubtract The amount of bytes to subtract.
     * @return The new amount of storage in the appropriate type.
     */
    public abstract @NotNull T subtract(long bytesToSubtract);

    /**
     * @param bytesToSubtract The amount of bytes to subtract.
     * @return The new amount of storage in the appropriate type.
     */
    public abstract @NotNull T subtract(@NotNull BigInteger bytesToSubtract);

    /**
     * @param storageAmount The amount of storage to subtract.
     * @return The new amount of storage in the appropriate type.
     */
    public abstract @NotNull T subtract(@NotNull StorageUnit<?> storageAmount);

    protected abstract @NotNull BigInteger getNumberOfBytesPerUnit();

    protected abstract @NotNull String getSymbol();

}
