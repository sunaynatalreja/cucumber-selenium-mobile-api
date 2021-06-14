/**
 * 
 */
package prjframework.sunaynatalreja.apirequests;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.response.Response;

import prj.sunaynatalreja.jsonutil.JSONUtil;
import prjframework.sunaynatalreja.apirequests.create.CreateRequest;
import prjframework.sunaynatalreja.apirequests.registersuccessful.RegisterSuccessfulRequest;
import prjframework.sunaynatalreja.apiresponse.create.CreateResponse;
import prjframework.sunaynatalreja.apiresponse.listusers.ListUsers;
import prjframework.sunaynatalreja.apiresponse.registersuccessfulresponse.RegisterSuccessfulResponse;
import prjframework.sunaynatalreja.apiresponse.singleUser.SingleUser;
import prjframework.sunaynatalreja.apiresponse.update.UpdateUser;
import prjframework.sunaynatalreja.constants.APIURL;

/**
 * @author Sunayna Talreja
*/
public class APIRequests {
	/**
	 * register successful API request hit
	 * @param data
	 * @return
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	public static RegisterSuccessfulResponse getRegisterSuccessfulResponse(Map<String,String> data) throws JsonMappingException, JsonProcessingException
	{		
		String url=APIURL.getRegisterSuccessful();
		RegisterSuccessfulRequest request=new RegisterSuccessfulRequest();
		request.setEmail(data.get("Email"));
		request.setPassword(data.get("Password"));
		ObjectMapper mapper=new ObjectMapper();		
		String response=JSONUtil.getInstance().jsonPost(mapper.writeValueAsString(request),url);
		return mapper.readValue(response, RegisterSuccessfulResponse.class);
		
	}

	/**
	 * create API request hit
	 * @param data
	 * @return
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	public static CreateResponse getCreateResponse(Map<String,String> data) throws JsonMappingException, JsonProcessingException
	{
		String url=APIURL.getCreatePost();
		CreateRequest request=new CreateRequest();
		request.setName(data.get("Name"));
		request.setJob(data.get("Job"));
		ObjectMapper mapper=new ObjectMapper();		
		String response=JSONUtil.getInstance().jsonPost(mapper.writeValueAsString(request),url);
		return mapper.readValue(response, CreateResponse.class);
		
	}

	/**
	 * single user API request hit
	 * @param data
	 * @return
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	public static SingleUser getSingleUserResponse(Map<String, String> data) throws JsonMappingException, JsonProcessingException {
		String url=APIURL.getSingleUserGet();
		ObjectMapper mapper=new ObjectMapper();		
		String response=JSONUtil.getInstance().jsonGetPathParameter(url,data);
		return mapper.readValue(response, SingleUser.class);
	}	
	/**
	 * List users API request hit
	 * @return
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	public static List<ListUsers> getListUsersResponse() throws JsonMappingException, JsonProcessingException {
		
		String url=APIURL.getListUsersGet();
		List<ListUsers> listUsers=new ArrayList<>();
		ObjectMapper mapper=new ObjectMapper();	
		Map<String,String> map=new HashedMap<>();
		map.put("page", "1");
		Response response=JSONUtil.getInstance().jsonGetQueryParams(map,url);
		listUsers.add(mapper.readValue(response.body().asString(), ListUsers.class));
		int totalPages=Integer.parseInt(listUsers.get(0).getTotal_pages());
		for(int i=2;i<=totalPages;i++)
		{
			map.put("page",String.valueOf(i));
			Response response2=JSONUtil.getInstance().jsonGetQueryParams(map,url);
			listUsers.add(mapper.readValue(response2.body().asString(), ListUsers.class));
		}
		return listUsers;
	}

	/**
	 * update user API request hit
	 * @param data
	 * @return
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	public static UpdateUser getUpdateResponse(Map<String, String> data) throws JsonMappingException, JsonProcessingException {
		String url=APIURL.getCreatePost();
		CreateRequest request=new CreateRequest();
		request.setName(data.get("Name"));
		request.setJob(data.get("Job"));
		ObjectMapper mapper=new ObjectMapper();		
		String response=JSONUtil.getInstance().jsonPut(mapper.writeValueAsString(request),url);
		return mapper.readValue(response, UpdateUser.class);
	}

	/*
	 * delete user API request hit
	 * 
	 */
	/**
	 * delete user API request hit
	 * @param data
	 * @return
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	public static Response getDeleteResponse(Map<String, String> data) throws JsonMappingException, JsonProcessingException {
		
		String url=APIURL.getDelete();
		ObjectMapper mapper=new ObjectMapper();		
		Response response=JSONUtil.getInstance().jsonDeleteWithPathParams(data,url);
		return response;
	}
}
