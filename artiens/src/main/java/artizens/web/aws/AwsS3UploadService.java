
package artizens.web.aws;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class AwsS3UploadService implements UploadService{
	
    private final AmazonS3 amazonS3;
	private final S3Component s3Component;

    public AwsS3UploadService(AmazonS3 amazonS3, S3Component s3Component) {
		this.amazonS3 = amazonS3;
		this.s3Component = s3Component;
	}

	@Override
    public void uploadFile(InputStream inputStream, ObjectMetadata objectMetadata, String fileName) {
        amazonS3.putObject(
                new PutObjectRequest(
                        s3Component.getBucket(),
                        fileName,
                        inputStream,
                        objectMetadata).withCannedAcl(CannedAccessControlList.PublicRead));
    }

    @Override
    public String getFileUrl(String fileName) {
        return amazonS3.getUrl(s3Component.getBucket(), fileName).toString();
    }
}
