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
 * Yottabyte as specified in ISO IEC 80000-13:2008 (1 Yottabyte = 1 000 000 000 000 000 000 000 000 Byte).
 */
public final class Yottabyte extends StorageUnit<Yottabyte> {

    @Serial
    private static final long serialVersionUID = 2482152459842042316L;

    Yottabyte(final @NotNull BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Yottabyte contains.
     * @return A new Yottabyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Yottabyte valueOf(final @NotNull BigInteger numberOfBytes) {
        return new Yottabyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Yottabyte contains.
     * @return A new Yottabyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Yottabyte valueOf(final long numberOfBytes) {
        return valueOf(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes the Yottabyte contains.
     * @return A new Yottabyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Yottabyte valueOf(final @NotNull Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    @CheckReturnValue
    public @NotNull Yottabyte add(final long bytesToAdd) {
        return add(BigInteger.valueOf(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Yottabyte add(final @NotNull BigInteger bytesToAdd) {
        return new Yottabyte(bytes.add(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Yottabyte add(final @NotNull StorageUnit<?> storageAmount) {
        return add(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    public @NotNull Yottabyte divide(final long divisor) {
        return divide(BigInteger.valueOf(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Yottabyte divide(final @NotNull BigInteger divisor) {
        return new Yottabyte(bytes.divide(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Yottabyte multiply(final long factor) {
        return multiply(BigInteger.valueOf(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Yottabyte multiply(final @NotNull BigInteger factor) {
        return new Yottabyte(bytes.multiply(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Yottabyte subtract(final long bytesToSubtract) {
        return subtract(BigInteger.valueOf(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Yottabyte subtract(final @NotNull BigInteger bytesToSubtract) {
        return new Yottabyte(bytes.subtract(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Yottabyte subtract(final @NotNull StorageUnit<?> storageAmount) {
        return subtract(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    protected @NotNull BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_YOTTABYTE;
    }

    @Override
    @CheckReturnValue
    protected @NotNull String getSymbol() {
        return "YB";
    }

    @Override
    @CheckReturnValue
    protected @NotNull Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
        return StorageUnits::decimalValueOf;
    }

}
