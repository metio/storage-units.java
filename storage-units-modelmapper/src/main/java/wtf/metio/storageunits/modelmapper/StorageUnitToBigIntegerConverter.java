/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.modelmapper;

import org.modelmapper.AbstractConverter;
import wtf.metio.storageunits.model.StorageUnit;

import java.math.BigInteger;

/**
 * Converts storage units to {@link BigInteger}s.
 */
public final class StorageUnitToBigIntegerConverter extends AbstractConverter<StorageUnit<?>, BigInteger> {

    @Override
    protected BigInteger convert(final StorageUnit<?> storageUnit) {
        return storageUnit.inByte();
    }

}
