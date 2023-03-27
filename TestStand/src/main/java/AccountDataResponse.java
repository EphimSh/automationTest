import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class AccountDataResponse {

    @JsonProperty("userId")
    private int userId;
    @JsonProperty("username")
    private String username;
    @JsonProperty("token")
    private String token;
    @JsonProperty("roles")
    private List<String> roles;
    @JsonProperty("error")
    private String error;


}
