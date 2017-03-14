package com.microsoft.azure.samples;


 import javax.servlet.annotation.MultipartConfig;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.annotation.WebServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.Part;

 import com.microsoft.azure.storage.*;
 import com.microsoft.azure.storage.blob.*;

 import java.io.InputStream;

@WebServlet(name = "AzureStorageUploadServlet", urlPatterns = {"/upload"})
@MultipartConfig

public class AzureStorageUploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
        final String storageConnection = System.getenv("STORAGE_CONNSTR");

        try {
            CloudStorageAccount account = CloudStorageAccount.parse(storageConnection);
            CloudBlobClient serviceClient = account.createCloudBlobClient();

            // Container name must be lower case.
            CloudBlobContainer container = serviceClient.getContainerReference("helloworld");
            container.createIfNotExists();

            // read the  image file
            final Part filePart = req.getPart("file");
            CloudBlockBlob blob = container.getBlockBlobReference("helloworld.jpg");
            InputStream fileContent = filePart.getInputStream();
            blob.upload(fileContent, filePart.getSize());
        }
        catch (Exception e) {
            System.out.print("Exception encountered: ");
            System.out.println(e.getMessage());
        }
    }
}