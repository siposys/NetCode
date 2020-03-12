
import java.io.*;
import java.util.zip.*;
/**
 * Created by 상헌 on 2016-05-29.
 */
public class myzip {
    static boolean logflag = true;     //테스트시 true


    private static void logwrite(String logMsg) {
        if (logflag) {
            try {
                System.out.println(logMsg);
                //WriteLogManager.infoLog(Define.DEBUG_LOG,"[GZip]:"+logMsg);
            } catch (Exception e) {
            }
        }
    }

    /**
     * GZIP을 이용하여 압축한다
     * 압축할 데이터
     *
     * @return 압축된 바이트 배열
     */
    public static byte[] compress(byte[] data) throws Exception {
        logwrite("compress(byte[]) called");

        try {
            logwrite("Compress Original DataSize:" + data.length);
           //COMPRESSION
			byte[] input = data;
			//byte[] input = message.getBytes();
			int length = input.length;
			// Compress the bytes
			byte[] output = new byte[32767];
		  //if nowrap is set to true, then the Raw Deflation happens.
		  //Deflater deflater = new Deflater();
		 //Deflater deflater = new Deflater(9, true);
		  Deflater deflater = new Deflater(9);
		  deflater.setInput(input);
	   
		  deflater.finish();
		  //the deflate function uses Strategy.
		  int compressedDataLength = deflater.deflate(output, 0 , output.length, Deflater.NO_FLUSH);
		  
		  //System.out.println("Total uncompressed bytes input :" + deflater.getTotalIn());
		  //System.out.println("Compressed Message Checksum :" + deflater.getAdler());
		  deflater.end();
		  deflater.finished();

		  //System.out.println("Compressed Message length : " + compressedDataLength);
		  //System.out.println("Total compressed message :" + output.toString());
		  

				logwrite("After Compress DataSize:" + compressedDataLength);
				//return baos.toByteArray();
				return output;
			} catch (IOException ioe) {
            throw new Exception("GZip Compress IO Exception:" + ioe.toString());
        }
    }

    /**
     * GZIP을 이용하여 압축해제한다
     *//* @param 압축된 데이터byte[]
     * @return 압축해제된 바이트 배열
     */
    public static byte[] decompress(byte[] data, int length) throws Exception {
        logwrite("decompress(byte[],int) called");
        logwrite("Before decompress ByteSize:" + data.length);
        logwrite("Input Param Data:" + length + "");
        try {
             //DECOMPRESSION
      Inflater inflater = new Inflater();
     //Inflater inflater = new Inflater(true);
      //inflater.setInput(output, 0, compressedDataLength);
      inflater.setInput(data, 0, data.length);
      byte[] result = new byte[32767];
      int resultLength = inflater.inflate(result);
      inflater.end();
      inflater.finished();

            logwrite("decompress Data Size:" + resultLength);

            return result;
        } catch (IOException ioe) {
            ioe.printStackTrace();
            throw new Exception("Gzip decompress Exception:" + ioe.toString());
        }
    }
}