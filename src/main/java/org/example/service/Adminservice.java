package org.example.service;

import org.example.dto.AdminDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface Adminservice {

    void add(AdminDto adminDto);

    List<AdminDto> getAllAdmins();

    AdminDto getAdminById(Long adminId);

    void updateAdmin(Long adminId, AdminDto adminDto);

    void deleteAdmin(Long adminId);
}
