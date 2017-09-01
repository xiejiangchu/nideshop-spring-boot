package com.xie.controller;

import com.github.pagehelper.PageInfo;
import com.xie.bean.Specification;
import com.xie.controller.api.BaseController;
import com.xie.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xie on 17/8/31.
 */
@Controller
@RequestMapping("/specification")
public class SpecificationController extends BaseController {

    @Autowired
    private SpecificationService specificationService;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String index(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                        @RequestParam(value = "pageSize", defaultValue = "20") int pageSize,
                        Model model) {
        setHeaderData(model);
        model.addAttribute("title", "商品规格");
        PageInfo<Specification> specificationPageInfo = specificationService.select(pageNum, pageSize);
        model.addAttribute("specificationPageInfo", specificationPageInfo);
        model.addAttribute("specificationCount", specificationService.count());
        return "specification";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable(value = "id") int id, Model model) {
        setHeaderData(model);
        model.addAttribute("title", "商品规格详情");

        Specification specification = specificationService.selectByPrimaryKey(id);
        model.addAttribute("specification", specification);
        return "specificationDetail";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestParam("id") int id,
                         @RequestParam("name") String name,
                         @RequestParam("sortOrder") short sortOrder) {
        Specification specification = new Specification();
        specification.setId(id);
        specification.setName(name);
        specification.setSortOrder((byte) sortOrder);

        specificationService.updateByPrimaryKey(specification);
        return "redirect:/specification";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAdd(Model model) {
        setHeaderData(model);
        model.addAttribute("title", "商品规格新增");
        return "specificationAdd";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestParam("name") String name,
                      @RequestParam("sortOrder") short sortOrder) {
        Specification specification = new Specification();
        specification.setName(name);
        specification.setSortOrder((byte) sortOrder);

        specificationService.insert(specification);
        return "redirect:/specification";
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id") int id,
                         @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                         @RequestParam(value = "pageSize", defaultValue = "20") int pageSize) {

        specificationService.deleteByPrimaryKey(id);
        return "forward:/specification?pageNum=" + pageNum + "&pageSize=" + pageSize;
    }
}
