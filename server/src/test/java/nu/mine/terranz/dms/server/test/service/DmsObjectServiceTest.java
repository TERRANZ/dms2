package nu.mine.terranz.dms.server.test.service;

import nu.mine.terranz.dms.server.db.entity.DmsObject;
import nu.mine.terranz.dms.server.db.entity.DmsObjectField;
import nu.mine.terranz.dms.server.db.repository.DmsObjectRepo;
import nu.mine.terranz.dms.server.service.DmsObjectFieldService;
import nu.mine.terranz.dms.server.service.DmsObjectService;
import nu.mine.terranz.dms.server.test.DmsObjectsFactory;
import nu.mine.terranz.dms.shared.dto.DmsObjectDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static nu.mine.terranz.dms.server.test.DmsObjectsFactory.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.util.Assert.notNull;

@RunWith(MockitoJUnitRunner.class)
public class DmsObjectServiceTest {


    private DmsObjectRepo dmsObjectRepo = mock(DmsObjectRepo.class);

    private DmsObjectFieldService dmsObjectFieldService = mock(DmsObjectFieldService.class);

    private DmsObjectService service = new DmsObjectService(dmsObjectRepo, dmsObjectFieldService);

    @Before
    public void setUp() {
        final DmsObjectField mockField = createObjectFieldEntity(createObjectEntity());
        when(dmsObjectFieldService.mapDto(any(), anyString())).thenReturn(createDmsObjectFieldDto("id"));
        when(dmsObjectFieldService.mapEntity(any(), any())).thenReturn(mockField);
    }

    @Test
    public void mapDtoTest() {
        final DmsObject mockObject = DmsObjectsFactory.createObjectEntity();
        DmsObjectsFactory.createObjectFieldEntity(mockObject);

        final DmsObjectDto result = service.mapDto(mockObject);

        notNull(result, "result is null");
    }

    @Test
    public void mapEntityTest() {
        final DmsObject result = service.mapEntity(createDmsObjectDto(), "uid");

        notNull(result, "result is null");
    }
}