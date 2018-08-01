package cc.viridian.service.statement.payload;

import java.util.List;

public class ListJobsResponse {
    private Long recordsTotal;
    private Long recordsFiltered;
    private List<Jobs> data;

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

    public List<Jobs> getData() {
        return data;
    }

    public void setData(List<Jobs> data) {
        this.data = data;
    }

    public ListJobsResponse() {
    }

    public ListJobsResponse(Long recordsTotal, Long recordsFiltered, List<Jobs> data) {
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsFiltered;
        this.data = data;
    }
}
