package chatbot;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.Math;
import java.util.StringTokenizer;

public class AlienBot_same_dis {

	PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(
			"C:\\Users\\Thien Dinh\\OneDrive\\eclipse_space\\AlienBot\\src\\text_processing\\questions_bot_cannot_answers.txt"),
			"utf-8"));

	int distance;

	String[][] chatBot = { { "hi", "hello", "hey" }, { "Hi", "Hello", "How can I help you" },
			//
			{ "much cost credit", "tuition fee" }, { "18$ per credit" },
			//
			{ "subject title", "tutorial course" },
			{ "There are a lot of subject like Artificial Intelligent, Data Mining, Network programming, Web programming,..." },
			//
			{ "target goal" }, { "Come to us to become one of the best Java developer in Vietnam" },
			//
			{ "job", "what to do after graduation" }, { "become a Java web developer, data analist" },
			//
			{ "much cost term" }, { "about 180$" },
			//
			{ "average class size" },
			{ "there are about 80 students in a theory class and 40 students in a lab class" },
			//
			{ "allowed choose roommate", "how pair roommate" }, { "Student can choose their roommate" },
			//
			{ "student have opportunity to learn abroad" },
			{ "Yes, some students have this opportunity to learn or work abroad after graduation" },
			//
			{ "many class take one time", "many subject learn term" },
			{ "student take about 4 - 6 subjects a term" },
			//
			{ "safe", "security" },
			{ "The protection is in building period, however it's safe enough for student in campus" },
			//
			{ "club" }, { "There are a lot of clubs in school like green Autumn, Social Activity,..." },
			//
			{ "health service" }, { "Student must enroll Health Ensurance" },
			//
			{ "training","internship internship program" }, { "There are a lot of companies suggest for students in the thirdth or fourth year" },
			//
			// { "xxxxxxxxxxxxxxxxxxxx" }, { "xxxxxxxxxxxxxxxxx" },
			//
			{ "Sorry this question's answer not available", "Sorry I can't get that",
					"Please restructure the syntax" } };

	public AlienBot_same_dis() throws IOException {
		analizeEnterTxt();
	}

	public void analizeEnterTxt() throws IOException {
		BufferedReader TexIn = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String uText = TexIn.readLine();
			if (uText.equals(""))
				continue;
			botSay("-->You:\t" + uText);
			uText.trim();
			uText = trimUseless(uText);
			// System.out.println("trimUseless: " + uText);
			int group = 0;
			int maxMatchScore = 0;
			int maxMatchDistance = Integer.MAX_VALUE;
			int maxMatchGroup = -1;
			while (group * 2 < chatBot.length - 1) {
				int matchScore = howManyLetter(chatBot[group * 2], uText.toLowerCase());
				// System.out.println("matchScore:" + matchScore);
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
			// System.out.println("maxMatchScore:" + maxMatchScore);

			// -----default--------------
			if (maxMatchGroup >= 0) {
				int r = (int) Math.floor(Math.random() * chatBot[maxMatchGroup * 2 + 1].length);
				botSay("\n-->Alien\t" + chatBot[maxMatchGroup * 2 + 1][r]);
			}
			if (maxMatchGroup < 0) {
				int r = (int) Math.floor(Math.random() * chatBot[chatBot.length - 1].length);
				botSay("\n-->Alien\t" + chatBot[chatBot.length - 1][r]);
				saveToAnswers(uText);
			}
			botSay("\n");
		}
	}

	private void saveToAnswers(String say) {
		printWriter.println(say);
		printWriter.flush();
	}

	private String trimUseless(String needTrimed) {
		String useless = "is am are he she i a an the how what do does";
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

	public void botSay(String s) {
		// txtChat.append("AI: " + s + "\n");
		System.out.println(s);
	}

	public int howManyLetter(String[] data, String TextIn) {
		String word;
		int matchScore = 0;
		for (int i = 0; i < data.length; i++) {
			StringTokenizer tokenText = new StringTokenizer(data[i], " :");
			int matchPerData = 0;
			while (tokenText.hasMoreTokens()) {
				word = tokenText.nextToken();
				// System.out.println("word: " + word);
				if (TextIn.contains(word))
					matchPerData++;
			}
			// matchScore = matchScore < matchPerData ? matchPerData : matchScore;
			if (matchScore < matchPerData) {
				matchScore = matchPerData;
				distance = getDistance(TextIn, data[i]);
			}
		}
		return matchScore;
	}

	public static int getDistance(String sequence1, String sequence2) {
		int a = 0;
		for (int x = 0; x < sequence1.length(); x++) {
			for (int y = 0; y < sequence2.length(); y++) {
				if (sequence1.charAt(x) == sequence2.charAt(y)) {
					a += 0;
				} else if (sequence1.charAt(x) != sequence2.charAt(y)) {
					a += 1;
				}
			}
		}
		return a;
	}
}