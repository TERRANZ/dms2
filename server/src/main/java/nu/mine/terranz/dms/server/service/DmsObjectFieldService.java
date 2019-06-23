package nu.mine.terranz.dms.server.service;

import nu.mine.terranz.dms.server.constants.DmsConstants.DmsTypes;
import nu.mine.terranz.dms.server.db.entity.DmsObject;
import nu.mine.terranz.dms.server.db.entity.DmsObjectField;
import nu.mine.terranz.dms.server.db.repository.DmsObjectFieldRepo;
import nu.mine.terranz.dms.shared.dto.DmsObjectFieldDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class DmsObjectFieldService {
    @Autowired
    private DmsObjectFieldRepo dmsObjectFieldRepo;

    public DmsObjectFieldDto mapDto(final DmsObjectField of, final String objectId) {
        final DmsObjectFieldDto ret = DmsObjectFieldDto.builder()
                .dmsObjectId(objectId)
                .type(of.getType().name())
                .createDate(of.getCreatedDate())
                .id(of.getId())
                .name(of.getName())
                .modifiedDate(of.getModifiedDate())
                .build();
        switch (of.getType()) {
            case STRING:
                ret.setStrVal(of.getStrval());
                break;
            case INT:
                ret.setIntVal(of.getIntval());
                break;
            case LONG:
                ret.setLongVal(of.getLongval());
                break;
            case FLOAT:
                ret.setFloatVal(of.getFloatval());
                break;
            case DATE:
                ret.setDateVal(of.getDateval().getTime());
                break;
            case LIST:
                ret.setListVal(of.getListval());
                break;
        }
        return ret;
    }

    public DmsObjectField mapEntity(final DmsObjectFieldDto dto, final DmsObject dmsObject) {
        final DmsObjectField ret = dmsObjectFieldRepo.findById(dto.getId())
                .orElseGet(() -> new DmsObjectField(dmsObject, dto.getName(), DmsTypes.valueOf(dto.getType())));

        ret.setModifiedDate(LocalDateTime.now());
        switch (ret.getType()) {
            case STRING:
                ret.setStrval(dto.getStrVal());
                break;
            case INT:
                ret.setIntval(dto.getIntVal());
                break;
            case LONG:
                ret.setLongval(dto.getLongVal());
                break;
            case FLOAT:
                ret.setFloatval(dto.getFloatVal());
                break;
            case DATE:
                ret.setDateval(new Date(dto.getDateVal()));
                break;
            case LIST:
                ret.setListval(dto.getListVal());
                break;
        }

        return ret;
    }
}
