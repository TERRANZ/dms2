package nu.mine.terranz.dms.server.test.db;

import nu.mine.terranz.dms.server.db.entity.DmsObject;
import nu.mine.terranz.dms.server.db.repository.DmsObjectFieldRepo;
import nu.mine.terranz.dms.server.db.repository.DmsObjectRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static nu.mine.terranz.dms.server.test.DmsObjectsFactory.createObjectEntity;
import static nu.mine.terranz.dms.server.test.DmsObjectsFactory.createObjectFieldEntity;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DmsObjectFieldRepoTest {
    @Autowired
    private DmsObjectFieldRepo repo;
    @Autowired
    private DmsObjectRepo dmsObjectRepo;

    @Test
    public void persistTest() {
        final DmsObject obj = dmsObjectRepo.save(createObjectEntity());
        repo.save(createObjectFieldEntity(obj));
    }

}
