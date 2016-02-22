package com.clm.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clm.algorithm.clustering.Cluster;
import com.clm.algorithm.clustering.ClusteringAlgo;
import com.clm.algorithm.clustering.DefClusteringAlgo;
import com.clm.algorithm.clustering.WeightedLinkageStrategy;
import com.clm.entities.Topic;
import com.clm.entities.User;
import com.clm.services.TopicService;
import com.clm.services.UserService;
@Controller
public class ClusterController {
	@Autowired
	TopicService topicService;
	@RequestMapping("/clusters")
	public String getClusters(Model model) {
		List<Topic> topics = topicService.findAll();
		/*Collection<String> topic = new ArrayList<String>();
		topic.add("test");
		topic.add("qtest");
		topic.add("ctest");*/
		double[][] distances = new double[][] { 
		    { 0, 1, 2, 3, 4, 5, 6, 8, 9, 7, 10, 11, 12, 13, 14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29 },
		    { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29, 0 }, 
		    { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29, 0, 1 },
		    { 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29, 0, 1, 2 },
		    { 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29, 0, 1, 2, 3 },
		    { 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29, 0, 1, 2, 3,4 },
		    { 6, 7, 8, 9, 10, 11, 12, 13, 14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29, 0, 1, 2, 3,4, 5 },
		    { 7, 8, 9, 10, 1, 12, 13, 14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29, 0, 1, 2, 3,4, 5, 6 },
		    { 8, 9, 10, 11, 12, 13, 14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29, 0, 1, 2, 3,4, 5, 6, 8 },
		    { 9, 10, 11, 12, 13, 14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29, 0, 1, 2, 3,4, 5, 6, 8, 9 },
		    { 10, 11, 12, 13, 14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29, 0, 1, 2, 3,4, 5, 6, 8, 9, 7 },
		    { 11, 12, 13, 14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29, 0, 1, 2, 3,4, 5, 6, 8, 9, 7,10 },
		    { 12, 13, 14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29, 0, 1, 2, 3,4, 5, 6, 8, 9, 7,10, 11 }, 
		    { 13, 14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29, 0, 1, 2, 3,4, 5, 6, 8, 9, 7,10, 11,12 },
		    { 14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29, 0, 1, 2, 3, 4, 5, 6, 8, 9, 7,10, 11,12,13 },
		    { 15,16,17,18,19,20,21,22,23,24,25,26,27,28,29, 0, 1, 2, 3, 4, 5, 6, 8, 9, 7,10, 11,12,13,14 },
		    { 16,17,18,19,20,21,22,23,24,25,26,27,28,29, 0, 1, 2, 3, 4, 5, 6, 8, 9, 7,10, 11,12,13,14,15 },
		    { 17,18,19,20,21,22,23,24,25,26,27,28,29, 0, 1, 2, 3, 4, 5, 6, 8, 9, 7,10, 11,12,13,14,15,16 },
		    { 18,19,20,21,22,23,24,25,26,27,28,29, 0, 1, 2, 3, 4, 5, 6, 8, 9, 7,10, 11,12,13,14,15,16,17 },
		    { 19,20,21,22,23,24,25,26,27,28,29, 0, 1, 2, 3, 4, 5, 6, 8, 9, 7,10, 11,12,13,14,15,16,17,18 },
		    { 20,21,22,23,24,25,26,27,28,29, 0, 1, 2, 3, 4, 5, 6, 8, 9, 7,10, 11,12,13,14,15,16,17,18,19 },
		    { 21,22,23,24,25,26,27,28,29, 0, 1, 2, 3, 4, 5, 6, 8, 9, 7,10, 11,12,13,14,15,16,17,18,19,20 },
		    { 22,22,23,24,25,26,27,28,29, 0, 1, 2, 3, 4, 5, 6, 8, 9, 7,10, 11,12,13,14,15,16,17,18,19,20 },
		    { 23,24,25,26,27,28,29, 0, 1, 2, 3, 4, 5, 6, 8, 9, 7,10, 11,12,13,14,15,16,17,18,19,20,21,22 },
		    { 24,25,26,27,28,29, 0, 1, 2, 3, 4, 5, 6, 8, 9, 7,10, 11,12,13,14,15,16,17,18,19,20,21,22,23 },
		    { 25,26,27,28,29, 0, 1, 2, 3, 4, 5, 6, 8, 9, 7,10, 11,12,13,14,15,16,17,18,19,20,21,22,23,24 },
		    { 26,27,28,29, 0, 1, 2, 3, 4, 5, 6, 8, 9, 7,10, 11,12,13,14,15,16,17,18,19,20,21,22,23,24,25 },
		    { 27,28,29, 0, 1, 2, 3, 4, 5, 6, 8, 9, 7,10, 11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26 },
		    { 28,29, 0, 1, 2, 3, 4, 5, 6, 8, 9, 7,10, 11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27 },
		    { 29, 0, 1, 2, 3, 4, 5, 6, 8, 9, 7,10, 11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28 }};

		ClusteringAlgo alg = new DefClusteringAlgo();
		String[] strTopics=new String[topics.size()];
		
		int i=0;
		for(Topic topic:topics){
			strTopics[i++] = topic.getName();
		}
		System.out.println(i);
		System.out.println(topics);
		Cluster cluster = alg.doClustering(distances, strTopics,
		    new WeightedLinkageStrategy());
		System.out.println(cluster.toString());
		String clusters="";
		/*while(cluster.getParent()!=null){
			clusters+=cluster.getName()+",";
			cluster = cluster.getParent();
		}*/
		/*while(cluster.getChildren().size()!=0){
			clusters+=cluster.getChildren()+",";
			cluster = cluster.getChildren().get(0);
		}*/
		strTopics=new String[topics.size()];
		printChildren(cluster,strTopics, 0);
		
		 String childrens = "";
         for (i = 0; i < strTopics.length; i++) {
         	childrens = childrens+ (strTopics[i] + ", ");
         }
         model.addAttribute("clusters", childrens);
         model.addAttribute("user", getPrincipal());
		return "clusters";
	}	
	void printChildren(Cluster node, String path[], int pathLen) {
        if (node == null) {
            return ;
        }
 
        /* append this node to the path array */
        path[pathLen] = node.toString()+" "+node.getName();
        pathLen++;
 
        /* it's a leaf, so print the path that led to here  */
        if (node.getChildren() == null || node.getChildren().size() == 0) {
            //printArray(path, pathLen);
            /*int i;
            String childrens = "";
            for (i = 0; i < pathLen; i++) {
            	childrens = childrens+ (path[i] + " ");
            }*/
            return ;
        } else {
             
            /* otherwise try both subtrees */
        	for(Cluster c:node.getChildren()){
        		printChildren(c, path, pathLen);
        	}
            //printPathsRecur(node.right, path, pathLen);
        }
        return ;
    }
	@Autowired
	UserService userService;
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		User user = userService.findUserByEmail(userName);
		String name = user.getFirstName()+" "+user.getLastName();
		return name;
	}	
}
