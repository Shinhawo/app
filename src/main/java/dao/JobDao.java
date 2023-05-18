package dao;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.JobName;

import util.DaoHelper;
import vo.Job;

public class JobDao {

	/**
	 * 모든 직종정보를 조회해서 반환한다.
	 * @return 전체 직종목록
	 */
	public List<Job> getJobs(){
		return DaoHelper.selectList("jobDao.getJobs", rs -> {
			Job job = new Job();
			job.setId(rs.getString("job_id"));
			job.setTitle(rs.getString("job_title"));
			job.setMinSalary(rs.getInt("min_salary"));
			job.setMaxSalary(rs.getInt("max_salary"));
			
			return job;
		});
	}
	
	/**
	 * 신규 직종정보를 전달받아서 데이터베이스 테이블에 저장시킨다.
	 * @param job 신규 직종 정보
	 */
//	jobDao.insertJob
	public void insertJob(Job job) {
		DaoHelper.update("jobDao.insertJob", job.getId(), job.getTitle(), job.getMinSalary(), job.getMaxSalary());
	}
	

}
