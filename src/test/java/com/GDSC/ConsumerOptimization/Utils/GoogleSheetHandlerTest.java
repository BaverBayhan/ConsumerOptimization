package com.GDSC.ConsumerOptimization.Utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GoogleSheetHandlerTest {
    @Test
    void testSheet() throws GeneralSecurityException, IOException {
        GoogleSheetHandler.getSheet(SheetID.PARTYINVITE.getSheetId());
    }
}