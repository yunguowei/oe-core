require openssl.inc

# For target side versions of openssl enable support for OCF Linux driver
# if they are available.
DEPENDS += "cryptodev-linux"

CFLAG += "-DHAVE_CRYPTODEV -DUSE_CRYPTODEV_DIGESTS"

LIC_FILES_CHKSUM = "file://LICENSE;md5=f9a8f968107345e0b75aa8c2ecaa7ec8"

export DIRS = "crypto ssl apps engines"
export OE_LDFLAGS="${LDFLAGS}"

SRC_URI += "file://configure-targets.patch \
            file://shared-libs.patch \
            file://oe-ldflags.patch \
            file://engines-install-in-libdir-ssl.patch \
            file://openssl-fix-link.patch \
            file://debian/version-script.patch \
            file://debian/pic.patch \
            file://debian/c_rehash-compat.patch \
            file://debian/ca.patch \
            file://debian/make-targets.patch \
            file://debian/no-rpath.patch \
            file://debian/man-dir.patch \
            file://debian/man-section.patch \
            file://debian/no-symbolic.patch \
            file://debian/debian-targets.patch \
            file://openssl_fix_for_x32.patch \
            file://fix-cipher-des-ede3-cfb1.patch \
            file://openssl-avoid-NULL-pointer-dereference-in-EVP_DigestInit_ex.patch \
            file://openssl-avoid-NULL-pointer-dereference-in-dh_pub_encode.patch \
            file://initial-aarch64-bits.patch \
            file://find.pl \
            file://openssl-fix-des.pod-error.patch \
            file://Makefiles-ptest.patch \
            file://ptest-deps.patch \
            file://run-ptest \
            file://0001-Keep-old-method-in-case-of-an-unsupported-protocol.patch \
            file://0001-Unauthenticated-DH-client-certificate-fix.patch \
            file://0001-Only-allow-ephemeral-RSA-keys-in-export-ciphersuites.patch \
            file://0001-A-memory-leak-can-occur-in-dtls1_buffer_record-if-ei.patch \
            file://0001-Fix-for-CVE-2014-3570.patch \
            file://0001-Fix-crash-in-dtls1_get_record-whilst-in-the-listen-s.patch \
            file://0002-Follow-on-from-CVE-2014-3571.-This-fixes-the-code-th.patch \
            file://0001-ECDH-downgrade-bug-fix.patch \
            file://0001-Fix-various-certificate-fingerprint-issues.patch \
            file://0001-use-correct-function-name.patch \
            file://0001-Return-error-when-a-bit-string-indicates-an-invalid-.patch \
            file://0001-Constify-ASN1_TYPE_cmp-add-X509_ALGOR_cmp.patch \
            file://0001-Check-public-key-is-not-NULL.patch \
            file://0001-Fix-a-failure-to-NULL-a-pointer-freed-on-error.patch \
            file://0002-Fix-a-failure-to-NULL-a-pointer-freed-on-error.patch \
            file://0001-Fix-reachable-assert-in-SSLv2-servers.patch \
            file://0001-Fix-unsigned-signed-warnings.patch \
            file://0001-PKCS-7-avoid-NULL-pointer-dereferences-with-missing-.patch \
            file://0001-Free-up-ADB-and-CHOICE-if-already-initialised.patch \
            file://0001-Fix-ASN1_TYPE_cmp.patch \
            file://0001-Remove-export-ciphers-from-the-DEFAULT-cipher-list.patch \
            file://0002-s_server-Use-2048-bit-DH-parameters-by-default.patch \
            file://0003-dhparam-set-the-default-to-2048-bits.patch \
            file://0004-dhparam-fix-documentation.patch \
            file://0005-Update-documentation-with-Diffie-Hellman-best-practi.patch \
            file://0006-client-reject-handshakes-with-DH-parameters-768-bits.patch \
            file://0001-openssl-CVE-2015-1789.patch \
            file://0002-openssl-CVE-2015-1790.patch \
            file://0003-openssl-CVE-2015-1788.patch \
            file://0004-openssl-CVE-2015-1792.patch \
            file://0005-openssl-CVE-2015-1791.patch \
            file://0006-openssl-bug-fix-for-commit-introduced-for-CVE-2015-1.patch \
            file://0007-openssl-More-ssl_session_dup-fixes-based-on-commit-f.patch \
            file://0001-Fix-PSK-handling.patch \
            file://0002-Fix-leak-with-ASN.1-combine.patch \
            file://0003-Add-PSS-parameter-check.patch \
            file://openssl-CVE-2015-3197.patch \
           "

SRC_URI[md5sum] = "f7175c9cd3c39bb1907ac8bba9df8ed3"
SRC_URI[sha256sum] = "1b60ca8789ba6f03e8ef20da2293b8dc131c39d83814e775069f02d26354edf3"

PACKAGES =+ " \
	${PN}-engines \
	${PN}-engines-dbg \
	"

FILES_${PN}-engines = "${libdir}/ssl/engines/*.so ${libdir}/engines"
FILES_${PN}-engines-dbg = "${libdir}/ssl/engines/.debug"

PARALLEL_MAKE = ""
PARALLEL_MAKEINST = ""

do_configure_prepend() {
  cp ${WORKDIR}/find.pl ${S}/util/find.pl
}
