package model.json;

import com.google.gson.Gson;
import spark.ResponseTransformer;

/**
 * Created by steve on 2015/9/13.
 */
public class JsonUtil {
    public static ResponseTransformer json() {
        return JsonUtil::toJson;
    }

    public static String toJson(Object o) {
        return new Gson().toJson(o);
    }
}
