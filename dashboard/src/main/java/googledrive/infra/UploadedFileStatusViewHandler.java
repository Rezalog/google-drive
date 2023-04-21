package googledrive.infra;

import googledrive.config.kafka.KafkaProcessor;
import googledrive.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class UploadedFileStatusViewHandler {

    @Autowired
    private UploadedFileStatusRepository uploadedFileStatusRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFileUploaded_then_CREATE_1(
        @Payload FileUploaded fileUploaded
    ) {
        try {
            if (!fileUploaded.validate()) return;

            // view 객체 생성
            UploadedFileStatus uploadedFileStatus = new UploadedFileStatus();
            // view 객체에 이벤트의 Value 를 set 함
            uploadedFileStatus.setId(fileUploaded.getId());
            uploadedFileStatus.setFileName(fileUploaded.getName());
            uploadedFileStatus.setFileSize(fileUploaded.getSize());
            uploadedFileStatus.setIsUploaded(true);
            // view 레파지 토리에 save
            uploadedFileStatusRepository.save(uploadedFileStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenIndexed_then_UPDATE_1(@Payload Indexed indexed) {
        try {
            if (!indexed.validate()) return;
            // view 객체 조회
            Optional<UploadedFileStatus> uploadedFileStatusOptional = uploadedFileStatusRepository.findById(
                indexed.getFileId()
            );

            if (uploadedFileStatusOptional.isPresent()) {
                UploadedFileStatus uploadedFileStatus = uploadedFileStatusOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                uploadedFileStatus.setIsIndexed(true);
                // view 레파지 토리에 save
                uploadedFileStatusRepository.save(uploadedFileStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenVideoProcessed_then_UPDATE_2(
        @Payload VideoProcessed videoProcessed
    ) {
        try {
            if (!videoProcessed.validate()) return;
            // view 객체 조회
            Optional<UploadedFileStatus> uploadedFileStatusOptional = uploadedFileStatusRepository.findById(
                videoProcessed.getFileId()
            );

            if (uploadedFileStatusOptional.isPresent()) {
                UploadedFileStatus uploadedFileStatus = uploadedFileStatusOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                uploadedFileStatus.setVideoUrl(videoProcessed.getVideoUrl());
                // view 레파지 토리에 save
                uploadedFileStatusRepository.save(uploadedFileStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
