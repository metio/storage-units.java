/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.mapstruct;

import wtf.metio.storageunits.model.StorageUnit;
import wtf.metio.storageunits.model.StorageUnits;

import java.math.BigInteger;

/**
 * Maps {@link BigInteger} values to decimal storage units.
 */
public final class BigIntegerToDecimalUnitMapper {

    public StorageUnit<?> convert(final BigInteger value) {
        return StorageUnits.decimalValueOf(value);
    }

}
