/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package wtf.metio.storageunits.model;

import java.io.Serial;
import java.math.BigInteger;
import java.util.function.Function;
import edu.umd.cs.findbugs.annotations.CheckReturnValue;
import org.jetbrains.annotations.NotNull;

/**
 * Zettabyte as specified in ISO IEC 80000-13:2008 (1 Zettabyte = 1 000 000 000 000 000 000 000 Byte).
 */
public final class Zettabyte extends StorageUnit<Zettabyte> {

  @Serial
  private static final long serialVersionUID = 8849006574018911826L;

  Zettabyte(@NotNull final BigInteger bytes) {
    super(bytes);
  }

  /**
   * @param numberOfBytes The amount of bytes the Zettabyte contains.
   * @return A new Zettabyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Zettabyte valueOf(@NotNull final BigInteger numberOfBytes) {
    return new Zettabyte(numberOfBytes);
  }

  /**
   * @param numberOfBytes The amount of bytes the Zettabyte contains.
   * @return A new Zettabyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Zettabyte valueOf(final long numberOfBytes) {
    return valueOf(BigInteger.valueOf(numberOfBytes));
  }

  /**
   * @param numberOfBytes The amount of bytes the Zettabyte contains.
   * @return A new Zettabyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Zettabyte valueOf(@NotNull final Long numberOfBytes) {
    return valueOf(numberOfBytes.longValue());
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Zettabyte add(final long bytesToAdd) {
    return add(BigInteger.valueOf(bytesToAdd));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Zettabyte add(@NotNull final BigInteger bytesToAdd) {
    return new Zettabyte(bytes.add(bytesToAdd));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Zettabyte add(@NotNull final StorageUnit<?> storageAmount) {
    return add(storageAmount.bytes);
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Zettabyte divide(final long divisor) {
    return divide(BigInteger.valueOf(divisor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Zettabyte divide(@NotNull final BigInteger divisor) {
    return new Zettabyte(bytes.divide(divisor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Zettabyte multiply(final long factor) {
    return multiply(BigInteger.valueOf(factor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Zettabyte multiply(@NotNull final BigInteger factor) {
    return new Zettabyte(bytes.multiply(factor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Zettabyte subtract(final long bytesToSubtract) {
    return subtract(BigInteger.valueOf(bytesToSubtract));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Zettabyte subtract(@NotNull final BigInteger bytesToSubtract) {
    return new Zettabyte(bytes.subtract(bytesToSubtract));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Zettabyte subtract(@NotNull final StorageUnit<?> storageAmount) {
    return subtract(storageAmount.bytes);
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected BigInteger getNumberOfBytesPerUnit() {
    return BYTES_IN_A_ZETTABYTE;
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected String getSymbol() {
    return "ZB";
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
    return StorageUnits::decimalValueOf;
  }

}
