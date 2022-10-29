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
 * Byte as specified in ISO IEC 80000-13:2008 (1 Byte).
 */
public final class Byte extends StorageUnit<Byte> {

    @Serial
    private static final long serialVersionUID = 6952239416014811456L;

    Byte(@NotNull final BigInteger numberOfBytes) {
        super(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Byte contains.
     * @return A new Byte unit with the given value.
     */
    @NotNull
    @CheckReturnValue
    public static Byte valueOf(@NotNull final BigInteger numberOfBytes) {
        return new Byte(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Byte contains.
     * @return A new Byte unit with the given value.
     */
    @NotNull
    @CheckReturnValue
    public static Byte valueOf(final long numberOfBytes) {
        return valueOf(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes the Byte contains.
     * @return A new Byte unit with the given value.
     */
    @NotNull
    @CheckReturnValue
    public static Byte valueOf(@NotNull final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Byte add(final long bytesToAdd) {
        return add(BigInteger.valueOf(bytesToAdd));
    }

    @Override
    public @NotNull Byte add(@NotNull final BigInteger bytesToAdd) {
        return new Byte(bytes.add(bytesToAdd));
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Byte add(@NotNull final StorageUnit<?> storageAmount) {
        return add(storageAmount.bytes);
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Byte divide(final long divisor) {
        return divide(BigInteger.valueOf(divisor));
    }

    @Override
    public @NotNull Byte divide(@NotNull final BigInteger divisor) {
        return new Byte(bytes.divide(divisor));
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Byte multiply(final long factor) {
        return new Byte(bytes.multiply(BigInteger.valueOf(factor)));
    }

    @Override
    public @NotNull Byte multiply(@NotNull final BigInteger factor) {
        return new Byte(bytes.multiply(factor));
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Byte subtract(final long bytesToSubtract) {
        return new Byte(bytes.subtract(BigInteger.valueOf(bytesToSubtract)));
    }

    @Override
    public @NotNull Byte subtract(@NotNull final BigInteger bytesToSubtract) {
        return new Byte(bytes.subtract(bytesToSubtract));
    }

    @Override
    @NotNull
    @CheckReturnValue
    public Byte subtract(@NotNull final StorageUnit<?> storageAmount) {
        return new Byte(bytes.subtract(storageAmount.bytes));
    }

    @Override
    @NotNull
    protected BigInteger getNumberOfBytesPerUnit() {
        return BigInteger.ONE;
    }

    @Override
    @NotNull
    @CheckReturnValue
    protected String getSymbol() {
        return "B";
    }

    @Override
    @NotNull
    @CheckReturnValue
    protected Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
        return StorageUnits::binaryValueOf;
    }

}
