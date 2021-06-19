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
	
	private static APIRequests api_requests_instance;
	  
    
    public static APIRequests getInstance()
    {
        if (api_requests_instance == null)
        {
        	api_requests_instance = new APIRequests();
        }
        return api_requests_instance;
    }
	
	
	/**
	 * register successful API request hit
	 * @param data
	 * @return
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	public RegisterSuccessfulResponse getRegisterSuccessfulResponse(Map<String,String> data) throws  JsonProcessingException
	{		
		String url=APIURL.getRegisterSuccessful();
		RegisterSuccessfulRequest request=new RegisterSuccessfulRequest();
		request.setEmail(data.get("Email"));
		request.setPassword(data.get("Password"));
		ObjectMapper mapper=new ObjectMapper();		
		String response=JSONUtil.getInstance().executeJsonPost(mapper.writeValueAsString(request),url);
		return mapper.readValue(response, RegisterSuccessfulResponse.class);
		
	}

	/**
	 * create API request hit
	 * @param data
	 * @return
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	public CreateResponse getCreateResponse(Map<String,String> data) throws  JsonProcessingException
	{
		String url=APIURL.getCreatePost();
		CreateRequest request=new CreateRequest();
		request.setName(data.get("Name"));
		request.setJob(data.get("Job"));
		ObjectMapper mapper=new ObjectMapper();		
		String response=JSONUtil.getInstance().executeJsonPost(mapper.writeValueAsString(request),url);
		return mapper.readValue(response, CreateResponse.class);
		
	}

	/**
	 * single user API request hit
	 * @param data
	 * @return
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	public SingleUser getSingleUserResponse(Map<String, String> data) throws  JsonProcessingException {
		String url=APIURL.getSingleUserGet();
		ObjectMapper mapper=new ObjectMapper();		
		String response=JSONUtil.getInstance().executeJsonGetPathParameter(url,data);
		return mapper.readValue(response, SingleUser.class);
	}	
	/**
	 * List users API request hit
	 * @return
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	public List<ListUsers> getListUsersResponse() throws  JsonProcessingException {
		
		String url=APIURL.getListUsersGet();
		List<ListUsers> listUsers=new ArrayList<>();
		ObjectMapper mapper=new ObjectMapper();	
		Map<String,String> map=new HashedMap<>();
		map.put("page", "1");
		Response response=JSONUtil.getInstance().executeJsonGetQueryParams(map,url);
		listUsers.add(mapper.readValue(response.body().asString(), ListUsers.class));
		int totalPages=Integer.parseInt(listUsers.get(0).getTotal_pages());
		for(int i=2;i<=totalPages;i++)
		{
			map.put("page",String.valueOf(i));
			Response response2=JSONUtil.getInstance().executeJsonGetQueryParams(map,url);
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
	public UpdateUser getUpdateResponse(Map<String, String> data) throws  JsonProcessingException {
		String url=APIURL.getCreatePost();
		CreateRequest request=new CreateRequest();
		request.setName(data.get("Name"));
		request.setJob(data.get("Job"));
		ObjectMapper mapper=new ObjectMapper();		
		String response=JSONUtil.getInstance().executeJsonPut(mapper.writeValueAsString(request),url);
		return mapper.readValue(response, UpdateUser.class);
	}

	/**
	 * delete user API request hit
	 * @param data
	 * @return Response restassured response
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	@SuppressWarnings("unused")
	public Response getDeleteResponse(Map<String, String> data) throws  JsonProcessingException {
		
		String url=APIURL.getDelete();
		ObjectMapper mapper=new ObjectMapper();		
		Response response=JSONUtil.getInstance().executeJsonDeleteWithPathParams(data,url);
		return response;
	}
}
