package com.codeclan.example.files_and_folders.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "files")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "file_extension")
    private String fileExtension;

    @Column(name = "size")
    private int size;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "folder_id", nullable = false)
    private Folder folder;

    public File(String name, String fileExtension, int size, Folder folder) {
        this.name = name;
        this.fileExtension = fileExtension;
        this.size = size;
        this.folder = folder;
    }

    public File() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

}
