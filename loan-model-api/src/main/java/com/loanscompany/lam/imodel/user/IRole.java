package com.loanscompany.lam.imodel.user;

import com.loanscompany.lam.imodel.general.ITimeActiveRecordEntity;
import com.loanscompany.lam.utility.enums.RoleName;

/**
 * The interface for roles assigned to a user
 *
 * @author percym
 */
public interface IRole extends ITimeActiveRecordEntity {

    /*
    * Gets the current role a user is assigned in the system'
    *
    * @return roleName
    * */
    RoleName getRoleName();

    /*
     * Sets the current role a user is assigned in the system'
     *
     * @param roleName
     * */
    void setRoleName(RoleName roleName);


}
