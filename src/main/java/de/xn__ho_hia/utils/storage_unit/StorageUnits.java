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
import static de.xn__ho_hia.utils.storage_unit.StorageUnit.BYTES_IN_A_EXABYTE;
import static de.xn__ho_hia.utils.storage_unit.StorageUnit.BYTES_IN_A_EXBIBYTE;
import static de.xn__ho_hia.utils.storage_unit.StorageUnit.BYTES_IN_A_GIBIBYTE;
import static de.xn__ho_hia.utils.storage_unit.StorageUnit.BYTES_IN_A_GIGABYTE;
import static de.xn__ho_hia.utils.storage_unit.StorageUnit.BYTES_IN_A_KIBIBYTE;
import static de.xn__ho_hia.utils.storage_unit.StorageUnit.BYTES_IN_A_KILOBYTE;
import static de.xn__ho_hia.utils.storage_unit.StorageUnit.BYTES_IN_A_MEBIBYTE;
import static de.xn__ho_hia.utils.storage_unit.StorageUnit.BYTES_IN_A_MEGABYTE;
import static de.xn__ho_hia.utils.storage_unit.StorageUnit.BYTES_IN_A_PEBIBYTE;
import static de.xn__ho_hia.utils.storage_unit.StorageUnit.BYTES_IN_A_PETABYTE;
import static de.xn__ho_hia.utils.storage_unit.StorageUnit.BYTES_IN_A_TEBIBYTE;
import static de.xn__ho_hia.utils.storage_unit.StorageUnit.BYTES_IN_A_TERABYTE;
import static de.xn__ho_hia.utils.storage_unit.StorageUnit.BYTES_IN_A_YOBIBYTE;
import static de.xn__ho_hia.utils.storage_unit.StorageUnit.BYTES_IN_A_YOTTABYTE;
import static de.xn__ho_hia.utils.storage_unit.StorageUnit.BYTES_IN_A_ZEBIBYTE;
import static de.xn__ho_hia.utils.storage_unit.StorageUnit.BYTES_IN_A_ZETTABYTE;
import static de.xn__ho_hia.utils.storage_unit.StorageUnit.DEFAULT_FORMAT_PATTERN;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.Locale;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Factory for storage units.
 */
public final class StorageUnits {

    private StorageUnits() {
        // Hidden constructor.
    }

    /**
     * @param bytes
     *            The amount to bytes to represent.
     * @return The appropriate binary-prefixed unit for the given amount of bytes.
     */
    public static StorageUnit<?> binaryValueOf(final long bytes) {
        return binaryValueOf(asBigInteger(bytes));
    }

    /**
     * @param bytes
     *            The amount to bytes to represent.
     * @return The appropriate binary-prefixed unit for the given amount of bytes.
     */
    public static StorageUnit<?> binaryValueOf(@NonNull final BigInteger bytes) {
        StorageUnit<?> unit = Kibibyte.valueOf(bytes);

        if (inbetween(StorageUnit.BYTES_IN_A_MEBIBYTE, bytes, StorageUnit.BYTES_IN_A_GIBIBYTE)) {
            unit = unit.asMebibyte();
        } else if (inbetween(StorageUnit.BYTES_IN_A_GIBIBYTE, bytes, StorageUnit.BYTES_IN_A_TEBIBYTE)) {
            unit = unit.asGibibyte();
        } else if (inbetween(StorageUnit.BYTES_IN_A_TEBIBYTE, bytes, StorageUnit.BYTES_IN_A_PEBIBYTE)) {
            unit = unit.asTebibyte();
        } else if (inbetween(StorageUnit.BYTES_IN_A_PEBIBYTE, bytes, StorageUnit.BYTES_IN_A_EXBIBYTE)) {
            unit = unit.asPebibyte();
        } else if (inbetween(StorageUnit.BYTES_IN_A_EXBIBYTE, bytes, StorageUnit.BYTES_IN_A_ZEBIBYTE)) {
            unit = unit.asExbibyte();
        } else if (inbetween(StorageUnit.BYTES_IN_A_ZEBIBYTE, bytes, StorageUnit.BYTES_IN_A_YOBIBYTE)) {
            unit = unit.asZebibyte();
        } else if (greaterThanEquals(bytes, StorageUnit.BYTES_IN_A_YOBIBYTE)) {
            unit = unit.asYobibyte();
        }

        return unit;
    }

    /**
     * @param bytes
     *            The amount of bytes to represent.
     * @return The appropriate metric-prefixed unit for the given amount of bytes.
     */
    public static StorageUnit<?> metricValueOf(final long bytes) {
        return metricValueOf(asBigInteger(bytes));
    }

    /**
     * @param bytes
     *            The amount of bytes to represent.
     * @return The appropriate metric-prefixed unit for the given amount of bytes.
     */
    public static StorageUnit<?> metricValueOf(@NonNull final BigInteger bytes) {
        StorageUnit<?> unit = Kilobyte.valueOf(bytes);

        if (inbetween(StorageUnit.BYTES_IN_A_MEGABYTE, bytes, StorageUnit.BYTES_IN_A_GIGABYTE)) {
            unit = unit.asMegabyte();
        } else if (inbetween(StorageUnit.BYTES_IN_A_GIGABYTE, bytes, StorageUnit.BYTES_IN_A_TERABYTE)) {
            unit = unit.asGigabyte();
        } else if (inbetween(StorageUnit.BYTES_IN_A_TERABYTE, bytes, StorageUnit.BYTES_IN_A_PETABYTE)) {
            unit = unit.asTerabyte();
        } else if (inbetween(StorageUnit.BYTES_IN_A_PETABYTE, bytes, StorageUnit.BYTES_IN_A_EXABYTE)) {
            unit = unit.asPetabyte();
        } else if (inbetween(StorageUnit.BYTES_IN_A_EXABYTE, bytes, StorageUnit.BYTES_IN_A_ZETTABYTE)) {
            unit = unit.asExabyte();
        } else if (inbetween(StorageUnit.BYTES_IN_A_ZETTABYTE, bytes, StorageUnit.BYTES_IN_A_YOTTABYTE)) {
            unit = unit.asZettabyte();
        } else if (greaterThanEquals(bytes, StorageUnit.BYTES_IN_A_YOTTABYTE)) {
            unit = unit.asYottabyte();
        }

        return unit;
    }

    private static boolean inbetween(final BigInteger start, final BigInteger value, final BigInteger endExclusive) {
        return greaterThanEquals(value, start) && value.compareTo(endExclusive) < 0;
    }

    private static boolean greaterThanEquals(final BigInteger value, final BigInteger comparison) {
        return value.compareTo(comparison) >= 0;
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsByte(@NonNull final Long numberOfBytes) {
        return formatAsByte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsByte(final long numberOfBytes) {
        return formatAsByte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsByte(@NonNull final BigInteger numberOfBytes) {
        return numberOfBytes.toString() + " B"; //$NON-NLS-1$
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsBinaryUnit(@NonNull final Long numberOfBytes) {
        return formatAsBinaryUnit(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsBinaryUnit(final long numberOfBytes) {
        return formatAsBinaryUnit(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsBinaryUnit(@NonNull final BigInteger numberOfBytes) {
        return formatAsBinaryUnit(numberOfBytes, DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsBinaryUnit(@NonNull final Long numberOfBytes, final String pattern) {
        return formatAsBinaryUnit(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsBinaryUnit(final long numberOfBytes, final String pattern) {
        return formatAsBinaryUnit(asBigInteger(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsBinaryUnit(@NonNull final BigInteger numberOfBytes, final String pattern) {
        return formatAsBinaryUnit(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsBinaryUnit(@NonNull final Long numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsBinaryUnit(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsBinaryUnit(final long numberOfBytes, final String pattern, final Locale locale) {
        return formatAsBinaryUnit(asBigInteger(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsBinaryUnit(@NonNull final BigInteger numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsBinaryUnit(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsBinaryUnit(@NonNull final Long numberOfBytes, final Format format) {
        return formatAsBinaryUnit(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsBinaryUnit(final long numberOfBytes, final Format format) {
        return formatAsBinaryUnit(asBigInteger(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsBinaryUnit(@NonNull final BigInteger numberOfBytes, final Format format) {
        return binaryValueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsKibibyte(@NonNull final Long numberOfBytes) {
        return formatAsKibibyte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsKibibyte(final long numberOfBytes) {
        return formatAsKibibyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsKibibyte(@NonNull final BigInteger numberOfBytes) {
        return formatAsKibibyte(numberOfBytes, DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsKibibyte(@NonNull final Long numberOfBytes, final String pattern) {
        return formatAsKibibyte(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsKibibyte(final long numberOfBytes, final String pattern) {
        return formatAsKibibyte(asBigInteger(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsKibibyte(@NonNull final BigInteger numberOfBytes, final String pattern) {
        return formatAsKibibyte(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsKibibyte(@NonNull final Long numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsKibibyte(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsKibibyte(final long numberOfBytes, final String pattern, final Locale locale) {
        return formatAsKibibyte(asBigInteger(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsKibibyte(@NonNull final BigInteger numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsKibibyte(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsKibibyte(@NonNull final Long numberOfBytes, final Format format) {
        return formatAsKibibyte(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsKibibyte(final long numberOfBytes, final Format format) {
        return formatAsKibibyte(asBigInteger(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsKibibyte(@NonNull final BigInteger numberOfBytes, final Format format) {
        return Kibibyte.valueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMebibyte(@NonNull final Long numberOfBytes) {
        return formatAsMebibyte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMebibyte(final long numberOfBytes) {
        return formatAsMebibyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMebibyte(@NonNull final BigInteger numberOfBytes) {
        return formatAsMebibyte(numberOfBytes, DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMebibyte(@NonNull final Long numberOfBytes, final String pattern) {
        return formatAsMebibyte(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMebibyte(final long numberOfBytes, final String pattern) {
        return formatAsMebibyte(asBigInteger(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMebibyte(@NonNull final BigInteger numberOfBytes, final String pattern) {
        return formatAsMebibyte(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMebibyte(@NonNull final Long numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsMebibyte(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMebibyte(final long numberOfBytes, final String pattern, final Locale locale) {
        return formatAsMebibyte(asBigInteger(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMebibyte(@NonNull final BigInteger numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsMebibyte(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMebibyte(@NonNull final Long numberOfBytes, final Format format) {
        return formatAsMebibyte(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMebibyte(final long numberOfBytes, final Format format) {
        return formatAsMebibyte(asBigInteger(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMebibyte(@NonNull final BigInteger numberOfBytes, final Format format) {
        return Mebibyte.valueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsGibibyte(@NonNull final Long numberOfBytes) {
        return formatAsGibibyte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsGibibyte(final long numberOfBytes) {
        return formatAsGibibyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsGibibyte(@NonNull final BigInteger numberOfBytes) {
        return formatAsGibibyte(numberOfBytes, DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsGibibyte(@NonNull final Long numberOfBytes, final String pattern) {
        return formatAsGibibyte(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsGibibyte(final long numberOfBytes, final String pattern) {
        return formatAsGibibyte(asBigInteger(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsGibibyte(@NonNull final BigInteger numberOfBytes, final String pattern) {
        return formatAsGibibyte(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsGibibyte(@NonNull final Long numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsGibibyte(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsGibibyte(final long numberOfBytes, final String pattern, final Locale locale) {
        return formatAsGibibyte(asBigInteger(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsGibibyte(@NonNull final BigInteger numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsGibibyte(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsGibibyte(@NonNull final Long numberOfBytes, final Format format) {
        return formatAsGibibyte(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsGibibyte(final long numberOfBytes, final Format format) {
        return formatAsGibibyte(asBigInteger(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsGibibyte(@NonNull final BigInteger numberOfBytes, final Format format) {
        return Gibibyte.valueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsTebibyte(@NonNull final Long numberOfBytes) {
        return formatAsTebibyte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsTebibyte(final long numberOfBytes) {
        return formatAsTebibyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsTebibyte(@NonNull final BigInteger numberOfBytes) {
        return formatAsTebibyte(numberOfBytes, DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsTebibyte(@NonNull final Long numberOfBytes, final String pattern) {
        return formatAsTebibyte(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsTebibyte(final long numberOfBytes, final String pattern) {
        return formatAsTebibyte(asBigInteger(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsTebibyte(@NonNull final BigInteger numberOfBytes, final String pattern) {
        return formatAsTebibyte(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsTebibyte(@NonNull final Long numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsTebibyte(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsTebibyte(final long numberOfBytes, final String pattern, final Locale locale) {
        return formatAsTebibyte(asBigInteger(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsTebibyte(@NonNull final BigInteger numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsTebibyte(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsTebibyte(@NonNull final Long numberOfBytes, final Format format) {
        return formatAsTebibyte(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsTebibyte(final long numberOfBytes, final Format format) {
        return formatAsTebibyte(asBigInteger(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsTebibyte(@NonNull final BigInteger numberOfBytes, final Format format) {
        return Tebibyte.valueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsPebibyte(@NonNull final Long numberOfBytes) {
        return formatAsPebibyte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsPebibyte(final long numberOfBytes) {
        return formatAsPebibyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsPebibyte(@NonNull final BigInteger numberOfBytes) {
        return formatAsPebibyte(numberOfBytes, DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsPebibyte(@NonNull final Long numberOfBytes, final String pattern) {
        return formatAsPebibyte(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsPebibyte(final long numberOfBytes, final String pattern) {
        return formatAsPebibyte(asBigInteger(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsPebibyte(@NonNull final BigInteger numberOfBytes, final String pattern) {
        return formatAsPebibyte(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsPebibyte(@NonNull final Long numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsPebibyte(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsPebibyte(final long numberOfBytes, final String pattern, final Locale locale) {
        return formatAsPebibyte(asBigInteger(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsPebibyte(@NonNull final BigInteger numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsPebibyte(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsPebibyte(@NonNull final Long numberOfBytes, final Format format) {
        return formatAsPebibyte(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsPebibyte(final long numberOfBytes, final Format format) {
        return formatAsPebibyte(asBigInteger(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsPebibyte(@NonNull final BigInteger numberOfBytes, final Format format) {
        return Pebibyte.valueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsExbibyte(@NonNull final Long numberOfBytes) {
        return formatAsExbibyte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsExbibyte(final long numberOfBytes) {
        return formatAsExbibyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsExbibyte(@NonNull final BigInteger numberOfBytes) {
        return formatAsExbibyte(numberOfBytes, DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsExbibyte(@NonNull final Long numberOfBytes, final String pattern) {
        return formatAsExbibyte(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsExbibyte(final long numberOfBytes, final String pattern) {
        return formatAsExbibyte(asBigInteger(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsExbibyte(@NonNull final BigInteger numberOfBytes, final String pattern) {
        return formatAsExbibyte(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsExbibyte(@NonNull final Long numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsExbibyte(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsExbibyte(final long numberOfBytes, final String pattern, final Locale locale) {
        return formatAsExbibyte(asBigInteger(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsExbibyte(@NonNull final BigInteger numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsExbibyte(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsExbibyte(@NonNull final Long numberOfBytes, final Format format) {
        return formatAsExbibyte(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsExbibyte(final long numberOfBytes, final Format format) {
        return formatAsExbibyte(asBigInteger(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsExbibyte(@NonNull final BigInteger numberOfBytes, final Format format) {
        return Exbibyte.valueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsZebibyte(@NonNull final Long numberOfBytes) {
        return formatAsZebibyte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsZebibyte(final long numberOfBytes) {
        return formatAsZebibyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsZebibyte(@NonNull final BigInteger numberOfBytes) {
        return formatAsZebibyte(numberOfBytes, DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsZebibyte(@NonNull final Long numberOfBytes, final String pattern) {
        return formatAsZebibyte(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsZebibyte(final long numberOfBytes, final String pattern) {
        return formatAsZebibyte(asBigInteger(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsZebibyte(@NonNull final BigInteger numberOfBytes, final String pattern) {
        return formatAsZebibyte(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsZebibyte(@NonNull final Long numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsZebibyte(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsZebibyte(final long numberOfBytes, final String pattern, final Locale locale) {
        return formatAsZebibyte(asBigInteger(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsZebibyte(@NonNull final BigInteger numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsZebibyte(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsZebibyte(@NonNull final Long numberOfBytes, final Format format) {
        return formatAsZebibyte(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsZebibyte(final long numberOfBytes, final Format format) {
        return formatAsZebibyte(asBigInteger(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsZebibyte(@NonNull final BigInteger numberOfBytes, final Format format) {
        return Zebibyte.valueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsYobibyte(@NonNull final Long numberOfBytes) {
        return formatAsYobibyte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsYobibyte(final long numberOfBytes) {
        return formatAsYobibyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsYobibyte(@NonNull final BigInteger numberOfBytes) {
        return formatAsYobibyte(numberOfBytes, DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsYobibyte(@NonNull final Long numberOfBytes, final String pattern) {
        return formatAsYobibyte(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsYobibyte(final long numberOfBytes, final String pattern) {
        return formatAsYobibyte(asBigInteger(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsYobibyte(@NonNull final BigInteger numberOfBytes, final String pattern) {
        return formatAsYobibyte(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsYobibyte(@NonNull final Long numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsYobibyte(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsYobibyte(final long numberOfBytes, final String pattern, final Locale locale) {
        return formatAsYobibyte(asBigInteger(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsYobibyte(@NonNull final BigInteger numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsYobibyte(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsYobibyte(@NonNull final Long numberOfBytes, final Format format) {
        return formatAsYobibyte(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsYobibyte(final long numberOfBytes, final Format format) {
        return formatAsYobibyte(asBigInteger(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsYobibyte(@NonNull final BigInteger numberOfBytes, final Format format) {
        return Yobibyte.valueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMetricUnit(@NonNull final Long numberOfBytes) {
        return formatAsMetricUnit(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMetricUnit(final long numberOfBytes) {
        return formatAsMetricUnit(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMetricUnit(@NonNull final BigInteger numberOfBytes) {
        return formatAsMetricUnit(numberOfBytes, DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMetricUnit(@NonNull final Long numberOfBytes, final String pattern) {
        return formatAsMetricUnit(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMetricUnit(final long numberOfBytes, final String pattern) {
        return formatAsMetricUnit(asBigInteger(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMetricUnit(@NonNull final BigInteger numberOfBytes, final String pattern) {
        return formatAsMetricUnit(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMetricUnit(@NonNull final Long numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsMetricUnit(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMetricUnit(final long numberOfBytes, final String pattern, final Locale locale) {
        return formatAsMetricUnit(asBigInteger(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMetricUnit(@NonNull final BigInteger numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsMetricUnit(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMetricUnit(@NonNull final Long numberOfBytes, final Format format) {
        return formatAsMetricUnit(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMetricUnit(final long numberOfBytes, final Format format) {
        return formatAsMetricUnit(asBigInteger(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMetricUnit(@NonNull final BigInteger numberOfBytes, final Format format) {
        return metricValueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsKilobyte(@NonNull final Long numberOfBytes) {
        return formatAsKilobyte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsKilobyte(final long numberOfBytes) {
        return formatAsKilobyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsKilobyte(@NonNull final BigInteger numberOfBytes) {
        return formatAsKilobyte(numberOfBytes, DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsKilobyte(@NonNull final Long numberOfBytes, final String pattern) {
        return formatAsKilobyte(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsKilobyte(final long numberOfBytes, final String pattern) {
        return formatAsKilobyte(asBigInteger(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsKilobyte(@NonNull final BigInteger numberOfBytes, final String pattern) {
        return formatAsKilobyte(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsKilobyte(@NonNull final Long numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsKilobyte(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsKilobyte(final long numberOfBytes, final String pattern, final Locale locale) {
        return formatAsKilobyte(asBigInteger(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsKilobyte(@NonNull final BigInteger numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsKilobyte(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsKilobyte(@NonNull final Long numberOfBytes, final Format format) {
        return formatAsKilobyte(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsKilobyte(final long numberOfBytes, final Format format) {
        return formatAsKilobyte(asBigInteger(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsKilobyte(@NonNull final BigInteger numberOfBytes, final Format format) {
        return Kilobyte.valueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMegabyte(@NonNull final Long numberOfBytes) {
        return formatAsMegabyte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMegabyte(final long numberOfBytes) {
        return formatAsMegabyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMegabyte(@NonNull final BigInteger numberOfBytes) {
        return formatAsMegabyte(numberOfBytes, DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMegabyte(@NonNull final Long numberOfBytes, final String pattern) {
        return formatAsMegabyte(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMegabyte(final long numberOfBytes, final String pattern) {
        return formatAsMegabyte(asBigInteger(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMegabyte(@NonNull final BigInteger numberOfBytes, final String pattern) {
        return formatAsMegabyte(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMegabyte(@NonNull final Long numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsMegabyte(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMegabyte(final long numberOfBytes, final String pattern, final Locale locale) {
        return formatAsMegabyte(asBigInteger(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMegabyte(@NonNull final BigInteger numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsMegabyte(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMegabyte(@NonNull final Long numberOfBytes, final Format format) {
        return formatAsMegabyte(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMegabyte(final long numberOfBytes, final Format format) {
        return formatAsMegabyte(asBigInteger(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsMegabyte(@NonNull final BigInteger numberOfBytes, final Format format) {
        return Megabyte.valueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsGigabyte(@NonNull final Long numberOfBytes) {
        return formatAsGigabyte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsGigabyte(final long numberOfBytes) {
        return formatAsGigabyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsGigabyte(@NonNull final BigInteger numberOfBytes) {
        return formatAsGigabyte(numberOfBytes, DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsGigabyte(@NonNull final Long numberOfBytes, final String pattern) {
        return formatAsGigabyte(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsGigabyte(final long numberOfBytes, final String pattern) {
        return formatAsGigabyte(asBigInteger(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsGigabyte(@NonNull final BigInteger numberOfBytes, final String pattern) {
        return formatAsGigabyte(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsGigabyte(@NonNull final Long numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsGigabyte(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsGigabyte(final long numberOfBytes, final String pattern, final Locale locale) {
        return formatAsGigabyte(asBigInteger(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsGigabyte(@NonNull final BigInteger numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsGigabyte(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsGigabyte(@NonNull final Long numberOfBytes, final Format format) {
        return formatAsGigabyte(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsGigabyte(final long numberOfBytes, final Format format) {
        return formatAsGigabyte(asBigInteger(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsGigabyte(@NonNull final BigInteger numberOfBytes, final Format format) {
        return Gigabyte.valueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsTerabyte(@NonNull final Long numberOfBytes) {
        return formatAsTerabyte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsTerabyte(final long numberOfBytes) {
        return formatAsTerabyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsTerabyte(@NonNull final BigInteger numberOfBytes) {
        return formatAsTerabyte(numberOfBytes, DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsTerabyte(@NonNull final Long numberOfBytes, final String pattern) {
        return formatAsTerabyte(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsTerabyte(final long numberOfBytes, final String pattern) {
        return formatAsTerabyte(asBigInteger(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsTerabyte(@NonNull final BigInteger numberOfBytes, final String pattern) {
        return formatAsTerabyte(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsTerabyte(@NonNull final Long numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsTerabyte(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsTerabyte(final long numberOfBytes, final String pattern, final Locale locale) {
        return formatAsTerabyte(asBigInteger(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsTerabyte(@NonNull final BigInteger numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsTerabyte(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsTerabyte(@NonNull final Long numberOfBytes, final Format format) {
        return formatAsTerabyte(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsTerabyte(final long numberOfBytes, final Format format) {
        return formatAsTerabyte(asBigInteger(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsTerabyte(@NonNull final BigInteger numberOfBytes, final Format format) {
        return Terabyte.valueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsPetabyte(@NonNull final Long numberOfBytes) {
        return formatAsPetabyte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsPetabyte(final long numberOfBytes) {
        return formatAsPetabyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsPetabyte(@NonNull final BigInteger numberOfBytes) {
        return formatAsPetabyte(numberOfBytes, DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsPetabyte(@NonNull final Long numberOfBytes, final String pattern) {
        return formatAsPetabyte(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsPetabyte(final long numberOfBytes, final String pattern) {
        return formatAsPetabyte(asBigInteger(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsPetabyte(@NonNull final BigInteger numberOfBytes, final String pattern) {
        return formatAsPetabyte(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsPetabyte(@NonNull final Long numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsPetabyte(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsPetabyte(final long numberOfBytes, final String pattern, final Locale locale) {
        return formatAsPetabyte(asBigInteger(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsPetabyte(@NonNull final BigInteger numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsPetabyte(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsPetabyte(@NonNull final Long numberOfBytes, final Format format) {
        return formatAsPetabyte(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsPetabyte(final long numberOfBytes, final Format format) {
        return formatAsPetabyte(asBigInteger(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsPetabyte(@NonNull final BigInteger numberOfBytes, final Format format) {
        return Petabyte.valueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsExabyte(@NonNull final Long numberOfBytes) {
        return formatAsExabyte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsExabyte(final long numberOfBytes) {
        return formatAsExabyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsExabyte(@NonNull final BigInteger numberOfBytes) {
        return formatAsExabyte(numberOfBytes, DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsExabyte(@NonNull final Long numberOfBytes, final String pattern) {
        return formatAsExabyte(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsExabyte(final long numberOfBytes, final String pattern) {
        return formatAsExabyte(asBigInteger(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsExabyte(@NonNull final BigInteger numberOfBytes, final String pattern) {
        return formatAsExabyte(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsExabyte(@NonNull final Long numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsExabyte(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsExabyte(final long numberOfBytes, final String pattern, final Locale locale) {
        return formatAsExabyte(asBigInteger(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsExabyte(@NonNull final BigInteger numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsExabyte(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsExabyte(@NonNull final Long numberOfBytes, final Format format) {
        return formatAsExabyte(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsExabyte(final long numberOfBytes, final Format format) {
        return formatAsExabyte(asBigInteger(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsExabyte(@NonNull final BigInteger numberOfBytes, final Format format) {
        return Exabyte.valueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsZettabyte(@NonNull final Long numberOfBytes) {
        return formatAsZettabyte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsZettabyte(final long numberOfBytes) {
        return formatAsZettabyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsZettabyte(@NonNull final BigInteger numberOfBytes) {
        return formatAsZettabyte(numberOfBytes, DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsZettabyte(@NonNull final Long numberOfBytes, final String pattern) {
        return formatAsZettabyte(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsZettabyte(final long numberOfBytes, final String pattern) {
        return formatAsZettabyte(asBigInteger(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsZettabyte(@NonNull final BigInteger numberOfBytes, final String pattern) {
        return formatAsZettabyte(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsZettabyte(@NonNull final Long numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsZettabyte(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsZettabyte(final long numberOfBytes, final String pattern, final Locale locale) {
        return formatAsZettabyte(asBigInteger(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsZettabyte(@NonNull final BigInteger numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsZettabyte(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsZettabyte(@NonNull final Long numberOfBytes, final Format format) {
        return formatAsZettabyte(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsZettabyte(final long numberOfBytes, final Format format) {
        return formatAsZettabyte(asBigInteger(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsZettabyte(@NonNull final BigInteger numberOfBytes, final Format format) {
        return Zettabyte.valueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsYottabyte(@NonNull final Long numberOfBytes) {
        return formatAsYottabyte(numberOfBytes.longValue());
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsYottabyte(final long numberOfBytes) {
        return formatAsYottabyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsYottabyte(@NonNull final BigInteger numberOfBytes) {
        return formatAsYottabyte(numberOfBytes, DEFAULT_FORMAT_PATTERN);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsYottabyte(@NonNull final Long numberOfBytes, final String pattern) {
        return formatAsYottabyte(numberOfBytes.longValue(), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsYottabyte(final long numberOfBytes, final String pattern) {
        return formatAsYottabyte(asBigInteger(numberOfBytes), pattern);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsYottabyte(@NonNull final BigInteger numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsYottabyte(numberOfBytes, asFormat(pattern, locale));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsYottabyte(@NonNull final Long numberOfBytes, final String pattern,
            final Locale locale) {
        return formatAsYottabyte(numberOfBytes.longValue(), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @param locale
     *            The locale to use.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsYottabyte(final long numberOfBytes, final String pattern, final Locale locale) {
        return formatAsYottabyte(asBigInteger(numberOfBytes), pattern, locale);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param pattern
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsYottabyte(@NonNull final BigInteger numberOfBytes, final String pattern) {
        return formatAsYottabyte(numberOfBytes, new DecimalFormat(pattern));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsYottabyte(@NonNull final Long numberOfBytes, final Format format) {
        return formatAsYottabyte(numberOfBytes.longValue(), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsYottabyte(final long numberOfBytes, final Format format) {
        return formatAsYottabyte(asBigInteger(numberOfBytes), format);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes to format.
     * @param format
     *            The formatting pattern to apply.
     * @return The formatted bytes using the default pattern.
     */
    @NonNull
    public static String formatAsYottabyte(@NonNull final BigInteger numberOfBytes, final Format format) {
        return Yottabyte.valueOf(numberOfBytes).toString(format);
    }

    /**
     * @param numberOfKibibytes
     *            The amount of kibibytes to create.
     * @return A new unit representing the given amount of kibibytes.
     */
    @NonNull
    public static Kibibyte kibibyte(@NonNull final Long numberOfKibibytes) {
        return kibibyte(numberOfKibibytes.longValue());
    }

    /**
     * @param numberOfKibibytes
     *            The amount of kibibytes to create.
     * @return A new unit representing the given amount of kibibytes.
     */
    @NonNull
    public static Kibibyte kibibyte(final long numberOfKibibytes) {
        return kibibyte(asBigInteger(numberOfKibibytes));
    }

    /**
     * @param numberOfKibibytes
     *            The amount of kibibytes to create.
     * @return A new unit representing the given amount of kibibytes.
     */
    @NonNull
    public static Kibibyte kibibyte(@NonNull final BigInteger numberOfKibibytes) {
        return new Kibibyte(multiplyNullsafe(BYTES_IN_A_KIBIBYTE, numberOfKibibytes));
    }

    /**
     * @param numberOfMebibytes
     *            The amount of mebibytes to create.
     * @return A new unit representing the given amount of mebibytes.
     */
    @NonNull
    public static Mebibyte mebibyte(@NonNull final Long numberOfMebibytes) {
        return mebibyte(numberOfMebibytes.longValue());
    }

    /**
     * @param numberOfMebibytes
     *            The amount of mebibytes to create.
     * @return A new unit representing the given amount of mebibytes.
     */
    @NonNull
    public static Mebibyte mebibyte(final long numberOfMebibytes) {
        return mebibyte(asBigInteger(numberOfMebibytes));
    }

    /**
     * @param numberOfMebibytes
     *            The amount of mebibytes to create.
     * @return A new unit representing the given amount of mebibytes.
     */
    @NonNull
    public static Mebibyte mebibyte(@NonNull final BigInteger numberOfMebibytes) {
        return new Mebibyte(multiplyNullsafe(BYTES_IN_A_MEBIBYTE, numberOfMebibytes));
    }

    /**
     * @param numberOfGibibytes
     *            The amount of gibibytes to create.
     * @return A new unit representing the given amount of gibibytes.
     */
    @NonNull
    public static Gibibyte gibibyte(@NonNull final Long numberOfGibibytes) {
        return gibibyte(numberOfGibibytes.longValue());
    }

    /**
     * @param numberOfGibibytes
     *            The amount of gibibytes to create.
     * @return A new unit representing the given amount of gibibytes.
     */
    @NonNull
    public static Gibibyte gibibyte(final long numberOfGibibytes) {
        return gibibyte(asBigInteger(numberOfGibibytes));
    }

    /**
     * @param numberOfGibibytes
     *            The amount of gibibytes to create.
     * @return A new unit representing the given amount of gibibytes.
     */
    @NonNull
    public static Gibibyte gibibyte(@NonNull final BigInteger numberOfGibibytes) {
        return new Gibibyte(multiplyNullsafe(BYTES_IN_A_GIBIBYTE, numberOfGibibytes));
    }

    /**
     * @param numberOfTebibytes
     *            The amount of tebibytes to create.
     * @return A new unit representing the given amount of tebibytes.
     */
    @NonNull
    public static Tebibyte tebibyte(@NonNull final Long numberOfTebibytes) {
        return tebibyte(numberOfTebibytes.longValue());
    }

    /**
     * @param numberOfTebibytes
     *            The amount of tebibytes to create.
     * @return A new unit representing the given amount of tebibytes.
     */
    @NonNull
    public static Tebibyte tebibyte(final long numberOfTebibytes) {
        return tebibyte(asBigInteger(numberOfTebibytes));
    }

    /**
     * @param numberOfTebibytes
     *            The amount of tebibytes to create.
     * @return A new unit representing the given amount of tebibytes.
     */
    @NonNull
    public static Tebibyte tebibyte(@NonNull final BigInteger numberOfTebibytes) {
        return new Tebibyte(multiplyNullsafe(BYTES_IN_A_TEBIBYTE, numberOfTebibytes));
    }

    /**
     * @param numberOfPebibytes
     *            The amount of pebibytes to create.
     * @return A new unit representing the given amount of pebibytes.
     */
    @NonNull
    public static Pebibyte pebibyte(@NonNull final Long numberOfPebibytes) {
        return pebibyte(numberOfPebibytes.longValue());
    }

    /**
     * @param numberOfPebibytes
     *            The amount of pebibytes to create.
     * @return A new unit representing the given amount of pebibytes.
     */
    @NonNull
    public static Pebibyte pebibyte(final long numberOfPebibytes) {
        return pebibyte(asBigInteger(numberOfPebibytes));
    }

    /**
     * @param numberOfPebibytes
     *            The amount of pebibytes to create.
     * @return A new unit representing the given amount of pebibytes.
     */
    @NonNull
    public static Pebibyte pebibyte(@NonNull final BigInteger numberOfPebibytes) {
        return new Pebibyte(multiplyNullsafe(BYTES_IN_A_PEBIBYTE, numberOfPebibytes));
    }

    /**
     * @param numberOfExbibytes
     *            The amount of exbibytes to create.
     * @return A new unit representing the given amount of exbibytes.
     */
    @NonNull
    public static Exbibyte exbibyte(@NonNull final Long numberOfExbibytes) {
        return exbibyte(numberOfExbibytes.longValue());
    }

    /**
     * @param numberOfExbibytes
     *            The amount of exbibytes to create.
     * @return A new unit representing the given amount of exbibytes.
     */
    @NonNull
    public static Exbibyte exbibyte(final long numberOfExbibytes) {
        return exbibyte(asBigInteger(numberOfExbibytes));
    }

    /**
     * @param numberOfExbibytes
     *            The amount of exbibytes to create.
     * @return A new unit representing the given amount of exbibytes.
     */
    @NonNull
    public static Exbibyte exbibyte(@NonNull final BigInteger numberOfExbibytes) {
        return new Exbibyte(multiplyNullsafe(BYTES_IN_A_EXBIBYTE, numberOfExbibytes));
    }

    /**
     * @param numberOfZebibytes
     *            The amount of zebibytes to create.
     * @return A new unit representing the given amount of zebibytes.
     */
    @NonNull
    public static Zebibyte zebibyte(@NonNull final Long numberOfZebibytes) {
        return zebibyte(numberOfZebibytes.longValue());
    }

    /**
     * @param numberOfZebibytes
     *            The amount of zebibytes to create.
     * @return A new unit representing the given amount of zebibytes.
     */
    @NonNull
    public static Zebibyte zebibyte(final long numberOfZebibytes) {
        return zebibyte(asBigInteger(numberOfZebibytes));
    }

    /**
     * @param numberOfZebibytes
     *            The amount of zebibytes to create.
     * @return A new unit representing the given amount of zebibytes.
     */
    @NonNull
    public static Zebibyte zebibyte(@NonNull final BigInteger numberOfZebibytes) {
        return new Zebibyte(multiplyNullsafe(BYTES_IN_A_ZEBIBYTE, numberOfZebibytes));
    }

    /**
     * @param numberOfYobibytes
     *            The amount of yobibytes to create.
     * @return A new unit representing the given amount of yobibytes.
     */
    @NonNull
    public static Yobibyte yobibyte(@NonNull final Long numberOfYobibytes) {
        return yobibyte(numberOfYobibytes.longValue());
    }

    /**
     * @param numberOfYobibytes
     *            The amount of yobibytes to create.
     * @return A new unit representing the given amount of yobibytes.
     */
    @NonNull
    public static Yobibyte yobibyte(final long numberOfYobibytes) {
        return yobibyte(asBigInteger(numberOfYobibytes));
    }

    /**
     * @param numberOfYobibytes
     *            The amount of yobibytes to create.
     * @return A new unit representing the given amount of yobibytes.
     */
    @NonNull
    public static Yobibyte yobibyte(@NonNull final BigInteger numberOfYobibytes) {
        return new Yobibyte(multiplyNullsafe(BYTES_IN_A_YOBIBYTE, numberOfYobibytes));
    }

    /**
     * @param numberOfKilobytes
     *            The number of kilobytes to create.
     * @return A new unit representing the given amount of kilobytes.
     */
    @NonNull
    public static Kilobyte kilobyte(@NonNull final Long numberOfKilobytes) {
        return kilobyte(numberOfKilobytes.longValue());
    }

    /**
     * @param numberOfKilobytes
     *            The number of kilobytes to create.
     * @return A new unit representing the given amount of kilobytes.
     */
    @NonNull
    public static Kilobyte kilobyte(final long numberOfKilobytes) {
        return kilobyte(asBigInteger(numberOfKilobytes));
    }

    /**
     * @param numberOfKilobytes
     *            The number of kilobytes to create.
     * @return A new unit representing the given amount of kilobytes.
     */
    @NonNull
    public static Kilobyte kilobyte(@NonNull final BigInteger numberOfKilobytes) {
        return new Kilobyte(multiplyNullsafe(BYTES_IN_A_KILOBYTE, numberOfKilobytes));
    }

    /**
     * @param numberOfMegabytes
     *            The number of megabytes to create.
     * @return A new unit representing the given amount of megabytes.
     */
    @NonNull
    public static Megabyte megabyte(@NonNull final Long numberOfMegabytes) {
        return megabyte(numberOfMegabytes.longValue());
    }

    /**
     * @param numberOfMegabytes
     *            The number of megabytes to create.
     * @return A new unit representing the given amount of megabytes.
     */
    @NonNull
    public static Megabyte megabyte(final long numberOfMegabytes) {
        return megabyte(asBigInteger(numberOfMegabytes));
    }

    /**
     * @param numberOfMegabytes
     *            The number of megabytes to create.
     * @return A new unit representing the given amount of megabytes.
     */
    @NonNull
    public static Megabyte megabyte(@NonNull final BigInteger numberOfMegabytes) {
        return new Megabyte(multiplyNullsafe(BYTES_IN_A_MEGABYTE, numberOfMegabytes));
    }

    /**
     * @param numberOfGigabytes
     *            The number of gigabytes to create.
     * @return A new unit representing the given amount of gigabytes.
     */
    @NonNull
    public static Gigabyte gigabyte(@NonNull final Long numberOfGigabytes) {
        return gigabyte(numberOfGigabytes.longValue());
    }

    /**
     * @param numberOfGigabytes
     *            The number of gigabytes to create.
     * @return A new unit representing the given amount of gigabytes.
     */
    @NonNull
    public static Gigabyte gigabyte(final long numberOfGigabytes) {
        return gigabyte(asBigInteger(numberOfGigabytes));
    }

    /**
     * @param numberOfGigabytes
     *            The number of gigabytes to create.
     * @return A new unit representing the given amount of gigabytes.
     */
    @NonNull
    public static Gigabyte gigabyte(@NonNull final BigInteger numberOfGigabytes) {
        return new Gigabyte(multiplyNullsafe(BYTES_IN_A_GIGABYTE, numberOfGigabytes));
    }

    /**
     * @param numberOfTerabytes
     *            The number of terabytes to create.
     * @return A new unit representing the given amount of terabytes.
     */
    @NonNull
    public static Terabyte terabyte(@NonNull final Long numberOfTerabytes) {
        return terabyte(numberOfTerabytes.longValue());
    }

    /**
     * @param numberOfTerabytes
     *            The number of terabytes to create.
     * @return A new unit representing the given amount of terabytes.
     */
    @NonNull
    public static Terabyte terabyte(final long numberOfTerabytes) {
        return terabyte(asBigInteger(numberOfTerabytes));
    }

    /**
     * @param numberOfTerabytes
     *            The number of terabytes to create.
     * @return A new unit representing the given amount of terabytes.
     */
    @NonNull
    public static Terabyte terabyte(@NonNull final BigInteger numberOfTerabytes) {
        return new Terabyte(multiplyNullsafe(BYTES_IN_A_TERABYTE, numberOfTerabytes));
    }

    /**
     * @param numberOfPetabytes
     *            The number of petabytes to create.
     * @return A new unit representing the given amount of petabytes.
     */
    @NonNull
    public static Petabyte petabyte(@NonNull final Long numberOfPetabytes) {
        return petabyte(numberOfPetabytes.longValue());
    }

    /**
     * @param numberOfPetabytes
     *            The number of petabytes to create.
     * @return A new unit representing the given amount of petabytes.
     */
    @NonNull
    public static Petabyte petabyte(final long numberOfPetabytes) {
        return petabyte(asBigInteger(numberOfPetabytes));
    }

    /**
     * @param numberOfPetabytes
     *            The number of petabytes to create.
     * @return A new unit representing the given amount of petabytes.
     */
    @NonNull
    public static Petabyte petabyte(@NonNull final BigInteger numberOfPetabytes) {
        return new Petabyte(multiplyNullsafe(BYTES_IN_A_PETABYTE, numberOfPetabytes));
    }

    /**
     * @param numberOfExabytes
     *            The number of exabytes to create.
     * @return A new unit representing the given amount of exabytes.
     */
    @NonNull
    public static Exabyte exabyte(@NonNull final Long numberOfExabytes) {
        return exabyte(numberOfExabytes.longValue());
    }

    /**
     * @param numberOfExabytes
     *            The number of exabytes to create.
     * @return A new unit representing the given amount of exabytes.
     */
    @NonNull
    public static Exabyte exabyte(final long numberOfExabytes) {
        return exabyte(asBigInteger(numberOfExabytes));
    }

    /**
     * @param numberOfExabytes
     *            The number of exabytes to create.
     * @return A new unit representing the given amount of exabytes.
     */
    @NonNull
    public static Exabyte exabyte(@NonNull final BigInteger numberOfExabytes) {
        return new Exabyte(multiplyNullsafe(BYTES_IN_A_EXABYTE, numberOfExabytes));
    }

    /**
     * @param numberOfZettabytes
     *            The number of zettabytes to create.
     * @return A new unit representing the given amount of zettabytes.
     */
    @NonNull
    public static Zettabyte zettabyte(@NonNull final Long numberOfZettabytes) {
        return zettabyte(numberOfZettabytes.longValue());
    }

    /**
     * @param numberOfZettabytes
     *            The number of zettabytes to create.
     * @return A new unit representing the given amount of zettabytes.
     */
    @NonNull
    public static Zettabyte zettabyte(final long numberOfZettabytes) {
        return zettabyte(asBigInteger(numberOfZettabytes));
    }

    /**
     * @param numberOfZettabytes
     *            The number of zettabytes to create.
     * @return A new unit representing the given amount of zettabytes.
     */
    @NonNull
    public static Zettabyte zettabyte(@NonNull final BigInteger numberOfZettabytes) {
        return new Zettabyte(multiplyNullsafe(BYTES_IN_A_ZETTABYTE, numberOfZettabytes));
    }

    /**
     * @param numberOfYottabytes
     *            The number of yottabytes to create.
     * @return A new unit representing the given amount of yottabytes.
     */
    @NonNull
    public static Yottabyte yottabyte(@NonNull final Long numberOfYottabytes) {
        return yottabyte(numberOfYottabytes.longValue());
    }

    /**
     * @param numberOfYottabytes
     *            The number of yottabytes to create.
     * @return A new unit representing the given amount of yottabytes.
     */
    @NonNull
    public static Yottabyte yottabyte(final long numberOfYottabytes) {
        return yottabyte(asBigInteger(numberOfYottabytes));
    }

    /**
     * @param numberOfYottabytes
     *            The number of yottabytes to create.
     * @return A new unit representing the given amount of yottabytes.
     */
    @NonNull
    public static Yottabyte yottabyte(@NonNull final BigInteger numberOfYottabytes) {
        return new Yottabyte(multiplyNullsafe(BYTES_IN_A_YOTTABYTE, numberOfYottabytes));
    }

}
