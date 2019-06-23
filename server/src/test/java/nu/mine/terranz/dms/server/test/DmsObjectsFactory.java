package nu.mine.terranz.dms.server.test;

import nu.mine.terranz.dms.server.db.entity.DmsObject;
import nu.mine.terranz.dms.server.db.entity.DmsObjectField;
import nu.mine.terranz.dms.shared.dto.DmsObjectDto;
import nu.mine.terranz.dms.shared.dto.DmsObjectFieldDto;

import static java.time.LocalDateTime.now;
import static nu.mine.terranz.dms.server.constants.DmsConstants.DmsTypes.STRING;
import static org.assertj.core.util.Lists.newArrayList;

public class DmsObjectsFactory {
    public static DmsObject createObjectEntity() {
        return DmsObject.builder()
                .id("id")
                .createdDate(now())
                .modifiedDate(now())
                .userId("uid")
                .name("name")
                .fieldList(newArrayList())
                .build();
    }

    public static DmsObjectField createObjectFieldEntity(final DmsObject dmsObject) {
        final DmsObjectField dmsObjectField = DmsObjectField.builder()
                .type(STRING)
                .strval("test")
                .createdDate(now())
                .modifiedDate(now())
                .id("id")
                .name("name")
                .build();
        dmsObject.getFieldList().add(dmsObjectField);
        return dmsObjectField;
    }

    public static DmsObjectDto createDmsObjectDto() {
        return DmsObjectDto.builder()
                .modifiedDate(now())
                .createDate(now())
                .fieldList(newArrayList(createDmsObjectFieldDto("id")))
                .id("id")
                .name("name")
                .build();
    }

    public static DmsObjectFieldDto createDmsObjectFieldDto(final String dmsObjectId) {
        final DmsObjectFieldDto dmsObjectFieldDto = DmsObjectFieldDto.builder()
                .modifiedDate(now())
                .createDate(now())
                .id("id")
                .type(STRING.name())
                .name("name")
                .strVal("str")
                .dmsObjectId(dmsObjectId)
                .build();
        return dmsObjectFieldDto;
    }
}
