package com.example.demo;

import com.example.demo.ows.model.ActivityEntity;
import com.example.demo.ows.model.MeetingEntity;
import com.example.demo.ows.model.OrgEntity;
import com.example.demo.ows.model.ScoreEntity;
import com.example.demo.ows.model.Study71Entity;
import com.example.demo.ows.model.TreeEntity;
import com.example.demo.ows.model.UnitEntity;
import com.example.demo.ows.model.UserEntity;
import com.example.demo.ows.repository.ActivityRepository;
import com.example.demo.ows.repository.LeaderRepository;
import com.example.demo.ows.repository.MeetingRepository;
import com.example.demo.ows.repository.OrgRepository;
import com.example.demo.ows.repository.ScoreRepository;
import com.example.demo.ows.repository.Study71Repository;
import com.example.demo.ows.repository.TreeRepository;
import com.example.demo.ows.repository.UnitRepository;
import com.example.demo.ows.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Neo4jDemoOwsApplicationTests {
    @Autowired
    TreeRepository treeRepository;
    @Autowired
    UnitRepository unitRepository;
    @Autowired
    OrgRepository orgRepository;
    @Autowired
    LeaderRepository leaderRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    MeetingRepository meetingRepository;
    @Autowired
    Study71Repository study71Repository;
    @Autowired
    ScoreRepository scoreRepository;
    @Autowired
    ActivityRepository activityRepository;

    @Test
    public void contextLoads() {}

    @Test
    public void testAddTree(){
        TreeEntity treeEntity = new TreeEntity();
        treeEntity.setType("主树");
        treeEntity.setName("组织树");
        this.treeRepository.save(treeEntity);
    }

    @Test
    public void testAddUnit(){
        UnitEntity unitEntity = new UnitEntity();
        unitEntity.setName("单位");
        TreeEntity treeEntity = this.treeRepository.findByName("组织树");
        if (treeEntity != null) {
            unitEntity.addTree(treeEntity);
        }
        this.unitRepository.save(unitEntity);
    }

    @Test
    public void testAddOrgUnit(){
        //挂在单位下的组织
        OrgEntity orgEntity1 = new OrgEntity();
        orgEntity1.setName("组织-挂单位");

        UnitEntity unitEntity = this.unitRepository.findByName("单位");
        if(unitEntity != null) {
            orgEntity1.addUnit(unitEntity);
        }
        this.orgRepository.save(orgEntity1);
    }

    @Test
    public void testAddOrgTree(){
        //挂在树下的组织
        OrgEntity orgEntity1 = new OrgEntity();
        orgEntity1.setName("组织-挂树");

        TreeEntity treeEntity = this.treeRepository.findByName("组织树");
        if(treeEntity != null) {
            orgEntity1.addTree(treeEntity);
        }

        this.orgRepository.save(orgEntity1);
    }

    //@Test
    //public void testAddLeader(){
    //    LeaderEntity leaderEntity = new LeaderEntity();
    //    leaderEntity.setName("领导班子");
    //    OrgEntity orgEntity = this.orgRepository.findByName("组织-挂单位");
    //    if(orgEntity != null) {
    //        leaderEntity.addOrg(orgEntity);
    //    }
    //    this.leaderRepository.save(leaderEntity);
    //}

    @Test
    public void testAddMeeting(){
        MeetingEntity meetingEntity = new MeetingEntity();
        meetingEntity.setName("三会一课");

        OrgEntity orgEntity = this.orgRepository.findByName("组织-挂单位");

        if(orgEntity != null) {
            meetingEntity.addOrg(orgEntity);
        }

        this.meetingRepository.save(meetingEntity);

    }

    @Test
    public void testAddStudy71(){

        Study71Entity study71Entity = new Study71Entity();
        study71Entity.setName("每日一课");

        this.study71Repository.save(study71Entity);

    }

    @Test
    public void testAddActivityVote(){

        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setName("投票");
        this.activityRepository.save(activityEntity);

    }

    @Test
    public void testAddActivityQuestion(){
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setName("问卷调查");
        this.activityRepository.save(activityEntity);
    }

    @Test
    public void testAddActivity1YuanJuan(){
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setName("一元捐");
        this.activityRepository.save(activityEntity);
    }

    @Test
    public void testAddActivityOffline(){
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setName("线下活动");
        this.activityRepository.save(activityEntity);
    }

    @Test
    public void testAddActivityGiveway(){
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setName("有奖竞答");
        this.activityRepository.save(activityEntity);
    }

    @Test
    public void testAddScoreShopping(){
        ScoreEntity scoreEntity = new ScoreEntity();
        scoreEntity.setName("积分换书");
        scoreEntity.setScore(500);

        this.scoreRepository.save(scoreEntity);

    }

    @Test
    public void testAddUserUp(){
        UserEntity user = new UserEntity();
        user.setName("用户上级");

        user = guakao(user);
        user = study(user);
        user = activity(user, "投票");

        MeetingEntity meetingEntity = this.meetingRepository.findByName("三会一课");
        if(meetingEntity != null) {
            user.addMeetingUp(meetingEntity);
        }
        //领导班子
        OrgEntity orgEntity = this.orgRepository.findByName("组织-挂单位");
        if(orgEntity != null) {
            user.addLeader(orgEntity);
        }

        this.userRepository.save(user);

    }

    @Test
    public void testAddUserDown(){

        UserEntity user = new UserEntity();
        user.setName("用户下级");

        user = guakao(user);
        user = study(user);
        user = activity(user, "问卷调查");
        user = activity(user, "有奖竞答");
        user = activity(user, "一元捐");
        user = activity(user, "线下活动");
        user = addUp(user);
        user = addScore(user);

        MeetingEntity meetingEntity = this.meetingRepository.findByName("三会一课");
        if(meetingEntity != null) {
            user.addMeetingDown(meetingEntity);
        }

        this.userRepository.save(user);

    }

    public UserEntity guakao(UserEntity userEntity){
        OrgEntity orgEntity = this.orgRepository.findByName("组织-挂单位");
        if(orgEntity != null) {
            userEntity.addOrg(orgEntity);
        }
        return userEntity;
    }

    public UserEntity study (UserEntity userEntity){
        Study71Entity study71Entity = this.study71Repository.findByName("每日一课");
        if(study71Entity != null) {
            userEntity.addStudy71(study71Entity);
        }
        return userEntity;
    }

    public UserEntity activity(UserEntity userEntity, String activityName){
        ActivityEntity activityEntity = this.activityRepository.findByName(activityName);
        if(activityEntity != null){
            userEntity.addActivity(activityEntity);
        }
        return userEntity;
    }

    public UserEntity addUp (UserEntity userEntity){
        UserEntity userUp = this.userRepository.findByName("用户上级");
        if(userUp != null) {
            userEntity.addUserUp(userUp);
        }
        return userEntity;
    }

    public UserEntity addScore (UserEntity userEntity){
        ScoreEntity scoreEntity = this.scoreRepository.findByName("积分换书");
        if(scoreEntity != null) {
            userEntity.addScoreShoping(scoreEntity);
        }
        return userEntity;
    }

    @Test
    public void testAddAll(){
        testAddTree();
        testAddUnit();
        testAddOrgUnit();
        testAddOrgTree();
        testAddMeeting();
        testAddStudy71();
        testAddActivityVote();
        testAddActivityQuestion();
        testAddActivity1YuanJuan();
        testAddActivityOffline();
        testAddActivityGiveway();
        testAddScoreShopping();
        testAddUserUp();
        testAddUserDown();
    }

    @Test
    public void deleteAll(){
        scoreRepository.deleteAll();
        treeRepository.deleteAll();
        unitRepository.deleteAll();
        orgRepository.deleteAll();
        leaderRepository.deleteAll();
        userRepository.deleteAll();
        meetingRepository.deleteAll();
        study71Repository.deleteAll();
        scoreRepository.deleteAll();
        activityRepository.deleteAll();
    }

}

