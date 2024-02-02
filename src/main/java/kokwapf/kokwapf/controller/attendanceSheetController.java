package kokwapf.kokwapf.controller;

import kokwapf.kokwapf.services.DocumentReaderService;
import kokwapf.kokwapf.web.model.attendanceSheetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
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

}
