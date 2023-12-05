package guru.qa.data;

import guru.qa.domain.Note;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface NoteRepository {

  List<Note> findAllByUsername(String username);

  void save(Note note);

  class MockNoteRepository implements NoteRepository {

    private static final List<Note> mockNotes = new ArrayList<>(
        List.of(
            new Note(
                "dima",
                "Помыть посуду"
            ),
            new Note(
                "dima",
                "Посмотреть футбол"
            )
        )
    );

    @Override
    public List<Note> findAllByUsername(String username) {
      if ("dima".equals(username)) {
        return mockNotes;
      } else {
        return Collections.emptyList();
      }
    }

    @Override
    public void save(Note note) {
      if ("dima".equals(note.username())) {
        mockNotes.add(note);
      }
    }
  }
}
