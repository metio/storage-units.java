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
 * Terabyte as specified in ISO IEC 80000-13:2008.
 */
public class Terabyte extends StorageUnit<Terabyte> {

    private static final long serialVersionUID = 2160488069631638952L;

    Terabyte(final BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the terabyte contains.
     * @return A new Kilobyte unit with the given value.
     */
    public static Terabyte valueOf(final BigInteger numberOfBytes) {
        return new Terabyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the terabytes contains.
     * @return A new Terabyte unit with the given value.
     */
    public static Terabyte valueOf(final long numberOfBytes) {
        return new Terabyte(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the terabytes contains.
     * @return A new Terabyte unit with the given value.
     */
    public static Terabyte valueOf(final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    public Terabyte add(final long bytesToAdd) {
        return new Terabyte(bytes.add(BigInteger.valueOf(bytesToAdd)));
    }

    @Override
    public Terabyte add(final StorageUnit<?> storageAmount) {
        return new Terabyte(bytes.add(storageAmount.bytes));
    }

    @Override
    public Terabyte divide(final long divisor) {
        return new Terabyte(bytes.divide(BigInteger.valueOf(divisor)));
    }

    @Override
    public Terabyte multiply(final long factor) {
        return new Terabyte(bytes.multiply(BigInteger.valueOf(factor)));
    }

    @Override
    public Terabyte subtract(final long bytesToSubtract) {
        return new Terabyte(bytes.subtract(BigInteger.valueOf(bytesToSubtract)));
    }

    @Override
    public Terabyte subtract(final StorageUnit<?> storageAmount) {
        return new Terabyte(bytes.subtract(storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_TERABYTE;
    }

    @Override
    protected String getSymbol() {
        return "TB"; //$NON-NLS-1$
    }

}
