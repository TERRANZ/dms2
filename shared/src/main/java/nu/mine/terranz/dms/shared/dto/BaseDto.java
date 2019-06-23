package nu.mine.terranz.dms.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseDto {
    protected String id;
    protected LocalDateTime createDate, modifiedDate;
    protected String name;
}
