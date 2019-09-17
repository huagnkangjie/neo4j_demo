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
public class UnitEntity {

     @Id
     @GeneratedValue
     private Long id;

     private String name;

     @Relationship(type = "直属", direction = Relationship.OUTGOING)
     public Set<TreeEntity> tree;

     public void addTree(TreeEntity treeEntity) {
          if (tree == null) {
               tree = new HashSet<>();
          }
          tree.add(treeEntity);
     }


}
