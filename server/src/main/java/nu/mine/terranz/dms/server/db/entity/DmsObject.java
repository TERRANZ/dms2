package nu.mine.terranz.dms.server.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DmsObject {
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

    private String userId;
    private String name;

    @JsonIgnore
    @OneToMany(
            mappedBy = "dmsObject",
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @OrderBy("createdDate ASC")
    private List<DmsObjectField> fieldList;
}
