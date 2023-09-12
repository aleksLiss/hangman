import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class hangMan {


    public void drowGame(){

        int counterErrors = 0;
        String unknownWord = getUnknownWord();
        System.out.println(getGallow(counterErrors));
        System.out.println("Загаданное слово: " + unknownWord);


    }






    public ArrayList<String> setStorageWords(){

      String words = "Толерантность, эксгумация, либерализм, экспонат," +
                " пышность, скабрёзность, шаловливость, экспозиция, индульгенция," +
                " контрацептив, шкворень, эпиграф, эпитафия, барбекю, жульен," +
                " энцефалопатия, парашютист, импозантность, индифферент," +
                " демультипликатор, педикулёз, выхухоль, россомаха," +
                " сущность, поэтапность, напыщенность, возвышенность," +
                " Кропотливость, гидрокарбонат, поясница," +
                " болтушка, скарабей, калабалык, уныние, талия, стамеска, клозет";

        ArrayList<String> storageWords = new ArrayList<>(Arrays.asList(words.split(", ")));
        return storageWords;
    }

    public String getWordFromStorage(){

        Random index = new Random();
        int lastIndex = setStorageWords().size();
        String word = setStorageWords().get(index.nextInt(0, lastIndex));
        return word.toLowerCase();
    }

    public String getUnknownWord(){

        String wordFromStorage = getWordFromStorage();
        String unknownWord = "";

        for(int i = 0; i < wordFromStorage.length();i++){
            unknownWord += "_";
        }
        return unknownWord;
    }

    public String getGallow(Integer number){
        return setGallow().get(number);
    }

    public HashMap<Integer, String> setGallow(){

        String gallow6 = "----------  \n" +
                         " |       |   \n" +
                         " |      (_)  \n" +
                         " |      _|_  \n" +
                         " |     / | \\\n" +
                         " |       |   \n" +
                         " |      / \\ \n" +
                         " |     /   \\\n" +
                         " |           \n" +
                         "_|___________\n" +
                         "|           | \n";

        String gallow5 = "----------  \n" +
                         " |       |   \n" +
                         " |      (_)  \n" +
                         " |      _|_  \n" +
                         " |     / | \\\n" +
                         " |       |   \n" +
                         " |      / \\ \n" +
                         " |            \n" +
                         " |           \n" +
                         "_|___________\n" +
                         "|           | \n";

        String gallow4 = "----------  \n" +
                         " |       |   \n" +
                         " |      (_)  \n" +
                         " |      _|_  \n" +
                         " |     / | \\\n" +
                         " |       |   \n" +
                         " |            \n" +
                         " |            \n" +
                         " |           \n" +
                         "_|___________\n" +
                         "|           | \n";

        String gallow3 = "----------  \n" +
                         " |       |   \n" +
                         " |      (_)  \n" +
                         " |      _|_  \n" +
                         " |     / | \\\n" +
                         " |            \n" +
                         " |            \n" +
                         " |            \n" +
                         " |           \n" +
                         "_|___________\n" +
                         "|           | \n";

        String gallow2 = "----------  \n" +
                         " |       |   \n" +
                         " |      (_)  \n" +
                         " |      _|_  \n" +
                         " |            \n" +
                         " |            \n" +
                         " |            \n" +
                         " |            \n" +
                         " |           \n" +
                         "_|___________\n" +
                         "|           | \n";

        String gallow1 = "----------  \n" +
                         " |       |   \n" +
                         " |      (_)  \n" +
                         " |            \n" +
                         " |            \n" +
                         " |            \n" +
                         " |            \n" +
                         " |            \n" +
                         " |           \n" +
                         "_|___________\n" +
                         "|           | \n";

        String gallow0 = "----------\n" +
                         " |       |   \n" +
                         " |           \n" +
                         " |           \n" +
                         " |            \n" +
                         " |           \n" +
                         " |           \n" +
                         " |           \n" +
                         " |           \n" +
                         "_|___________\n" +
                         "|           | \n";


        HashMap<Integer, String> storageGallowsMap = new HashMap<>();

        storageGallowsMap.put(0, gallow0);
        storageGallowsMap.put(1, gallow1);
        storageGallowsMap.put(2, gallow2);
        storageGallowsMap.put(3, gallow3);
        storageGallowsMap.put(4, gallow4);
        storageGallowsMap.put(5, gallow5);
        storageGallowsMap.put(6, gallow6);
        return storageGallowsMap;
    }

}
