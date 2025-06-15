package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.AdminDto;
import org.example.service.Adminservice;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin")
@RequiredArgsConstructor //final fields and nonnull to genaret constructor run
public class AdminController {

    private final Adminservice adminservice;

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public void add(@RequestBody AdminDto adminDto){
        adminservice.add(adminDto);
    }

    @GetMapping("/all")
    public List<AdminDto> getAllAdmins() {
        return adminservice.getAllAdmins();
    }

    @GetMapping("/{id}")
    public AdminDto getAdminById(@PathVariable Long id) {
        return adminservice.getAdminById(id);
    }

    @PutMapping("/update/{id}")
    public void updateAdmin(@PathVariable Long id, @RequestBody AdminDto adminDto) {
        adminservice.updateAdmin(id, adminDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAdmin(@PathVariable("id") Long id) {
        adminservice.deleteAdmin(id);
    }

}
