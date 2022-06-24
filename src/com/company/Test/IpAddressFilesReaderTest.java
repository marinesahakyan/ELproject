package com.company.Test;

import com.company.IpAddres;
import com.company.IpAddressFilesReader;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class IpAddressFilesReaderTest {

    private IpAddressFilesReader reader = new IpAddressFilesReader();
    private IpAddres ipAddres = new IpAddres();
    private String file = "C:/Users/LENOVO/Downloads/test.txt";

    @Test
    void isFileExisted(){
        var result = reader.read(file,ipAddres);
        assertEquals(73602,result);
    }
}
