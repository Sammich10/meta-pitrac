DEPENDS += "openblas"
DEPENDS:remove:class-native = "libgfortran"

# The upstream LAPACK ptest packaging blindly copies ${B}/BLAS and associated test
# inputs. When USE_OPTIMIZED_BLAS=1 is enabled, the project links against the
# external OpenBLAS backend instead of building the bundled BLAS test tree, so the
# BLAS directory is absent and do_install_ptest_base fails with rsync "No such file or directory".
# Disable ptests for this recipe to keep the build working in the optimized BLAS configuration.
PTEST_ENABLED = "0"

EXTRA_OECMAKE += " -DUSE_OPTIMIZED_BLAS=1"

do_install:append () {
	sed -i 's:${RECIPE_SYSROOT}::' ${D}${libdir}/cmake/lapack-${PV}/lapack-config.cmake
}

BBCLASSEXTEND = "native"