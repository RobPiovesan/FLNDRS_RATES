package RATES;

import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Evaluation {

    Evaluation(String classCode, String subjectName, boolean anon, String feeling, String body, String userID, String dateTime, String option, String attachmentPath){
        JSONObject json = new JSONObject(); //creates main json
        json.put("classCode", classCode);
        json.put("subjectName", subjectName);
        json.put("anonymous", anon);
        json.put("rating", feeling);
        json.put("evaluationBody", body);
        json.put("userID", userID);
        json.put("dateTime", dateTime);
        json.put("option", option);
        json.put("attachment", attachmentPath);

        String jsonString = json.toString(4);
        String evalJsonPath = "JSON/evaluations.json";

        //reads existing JSON
        String existingJSON = "";
        try {
            existingJSON = new String((Files.readAllBytes(Paths.get(evalJsonPath))));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        //Adds to existing JSON string
        String JSONtop = "{\n\"eval\":[\n";
        String newJSON;
        if(existingJSON.length() != 0){
            newJSON = existingJSON.substring(0, existingJSON.length()-2) + ",\n"+jsonString +"]}";
        }
        else{
            newJSON = JSONtop + jsonString + "]}";
        }

        //writes string to file
        try {
            FileWriter myWriter = new FileWriter("JSON/evaluations.json");
            myWriter.write(newJSON);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
