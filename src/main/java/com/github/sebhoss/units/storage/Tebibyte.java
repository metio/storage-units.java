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
 * Tebibyte as specified in ISO IEC 80000-13:2008.
 */
public final class Tebibyte extends StorageUnit<Tebibyte> {

    /** Generated */
    private static final long serialVersionUID = 3614537130129620881L;

    /**
     * @param numberOfBytes
     *            The amount of bytes the tebibytes contains.
     * @return A new Tebibyte unit with the given value.
     */
    public static Tebibyte valueOf(final long numberOfBytes) {
        return new Tebibyte(BigInteger.valueOf(numberOfBytes));
    }

    Tebibyte(final BigInteger bytes) {
        super(bytes);
    }

    @Override
    public Tebibyte add(final long bytesToAdd) {
        return new Tebibyte(bytes.add(BigInteger.valueOf(bytesToAdd)));
    }

    @Override
    public Tebibyte add(final StorageUnit<?> storageAmount) {
        return new Tebibyte(bytes.add(storageAmount.bytes));
    }

    @Override
    public Tebibyte divide(final long divisor) {
        return new Tebibyte(bytes.divide(BigInteger.valueOf(divisor)));
    }

    @Override
    public Tebibyte multiply(final long factor) {
        return new Tebibyte(bytes.multiply(BigInteger.valueOf(factor)));
    }

    @Override
    public Tebibyte subtract(final long bytesToSubtract) {
        return new Tebibyte(bytes.subtract(BigInteger.valueOf(bytesToSubtract)));
    }

    @Override
    public Tebibyte subtract(final StorageUnit<?> storageAmount) {
        return new Tebibyte(bytes.subtract(storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_TEBIBYTE;
    }

    @Override
    protected String getSymbol() {
        return "TiB"; //$NON-NLS-1$
    }

}
