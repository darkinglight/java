import sun.net.spi.nameservice.dns.DNSNameService;
import java.net.URL;
import java.io.File;
import java.lang.reflect.Method;

public class ClassLoaderDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("ClassLoaderDemo's ClassLoader is " + ClassLoaderDemo.class.getClassLoader());
        System.out.println("DNSNameService's ClassLoader is " + DNSNameService.class.getClassLoader());
        System.out.println("String's ClassLoader is " + String.class.getClassLoader());

        System.out.println("The parent of ClassLoaderDemo's ClassLoader is " + ClassLoaderDemo.class.getClassLoader().getParent());
        System.out.println("The grandparent of ClassLoaderDemo's ClassLoader is " + ClassLoaderDemo.class.getClassLoader().getParent().getParent());

        URL path = new File("data/classloader").toURI().toURL();
        
        DiskClassLoader diskClassLoaderA = new DiskClassLoader(path);
        Class<?> clazzA = diskClassLoaderA.loadClass("BeLoadedClass");
        Method sayA = clazzA.getMethod("say");
        Object instanceA = clazzA.newInstance();
        sayA.invoke(instanceA);
        System.out.println(diskClassLoaderA);
        System.out.println("clazzA@" + clazzA.hashCode());

        System.out.println("=======");

        DiskClassLoader diskClassLoaderB = new DiskClassLoader(path, diskClassLoaderA);
        Class<?> clazzB = diskClassLoaderB.loadClass("BeLoadedClass");
        Method sayB = clazzB.getMethod("say");
        Object instanceB = clazzA.newInstance();
        sayB.invoke(instanceB);
        System.out.println(diskClassLoaderB);
        System.out.println("clazzB@" + clazzB.hashCode());

        System.out.println("=======");

        DiskClassLoader diskClassLoaderC = new DiskClassLoader(path);
        Class<?> clazzC = diskClassLoaderC.loadClass("BeLoadedClass");
        Method sayC = clazzC.getMethod("say");
        Object instanceC = clazzC.newInstance();
        sayC.invoke(instanceC);
        System.out.println(diskClassLoaderC);
        System.out.println("clazzC@" + clazzC.hashCode());

        System.out.println("=======");

        System.out.println("clazzA == clazzB " + (clazzA == clazzB));
        System.out.println("clazzC == clazzB " + (clazzC == clazzB));
    }
}
