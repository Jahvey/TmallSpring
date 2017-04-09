package xyz.ivyxjc;

import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;
import org.junit.Test;

/**
 * Created by jc on 4/5/2017.
 */


public class Encrypt {

    @Test
    public void testEncrypt(){
        String base="123";
        DefaultHashService hashService = new DefaultHashService();
        HashRequest request = new HashRequest.Builder()
                .setAlgorithmName("sha-512").setSource(ByteSource.Util.bytes("123"))
                .setSalt(ByteSource.Util.bytes("ivyxjc")).setIterations(2).build();
        String hex = hashService.computeHash(request).toHex();
        System.out.println(hex);
    }
}
