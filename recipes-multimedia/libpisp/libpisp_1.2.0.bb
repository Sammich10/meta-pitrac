SUMMARY = "PiSP camera pipeline for libcamera on Raspberry Pi"
DESCRIPTION = "PiSP camera pipeline for libcamera on Raspberry Pi"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "\
    file://LICENSES/BSD-2-Clause.txt;md5=3417a46e992fdf62e5759fba9baef7a7 \
"

SRC_URI = "git://github.com/raspberrypi/libpisp.git;protocol=https;branch=main \
          file://meson_options_${PV}.txt \
         "

SRCREV = "50426319aa1a9ba4672f91977429365ad4e335a2"

S = "${WORKDIR}/git"
B = "${S}/build"

DEPENDS = " \
    cmake-native \
    nlohmann-json \
    glibc \
    "

inherit meson pkgconfig

do_configure:prepend() {
    rm -f ${S}/meson_options.txt
    cp ${WORKDIR}/meson_options_${PV}.txt ${S}/meson_options.txt
}
