package ru.matveycock.ElFinTask.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;
import ru.matveycock.ElFinTask.helper.Indices;

import java.util.List;
import java.util.Map;

@Document(indexName = Indices.RESULT_INDEX)
@Setting(settingPath = "static/es-settings.json")
public class Result {

    @Id
    @Field(type = FieldType.Keyword)
    private String id;
    @Field(type = FieldType.Boolean)
    private boolean successful;
    @Field(type = FieldType.Auto)
    private List<String> details;

    public Result(boolean successful,  List<String> details) {
        this.successful = successful;
        this.details = details;
    }

}
