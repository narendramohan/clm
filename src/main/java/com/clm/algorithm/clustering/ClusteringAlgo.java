package com.clm.algorithm.clustering;

public interface ClusteringAlgo {

  public Cluster doClustering(double[][] distances, String[] clusterNames,
      LinkageStrategy linkageStrategy);

  public Cluster doWeightedClustering(double[][] distances, String[] clusterNames,
      double[] weights, LinkageStrategy linkageStrategy);

}
