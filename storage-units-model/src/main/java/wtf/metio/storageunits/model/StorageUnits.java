/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.model;

import edu.umd.cs.findbugs.annotations.CheckReturnValue;
import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.Locale;

import static wtf.metio.storageunits.model.FormatUtils.asFormat;

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
    @CheckReturnValue
    public static @NotNull StorageUnit<?> binaryValueOf(final long bytes) {
        return binaryValueOf(BigInteger.valueOf(bytes));
    }

    /**
     * @param bytes The amount to bytes to represent.
     * @return The appropriate binary-prefixed unit for the given amount of bytes.
     */
    @CheckReturnValue
    public static @NotNull StorageUnit<?> binaryValueOf(final @NotNull BigInteger bytes) {
        StorageUnit<?> unit = Byte.valueOf(bytes);
        final @NotNull BigInteger positiveNumberOfBytes = bytes.signum() == -1 ? bytes.negate() : bytes;

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
    @CheckReturnValue
    public static @NotNull StorageUnit<?> decimalValueOf(final long bytes) {
        return decimalValueOf(BigInteger.valueOf(bytes));
    }

    /**
     * @param bytes The amount of bytes to represent.
     * @return The appropriate decimal unit for the given amount of bytes.
     */
    @CheckReturnValue
    public static @NotNull StorageUnit<?> decimalValueOf(final @NotNull BigInteger bytes) {
        StorageUnit<?> unit = Byte.valueOf(bytes);
        final @NotNull BigInteger positiveNumberOfBytes = bytes.signum() == -1 ? bytes.negate() : bytes;

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
    @CheckReturnValue
    public static @NotNull String formatAsByte(final @NotNull Long numberOfBytes) {
        return formatAsByte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsByte(final long numberOfBytes) {
        return formatAsByte(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsByte(final @NotNull BigInteger numberOfBytes) {
        return numberOfBytes + " B";
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsBinaryUnit(final @NotNull Long numberOfBytes) {
        return formatAsBinaryUnit(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsBinaryUnit(final long numberOfBytes) {
        return formatAsBinaryUnit(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsBinaryUnit(final @NotNull BigInteger numberOfBytes) {
        return formatAsBinaryUnit(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsBinaryUnit(final @NotNull Long numberOfBytes, final @NotNull String pattern) {
        return formatAsBinaryUnit(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsBinaryUnit(final long numberOfBytes, final @NotNull String pattern) {
        return formatAsBinaryUnit(BigInteger.valueOf(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsBinaryUnit(final @NotNull BigInteger numberOfBytes, final @NotNull String pattern) {
        return formatAsBinaryUnit(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsBinaryUnit(
            final @NotNull Long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsBinaryUnit(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsBinaryUnit(
            final long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsBinaryUnit(BigInteger.valueOf(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsBinaryUnit(
            final @NotNull BigInteger numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsBinaryUnit(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsBinaryUnit(final @NotNull Long numberOfBytes, final @NotNull Format format) {
        return formatAsBinaryUnit(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsBinaryUnit(final long numberOfBytes, final @NotNull Format format) {
        return formatAsBinaryUnit(BigInteger.valueOf(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsBinaryUnit(final @NotNull BigInteger numberOfBytes, final @NotNull Format format) {
        return binaryValueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsKibibyte(final @NotNull Long numberOfBytes) {
        return formatAsKibibyte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsKibibyte(final long numberOfBytes) {
        return formatAsKibibyte(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsKibibyte(final @NotNull BigInteger numberOfBytes) {
        return formatAsKibibyte(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsKibibyte(final @NotNull Long numberOfBytes, final @NotNull String pattern) {
        return formatAsKibibyte(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsKibibyte(final long numberOfBytes, final @NotNull String pattern) {
        return formatAsKibibyte(BigInteger.valueOf(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsKibibyte(final @NotNull BigInteger numberOfBytes, final @NotNull String pattern) {
        return formatAsKibibyte(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsKibibyte(
            final @NotNull Long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsKibibyte(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsKibibyte(
            final long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsKibibyte(BigInteger.valueOf(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsKibibyte(
            final @NotNull BigInteger numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsKibibyte(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsKibibyte(final @NotNull Long numberOfBytes, final @NotNull Format format) {
        return formatAsKibibyte(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsKibibyte(final long numberOfBytes, final @NotNull Format format) {
        return formatAsKibibyte(BigInteger.valueOf(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsKibibyte(final @NotNull BigInteger numberOfBytes, final @NotNull Format format) {
        return Kibibyte.valueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsMebibyte(final @NotNull Long numberOfBytes) {
        return formatAsMebibyte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsMebibyte(final long numberOfBytes) {
        return formatAsMebibyte(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsMebibyte(final @NotNull BigInteger numberOfBytes) {
        return formatAsMebibyte(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsMebibyte(final @NotNull Long numberOfBytes, final @NotNull String pattern) {
        return formatAsMebibyte(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsMebibyte(final long numberOfBytes, final @NotNull String pattern) {
        return formatAsMebibyte(BigInteger.valueOf(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsMebibyte(final @NotNull BigInteger numberOfBytes, final @NotNull String pattern) {
        return formatAsMebibyte(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsMebibyte(
            final @NotNull Long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsMebibyte(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsMebibyte(
            final long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsMebibyte(BigInteger.valueOf(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsMebibyte(
            final @NotNull BigInteger numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsMebibyte(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsMebibyte(final @NotNull Long numberOfBytes, final @NotNull Format format) {
        return formatAsMebibyte(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsMebibyte(final long numberOfBytes, final @NotNull Format format) {
        return formatAsMebibyte(BigInteger.valueOf(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsMebibyte(final @NotNull BigInteger numberOfBytes, final @NotNull Format format) {
        return Mebibyte.valueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsGibibyte(final @NotNull Long numberOfBytes) {
        return formatAsGibibyte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsGibibyte(final long numberOfBytes) {
        return formatAsGibibyte(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsGibibyte(final @NotNull BigInteger numberOfBytes) {
        return formatAsGibibyte(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsGibibyte(final @NotNull Long numberOfBytes, final @NotNull String pattern) {
        return formatAsGibibyte(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsGibibyte(final long numberOfBytes, final @NotNull String pattern) {
        return formatAsGibibyte(BigInteger.valueOf(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsGibibyte(final @NotNull BigInteger numberOfBytes, final @NotNull String pattern) {
        return formatAsGibibyte(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsGibibyte(
            final @NotNull Long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsGibibyte(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsGibibyte(
            final long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsGibibyte(BigInteger.valueOf(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsGibibyte(
            final @NotNull BigInteger numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsGibibyte(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsGibibyte(final @NotNull Long numberOfBytes, final @NotNull Format format) {
        return formatAsGibibyte(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsGibibyte(final long numberOfBytes, final @NotNull Format format) {
        return formatAsGibibyte(BigInteger.valueOf(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsGibibyte(final @NotNull BigInteger numberOfBytes, final @NotNull Format format) {
        return Gibibyte.valueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsTebibyte(final @NotNull Long numberOfBytes) {
        return formatAsTebibyte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsTebibyte(final long numberOfBytes) {
        return formatAsTebibyte(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsTebibyte(final @NotNull BigInteger numberOfBytes) {
        return formatAsTebibyte(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsTebibyte(final @NotNull Long numberOfBytes, final @NotNull String pattern) {
        return formatAsTebibyte(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsTebibyte(final long numberOfBytes, final @NotNull String pattern) {
        return formatAsTebibyte(BigInteger.valueOf(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsTebibyte(final @NotNull BigInteger numberOfBytes, final @NotNull String pattern) {
        return formatAsTebibyte(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsTebibyte(
            final @NotNull Long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsTebibyte(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsTebibyte(
            final long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsTebibyte(BigInteger.valueOf(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsTebibyte(
            final @NotNull BigInteger numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsTebibyte(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsTebibyte(final @NotNull Long numberOfBytes, final @NotNull Format format) {
        return formatAsTebibyte(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsTebibyte(final long numberOfBytes, final @NotNull Format format) {
        return formatAsTebibyte(BigInteger.valueOf(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsTebibyte(final @NotNull BigInteger numberOfBytes, final @NotNull Format format) {
        return Tebibyte.valueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsPebibyte(final @NotNull Long numberOfBytes) {
        return formatAsPebibyte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsPebibyte(final long numberOfBytes) {
        return formatAsPebibyte(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsPebibyte(final @NotNull BigInteger numberOfBytes) {
        return formatAsPebibyte(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsPebibyte(final @NotNull Long numberOfBytes, final @NotNull String pattern) {
        return formatAsPebibyte(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsPebibyte(final long numberOfBytes, final @NotNull String pattern) {
        return formatAsPebibyte(BigInteger.valueOf(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsPebibyte(final @NotNull BigInteger numberOfBytes, final @NotNull String pattern) {
        return formatAsPebibyte(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsPebibyte(
            final @NotNull Long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsPebibyte(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsPebibyte(
            final long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsPebibyte(BigInteger.valueOf(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsPebibyte(
            final @NotNull BigInteger numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsPebibyte(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsPebibyte(final @NotNull Long numberOfBytes, final @NotNull Format format) {
        return formatAsPebibyte(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsPebibyte(final long numberOfBytes, final @NotNull Format format) {
        return formatAsPebibyte(BigInteger.valueOf(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsPebibyte(final @NotNull BigInteger numberOfBytes, final @NotNull Format format) {
        return Pebibyte.valueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsExbibyte(final @NotNull Long numberOfBytes) {
        return formatAsExbibyte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsExbibyte(final long numberOfBytes) {
        return formatAsExbibyte(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsExbibyte(final @NotNull BigInteger numberOfBytes) {
        return formatAsExbibyte(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsExbibyte(final @NotNull Long numberOfBytes, final @NotNull String pattern) {
        return formatAsExbibyte(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsExbibyte(final long numberOfBytes, final @NotNull String pattern) {
        return formatAsExbibyte(BigInteger.valueOf(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsExbibyte(final @NotNull BigInteger numberOfBytes, final @NotNull String pattern) {
        return formatAsExbibyte(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsExbibyte(
            final @NotNull Long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsExbibyte(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsExbibyte(
            final long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsExbibyte(BigInteger.valueOf(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsExbibyte(
            final @NotNull BigInteger numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsExbibyte(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsExbibyte(final @NotNull Long numberOfBytes, final @NotNull Format format) {
        return formatAsExbibyte(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsExbibyte(final long numberOfBytes, final @NotNull Format format) {
        return formatAsExbibyte(BigInteger.valueOf(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsExbibyte(final @NotNull BigInteger numberOfBytes, final @NotNull Format format) {
        return Exbibyte.valueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsZebibyte(final @NotNull Long numberOfBytes) {
        return formatAsZebibyte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsZebibyte(final long numberOfBytes) {
        return formatAsZebibyte(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsZebibyte(final @NotNull BigInteger numberOfBytes) {
        return formatAsZebibyte(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsZebibyte(final @NotNull Long numberOfBytes, final @NotNull String pattern) {
        return formatAsZebibyte(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsZebibyte(final long numberOfBytes, final @NotNull String pattern) {
        return formatAsZebibyte(BigInteger.valueOf(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsZebibyte(final @NotNull BigInteger numberOfBytes, final @NotNull String pattern) {
        return formatAsZebibyte(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsZebibyte(
            final @NotNull Long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsZebibyte(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsZebibyte(
            final long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsZebibyte(BigInteger.valueOf(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsZebibyte(
            final @NotNull BigInteger numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsZebibyte(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsZebibyte(final @NotNull Long numberOfBytes, final @NotNull Format format) {
        return formatAsZebibyte(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsZebibyte(final long numberOfBytes, final @NotNull Format format) {
        return formatAsZebibyte(BigInteger.valueOf(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsZebibyte(final @NotNull BigInteger numberOfBytes, final @NotNull Format format) {
        return Zebibyte.valueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsYobibyte(final @NotNull Long numberOfBytes) {
        return formatAsYobibyte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsYobibyte(final long numberOfBytes) {
        return formatAsYobibyte(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsYobibyte(final @NotNull BigInteger numberOfBytes) {
        return formatAsYobibyte(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsYobibyte(final @NotNull Long numberOfBytes, final @NotNull String pattern) {
        return formatAsYobibyte(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsYobibyte(final long numberOfBytes, final @NotNull String pattern) {
        return formatAsYobibyte(BigInteger.valueOf(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsYobibyte(final @NotNull BigInteger numberOfBytes, final @NotNull String pattern) {
        return formatAsYobibyte(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsYobibyte(
            final @NotNull Long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsYobibyte(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsYobibyte(
            final long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsYobibyte(BigInteger.valueOf(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsYobibyte(
            final @NotNull BigInteger numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsYobibyte(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsYobibyte(final @NotNull Long numberOfBytes, final @NotNull Format format) {
        return formatAsYobibyte(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsYobibyte(final long numberOfBytes, final @NotNull Format format) {
        return formatAsYobibyte(BigInteger.valueOf(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsYobibyte(final @NotNull BigInteger numberOfBytes, final @NotNull Format format) {
        return Yobibyte.valueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsDecimalUnit(final @NotNull Long numberOfBytes) {
        return formatAsDecimalUnit(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsDecimalUnit(final long numberOfBytes) {
        return formatAsDecimalUnit(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsDecimalUnit(final @NotNull BigInteger numberOfBytes) {
        return formatAsDecimalUnit(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsDecimalUnit(final @NotNull Long numberOfBytes, final @NotNull String pattern) {
        return formatAsDecimalUnit(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsDecimalUnit(final long numberOfBytes, final @NotNull String pattern) {
        return formatAsDecimalUnit(BigInteger.valueOf(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsDecimalUnit(final @NotNull BigInteger numberOfBytes, final @NotNull String pattern) {
        return formatAsDecimalUnit(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsDecimalUnit(
            final @NotNull Long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsDecimalUnit(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsDecimalUnit(
            final long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsDecimalUnit(BigInteger.valueOf(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsDecimalUnit(
            final @NotNull BigInteger numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsDecimalUnit(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsDecimalUnit(final @NotNull Long numberOfBytes, final @NotNull Format format) {
        return formatAsDecimalUnit(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsDecimalUnit(final long numberOfBytes, final @NotNull Format format) {
        return formatAsDecimalUnit(BigInteger.valueOf(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsDecimalUnit(final @NotNull BigInteger numberOfBytes, final @NotNull Format format) {
        return decimalValueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsKilobyte(final @NotNull Long numberOfBytes) {
        return formatAsKilobyte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsKilobyte(final long numberOfBytes) {
        return formatAsKilobyte(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsKilobyte(final @NotNull BigInteger numberOfBytes) {
        return formatAsKilobyte(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsKilobyte(final @NotNull Long numberOfBytes, final @NotNull String pattern) {
        return formatAsKilobyte(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsKilobyte(final long numberOfBytes, final @NotNull String pattern) {
        return formatAsKilobyte(BigInteger.valueOf(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsKilobyte(final @NotNull BigInteger numberOfBytes, final @NotNull String pattern) {
        return formatAsKilobyte(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsKilobyte(
            final @NotNull Long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsKilobyte(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsKilobyte(
            final long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsKilobyte(BigInteger.valueOf(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsKilobyte(
            final @NotNull BigInteger numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsKilobyte(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsKilobyte(final @NotNull Long numberOfBytes, final @NotNull Format format) {
        return formatAsKilobyte(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsKilobyte(final long numberOfBytes, final @NotNull Format format) {
        return formatAsKilobyte(BigInteger.valueOf(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsKilobyte(final @NotNull BigInteger numberOfBytes, final @NotNull Format format) {
        return Kilobyte.valueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsMegabyte(final @NotNull Long numberOfBytes) {
        return formatAsMegabyte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsMegabyte(final long numberOfBytes) {
        return formatAsMegabyte(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsMegabyte(final @NotNull BigInteger numberOfBytes) {
        return formatAsMegabyte(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsMegabyte(final @NotNull Long numberOfBytes, final @NotNull String pattern) {
        return formatAsMegabyte(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsMegabyte(final long numberOfBytes, final @NotNull String pattern) {
        return formatAsMegabyte(BigInteger.valueOf(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsMegabyte(final @NotNull BigInteger numberOfBytes, final @NotNull String pattern) {
        return formatAsMegabyte(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsMegabyte(
            final @NotNull Long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsMegabyte(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsMegabyte(
            final long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsMegabyte(BigInteger.valueOf(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsMegabyte(
            final @NotNull BigInteger numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsMegabyte(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsMegabyte(final @NotNull Long numberOfBytes, final @NotNull Format format) {
        return formatAsMegabyte(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsMegabyte(final long numberOfBytes, final @NotNull Format format) {
        return formatAsMegabyte(BigInteger.valueOf(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsMegabyte(final @NotNull BigInteger numberOfBytes, final @NotNull Format format) {
        return Megabyte.valueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsGigabyte(final @NotNull Long numberOfBytes) {
        return formatAsGigabyte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsGigabyte(final long numberOfBytes) {
        return formatAsGigabyte(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsGigabyte(final @NotNull BigInteger numberOfBytes) {
        return formatAsGigabyte(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsGigabyte(final @NotNull Long numberOfBytes, final @NotNull String pattern) {
        return formatAsGigabyte(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsGigabyte(final long numberOfBytes, final @NotNull String pattern) {
        return formatAsGigabyte(BigInteger.valueOf(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsGigabyte(final @NotNull BigInteger numberOfBytes, final @NotNull String pattern) {
        return formatAsGigabyte(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsGigabyte(
            final @NotNull Long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsGigabyte(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsGigabyte(
            final long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsGigabyte(BigInteger.valueOf(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsGigabyte(
            final @NotNull BigInteger numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsGigabyte(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsGigabyte(final @NotNull Long numberOfBytes, final @NotNull Format format) {
        return formatAsGigabyte(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsGigabyte(final long numberOfBytes, final @NotNull Format format) {
        return formatAsGigabyte(BigInteger.valueOf(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsGigabyte(final @NotNull BigInteger numberOfBytes, final @NotNull Format format) {
        return Gigabyte.valueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsTerabyte(final @NotNull Long numberOfBytes) {
        return formatAsTerabyte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsTerabyte(final long numberOfBytes) {
        return formatAsTerabyte(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsTerabyte(final @NotNull BigInteger numberOfBytes) {
        return formatAsTerabyte(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsTerabyte(final @NotNull Long numberOfBytes, final @NotNull String pattern) {
        return formatAsTerabyte(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsTerabyte(final long numberOfBytes, final @NotNull String pattern) {
        return formatAsTerabyte(BigInteger.valueOf(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsTerabyte(final @NotNull BigInteger numberOfBytes, final @NotNull String pattern) {
        return formatAsTerabyte(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsTerabyte(
            final @NotNull Long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsTerabyte(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsTerabyte(
            final long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsTerabyte(BigInteger.valueOf(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsTerabyte(
            final @NotNull BigInteger numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsTerabyte(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsTerabyte(final @NotNull Long numberOfBytes, final @NotNull Format format) {
        return formatAsTerabyte(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsTerabyte(final long numberOfBytes, final @NotNull Format format) {
        return formatAsTerabyte(BigInteger.valueOf(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsTerabyte(final @NotNull BigInteger numberOfBytes, final @NotNull Format format) {
        return Terabyte.valueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsPetabyte(final @NotNull Long numberOfBytes) {
        return formatAsPetabyte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsPetabyte(final long numberOfBytes) {
        return formatAsPetabyte(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsPetabyte(final @NotNull BigInteger numberOfBytes) {
        return formatAsPetabyte(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsPetabyte(final @NotNull Long numberOfBytes, final @NotNull String pattern) {
        return formatAsPetabyte(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsPetabyte(final long numberOfBytes, final @NotNull String pattern) {
        return formatAsPetabyte(BigInteger.valueOf(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsPetabyte(final @NotNull BigInteger numberOfBytes, final @NotNull String pattern) {
        return formatAsPetabyte(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsPetabyte(
            final @NotNull Long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsPetabyte(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsPetabyte(
            final long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsPetabyte(BigInteger.valueOf(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsPetabyte(
            final @NotNull BigInteger numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsPetabyte(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsPetabyte(final @NotNull Long numberOfBytes, final @NotNull Format format) {
        return formatAsPetabyte(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsPetabyte(final long numberOfBytes, final @NotNull Format format) {
        return formatAsPetabyte(BigInteger.valueOf(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsPetabyte(final @NotNull BigInteger numberOfBytes, final @NotNull Format format) {
        return Petabyte.valueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsExabyte(final @NotNull Long numberOfBytes) {
        return formatAsExabyte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsExabyte(final long numberOfBytes) {
        return formatAsExabyte(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsExabyte(final @NotNull BigInteger numberOfBytes) {
        return formatAsExabyte(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsExabyte(final @NotNull Long numberOfBytes, final @NotNull String pattern) {
        return formatAsExabyte(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsExabyte(final long numberOfBytes, final @NotNull String pattern) {
        return formatAsExabyte(BigInteger.valueOf(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsExabyte(final @NotNull BigInteger numberOfBytes, final @NotNull String pattern) {
        return formatAsExabyte(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsExabyte(
            final @NotNull Long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsExabyte(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsExabyte(
            final long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsExabyte(BigInteger.valueOf(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsExabyte(
            final @NotNull BigInteger numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsExabyte(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsExabyte(final @NotNull Long numberOfBytes, final @NotNull Format format) {
        return formatAsExabyte(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsExabyte(final long numberOfBytes, final @NotNull Format format) {
        return formatAsExabyte(BigInteger.valueOf(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsExabyte(final @NotNull BigInteger numberOfBytes, final @NotNull Format format) {
        return Exabyte.valueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsZettabyte(final @NotNull Long numberOfBytes) {
        return formatAsZettabyte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsZettabyte(final long numberOfBytes) {
        return formatAsZettabyte(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsZettabyte(final @NotNull BigInteger numberOfBytes) {
        return formatAsZettabyte(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsZettabyte(final @NotNull Long numberOfBytes, final @NotNull String pattern) {
        return formatAsZettabyte(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsZettabyte(final long numberOfBytes, final @NotNull String pattern) {
        return formatAsZettabyte(BigInteger.valueOf(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsZettabyte(final @NotNull BigInteger numberOfBytes, final @NotNull String pattern) {
        return formatAsZettabyte(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsZettabyte(
            final @NotNull Long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsZettabyte(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsZettabyte(
            final long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsZettabyte(BigInteger.valueOf(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsZettabyte(
            final @NotNull BigInteger numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsZettabyte(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsZettabyte(final @NotNull Long numberOfBytes, final @NotNull Format format) {
        return formatAsZettabyte(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsZettabyte(final long numberOfBytes, final @NotNull Format format) {
        return formatAsZettabyte(BigInteger.valueOf(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsZettabyte(final @NotNull BigInteger numberOfBytes, final @NotNull Format format) {
        return Zettabyte.valueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsYottabyte(final @NotNull Long numberOfBytes) {
        return formatAsYottabyte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsYottabyte(final long numberOfBytes) {
        return formatAsYottabyte(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsYottabyte(final @NotNull BigInteger numberOfBytes) {
        return formatAsYottabyte(numberOfBytes, StorageUnit.DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsYottabyte(final @NotNull Long numberOfBytes, final @NotNull String pattern) {
        return formatAsYottabyte(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsYottabyte(final long numberOfBytes, final @NotNull String pattern) {
        return formatAsYottabyte(BigInteger.valueOf(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsYottabyte(
            final @NotNull BigInteger numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsYottabyte(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsYottabyte(
            final @NotNull Long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsYottabyte(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @param locale        The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsYottabyte(
            final long numberOfBytes,
            final @NotNull String pattern,
            final @NotNull Locale locale) {
        return formatAsYottabyte(BigInteger.valueOf(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param pattern       The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsYottabyte(final @NotNull BigInteger numberOfBytes, final @NotNull String pattern) {
        return formatAsYottabyte(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsYottabyte(final @NotNull Long numberOfBytes, final @NotNull Format format) {
        return formatAsYottabyte(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsYottabyte(final long numberOfBytes, final @NotNull Format format) {
        return formatAsYottabyte(BigInteger.valueOf(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes The amount of bytes to format.
     * @param format        The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @CheckReturnValue
    public static @NotNull String formatAsYottabyte(final @NotNull BigInteger numberOfBytes, final @NotNull Format format) {
        return Yottabyte.valueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes The amount of bytes to create.
     * @return A new unit representing the given amount of bytes.
     */
    @CheckReturnValue
    public static @NotNull Byte bytes(final @NotNull Long numberOfBytes) {
        return bytes(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes The amount of bytes to create.
     * @return A new unit representing the given amount of bytes.
     */
    @CheckReturnValue
    public static @NotNull Byte bytes(final long numberOfBytes) {
        return bytes(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes to create.
     * @return A new unit representing the given amount of bytes.
     */
    @CheckReturnValue
    public static @NotNull Byte bytes(final @NotNull BigInteger numberOfBytes) {
        return new Byte(numberOfBytes);
    }

    /**
     * @param numberOfKibibytes The amount of kibibytes to create.
     * @return A new unit representing the given amount of kibibytes.
     */
    @CheckReturnValue
    public static @NotNull Kibibyte kibibyte(final @NotNull Long numberOfKibibytes) {
        return kibibyte(numberOfKibibytes.longValue());
    }

    /**
     * @param numberOfKibibytes The amount of kibibytes to create.
     * @return A new unit representing the given amount of kibibytes.
     */
    @CheckReturnValue
    public static @NotNull Kibibyte kibibyte(final long numberOfKibibytes) {
        return kibibyte(BigInteger.valueOf(numberOfKibibytes));
    }

    /**
     * @param numberOfKibibytes The amount of kibibytes to create.
     * @return A new unit representing the given amount of kibibytes.
     */
    @CheckReturnValue
    public static @NotNull Kibibyte kibibyte(final @NotNull BigInteger numberOfKibibytes) {
        return new Kibibyte(StorageUnit.BYTES_IN_A_KIBIBYTE.multiply(numberOfKibibytes));
    }

    /**
     * @param numberOfMebibytes The amount of mebibytes to create.
     * @return A new unit representing the given amount of mebibytes.
     */
    @CheckReturnValue
    public static @NotNull Mebibyte mebibyte(final @NotNull Long numberOfMebibytes) {
        return mebibyte(numberOfMebibytes.longValue());
    }

    /**
     * @param numberOfMebibytes The amount of mebibytes to create.
     * @return A new unit representing the given amount of mebibytes.
     */
    @CheckReturnValue
    public static @NotNull Mebibyte mebibyte(final long numberOfMebibytes) {
        return mebibyte(BigInteger.valueOf(numberOfMebibytes));
    }

    /**
     * @param numberOfMebibytes The amount of mebibytes to create.
     * @return A new unit representing the given amount of mebibytes.
     */
    @CheckReturnValue
    public static @NotNull Mebibyte mebibyte(final @NotNull BigInteger numberOfMebibytes) {
        return new Mebibyte(StorageUnit.BYTES_IN_A_MEBIBYTE.multiply(numberOfMebibytes));
    }

    /**
     * @param numberOfGibibytes The amount of gibibytes to create.
     * @return A new unit representing the given amount of gibibytes.
     */
    @CheckReturnValue
    public static @NotNull Gibibyte gibibyte(final @NotNull Long numberOfGibibytes) {
        return gibibyte(numberOfGibibytes.longValue());
    }

    /**
     * @param numberOfGibibytes The amount of gibibytes to create.
     * @return A new unit representing the given amount of gibibytes.
     */
    @CheckReturnValue
    public static @NotNull Gibibyte gibibyte(final long numberOfGibibytes) {
        return gibibyte(BigInteger.valueOf(numberOfGibibytes));
    }

    /**
     * @param numberOfGibibytes The amount of gibibytes to create.
     * @return A new unit representing the given amount of gibibytes.
     */
    @CheckReturnValue
    public static @NotNull Gibibyte gibibyte(final @NotNull BigInteger numberOfGibibytes) {
        return new Gibibyte(StorageUnit.BYTES_IN_A_GIBIBYTE.multiply(numberOfGibibytes));
    }

    /**
     * @param numberOfTebibytes The amount of tebibytes to create.
     * @return A new unit representing the given amount of tebibytes.
     */
    @CheckReturnValue
    public static @NotNull Tebibyte tebibyte(final @NotNull Long numberOfTebibytes) {
        return tebibyte(numberOfTebibytes.longValue());
    }

    /**
     * @param numberOfTebibytes The amount of tebibytes to create.
     * @return A new unit representing the given amount of tebibytes.
     */
    @CheckReturnValue
    public static @NotNull Tebibyte tebibyte(final long numberOfTebibytes) {
        return tebibyte(BigInteger.valueOf(numberOfTebibytes));
    }

    /**
     * @param numberOfTebibytes The amount of tebibytes to create.
     * @return A new unit representing the given amount of tebibytes.
     */
    @CheckReturnValue
    public static @NotNull Tebibyte tebibyte(final @NotNull BigInteger numberOfTebibytes) {
        return new Tebibyte(StorageUnit.BYTES_IN_A_TEBIBYTE.multiply(numberOfTebibytes));
    }

    /**
     * @param numberOfPebibytes The amount of pebibytes to create.
     * @return A new unit representing the given amount of pebibytes.
     */
    @CheckReturnValue
    public static @NotNull Pebibyte pebibyte(final @NotNull Long numberOfPebibytes) {
        return pebibyte(numberOfPebibytes.longValue());
    }

    /**
     * @param numberOfPebibytes The amount of pebibytes to create.
     * @return A new unit representing the given amount of pebibytes.
     */
    @CheckReturnValue
    public static @NotNull Pebibyte pebibyte(final long numberOfPebibytes) {
        return pebibyte(BigInteger.valueOf(numberOfPebibytes));
    }

    /**
     * @param numberOfPebibytes The amount of pebibytes to create.
     * @return A new unit representing the given amount of pebibytes.
     */
    @CheckReturnValue
    public static @NotNull Pebibyte pebibyte(final @NotNull BigInteger numberOfPebibytes) {
        return new Pebibyte(StorageUnit.BYTES_IN_A_PEBIBYTE.multiply(numberOfPebibytes));
    }

    /**
     * @param numberOfExbibytes The amount of exbibytes to create.
     * @return A new unit representing the given amount of exbibytes.
     */
    @CheckReturnValue
    public static @NotNull Exbibyte exbibyte(final @NotNull Long numberOfExbibytes) {
        return exbibyte(numberOfExbibytes.longValue());
    }

    /**
     * @param numberOfExbibytes The amount of exbibytes to create.
     * @return A new unit representing the given amount of exbibytes.
     */
    @CheckReturnValue
    public static @NotNull Exbibyte exbibyte(final long numberOfExbibytes) {
        return exbibyte(BigInteger.valueOf(numberOfExbibytes));
    }

    /**
     * @param numberOfExbibytes The amount of exbibytes to create.
     * @return A new unit representing the given amount of exbibytes.
     */
    @CheckReturnValue
    public static @NotNull Exbibyte exbibyte(final @NotNull BigInteger numberOfExbibytes) {
        return new Exbibyte(StorageUnit.BYTES_IN_A_EXBIBYTE.multiply(numberOfExbibytes));
    }

    /**
     * @param numberOfZebibytes The amount of zebibytes to create.
     * @return A new unit representing the given amount of zebibytes.
     */
    @CheckReturnValue
    public static @NotNull Zebibyte zebibyte(final @NotNull Long numberOfZebibytes) {
        return zebibyte(numberOfZebibytes.longValue());
    }

    /**
     * @param numberOfZebibytes The amount of zebibytes to create.
     * @return A new unit representing the given amount of zebibytes.
     */
    @CheckReturnValue
    public static @NotNull Zebibyte zebibyte(final long numberOfZebibytes) {
        return zebibyte(BigInteger.valueOf(numberOfZebibytes));
    }

    /**
     * @param numberOfZebibytes The amount of zebibytes to create.
     * @return A new unit representing the given amount of zebibytes.
     */
    @CheckReturnValue
    public static @NotNull Zebibyte zebibyte(final @NotNull BigInteger numberOfZebibytes) {
        return new Zebibyte(StorageUnit.BYTES_IN_A_ZEBIBYTE.multiply(numberOfZebibytes));
    }

    /**
     * @param numberOfYobibytes The amount of yobibytes to create.
     * @return A new unit representing the given amount of yobibytes.
     */
    @CheckReturnValue
    public static @NotNull Yobibyte yobibyte(final @NotNull Long numberOfYobibytes) {
        return yobibyte(numberOfYobibytes.longValue());
    }

    /**
     * @param numberOfYobibytes The amount of yobibytes to create.
     * @return A new unit representing the given amount of yobibytes.
     */
    @CheckReturnValue
    public static @NotNull Yobibyte yobibyte(final long numberOfYobibytes) {
        return yobibyte(BigInteger.valueOf(numberOfYobibytes));
    }

    /**
     * @param numberOfYobibytes The amount of yobibytes to create.
     * @return A new unit representing the given amount of yobibytes.
     */
    @CheckReturnValue
    public static @NotNull Yobibyte yobibyte(final @NotNull BigInteger numberOfYobibytes) {
        return new Yobibyte(StorageUnit.BYTES_IN_A_YOBIBYTE.multiply(numberOfYobibytes));
    }

    /**
     * @param numberOfKilobytes The number of kilobytes to create.
     * @return A new unit representing the given amount of kilobytes.
     */
    @CheckReturnValue
    public static @NotNull Kilobyte kilobyte(final @NotNull Long numberOfKilobytes) {
        return kilobyte(numberOfKilobytes.longValue());
    }

    /**
     * @param numberOfKilobytes The number of kilobytes to create.
     * @return A new unit representing the given amount of kilobytes.
     */
    @CheckReturnValue
    public static @NotNull Kilobyte kilobyte(final long numberOfKilobytes) {
        return kilobyte(BigInteger.valueOf(numberOfKilobytes));
    }

    /**
     * @param numberOfKilobytes The number of kilobytes to create.
     * @return A new unit representing the given amount of kilobytes.
     */
    @CheckReturnValue
    public static @NotNull Kilobyte kilobyte(final @NotNull BigInteger numberOfKilobytes) {
        return new Kilobyte(StorageUnit.BYTES_IN_A_KILOBYTE.multiply(numberOfKilobytes));
    }

    /**
     * @param numberOfMegabytes The number of megabytes to create.
     * @return A new unit representing the given amount of megabytes.
     */
    @CheckReturnValue
    public static @NotNull Megabyte megabyte(final @NotNull Long numberOfMegabytes) {
        return megabyte(numberOfMegabytes.longValue());
    }

    /**
     * @param numberOfMegabytes The number of megabytes to create.
     * @return A new unit representing the given amount of megabytes.
     */
    @CheckReturnValue
    public static @NotNull Megabyte megabyte(final long numberOfMegabytes) {
        return megabyte(BigInteger.valueOf(numberOfMegabytes));
    }

    /**
     * @param numberOfMegabytes The number of megabytes to create.
     * @return A new unit representing the given amount of megabytes.
     */
    @CheckReturnValue
    public static @NotNull Megabyte megabyte(final @NotNull BigInteger numberOfMegabytes) {
        return new Megabyte(StorageUnit.BYTES_IN_A_MEGABYTE.multiply(numberOfMegabytes));
    }

    /**
     * @param numberOfGigabytes The number of gigabytes to create.
     * @return A new unit representing the given amount of gigabytes.
     */
    @CheckReturnValue
    public static @NotNull Gigabyte gigabyte(final @NotNull Long numberOfGigabytes) {
        return gigabyte(numberOfGigabytes.longValue());
    }

    /**
     * @param numberOfGigabytes The number of gigabytes to create.
     * @return A new unit representing the given amount of gigabytes.
     */
    @CheckReturnValue
    public static @NotNull Gigabyte gigabyte(final long numberOfGigabytes) {
        return gigabyte(BigInteger.valueOf(numberOfGigabytes));
    }

    /**
     * @param numberOfGigabytes The number of gigabytes to create.
     * @return A new unit representing the given amount of gigabytes.
     */
    @CheckReturnValue
    public static @NotNull Gigabyte gigabyte(final @NotNull BigInteger numberOfGigabytes) {
        return new Gigabyte(StorageUnit.BYTES_IN_A_GIGABYTE.multiply(numberOfGigabytes));
    }

    /**
     * @param numberOfTerabytes The number of terabytes to create.
     * @return A new unit representing the given amount of terabytes.
     */
    @CheckReturnValue
    public static @NotNull Terabyte terabyte(final @NotNull Long numberOfTerabytes) {
        return terabyte(numberOfTerabytes.longValue());
    }

    /**
     * @param numberOfTerabytes The number of terabytes to create.
     * @return A new unit representing the given amount of terabytes.
     */
    @CheckReturnValue
    public static @NotNull Terabyte terabyte(final long numberOfTerabytes) {
        return terabyte(BigInteger.valueOf(numberOfTerabytes));
    }

    /**
     * @param numberOfTerabytes The number of terabytes to create.
     * @return A new unit representing the given amount of terabytes.
     */
    @CheckReturnValue
    public static @NotNull Terabyte terabyte(final @NotNull BigInteger numberOfTerabytes) {
        return new Terabyte(StorageUnit.BYTES_IN_A_TERABYTE.multiply(numberOfTerabytes));
    }

    /**
     * @param numberOfPetabytes The number of petabytes to create.
     * @return A new unit representing the given amount of petabytes.
     */
    @CheckReturnValue
    public static @NotNull Petabyte petabyte(final @NotNull Long numberOfPetabytes) {
        return petabyte(numberOfPetabytes.longValue());
    }

    /**
     * @param numberOfPetabytes The number of petabytes to create.
     * @return A new unit representing the given amount of petabytes.
     */
    @CheckReturnValue
    public static @NotNull Petabyte petabyte(final long numberOfPetabytes) {
        return petabyte(BigInteger.valueOf(numberOfPetabytes));
    }

    /**
     * @param numberOfPetabytes The number of petabytes to create.
     * @return A new unit representing the given amount of petabytes.
     */
    @CheckReturnValue
    public static @NotNull Petabyte petabyte(final @NotNull BigInteger numberOfPetabytes) {
        return new Petabyte(StorageUnit.BYTES_IN_A_PETABYTE.multiply(numberOfPetabytes));
    }

    /**
     * @param numberOfExabytes The number of exabytes to create.
     * @return A new unit representing the given amount of exabytes.
     */
    @CheckReturnValue
    public static @NotNull Exabyte exabyte(final @NotNull Long numberOfExabytes) {
        return exabyte(numberOfExabytes.longValue());
    }

    /**
     * @param numberOfExabytes The number of exabytes to create.
     * @return A new unit representing the given amount of exabytes.
     */
    @CheckReturnValue
    public static @NotNull Exabyte exabyte(final long numberOfExabytes) {
        return exabyte(BigInteger.valueOf(numberOfExabytes));
    }

    /**
     * @param numberOfExabytes The number of exabytes to create.
     * @return A new unit representing the given amount of exabytes.
     */
    @CheckReturnValue
    public static @NotNull Exabyte exabyte(final @NotNull BigInteger numberOfExabytes) {
        return new Exabyte(StorageUnit.BYTES_IN_A_EXABYTE.multiply(numberOfExabytes));
    }

    /**
     * @param numberOfZettabytes The number of zettabytes to create.
     * @return A new unit representing the given amount of zettabytes.
     */
    @CheckReturnValue
    public static @NotNull Zettabyte zettabyte(final @NotNull Long numberOfZettabytes) {
        return zettabyte(numberOfZettabytes.longValue());
    }

    /**
     * @param numberOfZettabytes The number of zettabytes to create.
     * @return A new unit representing the given amount of zettabytes.
     */
    @CheckReturnValue
    public static @NotNull Zettabyte zettabyte(final long numberOfZettabytes) {
        return zettabyte(BigInteger.valueOf(numberOfZettabytes));
    }

    /**
     * @param numberOfZettabytes The number of zettabytes to create.
     * @return A new unit representing the given amount of zettabytes.
     */
    @CheckReturnValue
    public static @NotNull Zettabyte zettabyte(final @NotNull BigInteger numberOfZettabytes) {
        return new Zettabyte(StorageUnit.BYTES_IN_A_ZETTABYTE.multiply(numberOfZettabytes));
    }

    /**
     * @param numberOfYottabytes The number of yottabytes to create.
     * @return A new unit representing the given amount of yottabytes.
     */
    @CheckReturnValue
    public static @NotNull Yottabyte yottabyte(final @NotNull Long numberOfYottabytes) {
        return yottabyte(numberOfYottabytes.longValue());
    }

    /**
     * @param numberOfYottabytes The number of yottabytes to create.
     * @return A new unit representing the given amount of yottabytes.
     */
    @CheckReturnValue
    public static @NotNull Yottabyte yottabyte(final long numberOfYottabytes) {
        return yottabyte(BigInteger.valueOf(numberOfYottabytes));
    }

    /**
     * @param numberOfYottabytes The number of yottabytes to create.
     * @return A new unit representing the given amount of yottabytes.
     */
    @CheckReturnValue
    public static @NotNull Yottabyte yottabyte(final @NotNull BigInteger numberOfYottabytes) {
        return new Yottabyte(StorageUnit.BYTES_IN_A_YOTTABYTE.multiply(numberOfYottabytes));
    }

}
