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
 * Converts {@link BigInteger} values to decimal storage units.
 */
public final class BigIntegerToDecimalUnitConverter extends AbstractConverter<BigInteger, StorageUnit<?>> {

    @Override
    protected StorageUnit<?> convert(final BigInteger value) {
        return StorageUnits.decimalValueOf(value);
    }

}
