package com.example.demo.ows.model;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

/**
 * @author huang_kangjie
 * @date 2019-09-16 17:15
 * @since 3.0.0
 **/
@Data
@NodeEntity
public class UserEntity {

     @Id
     @GeneratedValue
     private Long id;

     private String name;

     /**
      * 人员类型：普通、领导
      */
     private String type;

     @Relationship(type = "挂靠", direction = Relationship.OUTGOING)
     public Set<OrgEntity> org;

     public void addOrg(OrgEntity orgEntity) {
          if (org == null) {
               org = new HashSet<>();
          }
          org.add(orgEntity);
     }

     @Relationship(type = "领导班子成员", direction = Relationship.OUTGOING)
     public Set<OrgEntity> leader;

     public void addLeader(OrgEntity orgEntity) {
          if (leader == null) {
               leader = new HashSet<>();
          }
          leader.add(orgEntity);
     }

     @Relationship(type = "71书院", direction = Relationship.OUTGOING)
     public Set<Study71Entity> study71;

     public void addStudy71(Study71Entity study71Entity) {
          if (study71 == null) {
               study71 = new HashSet<>();
          }
          study71.add(study71Entity);
     }

     @Relationship(type = "积分购物", direction = Relationship.OUTGOING)
     public Set<ScoreEntity> scoreShoping;

     public void addScoreShoping(ScoreEntity scoreEntity) {
          if (scoreShoping == null) {
               scoreShoping = new HashSet<>();
          }
          scoreShoping.add(scoreEntity);
     }

     @Relationship(type = "参加互动", direction = Relationship.OUTGOING)
     public Set<ActivityEntity> activity;

     public void addActivity(ActivityEntity activityEntity) {
          if (activity == null) {
               activity = new HashSet<>();
          }
          activity.add(activityEntity);
     }

     @Relationship(type = "上级", direction = Relationship.OUTGOING)
     public Set<UserEntity> userUp;

     public void addUserUp(UserEntity userEntity) {
          if (userUp == null) {
               userUp = new HashSet<>();
          }
          userUp.add(userEntity);
     }

     @Relationship(type = "主持会议", direction = Relationship.OUTGOING)
     public Set<MeetingEntity> meetingUp;

     public void addMeetingUp(MeetingEntity meetingEntity) {
          if (meetingUp == null) {
               meetingUp = new HashSet<>();
          }
          meetingUp.add(meetingEntity);
     }

     @Relationship(type = "参加会议", direction = Relationship.OUTGOING)
     public Set<MeetingEntity> meetingDown;

     public void addMeetingDown(MeetingEntity meetingEntity) {
          if (meetingDown == null) {
               meetingDown = new HashSet<>();
          }
          meetingDown.add(meetingEntity);
     }

}
