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
 * Exabyte as specified in ISO IEC 80000-13:2008 (1 Exabyte = 1 000 000 000 000 000 000 Byte).
 */
public final class Exabyte extends StorageUnit<Exabyte> {

  @Serial
  private static final long serialVersionUID = 6846441733771841250L;

  Exabyte(@NotNull final BigInteger bytes) {
    super(bytes);
  }

  /**
   * @param numberOfBytes The amount of bytes the Exabyte contains.
   * @return A new Exabyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Exabyte valueOf(@NotNull final BigInteger numberOfBytes) {
    return new Exabyte(numberOfBytes);
  }

  /**
   * @param numberOfBytes The amount of bytes the Exabyte contains.
   * @return A new Exabyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Exabyte valueOf(final long numberOfBytes) {
    return valueOf(BigInteger.valueOf(numberOfBytes));
  }

  /**
   * @param numberOfBytes The amount of bytes the Exabyte contains.
   * @return A new Exabyte unit with the given value.
   */
  @NotNull
  @CheckReturnValue
  public static Exabyte valueOf(@NotNull final Long numberOfBytes) {
    return valueOf(numberOfBytes.longValue());
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Exabyte add(final long bytesToAdd) {
    return add(BigInteger.valueOf(bytesToAdd));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Exabyte add(@NotNull final BigInteger bytesToAdd) {
    return new Exabyte(bytes.add(bytesToAdd));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Exabyte add(@NotNull final StorageUnit<?> storageAmount) {
    return add(storageAmount.bytes);
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Exabyte divide(final long divisor) {
    return divide(BigInteger.valueOf(divisor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Exabyte divide(@NotNull final BigInteger divisor) {
    return new Exabyte(bytes.divide(divisor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Exabyte multiply(final long factor) {
    return new Exabyte(bytes.multiply(BigInteger.valueOf(factor)));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Exabyte multiply(@NotNull final BigInteger factor) {
    return new Exabyte(bytes.multiply(factor));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Exabyte subtract(final long bytesToSubtract) {
    return new Exabyte(bytes.subtract(BigInteger.valueOf(bytesToSubtract)));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Exabyte subtract(@NotNull final BigInteger bytesToSubtract) {
    return new Exabyte(bytes.subtract(bytesToSubtract));
  }

  @Override
  @NotNull
  @CheckReturnValue
  public Exabyte subtract(@NotNull final StorageUnit<?> storageAmount) {
    return new Exabyte(bytes.subtract(storageAmount.bytes));
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected BigInteger getNumberOfBytesPerUnit() {
    return StorageUnit.BYTES_IN_A_EXABYTE;
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected String getSymbol() {
    return "EB";
  }

  @Override
  @NotNull
  @CheckReturnValue
  protected Function<@NotNull BigInteger, @NotNull StorageUnit<?>> converter() {
    return StorageUnits::decimalValueOf;
  }

}
