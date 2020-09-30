import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AOPHandle implements InvocationHandler {
    private Object obj;
    AOPHandle(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("preview proxy");
        Object ret = method.invoke(obj, args);
        System.out.println("post proxy");
        return ret;
    }
}
