package CHAPTER_III._99Proxy.CGLIB;

public class CGLIBTest {
    public static void main(String[] args) {
        CGLIBService service = new CGLIBService();
        CGLIBHandler handler = new CGLIBHandler(service);
        CGLIBService proxy = (CGLIBService) handler.createProxy();
        proxy.saySomething();
    }
}

