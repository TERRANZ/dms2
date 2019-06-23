package nu.mine.terranz.dms.server.db.repository;

import nu.mine.terranz.dms.server.db.entity.DmsObject;
import org.springframework.data.repository.CrudRepository;

public interface DmsObjectRepo extends CrudRepository<DmsObject, String> {
}
