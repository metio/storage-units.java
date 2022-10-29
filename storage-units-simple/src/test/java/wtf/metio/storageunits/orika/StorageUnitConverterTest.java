/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */

package wtf.metio.storageunits.orika;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.simpleframework.xml.stream.InputNode;

class StorageUnitConverterTest {

    @Test
    void shouldConvertStringToStorageUnit() throws Exception {
        final var converter = new StorageUnitConverter();
        final var input = Mockito.mock(InputNode.class);
        BDDMockito.given(input.getValue()).willReturn("100");
        final var unit = converter.read(input);

        Assertions.assertNotNull(unit);
    }

}
