package Lista1;

public class Main {

    public static void main(String[] args) {

        Inverse a = new Inverse(3);
        a.show();
        Inverse b = new Inverse(a.invert(a.tab));
        b.show();

//        Zad3 a = new Zad3(3);
//
//        a.show();
//        a.determinant();

        //Zad8 a = new Zad8();
        //a.search("aas", "vccvcvcasvccvcv");
    }
}
