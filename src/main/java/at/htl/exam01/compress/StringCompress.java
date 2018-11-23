package at.htl.exam01.compress;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class StringCompress {

    private static final String FILE_NAME = "sample.txt";

    /**
     * Main-Methode, hier wird das StringCompress-Objekt erstellt
     * und die Methoden des Objekts werden aufgerufen
     *
     * @param args
     */
    public static void main(String[] args) {
        StringCompress sc = new StringCompress();
        String[] text = sc.readFromFile(FILE_NAME);
        sc.print(text);
    }


    /**
     *
     * Sämtliche Zeilen werden aus der Textdatei eingelesen
     * zB 5A
     * Nun wird in das String-Array AAAAA geschrieben
     *
     * Bsp Testdatei
     * 5A
     * 3B
     * 4C
     *
     * ergibt eine String-Array mit 3 Elementen
     * AAAAA
     * BBB
     * CCCC
     *
     * @param fileName
     * @return String-Array mit dem entpacktem Text
     */
    public String[] readFromFile(String fileName) {

        int zeilenanzahl = getNoOfLines(fileName);
        String[] array = new String[zeilenanzahl];
        String help = "";
        String letter = "";
        int zahl = 0;


        try (Scanner scanner = new Scanner(new FileReader(fileName)) ) {


            for (int i = 0; i < array.length; i++) {

                help = scanner.nextLine();
                letter = help.substring(0,1);
                zahl = Integer.parseInt(help.substring(1));
                array[i] = "";

                for (int j = 0; j < zahl; j++) {
                    array[i] += letter;

                }




            }





            } catch (FileNotFoundException e) {
              System.out.println(e.getMessage());


        }



        return array;



    }


    /**
     * Der Inhalt des String-Arrays wird zeilenweise auf der Console ausgegeben
     *
     *
     * @param lines String-Array
     */
    public void print(String[] lines) {

        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }






    }

    /**
     * Die Anzahl der Zeilen der übergebenen Textdatei wird bestimmt
     *
     * @param fileName
     * @return Anzahl der Zeilen in der Textdatei
     */
    public int getNoOfLines(String fileName) {

        int zaehler = 0;

        try (Scanner scanner = new Scanner(new FileReader(fileName))) {
            while(scanner.hasNextLine()) {

                scanner.nextLine();
                zaehler++;


            }
        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }







        return zaehler;
    }
}
