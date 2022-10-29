/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.model;

import edu.umd.cs.findbugs.annotations.CheckReturnValue;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.math.BigInteger;
import java.util.function.Function;

/**
 * Pebibyte as specified in ISO IEC 80000-13:2008 (1 Pebibyte = 1 125 899 906 842 624 Byte).
 */
public final class Pebibyte extends StorageUnit<Pebibyte> {

    @Serial
    private static final long serialVersionUID = -6112472064345339882L;

    Pebibyte(@NotNull final BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Pebibyte contains.
     * @return A new Pebibyte unit with the given value.
     */
    @NotNull
    @CheckReturnValue
    public static Pebibyte valueOf(@NotNull final BigInteger numberOfBytes) {
        return new Pebibyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Pebibyte contains.
     * @return A new Pebibyte unit with the given value.
     */
    @NotNull
    @CheckReturnValue
    public static Pebibyte valueOf(final long numberOfBytes) {
        return valueOf(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes the Pebibyte contains.
     * @return A new Pebibyte unit with the given value.
     */
    @NotNull
    @CheckReturnValue
    public static Pebibyte valueOf(@NotNull final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Pebibyte add(final long bytesToAdd) {
        return add(BigInteger.valueOf(bytesToAdd));
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Pebibyte add(@NotNull final BigInteger bytesToAdd) {
        return new Pebibyte(bytes.add(bytesToAdd));
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Pebibyte add(@NotNull final StorageUnit<?> storageAmount) {
        return add(storageAmount.bytes);
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Pebibyte divide(final long divisor) {
        return divide(BigInteger.valueOf(divisor));
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Pebibyte divide(@NotNull final BigInteger divisor) {
        return new Pebibyte(bytes.divide(divisor));
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Pebibyte multiply(final long factor) {
        return multiply(BigInteger.valueOf(factor));
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Pebibyte multiply(@NotNull final BigInteger factor) {
        return new Pebibyte(bytes.multiply(factor));
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Pebibyte subtract(final long bytesToSubtract) {
        return subtract(BigInteger.valueOf(bytesToSubtract));
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Pebibyte subtract(@NotNull final BigInteger bytesToSubtract) {
        return new Pebibyte(bytes.subtract(bytesToSubtract));
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Pebibyte subtract(@NotNull final StorageUnit<?> storageAmount) {
        return subtract(storageAmount.bytes);
    }

    @Override
    @NotNull
    @CheckReturnValue
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_PEBIBYTE;
    }

    @Override
    @NotNull
    @CheckReturnValue
    protected String getSymbol() {
        return "PiB";
    }

    @Override
    @NotNull
    @CheckReturnValue
    protected Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
        return StorageUnits::binaryValueOf;
    }

}
