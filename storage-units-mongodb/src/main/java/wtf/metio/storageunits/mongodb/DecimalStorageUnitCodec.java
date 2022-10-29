/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.mongodb;

import wtf.metio.storageunits.model.StorageUnit;
import wtf.metio.storageunits.model.StorageUnits;

import java.math.BigInteger;

public final class DecimalStorageUnitCodec extends AbstractStorageUnitCodec {

    @Override
    protected StorageUnit<?> convertToStorageUnit(final BigInteger value) {
        return StorageUnits.decimalValueOf(value);
    }

}
