/**
 * 
 */
package prjframework.sunaynatalreja.constants;



/**
 * @author Sunayna Talreja
 * API Urls of all api requests
*/
public class APIURL {
	
	private static String registerSuccessful="https://reqres.in/api/register";
	private static String createPost="https://reqres.in/api/users";
	private static String singleUserGet="https://reqres.in/api/users/{Id}";
	private static String listUsersGet="https://reqres.in/api/users";
	private static String updatePut="https://reqres.in/api/users";
	private static String delete="https://reqres.in/api/users/{Id}";

	
	public static String getRegisterSuccessful() {
		return registerSuccessful;
	}
	public static void setRegisterSuccessful(String registerSuccessful) {
		APIURL.registerSuccessful = registerSuccessful;
	}
	public static String getCreatePost() {
		return createPost;
	}
	public static void setCreatePost(String createPost) {
		APIURL.createPost = createPost;
	}
	public static String getSingleUserGet() {
		return singleUserGet;
	}
	public static void setSingleUserGet(String singleUserGet) {
		APIURL.singleUserGet = singleUserGet;
	}
	public static String getListUsersGet() {
		return listUsersGet;
	}
	public static void setListUsersGet(String listUsersGet) {
		APIURL.listUsersGet = listUsersGet;
	}
	public static String getUpdatePut() {
		return updatePut;
	}
	public static void setUpdatePut(String updatePut) {
		APIURL.updatePut = updatePut;
	}
	public static String getDelete() {
		return delete;
	}
	public static void setDelete(String delete) {
		APIURL.delete = delete;
	}
}
