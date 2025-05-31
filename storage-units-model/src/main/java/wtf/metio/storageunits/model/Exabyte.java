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
 * Exabyte as specified in ISO IEC 80000-13:2008 (1 Exabyte = 1 000 000 000 000 000 000 Byte).
 */
public final class Exabyte extends StorageUnit<Exabyte> {

    @Serial
    private static final long serialVersionUID = 6846441733771841250L;

    private static final int conversionScale = computeFiniteConversionScale(StorageUnit.BYTES_IN_A_EXABYTE);

    Exabyte(final @NotNull BigInteger numberOfBytes) {
        super(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Exabyte contains.
     * @return A new Exabyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Exabyte valueOf(final @NotNull BigInteger numberOfBytes) {
        return new Exabyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes The amount of bytes the Exabyte contains.
     * @return A new Exabyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Exabyte valueOf(final long numberOfBytes) {
        return valueOf(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes The amount of bytes the Exabyte contains.
     * @return A new Exabyte unit with the given value.
     */
    @CheckReturnValue
    public static @NotNull Exabyte valueOf(final @NotNull Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    @CheckReturnValue
    public @NotNull Exabyte add(final long bytesToAdd) {
        return add(BigInteger.valueOf(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Exabyte add(final @NotNull BigInteger bytesToAdd) {
        return new Exabyte(bytes.add(bytesToAdd));
    }

    @Override
    @CheckReturnValue
    public @NotNull Exabyte add(final @NotNull StorageUnit<?> storageAmount) {
        return add(storageAmount.bytes);
    }

    @Override
    @CheckReturnValue
    public @NotNull Exabyte divide(final long divisor) {
        return divide(BigInteger.valueOf(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Exabyte divide(final @NotNull BigInteger divisor) {
        return new Exabyte(bytes.divide(divisor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Exabyte multiply(final long factor) {
        return new Exabyte(bytes.multiply(BigInteger.valueOf(factor)));
    }

    @Override
    @CheckReturnValue
    public @NotNull Exabyte multiply(final @NotNull BigInteger factor) {
        return new Exabyte(bytes.multiply(factor));
    }

    @Override
    @CheckReturnValue
    public @NotNull Exabyte subtract(final long bytesToSubtract) {
        return new Exabyte(bytes.subtract(BigInteger.valueOf(bytesToSubtract)));
    }

    @Override
    @CheckReturnValue
    public @NotNull Exabyte subtract(final @NotNull BigInteger bytesToSubtract) {
        return new Exabyte(bytes.subtract(bytesToSubtract));
    }

    @Override
    @CheckReturnValue
    public @NotNull Exabyte subtract(final @NotNull StorageUnit<?> storageAmount) {
        return new Exabyte(bytes.subtract(storageAmount.bytes));
    }

    @Override
    @CheckReturnValue
    public @NotNull BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_EXABYTE;
    }

    @Override
    @CheckReturnValue
    protected @NotNull String getSymbol() {
        return "EB";
    }

    @Override
    @CheckReturnValue
    protected @NotNull Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
        return StorageUnits::decimalValueOf;
    }

    @Override
    protected int conversionScale() {
        return conversionScale;
    }

}
