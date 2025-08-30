SUMMARY = "JSON for Modern C++"
DESCRIPTION = "JSON for Modern C++"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.MIT;md5=3b489645de9825cca5beeb9a7e18b6eb"

SRC_URI = "git://github.com/nlohmann/json.git;protocol=https;branch=master"

SRCREV = "55f93686c01528224f448c19128836e7df245f72"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE = "-DJSON_BuildTests=OFF"

ALLOW_EMPTY:${PN} = "1"
FILES:${PN}-dev = "${includedir}/* ${datadir}/*"