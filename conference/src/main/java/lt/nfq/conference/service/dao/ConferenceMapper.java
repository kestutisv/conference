package lt.nfq.conference.service.dao;

import java.util.Date;
import java.util.List;

import lt.nfq.conference.domain.Conference;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface ConferenceMapper {

    @Select("SELECT * FROM conference WHERE id=#{id}")
    public Conference getConference(@Param("id") int id);

    @Select("SELECT * FROM conference")
    public List<Conference> getConferences();
    
    @Select("SELECT conferenceCategoryId FROM conferenceCategories")
    public List<Integer> getConferencesCategories();

//    @Select("<script>SELECT * FROM conference JOIN conferenceCategories ON conference.id=conferenceCategories.conferenceId WHERE conferenceCategoryId IN"
//    		+ "<iterate open=\"(\" close=\")\" conjunction=\",\">"
//			+ "#[]#"
//			+ "</iterate> AND startDate >= #{start} AND startDate <= #{end} AND endDate <= #{end} AND endDate > #{start}</script>")
//    public List<Conference> getConferencesByDates(@Param("start") Date start, @Param("end") Date end, @Param("tags") Integer[] tags);
    @Select("SELECT * FROM conference WHERE startDate >= #{start} AND startDate <= #{end} AND endDate <= #{end} AND endDate > #{start}")
    public List<Conference> getConferencesByDates(@Param("start") Date start, @Param("end") Date end);
    //http://stackoverflow.com/questions/1637825/how-to-use-an-in-clause-in-ibatis
    //http://stackoverflow.com/questions/3428742/how-to-use-annotations-with-ibatis-mybatis-for-an-in-query
    //@Select("<script>SELECT * FROM conference JOIN conferenceCategories ON conference.id=conferenceCategories.conferenceId WHERE conferenceCategoryId IN (#{tags, typeHandler=lt.nfq.conference.helper.MyHandler}) AND startDate >= #{start} AND startDate <= #{end} AND endDate <= #{end} AND endDate > #{start}")
    //public List<Conference> getConferencesByDates(@Param("start") Date start, @Param("end") Date end, @Param("tags") Integer[] tags) throws SQLException;
    
    @Options(flushCache=true)
    @Update("UPDATE conference set name = #{name}, startDate = #{startDate}, endDate = #{endDate}, description = #{description}, location = #{location} WHERE id=#{id}")
    public int updateConference(Conference conference);

    @Options(flushCache=true)
    @Insert("INSERT INTO conference (name, startDate, endDate, description, location) VALUES (#{name}, #{startDate}, #{endDate}, #{description}, #{location})")
    @SelectKey(statement="CALL IDENTITY()", keyProperty="id", before=false, resultType=int.class)
    public int insertConference(Conference conference);
    
    @Insert("INSERT INTO conferenceCategories (conferenceId, conferenceCategoryId) VALUES (#{conferenceId}, #{conferenceCategoryId})")
    public int insertConferenceCategories(@Param("conferenceId") int conferenceId, @Param("conferenceCategoryId") int conferenceCategoryId);
    
}
