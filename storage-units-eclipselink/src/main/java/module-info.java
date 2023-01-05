/*
 * SPDX-FileCopyrightText: The Storage-Units Authors
 * SPDX-License-Identifier: 0BSD
 */
/**
 * Module for EclipseLink support.
 */
@org.jspecify.annotations.NullMarked
module wtf.metio.storageunits.eclipselink {

    requires wtf.metio.storageunits.model;
    requires eclipselink;
    requires java.sql;
    requires org.jspecify;

}
