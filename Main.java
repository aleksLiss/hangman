public class Main {

    public static void main(String[] args) {
        hangMan man = new hangMan();
        man.gameLoop();
        while (man.repeatGame()){
            man.gameLoop();
        }
    }
}
