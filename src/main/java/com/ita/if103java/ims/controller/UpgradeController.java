package com.ita.if103java.ims.controller;

import com.ita.if103java.ims.dto.AccountTypeDto;
import com.ita.if103java.ims.security.UserDetailsImpl;
import com.ita.if103java.ims.service.UpgradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/upgrade")
@CrossOrigin("http://localhost:4200")
public class UpgradeController {
    private UpgradeService upgradeService;

    @Autowired
    public UpgradeController(UpgradeService upgradeService) {
        this.upgradeService = upgradeService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{typeId}")
    public void upgrade(@AuthenticationPrincipal UserDetailsImpl user, @PathVariable("typeId") Long typeId) {
        upgradeService.upgradeAccount(user.getUser(), typeId);
    }

    @GetMapping(value = "/")
    public AccountTypeDto findCurrentType(@AuthenticationPrincipal UserDetailsImpl user) {
        return upgradeService.findById(user.getUser().getAccountId());
    }

    @GetMapping(value = "/all")
    public List<AccountTypeDto> findAll() {
        return upgradeService.findAll();
    }

    @GetMapping(value = "/all-possible")
    public List<AccountTypeDto> findAllPossible(@AuthenticationPrincipal UserDetailsImpl user) {
        return upgradeService.findAllPossibleToUpgrade(user.getUser().getAccountId());
    }
}
