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
 * Petabyte as specified in ISO IEC 80000-13:2008 (1 Petabyte = 1 000 000 000 000 000 Byte).
 */
public final class Petabyte extends StorageUnit<Petabyte> {

    @Serial
    private static final long serialVersionUID = 5889808368085688387L;

    Petabyte(final @NotNull BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Petabyte contains.
     * @return A new Petabyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Petabyte valueOf(final @NotNull BigInteger numberOfBytes) {
        return new Petabyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Petabyte contains.
     * @return A new Petabyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Petabyte valueOf(final long numberOfBytes) {
        return valueOf(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes the Petabyte contains.
     * @return A new Petabyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Petabyte valueOf(final @NotNull Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    @CheckReturnValue
    public @NotNull Petabyte add(final long bytesToAdd) {
        return add(BigInteger.valueOf(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Petabyte add(final @NotNull BigInteger bytesToAdd) {
        return new Petabyte(bytes.add(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Petabyte add(final @NotNull StorageUnit<?> storageAmount) {
        return add(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    public @NotNull Petabyte divide(final long divisor) {
        return divide(BigInteger.valueOf(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Petabyte divide(final @NotNull BigInteger divisor) {
        return new Petabyte(bytes.divide(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Petabyte multiply(final long factor) {
        return multiply(BigInteger.valueOf(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Petabyte multiply(final @NotNull BigInteger factor) {
        return new Petabyte(bytes.multiply(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Petabyte subtract(final long bytesToSubtract) {
        return subtract(BigInteger.valueOf(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Petabyte subtract(final @NotNull BigInteger bytesToSubtract) {
        return new Petabyte(bytes.subtract(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Petabyte subtract(final @NotNull StorageUnit<?> storageAmount) {
        return subtract(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    protected @NotNull BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_PETABYTE;
    }

    @Override
    @CheckReturnValue
    protected @NotNull String getSymbol() {
        return "PB";
    }

    @Override
    @CheckReturnValue
    protected @NotNull Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
        return StorageUnits::decimalValueOf;
    }

}
