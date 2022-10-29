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
 * Megabyte as specified in ISO IEC 80000-13:2008 (1 Megabyte = 1 000 000 Byte).
 */
public final class Megabyte extends StorageUnit<Megabyte> {

    @Serial
    private static final long serialVersionUID = 5901923092058760111L;

    Megabyte(@NotNull final BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Megabyte contains.
     * @return A new Megabyte unit with the given value.
     */
    @NotNull
    @CheckReturnValue
    public static Megabyte valueOf(@NotNull final BigInteger numberOfBytes) {
        return new Megabyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Megabyte contains.
     * @return A new Megabyte unit with the given value.
     */
    @NotNull
    @CheckReturnValue
    public static Megabyte valueOf(final long numberOfBytes) {
        return valueOf(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes the Megabyte contains.
     * @return A new Megabyte unit with the given value.
     */
    @NotNull
    @CheckReturnValue
    public static Megabyte valueOf(@NotNull final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Megabyte add(final long bytesToAdd) {
        return add(BigInteger.valueOf(bytesToAdd));
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Megabyte add(@NotNull final BigInteger bytesToAdd) {
        return new Megabyte(bytes.add(bytesToAdd));
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Megabyte add(@NotNull final StorageUnit<?> storageAmount) {
        return add(storageAmount.bytes);
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Megabyte divide(final long divisor) {
        return divide(BigInteger.valueOf(divisor));
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Megabyte divide(@NotNull final BigInteger divisor) {
        return new Megabyte(bytes.divide(divisor));
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Megabyte multiply(final long factor) {
        return multiply(BigInteger.valueOf(factor));
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Megabyte multiply(@NotNull final BigInteger factor) {
        return new Megabyte(bytes.multiply(factor));
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Megabyte subtract(final long bytesToSubtract) {
        return subtract(BigInteger.valueOf(bytesToSubtract));
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Megabyte subtract(@NotNull final BigInteger bytesToSubtract) {
        return new Megabyte(bytes.subtract(bytesToSubtract));
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Megabyte subtract(@NotNull final StorageUnit<?> storageAmount) {
        return subtract(storageAmount.bytes);
    }

    @Override
    @NotNull
    @CheckReturnValue
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_MEGABYTE;
    }

    @Override
    @NotNull
    @CheckReturnValue
    protected String getSymbol() {
        return "MB";
    }

    @Override
    @NotNull
    @CheckReturnValue
    protected Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
        return StorageUnits::decimalValueOf;
    }

}
