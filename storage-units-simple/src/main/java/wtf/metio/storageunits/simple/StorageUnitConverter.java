/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.simple;

import org.simpleframework.xml.convert.Converter;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import wtf.metio.storageunits.model.StorageUnit;
import wtf.metio.storageunits.model.StorageUnits;

/**
 * String-based implementation of a SimpleXML {@link Converter} for {@link StorageUnit StorageUnits}.
 */
public final class StorageUnitConverter implements Converter<StorageUnit<?>> {

    @Override
    public void write(final OutputNode outputNode, final StorageUnit<?> t) throws Exception {
        outputNode.setValue(t.inByte().toString());
    }

    @Override
    public StorageUnit<?> read(final InputNode inputNode) throws Exception {
        return StorageUnits.parse(inputNode.getValue());
    }

}
