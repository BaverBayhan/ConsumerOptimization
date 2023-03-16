package com.GDSC.ConsumerOptimization.Utils;

public enum URLPaths {
    GETLASTDATAOFPARTYINVITE("partyInviteLast"),
    GETALLDATAOFPARTYINVITE("partyInvite"),
    GENERIC("Generic");
    private final String path;

    URLPaths(String path)
    {
        this.path=path;
    }
    public String getPath() {
        return path;
    }
}
