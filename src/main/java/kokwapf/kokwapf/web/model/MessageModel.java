package kokwapf.kokwapf.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageModel {
    private MessageSeverityEnum severity;
    private String value;
}
