/**
 * 
 */
package prjframework.sunaynatalreja.framework.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.graph.Graph;

/**
 * @author Sunayna Talreja
*/
public class Cache {
	
	private static Cache cache_instance = null;
	  
    // variable of type String
    
	static Map<String,String> testDataCache;
    // private constructor restricted to this class itself
    private Cache()
    {
    	testDataCache=new ConcurrentHashMap<>();
    }
  
    // static method to create instance of Singleton class
    public static Cache getInstance()
    {
        if (cache_instance == null)
        	cache_instance = new Cache();
  
        return cache_instance;
    }
    
    public static void putVal(String key, String val)
    {
    	testDataCache.put(key, val);
    }
    
    public static String getVal(String key)
    {
    	return testDataCache.get(key);
    }

}
