package ru.ezhov.document.core;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import ru.ezhov.document.core.document.*;
import ru.ezhov.document.core.name.ColumnName;
import ru.ezhov.document.core.name.TableName;
import ru.ezhov.document.core.source.H2Source;
import ru.ezhov.document.core.source.Source;

import java.util.logging.Logger;

/**
 * Created by ezhov_da on 19.03.2018.
 */
public class App {
    private static final Logger LOG = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        try {
            Source source = new H2Source();
            Documents documents = new DbDocuments(new DbDocumentId(source), source);

            documents
                    .all()
                    .forEach(System.out::println);

            Document document = documents.newDocument("тест иииия" + Math.random(), new TableName(), "ezhov_da");
            document.addField("вау", new ColumnName(), "тестовое описание", FieldType.STRING, 100, Order._05, "ezhov_da");

            document.fields().forEach(c -> {
                System.out.println(c.name());
                System.out.println(c.columnName());
                System.out.println(c.order());
                System.out.println(c.type());
            });

            System.out.println(document);

            documents
                    .all()
                    .forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    private void oldCode() {
        //App app = new App();
        //String jsonRaw = testJSon();
        //JsonParser parser = new JsonParser();
        //JsonElement jsonElement = parser.parse(jsonRaw);
        //processArray(jsonElement);
        //System.out.println(document.rowCount());
        //Workbook workbook = new Workbook(new Sheet());
    }

    public void processArray(JsonElement jsonElement) {
        JsonArray jsonArray = jsonElement.getAsJsonArray();
        int size = jsonArray.size();
        for (int i = 0; i < size; i++) {
            JsonElement element = jsonArray.get(i);
            if (element.isJsonArray()) {
                processArray(element);
            } else {
                System.out.println(element.getAsString());
            }
        }
    }
}