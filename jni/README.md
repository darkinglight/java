Java:
    javac HelloJNI.java
    javah HelloJNI
    java -Djava.library.path=. HelloJNI

Compile:

linux:
    gcc -fPIC -I/usr/lib/jvm/java-11-openjdk-amd64/include -I/usr/lib/jvm/java-11-openjdk-amd64/include/linux -shared -o libhello.so HelloJNI.c
windows:
    gcc -Wl,--add-stdcall-alias -I"D:\Program Files\Java\include" -I"D:\Program Files\Java\include\win32" -shared -o hell o.dll HelloJNI.c

View:
    nm libhello.so | grep say

Reference:
https://blog.csdn.net/createchance/article/details/53783490
