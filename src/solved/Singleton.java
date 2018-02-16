package solved;

public class Singleton {
    private static Singleton singleton=null;
    private static Object mutex = new Object();

    public static Singleton getSingleton() {
        if(singleton==null)
        synchronized (mutex){
            if(singleton==null) singleton= new Singleton();
        }

        return singleton ;
    }
}
