public class ClassLoadTest {
    public static void main(String[] args) {
        new Thread(new MsgHandle()).start();
        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
