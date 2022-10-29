/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import wtf.metio.storageunits.model.StorageUnit;
import wtf.metio.storageunits.model.StorageUnits;

import java.io.IOException;

/**
 * Deserializes value back into binary storage units.
 */
public final class BinaryStorageUnitDeserializer extends JsonDeserializer<StorageUnit<?>> {

    @Override
    public StorageUnit<?> deserialize(final JsonParser jsonParser, final DeserializationContext context)
            throws IOException {
        return StorageUnits.binaryValueOf(jsonParser.getBigIntegerValue());
    }

}
