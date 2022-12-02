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
 * Gibibyte as specified in ISO IEC 80000-13:2008 (1 Gibibyte = 1 073 741 824 Byte).
 */
public final class Gibibyte extends StorageUnit<Gibibyte> {

    @Serial
    private static final long serialVersionUID = -1104749948510944566L;

    Gibibyte(final @NotNull BigInteger numberOfBytes) {
        super(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Gibibyte contains.
     * @return A new Gibibyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Gibibyte valueOf(final @NotNull BigInteger numberOfBytes) {
        return new Gibibyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Gibibyte contains.
     * @return A new Gibibyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Gibibyte valueOf(final long numberOfBytes) {
        return valueOf(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes the Gibibyte contains.
     * @return A new Gibibyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Gibibyte valueOf(final @NotNull Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    @CheckReturnValue
    public @NotNull Gibibyte add(final long bytesToAdd) {
        return add(BigInteger.valueOf(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Gibibyte add(final @NotNull BigInteger bytesToAdd) {
        return new Gibibyte(bytes.add(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Gibibyte add(final @NotNull StorageUnit<?> storageAmount) {
        return add(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    public @NotNull Gibibyte divide(final long divisor) {
        return divide(BigInteger.valueOf(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Gibibyte divide(final @NotNull BigInteger divisor) {
        return new Gibibyte(bytes.divide(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Gibibyte multiply(final long factor) {
        return multiply(BigInteger.valueOf(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Gibibyte multiply(final @NotNull BigInteger factor) {
        return new Gibibyte(bytes.multiply(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Gibibyte subtract(final long bytesToSubtract) {
        return subtract(BigInteger.valueOf(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Gibibyte subtract(final @NotNull BigInteger bytesToSubtract) {
        return new Gibibyte(bytes.subtract(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Gibibyte subtract(final @NotNull StorageUnit<?> storageAmount) {
        return subtract(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    protected @NotNull BigInteger getNumberOfBytesPerUnit() {
        return BYTES_IN_A_GIBIBYTE;
    }

    @Override
    @CheckReturnValue
    protected @NotNull String getSymbol() {
        return "GiB";
    }

    @Override
    @CheckReturnValue
    protected @NotNull Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
        return StorageUnits::binaryValueOf;
    }

}
