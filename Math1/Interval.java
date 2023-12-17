package Math1;
public class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int a, int b) {
        start = a;
        end = b;
    }

    public void display() {
        System.out.println(start + "," + end);
    }
}
