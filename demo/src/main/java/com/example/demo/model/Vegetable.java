package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Entity
@Data
@Table(name = "VEGETABLE")
public class Vegetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "COLOR_ID")
    private long colorId;

    @Column(name = "PRICE")
    private int price;

    @Column(name = "CREATED_AT")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @ManyToOne
    // colorのキーを参照したことでcolorのそのキーが登録先にされていないとvegetableも登録できないようになっている(RDBと同じロジックにできる)
    // joincolumnをやらないと@JoinTable戦略が基本戦略として使用され中間テーブルをつくってしまうようだ
    @JoinColumn(name = "COLOR_ID", insertable = false, updatable = false)
    private Color color;
}
