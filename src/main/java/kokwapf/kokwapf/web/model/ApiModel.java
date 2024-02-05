package kokwapf.kokwapf.web.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiModel {
    private MessageModel message;
    private Map<String, Object> filterMap;
    private Map<String, String> orderMap;
    private Object data;
    private Object result;
    private PagingValues paging;
    public ApiModel(MessageModel messageSeverity){
        this.message = messageSeverity;
    }
    public void setError(String error){
        this.message = new MessageModel(MessageSeverityEnum.ERROR, error);
    }
    public void setOk(String message){
        this.message =new MessageModel (MessageSeverityEnum.SUCCESS, message);
    }
}
