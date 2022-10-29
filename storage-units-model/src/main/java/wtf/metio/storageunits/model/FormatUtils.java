/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.model;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Locale;

import org.jetbrains.annotations.NotNull;

final class FormatUtils {

    private FormatUtils() {
        // Hidden constructor.
    }

    @NotNull
    static Format asFormat(@NotNull final String pattern, @NotNull final Locale locale) {
        final var localizedFormat = NumberFormat.getNumberInstance(locale);
        final var outputFormat = (DecimalFormat) localizedFormat;
        outputFormat.applyPattern(pattern);
        return outputFormat;
    }

}
