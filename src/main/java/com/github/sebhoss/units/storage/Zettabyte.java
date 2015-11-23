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
 * Zettabyte as specified in ISO IEC 80000-13:2008 (1 Zettabyte = 1 000 000 000 000 000 000 000 Byte).
 */
public class Zettabyte extends StorageUnit<Zettabyte> {

    private static final long serialVersionUID = 8849006574018911826L;

    Zettabyte(final BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the zettabyte contains.
     * @return A new Zettabyte unit with the given value.
     */
    public static Zettabyte valueOf(final BigInteger numberOfBytes) {
        return new Zettabyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the zettabytes contains.
     * @return A new Zettabyte unit with the given value.
     */
    public static Zettabyte valueOf(final long numberOfBytes) {
        return new Zettabyte(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the zettabytes contains.
     * @return A new Zettabyte unit with the given value.
     */
    public static Zettabyte valueOf(final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    public Zettabyte add(final long bytesToAdd) {
        return new Zettabyte(bytes.add(BigInteger.valueOf(bytesToAdd)));
    }

    @Override
    public Zettabyte add(final StorageUnit<?> storageAmount) {
        return new Zettabyte(bytes.add(storageAmount.bytes));
    }

    @Override
    public Zettabyte divide(final long divisor) {
        return new Zettabyte(bytes.divide(BigInteger.valueOf(divisor)));
    }

    @Override
    public Zettabyte multiply(final long factor) {
        return new Zettabyte(bytes.multiply(BigInteger.valueOf(factor)));
    }

    @Override
    public Zettabyte subtract(final long bytesToSubtract) {
        return new Zettabyte(bytes.subtract(BigInteger.valueOf(bytesToSubtract)));
    }

    @Override
    public Zettabyte subtract(final StorageUnit<?> storageAmount) {
        return new Zettabyte(bytes.subtract(storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_ZETTABYTE;
    }

    @Override
    protected String getSymbol() {
        return "ZB"; //$NON-NLS-1$
    }

}
