package guru.qa.view;

import guru.qa.data.UserRepository;
import guru.qa.domain.User;
import guru.qa.service.Session;
import guru.qa.service.UserSession;

import javax.swing.*;
import java.util.Optional;

public class LoginUiComponent implements UiComponent {

  private final UserRepository userRepository;

  public LoginUiComponent(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public Session render(Session session) {
    String username = JOptionPane.showInputDialog("Login:");
    String password = JOptionPane.showInputDialog("Password:");
    Optional<User> byUsername = userRepository.findByUsername(username);
    if (byUsername.isPresent()) {
      User user = byUsername.get();
      if (user.password().equals(password)) {
        return new UserSession(
            user
        );
      }
    }
    showError();
    return render(session);
  }

  private void showError() {
    JOptionPane.showMessageDialog(
        null,
        "Bad credentials!",
        "Error",
        JOptionPane.ERROR_MESSAGE
    );
  }
}
