public class ManSayHelloWorld implements ISayHelloWorld {
    @Override
    public String say() {
        System.out.println("Hello World!");
        return "MAN";
    }
}
