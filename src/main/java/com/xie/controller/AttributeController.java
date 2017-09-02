package com.xie.controller;

import com.xie.bean.Attribute;
import com.xie.controller.api.BaseController;
import com.xie.response.BaseResponse;
import com.xie.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xie on 17/8/30.
 */
@Controller
@RequestMapping("/attribute")
public class AttributeController extends BaseController {

    @Autowired
    private AttributeService attributeService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse detail(@PathVariable(value = "id") int id, Model model) {
        Attribute attribute = attributeService.selectByPrimaryKey(id);
        return BaseResponse.ok(attribute);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse delete(@RequestParam(value = "id") int id) {
        if (attributeService.deleteByPrimaryKey(id) > 0) {
            return BaseResponse.ok();
        }
        return BaseResponse.fail();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse add(@RequestParam(value = "attributeCategoryId") int attributeCategoryId,
                            @RequestParam(value = "name") String name,
                            @RequestParam(value = "inputType") int inputType,
                            @RequestParam(value = "sortOrder") short sortOrder) {
        Attribute attribute = new Attribute();
        attribute.setAttributeCategoryId(attributeCategoryId);
        attribute.setName(name);
        attribute.setInputType(inputType);
        attribute.setSortOrder(sortOrder);
        attributeService.insert(attribute);
        if (attribute.getId() > 0) {
            return BaseResponse.ok();
        }
        return BaseResponse.fail();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse update(@RequestParam(value = "attributeCategoryId") int attributeCategoryId,
                               @RequestParam(value = "id") int id,
                               @RequestParam(value = "name") String name,
                               @RequestParam(value = "inputType") int inputType,
                               @RequestParam(value = "sortOrder") short sortOrder) {
        Attribute attribute = new Attribute();
        attribute.setId(id);
        attribute.setAttributeCategoryId(attributeCategoryId);
        attribute.setName(name);
        attribute.setInputType(inputType);
        attribute.setSortOrder(sortOrder);
        attributeService.updateByPrimaryKey(attribute);
        if (attribute.getId() > 0) {
            return BaseResponse.ok();
        }
        return BaseResponse.fail();
    }
}
