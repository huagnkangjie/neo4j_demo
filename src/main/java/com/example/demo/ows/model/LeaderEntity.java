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
public class LeaderEntity {

     @Id
     @GeneratedValue
     private Long id;

     /**
      * 领导班子名称
      */
     private String name;

     @Relationship(type = "领导班子", direction = Relationship.OUTGOING)
     public Set<OrgEntity> org;

     public void addOrg(OrgEntity orgEntity) {
          if (org == null) {
               org = new HashSet<>();
          }
          org.add(orgEntity);
     }


}
