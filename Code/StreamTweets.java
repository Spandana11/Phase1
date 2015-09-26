
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

public class StreamTweets {
	public static void main(String[] args) {

		// OAuth requests for connecting to twitter Streaming API
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.setDebugEnabled(true);
		builder.setOAuthConsumerKey("wFyN6RE0CtTy1lfhEuPy58ucE");
		builder.setOAuthConsumerSecret("eJlhGso0exD3pfOWEDlnX85ZEfuVySh6sjjbBrwi0arIfFghRW");
		builder.setOAuthAccessToken("3751958901-7jOfXjsJYC90tkQQ7NpjsZW9QrjLg13Slyoh9la");
		builder.setOAuthAccessTokenSecret("tWbrek25FWJjWFrmWJLDMBR9m5QZT4ISEROTIuOblwsIf");

		TwitterStream stream = new TwitterStreamFactory(builder.build()).getInstance();

		StatusListener listener = new StatusListener() {

			@Override
			public void onException(Exception arg0) {
			}

			@Override
			public void onDeletionNotice(StatusDeletionNotice arg0) {
			}

			@Override
			public void onScrubGeo(long arg0, long arg1) {
			}

			// to get JSON results from twitter API
			@Override
			public void onStatus(Status status) {

					User user = status.getUser();

					// to get tweet details
					String userName = user.getScreenName();
					System.out.println(userName);
					String location = user.getLocation();
					System.out.println(location);
					String language = status.getIsoLanguageCode();
					System.out.println(language);
					String content = status.getText();
					System.out.println(content + "\n");
					System.out.println();

				}

			@Override
			public void onTrackLimitationNotice(int arg0) {
			}

			@Override
			public void onStallWarning(StallWarning arg0) {
			}
		};
		FilterQuery query = new FilterQuery();

		String keywords[] = { "the" };

		query.track(keywords);

		stream.addListener(listener);
		stream.filter(query);

	}
}