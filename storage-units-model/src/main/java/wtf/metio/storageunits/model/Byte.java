/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.model;

import com.google.errorprone.annotations.CheckReturnValue;
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

    Byte(final @NotNull BigInteger numberOfBytes) {
        super(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Byte contains.
     * @return A new Byte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Byte valueOf(final @NotNull BigInteger numberOfBytes) {
        return new Byte(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Byte contains.
     * @return A new Byte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Byte valueOf(final long numberOfBytes) {
        return valueOf(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes the Byte contains.
     * @return A new Byte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Byte valueOf(final @NotNull Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    @CheckReturnValue
    public @NotNull Byte add(final long bytesToAdd) {
        return add(BigInteger.valueOf(bytesToAdd));
    }

    @Override
    public @NotNull Byte add(final @NotNull BigInteger bytesToAdd) {
        return new Byte(bytes.add(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Byte add(final @NotNull StorageUnit<?> storageAmount) {
        return add(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    public @NotNull Byte divide(final long divisor) {
        return divide(BigInteger.valueOf(divisor));
    }

    @Override
    public @NotNull Byte divide(final @NotNull BigInteger divisor) {
        return new Byte(bytes.divide(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Byte multiply(final long factor) {
        return new Byte(bytes.multiply(BigInteger.valueOf(factor)));
    }

    @Override
    public @NotNull Byte multiply(final @NotNull BigInteger factor) {
        return new Byte(bytes.multiply(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Byte subtract(final long bytesToSubtract) {
        return new Byte(bytes.subtract(BigInteger.valueOf(bytesToSubtract)));
    }

    @Override
    public @NotNull Byte subtract(final @NotNull BigInteger bytesToSubtract) {
        return new Byte(bytes.subtract(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Byte subtract(final @NotNull StorageUnit<?> storageAmount) {
        return new Byte(bytes.subtract(storageAmount.bytes));
    }

    @Override
    protected @NotNull BigInteger getNumberOfBytesPerUnit() {
        return BigInteger.ONE;
    }

    @Override
    @CheckReturnValue
    protected @NotNull String getSymbol() {
        return "B";
    }

    @Override
    @CheckReturnValue
    protected @NotNull Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
        return StorageUnits::binaryValueOf;
    }

}
