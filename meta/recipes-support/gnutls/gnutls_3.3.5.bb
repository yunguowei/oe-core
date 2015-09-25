require gnutls.inc

SRC_URI += "file://correct_rpl_gettimeofday_signature.patch \
            file://0001-Reset-the-output-value-on-error-in-_gnutls_x509_dn_t.patch \
            file://0001-Better-fix-for-the-double-free-in-dist-point-parsing.patch \
            file://0001-eliminated-double-free-in-the-parsing-of-dist-points.patch \
           "

SRC_URI[md5sum] = "1f396dcf3c14ea67de7243821006d1a2"
SRC_URI[sha256sum] = "48f34ae032692c498e782e9f1369506572be40ecf7f3f3604b0b00bad1b10477"
