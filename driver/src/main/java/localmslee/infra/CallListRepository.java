package localmslee.infra;

import java.util.List;
import localmslee.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "callLists", path = "callLists")
public interface CallListRepository
    extends PagingAndSortingRepository<CallList, Long> {}