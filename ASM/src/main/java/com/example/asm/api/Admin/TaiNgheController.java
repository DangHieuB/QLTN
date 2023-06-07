package com.example.asm.api.Admin;

import com.example.asm.entities.TaiNghe;
import com.example.asm.service.ITaiNgheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
@RequestMapping("/ASM/quan-ly-tai-nghe")
public class TaiNgheController {

    private Page<TaiNghe> pageTaiNghe;

    @Autowired
    ITaiNgheService taiNgheService;

    @GetMapping("home")
    public String home(Model model, @RequestParam(defaultValue = "1") int page){
        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 10);
        pageTaiNghe = taiNgheService.getAll(pageable);
        model.addAttribute("page", pageTaiNghe);
        return"/Auth/index";
    }

    @PostMapping("/add")
    public String add(@Validated TaiNghe tn, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/ASM/quan-ly-tai-nghe";
        }
        taiNgheService.addTaiNghe(tn);
        return "redirect:/ASM/quan-ly-tai-nghe";
    }

    @PostMapping("/update/{taiNgheId}")
    public String update(@PathVariable(name = "taiNgheId") Integer taiNgheId, @Validated TaiNghe tn, BindingResult result) {
        if (result.hasErrors()) {
            tn.setTaiNgheId(taiNgheId);
            return "redirect:/ASM/quan-ly-tai-nghe";
        }
        taiNgheService.updateTaiNghe(tn);
        return "redirect:/ASM/quan-ly-tai-nghe";
    }

//    @GetMapping("/detail/{taiNgheId}")
//    public String detail(Model model, @PathVariable(name = "taiNgheId") Integer taiNgheId) {
//        listTN = taiNgheService.getAll();
//        model.addAttribute("listTN", listTN);
//        TaiNghe tn = taiNgheService.getById(taiNgheId);
//        model.addAttribute("Detail", tn);
//        return "TaiNghe/tai-nghe";
//    }

    @GetMapping("/delete/{taiNgheId}")
    public String delete(Model model, @PathVariable(name = "taiNgheId") Integer taiNgheId) {
        TaiNghe tn = taiNgheService.getById(taiNgheId);
        taiNgheService.deleteTaiNghe(tn);
        return "redirect:/ASM/quan-ly-tai-nghe";
    }

    @GetMapping("/view-update/{taiNgheId}")
    public String ViewUpdate(Model model, @PathVariable(name = "taiNgheId") Integer taiNgheId) {
        TaiNghe tn = taiNgheService.getById(taiNgheId);
        model.addAttribute("Detail", tn);
        return "/Admin/quan-ly-tai-nghe";
    }



    @GetMapping("/search")
    public String Search(Model model,@RequestParam(defaultValue = "1") int page,
                                    @RequestParam(required = false) String tenTaiNghe,
                                    @RequestParam(required = false) BigDecimal giaMin,
                                    @RequestParam(required = false) BigDecimal giaMax) {
        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 10);
        if(tenTaiNghe == null) {
            pageTaiNghe = taiNgheService.findByPriceBeetween(giaMin, giaMax, pageable);
        }else if (giaMax == null && giaMin == null) {
            pageTaiNghe = taiNgheService.findByTen(tenTaiNghe, pageable);
        }else if(giaMin == null){
            pageTaiNghe = taiNgheService.findByTenTaiNgheContainsAndDonGiaBefore(tenTaiNghe, giaMax, pageable);
        }else if(giaMax == null){
            pageTaiNghe = taiNgheService.findByTenTaiNgheContainsAndDonGiaAfter(tenTaiNghe, giaMin, pageable);
        }else {
            pageTaiNghe = taiNgheService.findByPriceAndTen(tenTaiNghe, giaMin, giaMax, pageable);
        }
        model.addAttribute("page", pageTaiNghe);
        return "/Admin/quan-ly-tai-nghe";
    }
}
