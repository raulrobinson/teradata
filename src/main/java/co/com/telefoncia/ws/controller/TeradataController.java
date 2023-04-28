package co.com.telefoncia.ws.controller;

import co.com.telefoncia.ws.service.TeradataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "${controller.properties.base-path}", produces = MediaType.APPLICATION_JSON_VALUE)
public class TeradataController {

    private final TeradataService teradataService;

    public TeradataController(TeradataService teradataService) {
        this.teradataService = teradataService;
    }

    @GetMapping
    public Object GetCustomQuery(String query) {
        return teradataService.GetDataForQuery(query);
    }
}
