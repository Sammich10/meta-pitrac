SUMMARY = "libcamera for Raspberry Pi"

LICENSE = "GPL-2.0-or-later & LGPL-2.1-or-later"

LIC_FILES_CHKSUM = "\
    file://LICENSES/GPL-2.0-or-later.txt;md5=fed54355545ffd980b814dab4a3b312c \
    file://LICENSES/LGPL-2.1-or-later.txt;md5=2a4f4fd2128ea2f65047ee63fbca9f68 \
"

SRC_URI = "git://github.com/raspberrypi/libcamera.git;protocol=https;branch=main \
           file://meson_options_${PV}.txt \
          "
# Version v0.4.0+rpt20250213
SRCREV = "29156679717bec7cc4784aeba3548807f2c27fca"

S = "${WORKDIR}/git"
B = "${S}/build"

DEPENDS = " \
    boost \
    cmake-native \
    python3-pyyaml-native \
    python3-jinja2-native \
    python3-ply-native \
    python3-jinja2-native \
    python3-pybind11-native \
    libpisp \
    libuv \
    elfutils \
    libunwind \
    udev \
    gnutls \
    chrpath-native \
    libevent \
    libyaml \
    openssl \
    tiff \
    qtbase \
    qtbase-native \
    meson \
    glibc \
    gstreamer1.0-plugins-base \
    "

inherit meson pkgconfig python3native

EXTRA_OEMESON = " \
    --buildtype=release \
    -Dpipelines=rpi/vc4,rpi/pisp \
    -Dipas=rpi/vc4,rpi/pisp \
    -Dv4l2=true \
    -Dgstreamer=enabled \
    -Dtest=false \
    -Dlc-compliance=disabled \
    -Dcam=disabled \
    -Dqcam=disabled \
    -Ddocumentation=disabled \
    -Dpycamera=enabled \
"

do_configure:prepend() {
    rm -f ${S}/meson_options.txt
    cp ${WORKDIR}/meson_options_${PV}.txt ${S}/meson_options.txt
}

FILES:${PN} += "${datadir}/* ${libdir}/* "