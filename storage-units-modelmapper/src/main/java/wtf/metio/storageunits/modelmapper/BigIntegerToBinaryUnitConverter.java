/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.modelmapper;

import org.modelmapper.AbstractConverter;
import wtf.metio.storageunits.model.StorageUnit;
import wtf.metio.storageunits.model.StorageUnits;

import java.math.BigInteger;

/**
 * Converts {@link BigInteger} values to binary storage units.
 */
public final class BigIntegerToBinaryUnitConverter extends AbstractConverter<BigInteger, StorageUnit<?>> {

    @Override
    protected StorageUnit<?> convert(final BigInteger value) {
        return StorageUnits.binaryValueOf(value);
    }

}
