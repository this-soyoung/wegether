package com.wegether.app.controller;

import com.wegether.app.domain.dto.DataDTO;
import com.wegether.app.domain.dto.Pagination;
import com.wegether.app.domain.vo.DataVO;
import com.wegether.app.service.account.AccountService;
import com.wegether.app.service.data.DataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/datas/*")
public class DataController {
    private final DataService dataService;
    private final AccountService accountService;

//    목록 조회
    @GetMapping("list")
    public void goToDataList(Pagination pagination, Model model){
        pagination.setTotal(dataService.getTotal());
        pagination.progress();
        model.addAttribute("consults", dataService.getList(pagination));
    }
//
////    목록 조회
//    @GetMapping("list")
//    public void goToConsultingList(Pagination pagination, Model model){
//        pagination.setTotal(dataService.getTotal());
//        pagination.progress();
//        model.addAttribute("consults", dataService.getList(pagination));
//    }

//    자료 등록
    @GetMapping("register")
        public void goToRegisterForm(DataVO dataVO, HttpSession session, Model model){

        String nickName = accountService.getMemberById((Long) session.getAttribute("id")).get().getMemberNickname();
        model.addAttribute("nickName", nickName);
    };

//    자료 등록 > 리스트 이동
    @PostMapping("register")
    public RedirectView write(DataDTO dataDTO){
        dataService.write(dataDTO);
        return new RedirectView("/data/list");
    }

    @GetMapping(value = {"detail", "modify"})
    public void read(Long id, Model model){
        model.addAttribute("data", dataService.read(id));
    }

//    @PostMapping("modify")
//    public RedirectView modify(DataDTO dataDTO, RedirectAttributes redirectAttributes){
//        dataService.modify(dataDTO);
//        redirectAttributes.addAttribute("id", dataDTO.getId());
//        return new RedirectView("/data/detail");
//    }
//
//    @PostMapping("remove")
//    public RedirectView remove(Long id){
//        dataService.remove(id);
//        return new RedirectView("/data/list");
//    }

}





















