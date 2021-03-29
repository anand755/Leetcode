package hacker.earth;

public class One {

    final int num = 10;

    public void display() {
        int num = 12;
        Runnable r = new Runnable() {
            final int num = 15;

            public void run() {
                int num = 20;
                System.out.println(this.num);
            }
        };
        r.run();
    }

    public static void main(String args[]) {
        One sy = new One();
        sy.display();
    }


}
