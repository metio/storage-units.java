/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */

package wtf.metio.storageunits.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import wtf.metio.storageunits.model.StorageUnits;

class StorageUnitConverterTest {

    @Test
    void convertStringToStorageUnit() throws Exception {
        final var converter = new StorageUnitConverter();
        final var input = Mockito.mock(InputNode.class);
        BDDMockito.given(input.getValue()).willReturn("100");
        final var unit = converter.read(input);

        Assertions.assertNotNull(unit);
    }

    @Test
    void convertStorageUnitToString() throws Exception {
        final var converter = new StorageUnitConverter();
        final var output = Mockito.mock(OutputNode.class);
        final var unit = StorageUnits.kibibyte(2);
        converter.write(output, unit);

        Mockito.verify(output).setValue("2048");
    }

}
