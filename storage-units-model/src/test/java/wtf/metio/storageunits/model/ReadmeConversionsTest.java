/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package wtf.metio.storageunits.model;

import static wtf.metio.storageunits.model.StorageUnits.kilobyte;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReadmeConversionsTest {

  @Test
  void shouldFormatUnitWithDefaults() {
    Assertions.assertAll(
        () -> Assertions.assertEquals("1.10 MB",
            kilobyte(900).add(kilobyte(200)).asBestMatchingUnit().toString()),
        () -> Assertions.assertEquals("1.05 MiB",
            kilobyte(900).add(kilobyte(200)).asBestMatchingBinaryUnit().toString()),
        () -> Assertions.assertEquals("1.10 MB",
            kilobyte(900).add(kilobyte(200)).asBestMatchingDecimalUnit().toString())
    );
  }

}
