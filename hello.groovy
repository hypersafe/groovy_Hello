// w

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.Bucket;
import java.util.List;

//https://github.com/minio/cookbook/blob/master/docs/aws-sdk-for-java-with-minio.md

class Main {                                    
    static void main(String... args) {
        String accessKey = System.getenv("AWS_KEY")  
        String secretKey = System.getenv("SECRET_KEY")  
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey)
		ClientConfiguration clientConfiguration = new ClientConfiguration()
		clientConfiguration.setSignerOverride("AWSS3V4SignerType")

		AmazonS3 s3Client = AmazonS3ClientBuilder
				.standard()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:9000", Regions.US_EAST_1.name()))
				.withPathStyleAccessEnabled(true)
				.withClientConfiguration(clientConfiguration)
				.withCredentials(new AWSStaticCredentialsProvider(credentials))
				.build()

        List<Bucket> buckets = s3Client.listBuckets()
        println("Your Amazon S3 buckets are:")
        buckets.each{
            eachbucket->println(eachbucket.getName())

        }
        // println 'Groovy world!'     

    }
}