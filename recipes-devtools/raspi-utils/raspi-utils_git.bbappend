SRCREV="b8961eb9a689a3c0465db108176d0ee425379730"

OECMAKE_TARGET_COMPILE:append = "\
    piolib/all \
"

OECMAKE_TARGET_INSTALL:append = "\ 
    piolib/install \
"
