package prjframework.sunaynatalreja.apiresponse.singleUser;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Single User response sub pojo class
 * @author Sunayna Talreja
*/
public class Data {
	
	@JsonProperty("id")
	private String id;	

	@JsonProperty("email")
	private String email;
	
	@JsonProperty("first_name")
	private String first_name;
	
	@JsonProperty("last_name")
	private String last_name;
	
	@JsonProperty("avatar")
	private String avatar;
	
	@JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();
	
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("first_name")
	public String getFirst_name() {
		return first_name;
	}

	@JsonProperty("first_name")
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	@JsonProperty("last_name")
	public String getLast_name() {
		return last_name;
	}

	@JsonProperty("last_name")
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	@JsonProperty("avatar")
	public String getAvatar() {
		return avatar;
	}

	@JsonProperty("avatar")
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
