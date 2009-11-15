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

package com.codeberry.jdatapath.agent;

import com.codeberry.jdatapath.DataPath;
import com.codeberry.jdatapath.JDataPathSystem;

import java.lang.instrument.Instrumentation;

public class Main {
  public static void premain(String agentArguments, Instrumentation instrumentation) {
    DataPath path = JDataPathSystem.getLocalSystem().getUserProfilePath();

    String userHome = System.getProperty("user.home");
    try {
      if (userHome.equals(path.getPath())) {
        System.err.println("*** JDataPath: Not Assigned 'user.home' (as expected): " + path.getPath());
      } else {
        System.setProperty("user.home", path.getPath());
        System.err.println("*** JDataPath: OK Assigned 'user.home': " + path.getPath());
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.err.println("*** JDataPath: Failed Assigned 'user.home': " + path.getPath());
    }
  }
}
