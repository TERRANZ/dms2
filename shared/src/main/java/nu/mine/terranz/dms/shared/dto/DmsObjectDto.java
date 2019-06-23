package nu.mine.terranz.dms.shared.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class DmsObjectDto extends BaseDto {

    private List<DmsObjectFieldDto> fieldList;

    @Builder
    public DmsObjectDto(final String id, final LocalDateTime createDate, final LocalDateTime modifiedDate, final String name, final List<DmsObjectFieldDto> fieldList) {
        super(id, createDate, modifiedDate, name);
        this.fieldList = fieldList;
    }
}
