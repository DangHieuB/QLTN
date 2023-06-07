package com.example.asm.api.Client;

import com.example.asm.entities.Role;
import com.example.asm.entities.User;
import com.example.asm.service.IRoleService;
import com.example.asm.service.IUserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;

@Controller
public class UserController {

    @Autowired
    IRoleService roleService;

    @Autowired
    IUserService userService;

    @GetMapping("/sign-up-view")
    public String viewSignUp(){
        return "/Auth/sign-up";
    }

    @GetMapping("/edit-user-view")
    public String viewEditUser(){
        return "/Auth/edit-user";
    }

    @PostMapping("/sign-up-user")
    public String dangKiUser(Model model, HttpServletRequest request){
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String gioiTinh = request.getParameter("gioiTinh");
        String ngaySinh = request.getParameter("ngaySinh");
        String diaChi = request.getParameter("diaChi");
        String sdt = request.getParameter("sdt");
        String email = request.getParameter("email");
        String matKhau = request.getParameter("matKhau");

        Role role = roleService.getById(1);//1:User, 2:Admin

        User u = User.builder()
                .ma(ma)
                .ten(ten)
                .gioiTinh(gioiTinh)
                .ngaySinh(Date.valueOf(ngaySinh))
                .sdt(sdt)
                .diaChi(diaChi)
                .email(email)
                .matKhau(matKhau)
                .trangThai(0)
                .build();

        userService.addUser(u);
        return "redirect:/loginView";
    }

    @PostMapping("/update-user/{id}")
    public String CapNhapUser(Model model, HttpServletRequest request){
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String gioiTinh = request.getParameter("gioiTinh");
        String ngaySinh = request.getParameter("ngaySinh");
        String diaChi = request.getParameter("diaChi");
        String sdt = request.getParameter("sdt");
        String email = request.getParameter("email");
        String matKhau = request.getParameter("matKhau");

        Role role = roleService.getById(1);//1:User, 2:Admin

        User u = User.builder()
                .ma(ma)
                .ten(ten)
                .gioiTinh(gioiTinh)
                .ngaySinh(Date.valueOf(ngaySinh))
                .sdt(sdt)
                .diaChi(diaChi)
                .email(email)
                .matKhau(matKhau)
                .trangThai(0)
                .build();

        userService.addUser(u);
        return "redirect:/client";
    }
}
