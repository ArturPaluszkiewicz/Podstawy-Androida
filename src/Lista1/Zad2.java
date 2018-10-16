package android1;

import java.util.Scanner;

//2. Należy napisać program do obliczania pierwiastka zadanego równania nieliniowego na zadanym przedziale
//metodą bisekcji z zadaną dokładnością i liczbą iteracji;
//https://chem.pg.edu.pl/documents/175260/14212622/smo_sem_014.pdf
public class Zad2 {

    int firstValue, firstPotency, secondValue, secondPotency, thirdValue, index;

    public void read() {
        if (this.index == 0) {
            System.out.println("Zadanie 2.");
        }

        Scanner scanIn = new Scanner(System.in);
        showFinalResult();
        System.out.println("Wpisywana wartość oznaczona gwiazdką (*): " + showEditValue());
        addValue(scanIn.nextInt());

        scanIn.close();
    }

    private void showFinalResult() {
        System.out.println("Wprowadź dane do następującego schematu: []x^[] + []x^[] + [], gdzie [] to podawana wartość.");
    }

    private void generateCurrentSchemat() {
        String firstValue, firstPotency, secondValue, secondPotency, thirdValue;
        firstValue = checkValue(this.firstValue);
        firstPotency = checkValue(this.firstPotency);
        secondValue = checkValue(this.secondValue);
        secondPotency = checkValue(this.secondPotency);
        thirdValue = checkValue(this.thirdValue);

        System.out.println("Aktualne wartości: " + firstValue + "x^" + firstPotency + " + " + secondValue + "x^" + secondPotency + " + " + thirdValue);
    }

    private String checkValue(int value) {
        if (value == 0) {
            return "[]";
        } else {
            return Integer.toString(value);
        }
    }

    private String showEditValue() {
        String valueToReturn = "no valid data";
        if (this.firstValue == 0 && this.firstPotency == 0) {
            valueToReturn = "[*]x^[] + []x^[] + []";
        } else if (this.firstValue != 0 && this.firstPotency == 0) {
            valueToReturn = "[]x^[*] + []x^[] + []";
        } else if (this.firstPotency != 0 && this.secondValue == 0) {
            valueToReturn = "[]x^[] + [*]x^[] + []";
        } else if (this.secondValue != 0 && this.secondPotency == 0) {
            valueToReturn = "[]x^[] + []x^[*] + []";
        } else if (this.secondPotency == 0 && this.thirdValue == 0) {
            valueToReturn = "[]x^[] + []x^[] + [*]";
        }
        return valueToReturn;
    }

    private void addValue(int value) {
        if (this.index < 5) {
            switch (this.index) {
                case 0:
                    this.firstValue = value;
                    nextIteration();
                    break;
                case 1:
                    this.firstPotency = value;
                    nextIteration();
                    break;
                case 2:
                    this.secondValue = value;
                    nextIteration();
                    break;
                case 3:
                    this.secondPotency = value;
                    nextIteration();
                    break;
                case 4:
                    this.thirdValue = value;
                    count();
                    break;
                default:
                    System.err.println("Incorrect index!");
            }
        }
    }

    private void nextIteration() {
        generateCurrentSchemat();
        this.index++;
        read();
    }

    private void count() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
        generateCurrentSchemat();
    }
}
