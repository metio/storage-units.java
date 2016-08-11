/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.storage_unit.eclipselink;

import java.math.BigInteger;

import org.eclipse.jdt.annotation.NonNull;

import de.xn__ho_hia.storage_unit.StorageUnit;
import de.xn__ho_hia.storage_unit.StorageUnits;

/**
 * Converts database values to common storage units.
 */
public final class CommonStorageUnitConverter extends AbstractStorageUnitConverter {

    private static final long serialVersionUID = -3710617517690757565L;

    @Override
    protected StorageUnit<?> convertToStorageUnit(@NonNull final BigInteger value) {
        return StorageUnits.commonValueOf(value);
    }

}
