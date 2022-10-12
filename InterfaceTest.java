import java.util.Arrays;

interface RemoteControlable {
    static final int VERSION = 1;
    abstract public void turnOn();
    public abstract void turnOff();
    default public void beep() {
        func();
        System.out.println("beep!"); // optional
    }
    private void func() { // 자기 자신에게 쓰려고 private 함수

    }
    static void func_static() { // 전역 함수라고 생각하면 됨

    }
}

interface ScreenCapturable {
    public abstract void capture();
}

interface WiFiRemoteControlable extends RemoteControlable, ScreenCapturable {
// interface는 다중 상속 가능
}

class Test implements WiFiRemoteControlable {

    @Override
    public void turnOn() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void turnOff() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void capture() {
        // TODO Auto-generated method stub
        
    }

}

class MyTV implements RemoteControlable, ScreenCapturable{

    @Override
    public void turnOn() {
        // TODO Auto-generated method stub
        System.out.println("TV is on!");
    }

    @Override
    public void turnOff() {
        // TODO Auto-generated method stub
        System.out.println("TV is off!");
    }

    @Override
    public void capture() {
        // TODO Auto-generated method stub
        
    }
    
}

class MyAircon implements RemoteControlable{

    @Override
    public void turnOn() {
        // TODO Auto-generated method stub
        System.out.println("Aircon is on!");
    }

    @Override
    public void turnOff() {
        // TODO Auto-generated method stub
        System.out.println("Aircon is off!");
    }

}

class MyOldBoiler {

}

class MyNewBoiler extends MyOldBoiler implements RemoteControlable{

    @Override
    public void turnOn() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void turnOff() {
        // TODO Auto-generated method stub
   
    }
}

class MyIntData implements Comparable{
    int value;

    MyIntData(int in) {
        value = in;
    }

    @Override
    public int compareTo(Object o) { // 말도안된다.
        // TODO Auto-generated method stub
        if (o instanceof MyIntData) { // o의 생김새가 MyIntData니??
            MyIntData in = (MyIntData)o;
            return -(value - in.value);
        }
        return 0;
    }
}

public class InterfaceTest {
    static void Welcome(RemoteControlable o) {
        o.turnOn();
    }
    public static void main(String[] args) {
        MyTV a = new MyTV();
        MyAircon b = new MyAircon();

        RemoteControlable [] app = new RemoteControlable[2];
        app[0] = a;
        app[1] = b;
        for (RemoteControlable e : app) {
            e.turnOn();
        }
        Welcome(a);

        int[] arr = {1,5, 2323, 21412, 1543523, 2325};
        Arrays.sort(arr);
        for (int e : arr) {
            System.out.println(e);
        }

        MyIntData[] data = new MyIntData[10];

        for (int i = 0; i < data.length; i++) {
            data[i] = new MyIntData((int)(Math.random()*1000));
        }
        System.out.println("------------------");
        Arrays.sort(data);
        for (MyIntData e : data) {
            System.out.println(e.value);
        }
    }
}
