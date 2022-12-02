/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.model;

import java.math.BigInteger;
import java.util.stream.LongStream;

final class TestUtils {

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

}
