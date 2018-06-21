package com.revature.aws;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.revature.util.BCrypt;
import com.amazonaws.AmazonServiceException;
import java.io.File;

public class PutObject
{
    public static void main(String[] args)
    {
        String bucket_name = "revature-project-1";
        String file_path = "C:\\Users\\nickc\\Downloads\\images\\hades.jpg";
        String key_name = BCrypt.hashpw("33.55OCAStudyGuidemissy.costigan@gmail.com", "$2a$10$UoN1BeeYXiuBPKtefJ8Qx.");
        System.out.format("Uploading %s to S3 bucket %s...\n", file_path, bucket_name);
        final AmazonS3 s3 = AmazonS3Client.builder().withRegion("us-east-1").build();
        try {
            s3.putObject(bucket_name, key_name, new File(file_path));
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }
        System.out.println("Done!");
    }
}