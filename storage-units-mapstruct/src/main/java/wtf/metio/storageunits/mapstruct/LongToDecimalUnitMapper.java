/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.mapstruct;

import wtf.metio.storageunits.model.StorageUnit;
import wtf.metio.storageunits.model.StorageUnits;

/**
 * Maps {@link Long} values to decimal storage units.
 */
public final class LongToDecimalUnitMapper {

    public StorageUnit<?> convert(final Long value) {
        return StorageUnits.decimalValueOf(value);
    }

}
