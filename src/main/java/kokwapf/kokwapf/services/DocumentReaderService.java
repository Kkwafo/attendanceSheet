package kokwapf.kokwapf.services;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import kokwapf.kokwapf.web.model.attendanceSheetDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DocumentReaderService {
    private File filePath = new File("");

    private boolean isExcelFile(String filePath) {
        return filePath.endsWith(".xlsx") || filePath.endsWith(".xls");
    }

    private boolean isCsvFile(String filePath) {
        return filePath.endsWith(".csv");
    }

    public void checkDocument() {
        if (isExcelFile(String.valueOf(filePath))) {
            readExcelFile(filePath);
        } else if (isCsvFile(String.valueOf(filePath))) {
            readCsvFile(filePath);
        } else {
            System.err.println("Formato de archivo no compatible.");
        }
    }

    public void readExcelFile(File filePath) {
        return;
    }

    public void readCsvFile(File filePath) {

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
}

