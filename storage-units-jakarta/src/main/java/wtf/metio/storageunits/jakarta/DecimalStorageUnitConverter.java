/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.jakarta;

import jakarta.persistence.Converter;
import wtf.metio.storageunits.model.StorageUnit;
import wtf.metio.storageunits.model.StorageUnits;

import java.math.BigInteger;

/**
 * Converts database values to decimal storage units.
 */
@Converter
public final class DecimalStorageUnitConverter extends AbstractStorageUnitConverter {

    @Override
    public StorageUnit<?> convertToEntityAttribute(final BigInteger y) {
        return StorageUnits.decimalValueOf(y);
    }

}
