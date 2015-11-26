SUMMARY = "FFmpeg-based GStreamer plug-in"
SECTION = "multimedia"
LICENSE = "GPLv2+ & LGPLv2+ & ( (GPLv2+ & LGPLv2.1+) | (GPLv3+ & LGPLv3+) )"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://ext/libpostproc/gstpostproc.c;beginline=1;endline=18;md5=5896e445e41681324381f5869ee33d38 \
                    file://COPYING.LIB;md5=55ca817ccb7d5b5b66355690e9abc605 \
                    file://ext/ffmpeg/gstffmpeg.h;beginline=1;endline=18;md5=ff65467b0c53cdfa98d0684c1bc240a9 \
                    file://gst-libs/ext/libav/LICENSE;md5=abc3b8cb02856aa7823bbbd162d16232 \
                    file://gst-libs/ext/libav/COPYING.GPLv2;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://gst-libs/ext/libav/COPYING.GPLv3;md5=d32239bcb673463ab874e80d47fae504 \
                    file://gst-libs/ext/libav/COPYING.LGPLv2.1;md5=e344c8fa836c3a41c4cbd79d7bd3a379 \
                    file://gst-libs/ext/libav/COPYING.LGPLv3;md5=e6a600fd5e1d9cbde2d983680233ad02"
LICENSE_FLAGS = "commercial"
HOMEPAGE = "http://www.gstreamer.net/"
DEPENDS = "gstreamer gst-plugins-base zlib bzip2 yasm-native"

inherit autotools pkgconfig

SRC_URI = "http://gstreamer.freedesktop.org/src/${BPN}/${BPN}-${PV}.tar.bz2 \
           file://lower-rank.diff \
           file://configure-fix.patch \
           file://h264_qpel_mmx.patch \
           file://libav_e500mc.patch \
           file://libav_e5500.patch \
           file://gst-ffmpeg-CVE-2013-3674.patch \
           file://0001-avformat-mpegtsenc-Check-data-array-size-in-mpegts_w.patch \
           file://0001-vqavideo-check-chunk-sizes-before-reading-chunks.patch \
           file://0001-avcodec-msrle-use-av_image_get_linesize-to-calculate.patch \
           file://0001-huffyuvdec-Skip-len-0-cases.patch \
           file://0001-huffyuvdec-Check-init_vlc-return-codes.patch \
           file://0001-alsdec-check-block-length.patch \
           file://0001-pgssubdec-check-RLE-size-before-copying.-Fix-out-of-.patch \
           file://0001-atrac3dec-Check-coding-mode-against-channels.patch \
           file://0001-eamad-fix-out-of-array-accesses.patch \
           file://0001-mjpegdec-check-SE.patch \
           file://0001-alac-fix-nb_samples-order-case.patch \
           file://0001-h264-correct-ref-count-check-and-limit-fix-out-of-ar.patch \
           file://0001-roqvideodec-check-dimensions-validity.patch \
           file://0001-aacdec-check-channel-count.patch \
           file://0001-pngdec-filter-dont-access-out-of-array-elements-at-t.patch \
           file://0001-error_concealment-Check-that-the-picture-is-not-in-a.patch \
           file://0001-vp3-fix-oob-read-for-negative-tokens-and-memleaks-on.patch \
           file://0001-vp3-Copy-all-3-frames-for-thread-updates.patch \
           file://0001-h264_sei-Fix-infinite-loop.patch \
           file://0001-avcodec-parser-reset-indexes-on-realloc-failure.patch \
           file://0001-avcodec-rpza-Perform-pointer-advance-and-checks-befo.patch \
           file://gst-ffmpeg-CVE-2013-0855.patch \
           file://0001-qdm2dec-fix-buffer-overflow.patch \
           file://0001-huffyuvdec-check-width-more-completely-avoid-out-of-.patch \
           file://0001-smackerdec-Check-that-the-last-indexes-are-within-th.patch \
           file://0001-avcodec-dsputil-fix-signedness-in-sizeof-comparissio.patch \
           file://0001-error-concealment-initialize-block-index.patch \
           file://0001-qdm2-check-array-index-before-use-fix-out-of-array-a.patch \
           file://0001-lavf-compute-probe-buffer-size-more-reliably.patch \
           file://0001-ffserver-set-oformat.patch \
           file://0001-h264-set-parameters-from-SPS-whenever-it-changes.patch \
           file://0001-h264-skip-error-concealment-when-SPS-and-slices-are-.patch \
           file://0001-avcodec-smc-fix-off-by-1-error.patch \
           file://0002-avcodec-mjpegdec-check-bits-per-pixel-for-changes-si.patch \
           file://0001-avcodec-mmvideo-Bounds-check-2nd-line-of-HHV-Intra-b.patch \
           file://0001-avcodec-pngdec-Check-bits-per-pixel-before-setting-m.patch \
           file://0001-avcodec-tiff-more-completely-check-bpp-bppcount.patch \
           file://0001-avcodec-gifdec-factorize-interleave-end-handling-out.patch \
           file://0001-avcodec-cinepak-fix-integer-underflow.patch \
           file://0001-avcodec-utils-Add-case-for-jv-to-avcodec_align_dimen.patch \
           file://0001-avcodec-rawdec-Check-the-return-code-of-avpicture_ge.patch \
           file://0001-vorbis-refactor-vorbis_residue_decode_internal.patch \
           file://0001-vorbis-simplify-the-inner-loop-in-setup_classifs.patch \
           file://0001-vorbis-fallback-to-normal-division-instead-of-crashi.patch \
           file://0001-vorbisdec-Check-VLC-tables-during-use-instead-of-set.patch \
           file://0001-vorbisdec-propagate-errors-from-setup_classifs.patch \
           file://0001-avcodec-vorbisdec-Fix-off-by-1-error-in-ptns_to_read.patch \
           file://0001-matroskadec-Fix-read-after-free-in-matroska_read_see.patch \
           file://0001-msrle-convert-MS-RLE-decoding-function-to-bytestream.patch \
           file://0001-avcodec-msrledec-restructure-msrle_decode_pal4-based.patch \
           file://0001-bytestream-add-a-new-set-of-bytestream-functions-wit.patch \
           file://0002-add-bytestream2_tell-and-bytestream2_seek-functions.patch \
           file://0003-bytestream-Add-bytestream2-writing-API.patch \
           file://0004-ulti-convert-to-new-bytestream-API.patch \
           file://0005-bytestream-K-R-formatting-cosmetics.patch \
           file://0001-aacsbr-use-a-swap-index-for-the-Y-matrix-rather-than.patch \
           file://0001-aac-Reset-some-state-variables-when-turning-SBR-off.patch \
           file://0001-avcodec-aacsbr-check-that-the-element-type-matches-b.patch \
           file://0001-avcodec-alac-Clear-pointers-in-allocate_buffers.patch \
           file://0001-swscale-utils-Clear-pix-buffers.patch \
           file://0001-avcodec-mjpegdec-Fix-context-fields-becoming-inconsi.patch \
           ${@bb.utils.contains('PACKAGECONFIG', 'libav9', 'file://libav-9.patch', '', d)} \ 
"

SRC_URI[md5sum] = "7f5beacaf1312db2db30a026b36888c4"
SRC_URI[sha256sum] = "76fca05b08e00134e3cb92fa347507f42cbd48ddb08ed3343a912def187fbb62"

PR = "r8"

GSTREAMER_DEBUG ?= "--disable-debug"

FFMPEG_EXTRA_CONFIGURE = "--with-ffmpeg-extra-configure"
# pass --cpu for powerpc. get cpu name by stripping "ppc" or "ppc64"
# from DEFAULTTUNE
FFMPEG_CPU_powerpc = "--cpu=${@d.getVar('DEFAULTTUNE')[3:]}"
FFMPEG_CPU_powerpc64 = "--cpu=${@d.getVar('DEFAULTTUNE')[5:]}"
FFMPEG_EXTRA_CONFIGURE_COMMON_ARG = "--target-os=linux ${FFMPEG_CPU} \
  --cc='${CC}' --as='${CC}' --ld='${CC}' --nm='${NM}' --ar='${AR}' \
  --ranlib='${RANLIB}' \
  ${GSTREAMER_DEBUG}"
FFMPEG_EXTRA_CONFIGURE_COMMON = \
'${FFMPEG_EXTRA_CONFIGURE}="${FFMPEG_EXTRA_CONFIGURE_COMMON_ARG}"'

EXTRA_OECONF = "${FFMPEG_EXTRA_CONFIGURE_COMMON}"

PACKAGECONFIG ??= "external-libav"
PACKAGECONFIG[external-libav] = "--with-system-ffmpeg,,libav"
PACKAGECONFIG[orc] = "--enable-orc,--disable-orc,orc"
PACKAGECONFIG[libav9] = ",,,"

FILES_${PN} += "${libdir}/gstreamer-0.10/*.so"
FILES_${PN}-dbg += "${libdir}/gstreamer-0.10/.debug"
FILES_${PN}-dev += "${libdir}/gstreamer-0.10/*.la"
FILES_${PN}-staticdev += "${libdir}/gstreamer-0.10/*.a"
