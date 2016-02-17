package com.clm.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clm.algorithm.clustering.Cluster;
import com.clm.algorithm.clustering.ClusteringAlgo;
import com.clm.algorithm.clustering.DefClusteringAlgo;
import com.clm.algorithm.clustering.WeightedLinkageStrategy;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.ResponseList;
import facebook4j.conf.Configuration;
import facebook4j.conf.ConfigurationBuilder;
import facebook4j.internal.org.json.JSONException;
import facebook4j.internal.org.json.JSONObject;
import opennlp.tools.util.ObjectStream;



@Controller
public class FacebookController {

	@RequestMapping("/facebook")
	public String helloFacebook1(Model model) {
		Properties props = null;
		try {

			props = PropertiesLoaderUtils.loadAllProperties("application.properties");
			PropertyPlaceholderConfigurer props2 = new PropertyPlaceholderConfigurer();
			props2.setProperties(props);
			String appId = props.getProperty("spring.social.facebook.appId");
			String appSec = props.getProperty("spring.social.facebook.appSecret");
			String appToken = props.getProperty("spring.social.facebook.appToken");
			System.out.println(appId);
			System.out.println(appSec);
			System.out.println(appToken);
			FacebookConnectionFactory fcf = new FacebookConnectionFactory(appId, appSec);
			// String token
			// =fcf.getOAuthOperations().authenticateClient().getAccessToken();
			String clientId = appId;
			String clientSecret = appSec;
			String redirectUri = "http://localhost";

			FacebookConnectionFactory cf = new FacebookConnectionFactory(clientId, clientSecret);
			OAuth2Operations oauth = cf.getOAuthOperations();
			OAuth2Parameters oauthParameters = new OAuth2Parameters();
			oauthParameters.setRedirectUri(redirectUri);
			oauthParameters.setScope("publish_stream,user_photos,offline_access");
			String authUrl = oauth.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, oauthParameters);
			System.out.println(authUrl);
			/*URL oracle = new URL(authUrl);
		    URLConnection yc = oracle.openConnection();
		    BufferedReader in = new BufferedReader(new InputStreamReader(
		                                    yc.getInputStream()));
		    String inputLine;
	        while ((inputLine = in.readLine()) != null) 
	            System.out.println(inputLine);
	        in.close();*/
	        
	        
			/*
			System.out.println("GO TO : " + authUrl);

			String code = JOptionPane.showInputDialog("Enter the authorization code:");

			AccessGrant accessGrant = oauth.exchangeForAccess(code, redirectUri, null);

			String accessToken = accessGrant.getAccessToken();
			FacebookTemplate fb1 = new FacebookTemplate(accessToken);*/

			/// FacebookProfile userProfile =
			/// fb.userOperations().getUserProfile();
			// System.out.println("Hello, " + userProfile.getName());

			////

			Connection<org.springframework.social.facebook.api.Facebook> con = fcf
					.createConnection(new AccessGrant("CAAGskXBsHwcBADZCVSRcIUu3qmImvKZAktQTaZBZB0pVxk0wymjdXgQ0S3M0QZAj4Jx17yILalFuXRENup5iuxJItXMT9jJnPY8nccCJ3ZC8I6AopGGmS4I8YZCmtUCIoW6ZAdT5chKACYgbAjFZCkFYqK78Rh4h97Rmbta9gl5JdFGDZCmqGtWBpq"));
			org.springframework.social.facebook.api.Facebook fb = con.getApi();
			System.out.println(fb.feedOperations().getFeed());
			PagedList<org.springframework.social.facebook.api.Post> posts = fb.feedOperations().getFeed();
			/*for(org.springframework.social.facebook.api.Post post:fb.feedOperations().getFeed()){
				System.out.println(post.getMessage());
			}*/
			model.addAttribute("posts", posts);
			/*
			 * Facebook facebook = new FacebookFactory().getInstance();
			 * facebook.setOAuthAppId(appId, appSec);
			 * facebook.setOAuthPermissions("user_posts");
			 * facebook.setOAuthAccessToken(new AccessToken(appToken, null));
			 * ResponseList<Post> results = facebook.searchPosts("watermelon");
			 */
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "facebook";
	}
	
	@RequestMapping("/facebook1")
	public static void main1(String[] args) throws FacebookException {
		// Make the configuration builder
		ConfigurationBuilder confBuilder = new ConfigurationBuilder();
		confBuilder.setDebugEnabled(true);
		// Set application id, secret key and access token
		confBuilder.setOAuthAppId("471215633080071");
		confBuilder.setOAuthAppSecret("8113067ec6049541cfffe9907323529b");
		confBuilder.setOAuthAccessToken("471215633080071|nwaXEBhJrFWGP3oFoq2mQwYgZO0");
		// Set permission
		confBuilder.setOAuthPermissions("email,publish_stream, id, name, first_name, last_name, generic");
		confBuilder.setUseSSL(true);
		confBuilder.setJSONStoreEnabled(true);
		// Create configuration object
		Configuration configuration = confBuilder.build();
		// Create facebook instance
		FacebookFactory ff = new FacebookFactory(configuration);
		Facebook facebook = ff.getInstance();
		try {
			// Get facebook posts
			String results = getFacebookPostes(facebook);
			String responce = stringToJson(results);
			// Create file and write to the file
			File file = new File("C:\\Facebook\\File\\test.txt");
			if (!file.exists()) {
				file.createNewFile();
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(results);
				bw.close();
				System.out.println("Writing complete");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getFacebookPostes(Facebook facebook) throws FacebookException {
		// Get posts for a particular search
		ResponseList<Post> results = facebook.getPosts("Reebok");
		return results.toString();
	}

	public static String stringToJson(String data) {
		// Create JSON object
		String jsonObject;
		try {
			jsonObject = JSONObject.valueToString(data);
			System.out.println("Message : " + jsonObject);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//JSONArray message = (JSONArray) jsonObject.get("message");
		
		return "Done";
	}

	public static BufferedReader readDataFile(String filename) {
		BufferedReader inputReader = null;
 
		try {
			inputReader = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException ex) {
			System.err.println("File not found: " + filename);
		}
 
		return inputReader;
	}
 
	public static void main(String[] args) throws Exception {
		/*SimpleKMeans kmeans = new SimpleKMeans();
 
		kmeans.setSeed(10);
 
		//important parameter to set: preserver order, number of cluster.
		kmeans.setPreserveInstancesOrder(true);
		kmeans.setNumClusters(5);
 
		BufferedReader datafile = readDataFile("C:/Users/ryan/workspace/data.arff"); 
		Instances data = new Instances(datafile);
 
 
		kmeans.buildClusterer(data);
 
		// This array returns the cluster number (starting with 0) for each instance
		// The array has as many elements as the number of instances
		int[] assignments = kmeans.getAssignments();
 
		int i=0;
		for(int clusterNum : assignments) {
		    System.out.printf("Instance %d -> Cluster %d \n", i, clusterNum);
		    i++;
		}*/
		ObjectStream  dfs = null;
		Collection<String> topic = new ArrayList<String>();
		topic.add("test");
		topic.add("qtest");
		topic.add("ctest");
		/*LinkageStrategy ls = new WeightedLinkageStrategy(topic);*/
		String[] names = new String[] { "O1", "O2", "O3", "O4", "O5", "O6" };
		double[][] distances = new double[][] { 
		    { 0, 1, 9, 7, 11, 14 },
		    { 1, 0, 4, 3, 8, 10 }, 
		    { 9, 4, 0, 9, 2, 8 },
		    { 7, 3, 9, 0, 6, 13 }, 
		    { 11, 8, 2, 6, 0, 10 },
		    { 14, 10, 8, 13, 10, 0 }};

		ClusteringAlgo alg = new DefClusteringAlgo();
		Cluster cluster = alg.doClustering(distances, new String[] {"test","qtest","ctest","1test","2qtest","3ctest"},
		    new WeightedLinkageStrategy());
		cluster.toConsole(15);
	}	
}
