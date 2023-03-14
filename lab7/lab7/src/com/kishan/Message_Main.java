package com.kishan;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Message_Main {

	public static MessageService get1() {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		appContext.scan("com.kishan");
		appContext.refresh();
		MessageService messageService = (MessageService) appContext.getBean("MessageService");
		return messageService;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("1)Insert\n 2)Update \n3)Delete \n 4)Display \n 5)Exit \n");
			int ch= sc.nextInt();
			if(ch==1) {
				MessageService messageService=get1();
				System.out.println("Enter the id");
				int i= sc.nextInt();
				System.out.println("Enter the Name");
				String i1= sc.next();
				
				messageService.Save(i,i1);
			
			}
			else if(ch==2) {
				MessageService messageService=get1();
				System.out.println("Enter the id");
				int i= sc.nextInt();
				System.out.println("Enter the Name");
				String i1= sc.next();
				
				messageService.Update(i,i1);
			}
			else if(ch==3) {
				MessageService messageService=get1();
				System.out.println("Enter the id");
				int i= sc.nextInt();
				messageService.Delete(i);
			}
			else if(ch==4) {
				MessageService messageService=get1();

				List<Message> al = messageService.getMessages();
				for (Message m : al) {
					System.out.println(m.getMid() + " " + m.getMessage());
				}
				
			}
			else if(ch==5) {
				break;
			}
		}
		
		
		
	}
}