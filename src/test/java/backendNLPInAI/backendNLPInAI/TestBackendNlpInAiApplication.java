package backendNLPInAI.backendNLPInAI;

import org.springframework.boot.SpringApplication;

public class TestBackendNlpInAiApplication {

	public static void main(String[] args) {
		SpringApplication.from(BackendNlpInAiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
