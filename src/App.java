import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WordManager wordManager = new WordManager();

        while(true) {
            System.out.println("Enter the command(Insert, Load, Replace, Delete, Restore, Print, Exercise, Exit):");
            String inputWord = scanner.nextLine();

            if(inputWord.equals("Insert")) {
                System.out.print("Enter the sentence: ");
                String newSentence = scanner.nextLine();

                if(wordManager.insert(newSentence))
                    System.out.println("Data insertion is completed");
                else
                    System.out.println("No sentence entered");
            }
            
            else if(inputWord.equals("Load")) {
                System.out.print("Enter the file name: ");
                String fileName = scanner.nextLine();

                if(wordManager.load(fileName))
                    System.out.println("File load is completed");
                else
                    System.out.println("File not found");
            }

            else if(inputWord.equals("Replace")) {
                System.out.print("Find what: ");
                String findWord = scanner.nextLine();

                System.out.print("Replace with: ");
                String replaceWord = scanner.nextLine();

                int replacedCount = wordManager.replace(findWord, replaceWord);

                if(replacedCount == 0)
                    System.out.println("Can not find \"" + findWord + "\"");
                else
                    System.out.println(replacedCount + " word(s) are replaced from experience to Test");
            }
            
            else if(inputWord.equals("Delete")) {
                System.out.print("Delete what: ");
                String word = scanner.nextLine();

                int deletedCount = wordManager.delete(word);

                if(deletedCount == 0)
                    System.out.println("Can not find \"" + word + "\"");
                else
                    System.out.println(deletedCount + " word(s) are deleted");
            }
            
            else if(inputWord.equals("Restore")) {
                wordManager.restore();
                System.out.println("original word(s) are restored");
            }
            
            else if(inputWord.equals("Print")) {
                wordManager.print();
            }
            
            else if(inputWord.equals("Exercise")) {
                System.out.print("count of words: ");
                int countOfWord = scanner.nextInt();

                System.out.print("width of line: ");
                int widthOfLine = scanner.nextInt();

                wordManager.runExercise(scanner, countOfWord, widthOfLine);
            }
            
            else if(inputWord.equals("Exit")) {
                scanner.close();
                System.out.println("Program terminates");
                System.exit(0);
            }

            else {
                System.out.println("worng command");
            }
        }
    }
}
