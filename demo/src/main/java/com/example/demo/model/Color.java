package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
@Table(name = "COLORS")
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME_JA", nullable = false, unique = true)
    private String nameJa;

    @Column(name = "NAME_EN", nullable = false, unique = true)
    private String nameEn;

    @Column(name = "CREATED_AT")
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    // OnetoManyは関係データベースにおいてjavaオブジェクトでRDBを表すときに使用する
    // mappedByはVegetableオブジェクト内のcolorとColorを紐づける
    // mappedByは連携関係のオーナーを選択する
    // → 1対多の1側が多の中の自身のFKを管理すること
    // fetchはfetch戦略を決める、sqlでのデータ取り出し方
    // cascadeはpersistenceの遷移機能,、rdbなどで関連したデータテーブルで片方が削除されたらもう片方も削除するようにしたりする
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "color", cascade = CascadeType.ALL, orphanRemoval = true)
    // 逆に参照するってこと？color一つに対して(例えば、赤)vegetableは複数colorを持つ(赤に設定されたレコードは複数)、その逆参照って感じ？
    @JsonBackReference
    // このリストはVegetableがColorを参照するためのもの(こっち側でどのVegetable自身(赤のColorオブジェクト等)を持っているかを把握するためのもの)
    private List<Vegetable> vegetableList;

}
