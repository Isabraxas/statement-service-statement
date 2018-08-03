package cc.viridian.service.statement.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PostRegisterAccount {
    private String account;
    private String currency;
    private String type;
    private String frequency;
}
