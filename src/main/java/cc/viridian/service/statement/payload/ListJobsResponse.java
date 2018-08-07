package cc.viridian.service.statement.payload;

import cc.viridian.service.statement.model.StatementJobModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
/**
 * Response for DataTable
 */
public class ListJobsResponse {
    private Long recordsTotal;
    private Long recordsFiltered;
    private List<StatementJobModel> data;
}
