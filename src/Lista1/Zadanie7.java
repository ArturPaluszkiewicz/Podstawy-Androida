package Lista1;

import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zadanie7 {

    /*
     * String input - path to input file
     * String output - directory where files will be saved
     *
     * Example:
     * findAndSave(
     * "/home/user/tekst2-dla_opornych.txt",
     * "/home/user/"
     * );
     */
    public static void findAndSave(String input, String output) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(input)));
        ArrayList<String>[] matches = Zadanie7.splitIntegersAndDecimals(Zadanie7.matchNumbers(content));
        String integersOutput = "";
        for (String match : matches[0]) {
            integersOutput += match + "\n";
        }
        String decimalsOutput = "";
        for (String match : matches[1]) {
            decimalsOutput += match + "\n";
        }
        Files.write(Paths.get(output+"integers.txt"), integersOutput.getBytes());
        Files.write(Paths.get(output+"decimals.txt"), decimalsOutput.getBytes());
    }

    private static ArrayList<String> matchNumbers(String text) {
        Pattern pattern = Pattern.compile("(\\d+(,\\d+)*)|(^|\\s)([–\\-+])(\\d+(,\\d+)*)");
        ArrayList<String> matches = new ArrayList<>();
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            matches.add(matcher.group().trim());
        }
        return matches;
    }

    private static ArrayList<String>[] splitIntegersAndDecimals(ArrayList<String> list) {
        ArrayList<String>[] result = new ArrayList[2];
        ArrayList<String> integers = new ArrayList<>();
        ArrayList<String> decimals = new ArrayList<>();
        for (String element : list) {
            String newElement = element.replace(",", ".");
            newElement = newElement.replace("–", "-");
            try {
                Integer.parseInt(newElement);
                integers.add(element);
            } catch (NumberFormatException e) {
                try {
                    Double.parseDouble(newElement);
                    decimals.add(element);
                } catch (NumberFormatException err) {
                    // Neither integer nor double - do nothing
                }
            }
        }
        result[0] = integers;
        result[1] = decimals;
        return result;
    }
}
