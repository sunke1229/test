package com.tencent.examples.demo.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "t_book")
public class Book implements Serializable{

    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 30, unique = true)
    private String name;

    @Column(name = "book_num")
    private Integer num;
}
