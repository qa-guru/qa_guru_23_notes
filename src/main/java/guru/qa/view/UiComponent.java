package guru.qa.view;

import guru.qa.service.Session;

import javax.swing.*;

public interface UiComponent {

  Session render(Session session);

  class MockUiComponent implements UiComponent {
    @Override
    public Session render(Session session) {
      JOptionPane.showMessageDialog(
          null,
          "I`m a mock UI component!",
          "Mock message",
          JOptionPane.INFORMATION_MESSAGE
      );
      return session;
    }
  }
}
