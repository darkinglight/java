public class HelloJni {
    native void hello();

    static {
        System.loadLibrary("HelloJni");
    }

    public static void main(String args[]) {
        HelloJni helloJni = new HelloJni();
        helloJni.hello();
    }
}
