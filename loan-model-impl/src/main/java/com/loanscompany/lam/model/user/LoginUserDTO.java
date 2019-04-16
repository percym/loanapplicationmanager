package com.loanscompany.lam.model.user;

import lombok.Data;
import lombok.ToString;

/**
 * @author percym
 * <p>
 * Login DTO
 */
@Data
@ToString(callSuper = true)
public class LoginUserDTO {

    private String userName;

    private String password;

}
