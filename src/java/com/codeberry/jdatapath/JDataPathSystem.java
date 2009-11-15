/*
 * Copyright 2009 Melv Ng
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.codeberry.jdatapath;

import com.codeberry.jdatapath.unknown.UnknownSystem;
import com.codeberry.jdatapath.windows.WindowsSystem;

public class JDataPathSystem {
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
