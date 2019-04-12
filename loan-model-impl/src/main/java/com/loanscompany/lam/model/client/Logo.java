package com.loanscompany.lam.model.client;


import com.health263.imodel.client.ILogo;
import com.health263.model.general.PrimaryKeyBean;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author percym
 * <p>
 * Implementation for the client class
 */
@Entity
@Audited
@Data
@NoArgsConstructor
@Table(schema = "data", name = "logo")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "logo_serial")),
        @AttributeOverride(name = "createdBy", column = @Column(name = "logo_created_by")),
        @AttributeOverride(name = "createdOn", column = @Column(name = "logo_created_on")),
        @AttributeOverride(name = "updatedBy", column = @Column(name = "logo_updated_by")),
        @AttributeOverride(name = "updatedOn", column = @Column(name = "logo_updated_on")),
        @AttributeOverride(name = "active", column = @Column(name = "logo_is_active"))
})
@SequenceGenerator(name = "default_seq", schema = "data", sequenceName = "logo_serial_seq", allocationSize = 1)
public class Logo extends PrimaryKeyBean implements ILogo  {

    private static final long serialVersionUID = -7896223980396662140L;


    @NotNull
    @Column(name = "file_name")
    private String fileName;

    @NotNull
    @Column(name = "file_download_uri")
    private String fileDownloadUri;

    @NotNull
    @Column(name = "file_type")
    private String fileType;

    @NotNull
    @Column(name = "size")
    private Long size;

//    @Column(name = "zz_start_date", updatable = false, nullable = false)
//    private LocalDateTime startDate;
//
//    @Column(name = "zz_end_date", updatable = false)
//    private LocalDateTime endDate;


}
