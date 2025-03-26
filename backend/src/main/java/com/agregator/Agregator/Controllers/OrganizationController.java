package com.agregator.Agregator.Controllers;

import com.agregator.Agregator.DTO.CreateOrganizationDTO;
import com.agregator.Agregator.DTO.OrganizationDTO;
import com.agregator.Agregator.Entity.Organization;
import com.agregator.Agregator.Services.OrganizationService;
import com.agregator.Agregator.Services.RegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequiredArgsConstructor
@RequestMapping("/organization")
public class OrganizationController {
    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private OrganizationService organizationService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody CreateOrganizationDTO dto) {
        try {
            organizationService.createOrganization(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Организация создана");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ошибка при создании организации");
        }
    }

}
