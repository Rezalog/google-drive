package googledrive.domain;

import googledrive.domain.*;
import googledrive.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class VideoProcessed extends AbstractEvent {

    private Long id;
    private Long fileId;
    private String videoUrl;

    public VideoProcessed(VideoProcess aggregate) {
        super(aggregate);
    }

    public VideoProcessed() {
        super();
    }
}
