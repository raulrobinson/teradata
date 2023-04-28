package co.com.telefoncia.ws;

import co.com.telefoncia.ws.service.TeradataService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppWsApplication {

    private final TeradataService teradataService;

    public AppWsApplication(TeradataService teradataService) {
        this.teradataService = teradataService;
    }

    public static void main(String[] args) {
        SpringApplication.run(AppWsApplication.class, args);
    }

    @Bean
    public Object GetCustomQuery() {
        return teradataService.GetDataForQuery("SELECT * FROM dwh_view.cuentacorrienteproducto");
    }

}

