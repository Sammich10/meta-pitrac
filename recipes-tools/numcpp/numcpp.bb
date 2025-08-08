SRC_URI = "git://github.com/dpilger26/NumCpp.git;protocol=https;branch=master"

SRCREV = "7d390df4ae94268e58222278529b22ebae2ee663"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6718843773b3df4eebf31db4a83526da"

S = "${WORKDIR}/git"

DEPENDS = "boost"

inherit cmake pkgconfig

FILES:${PN}-dev += "${datadir}/NumCpp/cmake"