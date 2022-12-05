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
import wtf.metio.storageunits.model.Kibibyte;
import wtf.metio.storageunits.model.StorageUnit;
import wtf.metio.storageunits.model.StorageUnits;

class StorageUnitSerializerTest {

    private Gson gson;

    @BeforeEach
    void setUp() {
        gson = new GsonBuilder()
                .registerTypeHierarchyAdapter(StorageUnit.class, new StorageUnitSerializer())
                .create();
    }

    @Test
    void serializeStorageUnit() {
        // given
        final StorageUnit<?> unit = StorageUnits.kibibyte(1L);

        // when
        final String output = gson.toJson(unit);

        // then
        Assertions.assertEquals("\"1024\"", output);
    }

    @Test
    void serializeNonStorageUnit() {
        // given
        final String input = "abc";

        // when
        final String output = gson.toJson(input);

        // then
        Assertions.assertEquals("\"abc\"", output);
    }

}
