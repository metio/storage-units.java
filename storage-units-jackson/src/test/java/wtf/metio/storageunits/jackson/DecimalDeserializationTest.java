/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wtf.metio.storageunits.model.StorageUnit;

import java.io.IOException;

class DecimalDeserializationTest {

    private ObjectMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new ObjectMapper();
        mapper.registerModule(new StorageUnitModule(StorageUnitModule.PreferredUnitType.DECIMAL));
    }

    @Test
    void deserializeStorageUnit() throws IOException {
        // given
        final String input = "1000";

        // when
        final StorageUnit<?> unit = mapper.readValue(input, StorageUnit.class);

        // then
        Assertions.assertEquals("1.00 kB", unit.toString());
    }

}
