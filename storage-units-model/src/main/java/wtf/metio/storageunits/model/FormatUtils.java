/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
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
