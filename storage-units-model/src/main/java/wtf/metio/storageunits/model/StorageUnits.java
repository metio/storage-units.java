/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package wtf.metio.storageunits.model;

import static wtf.metio.storageunits.model.FormatUtils.asFormat;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.Locale;
import edu.umd.cs.findbugs.annotations.CheckReturnValue;
import org.jetbrains.annotations.NotNull;

/**
 * Factory for storage units.
 */
public final class StorageUnits {

  private StorageUnits() {
    // Hidden constructor.
  }

  /**
   * @param bytes The amount to bytes to represent.
   * @return The appropriate binary-prefixed unit for the given amount of bytes.
   */
  @NotNull
  @CheckReturnValue
  public static StorageUnit<?> binaryValueOf(final long bytes) {
    return binaryValueOf(BigInteger.valueOf(bytes));
  }

  /**
   * @param bytes The amount to bytes to represent.
   * @return The appropriate binary-prefixed unit for the given amount of bytes.
   */
  @NotNull
  @CheckReturnValue
  public static StorageUnit<?> binaryValueOf(@NotNull final BigInteger bytes) {
    StorageUnit<?> unit = Byte.valueOf(bytes);
    @NotNull final BigInteger positiveNumberOfBytes = bytes.signum() == -1 ? bytes.negate() : bytes;

    if (inbetween(StorageUnit.BYTES_IN_A_KIBIBYTE, positiveNumberOfBytes, StorageUnit.BYTES_IN_A_MEBIBYTE)) {
      unit = unit.asKibibyte();
    } else if (inbetween(StorageUnit.BYTES_IN_A_MEBIBYTE, positiveNumberOfBytes, StorageUnit.BYTES_IN_A_GIBIBYTE)) {
      unit = unit.asMebibyte();
    } else if (inbetween(StorageUnit.BYTES_IN_A_GIBIBYTE, positiveNumberOfBytes, StorageUnit.BYTES_IN_A_TEBIBYTE)) {
      unit = unit.asGibibyte();
    } else if (inbetween(StorageUnit.BYTES_IN_A_TEBIBYTE, positiveNumberOfBytes, StorageUnit.BYTES_IN_A_PEBIBYTE)) {
      unit = unit.asTebibyte();
    } else if (inbetween(StorageUnit.BYTES_IN_A_PEBIBYTE, positiveNumberOfBytes, StorageUnit.BYTES_IN_A_EXBIBYTE)) {
      unit = unit.asPebibyte();
    } else if (inbetween(StorageUnit.BYTES_IN_A_EXBIBYTE, positiveNumberOfBytes, StorageUnit.BYTES_IN_A_ZEBIBYTE)) {
      unit = unit.asExbibyte();
    } else if (inbetween(StorageUnit.BYTES_IN_A_ZEBIBYTE, positiveNumberOfBytes, StorageUnit.BYTES_IN_A_YOBIBYTE)) {
      unit = unit.asZebibyte();
    } else if (greaterThanEquals(positiveNumberOfBytes, StorageUnit.BYTES_IN_A_YOBIBYTE)) {
      unit = unit.asYobibyte();
    }

    return unit;
  }

  /**
   * @param bytes The amount of bytes to represent.
   * @return The appropriate decimal unit for the given amount of bytes.
   */
  @NotNull
  @CheckReturnValue
  public static StorageUnit<?> decimalValueOf(final long bytes) {
    return decimalValueOf(BigInteger.valueOf(bytes));
  }

  /**
   * @param bytes The amount of bytes to represent.
   * @return The appropriate decimal unit for the given amount of bytes.
   */
  @NotNull
  @CheckReturnValue
  public static StorageUnit<?> decimalValueOf(@NotNull final BigInteger bytes) {
    StorageUnit<?> unit = Byte.valueOf(bytes);
    @NotNull final BigInteger positiveNumberOfBytes = bytes.signum() == -1 ? bytes.negate() : bytes;

    if (inbetween(StorageUnit.BYTES_IN_A_KILOBYTE, positiveNumberOfBytes, StorageUnit.BYTES_IN_A_MEGABYTE)) {
      unit = unit.asKilobyte();
    } else if (inbetween(StorageUnit.BYTES_IN_A_MEGABYTE, positiveNumberOfBytes, StorageUnit.BYTES_IN_A_GIGABYTE)) {
      unit = unit.asMegabyte();
    } else if (inbetween(StorageUnit.BYTES_IN_A_GIGABYTE, positiveNumberOfBytes, StorageUnit.BYTES_IN_A_TERABYTE)) {
      unit = unit.asGigabyte();
    } else if (inbetween(StorageUnit.BYTES_IN_A_TERABYTE, positiveNumberOfBytes, StorageUnit.BYTES_IN_A_PETABYTE)) {
      unit = unit.asTerabyte();
    } else if (inbetween(StorageUnit.BYTES_IN_A_PETABYTE, positiveNumberOfBytes, StorageUnit.BYTES_IN_A_EXABYTE)) {
      unit = unit.asPetabyte();
    } else if (inbetween(StorageUnit.BYTES_IN_A_EXABYTE, positiveNumberOfBytes, StorageUnit.BYTES_IN_A_ZETTABYTE)) {
      unit = unit.asExabyte();
    } else if (inbetween(StorageUnit.BYTES_IN_A_ZETTABYTE, positiveNumberOfBytes, StorageUnit.BYTES_IN_A_YOTTABYTE)) {
      unit = unit.asZettabyte();
    } else if (greaterThanEquals(positiveNumberOfBytes, StorageUnit.BYTES_IN_A_YOTTABYTE)) {
      unit = unit.asYottabyte();
    }

    return unit;
  }

  @CheckReturnValue
  private static boolean inbetween(final BigInteger start, final BigInteger value, final BigInteger endExclusive) {
    return greaterThanEquals(value, start) && value.compareTo(endExclusive) < 0;
  }

  @CheckReturnValue
  private static boolean greaterThanEquals(final BigInteger value, final BigInteger comparison) {
    return value.compareTo(comparison) >= 0;
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsByte(@NotNull final Long numberOfBytes) {
    return formatAsByte(numberOfBytes.longValue());
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsByte(final long numberOfBytes) {
    return formatAsByte(BigInteger.valueOf(numberOfBytes));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsByte(@NotNull final BigInteger numberOfBytes) {
    return numberOfBytes + " B";
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsBinaryUnit(@NotNull final Long numberOfBytes) {
    return formatAsBinaryUnit(numberOfBytes.longValue());
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsBinaryUnit(final long numberOfBytes) {
    return formatAsBinaryUnit(BigInteger.valueOf(numberOfBytes));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsBinaryUnit(@NotNull final BigInteger numberOfBytes) {
    return formatAsBinaryUnit(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsBinaryUnit(@NotNull final Long numberOfBytes, @NotNull final String pattern) {
    return formatAsBinaryUnit(numberOfBytes.longValue(), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsBinaryUnit(final long numberOfBytes, @NotNull final String pattern) {
    return formatAsBinaryUnit(BigInteger.valueOf(numberOfBytes), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsBinaryUnit(@NotNull final BigInteger numberOfBytes, @NotNull final String pattern) {
    return formatAsBinaryUnit(numberOfBytes, new DecimalFormat(pattern));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsBinaryUnit(
      @NotNull final Long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsBinaryUnit(numberOfBytes.longValue(), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsBinaryUnit(
      final long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsBinaryUnit(BigInteger.valueOf(numberOfBytes), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsBinaryUnit(
      @NotNull final BigInteger numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsBinaryUnit(numberOfBytes, asFormat(pattern, locale));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsBinaryUnit(@NotNull final Long numberOfBytes, @NotNull final Format format) {
    return formatAsBinaryUnit(numberOfBytes.longValue(), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsBinaryUnit(final long numberOfBytes, @NotNull final Format format) {
    return formatAsBinaryUnit(BigInteger.valueOf(numberOfBytes), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsBinaryUnit(@NotNull final BigInteger numberOfBytes, @NotNull final Format format) {
    return binaryValueOf(numberOfBytes).toString(format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsKibibyte(@NotNull final Long numberOfBytes) {
    return formatAsKibibyte(numberOfBytes.longValue());
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsKibibyte(final long numberOfBytes) {
    return formatAsKibibyte(BigInteger.valueOf(numberOfBytes));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsKibibyte(@NotNull final BigInteger numberOfBytes) {
    return formatAsKibibyte(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsKibibyte(@NotNull final Long numberOfBytes, @NotNull final String pattern) {
    return formatAsKibibyte(numberOfBytes.longValue(), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsKibibyte(final long numberOfBytes, @NotNull final String pattern) {
    return formatAsKibibyte(BigInteger.valueOf(numberOfBytes), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsKibibyte(@NotNull final BigInteger numberOfBytes, @NotNull final String pattern) {
    return formatAsKibibyte(numberOfBytes, new DecimalFormat(pattern));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsKibibyte(
      @NotNull final Long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsKibibyte(numberOfBytes.longValue(), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsKibibyte(
      final long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsKibibyte(BigInteger.valueOf(numberOfBytes), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsKibibyte(
      @NotNull final BigInteger numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsKibibyte(numberOfBytes, asFormat(pattern, locale));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsKibibyte(@NotNull final Long numberOfBytes, @NotNull final Format format) {
    return formatAsKibibyte(numberOfBytes.longValue(), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsKibibyte(final long numberOfBytes, @NotNull final Format format) {
    return formatAsKibibyte(BigInteger.valueOf(numberOfBytes), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsKibibyte(@NotNull final BigInteger numberOfBytes, @NotNull final Format format) {
    return Kibibyte.valueOf(numberOfBytes).toString(format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsMebibyte(@NotNull final Long numberOfBytes) {
    return formatAsMebibyte(numberOfBytes.longValue());
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsMebibyte(final long numberOfBytes) {
    return formatAsMebibyte(BigInteger.valueOf(numberOfBytes));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsMebibyte(@NotNull final BigInteger numberOfBytes) {
    return formatAsMebibyte(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsMebibyte(@NotNull final Long numberOfBytes, @NotNull final String pattern) {
    return formatAsMebibyte(numberOfBytes.longValue(), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsMebibyte(final long numberOfBytes, @NotNull final String pattern) {
    return formatAsMebibyte(BigInteger.valueOf(numberOfBytes), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsMebibyte(@NotNull final BigInteger numberOfBytes, @NotNull final String pattern) {
    return formatAsMebibyte(numberOfBytes, new DecimalFormat(pattern));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsMebibyte(
      @NotNull final Long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsMebibyte(numberOfBytes.longValue(), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsMebibyte(
      final long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsMebibyte(BigInteger.valueOf(numberOfBytes), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsMebibyte(
      @NotNull final BigInteger numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsMebibyte(numberOfBytes, asFormat(pattern, locale));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsMebibyte(@NotNull final Long numberOfBytes, @NotNull final Format format) {
    return formatAsMebibyte(numberOfBytes.longValue(), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsMebibyte(final long numberOfBytes, @NotNull final Format format) {
    return formatAsMebibyte(BigInteger.valueOf(numberOfBytes), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsMebibyte(@NotNull final BigInteger numberOfBytes, @NotNull final Format format) {
    return Mebibyte.valueOf(numberOfBytes).toString(format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsGibibyte(@NotNull final Long numberOfBytes) {
    return formatAsGibibyte(numberOfBytes.longValue());
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsGibibyte(final long numberOfBytes) {
    return formatAsGibibyte(BigInteger.valueOf(numberOfBytes));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsGibibyte(@NotNull final BigInteger numberOfBytes) {
    return formatAsGibibyte(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsGibibyte(@NotNull final Long numberOfBytes, @NotNull final String pattern) {
    return formatAsGibibyte(numberOfBytes.longValue(), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsGibibyte(final long numberOfBytes, @NotNull final String pattern) {
    return formatAsGibibyte(BigInteger.valueOf(numberOfBytes), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsGibibyte(@NotNull final BigInteger numberOfBytes, @NotNull final String pattern) {
    return formatAsGibibyte(numberOfBytes, new DecimalFormat(pattern));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsGibibyte(
      @NotNull final Long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsGibibyte(numberOfBytes.longValue(), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsGibibyte(
      final long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsGibibyte(BigInteger.valueOf(numberOfBytes), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsGibibyte(
      @NotNull final BigInteger numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsGibibyte(numberOfBytes, asFormat(pattern, locale));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsGibibyte(@NotNull final Long numberOfBytes, @NotNull final Format format) {
    return formatAsGibibyte(numberOfBytes.longValue(), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsGibibyte(final long numberOfBytes, @NotNull final Format format) {
    return formatAsGibibyte(BigInteger.valueOf(numberOfBytes), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsGibibyte(@NotNull final BigInteger numberOfBytes, @NotNull final Format format) {
    return Gibibyte.valueOf(numberOfBytes).toString(format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsTebibyte(@NotNull final Long numberOfBytes) {
    return formatAsTebibyte(numberOfBytes.longValue());
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsTebibyte(final long numberOfBytes) {
    return formatAsTebibyte(BigInteger.valueOf(numberOfBytes));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsTebibyte(@NotNull final BigInteger numberOfBytes) {
    return formatAsTebibyte(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsTebibyte(@NotNull final Long numberOfBytes, @NotNull final String pattern) {
    return formatAsTebibyte(numberOfBytes.longValue(), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsTebibyte(final long numberOfBytes, @NotNull final String pattern) {
    return formatAsTebibyte(BigInteger.valueOf(numberOfBytes), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsTebibyte(@NotNull final BigInteger numberOfBytes, @NotNull final String pattern) {
    return formatAsTebibyte(numberOfBytes, new DecimalFormat(pattern));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsTebibyte(
      @NotNull final Long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsTebibyte(numberOfBytes.longValue(), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsTebibyte(
      final long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsTebibyte(BigInteger.valueOf(numberOfBytes), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsTebibyte(
      @NotNull final BigInteger numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsTebibyte(numberOfBytes, asFormat(pattern, locale));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsTebibyte(@NotNull final Long numberOfBytes, @NotNull final Format format) {
    return formatAsTebibyte(numberOfBytes.longValue(), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsTebibyte(final long numberOfBytes, @NotNull final Format format) {
    return formatAsTebibyte(BigInteger.valueOf(numberOfBytes), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsTebibyte(@NotNull final BigInteger numberOfBytes, @NotNull final Format format) {
    return Tebibyte.valueOf(numberOfBytes).toString(format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsPebibyte(@NotNull final Long numberOfBytes) {
    return formatAsPebibyte(numberOfBytes.longValue());
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsPebibyte(final long numberOfBytes) {
    return formatAsPebibyte(BigInteger.valueOf(numberOfBytes));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsPebibyte(@NotNull final BigInteger numberOfBytes) {
    return formatAsPebibyte(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsPebibyte(@NotNull final Long numberOfBytes, @NotNull final String pattern) {
    return formatAsPebibyte(numberOfBytes.longValue(), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsPebibyte(final long numberOfBytes, @NotNull final String pattern) {
    return formatAsPebibyte(BigInteger.valueOf(numberOfBytes), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsPebibyte(@NotNull final BigInteger numberOfBytes, @NotNull final String pattern) {
    return formatAsPebibyte(numberOfBytes, new DecimalFormat(pattern));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsPebibyte(
      @NotNull final Long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsPebibyte(numberOfBytes.longValue(), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsPebibyte(
      final long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsPebibyte(BigInteger.valueOf(numberOfBytes), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsPebibyte(
      @NotNull final BigInteger numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsPebibyte(numberOfBytes, asFormat(pattern, locale));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsPebibyte(@NotNull final Long numberOfBytes, @NotNull final Format format) {
    return formatAsPebibyte(numberOfBytes.longValue(), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsPebibyte(final long numberOfBytes, @NotNull final Format format) {
    return formatAsPebibyte(BigInteger.valueOf(numberOfBytes), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsPebibyte(@NotNull final BigInteger numberOfBytes, @NotNull final Format format) {
    return Pebibyte.valueOf(numberOfBytes).toString(format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsExbibyte(@NotNull final Long numberOfBytes) {
    return formatAsExbibyte(numberOfBytes.longValue());
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsExbibyte(final long numberOfBytes) {
    return formatAsExbibyte(BigInteger.valueOf(numberOfBytes));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsExbibyte(@NotNull final BigInteger numberOfBytes) {
    return formatAsExbibyte(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsExbibyte(@NotNull final Long numberOfBytes, @NotNull final String pattern) {
    return formatAsExbibyte(numberOfBytes.longValue(), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsExbibyte(final long numberOfBytes, @NotNull final String pattern) {
    return formatAsExbibyte(BigInteger.valueOf(numberOfBytes), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsExbibyte(@NotNull final BigInteger numberOfBytes, @NotNull final String pattern) {
    return formatAsExbibyte(numberOfBytes, new DecimalFormat(pattern));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsExbibyte(
      @NotNull final Long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsExbibyte(numberOfBytes.longValue(), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsExbibyte(
      final long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsExbibyte(BigInteger.valueOf(numberOfBytes), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsExbibyte(
      @NotNull final BigInteger numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsExbibyte(numberOfBytes, asFormat(pattern, locale));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsExbibyte(@NotNull final Long numberOfBytes, @NotNull final Format format) {
    return formatAsExbibyte(numberOfBytes.longValue(), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsExbibyte(final long numberOfBytes, @NotNull final Format format) {
    return formatAsExbibyte(BigInteger.valueOf(numberOfBytes), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsExbibyte(@NotNull final BigInteger numberOfBytes, @NotNull final Format format) {
    return Exbibyte.valueOf(numberOfBytes).toString(format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsZebibyte(@NotNull final Long numberOfBytes) {
    return formatAsZebibyte(numberOfBytes.longValue());
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsZebibyte(final long numberOfBytes) {
    return formatAsZebibyte(BigInteger.valueOf(numberOfBytes));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsZebibyte(@NotNull final BigInteger numberOfBytes) {
    return formatAsZebibyte(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsZebibyte(@NotNull final Long numberOfBytes, @NotNull final String pattern) {
    return formatAsZebibyte(numberOfBytes.longValue(), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsZebibyte(final long numberOfBytes, @NotNull final String pattern) {
    return formatAsZebibyte(BigInteger.valueOf(numberOfBytes), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsZebibyte(@NotNull final BigInteger numberOfBytes, @NotNull final String pattern) {
    return formatAsZebibyte(numberOfBytes, new DecimalFormat(pattern));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsZebibyte(
      @NotNull final Long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsZebibyte(numberOfBytes.longValue(), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsZebibyte(
      final long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsZebibyte(BigInteger.valueOf(numberOfBytes), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsZebibyte(
      @NotNull final BigInteger numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsZebibyte(numberOfBytes, asFormat(pattern, locale));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsZebibyte(@NotNull final Long numberOfBytes, @NotNull final Format format) {
    return formatAsZebibyte(numberOfBytes.longValue(), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsZebibyte(final long numberOfBytes, @NotNull final Format format) {
    return formatAsZebibyte(BigInteger.valueOf(numberOfBytes), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsZebibyte(@NotNull final BigInteger numberOfBytes, @NotNull final Format format) {
    return Zebibyte.valueOf(numberOfBytes).toString(format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsYobibyte(@NotNull final Long numberOfBytes) {
    return formatAsYobibyte(numberOfBytes.longValue());
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsYobibyte(final long numberOfBytes) {
    return formatAsYobibyte(BigInteger.valueOf(numberOfBytes));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsYobibyte(@NotNull final BigInteger numberOfBytes) {
    return formatAsYobibyte(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsYobibyte(@NotNull final Long numberOfBytes, @NotNull final String pattern) {
    return formatAsYobibyte(numberOfBytes.longValue(), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsYobibyte(final long numberOfBytes, @NotNull final String pattern) {
    return formatAsYobibyte(BigInteger.valueOf(numberOfBytes), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsYobibyte(@NotNull final BigInteger numberOfBytes, @NotNull final String pattern) {
    return formatAsYobibyte(numberOfBytes, new DecimalFormat(pattern));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsYobibyte(
      @NotNull final Long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsYobibyte(numberOfBytes.longValue(), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsYobibyte(
      final long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsYobibyte(BigInteger.valueOf(numberOfBytes), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsYobibyte(
      @NotNull final BigInteger numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsYobibyte(numberOfBytes, asFormat(pattern, locale));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsYobibyte(@NotNull final Long numberOfBytes, @NotNull final Format format) {
    return formatAsYobibyte(numberOfBytes.longValue(), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsYobibyte(final long numberOfBytes, @NotNull final Format format) {
    return formatAsYobibyte(BigInteger.valueOf(numberOfBytes), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsYobibyte(@NotNull final BigInteger numberOfBytes, @NotNull final Format format) {
    return Yobibyte.valueOf(numberOfBytes).toString(format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsDecimalUnit(@NotNull final Long numberOfBytes) {
    return formatAsDecimalUnit(numberOfBytes.longValue());
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsDecimalUnit(final long numberOfBytes) {
    return formatAsDecimalUnit(BigInteger.valueOf(numberOfBytes));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsDecimalUnit(@NotNull final BigInteger numberOfBytes) {
    return formatAsDecimalUnit(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsDecimalUnit(@NotNull final Long numberOfBytes, @NotNull final String pattern) {
    return formatAsDecimalUnit(numberOfBytes.longValue(), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsDecimalUnit(final long numberOfBytes, @NotNull final String pattern) {
    return formatAsDecimalUnit(BigInteger.valueOf(numberOfBytes), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsDecimalUnit(@NotNull final BigInteger numberOfBytes, @NotNull final String pattern) {
    return formatAsDecimalUnit(numberOfBytes, new DecimalFormat(pattern));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsDecimalUnit(
      @NotNull final Long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsDecimalUnit(numberOfBytes.longValue(), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsDecimalUnit(
      final long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsDecimalUnit(BigInteger.valueOf(numberOfBytes), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsDecimalUnit(
      @NotNull final BigInteger numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsDecimalUnit(numberOfBytes, asFormat(pattern, locale));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsDecimalUnit(@NotNull final Long numberOfBytes, @NotNull final Format format) {
    return formatAsDecimalUnit(numberOfBytes.longValue(), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsDecimalUnit(final long numberOfBytes, @NotNull final Format format) {
    return formatAsDecimalUnit(BigInteger.valueOf(numberOfBytes), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsDecimalUnit(@NotNull final BigInteger numberOfBytes, @NotNull final Format format) {
    return decimalValueOf(numberOfBytes).toString(format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsKilobyte(@NotNull final Long numberOfBytes) {
    return formatAsKilobyte(numberOfBytes.longValue());
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsKilobyte(final long numberOfBytes) {
    return formatAsKilobyte(BigInteger.valueOf(numberOfBytes));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsKilobyte(@NotNull final BigInteger numberOfBytes) {
    return formatAsKilobyte(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsKilobyte(@NotNull final Long numberOfBytes, @NotNull final String pattern) {
    return formatAsKilobyte(numberOfBytes.longValue(), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsKilobyte(final long numberOfBytes, @NotNull final String pattern) {
    return formatAsKilobyte(BigInteger.valueOf(numberOfBytes), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsKilobyte(@NotNull final BigInteger numberOfBytes, @NotNull final String pattern) {
    return formatAsKilobyte(numberOfBytes, new DecimalFormat(pattern));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsKilobyte(
      @NotNull final Long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsKilobyte(numberOfBytes.longValue(), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsKilobyte(
      final long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsKilobyte(BigInteger.valueOf(numberOfBytes), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsKilobyte(
      @NotNull final BigInteger numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsKilobyte(numberOfBytes, asFormat(pattern, locale));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsKilobyte(@NotNull final Long numberOfBytes, @NotNull final Format format) {
    return formatAsKilobyte(numberOfBytes.longValue(), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsKilobyte(final long numberOfBytes, @NotNull final Format format) {
    return formatAsKilobyte(BigInteger.valueOf(numberOfBytes), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsKilobyte(@NotNull final BigInteger numberOfBytes, @NotNull final Format format) {
    return Kilobyte.valueOf(numberOfBytes).toString(format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsMegabyte(@NotNull final Long numberOfBytes) {
    return formatAsMegabyte(numberOfBytes.longValue());
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsMegabyte(final long numberOfBytes) {
    return formatAsMegabyte(BigInteger.valueOf(numberOfBytes));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsMegabyte(@NotNull final BigInteger numberOfBytes) {
    return formatAsMegabyte(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsMegabyte(@NotNull final Long numberOfBytes, @NotNull final String pattern) {
    return formatAsMegabyte(numberOfBytes.longValue(), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsMegabyte(final long numberOfBytes, @NotNull final String pattern) {
    return formatAsMegabyte(BigInteger.valueOf(numberOfBytes), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsMegabyte(@NotNull final BigInteger numberOfBytes, @NotNull final String pattern) {
    return formatAsMegabyte(numberOfBytes, new DecimalFormat(pattern));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsMegabyte(
      @NotNull final Long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsMegabyte(numberOfBytes.longValue(), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsMegabyte(
      final long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsMegabyte(BigInteger.valueOf(numberOfBytes), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsMegabyte(
      @NotNull final BigInteger numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsMegabyte(numberOfBytes, asFormat(pattern, locale));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsMegabyte(@NotNull final Long numberOfBytes, @NotNull final Format format) {
    return formatAsMegabyte(numberOfBytes.longValue(), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsMegabyte(final long numberOfBytes, @NotNull final Format format) {
    return formatAsMegabyte(BigInteger.valueOf(numberOfBytes), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsMegabyte(@NotNull final BigInteger numberOfBytes, @NotNull final Format format) {
    return Megabyte.valueOf(numberOfBytes).toString(format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsGigabyte(@NotNull final Long numberOfBytes) {
    return formatAsGigabyte(numberOfBytes.longValue());
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsGigabyte(final long numberOfBytes) {
    return formatAsGigabyte(BigInteger.valueOf(numberOfBytes));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsGigabyte(@NotNull final BigInteger numberOfBytes) {
    return formatAsGigabyte(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsGigabyte(@NotNull final Long numberOfBytes, @NotNull final String pattern) {
    return formatAsGigabyte(numberOfBytes.longValue(), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsGigabyte(final long numberOfBytes, @NotNull final String pattern) {
    return formatAsGigabyte(BigInteger.valueOf(numberOfBytes), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsGigabyte(@NotNull final BigInteger numberOfBytes, @NotNull final String pattern) {
    return formatAsGigabyte(numberOfBytes, new DecimalFormat(pattern));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsGigabyte(
      @NotNull final Long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsGigabyte(numberOfBytes.longValue(), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsGigabyte(
      final long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsGigabyte(BigInteger.valueOf(numberOfBytes), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsGigabyte(
      @NotNull final BigInteger numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsGigabyte(numberOfBytes, asFormat(pattern, locale));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsGigabyte(@NotNull final Long numberOfBytes, @NotNull final Format format) {
    return formatAsGigabyte(numberOfBytes.longValue(), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsGigabyte(final long numberOfBytes, @NotNull final Format format) {
    return formatAsGigabyte(BigInteger.valueOf(numberOfBytes), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsGigabyte(@NotNull final BigInteger numberOfBytes, @NotNull final Format format) {
    return Gigabyte.valueOf(numberOfBytes).toString(format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsTerabyte(@NotNull final Long numberOfBytes) {
    return formatAsTerabyte(numberOfBytes.longValue());
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsTerabyte(final long numberOfBytes) {
    return formatAsTerabyte(BigInteger.valueOf(numberOfBytes));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsTerabyte(@NotNull final BigInteger numberOfBytes) {
    return formatAsTerabyte(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsTerabyte(@NotNull final Long numberOfBytes, @NotNull final String pattern) {
    return formatAsTerabyte(numberOfBytes.longValue(), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsTerabyte(final long numberOfBytes, @NotNull final String pattern) {
    return formatAsTerabyte(BigInteger.valueOf(numberOfBytes), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsTerabyte(@NotNull final BigInteger numberOfBytes, @NotNull final String pattern) {
    return formatAsTerabyte(numberOfBytes, new DecimalFormat(pattern));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsTerabyte(
      @NotNull final Long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsTerabyte(numberOfBytes.longValue(), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsTerabyte(
      final long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsTerabyte(BigInteger.valueOf(numberOfBytes), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsTerabyte(
      @NotNull final BigInteger numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsTerabyte(numberOfBytes, asFormat(pattern, locale));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsTerabyte(@NotNull final Long numberOfBytes, @NotNull final Format format) {
    return formatAsTerabyte(numberOfBytes.longValue(), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsTerabyte(final long numberOfBytes, @NotNull final Format format) {
    return formatAsTerabyte(BigInteger.valueOf(numberOfBytes), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsTerabyte(@NotNull final BigInteger numberOfBytes, @NotNull final Format format) {
    return Terabyte.valueOf(numberOfBytes).toString(format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsPetabyte(@NotNull final Long numberOfBytes) {
    return formatAsPetabyte(numberOfBytes.longValue());
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsPetabyte(final long numberOfBytes) {
    return formatAsPetabyte(BigInteger.valueOf(numberOfBytes));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsPetabyte(@NotNull final BigInteger numberOfBytes) {
    return formatAsPetabyte(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsPetabyte(@NotNull final Long numberOfBytes, @NotNull final String pattern) {
    return formatAsPetabyte(numberOfBytes.longValue(), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsPetabyte(final long numberOfBytes, @NotNull final String pattern) {
    return formatAsPetabyte(BigInteger.valueOf(numberOfBytes), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsPetabyte(@NotNull final BigInteger numberOfBytes, @NotNull final String pattern) {
    return formatAsPetabyte(numberOfBytes, new DecimalFormat(pattern));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsPetabyte(
      @NotNull final Long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsPetabyte(numberOfBytes.longValue(), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsPetabyte(
      final long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsPetabyte(BigInteger.valueOf(numberOfBytes), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsPetabyte(
      @NotNull final BigInteger numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsPetabyte(numberOfBytes, asFormat(pattern, locale));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsPetabyte(@NotNull final Long numberOfBytes, @NotNull final Format format) {
    return formatAsPetabyte(numberOfBytes.longValue(), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsPetabyte(final long numberOfBytes, @NotNull final Format format) {
    return formatAsPetabyte(BigInteger.valueOf(numberOfBytes), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsPetabyte(@NotNull final BigInteger numberOfBytes, @NotNull final Format format) {
    return Petabyte.valueOf(numberOfBytes).toString(format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsExabyte(@NotNull final Long numberOfBytes) {
    return formatAsExabyte(numberOfBytes.longValue());
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsExabyte(final long numberOfBytes) {
    return formatAsExabyte(BigInteger.valueOf(numberOfBytes));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsExabyte(@NotNull final BigInteger numberOfBytes) {
    return formatAsExabyte(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsExabyte(@NotNull final Long numberOfBytes, @NotNull final String pattern) {
    return formatAsExabyte(numberOfBytes.longValue(), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsExabyte(final long numberOfBytes, @NotNull final String pattern) {
    return formatAsExabyte(BigInteger.valueOf(numberOfBytes), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsExabyte(@NotNull final BigInteger numberOfBytes, @NotNull final String pattern) {
    return formatAsExabyte(numberOfBytes, new DecimalFormat(pattern));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsExabyte(
      @NotNull final Long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsExabyte(numberOfBytes.longValue(), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsExabyte(
      final long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsExabyte(BigInteger.valueOf(numberOfBytes), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsExabyte(
      @NotNull final BigInteger numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsExabyte(numberOfBytes, asFormat(pattern, locale));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsExabyte(@NotNull final Long numberOfBytes, @NotNull final Format format) {
    return formatAsExabyte(numberOfBytes.longValue(), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsExabyte(final long numberOfBytes, @NotNull final Format format) {
    return formatAsExabyte(BigInteger.valueOf(numberOfBytes), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsExabyte(@NotNull final BigInteger numberOfBytes, @NotNull final Format format) {
    return Exabyte.valueOf(numberOfBytes).toString(format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsZettabyte(@NotNull final Long numberOfBytes) {
    return formatAsZettabyte(numberOfBytes.longValue());
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsZettabyte(final long numberOfBytes) {
    return formatAsZettabyte(BigInteger.valueOf(numberOfBytes));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsZettabyte(@NotNull final BigInteger numberOfBytes) {
    return formatAsZettabyte(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsZettabyte(@NotNull final Long numberOfBytes, @NotNull final String pattern) {
    return formatAsZettabyte(numberOfBytes.longValue(), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsZettabyte(final long numberOfBytes, @NotNull final String pattern) {
    return formatAsZettabyte(BigInteger.valueOf(numberOfBytes), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsZettabyte(@NotNull final BigInteger numberOfBytes, @NotNull final String pattern) {
    return formatAsZettabyte(numberOfBytes, new DecimalFormat(pattern));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsZettabyte(
      @NotNull final Long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsZettabyte(numberOfBytes.longValue(), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsZettabyte(
      final long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsZettabyte(BigInteger.valueOf(numberOfBytes), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsZettabyte(
      @NotNull final BigInteger numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsZettabyte(numberOfBytes, asFormat(pattern, locale));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsZettabyte(@NotNull final Long numberOfBytes, @NotNull final Format format) {
    return formatAsZettabyte(numberOfBytes.longValue(), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsZettabyte(final long numberOfBytes, @NotNull final Format format) {
    return formatAsZettabyte(BigInteger.valueOf(numberOfBytes), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsZettabyte(@NotNull final BigInteger numberOfBytes, @NotNull final Format format) {
    return Zettabyte.valueOf(numberOfBytes).toString(format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsYottabyte(@NotNull final Long numberOfBytes) {
    return formatAsYottabyte(numberOfBytes.longValue());
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsYottabyte(final long numberOfBytes) {
    return formatAsYottabyte(BigInteger.valueOf(numberOfBytes));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsYottabyte(@NotNull final BigInteger numberOfBytes) {
    return formatAsYottabyte(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsYottabyte(@NotNull final Long numberOfBytes, @NotNull final String pattern) {
    return formatAsYottabyte(numberOfBytes.longValue(), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsYottabyte(final long numberOfBytes, @NotNull final String pattern) {
    return formatAsYottabyte(BigInteger.valueOf(numberOfBytes), pattern);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsYottabyte(
      @NotNull final BigInteger numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsYottabyte(numberOfBytes, asFormat(pattern, locale));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsYottabyte(
      @NotNull final Long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsYottabyte(numberOfBytes.longValue(), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @param locale        The locale to use.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsYottabyte(
      final long numberOfBytes,
      @NotNull final String pattern,
      @NotNull final Locale locale) {
    return formatAsYottabyte(BigInteger.valueOf(numberOfBytes), pattern, locale);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param pattern       The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsYottabyte(@NotNull final BigInteger numberOfBytes, @NotNull final String pattern) {
    return formatAsYottabyte(numberOfBytes, new DecimalFormat(pattern));
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsYottabyte(@NotNull final Long numberOfBytes, @NotNull final Format format) {
    return formatAsYottabyte(numberOfBytes.longValue(), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsYottabyte(final long numberOfBytes, @NotNull final Format format) {
    return formatAsYottabyte(BigInteger.valueOf(numberOfBytes), format);
  }

  /**
   * @param numberOfBytes The amount of bytes to format.
   * @param format        The formatting pattern to apply.
   * @return The formatted bytes using the default pattern.
   */
  @NotNull
  @CheckReturnValue
  public static String formatAsYottabyte(@NotNull final BigInteger numberOfBytes, @NotNull final Format format) {
    return Yottabyte.valueOf(numberOfBytes).toString(format);
  }

  /**
   * @param numberOfBytes The amount of bytes to create.
   * @return A new unit representing the given amount of bytes.
   */
  @NotNull
  @CheckReturnValue
  public static Byte bytes(@NotNull final Long numberOfBytes) {
    return bytes(numberOfBytes.longValue());
  }

  /**
   * @param numberOfBytes The amount of bytes to create.
   * @return A new unit representing the given amount of bytes.
   */
  @NotNull
  @CheckReturnValue
  public static Byte bytes(final long numberOfBytes) {
    return bytes(BigInteger.valueOf(numberOfBytes));
  }

  /**
   * @param numberOfBytes The amount of bytes to create.
   * @return A new unit representing the given amount of bytes.
   */
  @NotNull
  @CheckReturnValue
  public static Byte bytes(@NotNull final BigInteger numberOfBytes) {
    return new Byte(numberOfBytes);
  }

  /**
   * @param numberOfKibibytes The amount of kibibytes to create.
   * @return A new unit representing the given amount of kibibytes.
   */
  @NotNull
  @CheckReturnValue
  public static Kibibyte kibibyte(@NotNull final Long numberOfKibibytes) {
    return kibibyte(numberOfKibibytes.longValue());
  }

  /**
   * @param numberOfKibibytes The amount of kibibytes to create.
   * @return A new unit representing the given amount of kibibytes.
   */
  @NotNull
  @CheckReturnValue
  public static Kibibyte kibibyte(final long numberOfKibibytes) {
    return kibibyte(BigInteger.valueOf(numberOfKibibytes));
  }

  /**
   * @param numberOfKibibytes The amount of kibibytes to create.
   * @return A new unit representing the given amount of kibibytes.
   */
  @NotNull
  @CheckReturnValue
  public static Kibibyte kibibyte(@NotNull final BigInteger numberOfKibibytes) {
    return new Kibibyte(StorageUnit.BYTES_IN_A_KIBIBYTE.multiply(numberOfKibibytes));
  }

  /**
   * @param numberOfMebibytes The amount of mebibytes to create.
   * @return A new unit representing the given amount of mebibytes.
   */
  @NotNull
  @CheckReturnValue
  public static Mebibyte mebibyte(@NotNull final Long numberOfMebibytes) {
    return mebibyte(numberOfMebibytes.longValue());
  }

  /**
   * @param numberOfMebibytes The amount of mebibytes to create.
   * @return A new unit representing the given amount of mebibytes.
   */
  @NotNull
  @CheckReturnValue
  public static Mebibyte mebibyte(final long numberOfMebibytes) {
    return mebibyte(BigInteger.valueOf(numberOfMebibytes));
  }

  /**
   * @param numberOfMebibytes The amount of mebibytes to create.
   * @return A new unit representing the given amount of mebibytes.
   */
  @NotNull
  @CheckReturnValue
  public static Mebibyte mebibyte(@NotNull final BigInteger numberOfMebibytes) {
    return new Mebibyte(StorageUnit.BYTES_IN_A_MEBIBYTE.multiply(numberOfMebibytes));
  }

  /**
   * @param numberOfGibibytes The amount of gibibytes to create.
   * @return A new unit representing the given amount of gibibytes.
   */
  @NotNull
  @CheckReturnValue
  public static Gibibyte gibibyte(@NotNull final Long numberOfGibibytes) {
    return gibibyte(numberOfGibibytes.longValue());
  }

  /**
   * @param numberOfGibibytes The amount of gibibytes to create.
   * @return A new unit representing the given amount of gibibytes.
   */
  @NotNull
  @CheckReturnValue
  public static Gibibyte gibibyte(final long numberOfGibibytes) {
    return gibibyte(BigInteger.valueOf(numberOfGibibytes));
  }

  /**
   * @param numberOfGibibytes The amount of gibibytes to create.
   * @return A new unit representing the given amount of gibibytes.
   */
  @NotNull
  @CheckReturnValue
  public static Gibibyte gibibyte(@NotNull final BigInteger numberOfGibibytes) {
    return new Gibibyte(StorageUnit.BYTES_IN_A_GIBIBYTE.multiply(numberOfGibibytes));
  }

  /**
   * @param numberOfTebibytes The amount of tebibytes to create.
   * @return A new unit representing the given amount of tebibytes.
   */
  @NotNull
  @CheckReturnValue
  public static Tebibyte tebibyte(@NotNull final Long numberOfTebibytes) {
    return tebibyte(numberOfTebibytes.longValue());
  }

  /**
   * @param numberOfTebibytes The amount of tebibytes to create.
   * @return A new unit representing the given amount of tebibytes.
   */
  @NotNull
  @CheckReturnValue
  public static Tebibyte tebibyte(final long numberOfTebibytes) {
    return tebibyte(BigInteger.valueOf(numberOfTebibytes));
  }

  /**
   * @param numberOfTebibytes The amount of tebibytes to create.
   * @return A new unit representing the given amount of tebibytes.
   */
  @NotNull
  @CheckReturnValue
  public static Tebibyte tebibyte(@NotNull final BigInteger numberOfTebibytes) {
    return new Tebibyte(StorageUnit.BYTES_IN_A_TEBIBYTE.multiply(numberOfTebibytes));
  }

  /**
   * @param numberOfPebibytes The amount of pebibytes to create.
   * @return A new unit representing the given amount of pebibytes.
   */
  @NotNull
  @CheckReturnValue
  public static Pebibyte pebibyte(@NotNull final Long numberOfPebibytes) {
    return pebibyte(numberOfPebibytes.longValue());
  }

  /**
   * @param numberOfPebibytes The amount of pebibytes to create.
   * @return A new unit representing the given amount of pebibytes.
   */
  @NotNull
  @CheckReturnValue
  public static Pebibyte pebibyte(final long numberOfPebibytes) {
    return pebibyte(BigInteger.valueOf(numberOfPebibytes));
  }

  /**
   * @param numberOfPebibytes The amount of pebibytes to create.
   * @return A new unit representing the given amount of pebibytes.
   */
  @NotNull
  @CheckReturnValue
  public static Pebibyte pebibyte(@NotNull final BigInteger numberOfPebibytes) {
    return new Pebibyte(StorageUnit.BYTES_IN_A_PEBIBYTE.multiply(numberOfPebibytes));
  }

  /**
   * @param numberOfExbibytes The amount of exbibytes to create.
   * @return A new unit representing the given amount of exbibytes.
   */
  @NotNull
  @CheckReturnValue
  public static Exbibyte exbibyte(@NotNull final Long numberOfExbibytes) {
    return exbibyte(numberOfExbibytes.longValue());
  }

  /**
   * @param numberOfExbibytes The amount of exbibytes to create.
   * @return A new unit representing the given amount of exbibytes.
   */
  @NotNull
  @CheckReturnValue
  public static Exbibyte exbibyte(final long numberOfExbibytes) {
    return exbibyte(BigInteger.valueOf(numberOfExbibytes));
  }

  /**
   * @param numberOfExbibytes The amount of exbibytes to create.
   * @return A new unit representing the given amount of exbibytes.
   */
  @NotNull
  @CheckReturnValue
  public static Exbibyte exbibyte(@NotNull final BigInteger numberOfExbibytes) {
    return new Exbibyte(StorageUnit.BYTES_IN_A_EXBIBYTE.multiply(numberOfExbibytes));
  }

  /**
   * @param numberOfZebibytes The amount of zebibytes to create.
   * @return A new unit representing the given amount of zebibytes.
   */
  @NotNull
  @CheckReturnValue
  public static Zebibyte zebibyte(@NotNull final Long numberOfZebibytes) {
    return zebibyte(numberOfZebibytes.longValue());
  }

  /**
   * @param numberOfZebibytes The amount of zebibytes to create.
   * @return A new unit representing the given amount of zebibytes.
   */
  @NotNull
  @CheckReturnValue
  public static Zebibyte zebibyte(final long numberOfZebibytes) {
    return zebibyte(BigInteger.valueOf(numberOfZebibytes));
  }

  /**
   * @param numberOfZebibytes The amount of zebibytes to create.
   * @return A new unit representing the given amount of zebibytes.
   */
  @NotNull
  @CheckReturnValue
  public static Zebibyte zebibyte(@NotNull final BigInteger numberOfZebibytes) {
    return new Zebibyte(StorageUnit.BYTES_IN_A_ZEBIBYTE.multiply(numberOfZebibytes));
  }

  /**
   * @param numberOfYobibytes The amount of yobibytes to create.
   * @return A new unit representing the given amount of yobibytes.
   */
  @NotNull
  @CheckReturnValue
  public static Yobibyte yobibyte(@NotNull final Long numberOfYobibytes) {
    return yobibyte(numberOfYobibytes.longValue());
  }

  /**
   * @param numberOfYobibytes The amount of yobibytes to create.
   * @return A new unit representing the given amount of yobibytes.
   */
  @NotNull
  @CheckReturnValue
  public static Yobibyte yobibyte(final long numberOfYobibytes) {
    return yobibyte(BigInteger.valueOf(numberOfYobibytes));
  }

  /**
   * @param numberOfYobibytes The amount of yobibytes to create.
   * @return A new unit representing the given amount of yobibytes.
   */
  @NotNull
  @CheckReturnValue
  public static Yobibyte yobibyte(@NotNull final BigInteger numberOfYobibytes) {
    return new Yobibyte(StorageUnit.BYTES_IN_A_YOBIBYTE.multiply(numberOfYobibytes));
  }

  /**
   * @param numberOfKilobytes The number of kilobytes to create.
   * @return A new unit representing the given amount of kilobytes.
   */
  @NotNull
  @CheckReturnValue
  public static Kilobyte kilobyte(@NotNull final Long numberOfKilobytes) {
    return kilobyte(numberOfKilobytes.longValue());
  }

  /**
   * @param numberOfKilobytes The number of kilobytes to create.
   * @return A new unit representing the given amount of kilobytes.
   */
  @NotNull
  @CheckReturnValue
  public static Kilobyte kilobyte(final long numberOfKilobytes) {
    return kilobyte(BigInteger.valueOf(numberOfKilobytes));
  }

  /**
   * @param numberOfKilobytes The number of kilobytes to create.
   * @return A new unit representing the given amount of kilobytes.
   */
  @NotNull
  @CheckReturnValue
  public static Kilobyte kilobyte(@NotNull final BigInteger numberOfKilobytes) {
    return new Kilobyte(StorageUnit.BYTES_IN_A_KILOBYTE.multiply(numberOfKilobytes));
  }

  /**
   * @param numberOfMegabytes The number of megabytes to create.
   * @return A new unit representing the given amount of megabytes.
   */
  @NotNull
  @CheckReturnValue
  public static Megabyte megabyte(@NotNull final Long numberOfMegabytes) {
    return megabyte(numberOfMegabytes.longValue());
  }

  /**
   * @param numberOfMegabytes The number of megabytes to create.
   * @return A new unit representing the given amount of megabytes.
   */
  @NotNull
  @CheckReturnValue
  public static Megabyte megabyte(final long numberOfMegabytes) {
    return megabyte(BigInteger.valueOf(numberOfMegabytes));
  }

  /**
   * @param numberOfMegabytes The number of megabytes to create.
   * @return A new unit representing the given amount of megabytes.
   */
  @NotNull
  @CheckReturnValue
  public static Megabyte megabyte(@NotNull final BigInteger numberOfMegabytes) {
    return new Megabyte(StorageUnit.BYTES_IN_A_MEGABYTE.multiply(numberOfMegabytes));
  }

  /**
   * @param numberOfGigabytes The number of gigabytes to create.
   * @return A new unit representing the given amount of gigabytes.
   */
  @NotNull
  @CheckReturnValue
  public static Gigabyte gigabyte(@NotNull final Long numberOfGigabytes) {
    return gigabyte(numberOfGigabytes.longValue());
  }

  /**
   * @param numberOfGigabytes The number of gigabytes to create.
   * @return A new unit representing the given amount of gigabytes.
   */
  @NotNull
  @CheckReturnValue
  public static Gigabyte gigabyte(final long numberOfGigabytes) {
    return gigabyte(BigInteger.valueOf(numberOfGigabytes));
  }

  /**
   * @param numberOfGigabytes The number of gigabytes to create.
   * @return A new unit representing the given amount of gigabytes.
   */
  @NotNull
  @CheckReturnValue
  public static Gigabyte gigabyte(@NotNull final BigInteger numberOfGigabytes) {
    return new Gigabyte(StorageUnit.BYTES_IN_A_GIGABYTE.multiply(numberOfGigabytes));
  }

  /**
   * @param numberOfTerabytes The number of terabytes to create.
   * @return A new unit representing the given amount of terabytes.
   */
  @NotNull
  @CheckReturnValue
  public static Terabyte terabyte(@NotNull final Long numberOfTerabytes) {
    return terabyte(numberOfTerabytes.longValue());
  }

  /**
   * @param numberOfTerabytes The number of terabytes to create.
   * @return A new unit representing the given amount of terabytes.
   */
  @NotNull
  @CheckReturnValue
  public static Terabyte terabyte(final long numberOfTerabytes) {
    return terabyte(BigInteger.valueOf(numberOfTerabytes));
  }

  /**
   * @param numberOfTerabytes The number of terabytes to create.
   * @return A new unit representing the given amount of terabytes.
   */
  @NotNull
  @CheckReturnValue
  public static Terabyte terabyte(@NotNull final BigInteger numberOfTerabytes) {
    return new Terabyte(StorageUnit.BYTES_IN_A_TERABYTE.multiply(numberOfTerabytes));
  }

  /**
   * @param numberOfPetabytes The number of petabytes to create.
   * @return A new unit representing the given amount of petabytes.
   */
  @NotNull
  @CheckReturnValue
  public static Petabyte petabyte(@NotNull final Long numberOfPetabytes) {
    return petabyte(numberOfPetabytes.longValue());
  }

  /**
   * @param numberOfPetabytes The number of petabytes to create.
   * @return A new unit representing the given amount of petabytes.
   */
  @NotNull
  @CheckReturnValue
  public static Petabyte petabyte(final long numberOfPetabytes) {
    return petabyte(BigInteger.valueOf(numberOfPetabytes));
  }

  /**
   * @param numberOfPetabytes The number of petabytes to create.
   * @return A new unit representing the given amount of petabytes.
   */
  @NotNull
  @CheckReturnValue
  public static Petabyte petabyte(@NotNull final BigInteger numberOfPetabytes) {
    return new Petabyte(StorageUnit.BYTES_IN_A_PETABYTE.multiply(numberOfPetabytes));
  }

  /**
   * @param numberOfExabytes The number of exabytes to create.
   * @return A new unit representing the given amount of exabytes.
   */
  @NotNull
  @CheckReturnValue
  public static Exabyte exabyte(@NotNull final Long numberOfExabytes) {
    return exabyte(numberOfExabytes.longValue());
  }

  /**
   * @param numberOfExabytes The number of exabytes to create.
   * @return A new unit representing the given amount of exabytes.
   */
  @NotNull
  @CheckReturnValue
  public static Exabyte exabyte(final long numberOfExabytes) {
    return exabyte(BigInteger.valueOf(numberOfExabytes));
  }

  /**
   * @param numberOfExabytes The number of exabytes to create.
   * @return A new unit representing the given amount of exabytes.
   */
  @NotNull
  @CheckReturnValue
  public static Exabyte exabyte(@NotNull final BigInteger numberOfExabytes) {
    return new Exabyte(StorageUnit.BYTES_IN_A_EXABYTE.multiply(numberOfExabytes));
  }

  /**
   * @param numberOfZettabytes The number of zettabytes to create.
   * @return A new unit representing the given amount of zettabytes.
   */
  @NotNull
  @CheckReturnValue
  public static Zettabyte zettabyte(@NotNull final Long numberOfZettabytes) {
    return zettabyte(numberOfZettabytes.longValue());
  }

  /**
   * @param numberOfZettabytes The number of zettabytes to create.
   * @return A new unit representing the given amount of zettabytes.
   */
  @NotNull
  @CheckReturnValue
  public static Zettabyte zettabyte(final long numberOfZettabytes) {
    return zettabyte(BigInteger.valueOf(numberOfZettabytes));
  }

  /**
   * @param numberOfZettabytes The number of zettabytes to create.
   * @return A new unit representing the given amount of zettabytes.
   */
  @NotNull
  @CheckReturnValue
  public static Zettabyte zettabyte(@NotNull final BigInteger numberOfZettabytes) {
    return new Zettabyte(StorageUnit.BYTES_IN_A_ZETTABYTE.multiply(numberOfZettabytes));
  }

  /**
   * @param numberOfYottabytes The number of yottabytes to create.
   * @return A new unit representing the given amount of yottabytes.
   */
  @NotNull
  @CheckReturnValue
  public static Yottabyte yottabyte(@NotNull final Long numberOfYottabytes) {
    return yottabyte(numberOfYottabytes.longValue());
  }

  /**
   * @param numberOfYottabytes The number of yottabytes to create.
   * @return A new unit representing the given amount of yottabytes.
   */
  @NotNull
  @CheckReturnValue
  public static Yottabyte yottabyte(final long numberOfYottabytes) {
    return yottabyte(BigInteger.valueOf(numberOfYottabytes));
  }

  /**
   * @param numberOfYottabytes The number of yottabytes to create.
   * @return A new unit representing the given amount of yottabytes.
   */
  @NotNull
  @CheckReturnValue
  public static Yottabyte yottabyte(@NotNull final BigInteger numberOfYottabytes) {
    return new Yottabyte(StorageUnit.BYTES_IN_A_YOTTABYTE.multiply(numberOfYottabytes));
  }

}
