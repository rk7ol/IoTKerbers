package util;

import java.nio.charset.StandardCharsets;

public class Util {

    public static byte[] oneWayHash64(byte[] value){
        return null;
    }

    public static byte[] oneWayHash64(String value){

        return oneWayHash64(value.getBytes(StandardCharsets.UTF_8));
    }

    public static byte[] random64Bits(){
        return null;
    }

}
