package kokwapf.kokwapf.services;


import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.Reader;

@Service
public class DocumentReaderService {
    private File filePath = new File("");

    private boolean isExcelFile(String filePath) {

        return filePath.endsWith(".xlsx") || filePath.endsWith(".xls");
    }

    private boolean isCsvFile(String filePath) {

        return filePath.endsWith(".csv");
    }



    public List<String> getListOfFiles() {
        File folder = new File("C:\\Users\\Averyl\\Desktop\\projects\\Documents");
        File[] listOfFiles = folder.listFiles();

        List<String> fileNames = new ArrayList<>();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                fileNames.add(file.getName());
                System.out.println(file.getName());
            }
        }
        return fileNames;
    }
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

        try (Reader reader = new FileReader(file);
             CSVParser csvParser = CSVFormat.DEFAULT.parse(reader)) {

            StringBuilder content = new StringBuilder();

            for (CSVRecord csvRecord : csvParser) {
                int numColumns = csvRecord.size();

                for (int i = 0; i < numColumns; i++) {
                    String columnValue = csvRecord.get(i);
                    content.append(columnValue);

                    // Agrega una coma después de cada valor, excepto para el último
                    if (i < numColumns - 1) {
                        content.append(", ");
                    }
                }
                // Agrega un salto de línea al final de cada línea del CSV
                content.append("\n");
            }

            return content.toString();
        }
    }

}


