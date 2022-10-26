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
 * Kibibyte as specified in ISO IEC 80000-13:2008 (1 Kibibyte = 1 024 Byte).
 */
public final class Kibibyte extends StorageUnit<Kibibyte> {

  @Serial
  private static final long serialVersionUID = 3798828851496657978L;

  Kibibyte(@NotNull final BigInteger bytes) {
    super(bytes);
  }

  /**
   * @param numberOfBytes The amount of bytes the Kibibyte contains.
   * @return A new Kibibyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Kibibyte valueOf(@NotNull final BigInteger numberOfBytes) {
    return new Kibibyte(numberOfBytes);
  }

  /**
   * @param numberOfBytes The amount of bytes the Kibibyte contains.
   * @return A new Kibibyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Kibibyte valueOf(final long numberOfBytes) {
    return valueOf(BigInteger.valueOf(numberOfBytes));
  }

  /**
   * @param numberOfBytes The amount of bytes the Kibibyte contains.
   * @return A new Kibibyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Kibibyte valueOf(@NotNull final Long numberOfBytes) {
    return valueOf(numberOfBytes.longValue());
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Kibibyte add(final long bytesToAdd) {
    return add(BigInteger.valueOf(bytesToAdd));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Kibibyte add(@NotNull final BigInteger bytesToAdd) {
    return new Kibibyte(bytes.add(bytesToAdd));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Kibibyte add(@NotNull final StorageUnit<?> storageAmount) {
    return add(storageAmount.bytes);
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Kibibyte divide(final long divisor) {
    return divide(BigInteger.valueOf(divisor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Kibibyte divide(@NotNull final BigInteger divisor) {
    return new Kibibyte(bytes.divide(divisor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Kibibyte multiply(final long factor) {
    return multiply(BigInteger.valueOf(factor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Kibibyte multiply(@NotNull final BigInteger factor) {
    return new Kibibyte(bytes.multiply(factor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Kibibyte subtract(final long bytesToSubtract) {
    return subtract(BigInteger.valueOf(bytesToSubtract));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Kibibyte subtract(@NotNull final BigInteger bytesToSubtract) {
    return new Kibibyte(bytes.subtract(bytesToSubtract));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Kibibyte subtract(final StorageUnit<?> storageAmount) {
    return subtract(storageAmount.bytes);
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected BigInteger getNumberOfBytesPerUnit() {
    return StorageUnit.BYTES_IN_A_KIBIBYTE;
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected String getSymbol() {
    return "KiB";
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
    return StorageUnits::binaryValueOf;
  }

}
