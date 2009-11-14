package com.codeberry.datapath;

public class DataPath {
  private final String path;
  private final boolean osSupported;

  public DataPath(String path, boolean osSupported) {
    this.path = path;
    this.osSupported = osSupported;
  }

  public String getPath() {
    return path;
  }

  public boolean isOsSupported() {
    return osSupported;
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

    if (osSupported != dataPath.osSupported) {
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
    result = 31 * result + (osSupported ? 1 : 0);
    return result;
  }

  @Override
  public String toString() {
    return "DataPath{" +
           "path='" + path + '\'' +
           ", osSupported=" + osSupported +
           '}';
  }
}
