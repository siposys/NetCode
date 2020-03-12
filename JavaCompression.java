//package com.example.android.toyvpn;
package Cedd;

import java.io.*;
import java.util.zip.*;
//import Base64;
public class Compress {
    static boolean logflag = true;     //When testing true


    private static void logwrite(String logMsg) {
        if (logflag) {
            try {
                System.out.println(logMsg);
                //WriteLogManager.infoLog(Define.DEBUG_LOG,"[GZip]:"+logMsg);
            } catch (Exception e) {
            }
        }
    }

    public static byte[] compress(byte[] data) throws Exception {
        logwrite("compress(byte[]) called");

        try {
            logwrite("Compress Original DataSize:" + data.length);
            ByteArrayOutputStream baos = null;
            GZIPOutputStream gos = null;

            if (data == null) {
                data = "".getBytes();
            }
            baos = new ByteArrayOutputStream();
            gos = new GZIPOutputStream(baos);
            gos.write(data, 0, data.length);

            gos.finish();
            gos.close();
            baos.close();

            logwrite("After Compress DataSize:" + (baos.toByteArray()).length);
            logwrite("After Compress DataSize:" + (baos.toByteArray()).toString());
            return baos.toByteArray();
        } catch (IOException ioe) {
            throw new Exception("GZip Compress IO Exception:" + ioe.toString());
        }
    }


    public static byte[] decompress(byte[] data, int length) throws Exception {
        logwrite("decompress(byte[],int) called");
        logwrite("Before decompress ByteSize:" + data.length);
        logwrite("Input Param Data:" + length + "");
        try {
            ByteArrayInputStream bais = null;
            GZIPInputStream gis = null;
            DataInputStream dis = null;
            byte[] outputByteArray = null;

            if (data == null) {
                data = "".getBytes();
            }

            bais = new ByteArrayInputStream(data);
            gis = new GZIPInputStream(bais);
            dis = new DataInputStream(gis);
            outputByteArray = new byte[length];
            dis.readFully(outputByteArray);

            dis.close();
            gis.close();
            bais.close();

            logwrite("decompress Data Size:" + outputByteArray.length);

            return outputByteArray;
        } catch (IOException ioe) {
            ioe.printStackTrace();
            throw new Exception("Gzip decompress Exception:" + ioe.toString());
        }
    }
    
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
    
    public static void main(String[] args) throws Exception{
        
    	   
        byte[] bytes = hexStringToByteArray("a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,ft,e04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,ft,e04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,fte04fd020ea3a6910a2d808002b30309d,drtyertgergdfgv,ertewr,tfgwe,rtfew,rtfew,ft");
        System.out.println("Orginal Data:" + bytes + "\n");
        //byte[] CompressedByteString= compress(bytes);
        //System.out.print("Compressed Data: "+CompressedByteString.toString() + "\n");
        //int Length=CompressedByteString.length;
        //byte[] DecompressedData = decompress(compress(bytes), Length);
        //System.out.print("After Compression Length: "+Length + "\n");
        int Length=bytes.length;
        System.out.println("Original Length: "+Length);
        byte[] encodedByte = Base64.base64Encode(bytes, 0, Length);
        System.out.println("Encoded Data: "+encodedByte.toString());
        System.out.print("Encoded Length: "+encodedByte.length + "\n");
        //String dec = CompressedByteString.toString();
        byte[] decodedByte = Base64.base64Decode(encodedByte, 0, encodedByte.length);
        System.out.println("Decoded Data: "+decodedByte.toString());
        System.out.print("Decoded Length: "+decodedByte.length + "\n");
        //TODO
        
    }
}
