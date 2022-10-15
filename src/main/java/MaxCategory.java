import com.google.gson.Gson;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MaxCategory {
    protected static Map<String, Integer> category = new HashMap<>();

    public static JSONObject maxCategory(BufferedReader in) throws IOException {
        Gson gson = new Gson();
        String readSales = in.readLine();
        Basket oneSale = gson.fromJson(readSales, Basket.class);
        category.put(oneSale.categories, oneSale.sum);
        String maxFinCategory = Collections.max(category.entrySet(),
                Comparator.comparingInt(Map.Entry::getValue)).getKey();
        int maxFinSum = category.get(maxFinCategory);
        JSONObject jsonMaxSum = new JSONObject();
        jsonMaxSum.put("sum", maxFinSum);
        jsonMaxSum.put("categories", maxFinCategory);

        return jsonMaxSum;
    }
}
