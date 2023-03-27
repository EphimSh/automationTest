import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ResponseTestStand {


    @JsonProperty("data")
    private List<DataBody> data;
    @JsonProperty("meta")
    private MetaBody meta;

    @JsonProperty("error")
    private String errorType;
    @JsonProperty("code")
    private String code;
    @JsonProperty("message")
    private String message;


    @JsonPropertyOrder({
            "id",
            "title",
            "description",
            "content",
            "authorId",
            "mainImage",
            "updatedAt",
            "createdAt",
            "labels",
            "delayPublishTo",
            "draft"
    })
    @Data
    public static class DataBody {
        @JsonProperty("id")
        private int id;
        @JsonProperty("title")
        private String title;
        @JsonProperty("description")
        private String description;
        @JsonProperty("content")
        private String content;
        @JsonProperty("authorId")
        private int authorId;
        @JsonProperty("mainImage")
        private MainImage mainImage;
        @JsonProperty("updatedAt")
        private String updatedAt;
        @JsonProperty("createdAt")
        private String createdAt;
        @JsonProperty("labels")
        private List<String> labels;
        @JsonProperty("delayPublishTo")
        private String delayPublishTo;
        @JsonProperty("draft")
        private boolean draft;
    }

    @Data
    @JsonPropertyOrder({"id", "cdnUrl"})
    public static class MainImage {
        @JsonProperty("id")
        private int id;
        @JsonProperty("cdnUrl")
        private String cdnUrl;
    }

    @JsonPropertyOrder({
            "prevPage",
            "nextPage",
            "count"
    })

    @Data
    public static class MetaBody {
        @JsonProperty("prevPage")
        private int prepPage;
        @JsonProperty("nextPage")
        private int nextPage;
        @JsonProperty("count")
        private int count;


    }

}
