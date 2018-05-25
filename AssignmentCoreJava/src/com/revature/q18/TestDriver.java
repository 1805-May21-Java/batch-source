package com.revature.q18;

public class TestDriver {
	public static void main(String[] args) {
		StringPlayerConcrete player = new StringPlayerConcrete();
		System.out.println(player.hasUppercase("zd,bjljkKJACN klnvesns"));
		System.out.println(player.hasUppercase("svljbzljdrblajbniiupaw"));
		System.out.println(player.makeUppercase("mvlkMLKNLRm//sevnsOINVION"));
		System.out.println(player.makeUppercase("knneg.s/eg8es9gkjnvs/lvek"));
		System.out.println(player.turnToInteger("sekvlslkj899see.v"));
		System.out.println(player.turnToInteger("0098"));
	}
}
