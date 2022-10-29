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
 * Yottabyte as specified in ISO IEC 80000-13:2008 (1 Yottabyte = 1 000 000 000 000 000 000 000 000 Byte).
 */
public final class Yottabyte extends StorageUnit<Yottabyte> {

  @Serial
  private static final long serialVersionUID = 2482152459842042316L;

  Yottabyte(@NotNull final BigInteger bytes) {
    super(bytes);
  }

  /**
   * @param numberOfBytes The amount of bytes the Yottabyte contains.
   * @return A new Yottabyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Yottabyte valueOf(@NotNull final BigInteger numberOfBytes) {
    return new Yottabyte(numberOfBytes);
  }

  /**
   * @param numberOfBytes The amount of bytes the Yottabyte contains.
   * @return A new Yottabyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Yottabyte valueOf(final long numberOfBytes) {
    return valueOf(BigInteger.valueOf(numberOfBytes));
  }

  /**
   * @param numberOfBytes The amount of bytes the Yottabyte contains.
   * @return A new Yottabyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Yottabyte valueOf(@NotNull final Long numberOfBytes) {
    return valueOf(numberOfBytes.longValue());
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Yottabyte add(final long bytesToAdd) {
    return add(BigInteger.valueOf(bytesToAdd));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Yottabyte add(@NotNull final BigInteger bytesToAdd) {
    return new Yottabyte(bytes.add(bytesToAdd));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Yottabyte add(@NotNull final StorageUnit<?> storageAmount) {
    return add(storageAmount.bytes);
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Yottabyte divide(final long divisor) {
    return divide(BigInteger.valueOf(divisor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Yottabyte divide(@NotNull final BigInteger divisor) {
    return new Yottabyte(bytes.divide(divisor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Yottabyte multiply(final long factor) {
    return multiply(BigInteger.valueOf(factor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Yottabyte multiply(@NotNull final BigInteger factor) {
    return new Yottabyte(bytes.multiply(factor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Yottabyte subtract(final long bytesToSubtract) {
    return subtract(BigInteger.valueOf(bytesToSubtract));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Yottabyte subtract(@NotNull final BigInteger bytesToSubtract) {
    return new Yottabyte(bytes.subtract(bytesToSubtract));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Yottabyte subtract(@NotNull final StorageUnit<?> storageAmount) {
    return subtract(storageAmount.bytes);
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected BigInteger getNumberOfBytesPerUnit() {
    return StorageUnit.BYTES_IN_A_YOTTABYTE;
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected String getSymbol() {
    return "YB";
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
    return StorageUnits::decimalValueOf;
  }

}
