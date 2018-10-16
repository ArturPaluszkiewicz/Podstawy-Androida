package Lista1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LiczbaZespolona {

    private double wartoscRzeczywista;
    private double wartoscUrojona;

    public LiczbaZespolona(double a, double b) {
        wartoscRzeczywista = a;
        wartoscUrojona = b;
    }

    public static LiczbaZespolona wpisz() {
        System.out.println("Podaj liczbe zespolona:");
        do {
            Scanner scanner = new Scanner(System.in);
            String temp;
            temp = scanner.nextLine();
            Pattern pattern = Pattern.compile("([-?0-9]+)\\+([-?0-9]+)i");
            Matcher matcher = pattern.matcher(temp);
            if (matcher.matches()) {
                double a = Double.parseDouble(matcher.group(1));
                double b = Double.parseDouble(matcher.group(2));
                return new LiczbaZespolona(a, b);
            }
            System.out.println("Zle!!! Sprobuj ponownie.");
        }while(true);
    }

    public void wypisz(){
        System.out.println(this.wartoscRzeczywista+"+"+this.wartoscUrojona+"i");
    }

    public LiczbaZespolona dodaj(LiczbaZespolona z){
        return new LiczbaZespolona(this.wartoscRzeczywista+z.wartoscRzeczywista,this.wartoscUrojona+z.wartoscUrojona);
    }

    public LiczbaZespolona odejmij(LiczbaZespolona z) {
        return new LiczbaZespolona(this.wartoscRzeczywista-z.wartoscRzeczywista,this.wartoscUrojona-z.wartoscUrojona);
    }

    public LiczbaZespolona pomnoz(LiczbaZespolona z) {
        return new LiczbaZespolona(this.wartoscRzeczywista*z.wartoscRzeczywista,this.wartoscUrojona*z.wartoscUrojona);
    }

    public LiczbaZespolona podziel(LiczbaZespolona z) {
        double temp = z.wartoscRzeczywista*z.wartoscRzeczywista+z.wartoscUrojona*z.wartoscUrojona;
        return new LiczbaZespolona((this.wartoscRzeczywista*z.wartoscRzeczywista+this.wartoscUrojona*z.wartoscUrojona)/temp,(this.wartoscUrojona*z.wartoscRzeczywista-this.wartoscRzeczywista*z.wartoscUrojona)/temp);
    }

}