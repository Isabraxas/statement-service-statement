package cc.viridian.service.statement.controller;

import cc.viridian.service.statement.service.AccountService;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    ServerRuntime mainServerRuntime;

    @Autowired
    AccountService accountService;

    /*
    @RequestMapping("/account")
    //public  List<Account> listAccounts(
    public  String listAccounts(
        @RequestParam(value= "page", required = false, defaultValue = "1") Integer page
    ) {
        return accountService.listAccounts(page);
    }


    @RequestMapping(method = RequestMethod.POST, value="/statement")
    //@ResponseBody
    public Integer newAccount(
        @RequestParam(value= "quantity", required = false, defaultValue = "1") Integer quantity)
        //@RequestBody String body)
    {

        return accountService.createAccounts(quantity);
    }

    @RequestMapping("/account/{number}")
    public  String getAccountByNumber(
        @PathVariable (value= "number", required = false) String number
    ) {
        return accountService.getAccountByNumber(number);
    }

    @RequestMapping(method = RequestMethod.POST, value="/transactions")
    //@ResponseBody
    public Integer newTransactions(
        @RequestParam(value= "quantity", required = false, defaultValue = "1") Integer quantity)
    //@RequestBody String body)
    {

        return accountService.createTransactions(quantity);
    }

    @RequestMapping("/mta/{number}")
    public  String getMtaAccountByNumber(
        @PathVariable (value= "number", required = false) String number
    ) {
        return accountService.createMta(number);
    }

    */
}
