package guru.qa.domain;

public class Note {

  private final String username;
  private final String note;

  public Note(String username, String note) {
    this.username = username;
    this.note = note;
  }

  public String username() {
    return username;
  }

  public String note() {
    return note;
  }
}
