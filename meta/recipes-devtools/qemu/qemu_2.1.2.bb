require qemu.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=441c28d2cf86e15a37fa47e15a72fbac \
                    file://COPYING.LIB;endline=24;md5=c04def7ae38850e7d3ef548588159913"

SRC_URI += "file://configure-fix-Darwin-target-detection.patch \
            file://qemu-enlarge-env-entry-size.patch \
            file://Qemu-Arm-versatilepb-Add-memory-size-checking.patch \
            file://qemu-CVE-2014-8106-1.patch \
            file://qemu-CVE-2014-8106-2.patch \
            file://qemu-CVE-2014-7840.patch \
            file://qemu-CVE-2014-7815.patch \
            file://qemu-CVE-2014-3689.patch \
            file://target-ppc-Altivec-s-mtvscr-Decodes-Wrong-Register.patch \
            file://qemu-CVE-2015-2756.patch \
            file://qemu-CVE-2014-9718.patch \
            file://qemu-CVE-2015-3456.patch \
            file://qemu-CVE-2015-4106-1.patch \
            file://qemu-CVE-2015-4106-2.patch \
            file://qemu-CVE-2015-4106-3.patch \
            file://qemu-CVE-2015-4106-4.patch \
            file://qemu-CVE-2015-4106-5.patch \
            file://qemu-CVE-2015-4106-6.patch \
            file://qemu-CVE-2015-4106-7.patch \
            file://qemu-CVE-2015-4106-8.patch \
            file://qemu-CVE-2015-3209-1.patch \
            file://qemu-CVE-2015-3209-2.patch \
            "
SRC_URI_prepend = "http://wiki.qemu-project.org/download/${BP}.tar.bz2"
SRC_URI[md5sum] = "0ff197c4ed4b695620bc4734e77c888f"
SRC_URI[sha256sum] = "fd10f5e45cf5a736fa5a3e1c279ae9821534e700beb7d1aab88a07648a394885"

COMPATIBLE_HOST_class-target_mips64 = "null"
COMPATIBLE_HOST_class-target_mips = "null"

do_install_append() {
    # Prevent QA warnings about installed ${localstatedir}/run
    if [ -d ${D}${localstatedir}/run ]; then rmdir ${D}${localstatedir}/run; fi
}
