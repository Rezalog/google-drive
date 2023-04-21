package googledrive.domain;

import googledrive.VideoProcessingApplication;
import googledrive.domain.VideoProcessed;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "VideoProcess_table")
@Data
public class VideoProcess {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long fileId;

    private String videoUrl;

    @PostPersist
    public void onPostPersist() {
        VideoProcessed videoProcessed = new VideoProcessed(this);
        videoProcessed.publishAfterCommit();
    }

    public static VideoProcessRepository repository() {
        VideoProcessRepository videoProcessRepository = VideoProcessingApplication.applicationContext.getBean(
            VideoProcessRepository.class
        );
        return videoProcessRepository;
    }

    public static void videoProcess(FileUploaded fileUploaded) {
        /** Example 1:  new item 
        VideoProcess videoProcess = new VideoProcess();
        repository().save(videoProcess);

        */

        /** Example 2:  finding and process
        
        repository().findById(fileUploaded.get???()).ifPresent(videoProcess->{
            
            videoProcess // do something
            repository().save(videoProcess);


         });
        */

    }
}
