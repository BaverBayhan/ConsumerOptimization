package com.GDSC.ConsumerOptimization.Utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class HttpFormContentClientTest {

    @Test
    void getSheetData() throws IOException, InterruptedException {
        String response = HttpFormContentUtils.getFromSheetApi(URLPaths.GENERIC.getPath(),"baver1234");
        System.err.println(HttpFormContentUtils.stringResponseToList(response).get(1));
    }

    @Test
    void get_from_sheet_api() {
    }
}