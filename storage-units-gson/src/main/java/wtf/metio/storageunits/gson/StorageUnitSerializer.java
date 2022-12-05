/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */

package wtf.metio.storageunits.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import wtf.metio.storageunits.model.StorageUnit;

import java.lang.reflect.Type;

/**
 * Serializes storage units into strings.
 */
public final class StorageUnitSerializer implements JsonSerializer<StorageUnit<?>> {

    @Override
    public JsonElement serialize(
            final StorageUnit<?> src,
            final Type typeOfSrc,
            final JsonSerializationContext context) {
        return new JsonPrimitive(src.inByte().toString());
    }

}
