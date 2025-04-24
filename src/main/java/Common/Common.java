package Common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sun.misc.*;
public class Common {

	public static String getPasswordHash(final String password) {

		MessageDigest md = null;

		try {

			md = MessageDigest.getInstance("SHA");

			md.update(password.getBytes("UTF-8"));

		} catch (final NoSuchAlgorithmException e) {

		} catch (final UnsupportedEncodingException e) {

		}



		final byte rawBytes[] = md.digest();

//		final String hash = new BASE64Encoder().encode(rawBytes);

//		return hash;

		return password;

	}



	/**

	 * @param followupdate

	 * @return

	 */

	public static String getDayFromDate(Date date) {

		final Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);

		System.out.println(calendar.getTime());

		final int year = calendar.get(Calendar.YEAR);

		final int month = calendar.get(Calendar.MONTH) + 1;

		final int day = calendar.get(Calendar.DAY_OF_MONTH);



		final String dateString = String.format("%d-%d-%d", year, month, day);

		Date date1 = null;

		try {

			date1 = new SimpleDateFormat("yyyy-M-d").parse(dateString);

		} catch (final ParseException e) {

			e.printStackTrace();

		}



		// Then get the day of week from the Date based on specific locale.

		final String dayOfWeek = new SimpleDateFormat("EEEE", Locale.getDefault()).format(date1);

		return dayOfWeek;

	}



	/**

	 * @param sessiononefromtime

	 * @param sessiononetotime

	 * @param appointmentduration

	 * @return

	 */

	public static int getTimeSlotsBetweenTime(final String fromtime, final String totime, final Integer duration) {

		final SimpleDateFormat df = new SimpleDateFormat("HH:mm");

		Date d = null, d1 = null;

		try {

			d = df.parse(fromtime);

			d1 = df.parse(totime);

		} catch (final ParseException e) {

			e.printStackTrace();

		}

		int count = 0;

		final Calendar cal = Calendar.getInstance();

		final Calendar cal1 = Calendar.getInstance();

		cal.setTime(d);

		cal1.setTime(d1);

		while (cal.getTime().before(cal1.getTime())) {

			cal.add(Calendar.MINUTE, duration);

			count++;

		}



		return count;

	}



	public static Date getDateWithoutTime(final Date date) {

		final Calendar cal = Calendar.getInstance();

		cal.setTime(date);

		cal.set(Calendar.HOUR_OF_DAY, 0);

		cal.set(Calendar.MINUTE, 0);

		cal.set(Calendar.SECOND, 0);

		cal.set(Calendar.MILLISECOND, 0);

		return cal.getTime();

	}



	/**

	 * @param i

	 * @return

	 */

	public static String getDayName(int month) {

		final Map mpMonth = new HashMap();



		mpMonth.put(1, "Sunday");

		mpMonth.put(2, "Monday");

		mpMonth.put(3, "Tuesday");

		mpMonth.put(4, "Wednesday");

		mpMonth.put(5, "Thursday");

		mpMonth.put(6, "Friday");

		mpMonth.put(7, "Saturday");

		return mpMonth.get(month).toString();

	}



	/**

	 * @param i

	 * @param j

	 * @param k

	 * @return

	 */

	public static int getAge(final int year, final int month, final int day) {

		// set up date of birth

		final Calendar calDOB = Calendar.getInstance();

		calDOB.set(year, month, day);

		// setup calNow as today.

		final Calendar calNow = Calendar.getInstance();

		calNow.setTime(new java.util.Date());

		// calculate age in years.

		int ageYr = calNow.get(Calendar.YEAR) - calDOB.get(Calendar.YEAR);

		// calculate additional age in months, possibly adjust years.

		final int ageMo = calNow.get(Calendar.MONTH) - calDOB.get(Calendar.MONTH);

		if (ageMo < 0) {

			// adjust years by subtracting one

			ageYr--;

		}

		return ageYr;

	}



	/**

	 * @param string

	 * @param string2

	 * @param serialno

	 * @return

	 */

	public static String generateNo(String callType, String code, Integer serialno) {

		String no = "";

		if (callType != null)

			no = callType;

		if (no.equals("")) {

			no = code;

		} else {

			no = no + "/" + code;

		}

		java.util.Calendar calendar = java.util.Calendar.getInstance();



		int year = calendar.get(java.util.Calendar.YEAR);



		int month = calendar.get(java.util.Calendar.MONTH);



		int mm = month + 1;

		String mon = mm + "";

		String yy = year + "";

		if (mon.length() == 1) {

			mon = "0" + mon;

		}

		if (no.length() > 0) {

			no = no + "/" + mon + yy;

		} else {

			no = no + mon + yy;

		}

		if (serialno != null) {

			no = no + "/" + serialno;

		}

		return no;

	}



	public static String[] Split(String text, String delemeter) {

		java.util.List<String> parts = new java.util.ArrayList<String>();



		text += delemeter;



		for (int i = text.indexOf(delemeter), j = 0; i != -1;) {

			parts.add(text.substring(j, i));

			j = i + delemeter.length();

			i = text.indexOf(delemeter, j);

		}



		return parts.toArray(new String[0]);

	}



	public static class EmailOperation {

		public static Integer sendEmail(String USERNAME, String PASSWORD, String addressfrom, String replyto,

				String emailto, String emailsubject, String emailtext) {

//			SendGrid.Email email = null;

//			SendGrid client = new SendGrid(USERNAME, PASSWORD);

//			email = new SendGrid.Email();

//			email.addTo(emailto);

//			email.setFrom(addressfrom);

//			email.setSubject(emailsubject);

//			email.setReplyTo(replyto);

//			// email.setText(emailtext);

//			email.setHtml(emailtext);

//			try {

//				client.send(email);

//			} catch (SendGridException e) {

//

//				e.printStackTrace();

//			}

			return 1;

		}



		public static boolean validateEmail(final String email) {

			// Input the string for validation

			// String email = "xyz@.com";

			// Set the email pattern string

			final Pattern p = Pattern.compile(".+@.+\\.[a-z]+");



			// Match the given string with the pattern

			final Matcher m = p.matcher(email);



			// check whether match is found

			final boolean matchFound = m.matches();



			final StringTokenizer st = new StringTokenizer(email, ".");

			String lastToken = null;

			while (st.hasMoreTokens()) {

				lastToken = st.nextToken();

			}



			if (matchFound && (lastToken.length() >= 2) && ((email.length() - 1) != lastToken.length())) {



				// validate the country code

				return true;

			}



			/*

			 * if (matchFound) { // validate the country code return true; }

			 */

			else {

				return false;

			}

		}

	}
}
// }
