package software.ulpgc.kata3;

import software.ulpgc.kata3.model.FileTitleLoader;
import software.ulpgc.kata3.model.Title;
import software.ulpgc.kata3.model.TsvTitleDeserializer;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Title> data = FileTitleLoader.with(
                        new File("C:\\Users\\User\\Documents\\title.basics.tsv\\title.basics.tsv"),
                        new TsvTitleDeserializer())
                        .load();
    }
}
