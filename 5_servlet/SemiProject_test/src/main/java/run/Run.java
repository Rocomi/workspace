package run;

import com.kh.wonPick.controller.MemberController;

public class Run {

	public static void main(String[] args) {
		
		int m = new MemberController().logIn("Rocomi", "1234");
		System.out.println(m);
	}

}
