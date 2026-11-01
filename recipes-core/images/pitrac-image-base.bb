require recipes-core/images/core-image-base.bb

SUMMARY = "Image for the PiTrac Raspberry Pi device"

DESCRIPTION = "This image is designed for the PiTrac Raspberry Pi device, providing a minimal setup with essential tools and configurations to run the PiTrac software."

# In your image recipe, add a post-install script
ROOTFS_POSTPROCESS_COMMAND += "set_default_locale; "

set_default_locale() {
    echo 'LANG=en_US.UTF-8' >> ${IMAGE_ROOTFS}/etc/environment
    echo 'LC_ALL=en_US.UTF-8' >> ${IMAGE_ROOTFS}/etc/environment
}

IMAGE_FEATURES:append = " \
                        allow-root-login \
                        allow-empty-password \
                        package-management \
                        "

IMAGE_INSTALL:append = " \
                        openssh \
                        git \
                        python3 \
                        python3-pip \
                        python3-opencv \
                        python3-setuptools \
                        python3-numpy \
                        python3-pickle \
                        libstdc++ \
                        libatomic \
                        libgcc \
                        glibc \
                        opencv \
                        opencv-staticdev \
                        rpidistro-ffmpeg \
                        libavcodec \
                        libavdevice \
                        libavfilter \
                        libavformat \
                        libavresample \
                        libavutil \
                        libpostproc \
                        libswresample \
                        libswscale \
                        tmux \
                        busybox \
                        vim \
                        i2c-tools \
                        media-ctl \
                        v4l-utils \
                        net-tools \
                        boost \
                        samba \
                        swig \
                        lgpio \
                        libcamera-rpi \
                        libpisp \
                        rpicam-apps \
                        raspi-gpio \
                        pigpio \
                        mjpg-streamer \
                        raspi-utils \
                        sqlite3 \
                        jsoncpp \
                        zeromq \
                        glibc-utils \
                        localedef \
                        lapack \
                        openblas \
                        "

TOOLCHAIN_TARGET_TASK:append = " \
                        make \
                        ninja \
                        cmake \
                        protobuf-c \
                        protobuf-compiler \
                        protobuf \
                        ccache \
                        automake \
                        autoconf \
                        binutils \
                        binutils-symlinks \
                        cpp \
                        cpp-symlinks \
                        dos2unix \
                        git \
                        gcc \
                        gcc-symlinks \
                        g++ \
                        g++-symlinks \
                        libstdc++ \
                        libstdc++-dev \
                        libgcc \
                        libatomic \
                        pkgconfig \
                        zeromq-dev \
                        cppzmq-dev \
                        msgpack-cpp-dev \
                        rpicam-apps-dev \
                        libpisp-dev \
                        googletest \
                        googletest-dev \
                        libcamera-rpi-dev \
                        glibc-dev \
                        numcpp-dev \
                        libstdc++-dev \
                        python3-dev \
                        lapack-dev \
                        openblas-dev \
                        "

TOOLCHAIN_HOST_TASK:append = " \
                        nativesdk-make \
                        nativesdk-ninja \
                        nativesdk-cmake \
                        nativesdk-protobuf-c \
                        nativesdk-protobuf-compiler \
                        nativesdk-protobuf \
                        nativesdk-ccache \
                        nativesdk-automake \
                        nativesdk-autoconf \
                        nativesdk-binutils \
                        nativesdk-binutils-symlinks \
                        nativesdk-cpp \
                        nativesdk-cpp-symlinks \
                        nativesdk-dos2unix \
                        nativesdk-git \
                        nativesdk-gcc \
                        nativesdk-gcc-symlinks \
                        nativesdk-g++ \
                        nativesdk-g++-symlinks \
                        nativesdk-libstdc++ \
                        nativesdk-libstdc++-dev \
                        nativesdk-libgcc \
                        nativesdk-libatomic \
                        nativesdk-pkgconfig \
                        nativesdk-glibc-utils \
                            "