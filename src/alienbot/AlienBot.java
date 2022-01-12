package alienbot;

import java.io.IOException;
import java.lang.Math;
import java.util.StringTokenizer;

public class AlienBot {

	//the difference between input and pattern
	int distance;
	//pattern that match with input in highest rate
	int maxMatchGroup;
	//the last input
	String last="";
	//the next sentence will be returned
	int next = 0;

	//pattern
	String[][] chatBot;
	//context
	String[][] context;
	

	public AlienBot() {
		Chat chat = new Chat();
		chatBot = chat.chat;
		context = chat.context;
	}

	public String analizeEnterTxt(String uText) throws IOException {
		if (uText.equals(""))
			return "";
		//the answer after analyze
		String answers = "";
		//reduce the noisy
		uText = trimUseless(uText.trim());
		// group: pattern in database
		int group = 0;
		// the score that user text match with a text in database
		int maxMatchScore = 0;
		// the max distance between user text with database's text
		int maxMatchDistance = Integer.MAX_VALUE;
		// the group in database chosen to answer user text
		// -1 is default group that respond for the unclear phases
		uText=uText.toLowerCase();

		if (containContext(uText)||last.equals(uText)) {
			if (maxMatchGroup > 0) {
				if (next + 1 < chatBot[maxMatchGroup * 2 + 1].length) {
					next++;
					return chatBot[maxMatchGroup * 2 + 1][next];
				}
			int r = (int) Math.floor(Math.random() * context[1].length);
			return context[1][r];
			}
		}

		next = 0;
		maxMatchGroup = -1;
		while (group * 2 < chatBot.length - 1) {
			int matchScore = howManyLetter(chatBot[group * 2], uText);
			if (maxMatchScore < matchScore) {
				maxMatchScore = matchScore;
				maxMatchGroup = group;
				maxMatchDistance = distance;
			} else if (maxMatchScore == matchScore) {
				if ((maxMatchDistance > distance) && (maxMatchScore > 0)) {
					maxMatchScore = matchScore;
					maxMatchGroup = group;
					maxMatchDistance = distance;
				}
			}
			group++;
		}

		// if (maxMatchGroup >= 0) {
		// int r = (int) Math.floor(Math.random() * chatBot[maxMatchGroup * 2 +
		// 1].length);
		// answers = chatBot[maxMatchGroup * 2 + 1][r];
		// }
		if (maxMatchGroup >= 0) {
			answers = chatBot[maxMatchGroup * 2 + 1][0];
		}
		if (maxMatchGroup < 0) {
			int r = (int) Math.floor(Math.random() * chatBot[chatBot.length - 1].length);
			answers = chatBot[chatBot.length - 1][r];
		}
		last=uText;
		return answers;
	}

	private boolean containContext(String input) {
		for (int i = 0; i < context[0].length; i++) {
			if (input.contains(context[0][i]))
				return true;
		}
		return false;
	}

	// private void saveToAnswers(String say) {
	// printWriter.println(say);
	// printWriter.flush();
	// }

	private String trimUseless(String needTrimed) {
		String useless = "is am are he she i a an the do does";
		String trimed = "";
		StringTokenizer token = new StringTokenizer(needTrimed, " :");
		while (token.hasMoreTokens()) {
			String consider = token.nextToken();
			if (!useless.contains(consider)) {
				trimed += " " + consider;
			}
		}
		return trimed;
	}

	public int howManyLetter(String[] data, String TextIn) {
		String word;
		int matchScore = 0;
		for (int i = 0; i < data.length; i++) {
			StringTokenizer tokenText = new StringTokenizer(data[i], " :");
			int matchPerData = 0;
			while (tokenText.hasMoreTokens()) {
				word = tokenText.nextToken();
				if (TextIn.contains(word))
					matchPerData++;
			}
			if (matchScore < matchPerData) {
				matchScore = matchPerData;
				distance = getDistance(TextIn, data[i]);
			}
		}
		return matchScore;
	}

	public static int getDistance(String sequenceX, String sequenceY) {
		int a = 0;
		for (int x = 0; x < sequenceX.length(); x++) {
			for (int y = 0; y < sequenceY.length(); y++) {
				if (sequenceX.charAt(x) == sequenceY.charAt(y)) {
					a += 0;
				} else if (sequenceX.charAt(x) != sequenceY.charAt(y)) {
					a += 1;
				}
			}
		}
		return a;
	}

}