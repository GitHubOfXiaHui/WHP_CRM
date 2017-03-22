package com.wondersgroup.framework.utils.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;

public class Client
{
    
    public static void main(String[] args)
        throws UnknownHostException, IOException, InterruptedException
    {
        
        /*     BigDecimal payAmtTotal = null;
             payAmtTotal = NumberUtils.createBigDecimal("122.225");
             // System.out.println(payAmtTotal.setScale(2, BigDecimal.ROUND_HALF_UP));
             String v = new DecimalFormat("0000000000.00").format(payAmtTotal.setScale(2, BigDecimal.ROUND_HALF_UP));
             System.out.println(v.substring(0, 10) + v.substring(11));*/
        BigDecimal payAmtTotal = NumberUtils.createBigDecimal("122.225");
        String priceStr = new DecimalFormat("0000000000.00").format(payAmtTotal.setScale(2, BigDecimal.ROUND_HALF_UP));
        priceStr = priceStr.substring(0, 10) + priceStr.substring(11);
        System.out.println(priceStr);
        Socket sk = new Socket("127.0.0.1", 7777);
        //sk.setSoTimeout(6000);
        
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(sk.getOutputStream(), "GBK"));
        
        writer.write("你爱你");
        writer.write("你爱你");
        writer.write("你爱你");
        writer.write("你爱你");
        writer.flush();
        writer.write("你爱你");
        writer.write("你爱你");
        writer.write("你爱你");
        writer.write("你爱你");
        writer.flush();
        writer.flush();
        
        byte[] buff = new byte[4096];
        
        char[] data = new char[3];
        BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream(), "GBK"));
        while (true)
        {
            int len = br.read(data);
            if (len < 0)
            {
                break;
            }
            String rexml = String.valueOf(data, 0, len);
            System.out.println(rexml);
            
        }
        
        br.close();
        
        writer.close();
    }
}
