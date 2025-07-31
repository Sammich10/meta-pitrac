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
                        opencv \
                        tmux \
                        i2c-tools \
                        net-tools \
                        boost \
                        samba \
                        swig \
                        lgpio \
                        libcamera \
                        libcamera-apps \
                        rpicam-apps \
                        "

TOOLCHAIN_HOST_TASK:append = " \
                            nativesdk-cmake \
                            nativesdk-ninja \
                            nativesdk-protobuf-c \
                            nativesdk-protobuf-compiler \
                            nativesdk-protobuf \
                            nativesdk-python3-modules \
                            nativesdk-ccache \
                            "