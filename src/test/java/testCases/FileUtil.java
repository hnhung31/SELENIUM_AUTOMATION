package testCases;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;


public class FileUtil {

    public static boolean waitForFileDownload(String downloadPath, String fileName, int timeoutSeconds) {
        File file = new File(downloadPath + File.separator + fileName);
        int waitTime = 0;

        while (waitTime < timeoutSeconds) {
            if (file.exists() && file.length() > 0) {
                return true;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            waitTime++;
        }
        return false;
    }

    public static String readTextFileContent(String downloadPath, String fileName) {
        String filePath = downloadPath + File.separator + fileName;
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (Exception e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
            return "";
        }
    }

    public static void deleteFile(String downloadPath, String fileName) {
        File file = new File(downloadPath + File.separator + fileName);
        if(file.exists()) {
            file.delete();
        }
    }
}


