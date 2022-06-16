import com.yxf.mycompose.single.GsonSingleton
import com.yxf.vehicleinspection.bean.request.CommonRequest

/**
 *   author:yxf
 *   time:2022/6/16
 */
/**
 * 将请求实体类包装通用请求jsonString
 * @param element 请求实体类实例化对象
 * @return String
 */
fun <T> getJsonData(element : T) : String{
    val requestArray = ArrayList<T>()
    requestArray.add(element)
    return GsonSingleton.instance.toJson(CommonRequest(requestArray))
}