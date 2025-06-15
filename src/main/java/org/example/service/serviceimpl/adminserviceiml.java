package org.example.service.serviceimpl;

import lombok.RequiredArgsConstructor;
import org.example.dto.AdminDto;
import org.example.entity.AdminEntity;
import org.example.repostory.adminrepostory;
import org.example.service.Adminservice;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class adminserviceiml implements Adminservice {

    private final ModelMapper modelMapper;
    private final adminrepostory adminrepostory;

    @Override
    public void add(AdminDto adminDto) {
        adminrepostory.save(modelMapper.map(adminDto,AdminEntity.class));
    }

    @Override
    public List<AdminDto> getAllAdmins() {
        List<AdminDto> adminDtoList = new ArrayList<>();
        List<AdminEntity> adminEntities = adminrepostory.findAll();

        for (AdminEntity entity : adminEntities) {
            adminDtoList.add(modelMapper.map(entity, AdminDto.class));
        }
        return adminDtoList;
    }

    @Override
    public AdminDto getAdminById(Long adminId) {
        return modelMapper.map(adminrepostory.findById(adminId), AdminDto.class);
    }

    @Override
    public void updateAdmin(Long adminId, AdminDto adminDto) {
        adminrepostory.save(modelMapper.map(adminDto, AdminEntity.class));

    }

    @Override
    public void deleteAdmin(Long adminId) {
       adminrepostory.deleteById(adminId);
    }
}
