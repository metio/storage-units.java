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
 * Zebibyte as specified in ISO IEC 80000-13:2008 (1 Zebibyte = 1 180 591 620 717 411 303 424 Byte).
 */
public final class Zebibyte extends StorageUnit<Zebibyte> {

  @Serial
  private static final long serialVersionUID = 2192254824473341887L;

  Zebibyte(@NotNull final BigInteger bytes) {
    super(bytes);
  }

  /**
   * @param numberOfBytes The amount of bytes the Zebibyte contains.
   * @return A new Zebibyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Zebibyte valueOf(@NotNull final BigInteger numberOfBytes) {
    return new Zebibyte(numberOfBytes);
  }

  /**
   * @param numberOfBytes The amount of bytes the Zebibyte contains.
   * @return A new Zebibyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Zebibyte valueOf(final long numberOfBytes) {
    return valueOf(BigInteger.valueOf(numberOfBytes));
  }

  /**
   * @param numberOfBytes The amount of bytes the Zebibyte contains.
   * @return A new Zebibyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Zebibyte valueOf(@NotNull final Long numberOfBytes) {
    return valueOf(numberOfBytes.longValue());
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Zebibyte add(final long bytesToAdd) {
    return add(BigInteger.valueOf(bytesToAdd));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Zebibyte add(@NotNull final BigInteger bytesToAdd) {
    return new Zebibyte(bytes.add(bytesToAdd));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Zebibyte add(@NotNull final StorageUnit<?> storageAmount) {
    return add(storageAmount.bytes);
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Zebibyte divide(final long divisor) {
    return divide(BigInteger.valueOf(divisor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Zebibyte divide(@NotNull final BigInteger divisor) {
    return new Zebibyte(bytes.divide(divisor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Zebibyte multiply(final long factor) {
    return multiply(BigInteger.valueOf(factor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Zebibyte multiply(@NotNull final BigInteger factor) {
    return new Zebibyte(bytes.multiply(factor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Zebibyte subtract(final long bytesToSubtract) {
    return subtract(BigInteger.valueOf(bytesToSubtract));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Zebibyte subtract(@NotNull final BigInteger bytesToSubtract) {
    return new Zebibyte(bytes.subtract(bytesToSubtract));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Zebibyte subtract(@NotNull final StorageUnit<?> storageAmount) {
    return subtract(storageAmount.bytes);
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected BigInteger getNumberOfBytesPerUnit() {
    return StorageUnit.BYTES_IN_A_ZEBIBYTE;
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected String getSymbol() {
    return "ZiB";
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
    return StorageUnits::binaryValueOf;
  }

}
