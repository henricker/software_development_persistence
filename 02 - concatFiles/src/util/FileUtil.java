package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import service.BufferedReaderBuilder;

public class FileUtil {
  public static void concatFile(BufferedWriter bw, String filename) throws IOException {
    try(
      BufferedReader fileToRead = new BufferedReaderBuilder(filename)
      .buildInputStream()
      .buildInputStreamReader()
      .buildBufferedReader()
    )
    {
      String line = fileToRead.readLine();
      while(line != null) {
        bw.write(line + "\n");
        line = fileToRead.readLine();
      }
    }
  }
}
