package adviser;

public class Chat {

	// Training data
	public String[][] chat = { { "hi", "hello", "hey", "good", "how are you" }, { "How can I help you" },
			// 1
			{ "before" },
			{ "You should learn Chinese history, study the benefits of learing Chinese",
					"You should determine you wanna learn simplified or traditional Chinese, Mandarin or Cantonese" },
			// 2
			{ "difference between simplified and traditional" },
			{ "The main difference between them is the spelling- how a character is structured by strokes. Traditional Chinese characters are way complicated. e.g. 國 to 国 (nation)",
					"There is no difference with regards to the grammar and meaning",
					"They are used in different regions. the simplified Chinese characters are used in the mainland of China while the traditional Chinese characters are used in Taiwan and HK" },
			// 3
			{ "difficult" },
			{ "Chinese's spelling is a little difficult with people whose mother language is not Han character, but compare to Vietnamese, their pronounce is very similar" },
			// 4
			{ "document material" },
			{ "You can use set of 6 books compiled by 杨寄洲",
					"You can watch on Youtobe, there are a lot of free courses" },
			// 5
			{ "download" }, { "You can search on Google, it's very easy to find out" },
			// 6
			{ "benefit" },
			{ "Mandarin is spoken by almost one billion people in many areas on the world",
					"Develop your creative thinking skills" },
			// 7
			{ "easy way learn speak chinese" },
			{ "make yourself familiar with sounds of Mandarin",
					"Start by watching Chinese movies, listening to Chinese radio or podcast shows" },
			// 8
			{ "forgot quickly" }, { "Don't worry, every one meet that, just revise every day" },
			// 9
			{ "fluent effective" },
			{ "Take the decision to speak Chinese whenever possible, don’t feel shy",
					"The more you speak Chinese, the better you’ll get at it" },
			// 10
			{ "necessary stay live come in china" },
			{ "Of course, not. If you are living in Mainland China, surely it helps. However, you can learn Chinese in every where. You can join a private classroom course or chat with Chinese people on Internet" },
			// 11
			{ "fun" },
			{ "Watch Chinese movies", "You can also try singing Chinese songs in a karaoke",
					"You can also play Chinese vocabulary-building games to speed up learning." },
			// 12
			{ "carrer job" },
			{ "You can become Chinese Interpreter, Chinese Language Teacher", "You can also become a businessperson" },
			// 13
			{ "long take" },
			{ "It's difficult to say about that. Learning language have to take a lot of time, day after day. In most case, it's take one month for the first HSK level, two month, four month, one year, two years and four years for the next ones" },
			// 14
			{ "which dialect should learn" }, { "Mandarin is more popular, but Cantonese is also a not bad selection" },
			// 15
			{ "Mandarin" }, { "Mandarin is mainly speaked in Mainland China, Taiwan" },
			// 16
			{ "Cantonese" }, { "Cantonese is mainly speaked in HongKong" },
			// 17
			{ "simplified" }, { "Simplified Chinese is mainly used in Mainland China today" },
			// 18
			{ "traditional" }, { "Traditional Chinese is mainly used in Taiwan, HongKong, Singapore today" },
			//
			// { "xxxxxxxxxxxxxxxxxxxx" }, { "xxxxxxxxxxxxxxxxx" },
			//
			// { "xxxxxxxxxxxxxxxxxxxx" }, { "xxxxxxxxxxxxxxxxx" },
			//
			// { "xxxxxxxxxxxxxxxxxxxx" }, { "xxxxxxxxxxxxxxxxx" },
			//

			{ "Sorry this question has not answer available", "Sorry I cannot get that",
					"Please restructure the syntax", "Sorry, I could not understand your meaning" } };

	public String[][] context = {
			// if input contains these word, then answers the next sentence in max match
			// group
			{ "this", "that", "else" },
			// if next sentence is not available
			{ "Sorry, I forgot the last question", "I didn't remember what you asked me before" } };
}
