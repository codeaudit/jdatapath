package com.codeberry.datapath.windows;

import com.codeberry.datapath.DataPath;
import com.codeberry.datapath.DataPathSystem;
import com.codeberry.datapath.windows.CCIDL;
import com.codeberry.datapath.LocalDataPathSystem;

import java.util.concurrent.atomic.AtomicBoolean;

public class WindowsSystem implements LocalDataPathSystem {
  private static final Object INIT_LOCK = new Object();
  private static boolean initialized;

  private static native String SHGetPathFromIDList(int csidl);

  public static String getPath(CCIDL csidl) {
    return SHGetPathFromIDList(csidl.getValue());
  }

  public WindowsSystem() {
    synchronized (INIT_LOCK) {
      if (!initialized) {
        System.loadLibrary("datapath");
        initialized = true;
      }
    }
  }

  public DataPath getLocalDataPath(String wantedDataDirName) {
    String mainPath = getPath(CCIDL.CSIDL_LOCAL_APPDATA);
    return new DataPath(mainPath + DataPathSystem.getFileSeparator() + wantedDataDirName, true);
  }

  public DataPath getUserProfilePath() {
    return new DataPath(getPath(CCIDL.CSIDL_PROFILE), true);
  }
}