package com.revature.aws;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.revature.util.BCrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class GetObject
{
    public static void main(String[] args)
    {

        String bucket_name = "revature-project-1";
//        String key_name = "3";
        String key_name = BCrypt.hashpw("33.55OCAStudyGuidemissy.costigan@gmail.com", "$2a$10$UoN1BeeYXiuBPKtefJ8Qx.");
        System.out.println(BCrypt.hashpw("nick", "$2a$10$UoN1BeeYXiuBPKtefJ8Qx."));
//        System.out.format("Downloading %s from S3 bucket %s...\n", key_name, bucket_name);
//        final AmazonS3 s3 = AmazonS3Client.builder().withRegion("us-east-1").build();
//        try {
//            S3Object o = s3.getObject(bucket_name, key_name);
//            System.out.println(o.getObjectMetadata().getContentLength());
//            S3ObjectInputStream s3is = o.getObjectContent();
//            FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\nickc\\Desktop\\hades.jpg"));
//            byte[] read_buf = new byte[(int)o.getObjectMetadata().getContentLength()];
//            int read_len = 0;
//            while ((read_len = s3is.read(read_buf)) > 0) {
//                fos.write(read_buf, 0, read_len);
//            }
//            
//            s3is.close();
//            fos.close();
//        } catch (AmazonServiceException e) {
//            System.err.println(e.getErrorMessage());
//            System.exit(1);
//        } catch (FileNotFoundException e) {
//            System.err.println(e.getMessage());
//            System.exit(1);
//        } catch (IOException e) {
//            System.err.println(e.getMessage());
//            System.exit(1);
//        }
        System.out.println("Done!");
    }
}