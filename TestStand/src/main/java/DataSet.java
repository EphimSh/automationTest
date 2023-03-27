
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data

public class DataSet {
    private String username;
    private String password;
    private Boolean shouldSuccess;

    public DataSet(@JsonProperty("username") String username,@JsonProperty("password") String password,@JsonProperty("shouldSuccess") Boolean shouldSuccess) {
        this.username = username;
        this.password = password;
        this.shouldSuccess = shouldSuccess;
    }
}
