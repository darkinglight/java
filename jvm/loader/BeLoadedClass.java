public class BeLoadedClass {
    public void say() {
        System.out.println("I'm Loaded by " + this.getClass().getClassLoader());
    }
}
