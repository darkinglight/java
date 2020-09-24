CC=javac

.Phony=all
all: LoadInfo.class MyClassLoader.class MyManager.class ClassLoadTest.class

ClassLoadTest.class: ClassLoadTest.java
	$(CC) $<

MyManager.class: MyManager.java
	$(CC) $<

MyClassLoader.class: MyClassLoader.java
	$(CC) $<

LoadInfo.class: LoadInfo.java
	$(CC) $<

.Phony=clean
clean:
	rm -f *.class
