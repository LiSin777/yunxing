package com.qing.boot.controller;

import com.qing.boot.domain.Account;
import com.qing.boot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/account/all")
    public List<Account> findAll() {
        return accountService.findAll();
    }

    @RequestMapping("/account/save")
    public void saveAccount(@RequestBody Account account) {
        accountService.insert(account);
    }

    @RequestMapping("/account/transfer")
    public void transfer(@RequestParam("remitterId") String remitterId, @RequestParam("remitteeId") String remitteeId,
                         @RequestParam("money") int money) {
        accountService.transfer(remitterId,remitteeId,money);
    }
}
