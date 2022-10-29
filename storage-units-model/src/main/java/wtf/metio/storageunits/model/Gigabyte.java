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
 * Gigabyte as specified in ISO IEC 80000-13:2008 (1 Gigabyte = 1 000 000 000 Byte).
 */
public final class Gigabyte extends StorageUnit<Gigabyte> {

  @Serial
  private static final long serialVersionUID = 7581075190529125530L;

  Gigabyte(@NotNull final BigInteger bytes) {
    super(bytes);
  }

  /**
   * @param numberOfBytes The amount of bytes the Gigabyte contains.
   * @return A new Gigabyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Gigabyte valueOf(@NotNull final BigInteger numberOfBytes) {
    return new Gigabyte(numberOfBytes);
  }

  /**
   * @param numberOfBytes The amount of bytes the Gigabyte contains.
   * @return A new Gigabyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Gigabyte valueOf(final long numberOfBytes) {
    return valueOf(BigInteger.valueOf(numberOfBytes));
  }

  /**
   * @param numberOfBytes The amount of bytes the Gigabyte contains.
   * @return A new Gigabyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Gigabyte valueOf(@NotNull final Long numberOfBytes) {
    return valueOf(numberOfBytes.longValue());
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Gigabyte add(final long bytesToAdd) {
    return add(BigInteger.valueOf(bytesToAdd));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Gigabyte add(@NotNull final BigInteger bytesToAdd) {
    return new Gigabyte(bytes.add(bytesToAdd));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Gigabyte add(@NotNull final StorageUnit<?> storageAmount) {
    return add(storageAmount.bytes);
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Gigabyte divide(final long divisor) {
    return divide(BigInteger.valueOf(divisor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Gigabyte divide(@NotNull final BigInteger divisor) {
    return new Gigabyte(bytes.divide(divisor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Gigabyte multiply(final long factor) {
    return multiply(BigInteger.valueOf(factor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Gigabyte multiply(@NotNull final BigInteger factor) {
    return new Gigabyte(bytes.multiply(factor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Gigabyte subtract(final long bytesToSubtract) {
    return subtract(BigInteger.valueOf(bytesToSubtract));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Gigabyte subtract(@NotNull final BigInteger bytesToSubtract) {
    return new Gigabyte(bytes.subtract(bytesToSubtract));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Gigabyte subtract(@NotNull final StorageUnit<?> storageAmount) {
    return subtract(storageAmount.bytes);
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected BigInteger getNumberOfBytesPerUnit() {
    return BYTES_IN_A_GIGABYTE;
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected String getSymbol() {
    return "GB";
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
    return StorageUnits::decimalValueOf;
  }

}
