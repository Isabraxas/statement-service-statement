package cc.viridian.service.statement.controller;

import cc.viridian.service.statement.service.AccountService;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    ServerRuntime mainServerRuntime;

    @Autowired
    AccountService accountService;
/*
    @RequestMapping("/transaction")
    public  List<Account> listTransactions(
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
*/
}
