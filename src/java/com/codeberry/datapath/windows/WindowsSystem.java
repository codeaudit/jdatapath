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

package com.codeberry.datapath.windows;

import com.codeberry.datapath.DataPath;
import com.codeberry.datapath.DataPathSystem;
import com.codeberry.datapath.LocalDataPathSystem;

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