package com.GDSC.ConsumerOptimization.Utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class HttpFormContentClientTest {

    @Test
    void getSheetData() throws IOException, InterruptedException {
        String response = HttpFormContentUtils.getUserDataFromSheetApi(URLPaths.WASHINGMACHINE.getPath(),"baver1234");
        HttpFormContentUtils.stringResponseToList(response);
        System.err.println(response);
    }
    @Test
    void get_from_sheet_api() {
    }
}