SUMMARY = "Append clock configuration settings to the boot firmware config.txt"

do_deploy:append() {
    sed -i '/#force_turbo=/ c\force_turbo=1' $CONFIG
    echo >> $CONFIG "# Run as fast as firmware/board allows"
    echo >> $CONFIG "arm_boost=1"
}