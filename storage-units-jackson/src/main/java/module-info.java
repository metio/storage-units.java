/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
/**
 * Module for Jackson support.
 */
@org.jspecify.annotations.NullMarked
module wtf.metio.storageunits.jackson {

    requires wtf.metio.storageunits.model;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires org.jspecify;

}
