package chatbot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;

public class AlienBot_cases {

	BufferedReader TexIn;

	String[][] chatBot = {
			// standard greetings
			{ "hi", "hello", "hey" }, { "hi", "hello", "how can I help you" },
			// test
			{ "On average, how many people are in a class?" }, { "answers.." },
			// default
			{ "you're bad", "stop talking", "please restructure the syntax" } };

	String[][] verbs = { { "is", "'re" }, { "was", "'re" }, { "think", " think" }, { "s", "'re" }, { "'re", "'re" } };

	public static void main(String[] args) throws IOException {
		new AlienBot_cases();
	}

	public AlienBot_cases() throws IOException {
		analizeEnterTxt();
	}

	public void analizeEnterTxt() throws IOException {
		TexIn = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String uText = TexIn.readLine();
			if (uText.equals(""))
				continue;
			botSay("-->You:\t" + uText);
			uText.trim();
			while (uText.charAt(uText.length() - 1) == '!' || uText.charAt(uText.length() - 1) == '.'
					|| uText.charAt(uText.length() - 1) == '?') {
				uText = uText.substring(0, uText.length() - 1);
			}
			uText.trim();
			byte response = 0;
			/*
			 * 0:we're searching through chatBot[][] for matches 1:we didn't find anything
			 * 2:we did find something
			 */
			// -----check for matches----
			int j = 0;// which group we're checking
			while (response == 0) {
				if (inArray(uText.toLowerCase(), chatBot[j * 2])) {
					response = 2;
					int r = (int) Math.floor(Math.random() * chatBot[(j * 2) + 1].length);
					botSay("\n-->Michael\t" + chatBot[(j * 2) + 1][r]);
				}
				j++;
				if (j * 2 == chatBot.length - 1 && response == 0) {
					response = 1;
				}
			}

			// -----try counter----------
			if (response == 1) {
				String quoteWords[] = uText.split("[ ']");
				int c = counter(quoteWords);
				if (c != -1) {
					String ext = uText.split(verbs[c][0])[1];
					botSay("\n-->Michael:\tYou" + verbs[c][1] + ext);
					response = 2;
				}
			}
			// -----default--------------
			if (response == 1) {
				int r = (int) Math.floor(Math.random() * chatBot[chatBot.length - 1].length);
				botSay("\n-->Michael\t" + chatBot[chatBot.length - 1][r]);
			}
			botSay("\n");
		}
	}

	public void botSay(String s) {
		// txtChat.append("AI: " + s + "\n");
		System.out.println(s);
	}

	public boolean inArray(String in, String[] str) {
		boolean match = false;
		for (int i = 0; i < str.length; i++) {
			if (str[i].equals(in)) {
				match = true;
			}
		}
		return match;
	}

	public int counter(String str[]) {
		int verbID = -1;
		for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < verbs.length; j++) {
				if (str[i].equals(verbs[j][0])) {
					verbID = j;
				}
			}
		}
		return verbID;
	}
}