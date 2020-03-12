
package Cedd;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.InflaterInputStream;

public class TestCD {
   public static void main(String[] args) throws DataFormatException, IOException {
      String message = "Hello Hello Hello Hello Hello Hello!";
      System.out.println("Original Message length : " + message.length());
      byte[] input = message.getBytes("UTF-8");
      int length = message.length();
      // Compress the bytes
      byte[] output = new byte[1024];
      Deflater deflater = new Deflater();
      deflater.setInput(input);
   
      deflater.finish();
      int compressedDataLength = deflater.deflate(output,0 , output.length, Deflater.NO_FLUSH);
     
      System.out.println("Total uncompressed bytes input :" + deflater.getTotalIn());
      System.out.println("Compressed Message Checksum :" + deflater.getAdler());     
      deflater.finished();

      System.out.println("Compressed Message length : " + compressedDataLength);
      System.out.println("Total compressed message :" + output.toString());
      ByteArrayInputStream bin = new ByteArrayInputStream(output);
      InflaterInputStream inflaterInputStream = new InflaterInputStream(bin);
      byte[] result = new byte[1024];

      ByteArrayOutputStream buffer = new ByteArrayOutputStream();
      if(inflaterInputStream.markSupported()){
         inflaterInputStream.mark(0);  
      }
      if(inflaterInputStream.markSupported()){
         inflaterInputStream.reset();  
      }
      while(inflaterInputStream.available() != 0){
         buffer.write(inflaterInputStream.read());
      }

      inflaterInputStream.close();
      // Decode the bytes into a String
      String message1 = new String(buffer.toByteArray(),0, length,"UTF-8");
      System.out.println(message.equals(message1));
      System.out.println("Total uncompressed message :" + message1.toString());
   }
}