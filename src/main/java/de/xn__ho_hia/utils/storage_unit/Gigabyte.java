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
package de.xn__ho_hia.utils.storage_unit;

import java.math.BigInteger;

/**
 * Gigabyte as specified in ISO IEC 80000-13:2008 (1 Gigabyte = 1 000 000 000 Byte).
 */
public class Gigabyte extends StorageUnit<Gigabyte> {

    private static final long serialVersionUID = 7581075190529125530L;

    Gigabyte(final BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the gigabyte contains.
     * @return A new Gigabyte unit with the given value.
     */
    public static Gigabyte valueOf(final BigInteger numberOfBytes) {
        return new Gigabyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the gigabytes contains.
     * @return A new Gigabyte unit with the given value.
     */
    public static Gigabyte valueOf(final long numberOfBytes) {
        return new Gigabyte(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the gigabytes contains.
     * @return A new Gigabyte unit with the given value.
     */
    public static Gigabyte valueOf(final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    public Gigabyte add(final long bytesToAdd) {
        return new Gigabyte(bytes.add(BigInteger.valueOf(bytesToAdd)));
    }

    @Override
    public Gigabyte add(final StorageUnit<?> storageAmount) {
        return new Gigabyte(bytes.add(storageAmount.bytes));
    }

    @Override
    public Gigabyte divide(final long divisor) {
        return new Gigabyte(bytes.divide(BigInteger.valueOf(divisor)));
    }

    @Override
    public Gigabyte multiply(final long factor) {
        return new Gigabyte(bytes.multiply(BigInteger.valueOf(factor)));
    }

    @Override
    public Gigabyte subtract(final long bytesToSubtract) {
        return new Gigabyte(bytes.subtract(BigInteger.valueOf(bytesToSubtract)));
    }

    @Override
    public Gigabyte subtract(final StorageUnit<?> storageAmount) {
        return new Gigabyte(bytes.subtract(storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_GIGABYTE;
    }

    @Override
    protected String getSymbol() {
        return "GB"; //$NON-NLS-1$
    }

}
