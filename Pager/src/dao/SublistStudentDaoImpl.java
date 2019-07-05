package dao;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Pager;
import model.Student;
import until.Constant;
import until.JdbcUtil;


public class SublistStudentDaoImpl implements StudentDao {

	@Override
	public Pager<Student> findStudent(Student searchModel, int pageNum,
			int pageSize) {
		List<Student> allStudenList = getAllStudent(searchModel);

		Pager<Student> pager = new Pager<Student>(pageNum, pageSize,
				allStudenList);
		
		return pager;
	}

	/**
	 * 模仿获取所有数据
	 * 
	 * @param searchModel
	 *            查询参数
	 * @return 查询结果
	 */
	private static List<Student> getAllStudent(Student searchModel) {
		ArrayList<Student> result = new ArrayList<Student>();
		ArrayList<Object> paramList = new ArrayList<Object>();
		
		StringBuilder sql = new StringBuilder( "select * from t_student where 1=1");
		
		String stuName = searchModel.getStuName();
		int gender = searchModel.getGender();
		
		if(stuName!=null && stuName.equals("")) {
			sql.append(" and stu_name like ?");
			paramList.add("%"+stuName+"%");
		}
		
		if (gender == Constant.GENDER_FEMALE || gender == Constant.GENDER_MALE) {
			sql.append(" and gender = ?");
			paramList.add(gender);
		}
		
		//查询数据库
		JdbcUtil db = null;
		try {
			db = new JdbcUtil();
			db.getConnection();
			result = db.findResult(sql.toString(), paramList);
			
			
		}catch(Exception e){
			
		}
		
		
		return result; 
	}

	public static void main(String[] args) {
		Student s = new Student();
		s.setGender(1);
		s.setStuName("龙");
		
		List<Student> lst = getAllStudent(s);
		for (Student s1 : lst) {
			System.out.println(s1);
		}
	}
}
