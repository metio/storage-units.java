/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package wtf.metio.storageunits.jackson;

import java.util.function.Supplier;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.ser.Serializers;
import wtf.metio.storageunits.model.StorageUnit;

/**
 * High-level Jackson module to configure de-/serialization of storage units.
 */
public class StorageUnitModule extends Module {

    private static final String MODULE_NAME = StorageUnitModule.class.getSimpleName();

    private static final Version MODULE_VERSION = new Version(4, 0, 0, "", "wtf.metio.storageunits",
            "storage-units-jackson");

    private final PreferredUnitType preferredUnitType;

    /**
     * Creates a new module which defaults to binary unit types.
     */
    public StorageUnitModule() {
        this(PreferredUnitType.BINARY);
    }

    /**
     * @param preferredUnitType
     *            The preferred de-serialization unit type.
     */
    public StorageUnitModule(final PreferredUnitType preferredUnitType) {
        this.preferredUnitType = preferredUnitType;
    }

    @Override
    public String getModuleName() {
        return MODULE_NAME;
    }

    @Override
    public Version version() {
        return MODULE_VERSION;
    }

    @Override
    public void setupModule(final SetupContext context) {
        context.addSerializers(new StorageUnitSerializers());
        context.addDeserializers(new StorageUnitDeserializers(preferredUnitType));
    }

    /**
     * The preferred storage unit type for de-serialization.
     */
    public enum PreferredUnitType {

        /** Deserializes values as binary units. */
        BINARY(BinaryStorageUnitDeserializer::new),

        /** Deserializes values as decimal units. */
        DECIMAL(DecimalStorageUnitDeserializer::new);

        /** The deserializer to use. */
        final Supplier<JsonDeserializer<?>> deserializer;

        PreferredUnitType(final Supplier<JsonDeserializer<?>> deserializer) {
            this.deserializer = deserializer;
        }

    }

    private static final class StorageUnitSerializers extends Serializers.Base {

        StorageUnitSerializers() {
            // no config yet
        }

        @Override
        public JsonSerializer<?> findSerializer(
                final SerializationConfig config,
                final JavaType type,
                final BeanDescription beanDesc) {
            final Class<?> rawClass = type.getRawClass();
            JsonSerializer<?> serializer = null;
            if (StorageUnit.class.isAssignableFrom(rawClass)) {
                serializer = new UnwrappingStorageUnitSerializer();
            }
            return serializer;
        }

    }

    private static final class StorageUnitDeserializers extends Deserializers.Base {

        private final PreferredUnitType preferredUnitType;

        StorageUnitDeserializers(final PreferredUnitType preferredUnitType) {
            this.preferredUnitType = preferredUnitType;
        }

        @Override
        public JsonDeserializer<?> findBeanDeserializer(
                final JavaType type,
                final DeserializationConfig config,
                final BeanDescription beanDesc)
                throws JsonMappingException {
            final Class<?> rawClass = type.getRawClass();

            if (StorageUnit.class.isAssignableFrom(rawClass)) {
                return preferredUnitType.deserializer.get();
            }

            return super.findBeanDeserializer(type, config, beanDesc);
        }

    }

}
