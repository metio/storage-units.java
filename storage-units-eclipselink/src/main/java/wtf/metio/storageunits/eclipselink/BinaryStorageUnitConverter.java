/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.eclipselink;

import wtf.metio.storageunits.model.StorageUnit;
import wtf.metio.storageunits.model.StorageUnits;

import java.io.Serial;
import java.math.BigInteger;

/**
 * Converts database values to binary storage units.
 */
public final class BinaryStorageUnitConverter extends AbstractStorageUnitConverter {

    @Serial
    private static final long serialVersionUID = 7476654237380243377L;

    @Override
    protected StorageUnit<?> convertToStorageUnit(final BigInteger value) {
        return StorageUnits.binaryValueOf(value);
    }

}
