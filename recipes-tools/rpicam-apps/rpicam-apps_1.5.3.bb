SRC_URI = "git://github.com/raspberrypi/rpicam-apps.git;protocol=https;branch=main \
           file://meson_options.txt \
          "
SRCREV = "50958df98d3cf77b54706a794226d556d649981c"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://license.txt;md5=a0013d1b383d72ba4bdc5b750e7d1d77"

inherit meson pkgconfig

DEPENDS = "libcamera libcamera-apps cmake ffmpeg boost qtbase"
RDEPENDS:${PN} = "libcamera libcamera-apps python3-core qtbase ffmpeg boost"

S = "${WORKDIR}/git"
B = "${S}/build"

do_configure:prepend() {
    rm -f ${S}/meson_options.txt
    cp ${WORKDIR}/meson_options.txt ${S}/meson_options.txt
}

FILES:${PN} += "${bindir} ${libdir}/*.so.* /usr/share/*"
FILES:${PN}-dev += "${includedir} ${libdir}/*.so ${libdir}/rpicam-apps-postproc/*.so"
