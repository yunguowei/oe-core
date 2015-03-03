require xserver-xorg.inc

# Misc build failure for master HEAD
SRC_URI += "file://crosscompile.patch \
            file://fix_open_max_preprocessor_error.patch \
            file://mips64-compiler.patch \
            file://xorg-CVE-2013-6424.patch \
            file://xshmfence-option.patch \
            file://present-module.patch \
            file://0001-render-check-request-size-before-reading-it-CVE-2014.patch \
            file://0002-render-unvalidated-lengths-in-Render-extn.-swapped-p.patch \
            file://0001-randr-unvalidated-lengths-in-RandR-extension-swapped.patch \
            file://0001-unchecked-malloc-may-allow-unauthed-client-to-crash-.patch \
            file://0001-dix-integer-overflow-in-ProcPutImage-CVE-2014-8092-1.patch \
            file://0002-dix-integer-overflow-in-GetHosts-CVE-2014-8092-2-4.patch \
            file://0003-dix-integer-overflow-in-RegionSizeof-CVE-2014-8092-3.patch \
            file://0004-dix-integer-overflow-in-REQUEST_FIXED_SIZE-CVE-2014-.patch \
            file://0005-Missing-parens-in-REQUEST_FIXED_SIZE-macro-CVE-2014-.patch \
            file://0006-dix-GetHosts-bounds-check-using-wrong-pointer-value-.patch \
            file://0001-glx-Be-more-paranoid-about-variable-length-requests-.patch \
            file://0002-glx-Be-more-strict-about-rejecting-invalid-image-siz.patch \
            file://0003-glx-Additional-paranoia-in-__glXGetAnswerBuffer-__GL.patch \
            file://0004-glx-Add-safe_-add-mul-pad-v3-CVE-2014-8093-4-6.patch \
            file://0005-glx-Integer-overflow-protection-for-non-generated-re.patch \
            file://0006-glx-Fix-mask-truncation-in-__glXGetAnswerBuffer-CVE-.patch \
            file://0001-dri2-integer-overflow-in-ProcDRI2GetBuffers-CVE-2014.patch \
            file://0001-Xi-unvalidated-lengths-in-Xinput-extension-CVE-2014-.patch \
            file://0001-xcmisc-unvalidated-length-in-SProcXCMiscGetXIDList-C.patch \
            file://0001-dbe-unvalidated-lengths-in-DbeSwapBuffers-calls-CVE-.patch \
            file://0002-dbe-Call-to-DDX-SwapBuffers-requires-address-of-int-.patch \
           "

SRC_URI[md5sum] = "e4c70262ed89764be8f8f5d699ed9227"
SRC_URI[sha256sum] = "626db6882602ebe1ff81f7a4231c7ccc6ceb5032f2b5b3954bf749e1567221e2"

# These extensions are now integrated into the server, so declare the migration
# path for in-place upgrades.

RREPLACES_${PN} =  "${PN}-extension-dri \
                    ${PN}-extension-dri2 \
                    ${PN}-extension-record \
                    ${PN}-extension-extmod \
                    ${PN}-extension-dbe \
                   "
RPROVIDES_${PN} =  "${PN}-extension-dri \
                    ${PN}-extension-dri2 \
                    ${PN}-extension-record \
                    ${PN}-extension-extmod \
                    ${PN}-extension-dbe \
                   "
RCONFLICTS_${PN} = "${PN}-extension-dri \
                    ${PN}-extension-dri2 \
                    ${PN}-extension-record \
                    ${PN}-extension-extmod \
                    ${PN}-extension-dbe \
                   "
