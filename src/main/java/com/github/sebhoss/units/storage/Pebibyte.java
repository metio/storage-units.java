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
 * Pebibyte as specified in ISO IEC 80000-13:2008.
 */
public final class Pebibyte extends StorageUnit<Pebibyte> {

    private static final long serialVersionUID = -6112472064345339882L;

    Pebibyte(final BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the pebibyte contains.
     * @return A new Pebibyte unit with the given value.
     */
    public static Pebibyte valueOf(final BigInteger numberOfBytes) {
        return new Pebibyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the pebibytes contains.
     * @return A new Pebibyte unit with the given value.
     */
    public static Pebibyte valueOf(final long numberOfBytes) {
        return new Pebibyte(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the pebibytes contains.
     * @return A new Pebibyte unit with the given value.
     */
    public static Pebibyte valueOf(final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    public Pebibyte add(final long bytesToAdd) {
        return new Pebibyte(bytes.add(BigInteger.valueOf(bytesToAdd)));
    }

    @Override
    public Pebibyte add(final StorageUnit<?> storageAmount) {
        return new Pebibyte(bytes.add(storageAmount.bytes));
    }

    @Override
    public Pebibyte divide(final long divisor) {
        return new Pebibyte(bytes.divide(BigInteger.valueOf(divisor)));
    }

    @Override
    public Pebibyte multiply(final long factor) {
        return new Pebibyte(bytes.multiply(BigInteger.valueOf(factor)));
    }

    @Override
    public Pebibyte subtract(final long bytesToSubtract) {
        return new Pebibyte(bytes.subtract(BigInteger.valueOf(bytesToSubtract)));
    }

    @Override
    public Pebibyte subtract(final StorageUnit<?> storageAmount) {
        return new Pebibyte(bytes.subtract(storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_PEBIBYTE;
    }

    @Override
    protected String getSymbol() {
        return "PiB"; //$NON-NLS-1$
    }

}
