abstract class PairMap {
    protected String keyArray [];
    protected String valueArray [];
    abstract String get(String key);
    abstract void put(String key, String value);

    abstract String delete(String key);
    abstract int length();
}

class Dictionary extends PairMap {
    public int index = 0;
    Dictionary() {
        keyArray = null;
        valueArray = null;
    }

    Dictionary(int n) {
        keyArray = new String[n];
        valueArray = new String[n];
    }
    @Override
    String get(String key) {
        int findIndex = 0;

        for (String k : keyArray) {
            if (k == key) {
                break ;
            }
            findIndex++;
        }
        if (findIndex >= 10) {
            return null;
        }
        return valueArray[findIndex];
    }

    @Override
    void put(String key, String value) {
        for (int i = 0; i < index; i++) {
            if (keyArray[i] == key) {
                valueArray[i] = value;
                return ;
            }
        }
        keyArray[index] = key;
        valueArray[index++] = value;
    }

    @Override
    String delete(String key) {
        int findIndex = 0;
        String tmp = null;

        for (int i = 0; i < index; i++) {
            if (keyArray[i] == key) {
                findIndex = i;
                break ;
            }
        }
        tmp = valueArray[findIndex];
        for (int i = keyArray.length - 2; i >= findIndex; i--) {
            keyArray[i] = keyArray[i + 1];
            valueArray[i] = valueArray[i + 1];
        }
        keyArray[keyArray.length - 1] = null;
        valueArray[valueArray.length - 1] = null;
        index--;
        return tmp;
    }

    @Override
    int length() {
        return index;
    }

}


public class Hw2_2 {
    public static void main(String[] args) {
        Dictionary dic = new Dictionary(10);

        dic.put("황기태", "자바");
        dic.put("이재문", "파이선");
        dic.put("이재문", "C++");
        System.out.println("이재문의 값은 " + dic.get("이재문"));
        System.out.println("황기태의 값은 " + dic.get("황기태"));
        dic.delete("황기태");
        System.out.println("황기태의 값은 " + dic.get("황기태"));
    }
}
