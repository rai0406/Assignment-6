package mobile.dao;

import java.util.List;

import mobile.pojo.Mobile;


public interface MobileDAO {
	
	Mobile getMobileById(int id);

	List<Mobile> getAllMobiles();

	boolean deleteMobile(Mobile mob);

	boolean updateMobile(Mobile mob);

	boolean createMobile(Mobile mob);

}
