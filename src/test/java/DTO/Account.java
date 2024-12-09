package DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Account {
    private String accountName;
    private String phone;
    private String fax;
    private String rating;
    private String accountSite;
    private String industry;
    private String ownership;
    private String employees;
    private String parentAccount;
    private String street;
    private String type;
}
