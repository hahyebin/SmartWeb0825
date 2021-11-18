package batch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import dao.bBoardDao;
import dto.bBoard;

public class Adminjob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
	
		// bBoard테이블에서 고객 질문 받아오기
		List<bBoard> list = bBoardDao.getInstance().AdminList();
		
		// list를 파일로 만들기
		File file = new File("Admin.txt");
		try (BufferedWriter bw = new BufferedWriter( new FileWriter(file))) {    // try-catch resource => close() 생략 가능
			for(bBoard board : list) {
				bw.write(board.getIdx()+",");
				bw.write(board.getTitle()+",");
				bw.write(board.getWriter()+",");
				bw.write(board.getContent()+",");
				bw.write(board.getReadCount()+",");
				bw.write(board.getRegister()+"\n");
				
			}
			bw.close();
			System.out.println("Admin.txt 파일생성완료");
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	}

}
