SUMMARY = "File classification tool"
DESCRIPTION = "File attempts to classify files depending \
on their contents and prints a description if a match is found."
HOMEPAGE = "http://www.darwinsys.com/file/"
SECTION = "console/utils"

# two clause BSD
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;beginline=2;md5=6a7382872edb68d33e1a9398b6e03188"

DEPENDS = "zlib file-native"
DEPENDS_class-native = "zlib-native"

SRC_URI = "ftp://ftp.astron.com/pub/file/file-${PV}.tar.gz \
           file://debian-742262.patch \
           file://file-recursion-issues.patch \
           file://file-avoid-excessive-processing.patch \
           file://file-stop-reporting-bad-capabilities-after-the-first-few.patch \
           file://adjust-limits-better.patch \
           file://bump-recursion.patch \
           file://do-not-bail-if-there-was-no-error.patch \
           file://kill--R-and-replace-with--P.patch \
           file://add-a-limit-to-the-number-of-times.patch \
           file://remove-name-recursion-limit.patch \
           file://fix-parameter-options.patch \
           file://put-the-changes-in-the-original-file.patch \
           file://add-a-limit-to-the-number.patch \
           file://file-limit-string-printing-to-100-chars.patch \
          "

SRC_URI[md5sum] = "d420d8f2990cd344673acfbf8d76ff5a"
SRC_URI[sha256sum] = "6519fb706d583231c2419592ebecdbb21d33c62eaf7a1a0b24ddfcb80c08bf07"

inherit autotools

FILES_${PN} += "${datadir}/misc/*.mgc"

do_install_append_class-native() {
	create_cmdline_wrapper ${D}/${bindir}/file \
		--magic-file ${datadir}/misc/magic.mgc
}

do_install_append_class-nativesdk() {
	create_cmdline_wrapper ${D}/${bindir}/file \
		--magic-file ${datadir}/misc/magic.mgc
}

BBCLASSEXTEND = "native nativesdk"
