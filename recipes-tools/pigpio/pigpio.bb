SUMMARY = "PiGPIO library for Raspberry Pi"

LICENSE = "Unlicense"
LIC_FILES_CHKSUM = "file://UNLICENCE;md5=61287f92700ec1bdf13bc86d8228cd13"

SRC_URI = "https://github.com/joan2937/pigpio/archive/master.zip;"
SRC_URI[sha256sum] = "cabc41a726102d6b74623c8c276e65c1d110dbea7b6f83de9bda490a6e89b499"

inherit autotools pkgconfig

S = "${WORKDIR}/pigpio-master"
B = "${S}"

DEPENDS_${PN} = " native-unzip"

CFLAGS += " -fPIC"
EXTRA_OEMAKE = " \
        CROSS_PREFIX=aarch64-pitrac-linux- \
        CC="${CC}" \
        CXX="${CXX}" \
        LD="${LD}" \
        AR="${AR}" \
        RANLIB="${RANLIB}" \
        CFLAGS="${CFLAGS}" \
        CXXFLAGS="${CXXFLAGS}" \
        LDFLAGS="${LDFLAGS}" \
        STRIP=true \
        DESTDIR=${D} \
        prefix=/usr \
        "

TARGET_CC_ARCH = "${LDFLAGS}"

do_install:append() {
    # Move man pages to standard location
    if [ -d ${D}/usr/man ]; then
        install -d ${D}${mandir}
        mv ${D}/usr/man/* ${D}${mandir}/
        rmdir ${D}/usr/man
    fi

    rm -rf ${D}/opt
    rm -rf ${D}/tmp
}

FILES:${PN} += "/usr/man"