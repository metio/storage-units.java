/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.mapstruct;

import wtf.metio.storageunits.model.StorageUnit;

import java.math.BigInteger;

/**
 * Maps storage units to {@link BigInteger}s.
 */
public final class StorageUnitToBigIntegerMapper {

    public BigInteger convert(final StorageUnit<?> storageUnit) {
        return storageUnit.inByte();
    }

}
