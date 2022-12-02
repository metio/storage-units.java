/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.modelmapper;

import org.modelmapper.AbstractConverter;
import wtf.metio.storageunits.model.StorageUnit;
import wtf.metio.storageunits.model.StorageUnits;

/**
 * Converts {@link Long} values to decimal storage units.
 */
public final class LongToDecimalUnitConverter extends AbstractConverter<Long, StorageUnit<?>> {

    @Override
    protected StorageUnit<?> convert(final Long s) {
        return StorageUnits.decimalValueOf(s);
    }

}
