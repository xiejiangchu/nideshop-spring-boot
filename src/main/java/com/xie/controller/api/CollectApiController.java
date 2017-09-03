package com.xie.controller.api;

import com.xie.bean.Collect;
import com.xie.request.CollectAddOrDeleteRequest;
import com.xie.response.BaseResponse;
import com.xie.service.CollectService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xie on 17/8/28.
 */
@Controller
@RequestMapping(value = "/api/collect")
public class CollectApiController extends BaseController {

    @Autowired
    private CollectService collectService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse index() {
        return BaseResponse.ok();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse list(@RequestParam(value = "typeId") int typeId) {
        return BaseResponse.ok(collectService.selectByUid(getUid(), typeId));
    }

    @RequestMapping(value = "/addOrDelete", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse addOrDelete(@RequestBody CollectAddOrDeleteRequest collectAddOrDeleteRequest) {
        Collect collect = collectService.selectByParams(getUid(), collectAddOrDeleteRequest.getTypeId(), collectAddOrDeleteRequest.getValueId());
        if (collect == null) {
            Collect insert = new Collect();
            insert.setTypeId(collectAddOrDeleteRequest.getTypeId());
            insert.setUserId(getUid());
            insert.setValueId(collectAddOrDeleteRequest.getValueId());
            insert.setAddTime(DateTime.now().toDate());
            insert.setIsAttention(0);
            collectService.insert(insert);
            return BaseResponse.ok("add");
        } else {
            collectService.deleteByPrimaryKey(collect.getId());
            return BaseResponse.ok("delete");
        }
    }
}
