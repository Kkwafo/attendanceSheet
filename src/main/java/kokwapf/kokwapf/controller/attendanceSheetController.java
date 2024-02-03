package kokwapf.kokwapf.controller;

import kokwapf.kokwapf.services.DocumentReaderService;
import kokwapf.kokwapf.web.model.attendanceSheetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/attendance")
@RestController
public class attendanceSheetController {

    private final DocumentReaderService documentReaderService;

    public attendanceSheetController(DocumentReaderService documentReaderService) {
        this.documentReaderService = documentReaderService;
    }

    @GetMapping("/getListOfFiles")
    public List<String> getListOfFiles( ) {
        return documentReaderService.getListOfFiles();
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
}
