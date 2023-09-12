public class Main {

    public static void main(String[] args) {
        hangMan man = new hangMan();
        man.setStorageWords();
        String w = man.getWordFromStorage();
//        System.out.println(w);
//        man.drowGallow();
//        System.out.println(man.drowGallow(7));
        man.drowGame();
    }
}
