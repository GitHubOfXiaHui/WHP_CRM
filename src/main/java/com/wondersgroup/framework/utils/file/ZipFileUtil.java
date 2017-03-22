/*
 * 文 件 名:  ZipFileUtil.java
 * 版    权:  WondersGroup Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  wh008
 * 修改时间:  2013-7-22
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.wondersgroup.framework.utils.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
/*import java.util.zip.ZipEntry;*/
/*import java.util.zip.ZipOutputStream;*/
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.commons.lang3.StringUtils;
import org.apache.tools.zip.ZipOutputStream;
import com.google.common.collect.Lists;
import com.wondersgroup.framework.SecurityConstants;

/**
 * 压缩工具类
 * 
 * @author  wh008
 * @version  [版本号, 2013-7-22]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class ZipFileUtil
{
    private ZipFileUtil()
    {
    }
    
    /**
     * 下单,将订单包含的图片及txt文件打成压缩包
     * @param basePath 基础路径
     * @param sqdh[] 申请单数组 
     * @param zipFileName 压缩后的文件名
     * @param txtFile 下单生成的txt文件
     * @throws Exception
     * @see [类、类#方法、类#成员]
     */
    public static String zip(String basePath, String[] sqdh, String zipFileName, List<File> files)
        throws Exception
    {
        
        String zipFilePath = basePath;
        if (StringUtils.isBlank(basePath))
        {
            zipFilePath = basePath + SecurityConstants.DOWNLOAD_FOLDER_NAME_DD + File.separator + zipFileName + ".zip";
        }
        else
        {
            zipFilePath = zipFilePath + File.separator + zipFileName;
        }
        FileOutputStream fileOut = new FileOutputStream(zipFilePath);
        
        ZipOutputStream out = new ZipOutputStream(fileOut);
        out.setEncoding("GBK");
        if (null != sqdh)
        {
            for (int i = 0; i < sqdh.length; i++)
            {
                File inputFile =
                    new File(basePath + SecurityConstants.DOWNLOAD_FOLDER_NAME_SQD + File.separator + sqdh[i]
                        + File.separator + SecurityConstants.IMG_FOLDER_NAME);
                
                putZipEntry(out, inputFile, sqdh[i]);
            }
        }
        if (null != files && files.size() > 0)
        {
            for (File txtFile : files)
            {
                putZipEntry(out, txtFile, txtFile.getName());
            }
        }
        out.close();
        fileOut.close();
        return zipFilePath;
    }
    
    public static void putZipEntry(ZipOutputStream out, File f, String base)
        throws Exception
    {
        if (f.isDirectory())
        {
            File[] fl = f.listFiles();
            //System.out.println(":::::::::" + base);
            
            out.putNextEntry(new ZipEntry(base + "/"));
            base = base.length() == 0 ? "" : base + "/";
            for (int i = 0; i < fl.length; i++)
            {
                putZipEntry(out, fl[i], base + fl[i].getName());
            }
        }
        else
        {
            out.putNextEntry(new ZipEntry(base));
            FileInputStream in = new FileInputStream(f);
            // System.out.println(base);
            byte[] buff = new byte[2048];
            int n = 0;
            while ((n = in.read(buff, 0, buff.length)) != -1)
            {
                out.write(buff, 0, n);
            }
            in.close();
        }
    }
    
    /**
     * 解压 zip 文件，注意不能解压 rar 文件哦，只能解压 zip 文件 解压 rar 文件 会出现 java.io.IOException: Negative
     * @param zipfile zip 文件，注意要是正宗的 zip 文件哦，不能是把 rar 的直接改为 zip 这样会出现 java.io.IOException:
     * @param destDir 解压目录，目标目录
     * @throws IOException
     */
    public static void unZip(String zipfile, String destDir)
    {
        
        destDir = destDir.endsWith("//") ? destDir : destDir + "//";
        
        byte b[] = new byte[2048];
        
        int length;
        
        ZipFile zipFile;
        
        try
        {
            
            zipFile = new ZipFile(new File(zipfile));
            
            Enumeration enumeration = zipFile.getEntries();
            
            ZipEntry zipEntry = null;
            
            while (enumeration.hasMoreElements())
            {
                
                zipEntry = (ZipEntry)enumeration.nextElement();
                
                File loadFile = new File(destDir + zipEntry.getName());
                
                if (zipEntry.isDirectory())
                {
                    
                    // 这段都可以不要，因为每次都貌似从最底层开始遍历的
                    
                    loadFile.mkdirs();
                    
                }
                else
                {
                    
                    if (!loadFile.getParentFile().exists())
                        
                        loadFile.getParentFile().mkdirs();
                    
                    OutputStream outputStream = new FileOutputStream(loadFile);
                    
                    InputStream inputStream = zipFile.getInputStream(zipEntry);
                    
                    while ((length = inputStream.read(b)) > 0)
                        
                        outputStream.write(b, 0, length);
                    
                }
                
            }
            
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] temp)
    {
        
        try
        {
            /* //String basePath = "D:\\work-wuhan\\wuhan-pt\\card\\card\\src\\main\\webapp\\";
             String basePath = "E:\\HCMBP\\src\\main\\webapp\\";
             String[] inputFilePath = {"SQD2013071900002", "SQD2013071900001"};
             String zipFileName = "DD2013071500002";
             File txtFile =
                 new File(basePath + SecurityConstants.DOWNLOAD_FOLDER_NAME_DD + File.separator
                     + SecurityConstants.DOWNLOAD_FOLDER_NAME_DD_TXT + File.separator + "aa.txt");
             File txtFile2 =
                 new File(basePath + SecurityConstants.DOWNLOAD_FOLDER_NAME_DD + File.separator
                     + SecurityConstants.DOWNLOAD_FOLDER_NAME_DD_TXT + File.separator + "bb.txt");
             List<File> txtFiles = Lists.newArrayList();
             txtFiles.add(txtFile);
             txtFiles.add(txtFile2);
             zip(basePath, inputFilePath, zipFileName, txtFiles);*/
            
            unZip("E:\\JNative_1.4RC2_src工.cab", "E:\\JNative\\");
            
            unZip("F:\\TDDownload\\jawin-2.0-alpha1.zip", "E:\\JNative\\");
            
            File unPathFile = new File("E:\\JNative\\");
            List<File> zipFiles = Lists.newArrayList();
            if (unPathFile.isDirectory())
            {
                File[] files = unPathFile.listFiles();
                zipFiles = Arrays.asList(files);
            }
            else
            {
                zipFiles.add(unPathFile);
            }
            String path = "E:\\aaaaaaaaaaaaaa\\aa";
            File pathFile = new File(path);
            if (!pathFile.exists())
            {
                pathFile.mkdirs();
            }
            path = zip(path, null, "TEST.zip", zipFiles);
            pathFile = new File(path);
            System.out.println(path);
            System.out.println(pathFile.getName());
            
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
