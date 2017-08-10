package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.Target;
import org.snmp4j.security.SecurityModels;
import org.snmp4j.security.USM;
import org.snmp4j.transport.DefaultUdpTransportMapping;

public class Test {
	public static void main(String[] args) throws IOException {
		File f = new File("C:/Users/lFW2917/Desktop/1111.txt");
		byte[] by = new byte[2048];
		try {
			InputStream in = new FileInputStream(f);
			while (in.available() > 0) {
				int i = in.read(by, 0, 2048);
				String code = "utf-8";
				String str = new String(by, 0, i, "utf-8");
				byte[] ss = str.getBytes("utf-8");
				if (!Test.compare(by, ss)) {
					code = "GBK";
				} else {
					code = "utf-8";
				}
				str = new String(by, 0, i, "GBK");
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static boolean compare(byte[] tem1, byte[] tem2) {
		for (int i = 0; i < tem2.length; i++) {
			if (tem1[i] == tem2[i]) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
}
