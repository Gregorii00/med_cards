package com.example.med_cards.scan;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.example.med_cards.model.Disease;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;
public class CsvUtility {
    public static String TYPE = "text/csv";
    public long count=0;
    public static boolean hasCsvFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }
    public static List<Disease> csvToDiseaseList() throws MalformedURLException {
        URL url = new URL("https://github.com/ak4nv/mkb10/raw/master/mkb10.csv");
        CSVFormat csvFormat = CSVFormat.DEFAULT.withTrim();
        List<Disease> diseaseList = new ArrayList<Disease>();
        try(CSVParser csvParser = CSVParser.parse(url, StandardCharsets.UTF_8, csvFormat)) {
            for(CSVRecord csvRecord : csvParser) {
                Disease disease = new Disease();
                disease.setId((csvRecord.get(2)));
                disease.setName(csvRecord.get(3));
                diseaseList.add(disease);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return diseaseList;
    }

}
