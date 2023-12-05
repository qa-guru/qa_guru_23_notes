package guru.qa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.util.Arrays.asList;

public class OldMain {

  public static void main(String[] args) {


    Map<String, String> users = Map.of(
        "dima", "12345",
        "valentin", "54321"
    );

    Map<String, String> notes = new HashMap<>(Map.of(
        "dima", "Помыть посуду, Посмотреть футбол"
    ));

    Scanner scanner = new Scanner(System.in);
    System.out.println("Login:");
    String login = scanner.nextLine();
    System.out.println("Password:");
    String password = scanner.nextLine();


    String candidate = users.get(login);
    if (candidate == null) {
      System.out.println("bad credentials!");
      System.exit(0);
    } else if (!candidate.equals(password)) {
      System.out.println("bad credentials!");
      System.exit(0);
    } else {
      System.out.println("My notes:");

      String notesAsString = notes.get(login);
      String[] notesArray = notesAsString.split(",");
      System.out.println(Arrays.toString(notesArray));

      System.out.println("Any new notes? (y/n)");
      String key = scanner.nextLine();
      if (key.equals("y")) {
        System.out.println("New Note:");
        String newNote = scanner.nextLine();
        ArrayList<String> notesAsList = new ArrayList<>(asList(notesArray));
        notesAsList.add(newNote);
        notes.put(login, String.join(", ", notesAsList));
        System.out.println(notes.get(login));
      } else {
        System.exit(0);
      }
    }
  }
}