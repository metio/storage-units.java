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
 * Converter for {@link BigInteger} values to binary storage units.
 */
public final class BigIntegerBinaryStorageUnitConverter extends DozerConverter<BigInteger, StorageUnit> {

    public BigIntegerBinaryStorageUnitConverter() {
        super(BigInteger.class, StorageUnit.class);
    }

    @Override
    public StorageUnit<?> convertTo(final BigInteger source, final StorageUnit destination) {
        return StorageUnits.binaryValueOf(source);
    }

    @Override
    public BigInteger convertFrom(final StorageUnit source, final BigInteger destination) {
        return source.inByte();
    }

}
