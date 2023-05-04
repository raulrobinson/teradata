package co.com.telefoncia.ws.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestDTO {
    private String query;
}
