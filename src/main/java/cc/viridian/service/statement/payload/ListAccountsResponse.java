package cc.viridian.service.statement.payload;

import java.util.List;

public class ListAccountsResponse {
    private Long recordsTotal;
    private Long recordsFiltered;
    private List<AccountsRegistered> data;

    public Long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<AccountsRegistered> getData() {
        return data;
    }

    public void setData(List<AccountsRegistered> data) {
        this.data = data;
    }

    public ListAccountsResponse() {
    }

    public ListAccountsResponse(Long recordsTotal, Long recordsFiltered, List<AccountsRegistered> data) {
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsFiltered;
        this.data = data;
    }
}
