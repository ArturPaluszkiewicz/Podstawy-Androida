import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Zadanie4 {
	public static void zliczWszystko(String input, String output) throws IOException {
		// Wczytaj zawarto�� jako stringa
		String zawartosc = new String(Files.readAllBytes(Paths.get(input)), "UTF-8");
		zawartosc = zawartosc.substring(1, zawartosc.length());
		System.out.println(zawartosc + "\n");
		// Zlicz znaki bia�e. znaki specjalne, cyfry, sp�g�oski, samog�oski
		// Zapisz wynik do pliku
		int iloscZnakowBialych = 0;
		int iloscZnakowSpecjalnych = 0;
		int iloscCyfr = 0;
		int iloscSpolglosek = 0;
		int iloscSamoglosek = 0;
		for(int i=0;i<zawartosc.length();i++) {
			char znak = zawartosc.charAt(i);
			if ("aeyio��u�".indexOf(znak) != -1){
				iloscSamoglosek++;	
			}
			else if ("bc�dfghjklmnprstwz��".indexOf(znak) != -1) {
				iloscSpolglosek++;
			}
			else if("1234567890".indexOf(znak) != -1) {
				iloscCyfr++;
			}
			else if(Character.isWhitespace(znak)) {
				iloscZnakowBialych++;
			}
			else {
				iloscZnakowSpecjalnych++;
			}
		}
		
				String zliczone = " Biale: " + iloscZnakowBialych + "\n" +
				" Specjalne: " + iloscZnakowSpecjalnych + "\n" +
				" Cyfry: " + iloscCyfr + "\n" +
				" Spolgloski: " + iloscSpolglosek + "\n" +
				" Samogloski: " + iloscSamoglosek + "\n";
		System.out.println(zliczone);
		Files.write(Paths.get(output), zliczone.getBytes());
	}
}
