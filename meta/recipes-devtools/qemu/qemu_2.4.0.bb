require qemu.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=441c28d2cf86e15a37fa47e15a72fbac \
                    file://COPYING.LIB;endline=24;md5=c04def7ae38850e7d3ef548588159913"

SRC_URI += "file://configure-fix-Darwin-target-detection.patch \
            file://qemu-enlarge-env-entry-size.patch \
            file://Qemu-Arm-versatilepb-Add-memory-size-checking.patch \
            file://smc91c111_fix1.patch \
            file://smc91c111_fix2.patch \
            file://smc91c111_fix3.patch \
            file://no-valgrind.patch \
            file://qemu-CVE-2015-5279.patch \
            file://qemu-CVE-2015-5225.patch \
            file://qemu-CVE-2015-6855.patch \
            file://qemu-CVE-2015-7295.patch \
            file://qemu-CVE-2015-7512.patch \
            file://CVE-2015-8504.patch \
            file://CVE-2015-7504.patch \
            file://CVE-2015-8345.patch \
            file://CVE-2016-1568.patch \
            file://CVE-2016-2197.patch \
            file://CVE-2016-2198.patch \
            file://qemu-CVE-2016-2857.patch \
            file://qemu-CVE-2016-2858-1.patch \
            file://qemu-CVE-2016-2858-2.patch \
            file://qemu-CVE-2016-2858-3.patch \
            file://qemu-CVE-2016-2858-4.patch \
            file://qemu-CVE-2015-8558.patch \
            file://qemu-CVE-2016-4001.patch \
            file://qemu-CVE-2016-4002.patch \
            file://qemu-CVE-2016-3710.patch \
            file://vga-add-vbe_enabled-helper.patch \
            file://vga-factor-out-vga-register-setup.patch \
            file://vga-update-vga-register-setup-on-vbe-changes.patch \
            file://qemu-CVE-2016-3712.patch \
            file://vga-add-sr_vbe-register-set.patch \
            file://qemu-CVE-2016-4020.patch \
            file://qemu-CVE-2016-4037.patch \
            file://qemu-CVE-2016-4439.patch \
            file://qemu-CVE-2016-4441.patch \
            file://qemu-CVE-2016-4453.patch \
            file://qemu-CVE-2016-4454-1.patch \
            file://qemu-CVE-2016-4454-2.patch \
            file://qemu-CVE-2016-4454-3.patch \
            file://qemu-CVE-2016-5126.patch \
            file://qemu-CVE-2016-2391.patch \
            file://qemu-CVE-2016-2538.patch \
            file://qemu-CVE-2016-5238.patch \
           "
SRC_URI_prepend = "http://wiki.qemu-project.org/download/${BP}.tar.bz2"
SRC_URI[md5sum] = "186ee8194140a484a455f8e3c74589f4"
SRC_URI[sha256sum] = "72b0b991bbcc540663a019e1e8c4f714053b691dda32c9b9ee80b25f367e6620"

COMPATIBLE_HOST_class-target_mips64 = "null"

do_install_append() {
    # Prevent QA warnings about installed ${localstatedir}/run
    if [ -d ${D}${localstatedir}/run ]; then rmdir ${D}${localstatedir}/run; fi
}
