public class Zadanie8 {

    public void search(String substring, String string){

        String sub;
        for (int index=0;index<string.length()-substring.length();index++){
            sub = string.substring(index, index + substring.length());
            if (sub.matches(substring)) {
                System.out.println("jest");
                return;
            }

        }
        System.out.println("nie ma");
    }
}
