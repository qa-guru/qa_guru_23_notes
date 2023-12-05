package guru.qa.view;

import guru.qa.service.Session;

public class UiComponents implements UiComponent {

  private final UiComponent[] components;

  public UiComponents(UiComponent... components) {
    this.components = components;
  }

  @Override
  public Session render(Session session) {
    Session sessionFromComponent = session;
    for (UiComponent component : components) {
      sessionFromComponent = component.render(sessionFromComponent);
    }
    return sessionFromComponent;
  }
}
