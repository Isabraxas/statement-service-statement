package cc.viridian.service.statement.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ListAccountsResponse {
    private Long recordsTotal;
    private Long recordsFiltered;
    private List<AccountsRegistered> data;
}
