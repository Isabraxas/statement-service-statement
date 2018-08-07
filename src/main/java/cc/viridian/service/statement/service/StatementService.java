package cc.viridian.service.statement.service;

import cc.viridian.service.statement.payload.ListAccountsResponse;
import cc.viridian.service.statement.payload.PostRegisterAccount;
import cc.viridian.service.statement.repository.StatementMainRepository;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@NoArgsConstructor
@Service
public class StatementService {

    private StatementMainRepository statementMainRepository;

    @Autowired
    public StatementService(StatementMainRepository statementMainRepository) {
        this.statementMainRepository = statementMainRepository;
    }


    public String registerNewAccount(PostRegisterAccount body) {
        return statementMainRepository.registerNewAccount(body);
    }


    public ListAccountsResponse listAccounts(Integer start, Integer length)
    {
        return statementMainRepository.listAccounts(start, length);
    }

}
