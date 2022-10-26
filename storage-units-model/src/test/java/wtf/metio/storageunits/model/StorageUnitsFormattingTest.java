/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package wtf.metio.storageunits.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StorageUnitsFormattingTest {

  @Test
  void shouldFormatReadmeExample() {
    // given
    final long numberOfBytes = 1_000_000_000_000_000L;

    // when
    final String formatted = StorageUnits.formatAsTerabyte(numberOfBytes, "#0.#####");

    // then
    Assertions.assertEquals("1000 TB", formatted);
  }

  @Test
  void shouldFormatNumberAsBytes() {
    // given
    final Long numberOfBytes = 123456L;

    // when
    final String formatted = StorageUnits.formatAsByte(numberOfBytes);

    // then
    Assertions.assertEquals("123456 B", formatted);
  }

  @Test
  void shouldFormatPrimitiveLongAsBytes() {
    // given
    final long numberOfBytes = 123456L;

    // when
    final String formatted = StorageUnits.formatAsByte(numberOfBytes);

    // then
    Assertions.assertEquals("123456 B", formatted);
  }

}
