require recipes-core/images/core-image-minimal.bb

SUMMARY = "Image for the PiTrac Raspberry Pi device"

DESCRIPTION = "This image is designed for the PiTrac Raspberry Pi device, providing a minimal setup with essential tools and configurations to run the PiTrac software."

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
                        python3-dev \
                        python3-setuptools \
                        python3-numpy \
                        python3-pickle \
                        libstdc++ \
                        libstdc++-dev \
                        libatomic \
                        libgcc \
                        opencv \
                        tmux \
                        busybox \
                        vim \
                        i2c-tools \
                        net-tools \
                        boost \
                        samba \
                        swig \
                        lgpio \
                        libcamera \
                        rpicam-apps \
                        sqlite3 \
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