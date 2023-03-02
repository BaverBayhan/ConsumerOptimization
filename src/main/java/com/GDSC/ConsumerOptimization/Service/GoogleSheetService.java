package com.GDSC.ConsumerOptimization.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;

public interface GoogleSheetService {
    void getResponses() throws IOException, GeneralSecurityException;
}
