/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.jackson;

import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import wtf.metio.storageunits.model.StorageUnit;
import wtf.metio.storageunits.model.StorageUnits;

/**
 * Deserializes value back into decimal storage units.
 */
public final class DecimalStorageUnitDeserializer extends JsonDeserializer<StorageUnit<?>> {

    @Override
    public StorageUnit<?> deserialize(final JsonParser jsonParser, final DeserializationContext context)
            throws IOException {
        return StorageUnits.decimalValueOf(jsonParser.getBigIntegerValue());
    }

}
