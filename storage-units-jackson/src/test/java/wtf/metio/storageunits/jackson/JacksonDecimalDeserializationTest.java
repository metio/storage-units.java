/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package wtf.metio.storageunits.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wtf.metio.storageunits.model.StorageUnit;

class JacksonDecimalDeserializationTest {

  private ObjectMapper mapper;

  @BeforeEach
  void setUp() {
    mapper = new ObjectMapper();
    mapper.registerModule(new StorageUnitModule(StorageUnitModule.PreferredUnitType.DECIMAL));
  }

  @Test
  void shouldDeserializeStorageUnit() throws IOException {
    // given
    final String input = "1000";

    // when
    final StorageUnit<?> unit = mapper.readValue(input, StorageUnit.class);

    // then
    Assertions.assertEquals("1.00 kB", unit.toString());
  }

}
