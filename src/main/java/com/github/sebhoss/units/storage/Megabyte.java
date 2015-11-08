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

import com.github.sebhoss.nullanalysis.Nullsafe;

/**
 * Megabyte as specified in ISO IEC 80000-13:2008.
 */
public class Megabyte extends StorageUnit<Megabyte> {

    private static final long serialVersionUID = 5901923092058760111L;

    /**
     * @param numberOfBytes
     *            The amount of bytes the megabytes contains.
     * @return A new Megabyte unit with the given value.
     */
    public static Megabyte valueOf(final long numberOfBytes) {
        return new Megabyte(Nullsafe.nullsafe(BigInteger.valueOf(numberOfBytes)));
    }

    Megabyte(final BigInteger bytes) {
        super(bytes);
    }

    @Override
    public Megabyte add(final long bytesToAdd) {
        return new Megabyte(Nullsafe.nullsafe(bytes.add(BigInteger.valueOf(bytesToAdd))));
    }

    @Override
    public Megabyte add(final StorageUnit<?> storageAmount) {
        return new Megabyte(Nullsafe.nullsafe(bytes.add(storageAmount.bytes)));
    }

    @Override
    public Megabyte divide(final long divisor) {
        return new Megabyte(Nullsafe.nullsafe(bytes.divide(BigInteger.valueOf(divisor))));
    }

    @Override
    public Megabyte multiply(final long factor) {
        return new Megabyte(Nullsafe.nullsafe(bytes.multiply(BigInteger.valueOf(factor))));
    }

    @Override
    public Megabyte subtract(final long bytesToSubtract) {
        return new Megabyte(Nullsafe.nullsafe(bytes.subtract(BigInteger.valueOf(bytesToSubtract))));
    }

    @Override
    public Megabyte subtract(final StorageUnit<?> storageAmount) {
        return new Megabyte(Nullsafe.nullsafe(bytes.subtract(storageAmount.bytes)));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_MEGABYTE;
    }

    @Override
    protected String getSymbol() {
        return "MB"; //$NON-NLS-1$
    }

}
