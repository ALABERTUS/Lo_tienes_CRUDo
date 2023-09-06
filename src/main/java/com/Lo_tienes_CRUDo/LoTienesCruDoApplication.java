package com.Lo_tienes_CRUDo;

import com.Lo_tienes_CRUDo.domain.models.Consulta;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
class LotienesCruDoApplication {

	public static void main(String[] args) {

		SpringApplication.run(LotienesCruDoApplication.class, args);
	}
}

