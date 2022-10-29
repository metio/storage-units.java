/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.jakarta;

import jakarta.persistence.AttributeConverter;
import wtf.metio.storageunits.model.StorageUnit;

import java.math.BigInteger;

/**
 * Abstract implementation of a Jakarta Persistence {@link AttributeConverter} for {@link StorageUnit StorageUnits}.
 */
abstract class AbstractStorageUnitConverter implements AttributeConverter<StorageUnit<?>, BigInteger> {

    @Override
    public final BigInteger convertToDatabaseColumn(final StorageUnit<?> storageUnit) {
        return storageUnit.inByte();
    }

}
