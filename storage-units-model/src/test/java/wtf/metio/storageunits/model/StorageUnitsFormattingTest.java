/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StorageUnitsFormattingTest {

    @Test
    void formatReadmeExample() {
        // given
        final long numberOfBytes = 1_000_000_000_000_000L;

        // when
        final String formatted = StorageUnits.formatAsTerabyte(numberOfBytes, "#0.#####");

        // then
        Assertions.assertEquals("1000 TB", formatted);
    }

    @Test
    void formatNumberAsBytes() {
        // given
        final Long numberOfBytes = 123456L;

        // when
        final String formatted = StorageUnits.formatAsByte(numberOfBytes);

        // then
        Assertions.assertEquals("123456 B", formatted);
    }

    @Test
    void formatPrimitiveLongAsBytes() {
        // given
        final long numberOfBytes = 123456L;

        // when
        final String formatted = StorageUnits.formatAsByte(numberOfBytes);

        // then
        Assertions.assertEquals("123456 B", formatted);
    }

}
