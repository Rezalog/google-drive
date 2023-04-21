package googledrive.infra;

import googledrive.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "uploadedFileStatuses",
    path = "uploadedFileStatuses"
)
public interface UploadedFileStatusRepository
    extends PagingAndSortingRepository<UploadedFileStatus, Long> {}
