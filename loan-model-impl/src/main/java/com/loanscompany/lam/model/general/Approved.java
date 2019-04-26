package com.loanscompany.lam.model.general;

import com.loanscompany.lam.imodel.general.IActive;
import com.loanscompany.lam.imodel.general.IApproved;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Active entity bean for getting approved records.
 *
 * @author percym
 */
@MappedSuperclass
@Audited
public abstract class Approved extends TimeActiveRecord implements IApproved {

    private static final long serialVersionUID = 8662079809319279877L;


    @NotNull
    @Column(name = "zz_approved", length = 1, columnDefinition = "BOOLEAN DEFAULT '1'")
    private Boolean approved;


    @Override
    public Boolean getApproved() {
        return approved;
    }

    @Override
    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getApproved());
    }

    @Override
    public boolean equals(final Object obj) {

        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof IActive)) {
            return false;
        }
        final IApproved other = (IApproved) obj;
        return Objects.equals(getApproved(), other.getApproved());

    }
}