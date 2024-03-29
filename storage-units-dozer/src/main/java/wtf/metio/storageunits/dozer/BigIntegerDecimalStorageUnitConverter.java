/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.dozer;

import com.github.dozermapper.core.DozerConverter;
import wtf.metio.storageunits.model.StorageUnit;
import wtf.metio.storageunits.model.StorageUnits;

import java.math.BigInteger;

/**
 * Converter for {@link BigInteger} values to decimal storage units.
 */
public final class BigIntegerDecimalStorageUnitConverter extends DozerConverter<BigInteger, StorageUnit> {

    public BigIntegerDecimalStorageUnitConverter() {
        super(BigInteger.class, StorageUnit.class);
    }

    @Override
    public StorageUnit<?> convertTo(final BigInteger source, final StorageUnit destination) {
        return StorageUnits.decimalValueOf(source);
    }

    @Override
    public BigInteger convertFrom(final StorageUnit source, final BigInteger destination) {
        return source.inByte();
    }

}
