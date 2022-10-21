import java.util.HashMap;
import java.util.Map;

abstract class PairMap {
    protected String keyArray [];
    protected String valueArray [];
    abstract String get(String key);
    abstract void put(String key, String value);

    abstract String delete(String key);
    abstract int length();
}

class Dictionary extends PairMap {
    Map<String, String> hm;
    Dictionary() {
        hm = new HashMap<String, String>();
    }
    @Override
    String get(String key) {
        // TODO Auto-generated method stub
        return key;
    }

    @Override
    void put(String key, String value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    String delete(String key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    int length() {
        // TODO Auto-generated method stub
        return 0;
    }

}


public class Hw2_2 {
    public static void main(String[] args) {

    }
}
