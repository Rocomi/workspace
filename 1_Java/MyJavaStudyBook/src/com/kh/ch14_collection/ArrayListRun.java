package com.kh.ch14_collection;

import java.util.ArrayList;

public class ArrayListRun {
	/*
	 * * 컬렉션 : 자료구조 개념이 내장되어 있는 클래스
	 * 			자바 기본적으로 제공되는 "자료구조" 담당 "프레임워크"
	 */
	public static void main(String[] args) {
		/*
		 * List<E> : 순서가 있고, 중복이 허용됨
		 */
		ArrayList list = new ArrayList(2);	// E--> Object
		
		System.out.println(list);		// 비어있는 상태
		
		System.out.println("-----------------------");
//		ArrayList list2 = new ArrayList(5);	// 5크기를 지정
//		System.out.println(list2);
		
		// 데이터 추가 : add(E e)
		list.add(new Music("하입보이", "뉴진스"));
		list.add(new Music("Believer", "Imagine Dragons"));
		list.add("끝");
		// => 크기 제약이 없음 : 지정된 크기보다 더 많은 데이터를 추가해도 가능! (오류x)
		// => 다양한 데이터 타입이 가능
		
		System.out.println(list);
		
		ArrayList<Music> mlist = new ArrayList<>();
		
		mlist.add(new Music("하입보이", "뉴진스"));
		mlist.add(new Music("Believer", "Imagine Dragons"));
//		mlist.add("끝");  ==> 타입을 Music으로 지정했기 때문에, 문자열 데이터는 추가 불가!
		
		for(Music m : mlist) {
			System.out.println(m);
		}
		for(int i =0; i<mlist.size(); i++) {
			System.out.println(mlist.get(i));
		}
		
		// 모두 지우고자 할 때 : clear()
		mlist.clear();
		
		// 리스트가 비어잇는지 확인하는 메소드 : isEmpty()
		System.out.println(mlist.isEmpty());
	}

}

class Music {
	private String title;
	private String artist;
	
	public Music(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}

	@Override
	public String toString() {
		return "Music [title=" + title + ", artist=" + artist + "]";
	}
	
	
}