package com.aegis.crmsystem.models;

import com.aegis.crmsystem.domain.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "files")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class File extends BaseEntity{

    @JsonView(Views.Message.class)
    @Column(name = "file_name")
    private String fileName;

    @JsonView(Views.Message.class)
    @Column(name = "file_path")
    private String filePath;
}
