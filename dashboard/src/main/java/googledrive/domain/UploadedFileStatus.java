package googledrive.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "UploadedFileStatus_table")
@Data
public class UploadedFileStatus {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long fileSize;
    private String fileName;
    private Boolean isIndexed;
    private String videoUrl;
    private Boolean isUploaded;
}
