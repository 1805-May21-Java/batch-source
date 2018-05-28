package com.revature;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class FireTheCannons {
	public static void fire() {
		ArrayList<String> tankList = new ArrayList<>();
		tankList.add("  $         			    \n"+ 
				" $$$     					\n"+ 
				"$	   .--._____,--	\n"+
				" $$$    .-='=='==-,		\n"+
				"    $	(O_o_o_o_o_O)		\n"+
				" $$$						\n"+
				"  $");
		tankList.add("  $         			    \n"+ 
				" $$$     					\n"+ 
				"$	   .--._____, --	\n"+
				" $$$    .-='=='==-,		\n"+
				"    $	(O_o_o_o_o_O)		\n"+
				" $$$						\n"+
				"  $");
		tankList.add("  $         			    \n"+ 
				" $$$     					\n"+ 
				"$	   .--._____,  --	\n"+
				" $$$    .-='=='==-,		\n"+
				"    $	(O_o_o_o_o_O)		\n"+
				" $$$						\n"+
				"  $");
		tankList.add("  $         			    \n"+ 
				" $$$     					\n"+ 
				"$	   .--._____,   --	\n"+
				" $$$    .-='=='==-,		\n"+
				"    $	(O_o_o_o_o_O)		\n"+
				" $$$						\n"+
				"  $");
		tankList.add("  $         			    \n"+ 
				" $$$     					\n"+ 
				"$	   .--._____,    --	\n"+
				" $$$    .-='=='==-,		\n"+
				"    $	(O_o_o_o_o_O)		\n"+
				" $$$						\n"+
				"  $");
		tankList.add("  $         			    \n"+ 
				" $$$     					\n"+ 
				"$	   .--._____,	\n"+
				" $$$    .-='=='==-,       --		\n"+
				"    $	(O_o_o_o_o_O)		\n"+
				" $$$						\n"+
				"  $");
		tankList.add("  $         			    \n"+ 
				" $$$     					\n"+ 
				"$	   .--._____,	\n"+
				" $$$    .-='=='==-,	   --	\n"+
				"    $	(O_o_o_o_o_O)		\n"+
				" $$$						\n"+
				"  $");
		tankList.add("  $         			    \n"+ 
				" $$$     					\n"+ 
				"$	   .--._____,	\n"+
				" $$$    .-='=='==-,         --		\n"+
				"    $	(O_o_o_o_o_O)		\n"+
				" $$$						\n"+
				"  $");
		tankList.add("  $         			    \n"+ 
				" $$$     					\n"+ 
				"$	   .--._____,	\n"+
				" $$$    .-='=='==-,	     --	\n"+
				"    $	(O_o_o_o_o_O)		\n"+
				" $$$						\n"+
				"  $");
		tankList.add("  $         			    \n"+ 
				" $$$     					\n"+ 
				"$	   .--._____,	\n"+
				" $$$    .-='=='==-,		\n"+
				"    $	(O_o_o_o_o_O)		--\n"+
				" $$$						\n"+
				"  $");
		tankList.add("  $         			    \n"+ 
				" $$$     					\n"+ 
				"$	   .--._____,	\n"+
				" $$$    .-='=='==-,		\n"+
				"    $	(O_o_o_o_o_O)		 --\n"+
				" $$$						\n"+
				"  $");
		tankList.add("  $         			    \n"+ 
				" $$$     					\n"+ 
				"$	   .--._____,	\n"+
				" $$$    .-='=='==-,		\n"+
				"    $	(O_o_o_o_o_O)		  --\n"+
				" $$$						\n"+
				"  $");
		tankList.add(
				"  $         			    \n"+ 
				" $$$     					\n"+ 
				"$	   .--._____,	\n"+
				" $$$    .-='=='==-,		\n"+
				"    $	(O_o_o_o_o_O)		  --\n"+
				" $$$						\n"+
				"  $");
		tankList.add(
				"  $                      (\\     .:\";'.:..\"      /)\n" + 
				" $$$                      (\\   (M^^.^~~:.'\").   /)\n" + 
				"$          .--._____,      (\\  .    .     . \\  /)  -\n" + 
				" $$$    .-='=='==-,         (\\| :. ~ ^  :. .|  /))\n" + 
				"    $	(O_o_o_o_o_O)         (\\- |  \\ /  |  /)  -\n" + 
				" $$$                          (\\  \\     /  /-\n" + 
				"  $                            (\\  \\   /  /");
		
		try {
			tankList.forEach(tank -> {
				System.out.println(tank);
				try {
					TimeUnit.MILLISECONDS.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
			TimeUnit.SECONDS.sleep(2);
			System.out.println("Money protected.");
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
