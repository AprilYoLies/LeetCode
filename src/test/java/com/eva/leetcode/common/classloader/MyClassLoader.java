package com.eva.leetcode.common.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MyClassLoader extends ClassLoader {
    //加密字节码的目录
    private String clsPath;

    MyClassLoader(String clsPath) {
        this.clsPath = clsPath;
    }

    //此处对ClassLoaderAttachment.java进行异或加密
    // target/test-classes/com/eva/leetcode/common/classloader/ClassLoaderAttachment.class target
    public static void main(String[] args) throws IOException {
        String srcPath = args[0];
        String destDir = args[1];
        String destPath = destDir + File.separator + srcPath.substring(srcPath.lastIndexOf(File.separator) + 1);
        InputStream is = new FileInputStream(new File(srcPath));
        OutputStream os = new FileOutputStream(new File(destPath));
        encry(is, os);
    }


    //异或加密
    private static void encry(InputStream is, OutputStream os) throws IOException {
        int n;
        while ((n = is.read()) != -1) {
            os.write(n ^ 0xff);
        }
    }

    //自定义类加载器
    @SuppressWarnings("deprecation")
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] b;
        String srcPath = this.clsPath + File.separator + name.substring(name.lastIndexOf(".") + 1) + ".class";
        System.out.println(srcPath);
        File file = new File(srcPath);
        try {
            InputStream is = new FileInputStream(file);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            encry(is, os);
            b = os.toByteArray();
            return defineClass(b, 0, b.length);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
