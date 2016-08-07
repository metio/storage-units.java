/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.utils.storage_unit;

import java.math.BigInteger;
import java.util.stream.LongStream;

import de.xn__ho_hia.quality.suppression.CompilerWarnings;

/**
 *
 *
 */
@SuppressWarnings({ CompilerWarnings.NLS })
public class TestUtils {

    private TestUtils() {
        // factory/helper class
    }

    static String logIncorrectCreation(
            final long bytes,
            final Class<?> expectedClass,
            final Class<?> unitClass) {
        return logIncorrectCreation(BigInteger.valueOf(bytes), expectedClass, unitClass);
    }

    static String logIncorrectCreation(
            final Long bytes,
            final Class<?> expectedClass,
            final Class<?> unitClass) {
        return logIncorrectCreation(bytes.longValue(), expectedClass, unitClass);
    }

    static String logIncorrectCreation(
            final BigInteger bytes,
            final Class<?> expectedClass,
            final Class<?> unitClass) {
        return String.format(
                "'%s' bytes should result in type [%s] but got [%s].",
                bytes,
                expectedClass.getSimpleName(),
                unitClass.getSimpleName());
    }

    static Long pow(final Long value, final int power) {
        final long result = LongStream.range(1, power + 1)
                .reduce(1L, (a, b) -> a * value.longValue());
        return Long.valueOf(result);
    }

}
