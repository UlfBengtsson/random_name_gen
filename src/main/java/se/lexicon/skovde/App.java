package se.lexicon.skovde;

import se.lexicon.skovde.models.NamesGen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        /*
        File file = new File("lastnames.txt");

        try(Scanner scanFile = new Scanner(file)) {

            String result = scanFile.nextLine();
            String result2 = scanFile.nextLine();

            System.out.println(result + " : " + result2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        */


        for (int i = 0; i < 5; i++) {
            System.out.println(NamesGen.randomFullName());
        }
    }


}
