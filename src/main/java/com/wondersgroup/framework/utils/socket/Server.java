package com.wondersgroup.framework.utils.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;

public class Server
{
    public Server()
        throws IOException
    {
        ServerSocket ss = new ServerSocket(7777);
        while (true)
        {
            Socket sk = ss.accept();
            ClientThread ct = new ClientThread(sk);
            ct.start();
            System.out.println("服务端已启动...");
        }
        
    }
    
    // 多线程客户端
    class ClientThread extends Thread
    {
        private Socket clientSocket = null;
        
        public ClientThread(Socket clientSocket)
        {
            this.clientSocket = clientSocket;
        }
        
        DataInputStream dis = new DataInputStream(null);
        
        BufferedReader br = null;
        
        @Override
        public void run()
        {
            // TODO Auto-generated method stub
            
            String hostName = clientSocket.getInetAddress().toString();
            System.out.println("hostName:>" + hostName + "已连接");
            String msg = null;
            try
            {
                char[] data = new char[100];
                br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), "GBK"));
                while (true)
                {
                    //  msg = dis.readUTF();
                    int len = br.read(data);
                    
                    msg = msg + String.valueOf(data, 0, len);
                    if (msg.indexOf("</Request>") > 0 || msg.indexOf("</msg>") > 0)
                    {
                        System.out.println(" read finshsh!" + hostName + "发来的消息>:" + msg);
                        break;
                    }
                    // System.out.println(hostName + "发来的消息>:" + msg);
                    
                    /* if (null == dis.readLine() || "".equals(dis.readLine()))
                     {
                         break;
                     }*/
                    
                }
                if (!"".equals(msg) && msg.length() != 0)
                {
                    /*BufferedOutputStream dos = new BufferedOutputStream(clientSocket.getOutputStream());
                     if (inStreamType == 0)
                     {
                         this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                     }
                     else
                         this.ins = new BufferedInputStream(this.socket.getInputStream());
                     this.out = new BufferedOutputStream(this.socket.getOutputStream());
                    
                    
                    DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
                    String rep = "我是返回给发来[" + msg + "]的消息";
                    System.out.println(rep);
                    dos.writeUTF(rep);*/
                    BufferedWriter writer =
                        new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream(), "GBK"));
                    
                    /*   writer.write("00000655<?xml version=\"1.0\" encoding=\"utf-8\" ?><Response> <TransCode>1001</TransCode><ResultCode></ResultCode><ErrorMsg></ErrorMsg><HISDateTime></HISDateTime> "
                           + "<List><Item><ReceiptNo>111110</ReceiptNo><ReceiptTime>2323</ReceiptTime><ShouldMoney>111.10</ShouldMoney></Item> "
                           + "<Item><ReceiptNo>22222</ReceiptNo><ReceiptTime>2211</ReceiptTime><ShouldMoney>222.10</ShouldMoney></Item></List>"
                           + "</Response> ");*/
                    
                    if (msg.indexOf("2006") > 0)
                    {
                        writer.write("00000123<?xml version=\"1.0\" encoding=\"utf-8\" ?>"
                            + "<Response><TransCode>2006</TransCode><ResultCode>0</ResultCode><ErrorMsg></ErrorMsg>"
                            + "<PatientID>156297</PatientID><PatName>张三</PatName><PatSex>男</PatSex>"
                            + "<IDCard>420115201112154725</IDCard><AccBalance>2323.23</AccBalance><Tel>1331234567</Tel></Response>");
                    }
                    else if (msg.indexOf("5001") > 0)
                    {
                        writer.write("00002728<?xml version=\"1.0\" encoding=\"utf-8\" ?><Response><TransCode>5001</TransCode><ResultCode>0</ResultCode><ErrorMsg>成功</ErrorMsg><List>"
                            + "<Item><ReceiptNo>0001561194</ReceiptNo><ReceiptTime>2015-08-25 13:56:35</ReceiptTime><BillDept>骨一科</BillDept><ExecDept>检验中心</ExecDept><Doctor>熊家亭</Doctor><FeesType>自费</FeesType><FeesItem>化验费</FeesItem><GroupID>6439</GroupID><GroupName>癌胚抗原测定（CEA）</GroupName><ItemID>0828</ItemID><ItemName>癌胚抗原测定(CEA)(化学发光法)</ItemName><ItemUnit>项</ItemUnit><Num>1</Num><Price>0.01</Price><ShouldMoney>0.01</ShouldMoney><ActualMoney>0.01</ActualMoney></Item>"
                            /* + "<Item><ReceiptNo>0001561194</ReceiptNo><ReceiptTime>2015-08-25 13:56:35</ReceiptTime><BillDept>骨一科</BillDept><ExecDept>检验中心</ExecDept><Doctor>熊家亭</Doctor><FeesType>自费</FeesType><FeesItem>化验费</FeesItem><GroupID>6439</GroupID><GroupName>癌胚抗原测定（CEA）</GroupName><ItemID>2768</ItemID><ItemName>静脉采血(免疫组)</ItemName><ItemUnit>次</ItemUnit><Num>1</Num><Price>0.02</Price><ShouldMoney>0.02</ShouldMoney><ActualMoney>0.02</ActualMoney></Item>"
                            + "<Item><ReceiptNo>0001561194</ReceiptNo><ReceiptTime>2015-08-25 13:56:35</ReceiptTime><BillDept>骨一科</BillDept><ExecDept>检验中心</ExecDept><Doctor>熊家亭</Doctor><FeesType>自费</FeesType><FeesItem>医材费</FeesItem><GroupID>6439</GroupID><GroupName>癌胚抗原测定（CEA）</GroupName><ItemID>3398</ItemID><ItemName>采血试管</ItemName><ItemUnit>支</ItemUnit><Num>1</Num><Price>1.38</Price><ShouldMoney>1.38</ShouldMoney><ActualMoney>1.38</ActualMoney></Item>"
                            + "<Item><ReceiptNo>0001561193</ReceiptNo><ReceiptTime>2015-08-25 13:56:13</ReceiptTime><BillDept>骨二科</BillDept><ExecDept>B超室</ExecDept><Doctor>熊家亭</Doctor><FeesType>自费</FeesType><FeesItem>检查费</FeesItem><GroupID>8351</GroupID><GroupName>常规胎儿超声检查(14周前)</GroupName><ItemID>0207</ItemID><ItemName>彩色多普勒超声常规检查</ItemName><ItemUnit>每个部位</ItemUnit><Num>1</Num><Price>100</Price><ShouldMoney>100</ShouldMoney><ActualMoney>100</ActualMoney></Item>"
                            + "<Item><ReceiptNo>0001561193</ReceiptNo><ReceiptTime>2015-08-25 13:56:13</ReceiptTime><BillDept>骨二科</BillDept><ExecDept>B超室</ExecDept><Doctor>熊家亭</Doctor><FeesType>自费</FeesType><FeesItem>检查费</FeesItem><GroupID>8351</GroupID><GroupName>常规胎儿超声检查(14周前)</GroupName><ItemID>0226</ItemID><ItemName>超声计算机图文报告</ItemName><ItemUnit>次</ItemUnit><Num>1</Num><Price>10</Price><ShouldMoney>10</ShouldMoney><ActualMoney>10</ActualMoney></Item>"
                            + "<Item><ReceiptNo>0001561193</ReceiptNo><ReceiptTime>2015-08-25 13:56:13</ReceiptTime><BillDept>骨二科</BillDept><ExecDept>B超室</ExecDept><Doctor>熊家亭</Doctor><FeesType>自费</FeesType><FeesItem>医材费</FeesItem><GroupID>8351</GroupID><GroupName>常规胎儿超声检查(14周前)</GroupName><ItemID>2996</ItemID><ItemName>一次性耦合剂(安必洁)</ItemName><ItemUnit>支</ItemUnit><Num>1</Num><Price>9.80</Price><ShouldMoney>9.80</ShouldMoney><ActualMoney>9.80</ActualMoney></Item>"
                            
                            
                            + "<Item><ReceiptNo>0001561195</ReceiptNo><ReceiptTime>2015-08-25 13:56:35</ReceiptTime><BillDept>骨3科</BillDept><ExecDept>检验中心</ExecDept><Doctor>熊家亭</Doctor><FeesType>自费</FeesType><FeesItem>化验费</FeesItem><GroupID>6439</GroupID><GroupName>癌胚抗原测定（CEA）</GroupName><ItemID>0828</ItemID><ItemName>癌胚抗原测定(CEA)(化学发光法)</ItemName><ItemUnit>项</ItemUnit><Num>1</Num><Price>70</Price><ShouldMoney>70</ShouldMoney><ActualMoney>70</ActualMoney></Item>"
                            + "<Item><ReceiptNo>0001561195</ReceiptNo><ReceiptTime>2015-08-25 13:56:35</ReceiptTime><BillDept>骨3科</BillDept><ExecDept>检验中心</ExecDept><Doctor>熊家亭</Doctor><FeesType>自费</FeesType><FeesItem>化验费</FeesItem><GroupID>6439</GroupID><GroupName>癌胚抗原测定（CEA）</GroupName><ItemID>2768</ItemID><ItemName>静脉采血(免疫组)</ItemName><ItemUnit>次</ItemUnit><Num>1</Num><Price>3</Price><ShouldMoney>3</ShouldMoney><ActualMoney>3</ActualMoney></Item>"
                            + "<Item><ReceiptNo>0001561195</ReceiptNo><ReceiptTime>2015-08-25 13:56:35</ReceiptTime><BillDept>骨3科</BillDept><ExecDept>检验中心</ExecDept><Doctor>熊家亭</Doctor><FeesType>自费</FeesType><FeesItem>医材费</FeesItem><GroupID>6439</GroupID><GroupName>癌胚抗原测定（CEA）</GroupName><ItemID>3398</ItemID><ItemName>采血试管</ItemName><ItemUnit>支</ItemUnit><Num>1</Num><Price>1.38</Price><ShouldMoney>1.38</ShouldMoney><ActualMoney>1.38</ActualMoney></Item>"
                            + "<Item><ReceiptNo>0001561196</ReceiptNo><ReceiptTime>2015-08-25 13:56:13</ReceiptTime><BillDept>骨4科</BillDept><ExecDept>B超室</ExecDept><Doctor>熊家亭</Doctor><FeesType>自费</FeesType><FeesItem>检查费</FeesItem><GroupID>8351</GroupID><GroupName>常规胎儿超声检查(14周前)</GroupName><ItemID>0207</ItemID><ItemName>彩色多普勒超声常规检查</ItemName><ItemUnit>每个部位</ItemUnit><Num>1</Num><Price>100</Price><ShouldMoney>100</ShouldMoney><ActualMoney>100</ActualMoney></Item>"
                            + "<Item><ReceiptNo>0001561196</ReceiptNo><ReceiptTime>2015-08-25 13:56:13</ReceiptTime><BillDept>骨4科</BillDept><ExecDept>B超室</ExecDept><Doctor>熊家亭</Doctor><FeesType>自费</FeesType><FeesItem>检查费</FeesItem><GroupID>8351</GroupID><GroupName>常规胎儿超声检查(14周前)</GroupName><ItemID>0226</ItemID><ItemName>超声计算机图文报告</ItemName><ItemUnit>次</ItemUnit><Num>1</Num><Price>10</Price><ShouldMoney>10</ShouldMoney><ActualMoney>10</ActualMoney></Item>"
                            + "<Item><ReceiptNo>0001561196</ReceiptNo><ReceiptTime>2015-08-25 13:56:13</ReceiptTime><BillDept>骨4科</BillDept><ExecDept>B超室</ExecDept><Doctor>熊家亭</Doctor><FeesType>自费</FeesType><FeesItem>医材费</FeesItem><GroupID>8351</GroupID><GroupName>常规胎儿超声检查(14周前)</GroupName><ItemID>2996</ItemID><ItemName>一次性耦合剂(安必洁)</ItemName><ItemUnit>支</ItemUnit><Num>1</Num><Price>9.80</Price><ShouldMoney>9.80</ShouldMoney><ActualMoney>9.80</ActualMoney></Item>"
                            
                            
                            + "<Item><ReceiptNo>0001561197</ReceiptNo><ReceiptTime>2015-08-25 13:56:35</ReceiptTime><BillDept>骨5科</BillDept><ExecDept>检验中心</ExecDept><Doctor>熊家亭</Doctor><FeesType>自费</FeesType><FeesItem>化验费</FeesItem><GroupID>6439</GroupID><GroupName>癌胚抗原测定（CEA）</GroupName><ItemID>0828</ItemID><ItemName>癌胚抗原测定(CEA)(化学发光法)</ItemName><ItemUnit>项</ItemUnit><Num>1</Num><Price>70</Price><ShouldMoney>70</ShouldMoney><ActualMoney>70</ActualMoney></Item>"
                            + "<Item><ReceiptNo>0001561197</ReceiptNo><ReceiptTime>2015-08-25 13:56:35</ReceiptTime><BillDept>骨5科</BillDept><ExecDept>检验中心</ExecDept><Doctor>熊家亭</Doctor><FeesType>自费</FeesType><FeesItem>化验费</FeesItem><GroupID>6439</GroupID><GroupName>癌胚抗原测定（CEA）</GroupName><ItemID>2768</ItemID><ItemName>静脉采血(免疫组)</ItemName><ItemUnit>次</ItemUnit><Num>1</Num><Price>3</Price><ShouldMoney>3</ShouldMoney><ActualMoney>3</ActualMoney></Item>"
                            + "<Item><ReceiptNo>0001561197</ReceiptNo><ReceiptTime>2015-08-25 13:56:35</ReceiptTime><BillDept>骨5科</BillDept><ExecDept>检验中心</ExecDept><Doctor>熊家亭</Doctor><FeesType>自费</FeesType><FeesItem>医材费</FeesItem><GroupID>6439</GroupID><GroupName>癌胚抗原测定（CEA）</GroupName><ItemID>3398</ItemID><ItemName>采血试管</ItemName><ItemUnit>支</ItemUnit><Num>1</Num><Price>1.38</Price><ShouldMoney>1.38</ShouldMoney><ActualMoney>1.38</ActualMoney></Item>"
                            + "<Item><ReceiptNo>0001561198</ReceiptNo><ReceiptTime>2015-08-25 13:56:13</ReceiptTime><BillDept>骨6科</BillDept><ExecDept>B超室</ExecDept><Doctor>熊家亭</Doctor><FeesType>自费</FeesType><FeesItem>检查费</FeesItem><GroupID>8351</GroupID><GroupName>常规胎儿超声检查(14周前)</GroupName><ItemID>0207</ItemID><ItemName>彩色多普勒超声常规检查</ItemName><ItemUnit>每个部位</ItemUnit><Num>1</Num><Price>100</Price><ShouldMoney>100</ShouldMoney><ActualMoney>100</ActualMoney></Item>"
                            + "<Item><ReceiptNo>0001561198</ReceiptNo><ReceiptTime>2015-08-25 13:56:13</ReceiptTime><BillDept>骨6科</BillDept><ExecDept>B超室</ExecDept><Doctor>熊家亭</Doctor><FeesType>自费</FeesType><FeesItem>检查费</FeesItem><GroupID>8351</GroupID><GroupName>常规胎儿超声检查(14周前)</GroupName><ItemID>0226</ItemID><ItemName>超声计算机图文报告</ItemName><ItemUnit>次</ItemUnit><Num>1</Num><Price>10</Price><ShouldMoney>10</ShouldMoney><ActualMoney>10</ActualMoney></Item>"
                            + "<Item><ReceiptNo>0001561198</ReceiptNo><ReceiptTime>2015-08-25 13:56:13</ReceiptTime><BillDept>骨6科</BillDept><ExecDept>B超室</ExecDept><Doctor>熊家亭</Doctor><FeesType>自费</FeesType><FeesItem>医材费</FeesItem><GroupID>8351</GroupID><GroupName>常规胎儿超声检查(14周前)</GroupName><ItemID>2996</ItemID><ItemName>一次性耦合剂(安必洁)</ItemName><ItemUnit>支</ItemUnit><Num>1</Num><Price>9.80</Price><ShouldMoney>9.80</ShouldMoney><ActualMoney>9.80</ActualMoney></Item>"
                            
                            + "<Item><ReceiptNo>0001561199</ReceiptNo><ReceiptTime>2015-08-25 13:56:35</ReceiptTime><BillDept>骨7科</BillDept><ExecDept>检验中心</ExecDept><Doctor>熊家亭</Doctor><FeesType>自费</FeesType><FeesItem>化验费</FeesItem><GroupID>6439</GroupID><GroupName>癌胚抗原测定（CEA）</GroupName><ItemID>0828</ItemID><ItemName>癌胚抗原测定(CEA)(化学发光法)</ItemName><ItemUnit>项</ItemUnit><Num>1</Num><Price>70</Price><ShouldMoney>70</ShouldMoney><ActualMoney>70</ActualMoney></Item>"
                            + "<Item><ReceiptNo>0001561199</ReceiptNo><ReceiptTime>2015-08-25 13:56:35</ReceiptTime><BillDept>骨7科</BillDept><ExecDept>检验中心</ExecDept><Doctor>熊家亭</Doctor><FeesType>自费</FeesType><FeesItem>化验费</FeesItem><GroupID>6439</GroupID><GroupName>癌胚抗原测定（CEA）</GroupName><ItemID>2768</ItemID><ItemName>静脉采血(免疫组)</ItemName><ItemUnit>次</ItemUnit><Num>1</Num><Price>3</Price><ShouldMoney>3</ShouldMoney><ActualMoney>3</ActualMoney></Item>"
                            + "<Item><ReceiptNo>0001561199</ReceiptNo><ReceiptTime>2015-08-25 13:56:35</ReceiptTime><BillDept>骨7科</BillDept><ExecDept>检验中心</ExecDept><Doctor>熊家亭</Doctor><FeesType>自费</FeesType><FeesItem>医材费</FeesItem><GroupID>6439</GroupID><GroupName>癌胚抗原测定（CEA）</GroupName><ItemID>3398</ItemID><ItemName>采血试管</ItemName><ItemUnit>支</ItemUnit><Num>1</Num><Price>1.38</Price><ShouldMoney>1.38</ShouldMoney><ActualMoney>1.38</ActualMoney></Item>"
                            + "<Item><ReceiptNo>0001561200</ReceiptNo><ReceiptTime>2015-08-25 13:56:13</ReceiptTime><BillDept>骨8科</BillDept><ExecDept>B超室</ExecDept><Doctor>熊家亭</Doctor><FeesType>自费</FeesType><FeesItem>检查费</FeesItem><GroupID>8351</GroupID><GroupName>常规胎儿超声检查(14周前)</GroupName><ItemID>0207</ItemID><ItemName>彩色多普勒超声常规检查</ItemName><ItemUnit>每个部位</ItemUnit><Num>1</Num><Price>100</Price><ShouldMoney>100</ShouldMoney><ActualMoney>100</ActualMoney></Item>"
                            + "<Item><ReceiptNo>0001561200</ReceiptNo><ReceiptTime>2015-08-25 13:56:13</ReceiptTime><BillDept>骨8科</BillDept><ExecDept>B超室</ExecDept><Doctor>熊家亭</Doctor><FeesType>自费</FeesType><FeesItem>检查费</FeesItem><GroupID>8351</GroupID><GroupName>常规胎儿超声检查(14周前)</GroupName><ItemID>0226</ItemID><ItemName>超声计算机图文报告</ItemName><ItemUnit>次</ItemUnit><Num>1</Num><Price>10</Price><ShouldMoney>10</ShouldMoney><ActualMoney>10</ActualMoney></Item>"
                            + "<Item><ReceiptNo>0001561200</ReceiptNo><ReceiptTime>2015-08-25 13:56:13</ReceiptTime><BillDept>骨8科</BillDept><ExecDept>B超室</ExecDept><Doctor>熊家亭</Doctor><FeesType>自费</FeesType><FeesItem>医材费</FeesItem><GroupID>8351</GroupID><GroupName>常规胎儿超声检查(14周前)</GroupName><ItemID>2996</ItemID><ItemName>一次性耦合剂(安必洁)</ItemName><ItemUnit>支</ItemUnit><Num>1</Num><Price>9.80</Price><ShouldMoney>9.80</ShouldMoney><ActualMoney>9.80</ActualMoney></Item>"
                            */
                            
                            + "</List></Response>");
                    }
                    else if (msg.indexOf("5002") > 0)
                    {
                        writer.write("00000238<?xml version=\"1.0\" encoding=\"utf-8\" ?><Response><TransCode>5002</TransCode><ResultCode>0</ResultCode><ErrorMsg>成功</ErrorMsg><TranFlow>20150825114618d258294f</TranFlow><TranTime>2015-08-25 11:46:17</TranTime><SendWin></SendWin></Response>");
                    }
                    else if (msg.indexOf("5003") > 0)
                    {
                        writer.write("00001997<?xml version=\"1.0\" encoding=\"utf-8\" ?><Response><TransCode>5003</TransCode><ResultCode>0</ResultCode><ErrorMsg>成功</ErrorMsg><Count>4</Count><RequestQty>4</RequestQty><List><Item><ReceiptNo>0001561191</ReceiptNo><ReceiptTime>2015-08-25 10:43:39</ReceiptTime><BillDept>骨一科</BillDept><ExecDept>门诊西药房</ExecDept><Doctor>熊家亭</Doctor><FeesType>自费</FeesType><FeesItem>西药</FeesItem><GroupID>0101019050604</GroupID><GroupName>5%葡萄糖氯化钠注射液(内封式)</GroupName><ItemID>0101019050604</ItemID><ItemName>5%葡萄糖氯化钠注射液(内封式)</ItemName><ItemUnit>袋</ItemUnit><Num>1</Num><Price>8.8090</Price><ShouldMoney>8.81</ShouldMoney><ActualMoney>8.81</ActualMoney></Item><Item><ReceiptNo>0001561191</ReceiptNo><ReceiptTime>2015-08-25 10:43:39</ReceiptTime><BillDept>骨一科</BillDept><ExecDept>门诊西药房</ExecDept><Doctor>熊家亭</Doctor><FeesType>自费</FeesType><FeesItem>西药</FeesItem><GroupID>0101009020601</GroupID><GroupName>多巴丝肼片</GroupName><ItemID>0101009020601</ItemID><ItemName>多巴丝肼片</ItemName><ItemUnit>片</ItemUnit><Num>40</Num><Price>2.36</Price><ShouldMoney>94.40</ShouldMoney><ActualMoney>94.40</ActualMoney></Item><Item><ReceiptNo>0001561192</ReceiptNo><ReceiptTime>2015-08-25 10:45:07</ReceiptTime><BillDept>骨一科</BillDept><ExecDept>住院西药房</ExecDept><Doctor>熊家亭</Doctor><FeesType>自费</FeesType><FeesItem>西药</FeesItem><GroupID>0101002040201</GroupID><GroupName>利巴韦林滴眼液</GroupName><ItemID>0101002040201</ItemID><ItemName>利巴韦林滴眼液</ItemName><ItemUnit>支</ItemUnit><Num>1</Num><Price>1.40</Price><ShouldMoney>1.40</ShouldMoney><ActualMoney>1.40</ActualMoney></Item><Item><ReceiptNo>0001561192</ReceiptNo><ReceiptTime>2015-08-25 10:45:07</ReceiptTime><BillDept>骨一科</BillDept><ExecDept>住院西药房</ExecDept><Doctor>熊家亭</Doctor><FeesType>自费</FeesType><FeesItem>西药</FeesItem><GroupID>0101007022201</GroupID><GroupName>非诺贝特胶囊（力平之）</GroupName><ItemID>0101007022201</ItemID><ItemName>非诺贝特胶囊（力平之）</ItemName><ItemUnit>粒</ItemUnit><Num>50</Num><Price>4.3091</Price><ShouldMoney>215.46</ShouldMoney><ActualMoney>215.46</ActualMoney></Item></List></Response>");
                    }
                    else if (msg.indexOf("7005") > 0)
                    {
                        writer.write("00001997<?xml version=\"1.0\" encoding=\"utf-8\" ?><Response><TransCode>7005</TransCode><ResultCode>0</ResultCode><ErrorMsg>成功</ErrorMsg><Count>4</Count><RequestQty>4</RequestQty>"
                            + "<List>"
                            + "<Item><ReceiptNo>0001561191</ReceiptNo><ExecTime>2015-08-22 10:43:39</ExecTime><RequestTime>2015-08-20 10:43:39</RequestTime><WardCode>555</WardCode><RequestDept>骨一科</RequestDept><ExecDept>门诊西药房</ExecDept><Doctor>熊家亭</Doctor><FeesType>自费</FeesType><FeesItem>西药</FeesItem><GroupID>0101019050604</GroupID><GroupName>5%葡萄糖氯化钠注射液(内封式)</GroupName><ItemID>0101019050604</ItemID><ItemName>5%葡萄糖氯化钠注射液(内封式)</ItemName><ItemUnit>袋</ItemUnit><Num>1</Num><Price>8.8090</Price><ShouldMoney>8.81</ShouldMoney><ActualMoney>3.81</ActualMoney><SelfPrice>8.81</SelfPrice><YhPrice>0.00</YhPrice><SelfMoney>8.81</SelfMoney><SettlementStatus>1</SettlementStatus><RecordStatus>0</RecordStatus><YhMoney>8.81</YhMoney></Item>"
                            + "<Item><ReceiptNo>0001561192</ReceiptNo><ExecTime>2015-08-23 10:43:39</ExecTime><RequestTime>2015-08-20 10:43:39</RequestTime><WardCode>555</WardCode><RequestDept>骨一科</RequestDept><ExecDept>门诊西药房</ExecDept><Doctor>熊家亭</Doctor><FeesType>自费</FeesType><FeesItem>西药</FeesItem><GroupID>0101009020601</GroupID><GroupName>多巴丝肼片</GroupName><ItemID>0101009020601</ItemID><ItemName>多巴丝肼片</ItemName><ItemUnit>片</ItemUnit><Num>40</Num><Price>2.36</Price><ShouldMoney>94.40</ShouldMoney><ActualMoney>4.40</ActualMoney><SelfPrice>4.81</SelfPrice><YhPrice>0.00</YhPrice><SelfMoney>8.81</SelfMoney><SettlementStatus>1</SettlementStatus><RecordStatus>2</RecordStatus><YhMoney>8.81</YhMoney></Item>"
                            + "<Item><ReceiptNo>0001561193</ReceiptNo><ExecTime>2015-08-24 10:45:07</ExecTime><RequestTime>2015-08-20 10:43:39</RequestTime><WardCode>555</WardCode><RequestDept>骨一科</RequestDept><ExecDept>住院西药房</ExecDept><Doctor>熊家亭</Doctor><FeesType>自费</FeesType><FeesItem>西药</FeesItem><GroupID>0101002040201</GroupID><GroupName>利巴韦林滴眼液</GroupName><ItemID>0101002040201</ItemID><ItemName>利巴韦林滴眼液</ItemName><ItemUnit>支</ItemUnit><Num>1</Num><Price>1.40</Price><ShouldMoney>1.40</ShouldMoney><ActualMoney>1.40</ActualMoney><SelfPrice>5.81</SelfPrice><YhPrice>0.00</YhPrice><SelfMoney>8.81</SelfMoney><SettlementStatus>0</SettlementStatus><RecordStatus>1</RecordStatus><YhMoney>8.81</YhMoney></Item>"
                            + "<Item><ReceiptNo>0001561194</ReceiptNo><ExecTime>2015-08-25 10:45:07</ExecTime><RequestTime>2015-08-20 10:43:39</RequestTime><WardCode>555</WardCode><RequestDept>骨一科</RequestDept><ExecDept>住院西药房</ExecDept><Doctor>熊家亭</Doctor><FeesType>自费</FeesType><FeesItem>西药</FeesItem><GroupID>0101007022201</GroupID><GroupName>非诺贝特胶囊（力平之）</GroupName><ItemID>0101007022201</ItemID><ItemName>非诺贝特胶囊（力平之）</ItemName><ItemUnit>粒</ItemUnit><Num>50</Num><Price>4.3091</Price><ShouldMoney>215.46</ShouldMoney><ActualMoney>215.46</ActualMoney><SelfPrice>8.81</SelfPrice><YhPrice>0.00</YhPrice><SelfMoney>8.81</SelfMoney><SettlementStatus>1</SettlementStatus><RecordStatus>1</RecordStatus><YhMoney>8.81</YhMoney></Item>"
                            + "</List></Response>");
                    }
                    else if (msg.indexOf("920001") > 0)
                    {
                        writer.write("00000515<?xml version=\"1.0\" encoding=\"utf-8\" ?>"
                            + "<msg><pub><TranCode>920001</TranCode><ChannelSeq>331025718</ChannelSeq><ChannelDate>20260203</ChannelDate>"
                            + "<ChannelTime>085823</ChannelTime><AppDate>20150106</AppDate><AppTime>084314</AppTime>"
                            + "<AppSeqNo>11209906</AppSeqNo><RspCode>000000</RspCode><RspMsg>交易成功</RspMsg></pub><data>"
                            + "<yhzh>22401900019</yhzh><yhmc>汉口银行</yhmc><zhye>10</zhye><dfzh>11</dfzh><dfzhmc>12</dfzhmc></data></msg>");
                    }
                    else if (msg.indexOf("4001") > 0)
                    {
                        writer.write("00000515<?xml version=\"1.0\" encoding=\"utf-8\" ?>"
                            + "<Response><TransCode>4001</TransCode><ResultCode>0</ResultCode><ErrorMsg></ErrorMsg>"
                            + "<List><Item><CardTypeName>专家号</CardTypeName></Item><Item><CardTypeName>普通号</CardTypeName></Item><Item><CardTypeName>急诊号</CardTypeName></Item></List></Response>");
                    }
                    else if (msg.indexOf("4002") > 0)
                    {
                        writer.write("00002301<?xml version=\"1.0\" encoding=\"utf-8\" ?><Response><TransCode>4002</TransCode><ResultCode>0</ResultCode><ErrorMsg>查询成功</ErrorMsg><Count>37</Count><ReturnQty>37</ReturnQty><List><Item><DeptId>8</DeptId><DeptName>神经内科</DeptName></Item><Item><DeptId>140</DeptId><DeptName>骨科门诊</DeptName></Item><Item><DeptId>10</DeptId><DeptName>感染科(内2)</DeptName></Item><Item><DeptId>12</DeptId><DeptName>内三科</DeptName></Item><Item><DeptId>142</DeptId><DeptName>乳腺门诊</DeptName></Item><Item><DeptId>14</DeptId><DeptName>内四科</DeptName></Item><Item><DeptId>143</DeptId><DeptName>口腔科</DeptName></Item><Item><DeptId>144</DeptId><DeptName>皮肤科</DeptName></Item><Item><DeptId>17</DeptId><DeptName>发热泡疹专科</DeptName></Item><Item><DeptId>145</DeptId><DeptName>120急救中心</DeptName></Item><Item><DeptId>19</DeptId><DeptName>内六科</DeptName></Item><Item><DeptId>146</DeptId><DeptName>急诊科</DeptName></Item><Item><DeptId>21</DeptId><DeptName>综合ICU</DeptName></Item><Item><DeptId>147</DeptId><DeptName>专家门诊</DeptName></Item><Item><DeptId>148</DeptId><DeptName>康复医学科</DeptName></Item><Item><DeptId>25</DeptId><DeptName>内七(呼吸)科</DeptName></Item><Item><DeptId>28</DeptId><DeptName>中医科</DeptName></Item><Item><DeptId>150</DeptId><DeptName>体检中心</DeptName></Item><Item><DeptId>30</DeptId><DeptName>外一科</DeptName></Item><Item><DeptId>33</DeptId><DeptName>骨一科</DeptName></Item><Item><DeptId>35</DeptId><DeptName>骨二科</DeptName></Item><Item><DeptId>37</DeptId><DeptName>外三科</DeptName></Item><Item><DeptId>39</DeptId><DeptName>外四科</DeptName></Item><Item><DeptId>42</DeptId><DeptName>胸外科</DeptName></Item><Item><DeptId>44</DeptId><DeptName>肛肠科</DeptName></Item><Item><DeptId>46</DeptId><DeptName>产科1</DeptName></Item><Item><DeptId>47</DeptId><DeptName>产科2</DeptName></Item><Item><DeptId>49</DeptId><DeptName>妇科</DeptName></Item><Item><DeptId>51</DeptId><DeptName>儿科</DeptName></Item><Item><DeptId>53</DeptId><DeptName>五官科</DeptName></Item><Item><DeptId>55</DeptId><DeptName>疼痛科</DeptName></Item><Item><DeptId>57</DeptId><DeptName>肿瘤科</DeptName></Item><Item><DeptId>60</DeptId><DeptName>内五科</DeptName></Item><Item><DeptId>62</DeptId><DeptName>精神科</DeptName></Item><Item><DeptId>170</DeptId><DeptName>法医门诊</DeptName></Item><Item><DeptId>171</DeptId><DeptName>结核门诊</DeptName></Item><Item><DeptId>172</DeptId><DeptName>便民门诊</DeptName></Item></List></Response>");
                    }
                    else if (msg.indexOf("4003") > 0)
                    {
                        writer.write("00000394<?xml version=\"1.0\" encoding=\"utf-8\" ?><Response><TransCode>4003</TransCode><ResultCode>0</ResultCode><ErrorMsg>查询成功</ErrorMsg><Count>10</Count><ReturnQty>1</ReturnQty><List><Item><AsRowid>0</AsRowid><MarkId>-1</MarkId><MarkDesc>科室号</MarkDesc><SessionType>普通号(口腔)</SessionType><HBTime>全天(00:00-23:59)</HBTime><RegCount>100</RegCount><Price>0.01</Price><IsTime>1</IsTime></Item>"
                            + "<Item><AsRowid>0</AsRowid><MarkId>-1</MarkId><MarkDesc>科室号2</MarkDesc><SessionType>普通号(口腔)</SessionType><HBTime>全天(00:00-23:59)</HBTime><RegCount>100</RegCount><Price>0.01</Price><IsTime>1</IsTime></Item>"
                            + "<Item><AsRowid>0</AsRowid><MarkId>-1</MarkId><MarkDesc>科室号3</MarkDesc><SessionType>普通号(口腔)</SessionType><HBTime>全天(00:00-23:59)</HBTime><RegCount>100</RegCount><Price>0.01</Price><IsTime>1</IsTime></Item>"
                            + "<Item><AsRowid>0</AsRowid><MarkId>-1</MarkId><MarkDesc>科室号4</MarkDesc><SessionType>普通号(口腔)</SessionType><HBTime>全天(00:00-23:59)</HBTime><RegCount>100</RegCount><Price>0.01</Price><IsTime>1</IsTime></Item>"
                            + "<Item><AsRowid>0</AsRowid><MarkId>-1</MarkId><MarkDesc>科室号5</MarkDesc><SessionType>普通号(口腔)</SessionType><HBTime>全天(00:00-23:59)</HBTime><RegCount>100</RegCount><Price>0.01</Price><IsTime>1</IsTime></Item>"
                            + "<Item><AsRowid>0</AsRowid><MarkId>-1</MarkId><MarkDesc>科室号6</MarkDesc><SessionType>普通号(口腔)</SessionType><HBTime>全天(00:00-23:59)</HBTime><RegCount>100</RegCount><Price>0.01</Price><IsTime>1</IsTime></Item>"
                            + "<Item><AsRowid>0</AsRowid><MarkId>-1</MarkId><MarkDesc>科室号12</MarkDesc><SessionType>普通号(口腔)</SessionType><HBTime>全天(00:00-23:59)</HBTime><RegCount>100</RegCount><Price>0.01</Price><IsTime>1</IsTime></Item></List></Response>");
                    }
                    else if (msg.indexOf("2002") > 0)
                    {
                        writer.write("00000123<?xml version=\"1.0\" encoding=\"utf-8\" ?>"
                            + "<Response><TransCode>2002</TransCode><ResultCode>0</ResultCode><ErrorMsg></ErrorMsg>"
                            + "<List><Item><CardTypeID>1</CardTypeID><CardTypeName>居民健康卡</CardTypeName><InsureId></InsureId><InsureName></InsureName></Item></List></Response>");
                    }
                    else if (msg.indexOf("2004") > 0)
                    {
                        writer.write("00000123<?xml version=\"1.0\" encoding=\"utf-8\" ?>"
                            + "<Response><TransCode>2004</TransCode><ResultCode>0</ResultCode><ErrorMsg></ErrorMsg>"
                            + "<PatientID>1234</PatientID><CardTranFlow>12345</CardTranFlow><PayTranFlow>123456</PayTranFlow><TranTime>2015-07-28 15:20:20</TranTime><Amt>900</Amt></Response>");
                    }
                    else if (msg.indexOf("2003") > 0)
                    {
                        writer.write("00000123<?xml version=\"1.0\" encoding=\"utf-8\" ?>"
                            + "<Response><TransCode>2003</TransCode><ResultCode>0</ResultCode><ErrorMsg></ErrorMsg>"
                            + "<Status>1</Status></Response>");
                    }
                    else if (msg.indexOf("6001") > 0)
                    {
                        writer.write("00000123<?xml version=\"1.0\" encoding=\"utf-8\" ?>"
                            + "<Response><TransCode>6001</TransCode><ErrorMsg></ErrorMsg><ResultCode>0</ResultCode><List><Item><outReportID>15082700710</outReportID><outReportDate>2015/8/27 23:27:22</outReportDate><outReportType>血脂四项</outReportType><outReportClass>1</outReportClass></Item><Item><outReportID>15082700710</outReportID><outReportDate>2015/8/27 23:27:22</outReportDate><outReportType>肾功能2号</outReportType><outReportClass>1</outReportClass></Item><Item><outReportID>15082700710</outReportID><outReportDate>2015/8/27 23:27:22</outReportDate><outReportType>肝功能2号</outReportType><outReportClass>1</outReportClass></Item><Item><outReportID>15082700710</outReportID><outReportDate>2015/8/27 23:27:22</outReportDate><outReportType>电解质</outReportType><outReportClass>1</outReportClass></Item><Item><outReportID>15082700710</outReportID><outReportDate>2015/8/27 23:27:22</outReportDate><outReportType>心功能</outReportType><outReportClass>1</outReportClass></Item></List></Response>");
                    }
                    else if (msg.indexOf("4005") > 0)
                    {
                        writer.write("00000123<?xml version=\"1.0\" encoding=\"utf-8\" ?>"
                            + "<Response><TransCode>4005</TransCode><ResultCode>0</ResultCode><ErrorMsg></ErrorMsg>"
                            + "<TranFlow>123</TranFlow><RegisterNo>1234</RegisterNo><AsRowid>12</AsRowid><JZTime>2015-07-30 15:20:20</JZTime><JZNo>1234</JZNo><Type>123</Type><PatName>张三</PatName><MZH>1234</MZH><FeesType>123</FeesType><FeesItem>234</FeesItem><DeptName>外科</DeptName><Loc>123</Loc><DoctorName>345</DoctorName><SessionType>副教授</SessionType><RegTime>2015-07-30 15:30:30</RegTime></Response>");
                    }
                    else if (msg.indexOf("6002") > 0)
                    {
                        writer.write("00000123<?xml version=\"1.0\" encoding=\"utf-8\" ?>"
                            + "<Response><TransCode>6002</TransCode><ErrorMsg></ErrorMsg><ResultCode>0</ResultCode><outReportID>509954</outReportID><outReportType>血脂四项</outReportType><outSampleNo>200</outSampleNo><outTestDate>2015/8/27 14:39:10</outTestDate><outReportDate>2015/8/27 23:27:22</outReportDate><outPatientName>饶太枝</outPatientName><outPatientSex>女</outPatientSex><outPatientAge>70.0岁</outPatientAge><outSampleType>0</outSampleType><outFeeType></outFeeType><outSamplingDate>2015/8/27 14:39:10</outSamplingDate><outApplySection>内七(呼吸)科</outApplySection><outApplyArea>内七(呼吸)科</outApplyArea><outBedNo>025</outBedNo><outSendDoctor>王定珍</outSendDoctor><outSendDate>2015/8/27 0:00:00</outSendDate><outCheckDoctor>李运恒</outCheckDoctor><outReportDoctor>李运恒</outReportDoctor><outDiagnose>待查</outDiagnose><outMemo></outMemo><outPatientID>0000050003</outPatientID><outMachineCode>AU640</outMachineCode><outRemark></outRemark><outResultID>509954</outResultID><outPatientType>住院</outPatientType><outBarcode>15082700710</outBarcode><outReportSection>生化检验</outReportSection><ResultCode>0</ResultCode><outReportID>509954</outReportID><outReportType>肾功能2号</outReportType><outSampleNo>200</outSampleNo><outTestDate>2015/8/27 14:39:10</outTestDate><outReportDate>2015/8/27 23:27:22</outReportDate><outPatientName>饶太枝</outPatientName><outPatientSex>女</outPatientSex><outPatientAge>70.0岁</outPatientAge><outSampleType>0</outSampleType><outFeeType></outFeeType><outSamplingDate>2015/8/27 14:39:10</outSamplingDate><outApplySection>内七(呼吸)科</outApplySection><outApplyArea>内七(呼吸)科</outApplyArea><outBedNo>025</outBedNo><outSendDoctor>王定珍</outSendDoctor><outSendDate>2015/8/27 0:00:00</outSendDate><outCheckDoctor>李运恒</outCheckDoctor><outReportDoctor>李运恒</outReportDoctor><outDiagnose>待查</outDiagnose><outMemo></outMemo><outPatientID>0000050003</outPatientID><outMachineCode>AU640</outMachineCode><outRemark></outRemark><outResultID>509954</outResultID><outPatientType>住院</outPatientType><outBarcode>15082700710</outBarcode><outReportSection>生化检验</outReportSection><ResultCode>0</ResultCode><outReportID>509954</outReportID><outReportType>肝功能2号</outReportType><outSampleNo>200</outSampleNo><outTestDate>2015/8/27 14:39:10</outTestDate><outReportDate>2015/8/27 23:27:22</outReportDate><outPatientName>饶太枝</outPatientName><outPatientSex>女</outPatientSex><outPatientAge>70.0岁</outPatientAge><outSampleType>0</outSampleType><outFeeType></outFeeType><outSamplingDate>2015/8/27 14:39:10</outSamplingDate><outApplySection>内七(呼吸)科</outApplySection><outApplyArea>内七(呼吸)科</outApplyArea><outBedNo>025</outBedNo><outSendDoctor>王定珍</outSendDoctor><outSendDate>2015/8/27 0:00:00</outSendDate><outCheckDoctor>李运恒</outCheckDoctor><outReportDoctor>李运恒</outReportDoctor><outDiagnose>待查</outDiagnose><outMemo></outMemo><outPatientID>0000050003</outPatientID><outMachineCode>AU640</outMachineCode><outRemark></outRemark><outResultID>509954</outResultID><outPatientType>住院</outPatientType><outBarcode>15082700710</outBarcode><outReportSection>生化检验</outReportSection><ResultCode>0</ResultCode><outReportID>509954</outReportID><outReportType>电解质</outReportType><outSampleNo>200</outSampleNo><outTestDate>2015/8/27 14:39:10</outTestDate><outReportDate>2015/8/27 23:27:22</outReportDate><outPatientName>饶太枝</outPatientName><outPatientSex>女</outPatientSex><outPatientAge>70.0岁</outPatientAge><outSampleType>0</outSampleType><outFeeType></outFeeType><outSamplingDate>2015/8/27 14:39:10</outSamplingDate><outApplySection>内七(呼吸)科</outApplySection><outApplyArea>内七(呼吸)科</outApplyArea><outBedNo>025</outBedNo><outSendDoctor>王定珍</outSendDoctor><outSendDate>2015/8/27 0:00:00</outSendDate><outCheckDoctor>李运恒</outCheckDoctor><outReportDoctor>李运恒</outReportDoctor><outDiagnose>待查</outDiagnose><outMemo></outMemo><outPatientID>0000050003</outPatientID><outMachineCode>AU640</outMachineCode><outRemark></outRemark><outResultID>509954</outResultID><outPatientType>住院</outPatientType><outBarcode>15082700710</outBarcode><outReportSection>生化检验</outReportSection><ResultCode>0</ResultCode><outReportID>509954</outReportID><outReportType>心功能</outReportType><outSampleNo>200</outSampleNo><outTestDate>2015/8/27 14:39:10</outTestDate><outReportDate>2015/8/27 23:27:22</outReportDate><outPatientName>饶太枝</outPatientName><outPatientSex>女</outPatientSex><outPatientAge>70.0岁</outPatientAge><outSampleType>0</outSampleType><outFeeType></outFeeType><outSamplingDate>2015/8/27 14:39:10</outSamplingDate><outApplySection>内七(呼吸)科</outApplySection><outApplyArea>内七(呼吸)科</outApplyArea><outBedNo>025</outBedNo><outSendDoctor>王定珍</outSendDoctor><outSendDate>2015/8/27 0:00:00</outSendDate><outCheckDoctor>李运恒</outCheckDoctor><outReportDoctor>李运恒</outReportDoctor><outDiagnose>待查</outDiagnose><outMemo></outMemo><outPatientID>0000050003</outPatientID><outMachineCode>AU640</outMachineCode><outRemark></outRemark><outResultID>509954</outResultID><outPatientType>住院</outPatientType><outBarcode>15082700710</outBarcode><outReportSection>生化检验</outReportSection></Response>");
                    }
                    else if (msg.indexOf("6003") > 0)
                    {
                        writer.write("00000123<?xml version=\"1.0\" encoding=\"utf-8\" ?>"
                            + "<Response><TransCode>6003</TransCode><ErrorMsg></ErrorMsg><ResultCode>0</ResultCode><List><Item><outItemCode>hs-cTNI</outItemCode><outItemName>超敏心肌钙蛋白Ⅰ</outItemName><outItemValue>0.29</outItemValue><outItemFlag>↑</outItemFlag><outUnit>ng/ml</outUnit><outReference>&lt;0.1</outReference><outReferenceShow>&lt;0.1ng/ml</outReferenceShow><outCheckWay>AU640</outCheckWay></Item><Item><outItemCode>ESR</outItemCode><outItemName>血沉</outItemName><outItemValue>80</outItemValue><outItemFlag>↑</outItemFlag><outUnit>mm/h    </outUnit><outReference>0～20</outReference><outReferenceShow>0～20mm/h    </outReferenceShow><outCheckWay>AU640</outCheckWay></Item><Item><outItemCode>CK-MB</outItemCode><outItemName>肌酸激酶同工酶</outItemName><outItemValue>8.2</outItemValue><outItemFlag></outItemFlag><outUnit>U/L</outUnit><outReference>0～24</outReference><outReferenceShow>0～24U/L</outReferenceShow><outCheckWay>AU640</outCheckWay></Item><Item><outItemCode>CK</outItemCode><outItemName>磷酸肌酸激酶</outItemName><outItemValue>28.4</outItemValue><outItemFlag></outItemFlag><outUnit>U/L</outUnit><outReference>26～140</outReference><outReferenceShow>26～140U/L</outReferenceShow><outCheckWay>AU640</outCheckWay></Item><Item><outItemCode>HCY</outItemCode><outItemName>同型半胱氨酸</outItemName><outItemValue>20.05</outItemValue><outItemFlag>↑</outItemFlag><outUnit>umol/L</outUnit><outReference>0～15</outReference><outReferenceShow>0～15umol/L</outReferenceShow><outCheckWay>AU640</outCheckWay></Item><Item><outItemCode>LDL-C</outItemCode><outItemName>低密度脂蛋白        </outItemName><outItemValue>1.650</outItemValue><outItemFlag></outItemFlag><outUnit>mmol/L</outUnit><outReference>0～3.12</outReference><outReferenceShow>0～3.12mmol/L</outReferenceShow><outCheckWay>AU640</outCheckWay></Item><Item><outItemCode>HDL-C</outItemCode><outItemName>高密度脂蛋白</outItemName><outItemValue>0.970</outItemValue><outItemFlag></outItemFlag><outUnit>mmol/L</outUnit><outReference>0.83～1.96</outReference><outReferenceShow>0.83～1.96mmol/L</outReferenceShow><outCheckWay>AU640</outCheckWay></Item><Item><outItemCode>TG</outItemCode><outItemName>甘油三脂            </outItemName><outItemValue>1.010</outItemValue><outItemFlag></outItemFlag><outUnit>mmol/L  </outUnit><outReference>0.23～1.23</outReference><outReferenceShow>0.23～1.23mmol/L  </outReferenceShow><outCheckWay>AU640</outCheckWay></Item><Item><outItemCode>CHOL</outItemCode><outItemName>血清总胆固醇</outItemName><outItemValue>2.940</outItemValue><outItemFlag></outItemFlag><outUnit>mmol/L</outUnit><outReference>0～5.2</outReference><outReferenceShow>0～5.2mmol/L</outReferenceShow><outCheckWay>AU640</outCheckWay></Item><Item><outItemCode>P</outItemCode><outItemName>磷</outItemName><outItemValue>0.990</outItemValue><outItemFlag></outItemFlag><outUnit>mmol/L</outUnit><outReference>0.9～1.34</outReference><outReferenceShow>0.9～1.34mmol/L</outReferenceShow><outCheckWay>AU640</outCheckWay></Item><Item><outItemCode>MG</outItemCode><outItemName>镁</outItemName><outItemValue>0.770</outItemValue><outItemFlag></outItemFlag><outUnit>mmol/L</outUnit><outReference>0.67～1.04</outReference><outReferenceShow>0.67～1.04mmol/L</outReferenceShow><outCheckWay>AU640</outCheckWay></Item><Item><outItemCode>Ca</outItemCode><outItemName>钙</outItemName><outItemValue>1.99</outItemValue><outItemFlag>↓</outItemFlag><outUnit>mmol/L</outUnit><outReference>2.08～2.8</outReference><outReferenceShow>2.08～2.8mmol/L</outReferenceShow><outCheckWay>AU640</outCheckWay></Item><Item><outItemCode>CL</outItemCode><outItemName>氯</outItemName><outItemValue>110.10</outItemValue><outItemFlag>↑</outItemFlag><outUnit>mmol/L</outUnit><outReference>99～110</outReference><outReferenceShow>99～110mmol/L</outReferenceShow><outCheckWay>AU640</outCheckWay></Item><Item><outItemCode>Na</outItemCode><outItemName>钠</outItemName><outItemValue>143.7</outItemValue><outItemFlag></outItemFlag><outUnit>mmol/L</outUnit><outReference>137～147</outReference><outReferenceShow>137～147mmol/L</outReferenceShow><outCheckWay>AU640</outCheckWay></Item><Item><outItemCode>K</outItemCode><outItemName>钾</outItemName><outItemValue>3.43</outItemValue><outItemFlag>↓</outItemFlag><outUnit>mmol/L</outUnit><outReference>3.5～5.3</outReference><outReferenceShow>3.5～5.3mmol/L</outReferenceShow><outCheckWay>AU640</outCheckWay></Item><Item><outItemCode>CO2</outItemCode><outItemName>二氧化碳结合力</outItemName><outItemValue>22.9</outItemValue><outItemFlag></outItemFlag><outUnit>mmol/L</outUnit><outReference>20～29</outReference><outReferenceShow>20～29mmol/L</outReferenceShow><outCheckWay>AU640</outCheckWay></Item><Item><outItemCode>UA</outItemCode><outItemName>尿酸                </outItemName><outItemValue>348.1</outItemValue><outItemFlag></outItemFlag><outUnit>umol/L  </outUnit><outReference>155～357</outReference><outReferenceShow>155～357umol/L  </outReferenceShow><outCheckWay>AU640</outCheckWay></Item><Item><outItemCode>BUN/CR</outItemCode><outItemName>尿素氮肌酐比</outItemName><outItemValue>0.033</outItemValue><outItemFlag></outItemFlag><outUnit> </outUnit><outReference></outReference><outReferenceShow> </outReferenceShow><outCheckWay>AU640</outCheckWay></Item><Item><outItemCode>CREA</outItemCode><outItemName>肌酐</outItemName><outItemValue>86.7</outItemValue><outItemFlag></outItemFlag><outUnit>umol/L</outUnit><outReference>40～88</outReference><outReferenceShow>40～88umol/L</outReferenceShow><outCheckWay>AU640</outCheckWay></Item><Item><outItemCode>BUN</outItemCode><outItemName>尿素氮</outItemName><outItemValue>2.900</outItemValue><outItemFlag></outItemFlag><outUnit>mmol/L</outUnit><outReference>2.9～8.2</outReference><outReferenceShow>2.9～8.2mmol/L</outReferenceShow><outCheckWay>AU640</outCheckWay></Item><Item><outItemCode>B2-MG</outItemCode><outItemName>β2-微球蛋白</outItemName><outItemValue>6.59</outItemValue><outItemFlag>↑</outItemFlag><outUnit>mg/L</outUnit><outReference>0.8～2.8</outReference><outReferenceShow>0.8～2.8mg/L</outReferenceShow><outCheckWay>AU640</outCheckWay></Item><Item><outItemCode>GLU</outItemCode><outItemName>葡萄糖</outItemName><outItemValue>3.88</outItemValue><outItemFlag>↓</outItemFlag><outUnit>mmol/L</outUnit><outReference>3.89～6.11</outReference><outReferenceShow>3.89～6.11mmol/L</outReferenceShow><outCheckWay>AU640</outCheckWay></Item><Item><outItemCode>LDH</outItemCode><outItemName>乳酸脱氢酶</outItemName><outItemValue>315.5</outItemValue><outItemFlag>↑</outItemFlag><outUnit>U/L</outUnit><outReference>103～227</outReference><outReferenceShow>103～227U/L</outReferenceShow><outCheckWay>AU640</outCheckWay></Item><Item><outItemCode>A-G</outItemCode><outItemName>白球比例</outItemName><outItemValue>1.189</outItemValue><outItemFlag>↓</outItemFlag><outUnit></outUnit><outReference>1.2～2.4</outReference><outReferenceShow>1.2～2.4</outReferenceShow><outCheckWay>AU640</outCheckWay></Item><Item><outItemCode>GELO</outItemCode><outItemName>球蛋白</outItemName><outItemValue>26.9</outItemValue><outItemFlag></outItemFlag><outUnit>G/L</outUnit><outReference>20～40</outReference><outReferenceShow>20～40G/L</outReferenceShow><outCheckWay>AU640</outCheckWay></Item><Item><outItemCode>ALB</outItemCode><outItemName>白蛋白</outItemName><outItemValue>32.0</outItemValue><outItemFlag>↓</outItemFlag><outUnit>G/L</outUnit><outReference>35～55</outReference><outReferenceShow>35～55G/L</outReferenceShow><outCheckWay>AU640</outCheckWay></Item><Item><outItemCode>TP</outItemCode><outItemName>总蛋白</outItemName><outItemValue>58.9</outItemValue><outItemFlag>↓</outItemFlag><outUnit>G/L</outUnit><outReference>60～85</outReference><outReferenceShow>60～85G/L</outReferenceShow><outCheckWay>AU640</outCheckWay></Item><Item><outItemCode>IDBIL</outItemCode><outItemName>间接胆红素</outItemName><outItemValue>6.650</outItemValue><outItemFlag></outItemFlag><outUnit>umol/L</outUnit><outReference></outReference><outReferenceShow>umol/L</outReferenceShow><outCheckWay>AU640</outCheckWay></Item><Item><outItemCode>DBIL</outItemCode><outItemName>直接胆红素</outItemName><outItemValue>4.2</outItemValue><outItemFlag></outItemFlag><outUnit>umol/L</outUnit><outReference>0～10</outReference><outReferenceShow>0～10umol/L</outReferenceShow><outCheckWay>AU640</outCheckWay></Item><Item><outItemCode>TBIL</outItemCode><outItemName>胆红素</outItemName><outItemValue>10.90</outItemValue><outItemFlag></outItemFlag><outUnit>umol/L  </outUnit><outReference>5.1～28</outReference><outReferenceShow>5.1～28umol/L  </outReferenceShow><outCheckWay>AU640</outCheckWay></Item><Item><outItemCode>AST/ALT</outItemCode><outItemName>谷草/谷丙转氨酶比值</outItemName><outItemValue>1.5</outItemValue><outItemFlag></outItemFlag><outUnit></outUnit><outReference>0.5～2</outReference><outReferenceShow>0.5～2</outReferenceShow><outCheckWay>AU640</outCheckWay></Item><Item><outItemCode>AST</outItemCode><outItemName>谷草转氨酶</outItemName><outItemValue>17.6</outItemValue><outItemFlag></outItemFlag><outUnit>U/L</outUnit><outReference>13～35</outReference><outReferenceShow>13～35U/L</outReferenceShow><outCheckWay>AU640</outCheckWay></Item><Item><outItemCode>ALT</outItemCode><outItemName>谷丙转氨酶</outItemName><outItemValue>11.9</outItemValue><outItemFlag></outItemFlag><outUnit>U/L</outUnit><outReference>7～40</outReference><outReferenceShow>7～40U/L</outReferenceShow><outCheckWay>AU640</outCheckWay></Item></List></Response>");
                    }
                    else if (msg.indexOf("6004") > 0)
                    {
                        writer.write("00000123<?xml version=\"1.0\" encoding=\"utf-8\" ?>"
                            + "<Response><TransCode>6004</TransCode><ResultCode>0</ResultCode><ErrorMsg></ErrorMsg>"
                            + "<outReportID>123</outReportID><outReportType>1234</outReportType><outSampleNo>12</outSampleNo><outTestDate>2015-07-30</outTestDate><outReportDate>1234</outReportDate><outPatientName>张三</outPatientName>"
                            + "<outPatientSex>男</outPatientSex><outPatientAge>35</outPatientAge><outSampleType>123</outSampleType><outFeeType>234</outFeeType><outSamplingDate>2015-07-30</outSamplingDate><outApplySection>检验科</outApplySection><outApplyArea>345</outApplyArea><outBedNo>123</outBedNo><outSendDoctor>123</outSendDoctor>"
                            + "<outSendDate>2015-07-30</outSendDate><outCheckDoctor>123</outCheckDoctor><outReportDoctor>1234</outReportDoctor><outDiagnose>1234</outDiagnose><outMemo>1234</outMemo><outPatientID>456</outPatientID><outMachineCode>1234</outMachineCode><outRemark>1234</outRemark><outPatientType>住院</outPatientType><outBarCode>678</outBarCode><outReportSection>12345</outReportSection><outGermFlag>12345</outGermFlag>"
                            + "<List><Item><outResultType>1234</outResultType><outGermCode>2345</outGermCode><outGermName>1234</outGermName><outTrainResult>12345</outTrainResult><outGermResultID>12345</outGermResultID><outPrintItem1>1231</outPrintItem1><outPrintItem2>1232</outPrintItem2><outPrintItem3>1233</outPrintItem3></Item></List></Response>");
                    }
                    else if (msg.indexOf("6005") > 0)
                    {
                        writer.write("00000123<?xml version=\"1.0\" encoding=\"utf-8\" ?>"
                            + "<Response><TransCode>6005</TransCode><ResultCode>0</ResultCode><ErrorMsg></ErrorMsg>"
                            + "<outItemCode>1234</outItemCode><outItemName>1234</outItemName><outItemValue>12345</outItemValue><outCheckWay>12</outCheckWay><outMIC>1234</outMIC><outYJH>1234</outYJH><outReference>1234</outReference><outPrintItem1>123</outPrintItem1><outPrintItem2>1232</outPrintItem2><outPrintItem3>1233</outPrintItem3><outPrintItem4>12334</outPrintItem4><outPrintItem5>1235</outPrintItem5></Response>");
                    }
                    else if (msg.indexOf("6006") > 0)
                    {
                        writer.write("00000123<?xml version=\"1.0\" encoding=\"utf-8\" ?>"
                            + "<Response><TransCode>6006</TransCode><ResultCode>0</ResultCode><ErrorMsg></ErrorMsg></Response>");
                    }
                    else if (msg.indexOf("7001") > 0)
                    {
                        writer.write("00000123<?xml version=\"1.0\" encoding=\"utf-8\" ?>"
                            + "<Response><TransCode>7001</TransCode><ResultCode>0</ResultCode><ErrorMsg></ErrorMsg>"
                            + "<PatientID>121212</PatientID><HosCardNo>33333</HosCardNo><HosNature>33333</HosNature>"
                            + "<DeptName>外科</DeptName><DeptId>33333</DeptId>"
                            + "<BedNo>12</BedNo><HosDate>2015-10-12 10:44:33</HosDate>"
                            + "<HosType>1</HosType><OutHosDate>2015-12-12</OutHosDate>"
                            + "<PatName>李四</PatName><PatSex>1</PatSex>"
                            + "<IDCard>1</IDCard><Birthday>2015-12-12</Birthday>"
                            + "<AccBalance>1</AccBalance><Tel>1851212121</Tel>" + "</Response>");
                    }
                    else if (msg.indexOf("7002") > 0)
                    {
                        writer.write("00000123<?xml version=\"1.0\" encoding=\"utf-8\" ?>"
                            + "<Response><TransCode>7002</TransCode><ResultCode>0</ResultCode><ErrorMsg></ErrorMsg>"
                            + "<ReceiptNo>121212</ReceiptNo>" + "</Response>");
                    }
                    else if (msg.indexOf("4008") > 0)
                    {
                        writer.write("00000123<?xml version=\"1.0\" encoding=\"utf-8\" ?>"
                            + "<Response><TransCode>4008</TransCode><ResultCode>0</ResultCode><ErrorMsg></ErrorMsg>"
                            + "</Response>");
                    }
                    else
                    {
                        writer.write("00000123<?xml version=\"1.0\" encoding=\"utf-8\" ?>"
                            + "<Response><TransCode>9999</TransCode><ResultCode>1</ResultCode><ErrorMsg>send xml error</ErrorMsg>"
                            + "</Response>");
                    }
                    
                    writer.flush();
                    writer.close();
                    br.close();
                }
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            super.run();
        }
    }
    
    public static void main(String[] args)
        throws IOException
    {
        
        String aaa =
            "<?xml version=\"1.0\" encoding=\"utf-8\" ?>"
                + "<Response><TransCode>4005</TransCode><ResultCode>0</ResultCode>"
                + "<ErrorMsg></ErrorMsg><TranFlow>156297</TranFlow>"
                + "<RegisterNo>O0000014</RegisterNo><AsRowid>2204</AsRowid>"
                + "<JZTime>2014-12-09 22:47:53</JZTime><JZNo>1</JZNo>"
                + "<Type>专家</Type><PatName>田胖子1</PatName><MZH>1406160020</MZH><FeesType>普通</FeesType>"
                + "<FeesItem>挂号费,诊查费</FeesItem><DeptName>门诊儿科</DeptName>"
                + "<Loc>门诊二楼</Loc><DoctorName>刘楚明</DoctorName><SessionType>*主任医师</SessionType>"
                + "<RegTime>2014-12-09 22:48:07</RegTime></Response>";
        System.out.println(aaa.length());
        
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println(addr.getHostName());
        System.out.println(addr.getHostAddress());
        getAllLocalHostIP();
        /* BigDecimal payAmtTotal = null;
         payAmtTotal = NumberUtils.createBigDecimal("123.523");
         aaa(payAmtTotal);
         //payAmtTotal = payAmtTotal.add(new BigDecimal("123.22333"));
         System.out.println(payAmtTotal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());*/
        new Server();
        
    }
    
    private static String[] getAllLocalHostIP()
    {
        List<String> res = new ArrayList<String>();
        Enumeration netInterfaces;
        try
        {
            netInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            while (netInterfaces.hasMoreElements())
            {
                NetworkInterface ni = (NetworkInterface)netInterfaces.nextElement();
                Enumeration nii = ni.getInetAddresses();
                while (nii.hasMoreElements())
                {
                    ip = (InetAddress)nii.nextElement();
                    if (ip.getHostAddress().indexOf(":") == -1)
                    {
                        res.add(ip.getHostAddress());
                        System.out.println("本机的ip=" + ip.getHostAddress());
                    }
                }
            }
        }
        catch (SocketException e)
        {
            e.printStackTrace();
        }
        return (String[])res.toArray(new String[0]);
    }
    
    static void aaa(BigDecimal payAmtTotal)
    {
        payAmtTotal = NumberUtils.createBigDecimal("123.623");
        System.out.println(payAmtTotal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
    }
}
