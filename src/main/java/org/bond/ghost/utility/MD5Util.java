package org.bond.ghost.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * String工具类
 * 
 * @author 宋立君
 * @date 2014年06月24日
 */
public class MD5Util {

	// 全局数组
	private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	public MD5Util() {

	}

	private static String byteToString(byte bByte) {
		int iRet = bByte;
		if (iRet < 0) {
			iRet += 256;
		}
		int iD1 = iRet / 16;
		int iD2 = iRet % 16;
		return strDigits[iD1] + strDigits[iD2];
	}

	private static String byteArrayToString(byte[] bByte) {
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < bByte.length; i++) {
			sBuffer.append(byteToString(bByte[i]));
		}
		return sBuffer.toString();
	}

	public static String getMD5String(String input) throws Exception {
		return getMD5String(input.getBytes());
	}

	public static String getMD5String(byte[] input) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		// md.digest() 该函数返回值为存放哈希值结果的byte数组
		return byteArrayToString(md.digest(input));
	}

	public static String getFileMD5String(File file) throws Exception {
		FileInputStream in = new FileInputStream(file);
		FileChannel ch = in.getChannel();
		MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0,file.length());

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(byteBuffer);
		
		return byteArrayToString(md.digest());
	}

	public static String getFileMD5String(String filePathName) throws Exception {
		File file = new File(filePathName);

		return getFileMD5String(file);
	}

}
