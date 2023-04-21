package googledrive.domain;

import googledrive.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "videoProcesses",
    path = "videoProcesses"
)
public interface VideoProcessRepository
    extends PagingAndSortingRepository<VideoProcess, Long> {}
