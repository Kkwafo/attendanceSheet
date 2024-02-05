package kokwapf.kokwapf.controller;

import kokwapf.kokwapf.services.DocumentReaderService;
import kokwapf.kokwapf.web.model.ApiModel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequestMapping("api/v1/attendance")
@RestController
public class attendanceSheetController {

    private static final String ATTENDANCE_START_PATTERN = "ATTENDANCE_DOCUMENT";
    private final DocumentReaderService documentReaderService;
    private static final String PATH_FOLDER_ATTENDANCE = "C:\\Users\\Averyl\\Desktop\\projects\\Documents";

    public attendanceSheetController(DocumentReaderService documentReaderService) {
        this.documentReaderService = documentReaderService;
    }


    @PostMapping("/validateFile")
    public ResponseEntity<String> validateFile(@RequestParam String fileName) {
        if (documentReaderService.isValidFileType(fileName)) {
            return ResponseEntity.ok("El tipo de archivo es válido: " + fileName);
        } else {
            return ResponseEntity.badRequest().body("El tipo de archivo no es válido: " + fileName);
        }
    }

    @PostMapping("/readFile")
    public ResponseEntity<String> readFile(@RequestParam String fileName) {

        try {
            String fileContent = documentReaderService.readFromFile(fileName);
            System.out.println("Contenido del archivo " + fileName + ":\n" + fileContent);
            return ResponseEntity.ok("Contenido del archivo impreso en la consola.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error al leer el archivo " + fileName + ": " + e.getMessage());
        }
    }

    @GetMapping("/getListOfFiles")
    public ResponseEntity<ApiModel>getListOfFiles(){
        ApiModel model = new ApiModel();
        Set<String> fileNames = Stream.of(new File(PATH_FOLDER_ATTENDANCE).listFiles())
                .filter(f -> f.getName().startsWith(ATTENDANCE_START_PATTERN))
                .map(File::getName).collect(Collectors.toSet());
        model.setResult(fileNames);
        return ResponseEntity.ok(model);

    }
}
