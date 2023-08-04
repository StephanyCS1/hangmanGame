import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Initialize sentence for the game
        System.out.println("Ingrese una palabra para adivinar");
        String sentence = sc.nextLine();
        String name = sentence.toLowerCase();
        char [] hangman = new char [name.length()];
        int maxAttempts = 3;

        for (int i = 0; i < name.length(); i++) {
            hangman[i] = '_';
        }
        // ask for the user to enter a character to guess the sentence
        while (maxAttempts > 0){
            System.out.println("Ingrese una letra para ver si la palabra la contiene");
            System.out.println("Intentos restantes: "+ maxAttempts);
            boolean containsLetters = false;
            char letter = sc.nextLine().charAt(0);

            for (int i = 0; i < name.length(); i++) {
                if(name.charAt(i) == letter){
                    hangman[i] = letter;
                    containsLetters = true;
                }
            }
            System.out.println(hangman);
//            Shows the toy hangman figure based on the remaining attempts
            if(!containsLetters){
                maxAttempts--;

                switch (maxAttempts) {
                    case 2 -> {
                        System.out.println("  O / ");
                        System.out.println("/ | ");
                    }
                    case 1 -> {
                        System.out.println("  O / ");
                        System.out.println("/ | ");
                        System.out.println("  | ");
                    }
                    case 0 -> {
                        System.out.println("  O / ");
                        System.out.println("/ | ");
                        System.out.println("  | ");
                        System.out.println(" / / ");
                    }
                    default -> {
                    }
                }
            }
            //Verify if the sentence is the same as the player provided in the first step
            if (new String(hangman).equals(sentence)) {
                System.out.println("¡Felicidades! Has adivinado la palabra: " + sentence);
                break;
            }
//            If have 3 wrongs characters or letters, the game is over
            if (maxAttempts == 0){
                System.out.println("Perdiste la palabra era: " + sentence);
                sc.close();
            }

        }
    }
}