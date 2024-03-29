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

package com.codeberry.jdatapath.unknown;

import com.codeberry.jdatapath.DataPath;
import com.codeberry.jdatapath.JDataPathSystem;
import com.codeberry.jdatapath.LocalDataPathSystem;

public class UnknownSystem implements LocalDataPathSystem {
  public DataPath getLocalDataPath(String wantedDataDirName) {
    String userHome = System.getProperty("user.home");
    return new DataPath(userHome + JDataPathSystem.getFileSeparator() + "." + wantedDataDirName, false);
  }

  public DataPath getUserProfilePath() {
    return new DataPath(System.getProperty("user.home"), false);
  }
}
