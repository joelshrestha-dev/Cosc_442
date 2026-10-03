
public class CollegeStudent {

	// This method helps decide if a college student should go
	// out or stay in and study for the night.
	// Decide whether a college student should go out tonight.
	public boolean goOut(int hoursStudied, int moneyInWallet,
			boolean friendsAround, String dayOfWeek) {

		final int REQUIRED_STUDY_HOURS = 3;
		final int REQUIRED_MONEY = 20;

		// Fridays are always okay.
		if (dayOfWeek.equals("Friday")) {
			return true;
		}

		// Otherwise, the student needs enough money
		// and either enough study time or friends around.
		if ((moneyInWallet >= REQUIRED_MONEY) &&
				((hoursStudied >= REQUIRED_STUDY_HOURS) || friendsAround)) {
			return true;
		}

		return false;
	}
}
