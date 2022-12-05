/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import wtf.metio.storageunits.model.StorageUnit;
import wtf.metio.storageunits.model.StorageUnits;

import java.lang.reflect.Type;

/**
 * Deserializes value back into decimal storage units.
 */
public final class DecimalStorageUnitDeserializer implements JsonDeserializer<StorageUnit<?>> {

    @Override
    public StorageUnit<?> deserialize(
            final JsonElement json,
            final Type typeOfT,
            final JsonDeserializationContext context) throws JsonParseException {
        return StorageUnits.parse(json.getAsJsonPrimitive().getAsString()).asBestMatchingDecimalUnit();
    }

}
