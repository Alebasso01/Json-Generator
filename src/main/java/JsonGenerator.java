import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonGenerator {

    public static void main(String[] args) {
        // Crea un oggetto JSON con il campo DAU impostato a 1
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("DAU", 1);

        // Percorso del file JSON da creare in target
        String targetPath = "target/data.json";
        String resourcesPath = "src/main/resources/data.json";

        // Salva l'oggetto JSON su un file nella cartella target
        try (FileWriter fileWriter = new FileWriter(targetPath)) {
            fileWriter.write(jsonObject.toString(4)); // 4 spazi di indentazione
            System.out.println("File JSON creato con successo in target: " + targetPath);
        } catch (IOException e) {
            System.err.println("Errore durante la scrittura del file JSON: " + e.getMessage());
            return; // Interrompi l'esecuzione in caso di errore
        }

        // Copia il file in src/main/resources
        try {
            Files.copy(Paths.get(targetPath), Paths.get(resourcesPath), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File JSON copiato in: " + resourcesPath);
        } catch (IOException e) {
            System.err.println("Errore durante la copia del file JSON: " + e.getMessage());
        }
    }
}
