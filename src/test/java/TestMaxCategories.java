import com.google.gson.Gson;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestMaxCategories {


    MaxCategory maxCategory = new MaxCategory();
    @BeforeEach
    void setUp() {
        maxCategory.readTsvFile();
        maxCategory.readJsonFile("fortest.json");
        maxCategory.maxValueMap();
        System.out.println("Тест запущен!\n");
    }
    @AfterEach
    void endTest(){
        System.out.println("Тест успешно пройден!");
    }

    @Test
    public void maxValueMapTest() {
        Assertions.assertEquals(2, maxCategory.mapValueMax.size());
        Assertions.assertEquals("еда", maxCategory.mapValueMax.get("category"));
        Assertions.assertEquals(50, (Long) maxCategory.mapValueMax.get("sum"));
        maxCategory.readJsonFile("fortest.json");
        maxCategory.maxValueMap();
        // после добавления аналогичной покупки итоговая сумма возрастает
        Assertions.assertEquals("еда", maxCategory.mapValueMax.get("category"));
        Assertions.assertEquals(100, (Long) maxCategory.mapValueMax.get("sum"));
    }
    @Test
    void readJsonFileTest() {
        Assertions.assertEquals(50, (Long) maxCategory.categoryJson.get("еда"));
    }
}
