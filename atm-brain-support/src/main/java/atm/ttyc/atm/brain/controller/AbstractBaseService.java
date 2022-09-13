package atm.ttyc.atm.brain.controller;

import atm.ttyc.atm.brain.contants.ErrorCodes;
import com.alibaba.fastjson.JSONObject;
import com.sg.growth.http.HttpApiClient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractBaseService {
    protected String accessApiPostWithOutUser(String apiUrl, JSONObject params) {
        try {
            return HttpApiClient.doPost(apiUrl, params);
        } catch (Exception e) {
            log.warn("invoke {} error is {}", apiUrl, e.getMessage(),e);
            throw ErrorCodes.userDefineException(10001, "清除本机缓存失败:"+e.getMessage());
        }
    }

    protected JSONObject buildBody(Object params) {
        JSONObject body = new JSONObject();
        body.put("params", params);
        return body;
    }

}
