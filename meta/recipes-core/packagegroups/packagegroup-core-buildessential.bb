#
# Copyright (C) 2007 OpenedHand Ltd.
# Copyright (C) 2012 Red Hat, Inc.
#

SUMMARY = "Essential build dependencies"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS_packagegroup-core-buildessential = "\
    autoconf \
    automake \
    binutils \
    cpp \
    gcc \
    g++ \
    gettext \
    make \
    libstdc++ \
    libstdc++-dev \
    libtool \
    pkgconfig \
    "

