package guru.qa.data;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import guru.qa.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class FileUserRepository implements UserRepository {

  private final Path pathToFile;

  public FileUserRepository(Path pathToFile) {
    this.pathToFile = pathToFile;
  }

  @Override
  public Optional<User> findByUsername(String username) {
    try (InputStream is = Files.newInputStream(pathToFile);
         CSVReader csvReader = new CSVReader(
             new InputStreamReader(is)
         )) {

      Optional<String[]> candidate = csvReader.readAll()
          .stream()
          .filter(row -> username.equals(row[0]))
          .findFirst();

      if (candidate.isPresent()) {
        return Optional.of(
            new User(
                candidate.get()[0],
                candidate.get()[1]
            )
        );
      } else {
        return Optional.empty();
      }
    } catch (IOException | CsvException e) {
      throw new RuntimeException(e);
    }
  }
}
