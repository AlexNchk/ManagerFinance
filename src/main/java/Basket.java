import com.google.gson.Gson;

import java.io.*;
import java.util.*;

public class Basket {
    protected String title;
    protected String categories;
    protected String date;
    protected int sum;

    public Basket(String title, String date, int sum){
        this.title = title;
        this.categories = null;
        this.date = date;
        this.sum = sum;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }


    static Map<String, String> loadFromTsvFile(File tsvFile) throws IOException {
        Map<String,String> mapCategories = new HashMap<>();
        try(BufferedReader tsrRead = new BufferedReader(new FileReader(tsvFile))){
            String line = null;
            while ((line = tsrRead.readLine()) != null){
                String[] lineParts = line.split("\t");
                mapCategories.put(lineParts[0],lineParts[1]);
            }
        }
        return mapCategories;
    }
    public static Basket loadFromJson(File jsonFile) throws IOException{
        try (Scanner scanner = new Scanner(jsonFile)) {
            String json = scanner.nextLine();
            Gson gson = new Gson();
            return gson.fromJson(json, Basket.class);
        }
    }

    @Override
    public String toString() {
        return "{" +
                "title='" + title + '\'' +
                ", categories='" + categories + '\'' +
                ", date='" + date + '\'' +
                ", sum=" + sum +
                '}';
    }
}
