import java.net.URLClassLoader;
import java.net.URL;
import java.net.MalformedURLException;
import java.lang.ClassLoader;

public class DiskClassLoader extends URLClassLoader {
    public DiskClassLoader(URL path) throws MalformedURLException {
        super(new URL[]{path});
    }

    public DiskClassLoader(URL path, ClassLoader parent) throws MalformedURLException {
        super(new URL[]{path}, parent);
    }
}
