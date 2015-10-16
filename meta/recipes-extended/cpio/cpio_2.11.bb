include cpio_v2.inc

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=f27defe1e96c2e1ecd4e0c9be8967949"

PR = "r4"

SRC_URI += "file://remove-gets.patch \
            file://0001-Fix-memory-overrun-on-reading-improperly-created-lin.patch \
            file://0002-Bugfix.patch \
            file://0003-Fix-typo.patch \
            file://cpio-CVE-2015-1197.patch \
            file://Fix-symlink-bad-length-test-for-64-bit-architectures.patch \
            file://fix-testcase-symlink-bad-lengths.patch \
        "

SRC_URI[md5sum] = "1112bb6c45863468b5496ba128792f6c"
SRC_URI[sha256sum] = "601b1d774cd6e4cd39416203c91ec59dbd65dd27d79d75e1a9b89497ea643978"

