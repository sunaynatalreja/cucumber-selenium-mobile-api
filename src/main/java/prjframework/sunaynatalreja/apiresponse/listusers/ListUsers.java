/**
 * 
 */
package prjframework.sunaynatalreja.apiresponse.listusers;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import prjframework.sunaynatalreja.apiresponse.singleUser.Data;
import prjframework.sunaynatalreja.apiresponse.singleUser.Support;

/**
 * List Users response pojo class
 * @author Sunayna Talreja
*/
public class ListUsers {
	
    @JsonProperty("page")
	private String page;
	
    @JsonProperty("per_page")
	private String per_page;
	
    @JsonProperty("total")
	private String total;
	
    @JsonProperty("total_pages")
	private String total_pages;
	
    @JsonProperty("data")
	private Data[] data;
	
    @JsonProperty("support")
	private Support support;
	    
	@JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	
	
	@JsonProperty("page")
	public String getPage() {
		return page;
	}

	@JsonProperty("page")
	public void setPage(String page) {
		this.page = page;
	}

	@JsonProperty("per_page")
	public String getPer_page() {
		return per_page;
	}

	@JsonProperty("per_page")
	public void setPer_page(String per_page) {
		this.per_page = per_page;
	}

	@JsonProperty("total")
	public String getTotal() {
		return total;
	}

	@JsonProperty("total")
	public void setTotal(String total) {
		this.total = total;
	}

	@JsonProperty("total_pages")
	public String getTotal_pages() {
		return total_pages;
	}

	@JsonProperty("total_pages")
	public void setTotal_pages(String total_pages) {
		this.total_pages = total_pages;
	}

	@JsonProperty("data")
	public Data[] getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(Data[] data) {
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
