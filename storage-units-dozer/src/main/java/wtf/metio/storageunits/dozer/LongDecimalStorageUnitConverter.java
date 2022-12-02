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
    public StorageUnit<?> convertTo(final Long source, final StorageUnit destination) {
        return StorageUnits.decimalValueOf(source);
    }

    @Override
    public Long convertFrom(final StorageUnit source, final Long destination) {
        return source.inByte().longValue();
    }

}
