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
 * Mebibyte as specified in ISO IEC 80000-13:2008 (1 Mebibyte = 1 048 576 Byte).
 */
public final class Mebibyte extends StorageUnit<Mebibyte> {

    /** Generated */
    private static final long serialVersionUID = 7697583678146919524L;

    Mebibyte(final BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the mebibyte contains.
     * @return A new Mebibyte unit with the given value.
     */
    public static Mebibyte valueOf(final BigInteger numberOfBytes) {
        return new Mebibyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the mebibytes contains.
     * @return A new Mebibyte unit with the given value.
     */
    public static Mebibyte valueOf(final long numberOfBytes) {
        return new Mebibyte(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the mebibytes contains.
     * @return A new Mebibyte unit with the given value.
     */
    public static Mebibyte valueOf(final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    public Mebibyte add(final long bytesToAdd) {
        return new Mebibyte(bytes.add(BigInteger.valueOf(bytesToAdd)));
    }

    @Override
    public Mebibyte add(final StorageUnit<?> storageAmount) {
        return new Mebibyte(bytes.add(storageAmount.bytes));
    }

    @Override
    public Mebibyte divide(final long divisor) {
        return new Mebibyte(bytes.divide(BigInteger.valueOf(divisor)));
    }

    @Override
    public Mebibyte multiply(final long factor) {
        return new Mebibyte(bytes.multiply(BigInteger.valueOf(factor)));
    }

    @Override
    public Mebibyte subtract(final long bytesToSubtract) {
        return new Mebibyte(bytes.subtract(BigInteger.valueOf(bytesToSubtract)));
    }

    @Override
    public Mebibyte subtract(final StorageUnit<?> storageAmount) {
        return new Mebibyte(bytes.subtract(storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_MEBIBYTE;
    }

    @Override
    protected String getSymbol() {
        return "MiB"; //$NON-NLS-1$
    }

}