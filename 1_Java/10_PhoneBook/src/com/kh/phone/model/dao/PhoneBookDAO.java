package com.kh.phone.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kh.phone.model.vo.PhoneBook;

public class PhoneBookDAO {
	
	private PhoneBook[] pArr = new PhoneBook[1000];
	
	public void fileSave(PhoneBook[] pArr) {
		
		try (ObjectOutputStream oos = new ObjectOutputStream(
											new FileOutputStream("PhoneBook.txt"))){
			for(PhoneBook p : pArr) {
				if (p != null) {
					oos.writeObject(p);
				}else {
					break;
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public PhoneBook[] fileRead() {
		
		try(ObjectInputStream ois = new ObjectInputStream(
										new FileInputStream("PhoneBook.txt"))){
			int index = 0;
			while (true) {
				PhoneBook pb = (PhoneBook) ois.readObject();
				
				pArr[index++] = pb;
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return pArr;
	}

}