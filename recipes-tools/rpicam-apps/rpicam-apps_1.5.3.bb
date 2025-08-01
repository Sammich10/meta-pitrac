SRC_URI = "git://github.com/raspberrypi/rpicam-apps.git;protocol=https;branch=main \
           file://meson_options.txt \
          "
SRCREV = "50958df98d3cf77b54706a794226d556d649981c"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://license.txt;md5=a0013d1b383d72ba4bdc5b750e7d1d77"

inherit meson pkgconfig

DEPENDS = "libcamera cmake ffmpeg boost qtbase opencv"
RDEPENDS:${PN} = "libcamera python3-core qtbase ffmpeg boost opencv"

S = "${WORKDIR}/git"
B = "${S}/build"

do_configure:prepend() {
    rm -f ${S}/meson_options.txt
    cp ${WORKDIR}/meson_options.txt ${S}/meson_options.txt
}

do_install:append(){
    # Find all .so files in the installation directory
    find ${D}${libdir}/rpicam-apps-postproc -type f -name "*.so" | xargs -I{} mv {} {}.1.5.3
    find ${D}${libdir}/rpicam-apps-postproc -type f | grep '\.so.1.5.3' | sed 's/\.1.5.3//g' | xargs -I{} ln -sr {}.1.5.3 {}
    chrpath -d ${D}${libdir}/rpicam-apps-postproc/*.so.1.5.3
}

FILES:${PN} += "${bindir} ${libdir}/*.so.* ${libdir}/rpicam-apps-postproc/*.so.* /usr/share/*"
FILES:${PN}-dev += "${includedir} ${libdir}/*.so ${libdir}/rpicam-apps-postproc/*.so"
