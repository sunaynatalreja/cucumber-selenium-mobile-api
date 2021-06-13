/**
 * 
 */
package prjframework.sunaynatalreja.apiresponse.listusers;

import prjframework.sunaynatalreja.apiresponse.singleUser.Data;
import prjframework.sunaynatalreja.apiresponse.singleUser.Support;

/**
 * List Users response pojo class
 * @author Sunayna Talreja
*/
public class ListUsers {
	public String page;
	public String per_page;
	public String total;
	public String total_pages;
	public Data[] data;
	public Support support;
	public String getPage() {
		return page;
	}
	public String getPer_page() {
		return per_page;
	}
	public String getTotal() {
		return total;
	}
	public String getTotal_pages() {
		return total_pages;
	}
	public Data[] getData() {
		return data;
	}
	public Support getSupport() {
		return support;
	}
	
	
}
