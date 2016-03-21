import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterIntegration {
	public static void main(String[] args) throws Exception {
		// Create configuration builder and set key, token etc
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setOAuthConsumerKey("ATflJJwtDEL56UBkwUv2JGGQd");
		cb.setOAuthConsumerSecret("85UM6fASxvWQ6CUQ1G9WAjDlpcRFi0Dqn3u7Bua6YNdvHOrOXB");
		cb.setOAuthAccessToken("80365108-CjxofehDk1BF9JpNC4kP2oFRR0f85VHURubKs4iDu");
		cb.setOAuthAccessTokenSecret("AvcUXwiod9hMzzvORO5RhBfnihxJdEJDmNQie7t50FCQm"); // Create Twitter instance
		Twitter twitter = new TwitterFactory(cb.build()).getInstance();
		// // Create file writer and buffer writer
		FileWriter fstream = new FileWriter("Twitterstream.txt", true);
		BufferedWriter out = new BufferedWriter(fstream);
		// Create Query object and set search string
		Query query = new Query("");
		query.setQuery("USAirways");
		// Get query result
		QueryResult qr = twitter.search(query);
		// Get tweets and write in the file
		int counter =0; 
		while (qr.hasNext()) {
			qr.nextQuery();
			List<Status> tweets = qr.getTweets();
			for (Status t : tweets) {
				System.out.println(t.getId() + " - " + t.getCreatedAt() + ": " + t.getText());
				out.write("\n" + t.getId() + ",");
				out.write("\t" + t.getText() + ",");
				out.write("\t" + t.getUser() + ",");
			}
			if(counter==10)
				break;
			else
				counter++;
		}
		try {
			Thread.sleep(1000 * 60 * 15);
		} catch (Exception e) {
		}

	}
}
