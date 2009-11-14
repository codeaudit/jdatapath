package com.codeberry.datapath;

import com.codeberry.datapath.unknown.UnknownSystem;
import com.codeberry.datapath.windows.WindowsSystem;

public class DataPathSystem {
  private static final LocalDataPathSystem SYSTEM;
  private static final String FILE_SEPARATOR = System.getProperty("file.separator");

  static {
    String osName = System.getProperty("os.name");

    if (osName == null) {
      osName = "";
    }

    osName = osName.toLowerCase();

    if (isWindows(osName)) {
      SYSTEM = new WindowsSystem();
    } else if (isUnix(osName) || isMac(osName)) {
      // TODO: Implement :)
      SYSTEM = new UnknownSystem();
    } else {
      SYSTEM = new UnknownSystem();
    }
  }

  public static LocalDataPathSystem getLocalSystem() {
    return SYSTEM;
  }

  public static String getFileSeparator() {
    return FILE_SEPARATOR;
  }

  private static boolean isWindows(String osName) {
    return osName.indexOf("win") >= 0;
  }

  private static boolean isUnix(String osName) {
    return osName.indexOf("nux") >= 0 || osName.indexOf("nix") >= 0;
  }

  private static boolean isMac(String osName) {
    return osName.indexOf("mac") >= 0;
  }

  public static void main(String[] args) {
    String wantedDirName = "<please input wanted dir>";

    if (args.length > 0) {
      wantedDirName = args[0];
    }

    DataPath localDataPath = getLocalSystem().getLocalDataPath(wantedDirName);
    System.out.println("Local data path: " + localDataPath);

    DataPath profilePath = getLocalSystem().getUserProfilePath();
    System.out.println("Profile path: " + profilePath);
  }
}
