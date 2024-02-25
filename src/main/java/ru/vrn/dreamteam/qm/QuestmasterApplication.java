package ru.vrn.dreamteam.qm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuestmasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestmasterApplication.class, args);
	}

}

//docker run -itd -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=psgrspwd -p 5432:5432 -v /data:/var/lib/postgresql/data --name postgresql postgres
//171f97cfce2f6ac0bb5ca5e2c99dc395d9f95fbf40e5b4f249c90f38036a47c5
