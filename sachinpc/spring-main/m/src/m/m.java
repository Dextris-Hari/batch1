package m;

public class m {
	public static void main(String[] args) {
		java.lang.String m = "abc";
		java.lang.String n = "bc";
		java.lang.String dup = "";
		for (int i = 0; i < m.length(); i++) {
			for (int j = 0; j < n.length(); j++) {

				if (m.charAt(i) == n.charAt(j)) {

					dup += m.charAt(i);
				}
			}
		}
		
		for (int k = 0; k < dup.length(); k++) {
			java.lang.String rev = dup.charAt(k) + "";
			m = m.replace(rev, "");

		}
		System.out.println(m);
	}

}
