public class Foo {
    public int x, y;

    public Foo (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void switcheroo (Foo a, Foo b) {
        Foo temp = a;
        System.out.println(temp.x);
        a = b;
        System.out.println(a.x);
        b = temp;
        System.out.println(b.x);
    }

    public static void fliperoo (Foo a, Foo b) {
        Foo temp = new Foo(a.x, a.y);
        a.x = b.x;
        a.y = b.y;
        b.x = temp.x;
        b.y = temp.y;
    }

    public static void swaperoo (Foo a, Foo b) {
        Foo temp = a;
        a.x = b.x;
        a.y = b.y;
        b.x = temp.x;
        b.y = temp.y;
    }

    public static void main (String[] args) {
        Foo foobar = new Foo(10, 20);
        Foo baz = new Foo(30, 40);
        switcheroo(foobar, baz);
        // System.out.println(foobar.x);
        // System.out.println(foobar.y);
        // System.out.println(baz.x);
        // System.out.println(baz.y);
        fliperoo(foobar, baz);
        // System.out.println(foobar.x);
        // System.out.println(foobar.y);
        // System.out.println(baz.x);
        // System.out.println(baz.y);
        swaperoo(foobar, baz);
        // System.out.println(foobar.x);
        // System.out.println(foobar.y);
        // System.out.println(baz.x);
        // System.out.println(baz.y);
    }
}