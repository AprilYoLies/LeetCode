package com.eva.leetcode.common;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author EvaJohnson
 * @Date 2019-08-11
 * @Email g863821569@gmail.com
 */
public class NioTest {
    private static int len;

    @Test
    public void testMemoryMap() {
        try {
            //使用内存映射的方式读取文件
            RandomAccessFile file = new RandomAccessFile("/Users/eva/Downloads/netty.mp4", "rw");
            FileChannel channel = file.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            long startTime = System.currentTimeMillis();
            buffer.clear();
            // 读出所有数据
            while (channel.read(buffer) != -1) {
                buffer.flip();
                buffer.clear();
            }
            file.close();
            long endTime = System.currentTimeMillis();
            System.out.println("使用内存映射方式读取文件总耗时： " + (endTime - startTime));


            //普通IO流方式
            long startTime1 = System.currentTimeMillis();
            File file1 = new File("/Users/eva/Downloads/netty.mp4");
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(file1));
                while ((reader.readLine()) != null) {
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e1) {
                    }
                }
            }
            long endTime1 = System.currentTimeMillis();
            System.out.println("使用普通IO流方式读取文件总耗时： " + (endTime1 - startTime1));
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMemoryMapCopy() {
        String readFileName = "/Users/eva/Downloads/netty.mp4";
        String writeFileName = "/Users/eva/Downloads/netty1.mp4";
        writeFile(readFileName, writeFileName);
    }

    /**
     * 读文件
     *
     * @param fileName
     * @return
     */
    public static ByteBuffer readFile(String fileName) {
        try {
            RandomAccessFile file = new RandomAccessFile(fileName, "rw");
            len = (int) file.length();
            FileChannel channel = file.getChannel();
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, len);
            return buffer;
//            return buffer.get(new byte[(int) file.length()]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 写文件
     *
     * @param readFileName
     * @param writeFileName
     */
    public static void writeFile(String readFileName, String writeFileName) {
        try {
            RandomAccessFile file = new RandomAccessFile(writeFileName, "rw");
            FileChannel channel = file.getChannel();
            ByteBuffer buffer = readFile(readFileName);

            MappedByteBuffer bytebuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, len);
            long startTime = System.currentTimeMillis();
            bytebuffer.put(buffer);
//            for (int i = 0; i < len; i++) {
//                bytebuffer.put(i, buffer.get(i));
//            }
//            bytebuffer.flip();
            long endTime = System.currentTimeMillis();
            System.out.println("写文件耗时： " + (endTime - startTime));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
