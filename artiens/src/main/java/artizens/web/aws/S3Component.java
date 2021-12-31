package artizens.web.aws;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Profile("aws")
@ConfigurationProperties(prefix = "cloud.aws.s3")
@Component
public class S3Component {
//    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

	public String getBucket() {
		return bucket;
	}

	public void setBucket(String bucket) {
		this.bucket = bucket;
	}
    
    
}
