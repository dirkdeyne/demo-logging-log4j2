package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

@RestController
class LogController {

	private static final Logger logger = LoggerFactory.getLogger(LogController.class);

	private String config;

	private String extension;
	private String path;
	private String name;

	private LogController(
			@Value("${logging.config}") String config,
			@Value("${search_files.csv.path}") String path,
			@Value("${search_files.csv.name}") String name,
			@Value("${search_files.csv.extension}") String extension
	){
		this.config = config;
		this.extension = extension;
		this.name = name;
		this.path = path;
	}

	@GetMapping("/info")
	public String info(){
		logger.info("user called info()");
		return "info";
	}

	@GetMapping("/debug")
	public String debug(){
		logger.debug("user called debug()");
		return "debug";
	}

	@GetMapping("/warn")
	public String warn(){
		logger.debug("user called warn()");
		return "warn";
	}

	@GetMapping("/csv")
	public String showCsvConfig() {
		return String.format("path: %s, name: %s, extension: %s", path, name, extension);
	}
}
