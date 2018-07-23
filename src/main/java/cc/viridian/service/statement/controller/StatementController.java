package cc.viridian.service.statement.controller;

import cc.viridian.service.statement.payload.AccountsRegistered;
import cc.viridian.service.statement.payload.PostRegisterAccount;
import cc.viridian.service.statement.payload.ListAccountsResponse;
import cc.viridian.service.statement.service.StatementService;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class StatementController {

    @Autowired
    ServerRuntime mainServerRuntime;

    @Autowired
    StatementService statementService;

    @RequestMapping(method = RequestMethod.POST, value="/account")
    @ResponseBody
    public String registerNewAccount(
        @RequestBody PostRegisterAccount body)
    {
        return statementService.registerNewAccount(body);
    }

    @RequestMapping("/account")
    public ListAccountsResponse listAccounts(
        @RequestParam(value= "start", required = false, defaultValue = "0") Integer start,
        @RequestParam(value= "length", required = false, defaultValue = "25") Integer length
    ) {
        return statementService.listAccounts(start, length);
    }

}
