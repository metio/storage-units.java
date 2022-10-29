/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.model;

import static wtf.metio.storageunits.model.FormatUtils.asFormat;

import java.io.Serial;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Function;
import edu.umd.cs.findbugs.annotations.CheckReturnValue;
import org.jetbrains.annotations.NotNull;

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
  @NotNull
  static final String DEFAULT_FORMAT_PATTERN = "0.00"; //$NON-NLS-1$

  /**
   * The storage unit base for binary numbers. Each step between the units dimensions is done with this base value.
   */
  @NotNull
  static final BigInteger BINARY_UNIT_BASE = BigInteger.valueOf(1024);

  @NotNull
  static final BigInteger BYTES_IN_A_KIBIBYTE = BigInteger.ONE.multiply(StorageUnit.BINARY_UNIT_BASE);

  @NotNull
  static final BigInteger BYTES_IN_A_MEBIBYTE = StorageUnit.BYTES_IN_A_KIBIBYTE.multiply(
      StorageUnit.BINARY_UNIT_BASE);

  @NotNull
  static final BigInteger BYTES_IN_A_GIBIBYTE = StorageUnit.BYTES_IN_A_MEBIBYTE.multiply(
      StorageUnit.BINARY_UNIT_BASE);

  @NotNull
  static final BigInteger BYTES_IN_A_TEBIBYTE = StorageUnit.BYTES_IN_A_GIBIBYTE.multiply(
      StorageUnit.BINARY_UNIT_BASE);

  @NotNull
  static final BigInteger BYTES_IN_A_PEBIBYTE = StorageUnit.BYTES_IN_A_TEBIBYTE.multiply(
      StorageUnit.BINARY_UNIT_BASE);

  @NotNull
  static final BigInteger BYTES_IN_A_EXBIBYTE = StorageUnit.BYTES_IN_A_PEBIBYTE.multiply(
      StorageUnit.BINARY_UNIT_BASE);

  @NotNull
  static final BigInteger BYTES_IN_A_ZEBIBYTE = StorageUnit.BYTES_IN_A_EXBIBYTE.multiply(
      StorageUnit.BINARY_UNIT_BASE);

  @NotNull
  static final BigInteger BYTES_IN_A_YOBIBYTE = StorageUnit.BYTES_IN_A_ZEBIBYTE.multiply(
      StorageUnit.BINARY_UNIT_BASE);

  /**
   * The storage unit base for decimal numbers. Each step between the units dimensions is done with this base value.
   */
  @NotNull
  static final BigInteger DECIMAL_UNIT_BASE = BigInteger.valueOf(1000);

  @NotNull
  static final BigInteger BYTES_IN_A_KILOBYTE = BigInteger.ONE.multiply(
      StorageUnit.DECIMAL_UNIT_BASE);

  @NotNull
  static final BigInteger BYTES_IN_A_MEGABYTE = StorageUnit.BYTES_IN_A_KILOBYTE.multiply(
      StorageUnit.DECIMAL_UNIT_BASE);

  @NotNull
  static final BigInteger BYTES_IN_A_GIGABYTE = StorageUnit.BYTES_IN_A_MEGABYTE.multiply(
      StorageUnit.DECIMAL_UNIT_BASE);

  @NotNull
  static final BigInteger BYTES_IN_A_TERABYTE = StorageUnit.BYTES_IN_A_GIGABYTE.multiply(
      StorageUnit.DECIMAL_UNIT_BASE);

  @NotNull
  static final BigInteger BYTES_IN_A_PETABYTE = StorageUnit.BYTES_IN_A_TERABYTE.multiply(
      StorageUnit.DECIMAL_UNIT_BASE);

  @NotNull
  static final BigInteger BYTES_IN_A_EXABYTE = StorageUnit.BYTES_IN_A_PETABYTE.multiply(
      StorageUnit.DECIMAL_UNIT_BASE);

  @NotNull
  static final BigInteger BYTES_IN_A_ZETTABYTE = StorageUnit.BYTES_IN_A_EXABYTE.multiply(
      StorageUnit.DECIMAL_UNIT_BASE);

  @NotNull
  static final BigInteger BYTES_IN_A_YOTTABYTE = StorageUnit.BYTES_IN_A_ZETTABYTE.multiply(
      StorageUnit.DECIMAL_UNIT_BASE);

  @NotNull
  protected final BigInteger bytes;

  protected StorageUnit(@NotNull final BigInteger bytes) {
    this.bytes = bytes;
  }

  /**
   * @return This storage unit as the best matching binary unit.
   */
  @NotNull
  @CheckReturnValue
  public final StorageUnit<?> asBestMatchingBinaryUnit() {
    return StorageUnits.binaryValueOf(this.bytes);
  }

  /**
   * @return This storage unit as the best matching decimal unit.
   */
  @NotNull
  @CheckReturnValue
  public final StorageUnit<?> asBestMatchingDecimalUnit() {
    return StorageUnits.decimalValueOf(this.bytes);
  }

  /**
   * @return This storage unit as the best matching unit, while keeping the current type (binary, decimal, common).
   */
  @NotNull
  @CheckReturnValue
  public final StorageUnit<?> asBestMatchingUnit() {
    return converter().apply(this.bytes);
  }

  @NotNull
  protected abstract Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter();

  /**
   * @return This storage unit as bytes.
   */
  @NotNull
  @CheckReturnValue
  public final Byte asByte() {
    return new Byte(this.bytes);
  }

  /**
   * @return This storage unit as a kibibyte.
   */
  @NotNull
  @CheckReturnValue
  public final Kibibyte asKibibyte() {
    return new Kibibyte(this.bytes);
  }

  /**
   * @return This storage unit as a mebibyte.
   */
  @NotNull
  @CheckReturnValue
  public final Mebibyte asMebibyte() {
    return new Mebibyte(this.bytes);
  }

  /**
   * @return This storage unit as a gibibyte.
   */
  @NotNull
  @CheckReturnValue
  public final Gibibyte asGibibyte() {
    return new Gibibyte(this.bytes);
  }

  /**
   * @return This storage unit as a tebibyte.
   */
  @NotNull
  @CheckReturnValue
  public final Tebibyte asTebibyte() {
    return new Tebibyte(this.bytes);
  }

  /**
   * @return This storage unit as a pebibyte.
   */
  @NotNull
  @CheckReturnValue
  public final Pebibyte asPebibyte() {
    return new Pebibyte(this.bytes);
  }

  /**
   * @return This storage unit as a exbibyte.
   */
  @NotNull
  @CheckReturnValue
  public final Exbibyte asExbibyte() {
    return new Exbibyte(this.bytes);
  }

  /**
   * @return This storage unit as a zebibyte.
   */
  @NotNull
  @CheckReturnValue
  public final Zebibyte asZebibyte() {
    return new Zebibyte(this.bytes);
  }

  /**
   * @return This storage unit as a yobibyte.
   */
  @NotNull
  @CheckReturnValue
  public final Yobibyte asYobibyte() {
    return new Yobibyte(this.bytes);
  }

  /**
   * @return This storage unit as a kilobyte.
   */
  @NotNull
  @CheckReturnValue
  public final Kilobyte asKilobyte() {
    return new Kilobyte(this.bytes);
  }

  /**
   * @return This storage unit as a megabyte.
   */
  @NotNull
  @CheckReturnValue
  public final Megabyte asMegabyte() {
    return new Megabyte(this.bytes);
  }

  /**
   * @return This storage unit as a gigabyte.
   */
  @NotNull
  @CheckReturnValue
  public final Gigabyte asGigabyte() {
    return new Gigabyte(this.bytes);
  }

  /**
   * @return This storage unit as a terabyte.
   */
  @NotNull
  @CheckReturnValue
  public final Terabyte asTerabyte() {
    return new Terabyte(this.bytes);
  }

  /**
   * @return This storage unit as a petabyte.
   */
  @NotNull
  @CheckReturnValue
  public final Petabyte asPetabyte() {
    return new Petabyte(this.bytes);
  }

  /**
   * @return This storage unit as a exabyte.
   */
  @NotNull
  @CheckReturnValue
  public final Exabyte asExabyte() {
    return new Exabyte(this.bytes);
  }

  /**
   * @return This storage unit as a zettabyte.
   */
  @NotNull
  @CheckReturnValue
  public final Zettabyte asZettabyte() {
    return new Zettabyte(this.bytes);
  }

  /**
   * @return This storage unit as a yottabyte.
   */
  @NotNull
  @CheckReturnValue
  public final Yottabyte asYottabyte() {
    return new Yottabyte(this.bytes);
  }

  /**
   * @return The amount of bytes this storage unit encompasses.
   */
  @NotNull
  @CheckReturnValue
  public final BigInteger inByte() {
    return this.bytes;
  }

  /**
   * @return This storage unit quantified as kibibyte.
   */
  @NotNull
  @CheckReturnValue
  public final BigDecimal inKibibyte() {
    return this.calculate(StorageUnit.BYTES_IN_A_KIBIBYTE);
  }

  /**
   * @return This storage unit quantified as mebibyte.
   */
  @NotNull
  @CheckReturnValue
  public final BigDecimal inMebibyte() {
    return this.calculate(StorageUnit.BYTES_IN_A_MEBIBYTE);
  }

  /**
   * @return This storage unit quantified as gibibyte.
   */
  @NotNull
  @CheckReturnValue
  public final BigDecimal inGibibyte() {
    return this.calculate(StorageUnit.BYTES_IN_A_GIBIBYTE);
  }

  /**
   * @return This storage unit quantified as tebibyte.
   */
  @NotNull
  @CheckReturnValue
  public final BigDecimal inTebibyte() {
    return this.calculate(StorageUnit.BYTES_IN_A_TEBIBYTE);
  }

  /**
   * @return This storage unit quantified as pebibyte.
   */
  @NotNull
  @CheckReturnValue
  public final BigDecimal inPebibyte() {
    return this.calculate(StorageUnit.BYTES_IN_A_PEBIBYTE);
  }

  /**
   * @return This storage unit quantified as exbibyte.
   */
  @NotNull
  @CheckReturnValue
  public final BigDecimal inExbibyte() {
    return this.calculate(StorageUnit.BYTES_IN_A_EXBIBYTE);
  }

  /**
   * @return This storage unit quantified as zebibyte.
   */
  @NotNull
  @CheckReturnValue
  public final BigDecimal inZebibyte() {
    return this.calculate(StorageUnit.BYTES_IN_A_ZEBIBYTE);
  }

  /**
   * @return This storage unit quantified as yobibyte.
   */
  @NotNull
  @CheckReturnValue
  public final BigDecimal inYobibyte() {
    return this.calculate(StorageUnit.BYTES_IN_A_YOBIBYTE);
  }

  /**
   * @return This storage unit quantified as kilobyte.
   */
  @NotNull
  @CheckReturnValue
  public final BigDecimal inKilobyte() {
    return this.calculate(StorageUnit.BYTES_IN_A_KILOBYTE);
  }

  /**
   * @return This storage unit quantified as megabyte.
   */
  @NotNull
  @CheckReturnValue
  public final BigDecimal inMegabyte() {
    return this.calculate(StorageUnit.BYTES_IN_A_MEGABYTE);
  }

  /**
   * @return This storage unit quantified as gigabyte.
   */
  @NotNull
  @CheckReturnValue
  public final BigDecimal inGigabyte() {
    return this.calculate(StorageUnit.BYTES_IN_A_GIGABYTE);
  }

  /**
   * @return This storage unit quantified as terabyte.
   */
  @NotNull
  @CheckReturnValue
  public final BigDecimal inTerabyte() {
    return this.calculate(StorageUnit.BYTES_IN_A_TERABYTE);
  }

  /**
   * @return This storage unit quantified as petabyte.
   */
  @NotNull
  @CheckReturnValue
  public final BigDecimal inPetabyte() {
    return this.calculate(StorageUnit.BYTES_IN_A_PETABYTE);
  }

  /**
   * @return This storage unit quantified as exabyte.
   */
  @NotNull
  @CheckReturnValue
  public final BigDecimal inExabyte() {
    return this.calculate(StorageUnit.BYTES_IN_A_EXABYTE);
  }

  /**
   * @return This storage unit quantified as zettabyte.
   */
  @NotNull
  @CheckReturnValue
  public final BigDecimal inZettabyte() {
    return this.calculate(StorageUnit.BYTES_IN_A_ZETTABYTE);
  }

  /**
   * @return This storage unit quantified as yottabyte.
   */
  @NotNull
  @CheckReturnValue
  public final BigDecimal inYottabyte() {
    return this.calculate(StorageUnit.BYTES_IN_A_YOTTABYTE);
  }

  /**
   * @return This storage unit quantified as common kibibyte.
   */
  @NotNull
  @CheckReturnValue
  public final BigDecimal inCommonKilobyte() {
    return this.calculate(StorageUnit.BYTES_IN_A_KIBIBYTE);
  }

  /**
   * @return This storage unit quantified as common mebibyte.
   */
  @NotNull
  @CheckReturnValue
  public final BigDecimal inCommonMegabyte() {
    return this.calculate(StorageUnit.BYTES_IN_A_MEBIBYTE);
  }

  /**
   * @return This storage unit quantified as common gibibyte.
   */
  @NotNull
  @CheckReturnValue
  public final BigDecimal inCommonGigabyte() {
    return this.calculate(StorageUnit.BYTES_IN_A_GIBIBYTE);
  }

  /**
   * @return This storage unit quantified as common tebibyte.
   */
  @NotNull
  @CheckReturnValue
  public final BigDecimal inCommonTerabyte() {
    return this.calculate(StorageUnit.BYTES_IN_A_TEBIBYTE);
  }

  /**
   * @return This storage unit quantified as common pebibyte.
   */
  @NotNull
  @CheckReturnValue
  public final BigDecimal inCommonPetabyte() {
    return this.calculate(StorageUnit.BYTES_IN_A_PEBIBYTE);
  }

  /**
   * @return This storage unit quantified as common exbibyte.
   */
  @NotNull
  @CheckReturnValue
  public final BigDecimal inCommonExabyte() {
    return this.calculate(StorageUnit.BYTES_IN_A_EXBIBYTE);
  }

  /**
   * @return This storage unit quantified as common zebibyte.
   */
  @NotNull
  @CheckReturnValue
  public final BigDecimal inCommonZettabyte() {
    return this.calculate(StorageUnit.BYTES_IN_A_ZEBIBYTE);
  }

  /**
   * @return This storage unit quantified as common yottabyte.
   */
  @NotNull
  @CheckReturnValue
  public final BigDecimal inCommonYottabyte() {
    return this.calculate(StorageUnit.BYTES_IN_A_YOBIBYTE);
  }

  @NotNull
  @Override
  @CheckReturnValue
  public final String toString() {
    return this.toString(DEFAULT_FORMAT_PATTERN);
  }

  /**
   * Formats this storage unit according to the given pattern.
   *
   * @param pattern The {@link Format} pattern to apply.
   * @return The formatted representation of this storage unit.
   */
  @NotNull
  @CheckReturnValue
  public final String toString(final String pattern) {
    return this.toString(new DecimalFormat(pattern));
  }

  /**
   * Formats this storage unit according to the given pattern in a specific {@link Locale}.
   *
   * @param pattern The {@link Format} pattern to apply.
   * @param locale  The locale to use.
   * @return The formatted representation of this storage unit.
   */
  @NotNull
  @CheckReturnValue
  public final String toString(final String pattern, final Locale locale) {
    return this.toString(asFormat(pattern, locale));
  }

  /**
   * Formats this storage unit according to a specified {@link Format}. The storage unit's symbol will be automatically
   * added at the end of the formatted string together with a single whitespace character in front of it. Use the
   * <code>asOtherUnit</code> methods before printing in order to change the symbol.
   *
   * @param format The custom format to use.
   * @return The formatted representation of this storage unit.
   */
  @NotNull
  @CheckReturnValue
  public final String toString(final Format format) {
    final BigDecimal amount = this.calculate(this.getNumberOfBytesPerUnit());
    final String formattedAmount = format.format(amount);
    return String.format("%s %s", formattedAmount, getSymbol());
  }

  @NotNull
  @CheckReturnValue
  private BigDecimal calculate(final BigInteger base) {
    return new BigDecimal(this.bytes)
        .divide(new BigDecimal(base), StorageUnit.DEFAULT_SCALE, RoundingMode.CEILING);
  }

  @Override
  public final int hashCode() {
    return Objects.hashCode(this.bytes);
  }

  @Override
  public final boolean equals(final Object other) {
    if (other instanceof final StorageUnit<?> that) {
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
   * @param bytesToAdd The amount of bytes to add.
   * @return The new amount of storage in the appropriate type.
   */
  @NotNull
  public abstract T add(long bytesToAdd);

  /**
   * @param bytesToAdd The amount of bytes to add.
   * @return The new amount of storage in the appropriate type.
   */
  @NotNull
  public abstract T add(@NotNull BigInteger bytesToAdd);

  /**
   * @param storageAmount The amount of storage to add.
   * @return The new amount of storage in the appropriate type.
   */
  @NotNull
  public abstract T add(@NotNull StorageUnit<?> storageAmount);

  /**
   * @param divisor The divisor to apply.
   * @return The new amount of storage in the appropriate type.
   */
  @NotNull
  public abstract T divide(long divisor);

  /**
   * @param divisor The divisor to apply.
   * @return The new amount of storage in the appropriate type.
   */
  @NotNull
  public abstract T divide(@NotNull BigInteger divisor);

  /**
   * @param factor The factor to apply.
   * @return The new amount of storage in the appropriate type.
   */
  @NotNull
  public abstract T multiply(long factor);

  /**
   * @param factor The factor to apply.
   * @return The new amount of storage in the appropriate type.
   */
  @NotNull
  public abstract T multiply(@NotNull BigInteger factor);

  /**
   * @param bytesToSubtract The amount of bytes to subtract.
   * @return The new amount of storage in the appropriate type.
   */
  @NotNull
  public abstract T subtract(long bytesToSubtract);

  /**
   * @param bytesToSubtract The amount of bytes to subtract.
   * @return The new amount of storage in the appropriate type.
   */
  @NotNull
  public abstract T subtract(@NotNull BigInteger bytesToSubtract);

  /**
   * @param storageAmount The amount of storage to subtract.
   * @return The new amount of storage in the appropriate type.
   */
  @NotNull
  public abstract T subtract(@NotNull StorageUnit<?> storageAmount);

  @NotNull
  protected abstract BigInteger getNumberOfBytesPerUnit();

  @NotNull
  protected abstract String getSymbol();

}
