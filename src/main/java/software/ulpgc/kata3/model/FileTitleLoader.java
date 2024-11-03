package software.ulpgc.kata3.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileTitleLoader implements TitleLoader{
    private final File file;

    private final TitleDeserializer deserializer;

    private FileTitleLoader(File file, TitleDeserializer deserializer) {
        this.file = file;
        this.deserializer = deserializer;
    }

    public static FileTitleLoader with(File file, TitleDeserializer deserializer) {
        return new FileTitleLoader(file, deserializer);
    }

    @Override
    public List<Title> load() throws IOException {
        List<Title> titles = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            reader.readLine();
            while (true){
                String line = reader.readLine();
                if (line == null) break;
                Title title = deserializer.deserialize(line);
                titles.add(title);
            }
            return titles;
        }
    }
}
