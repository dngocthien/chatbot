package alienbot;

public class Chat {

	public Chat() {
	}

	// Training data
	public String[][] chat = { { "hi", "hello", "hey", "good", "how are you" }, { "How can I help you" },
			//
			{ "much cost credit", "tuition fee" }, { "18$ per credit" },
			//
			{ "much cost term", "how much it cost each per year" }, { "about 180$ each term" },
			//
			{ "what's you can do" }, { "I answer your questions about Nong Lam university enrollment" },
			//
			{ "what's java web developer" }, { "He make websites" },
			//
			{ "developer" }, { "He make websites, network admin or others. The job very open for developer" },
			//
			{ "what's your name" }, { "I am Alien Bot" },
			//
			{ "how many credit per term" }, { "You learn 15 - 25 credit a term" },
			//
			{ "how many credit per year" }, { "You learn about 40 credit" },
			//
			{ "how many main major" },
			{ "NLU's IT falcuty diveded into 3 main major: Network, Software Engineering and Information System" },
			//
			{ "what to will learn", "subject title", "tutorial course" },
			{ "There are a lot of subject like Artificial Intelligent, Web programming",
					"Data Mining, Network programming,..." },
			//
			{ "what will learn if choose network" },
			{ "You will learn Network, Network Programming, Network Administrator, Network security,..." },
			//
			{ "what will learn if choose software engineering" },
			{ "You will learn Data Warehouse, Quality Assurance and Software Testing Software Engineering Project,... " },
			//
			{ "what will learn if choose information system" },
			{ "You will learn Database System Management, Ecommerce, Information System Security,..." },
			//
			{ "target goal" }, { "Come to us to become one of the best Java developer in Vietnam" },
			//
			{ "job", "what to do after graduation" },
			{ "You can become a Java web developer, data analist",
					"You can also do a lot of other works, IT can apply for many jobs" },
			//
			{ "average class size", "how many student in class" },
			{ "there are about 80 students in a theory class and 40 students in a lab class" },
			//
			{ "allowed choose roommate", "how pair roommate" }, { "Student can choose their roommate" },
			//
			{ "student have opportunity to learn abroad" },
			{ "Yes, some students have this opportunity to learn or work abroad after graduation" },
			//
			{ "many class take one time", "many subject learn term" }, { "student take about 4 - 6 subjects a term" },
			//
			{ "safe", "security" },
			{ "The protection is in building period, however it is safe enough for student in campus" },
			//
			{ "club" }, { "There are a lot of clubs in school like green Autumn, Social Activity,..." },
			//
			{ "health service" }, { "Student must enroll Health Ensurance" },
			//
			{ "training", "internship internship program" },
			{ "There are a lot of companies suggest for students in the thirdth or fourth year" },
			//
			{ "score 2017" }, { "20" },
			//
			{ "score 2018" }, { "About 21" },
			//
			{ "passed with 21 point admission rate" }, { "Admission rate is about 50%" },
			//
			{ "what is java" }, { "Java is a programming language" },
			//
			{ "can you tell me all about information technology falcuty" },
			{ "My falcuty concentrate on Java basic to develop software" },
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
