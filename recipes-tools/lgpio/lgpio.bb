SUMMARY = "Install the lgpio library"

LICENSE = "Unlicense"
LIC_FILES_CHKSUM = "file://UNLICENCE;md5=61287f92700ec1bdf13bc86d8228cd13"

SRC_URI = "http://abyz.me.uk/lg/lg.zip;downloadfilename=lg.zip;unpack=1"
SRC_URI[sha256sum] = "bb31c6031b632911a4cbbd1d47ea326f1249b9f9efe1504eca83d1e0ef0394af"

inherit autotools pkgconfig

S = "${WORKDIR}/lg"
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
        "

do_install:append() {
    rm -rf ${D}/opt
}