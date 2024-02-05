package kokwapf.kokwapf.services;


import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.util.StringJoiner;

@Service
public class DocumentReaderService {

    public boolean isValidFileType(String fileName) {

        if (fileName.endsWith(".xlsx") || fileName.endsWith(".xls")) {
            return true;
        } else if (fileName.endsWith(".csv")) {
            return true;
        } else {
            return false;
        }
    }
    private String basePath = "C:\\Users\\Averyl\\Desktop\\projects\\Documents";

    public String readFromFile(String fileName) throws IOException {
        File file = new File(basePath, fileName);

        StringBuilder content = new StringBuilder();

        try (
                BufferedReader reader = Files.newBufferedReader(file.toPath());
                CSVParser csvParser = CSVFormat.DEFAULT.parse(reader)
        ) {
            for (CSVRecord csvRecord : csvParser) {
                StringJoiner line = new StringJoiner(", ");

                csvRecord.forEach(line::add);
                content.append(line);
                content.append("\n");
            }
        }
        return content.toString();
    }

}


