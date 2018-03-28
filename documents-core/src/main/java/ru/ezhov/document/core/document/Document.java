package ru.ezhov.document.core.document;

import ru.ezhov.document.core.document.fields.Fields;

import java.util.Date;

/**
 * Created by ezhov_da on 19.03.2018.
 */
public interface Document {
    int id();

    String name();

    boolean active();


    String tableName();

    String username();

    Date addDt();

    String description();

    Fields fields();
}
