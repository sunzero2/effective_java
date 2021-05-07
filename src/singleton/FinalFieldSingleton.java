package singleton;

public class FinalFieldSingleton {
    public static final FinalFieldSingleton INSTANCE = new FinalFieldSingleton();
    private FinalFieldSingleton() {}
}
