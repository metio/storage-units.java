/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wtf.metio.storageunits.model.StorageUnit;

class DecimalDeserializationTest {

    private Gson gson;

    @BeforeEach
    void setUp() {
        gson = new GsonBuilder()
                .registerTypeHierarchyAdapter(StorageUnit.class, new DecimalStorageUnitDeserializer())
                .create();
    }

    @Test
    void deserializeStorageUnit() {
        // given
        final String input = "1000";

        // when
        final StorageUnit<?> unit = gson.fromJson(input, StorageUnit.class);

        // then
        Assertions.assertEquals("1.00 kB", unit.toString());
    }

}
