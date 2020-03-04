
void onlyMe(Foo f) {
    synchronized(f) {
        doSomething();
    }
}
