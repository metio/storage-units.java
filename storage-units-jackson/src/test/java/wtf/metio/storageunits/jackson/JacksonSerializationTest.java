/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
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
