/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
package wtf.metio.storageunits.model;

import java.io.Serial;
import java.math.BigInteger;
import java.util.function.Function;
import edu.umd.cs.findbugs.annotations.CheckReturnValue;
import org.jetbrains.annotations.NotNull;

/**
 * Petabyte as specified in ISO IEC 80000-13:2008 (1 Petabyte = 1 000 000 000 000 000 Byte).
 */
public final class Petabyte extends StorageUnit<Petabyte> {

  @Serial
  private static final long serialVersionUID = 5889808368085688387L;

  Petabyte(@NotNull final BigInteger bytes) {
    super(bytes);
  }

  /**
   * @param numberOfBytes The amount of bytes the Petabyte contains.
   * @return A new Petabyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Petabyte valueOf(@NotNull final BigInteger numberOfBytes) {
    return new Petabyte(numberOfBytes);
  }

  /**
   * @param numberOfBytes The amount of bytes the Petabyte contains.
   * @return A new Petabyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Petabyte valueOf(final long numberOfBytes) {
    return valueOf(BigInteger.valueOf(numberOfBytes));
  }

  /**
   * @param numberOfBytes The amount of bytes the Petabyte contains.
   * @return A new Petabyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Petabyte valueOf(@NotNull final Long numberOfBytes) {
    return valueOf(numberOfBytes.longValue());
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Petabyte add(final long bytesToAdd) {
    return add(BigInteger.valueOf(bytesToAdd));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Petabyte add(@NotNull final BigInteger bytesToAdd) {
    return new Petabyte(bytes.add(bytesToAdd));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Petabyte add(@NotNull final StorageUnit<?> storageAmount) {
    return add(storageAmount.bytes);
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Petabyte divide(final long divisor) {
    return divide(BigInteger.valueOf(divisor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Petabyte divide(@NotNull final BigInteger divisor) {
    return new Petabyte(bytes.divide(divisor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Petabyte multiply(final long factor) {
    return multiply(BigInteger.valueOf(factor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Petabyte multiply(@NotNull final BigInteger factor) {
    return new Petabyte(bytes.multiply(factor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Petabyte subtract(final long bytesToSubtract) {
    return subtract(BigInteger.valueOf(bytesToSubtract));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Petabyte subtract(@NotNull final BigInteger bytesToSubtract) {
    return new Petabyte(bytes.subtract(bytesToSubtract));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Petabyte subtract(@NotNull final StorageUnit<?> storageAmount) {
    return subtract(storageAmount.bytes);
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected BigInteger getNumberOfBytesPerUnit() {
    return StorageUnit.BYTES_IN_A_PETABYTE;
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected String getSymbol() {
    return "PB";
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
    return StorageUnits::decimalValueOf;
  }

}
