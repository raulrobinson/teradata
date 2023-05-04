package co.com.telefoncia.ws.controller;

import co.com.telefoncia.ws.dto.RequestDTO;
import co.com.telefoncia.ws.service.TeradataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "${controller.properties.base-path}", produces = MediaType.APPLICATION_JSON_VALUE)
public class TeradataController {

    private final TeradataService teradataService;

    public TeradataController(TeradataService teradataService) {
        this.teradataService = teradataService;
    }

    @PostMapping(path = "/custom-query-param", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
    public Object getCustomQueryByRequestParam(@RequestParam(name = "query") String query) {
        return teradataService.getCustomQueryByRequestParam(query);
    }

    @PostMapping(path = "/custom-query-body", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Object getCustomQueryByRequestBody(@RequestBody RequestDTO requestDTO) {
        return teradataService.getCustomQueryByRequestBody(requestDTO);
    }
}
