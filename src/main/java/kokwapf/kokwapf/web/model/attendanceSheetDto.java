package kokwapf.kokwapf.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class attendanceSheetDto {
    private UUID id;
    private String studentName;
    private String studentRegisterNumber;
    private LocalDate dayOffEvent;
    private OffsetDateTime createdAt;
    private OffsetDateTime uploadAt;
    private String documentCategory;
    private String handlingAttendance;
    private String signature;
    private Boolean attendance;


}
