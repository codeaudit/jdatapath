package com.codeberry.datapath.unknown;

import com.codeberry.datapath.DataPath;
import com.codeberry.datapath.DataPathSystem;
import com.codeberry.datapath.LocalDataPathSystem;

public class UnknownSystem implements LocalDataPathSystem {
  public DataPath getLocalDataPath(String wantedDataDirName) {
    String userHome = System.getProperty("user.home");
    return new DataPath(userHome + DataPathSystem.getFileSeparator() + "." + wantedDataDirName, false);
  }

  public DataPath getUserProfilePath() {
    return new DataPath(System.getProperty("user.home"), false);
  }
}
