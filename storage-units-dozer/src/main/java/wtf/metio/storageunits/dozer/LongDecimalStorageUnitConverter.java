/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.dozer;

import com.github.dozermapper.core.DozerConverter;
import wtf.metio.storageunits.model.StorageUnit;
import wtf.metio.storageunits.model.StorageUnits;

/**
 * Converter for {@link Long} values to decimal storage units.
 */
public final class LongDecimalStorageUnitConverter extends DozerConverter<Long, StorageUnit> {

    public LongDecimalStorageUnitConverter() {
        super(Long.class, StorageUnit.class);
    }

    @Override
    public StorageUnit<?> convertTo(final Long value, final StorageUnit unit) {
        return StorageUnits.decimalValueOf(value);
    }

    @Override
    public Long convertFrom(final StorageUnit unit, final Long value) {
        return unit.inByte().longValue();
    }

}
