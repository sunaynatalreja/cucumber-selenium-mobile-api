package prjframework.sunaynatalreja.apiresponse.singleUser;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Sunayna Talreja
 * Single user response pojo class
*/

public class SingleUser {
	
	@JsonProperty("data")
	private Data data;
	
	@JsonProperty("support")
	private Support support;
	

	@JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();
		
	@JsonProperty("data")
	public Data getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(Data data) {
		this.data = data;
	}

	@JsonProperty("support")
	public Support getSupport() {
		return support;
	}

	@JsonProperty("support")
	public void setSupport(Support support) {
		this.support = support;
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
