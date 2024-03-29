/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.model;

import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Locale;

final class FormatUtils {

    private FormatUtils() {
        // Hidden constructor.
    }

    static @NotNull Format asFormat(final @NotNull String pattern, final @NotNull Locale locale) {
        final var localizedFormat = NumberFormat.getNumberInstance(locale);
        final var outputFormat = (DecimalFormat) localizedFormat;
        outputFormat.applyPattern(pattern);
        return outputFormat;
    }

}
