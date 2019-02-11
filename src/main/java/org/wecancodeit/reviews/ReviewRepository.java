package org.wecancodeit.reviews;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class ReviewRepository {

	private Map<Long, Review> reviewList = new HashMap<>();
	
	
	
	public ReviewRepository() {
		Review blackDesertOnline = new Review(1L, "Black Desert Online", "Sandbox MMO", 
				"Black Desert Online is one of the most visually appealing MMOs that I have played to date. "
				+ "The concept of the game is centered around RNG-weighted gear-progression, and most players have an end goal of high-tier PVP. "
				+ "Speaking of PVP, Black Desert Online has THE BEST combat system, with visceral fighting instead of a tab-targeting system. "
				+ "The biggest downfall of the game is the lack of end-game PVE content, but the PVP is satisfying enough to make up for it. " 
				,"BlackDesertOnline");
		
		Review worldOfWarcraft= new Review(2L, "World of Warcraft", "MMO", "World of Warcraft is the video game that comes to mind when anyone says MMO. "
				+ "It has withstood the test of time and is still the most popular MMO around, with competitive dungeons, PVP, and raiding."
				+ " The graphics and character customization leave a little to be desired for a modern-day MMO, but the end-game content is plentiful for both "
				+ "the hardcore and casual alike. In its present iteration, class design is pretty lacking with a lot of downtime in DPS and tanking rotations, "
				+ "but it's still a great game.", "Sarazzlin");
		
		Review banjoKazooie = new Review (3L, "Banjo-Kazooie", "Platformer", "Banjo-Kazooie is just one of those games that come around every so often and blow your mind"
				+ " The story was excellent, the puzzles were challenging enough but rewarding, and the soundtrack remains to date my favorite of all time. "
				+ "Banjo-Kazooie was my gateway into the world of hardcore video gaming and I've never looked back.", "BanjoKazooie");
		
		Review halo2 = new Review (4L, "Halo 2", "First-Person Shooter", "Generally speaking, video game sequels can be pretty disappointing. "
				+ "Halo 2 is one of the few instances where the sequel outshone the original in just about all regards. "
				+ "The mutliplayer aspect was excellent, allowing for couch co-op through the campaign, which is something I appreciate because"
				+ "it allowed me to spend time with my brother without beating each other up or bribing the other sibling for game time."
				+ " Some of my best memories were playing zombies on a LAN at my friends house with mutliple TVs and room setups. "
				, "halo2");
		
		Review stardewValley = new Review(5L, "Stardew Valley", "Farming Simulation RPG","Stardew Valley took my love of Harvest Moon and RPGs"
				+ " and made a beautiful harmony of both. It is a wonderfully relaxing game with a great soundtrack and game atmosphere. I am ashamed to admit"
				+ " the amount of hours I spent on my artisinal mayonnaise operation, but I have no regrets.", "SDV");
		
		reviewList.put(blackDesertOnline.getId(), blackDesertOnline);
		reviewList.put(worldOfWarcraft.getId(), worldOfWarcraft);
		reviewList.put(banjoKazooie.getId(), banjoKazooie);
		reviewList.put(halo2.getId(),halo2);
		reviewList.put(stardewValley.getId(), stardewValley);
			
	}

	
	//constructor for testing purposes, using spread operator
	public ReviewRepository(Review... reviews) {
		for (Review review : reviews) {
			reviewList.put(review.getId(), review);

		}
	}

	public Review findOne(long id) {
		return reviewList.get(id);
	}

	public Collection<Review> findAll() {
		return reviewList.values();
	}

}
