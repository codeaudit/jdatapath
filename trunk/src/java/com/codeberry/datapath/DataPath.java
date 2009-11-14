package com.codeberry.datapath;

public class DataPath {
  private final String path;
  private final boolean recommendedByOs;

  public DataPath(String path, boolean recommendedByOs) {
    this.path = path;
    this.recommendedByOs = recommendedByOs;
  }

  public String getPath() {
    return path;
  }

  public boolean isRecommendedByOs() {
    return recommendedByOs;
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

    if (recommendedByOs != dataPath.recommendedByOs) {
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
    result = 31 * result + (recommendedByOs ? 1 : 0);
    return result;
  }

  @Override
  public String toString() {
    return "DataPath{" +
           "path='" + path + '\'' +
           ", recommendedByOs=" + recommendedByOs +
           '}';
  }
}
