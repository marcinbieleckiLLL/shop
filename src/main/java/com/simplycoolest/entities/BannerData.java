package com.simplycoolest.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Marcin on 28.02.2018.
 */
@Entity
@Table(name = "banner")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BannerData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="banner_id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="data")
    private String data;
}
