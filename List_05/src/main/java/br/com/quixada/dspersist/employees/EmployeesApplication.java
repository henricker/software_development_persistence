package br.com.quixada.dspersist.employees;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.quixada.dspersist.employees.main.ui.tui.MainTUI;

@SpringBootApplication
public class EmployeesApplication implements CommandLineRunner {

	@Autowired
	private MainTUI mainTUI;
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		mainTUI.run(scanner);
	}

}
