package cz.osu;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class FileManager {

    public static ArrayList<String> fileFromResourceToArrayList(String fileName) {

        ArrayList<String> lines = new ArrayList<>();
        File file = new File(FileManager.class.getClassLoader().getResource(fileName).getFile());


        try {

            for (String line : Files.readAllLines(file.toPath())) {

                lines.add(line);
            }

        } catch (IOException e) {

            e.printStackTrace();
        }

        return lines;
    }
}
