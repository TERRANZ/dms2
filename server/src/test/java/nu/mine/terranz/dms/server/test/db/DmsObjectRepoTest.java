package nu.mine.terranz.dms.server.test.db;

import nu.mine.terranz.dms.server.db.repository.DmsObjectRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static nu.mine.terranz.dms.server.test.DmsObjectsFactory.createObjectEntity;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DmsObjectRepoTest {
    @Autowired
    private DmsObjectRepo repo;

    @Test
    public void persistTest() {
        repo.save(createObjectEntity());
    }
}
