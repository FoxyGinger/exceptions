package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class HumanFile {
    public static void Write(Human human) {
        try {
            FileWriter fileWriter = new FileWriter(human.getLastName() + ".txt", true);
            fileWriter.write(human + "\n");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
