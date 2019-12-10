package se.lexicon.skovde.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NamesGen {
    private static List<String> firstFemaleNamesList = readFileToStringList("firstname_female.txt");
    private static List<String> firstMaleNamesList = readFileToStringList("firstname_males.txt");
    private static List<String> lastNamesList = readFileToStringList("lastnames.txt");

    private static Random random = new Random();

    public static String randomFullName()
    {
        if (random.nextBoolean())
        {
            return randomFullFemaleName();
        }
        else
        {
            return  randomFullMaleName();
        }
    }

    public static String randomFullMaleName()
    {
        return randomFirstMaleName() + ' ' + randomLastName() ;
    }
    public static String randomFullFemaleName()
    {
        return randomFirstFemaleName() + ' ' + randomLastName() ;
    }
    public static String randomFirstMaleName()
    {
        return firstMaleNamesList.get(random.nextInt(firstMaleNamesList.size()));
    }
    public static String randomFirstFemaleName()
    {
        return firstFemaleNamesList.get(random.nextInt(firstFemaleNamesList.size()));
    }
    public static String randomLastName()
    {
        return lastNamesList.get(random.nextInt(lastNamesList.size()));
    }

    public static List<String> readFileToStringList(String fileName)
    {
        List<String> stringList = new ArrayList<>();

        File oldFile = new File(fileName);

        try(FileReader reader = new FileReader(oldFile))
        {

            long fileSize = oldFile.length();

            if (fileSize <= Integer.MAX_VALUE){
                char[] text = new char[(int)fileSize];
                reader.read(text);
                StringBuilder commaSeperatedString = new StringBuilder();

                for (char letter : text ) {
                    if (letter == ',')
                    {
                        //System.out.println();
                        stringList.add(commaSeperatedString.toString());
                        commaSeperatedString = new StringBuilder();
                    }
                    else if (letter != '\n' && letter != '\r')
                    {
                        //System.out.print(letter);
                        commaSeperatedString.append(letter);
                    }

                }
                return stringList;
            }
            else {
                System.out.println("File was too big for a Int");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }

    public static List<String> getFirstFemaleNamesList() {
        return firstFemaleNamesList;
    }

    public static void setFirstFemaleNamesList(List<String> firstFemaleNamesList) {
        NamesGen.firstFemaleNamesList = firstFemaleNamesList;
    }

    public static List<String> getFirstMaleNamesList() {
        return firstMaleNamesList;
    }

    public static void setFirstMaleNamesList(List<String> firstMaleNamesList) {
        NamesGen.firstMaleNamesList = firstMaleNamesList;
    }

    public static List<String> getLastNamesList() {
        return lastNamesList;
    }

    public static void setLastNamesList(List<String> lastNamesList) {
        NamesGen.lastNamesList = lastNamesList;
    }
}
