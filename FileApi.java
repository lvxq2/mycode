package com.test;

import java.nio.charset.StandardCharsets;
import java.util.List;

public interface FileApi {
    void createFile(String path) throws IOException{
File file1 = new File(path);
   file1.createNewFile();}

    void deleteFile(String path) {
File file1 = new File(path);
   file1.delete();}

    List<String> subFiles(String path);

    void writeFile(String path, byte[] content) throws IOException{
       try{
       FileOutputStream fos = new FileOutputStream(path);
        fos.write(content);
        fos.close();
       }catch (IOException e) {
       throw new RuntimeException(e);
		}
}


    byte[] readFile(String path){
    File file = new File(path);
    FileInputStream input = null;
    try{
        input = new FileInputStream(file);
        byte[] buf =new byte[input.available()];
        input.read(buf);
        }catch(Exception e){
            e.printstackTrack();
        }finally{
            if(input != null){
            try {
                input.close();
                }catch(IOException e){
                e.printStackTrace();
        }
        }
    }
   return null;
}


    void moveFile(String fromPath, String toPath) throws Exception{
       
       try {
                   //FileUtils.moveFileToDirectory(source, destDirPath, false);
        File source = new File(fromPath);
          File[] files=source.listFiles();
          if(files==null)
               return;
          File target =new File(toPath);
          if(!target.exists()){
                target.mkdirs();
           }
          for(int i=0;i<files.length
       } catch (IOException e) {
        e.printStackTrace();
       }
}

   


    void copyFile(String fromPath, String toPath){
        File file = new File(fromPath);
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(toPath);
        byte[] bys = new byte[1024];
        while(( fis.read(bys))!=-1){
            fos.write(bys);
        }
        fis.close();
        fos.close();
    }

    long fileSize(String path) {
        File file = new File(path);
        if (!file.exists() || !file.isFile()) {
            System.out.println("文件不存在");
            return -1;
        }
        return file.length();
    }

    void downloadFile(String url, String toPath);

    default byte[] stringToBytes(String content) {
        return content.getBytes(StandardCharsets.UTF_8);
    }

    default String bytesToString(byte[] bytes) {
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
