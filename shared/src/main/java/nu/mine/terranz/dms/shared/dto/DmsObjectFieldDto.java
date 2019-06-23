package nu.mine.terranz.dms.shared.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DmsObjectFieldDto extends BaseDto {
    private String dmsObjectId;
    private String type;
    private Integer intVal;
    private Long longVal;
    private String strVal;
    private Double floatVal;
    private Long dateVal;
    private String listVal;

    @Builder
    public DmsObjectFieldDto(final String id, final LocalDateTime createDate, final LocalDateTime modifiedDate, final String name, final String dmsObjectId, final String type, final Integer intVal, final Long longVal, final String strVal, final Double floatVal, final Long dateVal, final String listVal) {
        super(id, createDate, modifiedDate, name);
        this.dmsObjectId = dmsObjectId;
        this.type = type;
        this.intVal = intVal;
        this.longVal = longVal;
        this.strVal = strVal;
        this.floatVal = floatVal;
        this.dateVal = dateVal;
        this.listVal = listVal;
    }
}
