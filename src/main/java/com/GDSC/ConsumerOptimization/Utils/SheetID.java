package com.GDSC.ConsumerOptimization.Utils;

public enum SheetID {
    PARTYINVITE("1SIoSJvTWzCHMVokfaCFWlV_j9ZCb4JdNx5v5qEQG43k"),
    DEFAULT("1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms");

    private final String sheetId;

    SheetID(String sheetId) {
        this.sheetId = sheetId;
    }

    public String getSheetId() {
        return sheetId;
    }
}
