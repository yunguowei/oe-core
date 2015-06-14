# note that we allow for us to use data later than our code version
#
DESCRIPTION = "tzcode, timezone zoneinfo utils -- zic, zdump, tzselect"
LICENSE = "PD & BSD"

LIC_FILES_CHKSUM = "file://${WORKDIR}/README;md5=d0ff93a73dd5bc3c6e724bb4343760f6"

SRC_URI =" ftp://ftp.iana.org/tz/releases/tzcode${PV}.tar.gz;name=tzcode \
           ftp://ftp.iana.org/tz/releases/tzdata2015e.tar.gz;name=tzdata"

SRC_URI[tzcode.md5sum] = "d41d8cd98f00b204e9800998ecf8427e"
SRC_URI[tzcode.sha256sum] = "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855"
SRC_URI[tzdata.md5sum] = "36f9056efb432ca945c73397acfce0d4"
SRC_URI[tzdata.sha256sum] = "ffc9b5d38abda8277aa479e3f75aa7668819d0977cd1a0c8ef3b09128334ba6f"

S = "${WORKDIR}"

inherit native

do_install () {
        install -d ${D}${bindir}/
        install -m 755 zic ${D}${bindir}/
        install -m 755 zdump ${D}${bindir}/
        install -m 755 tzselect ${D}${bindir}/
}
