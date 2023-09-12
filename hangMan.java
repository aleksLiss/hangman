import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class hangMan {



    public void gameLoop(){

        int counterErrors = 0;
        String letter = inputLetter();
        String word =  getWordFromStorage();
        String unknownWord = getUnknownWord();

        drowGame(counterErrors);
        while(counterErrors != 6 || (!unknownWord.contains("_"))) {
            if (word.contains(letter)) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == letter.charAt(0)) {
                        unknownWord = unknownWord.replace(unknownWord.charAt(i), letter.charAt(0));
                        System.out.println(unknownWord);
                    }
                }
                letter = inputLetter();
            } else {
                counterErrors++;
                drowGame(counterErrors);
            }
        }
    }





    public String inputLetter(){

        Scanner inputLetter = new Scanner(System.in);
        System.out.println("Введите букву русского алфавита: ");
        String letter = inputLetter.nextLine().toLowerCase();
        while(true){
            if(!(1072 <= letter.charAt(0) && letter.charAt(0) <= 1103)){
                System.out.println("Некорректная буква. Повторите ввод: ");
                letter = inputLetter.nextLine().toLowerCase();
            }else {
                break;
            }

        }
        return letter;
    }





    public void drowGame(Integer counterErrors){

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
        final String word = setStorageWords().get(index.nextInt(0, lastIndex)).toLowerCase();
        return word;
    }

    public String getUnknownWord(){

        String wordFromStorage = getWordFromStorage();
        String unknownWord = "";

        for(int i = 0; i < wordFromStorage.length();i++){
            unknownWord += "_";
            unknownWord += " ";
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
