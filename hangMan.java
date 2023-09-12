import java.util.*;

public class hangMan {


    public boolean repeatGame(){
        Scanner answer = new Scanner(System.in);
        System.out.println("Хотите сыграть еще раз?\n" + "Ответье да/нет: ");
        if (answer.next().toLowerCase().equals("да")){
            return true;
        }else {
            System.out.println("Увидимся....");
            return false;
        }
    }



    public void gameLoop(){

        setStorageWords();

        int counterErrors = 0;
        String [] words =  getWordFromStorage();
        String word = words[0];
        String unknownWord = words[1];
        ArrayList<String> storageLetters = new ArrayList<>();

        while(counterErrors < 7 && !unknownWord.equals(word)) {
            drowGallow(counterErrors);
            System.out.println("Загаданное слово: " + unknownWord);
            String letter = inputLetter();
            if(storageLetters.contains(letter)){
                System.out.println("Вы уже загадывали эту букву. Повторите ввод.");
            }else {
                if (word.contains(letter)) {
                    char [] unknowWordArray = unknownWord.toCharArray();
                    for(int i = 0; i < word.length(); i++){
                        if(word.charAt(i) == letter.charAt(0)){
                            unknowWordArray[i] = letter.charAt(0);
                    }
                }
                unknownWord = new String(unknowWordArray);
            } else {
                System.out.println("Такой буквы нет в слове!");
                storageLetters.add(letter);
                counterErrors++;
                }
            }
        }

        if(unknownWord.equals(word)){
            System.out.println("Вы выиграли!\n" + "Загаданное слово: " + words[0]);
        }else if(counterErrors > 6){
        System.out.println("Вы проиграли!\n" + "Загаданное слово: " + words[0]);
        }
    }


    public String inputLetter(){

        Scanner inputLetter = new Scanner(System.in);
        System.out.println("Введите букву русского алфавита: ");
        String letter = inputLetter.next().toLowerCase();
        while(true){
            if(!(1072 <= letter.charAt(0) && letter.charAt(0) <= 1103) || letter.length() > 1){
                System.out.println("Некорректная буква. Повторите ввод: ");
                letter = inputLetter.next().toLowerCase();
            }else {
                break;
            }

        }
        return letter;
    }





    public void drowGallow(Integer counterErrors){
        System.out.println(getGallow(counterErrors));
    }






    public String[] getWordFromStorage(){
        Random index = new Random();
        String [] words = new String[2];
        int lastIndex = setStorageWords().size();
        String unknownWord = "";

        String word = setStorageWords().get(index.nextInt(0, lastIndex)).toLowerCase();

        for(int i = 0; i < word.length();i++){
            unknownWord += "_";
        }
        words[0] = word;
        words[1] = unknownWord;
        return words;
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

}

