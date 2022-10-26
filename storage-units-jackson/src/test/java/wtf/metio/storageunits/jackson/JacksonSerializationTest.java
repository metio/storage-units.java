/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package wtf.metio.storageunits.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wtf.metio.storageunits.model.StorageUnit;
import wtf.metio.storageunits.model.StorageUnits;

class JacksonSerializationTest {

  private ObjectMapper mapper;

  @BeforeEach
  void setUp() {
    mapper = new ObjectMapper();
    mapper.registerModule(new StorageUnitModule());
  }

  @Test
  void shouldSerializeStorageUnit() throws JsonProcessingException {
    // given
    final StorageUnit<?> unit = StorageUnits.kibibyte(1L);

    // when
    final String output = mapper.writeValueAsString(unit);

    // then
    Assertions.assertEquals("1024", output);
  }

  @Test
  void shouldSerializeNonStorageUnit() throws JsonProcessingException {
    // given
    final String input = "abc";

    // when
    final String output = mapper.writeValueAsString(input);

    // then
    Assertions.assertEquals("\"abc\"", output);
  }

}
