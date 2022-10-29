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
 * Converts database values to decimal storage units.
 */
public final class DecimalStorageUnitConverter extends AbstractStorageUnitConverter {

    @Serial
    private static final long serialVersionUID = -6919304587763247036L;

    @Override
    protected StorageUnit<?> convertToStorageUnit(final BigInteger value) {
        return StorageUnits.decimalValueOf(value);
    }

}
