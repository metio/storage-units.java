/*
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 *
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information, please refer to <http://unlicense.org>
 */
package com.github.sebhoss.units.storage;

import java.math.BigInteger;

/**
 * Zebibyte as specified in ISO IEC 80000-13:2008.
 */
public final class Zebibyte extends StorageUnit<Zebibyte> {

    private static final long serialVersionUID = 2192254824473341887L;

    /**
     * @param numberOfBytes
     *            The amount of bytes the zebibytes contains.
     * @return A new Zebibyte unit with the given value.
     */
    public static Zebibyte valueOf(final long numberOfBytes) {
        return new Zebibyte(BigInteger.valueOf(numberOfBytes));
    }

    Zebibyte(final BigInteger bytes) {
        super(bytes);
    }

    @Override
    public Zebibyte add(final long bytesToAdd) {
        return new Zebibyte(bytes.add(BigInteger.valueOf(bytesToAdd)));
    }

    @Override
    public Zebibyte add(final StorageUnit<?> storageAmount) {
        return new Zebibyte(bytes.add(storageAmount.bytes));
    }

    @Override
    public Zebibyte divide(final long divisor) {
        return new Zebibyte(bytes.divide(BigInteger.valueOf(divisor)));
    }

    @Override
    public Zebibyte multiply(final long factor) {
        return new Zebibyte(bytes.multiply(BigInteger.valueOf(factor)));
    }

    @Override
    public Zebibyte subtract(final long bytesToSubtract) {
        return new Zebibyte(bytes.subtract(BigInteger.valueOf(bytesToSubtract)));
    }

    @Override
    public Zebibyte subtract(final StorageUnit<?> storageAmount) {
        return new Zebibyte(bytes.subtract(storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_ZEBIBYTE;
    }

    @Override
    protected String getSymbol() {
        return "ZiB"; //$NON-NLS-1$
    }

}
