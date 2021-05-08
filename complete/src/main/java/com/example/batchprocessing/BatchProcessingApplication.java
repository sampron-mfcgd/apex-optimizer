package com.example.batchprocessing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

@SpringBootApplication
public class BatchProcessingApplication {



	public static void main(String[] args) throws Exception {
		//for (String dllLibrary : dllLibraryArray) {
		//	NativeLoader.load(dllLibrary);
		//}

		File rootFile = new File(new BatchProcessingApplication().getClass().getClassLoader().getResource("finace-19.1.203.MANULIFE.5.jar").toURI());
        String library = "copy-finace-19.1.203.MANULIFE.5.jar";
		//ClassPathResource resource = new ClassPathResource(rootFile.getCanonicalPath());

		InputStream targetStream = new FileInputStream(rootFile);

		//try (InputStream inputStream = resource.getInputStream()) {
			File tempFile = new File("C:\\Temp", library);
			tempFile.deleteOnExit();

			Files.copy(targetStream, tempFile.toPath());

			System.load(tempFile.getAbsolutePath());
		//} catch (IOException e) {
			//throw new RuntimeException("Failed to load library " + library);
		//}

		//public static synchronized void load(String library){
			//if (!LOADED_LIBS.contains(library)) {

			//}
		//}

			System.exit(SpringApplication.exit(SpringApplication.run(BatchProcessingApplication.class, args)));
	}
}
