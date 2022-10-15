import com.google.gson.Gson;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestMaxCategories {
    final String readSales = "{title='булка',categories='еда',date='2202.02.08',sum='400'}";
    final Map<String, Integer> categoryTest = new HashMap<>();
    Gson gsonTest = new Gson();

    @AfterEach
    void endTest(){
        System.out.println("Тест успешно пройден!");
    }

    @Test
    public void testCategorySum() {
        Basket oneSaleTest = gsonTest.fromJson(readSales, Basket.class);
        MaxCategory.category.put(oneSaleTest.categories, oneSaleTest.sum);
        int actualCategory = MaxCategory.category.get(oneSaleTest.categories);
        Assertions.assertEquals(oneSaleTest.sum, actualCategory);
    }

    @Test
    public void testCategoriesTSV() throws IOException {
        Map<String, String> tsvTest = Basket.loadFromTsvFile(new File("categories.tsv"));
        Basket oneSaleTest = gsonTest.fromJson(readSales, Basket.class);
        String actualCategoryToTsv = tsvTest.get(oneSaleTest.title);
        Assertions.assertEquals(oneSaleTest.categories, actualCategoryToTsv);
    }
}
