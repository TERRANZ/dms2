package nu.mine.terranz.dms.server.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import nu.mine.terranz.dms.server.constants.DmsConstants;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DmsObjectField {
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false, length = 35)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate = LocalDateTime.now();

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @JsonIgnore
    @JoinColumn(name = "object_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private DmsObject dmsObject;

    @Basic(optional = false)
    @Column(nullable = false, length = 256)
    private String name;

    @Basic(optional = false)
    @Column(nullable = false)
    private DmsConstants.DmsTypes type;

    private Integer intval;

    private Long longval;

    @Column(length = 2048)
    private String strval;

    @Column(precision = 22)
    private Double floatval;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateval;

    @Column(length = 4096)
    private String listval;

    public DmsObjectField(final DmsObject dmsObject, final String name, final DmsConstants.DmsTypes type) {
        this.dmsObject = dmsObject;
        this.name = name;
        this.type = type;
    }
}
