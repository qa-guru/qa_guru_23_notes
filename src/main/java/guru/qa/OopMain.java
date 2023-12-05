package guru.qa;

import guru.qa.data.FileUserRepository;
import guru.qa.data.NoteRepository;
import guru.qa.data.UserRepository;
import guru.qa.service.Session;
import guru.qa.view.LoginUiComponent;
import guru.qa.view.NotesUiComponent;
import guru.qa.view.UiComponent;
import guru.qa.view.UiComponents;

import java.nio.file.Path;

public class OopMain {

  public static void main(String[] args) {
    new UiComponents(
        new LoginUiComponent(
            new FileUserRepository(
                Path.of(
                    "users.csv"
                )
            )
        ),
        new NotesUiComponent(
            new NoteRepository.MockNoteRepository()
        )
    ).render(
        new Session.MockSession()
    );
  }
}
