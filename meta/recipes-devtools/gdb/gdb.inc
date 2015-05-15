require gdb-common.inc

inherit gettext

SRC_URI += "file://kill_arm_map_symbols.patch \
            file://gdbserver-cflags-last.diff;striplevel=0 \
            file://renesas-sh-native-support.patch \
            file://include_asm_ptrace.patch \
            file://fix-detection-of-64-bit-PPC-inferior-in-gdbserver.patch \
           "
#LDFLAGS_append = " -s"
#export CFLAGS_append=" -L${STAGING_LIBDIR}"

# cross-canadian must not see this
PACKAGES =+ "gdbserver"
FILES_gdbserver = "${bindir}/gdbserver"
