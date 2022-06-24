package com.company.Test;

import com.company.IpAddres;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class IpAddressTest {

    private final IpAddres ipAddreses = new IpAddres();

    @Test
    public void sizeIsThree() {
        List<String> ips = Arrays.asList(
                "191.168.56.121",
                "191.221.53.122",
                "191.172.51.123",
                "191.156.43.131"
        );

        for (var ip : ips)
            ipAddreses.insert(ip);

        assertEquals(3, ipAddreses.size());

    }

}
