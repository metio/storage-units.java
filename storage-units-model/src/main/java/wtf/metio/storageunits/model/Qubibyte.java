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
 * Qubibyte as specified in ISO IEC 80000-13:2008 (1 Qubibyte = 1 267 650 600 228 229 401 496 703 205 376 Byte).
 */
public final class Qubibyte extends StorageUnit<Qubibyte> {

    @Serial
    private static final long serialVersionUID = 8611754914470986560L;

    private static final int conversionScale = computeFiniteConversionScale(StorageUnit.BYTES_IN_A_QUBIBYTE);

    Qubibyte(final @NotNull BigInteger numberOfBytes) {
        super(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Qubibyte contains.
     * @return A new Qubibyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Qubibyte valueOf(final @NotNull BigInteger numberOfBytes) {
        return new Qubibyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Qubibyte contains.
     * @return A new Qubibyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Qubibyte valueOf(final long numberOfBytes) {
        return valueOf(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes the Qubibyte contains.
     * @return A new Qubibyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Qubibyte valueOf(final @NotNull Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    @CheckReturnValue
    public @NotNull Qubibyte add(final long bytesToAdd) {
        return add(BigInteger.valueOf(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Qubibyte add(final @NotNull BigInteger bytesToAdd) {
        return new Qubibyte(bytes.add(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Qubibyte add(final @NotNull StorageUnit<?> storageAmount) {
        return add(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    public @NotNull Qubibyte divide(final long divisor) {
        return divide(BigInteger.valueOf(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Qubibyte divide(final @NotNull BigInteger divisor) {
        return new Qubibyte(bytes.divide(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Qubibyte multiply(final long factor) {
        return multiply(BigInteger.valueOf(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Qubibyte multiply(final @NotNull BigInteger factor) {
        return new Qubibyte(bytes.multiply(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Qubibyte subtract(final long bytesToSubtract) {
        return subtract(BigInteger.valueOf(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Qubibyte subtract(final @NotNull BigInteger bytesToSubtract) {
        return new Qubibyte(bytes.subtract(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Qubibyte subtract(final @NotNull StorageUnit<?> storageAmount) {
        return subtract(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    public @NotNull BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_QUBIBYTE;
    }

    @Override
    @CheckReturnValue
    protected @NotNull String getSymbol() {
        return "QiB";
    }

    @Override
    @CheckReturnValue
    protected @NotNull Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
        return StorageUnits::binaryValueOf;
    }

    @Override
    protected int conversionScale() {
        return conversionScale;
    }

}
