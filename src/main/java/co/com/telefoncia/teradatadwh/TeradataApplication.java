package co.com.telefoncia.teradatadwh;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Slf4j
@RestController
@RequestMapping(path = "${controller.properties.base-path}", produces = MediaType.APPLICATION_JSON_VALUE)
public class TeradataApplication {

    private final TeradataService teradataService;

    public TeradataApplication(TeradataService teradataService) {
        this.teradataService = teradataService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TeradataApplication.class, args);
    }

    @Bean
    public Object GetCustomQuery() {
        return teradataService.GetDataForQuery("SELECT * FROM dwh_view.cuentacorrienteproducto");
    }

}

