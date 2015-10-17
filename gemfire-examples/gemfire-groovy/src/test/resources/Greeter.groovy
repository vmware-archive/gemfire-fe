class Greeter {
    String sayHello(String msg) {
        new Dependency(msg).message
    }
}
