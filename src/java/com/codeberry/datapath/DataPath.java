package com.codeberry.datapath;

public class DataPath {
  private final String path;
  private final boolean supportedByOs;

  public DataPath(String path, boolean supportedByOs) {
    this.path = path;
    this.supportedByOs = supportedByOs;
  }

  public String getPath() {
    return path;
  }

  public boolean isSupportedByOs() {
    return supportedByOs;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof DataPath)) {
      return false;
    }

    DataPath dataPath = (DataPath) o;

    if (supportedByOs != dataPath.supportedByOs) {
      return false;
    }
    if (path != null ? !path.equals(dataPath.path) : dataPath.path != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = path != null ? path.hashCode() : 0;
    result = 31 * result + (supportedByOs ? 1 : 0);
    return result;
  }

  @Override
  public String toString() {
    return "DataPath{" +
           "path='" + path + '\'' +
           ", supportedByOs=" + supportedByOs +
           '}';
  }
}
