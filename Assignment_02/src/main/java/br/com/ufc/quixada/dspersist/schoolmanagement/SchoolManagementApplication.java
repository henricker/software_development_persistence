package br.com.ufc.quixada.dspersist.schoolmanagement;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.ufc.quixada.dspersist.schoolmanagement.exceptions.BusinessException;
import br.com.ufc.quixada.dspersist.schoolmanagement.exceptions.ServerException;
import br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.GenericTUI;
import br.com.ufc.quixada.dspersist.schoolmanagement.ui.tui.util.TuiUtil;

@SpringBootApplication
public class SchoolManagementApplication implements CommandLineRunner {

	@Autowired
	private GenericTUI ui;

	public static void main(String[] args) {
		SpringApplication.run(SchoolManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception { 
		Scanner scanner = new Scanner(System.in);
		Boolean keepRunning = true;
		while(Boolean.TRUE.equals(keepRunning)) {
			try {
				this.ui.setScanner(scanner).run();
			}catch(BusinessException e) {
        TuiUtil.clearScreen();
        System.out.println(e.showMessage());
      } catch(Exception e) {
        TuiUtil.clearScreen();
        System.out.println(new ServerException().showMessage());
      } finally {
        System.out.println("Ainda deseja continuar? 1 - sim, 0 - não");
        Integer keep = scanner.nextInt();
        if(keep == 1) {
          run();
        }
        keepRunning = false;
      }

			if(Boolean.FALSE.equals(keepRunning))
				break;

		}
		scanner.close();
	}

}
