package nu.mine.terranz.dms.server.service;

import nu.mine.terranz.dms.server.db.entity.DmsObject;
import nu.mine.terranz.dms.server.db.repository.DmsObjectRepo;
import nu.mine.terranz.dms.shared.dto.DmsObjectDto;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.time.LocalDateTime.now;

@Service
public class DmsObjectService {
    private final DmsObjectRepo dmsObjectRepo;
    private final DmsObjectFieldService dmsObjectFieldService;

    public DmsObjectService(final DmsObjectRepo dmsObjectRepo, final DmsObjectFieldService dmsObjectFieldService) {
        this.dmsObjectRepo = dmsObjectRepo;
        this.dmsObjectFieldService = dmsObjectFieldService;
    }

    public DmsObjectDto mapDto(final DmsObject dmsObject) {
        return DmsObjectDto.builder()
                .id(dmsObject.getId())
                .createDate(dmsObject.getCreatedDate())
                .modifiedDate(dmsObject.getModifiedDate())
                .fieldList(dmsObject.getFieldList().parallelStream().map(of ->
                        dmsObjectFieldService.mapDto(of, dmsObject.getId())
                ).collect(Collectors.toList()))
                .name(dmsObject.getName())
                .build();
    }

    public DmsObject mapEntity(final DmsObjectDto dmsObjectDto, final String currentUser) {
        final DmsObject ret = dmsObjectRepo.findById(dmsObjectDto.getId()).orElseGet(() -> DmsObject.builder()
                .id(dmsObjectDto.getId())
                .userId(currentUser)
                .fieldList(Lists.newArrayList())
                .createdDate(now())
                .name(dmsObjectDto.getName())
                .build());
        ret.setModifiedDate(now());
        if (dmsObjectDto.getFieldList() != null && dmsObjectDto.getFieldList().size() > 0) {
            ret.getFieldList().addAll(
                    dmsObjectDto.getFieldList()
                            .parallelStream()
                            .map(fieldDto -> dmsObjectFieldService.mapEntity(fieldDto, ret)).collect(Collectors.toList())
            );
        }
        return ret;
    }

    public Optional<DmsObject> findById(final String id) {
        return dmsObjectRepo.findById(id);
    }
}
